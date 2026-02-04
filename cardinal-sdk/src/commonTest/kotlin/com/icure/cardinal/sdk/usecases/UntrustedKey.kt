package com.icure.cardinal.sdk.usecases

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.auth.UsernamePassword
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.KeyPairRecoverer
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.internal
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

private const val UNTRUSTED_KEY_PROP_ID = "com.test.untrustedKey"

private fun verifyDelegatePublicKeys(
	delegate: CryptoActorStubWithType,
	publicKeys: List<SpkiHexString>,
): List<SpkiHexString> {
	val untrusted = delegate.stub.cryptoActorProperties?.mapNotNull {
		if (it.id == UNTRUSTED_KEY_PROP_ID) {
			SpkiHexString(it.typedValue?.stringValue!!)
		} else {
			null
		}
	}.orEmpty().toSet()
	return publicKeys.filter { it !in untrusted }
}

@OptIn(InternalIcureApi::class)
class UntrustedKey : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"A user that has a key that can't be trusted anymore can still use it for decrypting existing data but won't use it to encrypt new data" {
		val parent = createHcpUser()
		val child = createHcpUser(parent = parent)
		val initialApi = child.api(specJob)
		// Create initial data
		val patient = initialApi.patient.createPatient(
			initialApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "john",
					lastName = "doe",
					note = "Encrypted note"
				),
				delegates = mapOf(
					parent.dataOwnerId to AccessLevel.Write
				)
			)
		)
		initialApi.patient.encrypted.getPatient(patient.id).shouldNotBeNull().note shouldBe null
		// Should have created exchange data
		val selfSelfXData = initialApi.crypto.internal.exchangeDataManager.base.getExchangeDataByDelegatorDelegatePair(null, EntityReferenceInGroup(child.dataOwnerId), EntityReferenceInGroup(child.dataOwnerId))
		val selfParentXData = initialApi.crypto.internal.exchangeDataManager.base.getExchangeDataByDelegatorDelegatePair(null, EntityReferenceInGroup(child.dataOwnerId), EntityReferenceInGroup(parent.dataOwnerId))
		selfSelfXData shouldHaveSize 1
		selfParentXData shouldHaveSize 1
		// Prepare for new api with untrusted key
		initialApi.healthcareParty.getCurrentHealthcareParty().also { self ->
			initialApi.healthcareParty.modifyHealthcareParty(
				self.copy(
					cryptoActorProperties = self.cryptoActorProperties.orEmpty() + setOf(
						DecryptedPropertyStub(
							id = UNTRUSTED_KEY_PROP_ID,
							typedValue = DecryptedTypedValue(stringValue = child.publicKeySpki!!.s)
						)
					)
				)
			)
		}
		val newParentKey = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
		val newParentKeySpki = defaultCryptoService.rsa.exportSpkiHex(newParentKey.public)
		parent.api(specJob).apply {
			val p = healthcareParty.getCurrentHealthcareParty()
			healthcareParty.modifyHealthcareParty(
				p.copy(
					cryptoActorProperties = p.cryptoActorProperties.orEmpty() + setOf(
						DecryptedPropertyStub(
							id = UNTRUSTED_KEY_PROP_ID,
							typedValue = DecryptedTypedValue(stringValue = parent.publicKeySpki!!.s)
						)
					),
					publicKeysForOaepWithSha256 = p.publicKeysForOaepWithSha256 + newParentKeySpki
				)
			)
		}
		var didCreateNewKey = false
		val newChildKey = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
		val newChildKeySpki = defaultCryptoService.rsa.exportSpkiHex(newChildKey.public)
		val apiWithUntrustedKeysStorage = VolatileStorageFacade()
		val apiWithUntrustedKey = CardinalSdk.initialize(
			null,
			baseUrl,
			AuthenticationMethod.UsingCredentials(
				UsernamePassword(
					child.username,
					child.password
				)
			),
			apiWithUntrustedKeysStorage,
			SdkOptions(
				cryptoStrategies = object : CryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						didCreateNewKey = true
						return CryptoStrategies.KeyGenerationRequestResult.Use(newChildKey)
					}

					override suspend fun recoverAndVerifySelfHierarchyKeys(
						keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
						cryptoPrimitives: CryptoService,
						keyPairRecoverer: KeyPairRecoverer
					): Map<String, CryptoStrategies.RecoveredKeyData> {
						return keysData.associate { recoveryRequest ->
							if (recoveryRequest.dataOwnerDetails.dataOwner.id == child.dataOwnerId) {
								recoveryRequest.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
									recoveredKeys = mapOf(
										child.publicKeySpki!!.fingerprintV1() to child.keypair!!
									),
									keyAuthenticity = mapOf(
										child.publicKeySpki!!.fingerprintV1() to false
									)
								)
							} else if (recoveryRequest.dataOwnerDetails.dataOwner.id == parent.dataOwnerId) {
								recoveryRequest.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
									recoveredKeys = mapOf(
										parent.publicKeySpki!!.fingerprintV1() to parent.keypair!!,
										newParentKeySpki.fingerprintV1() to newParentKey
									),
									keyAuthenticity = mapOf(
										parent.publicKeySpki!!.fingerprintV1() to false,
										// recovered key trusted by default -> newParentKey trusted by default
									)
								)
							} else {
								throw IllegalStateException("Unexpected data owner id ${recoveryRequest.dataOwnerDetails.dataOwner.id} in recovery request")
							}
						}
					}

					override suspend fun verifyDelegatePublicKeys(
						delegate: CryptoActorStubWithType,
						publicKeys: List<SpkiHexString>,
						cryptoPrimitives: CryptoService,
						groupId: String?
					): List<SpkiHexString> = verifyDelegatePublicKeys(delegate, publicKeys)
				}
			)
		)
		didCreateNewKey shouldBe true
		// Keys trust should match expected
		val allTrustedKeys = apiWithUntrustedKey.crypto.currentDataOwnerKeys(filterTrustedKeys = true)
		allTrustedKeys shouldHaveSize 2
		allTrustedKeys[child.dataOwnerId].shouldNotBeNull().keys shouldContainExactlyInAnyOrder setOf(newChildKeySpki.fingerprintV1())
		allTrustedKeys[parent.dataOwnerId].shouldNotBeNull().keys shouldContainExactlyInAnyOrder setOf(newParentKeySpki.fingerprintV1())
		val allKeys = apiWithUntrustedKey.crypto.currentDataOwnerKeys(filterTrustedKeys = false)
		allKeys shouldHaveSize 2
		allKeys[child.dataOwnerId].shouldNotBeNull().keys shouldContainExactlyInAnyOrder setOf(child.publicKeySpki!!.fingerprintV1(), newChildKeySpki.fingerprintV1())
		allKeys[parent.dataOwnerId].shouldNotBeNull().keys shouldContainExactlyInAnyOrder setOf(parent.publicKeySpki!!.fingerprintV1(), newParentKeySpki.fingerprintV1())
		// Prev data should be decryptable
		val patientAfter = apiWithUntrustedKey.patient.getPatient(patient.id)
		patientAfter.shouldNotBeNull().note shouldBe "Encrypted note"
		// New data should be encrypted with new trusted key only
		val newPatient = apiWithUntrustedKey.patient.createPatient(
			apiWithUntrustedKey.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "jane",
					lastName = "doe",
					note = "New encrypted note"
				),
				delegates = mapOf(
					parent.dataOwnerId to AccessLevel.Write
				)
			)
		)
		val selfSelfXData2 = apiWithUntrustedKey.crypto.internal.exchangeDataManager.base.getExchangeDataByDelegatorDelegatePair(null, EntityReferenceInGroup(child.dataOwnerId), EntityReferenceInGroup(child.dataOwnerId))
		val selfParentXData2 = apiWithUntrustedKey.crypto.internal.exchangeDataManager.base.getExchangeDataByDelegatorDelegatePair(null, EntityReferenceInGroup(child.dataOwnerId), EntityReferenceInGroup(parent.dataOwnerId))
		selfSelfXData2 shouldHaveSize 2
		selfParentXData2 shouldHaveSize 2
		selfSelfXData2.filter { it.id != selfSelfXData.first().id }.shouldHaveSize(1).single().also { xdata ->
			xdata.exchangeKey.keys shouldContainExactlyInAnyOrder setOf(newChildKeySpki.fingerprintV2())
		}
		selfParentXData2.filter { it.id != selfParentXData.first().id }.shouldHaveSize(1).single().also { xdata ->
			xdata.exchangeKey.keys shouldContainExactlyInAnyOrder setOf(newParentKeySpki.fingerprintV2(), newChildKeySpki.fingerprintV2())
		}
		// Reusing api with untrusted key already in storage loads properly
		val apiWithUntrustedKey2 = CardinalSdk.initialize(
			null,
			baseUrl,
			AuthenticationMethod.UsingCredentials(
				UsernamePassword(
					child.username,
					child.password
				)
			),
			apiWithUntrustedKeysStorage,
			SdkOptions(
				cryptoStrategies = object : CryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						fail("Should not be called")
					}

					override suspend fun recoverAndVerifySelfHierarchyKeys(
						keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
						cryptoPrimitives: CryptoService,
						keyPairRecoverer: KeyPairRecoverer
					): Map<String, CryptoStrategies.RecoveredKeyData> {
						fail("Should not be called")
					}
				}
			)
		)
		val allTrustedKeys2 = apiWithUntrustedKey2.crypto.currentDataOwnerKeys(filterTrustedKeys = true)
		allTrustedKeys2 shouldHaveSize 2
		allTrustedKeys2[child.dataOwnerId].shouldNotBeNull().keys shouldContainExactlyInAnyOrder setOf(newChildKeySpki.fingerprintV1())
		allTrustedKeys2[parent.dataOwnerId].shouldNotBeNull().keys shouldContainExactlyInAnyOrder setOf(newParentKeySpki.fingerprintV1())
		val allKeys2 = apiWithUntrustedKey2.crypto.currentDataOwnerKeys(filterTrustedKeys = false)
		allKeys2 shouldHaveSize 2
		allKeys2[child.dataOwnerId].shouldNotBeNull().keys shouldContainExactlyInAnyOrder setOf(child.publicKeySpki!!.fingerprintV1(), newChildKeySpki.fingerprintV1())
		allKeys2[parent.dataOwnerId].shouldNotBeNull().keys shouldContainExactlyInAnyOrder setOf(parent.publicKeySpki!!.fingerprintV1(), newParentKeySpki.fingerprintV1())
		// Try other hcp not in hierarchy also doesn't use untrusted key
		val unrelatedHcp = createHcpUser()
		val unrelatedHcpApi = unrelatedHcp.api(
			specJob,
			object : CryptoStrategies {
				override suspend fun verifyDelegatePublicKeys(
					delegate: CryptoActorStubWithType,
					publicKeys: List<SpkiHexString>,
					cryptoPrimitives: CryptoService,
					groupId: String?
				): List<SpkiHexString> = verifyDelegatePublicKeys(delegate, publicKeys)
			}
		)
		val patientByUnrelated = unrelatedHcpApi.patient.createPatient(
			unrelatedHcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "alice",
					lastName = "doe",
					note = "Unrelated encrypted note"
				),
				delegates = mapOf(
					parent.dataOwnerId to AccessLevel.Write
				)
			)
		)
		unrelatedHcpApi.crypto.internal.exchangeDataManager.base.getExchangeDataByDelegatorDelegatePair(
			null,
			EntityReferenceInGroup(unrelatedHcp.dataOwnerId),
			EntityReferenceInGroup(parent.dataOwnerId)
		).shouldHaveSize(1).single().also { xdata ->
			xdata.exchangeKey.keys shouldContainExactlyInAnyOrder setOf(newParentKeySpki.fingerprintV2(), unrelatedHcp.publicKeySpki!!.fingerprintV2())
		}
	}
})
