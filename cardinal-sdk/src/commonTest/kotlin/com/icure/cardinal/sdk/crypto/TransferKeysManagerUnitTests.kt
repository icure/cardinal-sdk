package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.cardinal.sdk.crypto.entities.CandidateTransferKey
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.fake.FakeUserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.fake.NoDataOwnerApi
import com.icure.cardinal.sdk.crypto.fake.NoExchangeDataManager
import com.icure.cardinal.sdk.crypto.impl.TransferKeysManagerImpl
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.cardinal.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.cardinal.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.collections.DirectedGraph
import com.icure.cardinal.sdk.utils.collections.StronglyConnectedGraph
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainAnyOf
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
private data class Keys(
	val a: SpkiHexString,
	val b: SpkiHexString,
	val c: SpkiHexString,
	val d: SpkiHexString,
	val e: SpkiHexString,
	val f: SpkiHexString,
	val pairs: Pairs
) {
	data class Pairs(
		val a: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
		val b: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
		val c: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
		val d: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
		val e: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
		val f: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
	)
}

@OptIn(InternalIcureApi::class)
class TransferKeysManagerUnitTests : StringSpec({
	suspend fun createKeyInfo(): Pair<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>, SpkiHexString> =
		defaultCryptoService.rsa.generateKeyPair(
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
		).let { keyPair ->
			val keyInfo = CardinalKeyInfo(
				defaultCryptoService.rsa.exportSpkiHex(keyPair.public),
				keyPair
			)
			Pair(keyInfo, keyInfo.pubSpkiHexString)
		}

	lateinit var storage: CardinalStorageFacade
	lateinit var encryptionKeysManage: FakeUserEncryptionKeysManager
	lateinit var transferKeysManager: TransferKeysManagerImpl
	lateinit var self: HealthcareParty
	lateinit var keys: Keys

	beforeEach {
		val memStorage = VolatileStorageFacade()
		storage = CardinalStorageFacade(
			JsonAndBase64KeyStorage(memStorage),
			memStorage,
			DefaultStorageEntryKeysFactory,
			defaultCryptoService,
			false
		)
		self = HealthcareParty(defaultCryptoService.strongRandom.randomUUID())
		encryptionKeysManage = FakeUserEncryptionKeysManager(self.id)
		transferKeysManager = TransferKeysManagerImpl(
			encryptionKeysManage,
			storage,
			defaultCryptoService,
			NoExchangeDataManager,
			object : DataOwnerApi by NoDataOwnerApi {
				override suspend fun getCurrentDataOwnerId(): String = self.id
			}
		)

		val (aKey, a) = createKeyInfo()
		val (bKey, b) = createKeyInfo()
		val (cKey, c) = createKeyInfo()
		val (dKey, d) = createKeyInfo()
		val (eKey, e) = createKeyInfo()
		val (fKey, f) = createKeyInfo()
		keys = Keys(
			a,
			b,
			c,
			d,
			e,
			f,
			Keys.Pairs(
				aKey,
				bKey,
				cKey,
				dKey,
				eKey,
				fKey
			)
		)
	}

	suspend fun addKey(key: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>, available: Boolean, verified: Boolean) {
		if (available) {
			encryptionKeysManage.addSelfKey(key, verified)
		}
		if (verified) {
			storage.updateAndSaveSelfVerifiedKeys(self.id, mapOf(key.pubSpkiHexString.fingerprintV1() to verified))
		}
		self = self.copy(publicKeysForOaepWithSha256 = self.publicKeysForOaepWithSha256 + key.pubSpkiHexString)
	}

	fun copyWithTransferKey(
		dataOwner: HealthcareParty,
		from: SpkiHexString,
		to: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
	): HealthcareParty {
		val genericFrom = AesExchangeKeyEncryptionKeypairIdentifier(from.fingerprintV1().s)
		val genericTo = AesExchangeKeyEncryptionKeypairIdentifier(to.pubSpkiHexString.fingerprintV1().s)
		val newTransferKeys = dataOwner.transferKeys.toMutableMap()
		val fromTransferKeys = newTransferKeys[genericFrom]?.toMutableMap() ?: mutableMapOf()
		fromTransferKeys[genericTo] = HexString("0000")
		newTransferKeys[genericFrom] = fromTransferKeys
		return dataOwner.copy(transferKeys = newTransferKeys)
	}

	fun addTransferKey(from: SpkiHexString, to: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>) {
		self = copyWithTransferKey(self, from, to)
	}



	fun <T> StronglyConnectedGraph<T>.shuffled(): StronglyConnectedGraph<T> {
		val originalToNew = acyclicLabelToGroup.entries.associate { (originalLabel, newLabelCandidates) ->
			originalLabel to newLabelCandidates.random()
		}
		val newNodesToEdges = acyclicGraph.nodesToEdges.entries.map { (node, edges) ->
			originalToNew.getValue(node) to edges.map { originalToNew.getValue(it) }.shuffled().toSet()
		}.shuffled().toMap()
		val newOriginalLabelToAcyclicLabel = originalLabelToAcyclicLabel.mapValues { originalToNew.getValue(it.value) }
		val newAcyclicLabelToGroup = acyclicLabelToGroup.mapKeys { originalToNew.getValue(it.key) }.mapValues { it.value.shuffled().toSet() }
		return StronglyConnectedGraph(
			DirectedGraph(newNodesToEdges),
			newOriginalLabelToAcyclicLabel,
			newAcyclicLabelToGroup
		)
	}

	// Shuffle transfer keys and keys of the healthcare party, forcing randomization of the transfer keys graph
	fun HealthcareParty.shuffled(): HealthcareParty {
		return copy(
			publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256.shuffled().toSet(),
			transferKeys = transferKeys.toList().map { (k, v) ->
				k to v.toList().shuffled().toMap()
			}.shuffled().toMap()
		)
	}

	// Support debugging
	fun KeypairFingerprintV1String.humanize() = when (s) {
		keys.a.fingerprintV1().s -> "A"
		keys.b.fingerprintV1().s -> "B"
		keys.c.fingerprintV1().s -> "C"
		keys.d.fingerprintV1().s -> "D"
		keys.e.fingerprintV1().s -> "E"
		keys.f.fingerprintV1().s -> "F"
		else -> "Unknown"
	}
	fun SpkiHexString.humanize() = fingerprintV1().humanize()
	fun CandidateTransferKey.humanize() = "${target.pubSpkiHexString.humanize()} <- (${sources.joinToString(", ") { it.humanize() }})"
	fun StronglyConnectedGraph<KeypairFingerprintV1String>.printHumanized() = acyclicGraph.nodesToEdges.forEach { (k, edges) ->
		println("${k.humanize()} -> ${edges.map { it.humanize() }}")
	}

	suspend fun getSuggestedTransferKeysAndPrint(dataOwner: HealthcareParty = self): List<CandidateTransferKey> {
		val suggestedTransferKeys = transferKeysManager.getSuggestedTransferKeys(dataOwner)
		println("Suggested transfer keys:")
		suggestedTransferKeys.forEach { println(it.humanize()) }
		return suggestedTransferKeys
	}

	fun applySuggestions(suggestedTransferKeys: List<CandidateTransferKey>, dataOwner: HealthcareParty = self): HealthcareParty =
		suggestedTransferKeys.fold(dataOwner) { updated, candidate ->
			candidate.sources.fold(updated) { innerUpdated, s ->
				copyWithTransferKey(innerUpdated, s, candidate.target)
			}
		}

	suspend fun verifyFullyConnected(dataOwner: HealthcareParty = self) {
		val usedKeys = dataOwner.publicKeysForOaepWithSha256
		val graph = transferKeysManager.transferKeysFpGraphOf(dataOwner)
		graph.acyclicGraph.nodesToEdges.shouldHaveSize(1)
		graph.acyclicLabelToGroup.shouldHaveSize(1)
		graph.acyclicLabelToGroup.values.single() shouldBe usedKeys.map { it.fingerprintV1() }.toSet()
		getSuggestedTransferKeysAndPrint(dataOwner).shouldBeEmpty()
	}

	suspend fun applySuggestionsAndVerifyFullyConnected(suggestedTransferKeys: List<CandidateTransferKey>, dataOwner: HealthcareParty = self) {
		verifyFullyConnected(applySuggestions(suggestedTransferKeys, dataOwner))
	}

	"Suggested transfer keys with all keys available and verified should match expected - case 1".config(enabled = DEFAULT_ENABLED) {
		// A -> B -> C
		addKey(keys.pairs.a, true, true)
		addKey(keys.pairs.b, true, true)
		addKey(keys.pairs.c, true, true)
		addTransferKey(keys.a, keys.pairs.b)
		addTransferKey(keys.b, keys.pairs.c)

		val suggestedTransferKeys = getSuggestedTransferKeysAndPrint()
		suggestedTransferKeys.size shouldBe 1
		suggestedTransferKeys.first().target.pubSpkiHexString shouldBe keys.a
		suggestedTransferKeys.first().sources shouldBe listOf(keys.c)
		applySuggestionsAndVerifyFullyConnected(suggestedTransferKeys)
	}

	"Suggested transfer keys with all keys available and verified should match expected - case 2".config(enabled = DEFAULT_ENABLED) {
		// A -> B <-> C -> D <-> E
		addKey(keys.pairs.a, true, true)
		addKey(keys.pairs.b, true, true)
		addKey(keys.pairs.c, true, true)
		addKey(keys.pairs.d, true, true)
		addKey(keys.pairs.e, true, true)
		addTransferKey(keys.a, keys.pairs.b)
		addTransferKey(keys.b, keys.pairs.c)
		addTransferKey(keys.c, keys.pairs.b)
		addTransferKey(keys.c, keys.pairs.d)
		addTransferKey(keys.d, keys.pairs.e)
		addTransferKey(keys.e, keys.pairs.d)

		val suggestedTransferKeys = getSuggestedTransferKeysAndPrint()
		suggestedTransferKeys.size shouldBe 1
		suggestedTransferKeys.first().target.pubSpkiHexString shouldBe keys.a
		suggestedTransferKeys.first().sources.let {
			it.size shouldBe 1
			it shouldContainAnyOf listOf(keys.d, keys.e)
		}
		applySuggestionsAndVerifyFullyConnected(suggestedTransferKeys)
	}

	"Suggested transfer keys with all keys available and verified should match expected - case 3".config(enabled = DEFAULT_ENABLED) {
		// A -> B -> C
		// D
		addKey(keys.pairs.a, true, true)
		addKey(keys.pairs.b, true, true)
		addKey(keys.pairs.c, true, true)
		addKey(keys.pairs.d, true, true)
		addTransferKey(keys.a, keys.pairs.b)
		addTransferKey(keys.b, keys.pairs.c)
		addTransferKey(keys.c, keys.pairs.b)

		/*
		 * A <- (C) -- note: this is redundant if for the following ones `A` is picked, but we complicate too much the algorithm otherwise
		 * D <- (one of {A, B, C})
		 * one of {A, B, C} <- (D) -- note: if A then we only have 2 candidates
		 */
		val suggestedTransferKeys = getSuggestedTransferKeysAndPrint()
		if (suggestedTransferKeys.size != 2 && suggestedTransferKeys.size != 3) fail("Unexpected number of suggested transfer keys - ${suggestedTransferKeys.size}")
		suggestedTransferKeys.find {
			it.target.pubSpkiHexString == keys.a && it.sources.contains(keys.c)
		} ?: fail("No suggestion for A <- C")
		suggestedTransferKeys.find { candidate ->
			candidate.target.pubSpkiHexString == keys.d && candidate.sources.any { it == keys.a || it == keys.b || it == keys.c }
		} ?: fail("No suggestion for D <- one of {A, B, C}")
		suggestedTransferKeys.find { candidate ->
			candidate.target.pubSpkiHexString.let { it == keys.a || it == keys.b || it == keys.c } && candidate.sources.any { it == keys.d }
		} ?: fail("No suggestion for one of {A, B, C} <- D")
		applySuggestionsAndVerifyFullyConnected(suggestedTransferKeys)
	}

	"Should not suggest transfer keys to non-available keys".config(enabled = DEFAULT_ENABLED) {
		// A (non available) -> B (available)
		addKey(keys.pairs.b, true, true)
		addKey(keys.pairs.a, false, true)
		addTransferKey(keys.a, keys.pairs.b)
		getSuggestedTransferKeysAndPrint().shouldBeEmpty()
	}

	"Should suggest transfer keys even if the from is not-available".config(enabled = DEFAULT_ENABLED) {
		// A (available), B (non available), should suggest B -> A
		addKey(keys.pairs.a, true, true)
		addKey(keys.pairs.b, false, true)
		val suggestions = getSuggestedTransferKeysAndPrint()
		suggestions.size shouldBe 1
		suggestions.first().target.pubSpkiHexString shouldBe keys.a
		suggestions.first().sources shouldBe listOf(keys.b)
		getSuggestedTransferKeysAndPrint(applySuggestions(suggestions)).shouldBeEmpty()
	}

	"Should not suggest transfer keys from unverified keys".config(enabled = DEFAULT_ENABLED) {
		// A (verified) -> B (unverified)
		addKey(keys.pairs.a, true, true)
		addKey(keys.pairs.b, true, false)
		addTransferKey(keys.a, keys.pairs.b)
		getSuggestedTransferKeysAndPrint().shouldBeEmpty()
	}

	"Should still suggest transfer keys to unverified keys".config(enabled = DEFAULT_ENABLED) {
		// A (unverified) -> B (verified)
		addKey(keys.pairs.a, true, false)
		addKey(keys.pairs.b, true, true)
		addTransferKey(keys.a, keys.pairs.b)
		val suggestions = getSuggestedTransferKeysAndPrint()
		suggestions.size shouldBe 1
		suggestions.first().target.pubSpkiHexString shouldBe keys.a
		suggestions.first().sources shouldBe listOf(keys.b)
		getSuggestedTransferKeysAndPrint(applySuggestions(suggestions)).shouldBeEmpty()
	}

	"When there are groups of mixed verified and unverified keys it should prefer to create links between verified keys".config(enabled = DEFAULT_ENABLED) {
		// A (v) -> B -> C -> A
		//          |
		//          v
		// D (v) -> E -> F -> D

		// Must create D -> A
		addKey(keys.pairs.a, true, true)
		addKey(keys.pairs.b, true, false)
		addKey(keys.pairs.c, true, false)
		addKey(keys.pairs.d, true, true)
		addKey(keys.pairs.e, true, false)
		addKey(keys.pairs.f, true, false)
		addTransferKey(keys.a, keys.pairs.b)
		addTransferKey(keys.b, keys.pairs.c)
		addTransferKey(keys.c, keys.pairs.a)
		addTransferKey(keys.d, keys.pairs.e)
		addTransferKey(keys.e, keys.pairs.f)
		addTransferKey(keys.f, keys.pairs.d)
		addTransferKey(keys.b, keys.pairs.e)

		repeat(1000) {
			val shuffledSelf = self.shuffled()
			val suggestions = transferKeysManager.getSuggestedTransferKeys(shuffledSelf)
			suggestions.size shouldBe 1
			suggestions.first().target.pubSpkiHexString shouldBe keys.a
			suggestions.first().sources shouldBe listOf(keys.d)
			applySuggestionsAndVerifyFullyConnected(suggestions, shuffledSelf)
		}
	}

	"Should not suggest transfer keys if there is already an equivalent transfer key involving different members of the same group".config(enabled = DEFAULT_ENABLED) {
		// A (v) -> B -> C -> A
		//          |
		//          v
		// D (v) -> E -> F -> D

		// Verification and availability was manipulated in order to enforce an attempt to create a key from A -> D.
		// The algorithm should realize that there is already a different transfer key from another member of group A to
		// another member of group D and should not suggest a new transfer key.
		addKey(keys.pairs.a, false, true)
		addKey(keys.pairs.b, false, false)
		addKey(keys.pairs.c, false, false)
		addKey(keys.pairs.d, true, true)
		addKey(keys.pairs.e, true, false)
		addKey(keys.pairs.f, true, false)
		addTransferKey(keys.a, keys.pairs.b)
		addTransferKey(keys.b, keys.pairs.c)
		addTransferKey(keys.c, keys.pairs.a)
		addTransferKey(keys.d, keys.pairs.e)
		addTransferKey(keys.e, keys.pairs.f)
		addTransferKey(keys.f, keys.pairs.d)
		addTransferKey(keys.b, keys.pairs.e)

		// Randomize the graph used to make sure that at least one time B and E are NOT the canonical labels for the 2 groups
		repeat(1000) {
			transferKeysManager.getSuggestedTransferKeys(
				self.shuffled()
			).shouldBeEmpty()
		}
	}
})