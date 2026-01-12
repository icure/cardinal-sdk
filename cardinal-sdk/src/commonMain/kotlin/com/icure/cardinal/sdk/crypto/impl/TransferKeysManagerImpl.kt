package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.TransferKeysManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.CandidateTransferKey
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.SelfVerifiedKeysSet
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.cardinal.sdk.utils.collections.DirectedGraph
import com.icure.cardinal.sdk.utils.collections.StronglyConnectedGraph
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class TransferKeysManagerImpl(
	private val encryptionKeysManager: UserEncryptionKeysManager,
	private val icureStorage: CardinalStorageFacade,
	private val cryptoService: CryptoService,
	private val exchangeDataManager: ExchangeDataManager,
	private val dataOwnerApi: DataOwnerApi,
) : TransferKeysManager {
	override suspend fun updateSelfTransferKeys() {
		if (encryptionKeysManager.delegatorActorId() != dataOwnerApi.getCurrentDataOwnerId()) return // Only update transfer keys if using the current data owner as delegator
		val self = dataOwnerApi.getCurrentDataOwnerStub()
		val newEdgesByTarget = getSuggestedTransferKeys(self.stub)
		if (newEdgesByTarget.isEmpty()) return
		val selfId = self.stub.id
		val verifiedFps = encryptionKeysManager.delegatorActorVerifiedKeys().map { it.pubSpkiHexString.fingerprintV1() }.toSet()
		val allVerifiedSourcesAndTarget = newEdgesByTarget.flatMap { x ->
			if (verifiedFps.contains(x.target.pubSpkiHexString.fingerprintV1())) {
				listOf(x.target.pubSpkiHexString) + x.sources
			} else {
				x.sources
			}
		}.toSet()
		val keysToUse = VerifiedRsaEncryptionKeysSet(cryptoService.loadEncryptionKeysForDataOwner(self.stub, allVerifiedSourcesAndTarget))
		val exchangeData = exchangeDataManager.getOrCreateEncryptionDataTo(
			null,
			EntityReferenceInGroup(selfId, null),
			false,
			false
		)
		// If the exchange data already existed ensure that it has all the necessary keys
		exchangeDataManager.base.updateExchangeDataWithDecryptedContent(
			exchangeData = exchangeData.exchangeData,
			newEncryptionKeys = keysToUse,
			delegatorSignatureKeys = null,
			unencryptedExchangeDataContent = exchangeData.unencryptedContent
        )
		val updatedTransferKeys = self.stub.transferKeys.toList().associate { (identifier, transferKeys) ->
			identifier.sliceIfNeeded() to transferKeys.toList().associate { (targetIdentifier, key) ->
				targetIdentifier.sliceIfNeeded() to key
			}.toMutableMap()
		}.toMutableMap()
		for (newEdges in newEdgesByTarget) {
			val encryptedTransferKey = encryptTransferKey(newEdges.target.key, exchangeData.unencryptedContent.exchangeKey)
			for (source in newEdges.sources) {
				val sourceTransferKeys = updatedTransferKeys.getOrPut(source.fingerprintV1().asAmbiguousIdentifier()) { mutableMapOf() }
				sourceTransferKeys[newEdges.target.pubSpkiHexString.fingerprintV1().asAmbiguousIdentifier()] = encryptedTransferKey
			}
		}
		dataOwnerApi.modifyDataOwnerStub(self.copy(stub = self.stub.copy(transferKeys = updatedTransferKeys)))
	}

	// encrypts a transfer key in pkcs8 format using an exchange key, returns the hex representation
	private suspend fun encryptTransferKey(
		transferKey: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
		exchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>
	): HexString {
		val exportedKey = cryptoService.rsa.exportPrivateKeyPkcs8(transferKey.private)
		return HexString(cryptoService.aes.encrypt(exportedKey, exchangeKey).toHexString())
	}

	/**
	 * Get the suggested transfer keys for a data owner, based on the currently available key, their verification status
	 * and the verified transfer keys.
	 * @param self the current data owner.
	 * @return the new verified transfer keys edges.
	 */
	suspend fun getSuggestedTransferKeys(
		self: CryptoActor,
	): List<CandidateTransferKey> {
		val currentTransferKeysGraph = transferKeysFpGraphOf(self)
		val verifiedKeysFpSet = (
			icureStorage.loadSelfVerifiedKeys(self.id).filter { it.value }.keys
				+ encryptionKeysManager.delegatorActorVerifiedKeys().map { it.pubSpkiHexString.fingerprintV1() }
		).toSet()
		if (verifiedKeysFpSet.isEmpty()) return emptyList()
		val fpToSpki = self.publicKeysSpki.associateBy { it.fingerprintV1() }
		// 1. Choose keys available in this device which should be reachable from all other verified keys
		val targetKeys = currentTransferKeysGraph.transferTargetKeys(self.id)
		return targetKeys.flatMap { targetKey ->
			// 2. Find groups which can't reach the existing target keys
			val candidatesFp = currentTransferKeysGraph.transferKeysCandidatesFp(targetKey.pubSpkiHexString.fingerprintV1())
			// 3. Keep only groups which contain at least a verified candidate
			val verifiedGroupCandidates = candidatesFp.filter { candidate ->
				currentTransferKeysGraph.acyclicLabelToGroup[candidate]!!.any { verifiedKeysFpSet.contains(it) }
			}
			val verifiedCandidatesSet = verifiedGroupCandidates.toSet()
			if (verifiedCandidatesSet.isEmpty()) return@flatMap emptyList()
			// 4. Drop all candidates which can already reach another candidate group: it is sufficient to create a transfer key from that group.
			val optimizedCandidates = verifiedGroupCandidates.filter { candidate ->
				ensureNonNull(currentTransferKeysGraph.reachSets[candidate]) {
					"Reach set not found for candidate $candidate in transfer keys graph"
				}.all { reachableNode -> !verifiedCandidatesSet.contains(reachableNode) }
			}
			ensure(optimizedCandidates.isNotEmpty()) { "Check failed: at least one candidate should survive optimization" }
			// 5. Transfer keys could also be faked: to make sure we are not giving access to unauthorised people we remap the candidates to a verified public
			// keys
			val verifiedOptimizedCandidates = optimizedCandidates.map { candidate ->
				ensureNonNull(
					currentTransferKeysGraph.acyclicLabelToGroup[candidate]?.find { verifiedKeysFpSet.contains(it) }
				) {
					"Check failed: optimized candidates groups should have at least a verified member"
				}
			}
			listOf(CandidateTransferKey(verifiedOptimizedCandidates.map { fpToSpki.getValue(it) }, targetKey))
		}
	}

	fun transferKeysFpGraphOf(dataOwner: CryptoActor): StronglyConnectedGraph<KeypairFingerprintV1String> {
		val publicKeys = dataOwner.publicKeysSpki.map { it.fingerprintV1() }
		val edges = dataOwner.transferKeys.entries.flatMap { (source, targetKeys) ->
			val sourceFp = source.toFingerprintV1OrNull()
			if (sourceFp == null) {
				emptyList()
			} else {
				targetKeys.keys.mapNotNull { target -> target.toFingerprintV1OrNull()?.let { sourceFp to it } }
			}
		}
		return DirectedGraph.fromEdges(*edges.toTypedArray(), additionalNodes = publicKeys).acyclic()
	}

	private fun StronglyConnectedGraph<KeypairFingerprintV1String>.transferTargetKeys(currentDataOwnerId: String): List<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> {
		// The groups of all keys available on this device -> we have the ability to create transfer keys to them
		val availableGroups = encryptionKeysManager.getDecryptionKeysForDataOwnerIfInCurrentHierarchy(currentDataOwnerId)?.allKeys?.map { key ->
			key.pubSpkiHexString.fingerprintV1().let { fp -> originalLabelToAcyclicLabel[fp] ?: fp }
		}?.toSet().orEmpty()
		// Drop candidates that are already reachable from another transfer keys group
		val groupsReachableFromAvailable = acyclicGraph.nodesToEdges.entries.flatMap { (source, reachables) ->
			if (availableGroups.contains(source)) reachables else emptyList()
		}.toSet()
		val targetCandidates = availableGroups.filter { it !in groupsReachableFromAvailable }
		// Remap candidate groups to prefer verified keys if available on that group
		val verifiedFps = encryptionKeysManager.delegatorActorVerifiedKeys().map { it.pubSpkiHexString.fingerprintV1() }
		return targetCandidates.map { candidateFp ->
			val candidateGroup = acyclicLabelToGroup[candidateFp] ?: setOf(candidateFp) // May not be part of transfer keys graph yet
			val bestCandidateOfGroup = candidateGroup.find { verifiedFps.contains(it) } ?: candidateFp
			ensureNonNull(encryptionKeysManager.getKeyPairForFingerprint(bestCandidateOfGroup.toV2())) {
				"Key pair not found for fingerprint $bestCandidateOfGroup"
			}.keyPair
		}
	}

	// all public keys would go to the stored keys -> no need for specifying the key.
	// Result only includes the acyclic label, not the full group
	private fun StronglyConnectedGraph<KeypairFingerprintV1String>.transferKeysCandidatesFp(
		keyToFp: KeypairFingerprintV1String
	): Set<KeypairFingerprintV1String> =
		reachSets.mapNotNull { (from, reachable) ->
			val currGroup = acyclicLabelToGroup.getValue(from)
			val reachableOriginal = reachable.flatMap { acyclicLabelToGroup.getValue(it) }
			if (keyToFp in currGroup || keyToFp in reachableOriginal) null else from
		}.toSet()
}
