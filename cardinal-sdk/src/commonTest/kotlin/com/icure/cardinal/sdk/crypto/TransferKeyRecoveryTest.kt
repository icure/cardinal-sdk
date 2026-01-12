package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.internal
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class TransferKeyRecoveryTest : StringSpec({
	val specJob = autoCancelJob()
	beforeSpec { initializeTestEnvironment() }

	class VerifyEverythingStrategy(
		private val expectMissingKeys: Boolean
	) : CryptoStrategies {
		override suspend fun recoverAndVerifySelfHierarchyKeys(
			keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
			cryptoPrimitives: CryptoService,
			keyPairRecoverer: KeyPairRecoverer
		): Map<String, CryptoStrategies.RecoveredKeyData> =
			keysData.associate {
				if (expectMissingKeys) {
					it.unavailableKeys.shouldNotBeEmpty()
				} else {
					it.unavailableKeys.shouldBeEmpty()
				}
				it.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
					recoveredKeys = emptyMap(),
					keyAuthenticity = it.unknownKeys.associate { k -> k.fingerprintV1() to true }
				)
			}

		override suspend fun generateNewKeyForDataOwner(
			self: DataOwnerWithType,
			cryptoPrimitives: CryptoService
		): CryptoStrategies.KeyGenerationRequestResult =
			CryptoStrategies.KeyGenerationRequestResult.Allow

		override suspend fun verifyDelegatePublicKeys(
			delegate: CryptoActorStubWithType,
			publicKeys: List<SpkiHexString>,
			cryptoPrimitives: CryptoService,
			groupId: String?
		): List<SpkiHexString> =
			publicKeys

		override suspend fun dataOwnerRequiresAnonymousDelegation(dataOwner: CryptoActorStubWithType, groupId: String?): Boolean =
			dataOwner.type == DataOwnerType.Patient
	}

	"Api should automatically create needed transfer keys and use them to recover missing keys".config(enabled = DEFAULT_ENABLED) {
		val hcp = createHcpUser()
		val originalKeyIdentifier = hcp.publicKeySpki.shouldNotBeNull().fingerprintV1().asAmbiguousIdentifier()
		val originalApi = hcp.api(specJob, VerifyEverythingStrategy(false))
		val (secondApi, secondKey) = hcp.apiWithLostKeys(specJob, VerifyEverythingStrategy(true))
		// Automatically creates the transfer key original->second
		val secondKeyIdentifier = defaultCryptoService.rsa.exportSpkiHex(secondKey.public).fingerprintV1().asAmbiguousIdentifier()
		secondApi.dataOwner.getCurrentDataOwner().dataOwner.transferKeys.also { transferKeys ->
			transferKeys shouldHaveSize 1
			val originalToSecond = transferKeys[originalKeyIdentifier].shouldNotBeNull()
			originalToSecond.keys shouldBe setOf(secondKeyIdentifier)
		}
		secondApi.crypto.internal.userEncryptionKeysManager.getAllDecryptionKeys().allKeys shouldHaveSize 1
		// Automatically creates the transfer key second->original
		val originalApiWithRecoveredSecond = hcp.api(specJob, VerifyEverythingStrategy(false))
		originalApiWithRecoveredSecond.crypto.internal.userEncryptionKeysManager.getAllDecryptionKeys().allKeys shouldHaveSize 2
		originalApiWithRecoveredSecond.dataOwner.getCurrentDataOwner().dataOwner.transferKeys.also { transferKeys ->
			transferKeys shouldHaveSize 2
			val originalToSecond = transferKeys[originalKeyIdentifier].shouldNotBeNull()
			originalToSecond.keys shouldBe setOf(secondKeyIdentifier)
			val secondToOriginal = transferKeys[secondKeyIdentifier].shouldNotBeNull()
			secondToOriginal.keys shouldBe setOf(originalKeyIdentifier)
		}
		val secondApiWithRecoveredOriginal = hcp.apiWithKeys(
			specJob,
			secondKey,
			cryptoStrategies = VerifyEverythingStrategy(false)
		)
		secondApiWithRecoveredOriginal.crypto.internal.userEncryptionKeysManager.getAllDecryptionKeys().allKeys shouldHaveSize 2
	}
})
