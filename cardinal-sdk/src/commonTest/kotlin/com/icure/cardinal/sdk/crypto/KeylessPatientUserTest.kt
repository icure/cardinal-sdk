package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createUserFromExistingPatient
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.internal
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class KeylessPatientUserTest : StringSpec(
	{
		val specJob = autoCancelJob()

		lateinit var hcp: DataOwnerDetails
		lateinit var hcpApi: CardinalSdk
		lateinit var patientDetails: DataOwnerDetails

		beforeSpec {
			initializeTestEnvironment()

			hcp = createHcpUser()
			hcpApi = hcp.api(specJob)
			patientDetails = createUserFromExistingPatient(
				hcpApi.patient.createPatient(
					hcpApi.patient.withEncryptionMetadata(
						DecryptedPatient(
							id = defaultCryptoService.strongRandom.randomUUID(),
							firstName = "John",
							lastName = "Doe",
							note = "This note will not be visible to the patient"
						)
					)
				).shouldNotBeNull(),
				true
			)
		}

		suspend fun getPatientApi(): Pair<CardinalSdk, RawDecryptedExchangeData> {
			val api = patientDetails.api(
				specJob,
				object : CryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						return CryptoStrategies.KeyGenerationRequestResult.Keyless
					}
				},
			)
			val exchangeData = api.crypto.keylessCreateExchangeDataTo(hcp.dataOwnerId).shouldNotBeNull()
			return api to exchangeData
		}

		suspend fun createCalendarItem(patientApi: CardinalSdk, patient: Patient, patientUser: User): DecryptedCalendarItem {
			val startTime = currentEpochMs() + Math.random().toInt()
			return patientApi.calendarItem.createCalendarItem(
				patientApi.calendarItem.withEncryptionMetadata(
					base = DecryptedCalendarItem(
						id = defaultCryptoService.strongRandom.randomUUID(),
						title = "My appointment",
						startTime = startTime,
						endTime = startTime + 3600000, // 1 hour later
						details = "This note will not be visible to the patient"
					),
					patient = patient,
					user = patientUser,
					secretId = SecretIdUseOption.UseNone,
					alternateRootDelegateId = hcp.dataOwnerId
				)
			)

		}

		"A keyless API should not allow the creation of encrypted data if no exchange data is provided" {
			val patientApi = patientDetails.api(
				specJob,
				object : CryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						return CryptoStrategies.KeyGenerationRequestResult.Keyless
					}
				},
			)

			val patientUser = patientApi.user.getCurrentUser()
			val patient = patientApi.patient.encrypted.getPatient(patientUser.dataOwnerId).shouldNotBeNull()

			shouldThrow<IllegalStateException> {
				createCalendarItem(patientApi, patient, patientUser)
			}
		}

		"A keyless API should allow creation of data and retrieval by delegator and delegate" {
			val (patientApi, exchangeData) = getPatientApi()

			// Arrange: initialize test data
			val patientUser = patientApi.user.getCurrentUser()
			val patient = patientApi.patient.encrypted.getPatient(patientUser.dataOwnerId).shouldNotBeNull()

			val ci = createCalendarItem(patientApi, patient, patientUser)

			// Patient retrieves the calendar item
			val retrievedByPatient = patientApi.calendarItem.getCalendarItem(ci.id)!!
			retrievedByPatient.title shouldBe ci.title
			patientApi.calendarItem.decryptPatientIdOf(retrievedByPatient).map { it.entityId } shouldBe listOf(patient.id)

			// HCP retrieves the calendar item
			val retrievedByHcp = hcpApi.calendarItem.getCalendarItem(ci.id)!!
			retrievedByHcp.title shouldBe ci.title
			hcpApi.calendarItem.decryptPatientIdOf(retrievedByHcp).map { it.entityId } shouldBe listOf(patient.id)
		}

		"A keyless API should allow retrieval in new instance after exchange data injection" {
			// Arrange: initialize test data
			val (patientApi, exchangeData) = getPatientApi()

			val patientUser = patientApi.user.getCurrentUser()
			val patient = patientApi.patient.encrypted.getPatient(patientUser.dataOwnerId).shouldNotBeNull()

			val ci = createCalendarItem(patientApi, patient, patientUser)

			val retrievedByPatient = patientApi.calendarItem.getCalendarItem(ci.id)!!
			retrievedByPatient.title shouldBe ci.title

			// Simulate a new API instance (new session)
			val newPatientApi = patientDetails.api(
				specJob,
				object : CryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						return CryptoStrategies.KeyGenerationRequestResult.Keyless
					}
				},
			)

			// Before injecting exchange data, retrieval should fail
			shouldThrow<RequestStatusException> {
				newPatientApi.calendarItem.getCalendarItem(ci.id)
			}.statusCode shouldBe 403 // Forbidden

			newPatientApi.crypto.injectExchangeData(
				patientDetails.groupId,
				listOf(
					ExchangeDataInjectionDetails(
						exchangeDataId = exchangeData.exchangeDataId,
						exchangeKey = exchangeData.exchangeKey,
						accessControlSecret = exchangeData.accessControlSecret,
						sharedSignatureKey = exchangeData.sharedSignatureKey,
						verified = false,
					),
				),
				false,
			)

			// After injection, retrieval should succeed
			val retrievedByNewApi = newPatientApi.calendarItem.getCalendarItem(ci.id)
			retrievedByNewApi.shouldNotBeNull()
			retrievedByNewApi.title shouldBe ci.title
			newPatientApi.calendarItem.decryptPatientIdOf(retrievedByNewApi).map { it.entityId } shouldBe listOf(patient.id)
		}

		"Keyless SDks do not support the re-encryption of injected exchange data" {
			val (patientApi, exchangeData) = getPatientApi()
			val patientUser = patientApi.user.getCurrentUser()
			val patient = patientApi.patient.encrypted.getPatient(patientUser.dataOwnerId).shouldNotBeNull()
			val ci = createCalendarItem(patientApi, patient, patientUser)

			val newCryptoStrategies = object : CryptoStrategies {
				override suspend fun generateNewKeyForDataOwner(
					self: DataOwnerWithType,
					cryptoPrimitives: CryptoService,
				): CryptoStrategies.KeyGenerationRequestResult {
					// Simulate a new key by returning Keyless (or adapt if keyful is needed)
					return CryptoStrategies.KeyGenerationRequestResult.Keyless
				}
			}

			val newPatientApiWithKeyAndInjected = patientDetails.api(
				specJob,
				object : CryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						return CryptoStrategies.KeyGenerationRequestResult.Keyless
					}
				},
			)

			shouldThrow<IllegalStateException> {
				newPatientApiWithKeyAndInjected.crypto.injectExchangeData(
					patientDetails.groupId,
					listOf(
						ExchangeDataInjectionDetails(
							exchangeDataId = exchangeData.exchangeDataId,
							exchangeKey = exchangeData.exchangeKey,
							accessControlSecret = exchangeData.accessControlSecret,
							sharedSignatureKey = exchangeData.sharedSignatureKey,
							verified = false,
						),
					),
					true,
				)
			}
		}

		"Should allow re-encryption of exchange data as unverified on injection" {
			val (patientApi, exchangeData) = getPatientApi()
			val patientUser = patientApi.user.getCurrentUser()
			val patient = patientApi.patient.encrypted.getPatient(patientUser.dataOwnerId).shouldNotBeNull()
			val ci = createCalendarItem(patientApi, patient, patientUser)

			val volatileStorageFacade = VolatileStorageFacade()
			val newPatientApiWithKeyAndInjected = patientDetails.apiWithStorage(baseJob = specJob, storageFacade = volatileStorageFacade,)

			// Inject exchange data
			newPatientApiWithKeyAndInjected.crypto.injectExchangeData(
				patientDetails.groupId,
				listOf(
					ExchangeDataInjectionDetails(
						exchangeDataId = exchangeData.exchangeDataId,
						exchangeKey = exchangeData.exchangeKey,
						accessControlSecret = exchangeData.accessControlSecret,
						sharedSignatureKey = exchangeData.sharedSignatureKey,
						verified = false,
					),
				),
				true,
			)

			val newExchangeData = newPatientApiWithKeyAndInjected.crypto.internal.exchangeDataManager.getOrCreateEncryptionDataTo(null,
				EntityReferenceInGroup(hcp.dataOwnerId, null), false, false)
			// The exchange data id should be different (re-encrypted)
			(newExchangeData?.exchangeData?.id == exchangeData.exchangeDataId) shouldBe false

			// Now, simulate a new API instance with the same key (no injected exchange data)
			val newPatientApiWithKey = patientDetails.apiWithStorage(baseJob = specJob, storageFacade = volatileStorageFacade,)

			val retrievedByNewApi = newPatientApiWithKey.calendarItem.getCalendarItem( ci.id)
			retrievedByNewApi.shouldNotBeNull()
			retrievedByNewApi.title shouldBe ci.title
			newPatientApiWithKey.calendarItem.decryptPatientIdOf(retrievedByNewApi).map { it.entityId } shouldBe listOf(patient.id)

			val newExchangeData2 = newPatientApiWithKeyAndInjected.crypto.internal.exchangeDataManager.getOrCreateEncryptionDataTo(null,
				EntityReferenceInGroup(hcp.dataOwnerId, null), false, false)

			(newExchangeData2?.exchangeData?.id == exchangeData.exchangeDataId) shouldBe false
		}

		"Should allow re-encryption of exchange data as verified on injection" {
			val (patientApi, exchangeData) = getPatientApi()
			val patientUser = patientApi.user.getCurrentUser()
			val patient = patientApi.patient.encrypted.getPatient(patientUser.dataOwnerId).shouldNotBeNull()
			val ci = createCalendarItem(patientApi, patient, patientUser)

			val volatileStorageFacade = VolatileStorageFacade()
			val newPatientApiWithKeyAndInjected = patientDetails.apiWithStorage(baseJob = specJob, storageFacade = volatileStorageFacade,)

			// Inject exchange data
			newPatientApiWithKeyAndInjected.crypto.injectExchangeData(
				patientDetails.groupId,
				listOf(
					ExchangeDataInjectionDetails(
						exchangeDataId = exchangeData.exchangeDataId,
						exchangeKey = exchangeData.exchangeKey,
						accessControlSecret = exchangeData.accessControlSecret,
						sharedSignatureKey = exchangeData.sharedSignatureKey,
						verified = true,
					),
				),
				true,
			)

			val newExchangeData = newPatientApiWithKeyAndInjected.crypto.internal.exchangeDataManager.getOrCreateEncryptionDataTo(null,
				EntityReferenceInGroup(hcp.dataOwnerId, null), false, false)
			// The exchange data id should be different (re-encrypted)
			(newExchangeData?.exchangeData?.id == exchangeData.exchangeDataId) shouldBe true

			val retrievedByNewApi = newPatientApiWithKeyAndInjected.calendarItem.getCalendarItem( ci.id)
			retrievedByNewApi.shouldNotBeNull()
			retrievedByNewApi.title shouldBe ci.title
			newPatientApiWithKeyAndInjected.calendarItem.decryptPatientIdOf(retrievedByNewApi).map { it.entityId } shouldBe listOf(patient.id)
		}

	}
)
