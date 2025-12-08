package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.ExchangeDataRecoveryDetails
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeySize
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.RecoveryData
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.internal
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.base64Encode
import com.icure.cardinal.sdk.utils.decode
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesService
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.fail
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeSingleton
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.ktor.utils.io.core.toByteArray
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.random.Random

@OptIn(InternalIcureApi::class)
class RecoveryDataEncryptionTest : StringSpec({
	val specJob = autoCancelJob()
	beforeSpec { initializeTestEnvironment() }
	"User should be able to create and use key recovery info".config(enabled = DEFAULT_ENABLED) {
		val hcp = createHcpUser()
		val api = hcp.api(specJob)
		val recoveryKey = api.recovery.createRecoveryInfoForAvailableKeyPairs()
		val data = api.patient.createPatient(
			api.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = "Some secret note"
				),
			)
		)
		var calledRecovery = false
		val recoveringStrategies = object : CryptoStrategies by BasicCryptoStrategies {
			override suspend fun recoverAndVerifySelfHierarchyKeys(
				keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
				cryptoPrimitives: CryptoService,
				keyPairRecoverer: KeyPairRecoverer
			): Map<String, CryptoStrategies.RecoveredKeyData> {
				calledRecovery = true
				val recoveredKeys = keyPairRecoverer.recoverWithRecoveryKey(recoveryKey, autoDelete = true).value
				return keysData.associate { keyData ->
					keyData.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
						recoveredKeys.getValue(keyData.dataOwnerDetails.dataOwner.id)
							.mapKeys { it.key.fingerprintV1() },
						emptyMap()
					)
				}
			}

			override suspend fun generateNewKeyForDataOwner(
				self: DataOwnerWithType,
				cryptoPrimitives: CryptoService
			): CryptoStrategies.KeyGenerationRequestResult = fail("Should not need to create new key")
		}
		val api2 = hcp.apiWithKeys(specJob, cryptoStrategies = recoveringStrategies) // No keys will be in storage
		api2.patient.getPatient(data.id) shouldBe data
		calledRecovery shouldBe true
	}

	"User should be able to share data with a patient that did not yet do a first login".config(enabled = DEFAULT_ENABLED) {
		val hcp = createHcpUser()
		val api = hcp.api(specJob)
		val patient = api.patient.createPatient(
			api.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = "Some secret note"
				),
			)
		)
		val secretIdsOptions = SecretIdShareOptions.AllAvailable(true)
		shouldThrow<IllegalArgumentException> {
			api.patient.shareWith(patient.id, patient, PatientShareOptions(shareSecretIds = secretIdsOptions))
		}
		api.patient.forceInitializeExchangeDataToNewlyInvitedPatient(patient.id) shouldBe true
		api.patient.shareWith(patient.id, patient, PatientShareOptions(shareSecretIds = secretIdsOptions))
		val recoveryKey = api.recovery.createExchangeDataRecoveryInfo(patient.id)
		val patientUser = createPatientUser(existingPatientId = patient.id)
		val apiPatient = patientUser.api(specJob)
		shouldThrow<EntityEncryptionException> { apiPatient.patient.getPatient(patient.id) }
		apiPatient.recovery.recoverExchangeData(recoveryKey.shouldNotBeNull())
		apiPatient.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe patient.note
	}

	"Existing key recovery info should be decrypted correctly".config(enabled = DEFAULT_ENABLED) {
		// All data was created only for testing purposes
		val childId = defaultCryptoService.strongRandom.randomUUID()
		val childPrivate = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCNwFBObvWcTPk/xdtzGVjqrlFxTlSMVbsO4UGT" +
			"/x4JkGmAmz7AdE28uzl6ObMWYrzuk18jKaTM8D4mAqwypjwecWlbypkgXtbE7nhzy3ESoIfb6e7S73VxErdT+azPke+rcdCfh6bpr/J" +
			"KJIAxr+DkyDZ/N5w7Grw5Pju0ApENgnb3tMpxg7jGrizTSk0bdL8bcno9VM6LuZ83K+QaU7ONMWxaKJOCoZNcVEjo3FdivuSv1CF1fR" +
			"J1yJJTUESXI9LPp/ZF3GPYuLjwvP20BVEaCr4rsYmOHINsmfyFvgfC7Ei0FVOK85G2JVUBxaZ6CZecdv+eAt8nqsgi4n+HwbZvAgMBA" +
			"AECggEAAea1bQfh9XG22hseQWHyplsmLn3ddnBj7OQqjACc94XfVGFAqzYkIMbmE3SYqVEztYN2gDM7yZ/jRYE9rAQ8xC/DOP7zpNKA" +
			"0O1d4je1UYmjqNhvYpbhnV2h5ddwcOxFKaiCItGf9HxupH3u1jvEqWziBjzJtKU8JwxloplyNpsnPcLoKwvak3TYbPtpxxayvLPQ9gS" +
			"1ayXzZsv28oTiWODELPI3b6PFVT0LBNm+wpWOQkaQZYqDKt0uX2bUIJR7h9Gp6uC+Prz4DifMvJhX3wJz9Hq9FlZNoTmqPcspjbSeOk" +
			"cqnlyWZVGkBijbfrppT03lCYNeHUulIDCWmIQjoQKBgQDHifFdjEdsvpGMu+i9PfJ6SSNjpw/Zp5UaChLITo6lDKJRCHzN/qIwesmoA" +
			"9MQK1HjxvD2mvMnRUtHFHE70DM5wcdsp/t+NzPoYof392ezbk0dTrvTKarpRaT9xgvd2qGflrHYfZHcn2M03iWKywHx07UeZHZF9OC3" +
			"fTO/8ote0QKBgQC13GQ13V2bvbkOOvWU9iAr8w7SfCdqAugSytfyAf1OD9DpTzoTnBw6Gs5plw14DIWDbzNalh+zc/SiKBiLt1OWWGD" +
			"CisFoQe4DMe0eFgDLAGWvJ1C0n3OmhYYwIEUjieFATHRnGBj3z2TULwSvwR0wNL9zTvurWnfQCj5kZPGRPwKBgQDFJhXESAWJ+//y/P" +
			"ZHhB0/lWPR4g5XDqzSvYExR+zIRmNZjPlCzoORQsBbsOuo3iRa2QTbotz7wAtQf3IhluQF/N/9CzwAyKoQwMl2xos/TYwDmPca++BR+" +
			"u25jyPKX2mxNEMjk226fgCXC6YsK8gQFwysqrXxCLG+mYW38PyjAQKBgEdbgcqM4HUCnYES61eWt4rnJRK7+m8jUtJE2zSvSSf/Frbl" +
			"CmG1aHH4ILPXvEY1i5HF6T2LGEc+oWebGf6AYYDljpnm/fqdm/mO9n5OneMJddyjLYyh4CwfykZJ8zb9m++x0B6/mtRpgSOsi0c3G+/" +
			"VUqW5ARD8P3TXACI+ZXbbAoGATQ64HE3PwXRo7MBpvwilZEHvASv2XsIKuWogs83TiMF+gsyokAofVx1VGpafA7W2YKZf2mZWUJbWbW" +
			"77X6DcFzpSBW0zfkKlcXeTOT/MaqotPxyaYG/ffyilrm6ENb54MGgcmJqTLgmVO2dArfuN+INmMoQoN5C0kdK8oyq4uu8="
		val childPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjcBQTm71nEz5P8XbcxlY6q5RcU5UjFW7DuFBk/8eCZBpg" +
			"Js+wHRNvLs5ejmzFmK87pNfIymkzPA+JgKsMqY8HnFpW8qZIF7WxO54c8txEqCH2+nu0u91cRK3U/msz5Hvq3HQn4em6a/ySiSAMa/g" +
			"5Mg2fzecOxq8OT47tAKRDYJ297TKcYO4xq4s00pNG3S/G3J6PVTOi7mfNyvkGlOzjTFsWiiTgqGTXFRI6NxXYr7kr9QhdX0SdciSU1B" +
			"ElyPSz6f2Rdxj2Li48Lz9tAVRGgq+K7GJjhyDbJn8hb4HwuxItBVTivORtiVVAcWmegmXnHb/ngLfJ6rIIuJ/h8G2bwIDAQAB"
		val parentId = defaultCryptoService.strongRandom.randomUUID()
		val parentPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDLflvkQoqJoox31jholW0ZwOn0C4LaT8BbrfR" +
			"8vsQwjiT9HQhYt8LK+fLWU4DOXjzP13lrfqezZ8P0Af4CcUTLHEGbDcwNcfBonuipn058a/GQlVXp5JuXtLrOLWf3S5aYxOeJKB/SHj" +
			"caO7bavmCIH4e2iYuydfCTSn/IElvGm/bLAGZwDHtacct0hJ+uBfZMvLZp8J3V6PGQ+t6YLes5ogptN4tp6dJNDJDBjrgr1w+R/OQ1H" +
			"M3khVydj5vMdR+i4s2mOJs20cYkD3Ra0rD2OYVxwYIPbCYlCXDt7P15BpdEHrRfe45VSJnhpx8DGP1F8Qfud1vmijizvAh3EnUpAgMB" +
			"AAECggEARWR7GI06afH03b6+8KcYE8Kt5StxvVmZ2ompCEsTYw1t/qSCXqKXehkfHshN8dHAAg5UGPyRWoQFlfWB9bpDf9HMa4Aad/F" +
			"FTp/17jXlkVdMAoZyTDbJekPGuh1QyUtM+R6YaDS3GTN1jewUEGcASxsZb/1alopSdh/fEE52XnTf6SAeM4YHEpaDV3it0ugkFc0uZY" +
			"290RK7+P3pRdhvHfS7kzXycSRISsml5wgBZBUTFFU/Oi/7pOgAUGzlFKkHKHmIulfoCy/mGOf5W0d+UePBucrd8hAbUglb0+Wed0zgO" +
			"nhPsxqWgpghXM/qi5DfZOm17+EFZw0xLgecrceD2wKBgQD2JmdUiAx+s/H+atztrkCutrigyIBKF3keL2i4UebK7L7LsNY71UuBWw1R" +
			"wvOnX5+6q+nxTbE2NbYoeAeSdxsgg69Z+uhbAu6HYg6pl++kohRtjstJRSPo2mEgLlaHukjDfkMDzwGHj+KTXD78fIbmNwxCAeiJrgq" +
			"c3JM1kJ74jwKBgQDTovoLH5IgpWeACbqyFAvUm6eJvCCLkNcIraCIqdvUF5QItZ2hcp+YG60p69OS1TPx4jFa7rbzVy7z5xC9P9Co+D" +
			"Bogf58qR4r8gP5Nrh8fxmUbfLonMKBNMVVDuho8H3y2JkSXgmT+rgyn4hAFdOhOVgmEGaZin3afwuDmV/ixwKBgHMwg5iGVjqQ4QUrY" +
			"xoDOpfIQFxVl9uUYoSisQHYqgV6hsrxhT/Y0A3H21LQxY8k663Ct6bJsc1pk0Ya7Yg4HsS3ez7DcSruE0vdsnjg9i93/dFLSoyOQ4C7" +
			"eUpDBRFdNqHtm1TT8aZLyj8lowArEkH3rs/Q7s5HWQYRHv6pIAu3AoGAPMS1S3BbQyh7WZZxlySOaRPwvWnZZnnGZOWGDPfI+VNz3DR" +
			"Z+Luy+7gmtrzSWX0Cl1e9mECnI6RLBRm6Ar1KKtpo+/knm5/r2+54GZ0OyCCutaIEd6pbZ0JBzzSio086uvpaqZ163pTFQzPvqYca51" +
			"ZR60wWScwsawrDwZvOno0CgYASOjQawBObdgThbkJ2EUdlq8J2rOYKYXxkbM9W1eC22v9LKH0+H9CJT+nc9cfHcJHd4SF8qFvwRCqvv" +
			"AH2Npa0G5EMcLrJb3enoZpStQKyGjK756Ac2pZ5WW+DxFEh8d7/MUZ0wVUcKPkscQnkYPpIdOzqIlfoEuGsesOJIPpecQ=="
		val parentPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy35b5EKKiaKMd9Y4aJVtGcDp9AuC2k/AW630fL7EMI4k" +
			"/R0IWLfCyvny1lOAzl48z9d5a36ns2fD9AH+AnFEyxxBmw3MDXHwaJ7oqZ9OfGvxkJVV6eSbl7S6zi1n90uWmMTniSgf0h43Gju22r5" +
			"giB+HtomLsnXwk0p/yBJbxpv2ywBmcAx7WnHLdISfrgX2TLy2afCd1ejxkPremC3rOaIKbTeLaenSTQyQwY64K9cPkfzkNRzN5IVcnY" +
			"+bzHUfouLNpjibNtHGJA90WtKw9jmFccGCD2wmJQlw7ez9eQaXRB60X3uOVUiZ4acfAxj9RfEH7ndb5oo4s7wIdxJ1KQIDAQAB"
		val recoveryDataContentJson = "{" +
			"\"$childId\": [" +
				"{\"pair\":{\"privateKey\":\"$childPrivate\",\"publicKey\":\"$childPublic\"},\"algorithm\":\"sha-256\"}" +
			"]," +
			"\"$parentId\":[" +
				"{\"pair\":{\"privateKey\":\"$parentPrivate\",\"publicKey\":\"$parentPublic\"},\"algorithm\":\"sha-1\"}" +
			"]" +
		"}"
		val hcp = createHcpUser()
		val api = hcp.api(specJob)
		val newKey = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding, AesService.KeySize.Aes256)
		val newRecoveryKey = RecoveryDataKey.fromRawBytes(defaultCryptoService.aes.exportKey(newKey))
		api.crypto.internal.recoveryDataEncryption.raw.createRecoveryData(
			RecoveryData(
				id = api.crypto.internal.recoveryDataEncryption.recoveryKeyToId(newRecoveryKey),
				recipient = hcp.dataOwnerId,
				encryptedSelf = defaultCryptoService.aes.encrypt(recoveryDataContentJson.toByteArray(), newKey)
					.base64Encode(),
				type = RecoveryData.Type.KeypairRecovery
			)
		)
		val recoveryResult = api.crypto.internal.recoveryDataEncryption.getAndDecryptKeyPairsRecoveryData(
			newRecoveryKey,
			true
		).shouldBeInstanceOf<RecoveryResult.Success<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>>>().data
		recoveryResult.keys shouldBe setOf(childId, parentId)
		recoveryResult.getValue(childId).entries.shouldBeSingleton().single().let { (spki, keypair) ->
			val exportedPublic = defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).base64Encode()
			val exportedPrivate = defaultCryptoService.rsa.exportPrivateKeyPkcs8(keypair.private).base64Encode()
			spki shouldBe SpkiHexString(exportedPublic.decode().toHexString())
			exportedPublic.s shouldBe childPublic
			exportedPrivate.s shouldBe childPrivate
			keypair.algorithm shouldBe RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
		}
		recoveryResult.getValue(parentId).entries.shouldBeSingleton().single().let { (spki, keypair) ->
			val exportedPublic = defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).base64Encode()
			val exportedPrivate = defaultCryptoService.rsa.exportPrivateKeyPkcs8(keypair.private).base64Encode()
			spki shouldBe SpkiHexString(exportedPublic.decode().toHexString())
			exportedPublic.s shouldBe parentPublic
			exportedPrivate.s shouldBe parentPrivate
			keypair.algorithm shouldBe RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		}
	}

	"Existing exchange data recovery info should be decrypted correctly".config(enabled = DEFAULT_ENABLED) {
		val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding, AesService.KeySize.Aes256)
		val recoveryKey = RecoveryDataKey.fromRawBytes(defaultCryptoService.aes.exportKey(key))
		val exchangeDataId = defaultCryptoService.strongRandom.randomUUID()
		val rawAccessControlSecret = "EisFflVfFfAXj3sWoGuhhg=="
		val rawSharedSignatureKey = "gXS+x+PYscFM2G7UX/wzrpv64X6G1rKh1vK93Z9YxGB8dA+zFRgVTB59Xz2yp6WYnfPzxjIP/4ICGQLb" +
			"26/kQ3cGrV7r5UZHOk7RtOgL+m5z+FpFIZ1zmejewe6h8b6U18lQY6moylTeHMeov8MnufEDpeW8329MP9YW5Srxteo="
		val rawExchangeKey = "vNtW4DcqZONObJktCUHNhdmvRRgCLWzU+iBsX+zpIx4="
		val recoveryInfoJson = "[{" +
			"\"exchangeDataId\":\"$exchangeDataId\"," +
			"\"rawAccessControlSecret\":\"$rawAccessControlSecret\"," +
			"\"rawSharedSignatureKey\":\"$rawSharedSignatureKey\"," +
			"\"rawExchangeKey\":\"$rawExchangeKey\"" +
		"}]"
		val hcp = createHcpUser()
		val api = hcp.api(specJob)
		api.crypto.internal.recoveryDataEncryption.raw.createRecoveryData(
			RecoveryData(
				id = api.crypto.internal.recoveryDataEncryption.recoveryKeyToId(recoveryKey),
				recipient = hcp.dataOwnerId,
				encryptedSelf = defaultCryptoService.aes.encrypt(recoveryInfoJson.toByteArray(), key).base64Encode(),
				type = RecoveryData.Type.ExchangeKeyRecovery
			)
		)
		val recoveryResult = api.crypto.internal.recoveryDataEncryption.getAndDecryptExchangeDataRecoveryData(recoveryKey)
			.shouldBeInstanceOf<RecoveryResult.Success<List<ExchangeDataRecoveryDetails>>>().data
		recoveryResult.shouldBeSingleton().single() shouldBe ExchangeDataRecoveryDetails(
			exchangeDataId = exchangeDataId,
			rawAccessControlSecret = Base64String(rawAccessControlSecret),
			rawSharedSignatureKey = Base64String(rawSharedSignatureKey),
			rawExchangeKey = Base64String(rawExchangeKey)
		)
	}

	"Recovery data key options should be respected".config(enabled = DEFAULT_ENABLED) {
		val hcp = createHcpUser()
		val api = hcp.api(specJob)
		val recoveryKey1 = api.recovery.createRecoveryInfoForAvailableKeyPairs(
			recoveryKeyOptions = RecoveryKeyOptions.Generate(RecoveryKeySize.Bytes16)
		)
		recoveryKey1.asRawBytes() shouldHaveSize 16
		val recoveryKey2 = api.recovery.createRecoveryInfoForAvailableKeyPairs(
			recoveryKeyOptions = RecoveryKeyOptions.Generate(RecoveryKeySize.Bytes32)
		)
		recoveryKey2.asRawBytes() shouldHaveSize 32
		val precomputedKey1 = RecoveryDataKey.fromRawBytes(Random.nextBytes(16))
		val recoveryKey3 = api.recovery.createRecoveryInfoForAvailableKeyPairs(
			recoveryKeyOptions = RecoveryKeyOptions.Use(precomputedKey1)
		)
		recoveryKey3.asRawBytes().toList() shouldBe precomputedKey1.asRawBytes().toList()
		val precomputedKey2 = RecoveryDataKey.fromRawBytes(Random.nextBytes(32))
		val recoveryKey4 = api.recovery.createRecoveryInfoForAvailableKeyPairs(
			recoveryKeyOptions = RecoveryKeyOptions.Use(precomputedKey2)
		)
		recoveryKey4.asRawBytes().toList() shouldBe precomputedKey2.asRawBytes().toList()
		listOf(
			recoveryKey1,
			recoveryKey2,
			recoveryKey3,
			recoveryKey4,
		).forEach { recoveryKey ->
			api.recovery.recoverKeyPairs(recoveryKey, true).apply {
				isSuccess shouldBe true
				value.shouldNotBeEmpty()
			}
		}
	}

	"Attempting to create recovery data with an already used key should fail".config(enabled = DEFAULT_ENABLED) {
		val hcp = createHcpUser()
		val api = hcp.api(specJob)
		val existingRecoveryKey = api.recovery.createRecoveryInfoForAvailableKeyPairs()
		shouldThrow<IllegalArgumentException> {
			api.recovery.createRecoveryInfoForAvailableKeyPairs(
				recoveryKeyOptions = RecoveryKeyOptions.Use(existingRecoveryKey)
			)
		}
		api.recovery.purgeAllRecoveryInfoFor(hcp.dataOwnerId)
		api.recovery.createRecoveryInfoForAvailableKeyPairs(
			recoveryKeyOptions = RecoveryKeyOptions.Use(existingRecoveryKey)
		) // after purging should be ok
	}

	"Should be able to wait for recovery data to be created".config(enabled = DEFAULT_ENABLED) {
		val hcp = createHcpUser()
		val api = hcp.api(specJob)
		val precomputedKey = api.recovery.preGenerateRecoveryKey(RecoveryKeySize.Bytes32)
		precomputedKey.asRawBytes() shouldHaveSize 32
		withTimeoutOrNull(6000) {
			api.recovery.recoverKeyPairsWaitingForCreation(precomputedKey, true, 4)
		}.shouldNotBeNull().shouldBeInstanceOf<RecoveryResult.Failure>().reason shouldBe RecoveryDataUseFailureReason.Missing
		val resultDeferred = async {
			withTimeoutOrNull(6000) {
				api.recovery.recoverKeyPairsWaitingForCreation(precomputedKey, true, 100)
			}
		}
		delay(2000)
		api.recovery.createRecoveryInfoForAvailableKeyPairs(recoveryKeyOptions = RecoveryKeyOptions.Use(precomputedKey))
		resultDeferred.await().shouldNotBeNull().also {
			it.isSuccess shouldBe true
			it.value.shouldNotBeEmpty()
		}
	}
})