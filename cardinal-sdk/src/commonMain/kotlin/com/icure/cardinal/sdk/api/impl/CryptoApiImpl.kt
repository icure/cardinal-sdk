package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.api.CryptoInGroupApi
import com.icure.cardinal.sdk.api.ShamirKeysManagerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.crypto.entities.SelfVerifiedKeysSet
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.crypto.impl.loadEncryptionKeysForDataOwner
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.Pkcs8Bytes
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.chunked
import kotlinx.coroutines.flow.toList

@InternalIcureApi
internal class CryptoApiImpl(
	override val shamirKeysManager: ShamirKeysManagerApi,
	internal val internal: InternalCryptoServices
) : CryptoApi {
	override val inGroup: CryptoInGroupApi = object : CryptoInGroupApi {
		override suspend fun keylessCreateExchangeDataTo(
			groupId: String?,
			delegate: EntityReferenceInGroup
		) = doKeylessCreateExchangeDataTo(groupId, delegate)

		override suspend fun getAccessControlKeys(groupId: String?, entityType: EntityWithEncryptionMetadataTypeName): List<String> =
			internal.headersProvider.getAccessControlKeysHeadersFor(groupId, entityType)
	}

	override suspend fun getAccessControlKeys(entityType: EntityWithEncryptionMetadataTypeName): List<String> =
		internal.headersProvider.getAccessControlKeysHeadersFor(groupId = null, entityType)

	override suspend fun forceReload() {
		internal.forceReload()
	}

	override suspend fun availableKeys(
		filterTrustedKeys: Boolean
	): Map<String, Map<KeypairFingerprintV1String, Pkcs8Bytes>> =
		internal.userEncryptionKeysManager.getAvailableKeyPairs().mapValues { (_, keyInfo) ->
			keyInfo.filter { cachedKeypairDetails ->
				!filterTrustedKeys || cachedKeypairDetails.isDevice || cachedKeypairDetails.isVerified
			}.associate { cachedKeypairDetails ->
				Pair(
					cachedKeypairDetails.keyPair.pubSpkiHexString.fingerprintV1(),
					Pkcs8Bytes(defaultCryptoService.rsa.exportPrivateKeyPkcs8(cachedKeypairDetails.keyPair.key.private))
				)
			}
		}

	override suspend fun keylessCreateExchangeDataTo(delegate: String) = doKeylessCreateExchangeDataTo(
		groupId = null,
		delegate = EntityReferenceInGroup(
			entityId = delegate,
			groupId = null
		)
	)

	private suspend fun doKeylessCreateExchangeDataTo(
		groupId: String?,
		delegate: EntityReferenceInGroup
	): RawDecryptedExchangeData {
		require(delegate.groupId == null && delegate.entityId != this.internal.dataOwnerApi.getCurrentDataOwnerId()) { "Can't create exchange data to yourself in keyless mode." }
		check(this.internal.userEncryptionKeysManager.delegatorActorVerifiedKeys().isEmpty()) { "This method can only be used in keyless mode." }

		val created = this.internal.exchangeDataManager.getOrCreateEncryptionDataTo(
			groupId = groupId,
			delegateReference = delegate,
			allowCreationWithoutDelegateKey = false,
			allowCreationWithoutDelegatorKey = true
		)
		return RawDecryptedExchangeData(
			exchangeDataId = created.exchangeData.id,
			accessControlSecret = this.internal.exchangeDataManager.base.exportAccessControlSecret(created.unencryptedContent.accessControlSecret),
			exchangeKey =  this.internal.exchangeDataManager.base.exportExchangeKey(created.unencryptedContent.exchangeKey),
			sharedSignatureKey =  this.internal.exchangeDataManager.base.exportSharedSignatureKey(created.unencryptedContent.sharedSignatureKey),
		)
	}

	override suspend fun injectExchangeData(
		groupId: String?,
		details: List<ExchangeDataInjectionDetails>,
		reEncryptWithOwnKeys: Boolean,
	) {
		this.internal.exchangeDataManager.injectDecryptedExchangeData(
			groupId = groupId,
			exchangeDataDetails = details,
			reEncryptWithOwnKeys = reEncryptWithOwnKeys
		)
	}

	@OptIn(ExperimentalCoroutinesApi::class)
	override suspend fun ensureHasAccessToSharedSimpleDataOwnerGroupExchangeData(
		delegate: String,
		sharedSimpleDataOwnerGroupId: String,
		delegatePublicKey: SpkiHexString?,
	): Boolean {
		require (this.internal.dataOwnerApi.getCurrentDataOwnerId() != delegate) {
			"Can't use ensureHasAccessToSharedSimpleDataOwnerGroupExchangeData method with delegate being your own data owner"
			//TODO at some point might be good to add support for cases where a parent-type link is part of the same simple-group as a newly added self, for example:
			// 1. Self has been added to group, but parent of self was already there
			// 2. Self can add pieces for the simple group exchange, and can decrypt them using the parent
			// 3. Self is removed from parent group
			// Not sure if there is ever going to be a good use case for this, but we could technically support something like such
		}
		val thisLinkToGroup = this.internal.dataOwnerApi.getCurrentDataOwnerHierarchyInfo().findLinkType(sharedSimpleDataOwnerGroupId)
		require (thisLinkToGroup != null) {
			"Current data owner is not part of group $sharedSimpleDataOwnerGroupId."
		}
		require (thisLinkToGroup == DataOwnerGroupLinkType.Simple) {
			"$sharedSimpleDataOwnerGroupId does not represent a simple-type data owner group"
		}
		this.internal.dataOwnerApi.getDataOwnerHierarchyInfo(delegate).let {
			require (it.dataOwnerType == this.internal.dataOwnerApi.getCurrentDataOwnerType()) {
				"Delegate data owner is not of the same type as the current data owner."
			}
			require (it.contains(sharedSimpleDataOwnerGroupId)) {
				"Delegate data owner is not a member of the shared simple-type data owner group $sharedSimpleDataOwnerGroupId."
			}
		}
		val allDelegateKeysBySpki = this.internal.primitives.loadEncryptionKeysForDataOwner(
			requireNotNull(this.internal.dataOwnerApi.getCryptoActorStub(delegate)) {
				"Could not find delegate crypto actor $delegate"
			}.stub
		).associateBy { it.pubSpkiHexString }
		val delegateEncryptionKeys = delegatePublicKey?.let {
			VerifiedRsaEncryptionKeysSet(
				listOf(
					requireNotNull(allDelegateKeysBySpki[it]) {
						"Pub key with fingerprint ${it.fingerprintV2()} is not a key of the delegate crypto actor $delegate"
					}
				)
			)
		} ?: VerifiedRsaEncryptionKeysSet(allDelegateKeysBySpki.values)
		val decryptionRecipients = this.internal.dataOwnerApi.getCurrentDataOwnerHierarchyInfo().findLinkedSimpleGroupOwnRecipients(sharedSimpleDataOwnerGroupId)
		val decryptionKeysByRecipient = decryptionRecipients.associateWith {
			this.internal.userEncryptionKeysManager.getDecryptionKeysForDataOwnerIfInCurrentHierarchy(it)
		}
		val searchRecipients = (decryptionRecipients + delegate).mapTo(mutableSetOf()) { EntityReferenceInGroup(it, null) }
		var allHandled = true
		var remainingIds = this.internal.exchangeDataManager.base.getMainExchangeDataIdsForParticipant(sharedSimpleDataOwnerGroupId).toList()
		var idsToRetry = mutableListOf<String>()
		var remainingTries = 3
		while (remainingIds.isNotEmpty() && remainingTries-- > 0) {
			remainingIds.chunked(50).forEach { currChunk ->
				val currChunkFound = this.internal.exchangeDataManager.base.getExchangeDataPiecesByIdsForRecipients(
					null,
					currChunk.toSet(),
					searchRecipients,
				)
				val piecesToUpdate =
					mutableListOf<BaseExchangeDataManager.UpdateExistingExchangeDataGroupPieceRequest>()
				val piecesToCreate =
					mutableListOf<BaseExchangeDataManager.CreatePieceForExistingExchangeDataGroupRequest>()
				currChunkFound.values.forEach { currGroupPieces ->
					if (currGroupPieces[delegate]?.takeIf {
							delegatePublicKey == null || it.exchangeKey.containsKey(
								delegatePublicKey.fingerprintV2()
							)
						} != null) return@forEach // nothing to do
					val decryptedContent = decryptionRecipients.firstNotNullOfOrNull { recipient ->
						currGroupPieces[recipient]?.let {
							this.internal.exchangeDataManager.base.tryDecryptExchangeDataContentAndGetVerified(
								it,
								decryptionKeysByRecipient[recipient]!!,
								SelfVerifiedKeysSet.empty,
								null,
							)
						}
					}?.first
					if (decryptedContent == null) {
						allHandled = false
						return@forEach
					}
					val existingPiece = currGroupPieces[delegate]
					if (existingPiece != null) {
						piecesToUpdate.add(
							BaseExchangeDataManager.UpdateExistingExchangeDataGroupPieceRequest(
								existingPiece = existingPiece,
								newPieceEncryptionKeys = delegateEncryptionKeys,
								groupUnencryptedContent = decryptedContent
							)
						)
					} else {
						val referencePiece = currGroupPieces.values.first()
						piecesToCreate.add(
							BaseExchangeDataManager.CreatePieceForExistingExchangeDataGroupRequest(
								exchangeDataGroupId = referencePiece.exchangeDataGroupId ?: return@forEach,
								recipientReference = EntityReferenceInGroup(delegate, null),
								delegatorReferenceString = referencePiece.delegator,
								delegateReferenceString = referencePiece.delegate,
								newPieceEncryptionKeys = delegateEncryptionKeys,
								groupUnencryptedContent = decryptedContent,
							)
						)
					}
				}
				val successCreate = this.internal.exchangeDataManager.base.createPiecesForExistingExchangeDataGroup(
					null,
					piecesToCreate
				).toSet()
				val successUpdate = this.internal.exchangeDataManager.base.updateExchangeDataGroupPieces(
					null,
					piecesToUpdate
				).toSet()
				idsToRetry.addAll(currChunk - (successCreate + successUpdate))
			}
			remainingIds = idsToRetry
			idsToRetry = mutableListOf()
		}
		return remainingIds.isEmpty() && allHandled
	}
}
