package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class KeyRecoveryTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"Crypto strategies should be able to recover using iCure recovery methods".config(enabled = DEFAULT_ENABLED) {
		val hcp = createHcpUser()
		// Create a new key and corresponding transfer keys
		var secondKey: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>? = null
		hcp.apiWithLostKeys(
			specJob,
			cryptoStrategies = object : CryptoStrategies {
				override suspend fun recoverAndVerifySelfHierarchyKeys(
					keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
					cryptoPrimitives: CryptoService,
					keyPairRecoverer: KeyPairRecoverer
				): Map<String, CryptoStrategies.RecoveredKeyData> {
					val selfRecoveryRequest = keysData.shouldHaveSize(1).single()
					selfRecoveryRequest.unavailableKeys.map { it.publicKey } shouldContainExactlyInAnyOrder listOf(hcp.publicKeySpki!!)
					selfRecoveryRequest.unknownKeys shouldContainExactlyInAnyOrder listOf(hcp.publicKeySpki)
					return keysData.associate {
						it.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
							recoveredKeys = emptyMap(),
							keyAuthenticity = mapOf(hcp.publicKeySpki.fingerprintV1() to true)
						)
					}
				}

				override suspend fun notifyNewKeyCreated(
					apis: CardinalApis,
					key: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>,
					cryptoPrimitives: CryptoService
				) {
					if (secondKey != null) fail("Should notify only once")
					secondKey = key
				}
			}
		)
		if (secondKey == null) fail("Should have created a second key")
		val secondKeySpki = defaultCryptoService.rsa.exportSpkiHex(secondKey.public)
		// Try to use the transfer keys from crypto strategies
		val initialized = hcp.apiWithLostKeys(
			specJob,
			cryptoStrategies = object : CryptoStrategies {
				override suspend fun recoverAndVerifySelfHierarchyKeys(
					keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
					cryptoPrimitives: CryptoService,
					keyPairRecoverer: KeyPairRecoverer
				): Map<String, CryptoStrategies.RecoveredKeyData> {
					val selfRecoveryRequest = keysData.shouldHaveSize(1).single()
					selfRecoveryRequest.unavailableKeys.map { it.publicKey } shouldContainExactlyInAnyOrder listOf(secondKeySpki, hcp.publicKeySpki!!)
					selfRecoveryRequest.unknownKeys shouldContainExactlyInAnyOrder listOf(secondKeySpki, hcp.publicKeySpki)
					keyPairRecoverer.getRecoverableWithEncryptionKeys(selfRecoveryRequest.dataOwnerDetails, listOf(hcp.keypair!!)) shouldBe setOf(secondKeySpki)
					return keysData.associate {
						it.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
							recoveredKeys = mapOf(
								hcp.publicKeySpki.fingerprintV1() to hcp.keypair,
							),
							keyAuthenticity = mapOf(
								secondKeySpki.fingerprintV1() to true
							)
						)
					}
				}

				override suspend fun generateNewKeyForDataOwner(
					self: DataOwnerWithType,
					cryptoPrimitives: CryptoService
				): CryptoStrategies.KeyGenerationRequestResult {
					fail("Should not create a third key")
				}
			}
		).first
		initialized.crypto.currentDataOwnerKeys().apply {
			keys shouldBe setOf(hcp.dataOwnerId)
			values.single().keys shouldBe setOf(hcp.publicKeySpki!!.fingerprintV1(), secondKeySpki.fingerprintV1())
		}
	}

	"Should be able to use keys of the parent HCP to recover shamir splits".config(enabled = DEFAULT_ENABLED) {
		TODO("Implement test and functionality (was part of typescript sdk)")
	}
})