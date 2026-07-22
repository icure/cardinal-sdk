package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.embed.Content
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.options.CustomisedSdkOptions
import com.icure.cardinal.sdk.options.EncryptedFieldsOptions
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.maps.shouldBeEmpty
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class ServiceEncryptionTest : StringSpec({
	lateinit var hcp: DataOwnerDetails
	lateinit var sdkLegacy: CardinalSdk
	lateinit var sdkDefault: CardinalSdk
	lateinit var patient: DecryptedPatient
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
		hcp = createHcpUser()
		sdkLegacy = hcp.api(specJob, customisedSdkOptions = CustomisedSdkOptions(encryptedFieldsOptions = EncryptedFieldsOptions.Legacy))
		sdkDefault = hcp.api(specJob)
		patient = sdkLegacy.patient.createPatient(sdkLegacy.patient.withEncryptionMetadata(DecryptedPatient(uuid())))
	}

	suspend fun checkDecryptedServicesContent(
		contactId: String,
		expectedServices: List<DecryptedService>
	) {
		fun checkOne(
			actualDecryptedServices: Collection<DecryptedService>,
			expectedServices: List<DecryptedService>
		) {
			actualDecryptedServices.map { it.id } shouldContainExactlyInAnyOrder expectedServices.map { it.id }
			expectedServices.forEach { expectedService ->
				actualDecryptedServices.find { it.id == expectedService.id }.shouldNotBeNull().also { actualService ->
					actualService.content.forEach { (key, actualContent) ->
						val expectedContent = expectedService.content.getValue(key)
						actualContent.copy(
							compoundValue = null,
							binaryValue = null,
							encryptedSelf = null
						) shouldBe expectedContent.copy(
							compoundValue = null,
							binaryValue = null,
							encryptedSelf = null
						)
						actualContent.binaryValue?.toList() shouldBe expectedContent.binaryValue?.toList()
						checkOne(
							actualContent.compoundValue.orEmpty(),
							expectedContent.compoundValue.orEmpty()
						)
					}
				}
			}
		}
		checkOne(sdkLegacy.contact.getContact(contactId).shouldNotBeNull().services, expectedServices)
		checkOne(sdkDefault.contact.getContact(contactId).shouldNotBeNull().services, expectedServices)

	}

	// Compound data and other data in the same service is encrypted as a simple service
	val simpleService1 = DecryptedService(
		id = "service1",
		content = mapOf(
			"xx" to DecryptedContent(
				compoundValue = listOf(
					DecryptedService(
						id = "sub1",
						content = mapOf(
							"xx" to DecryptedContent(
								numberValue = 1.0
							)
						)
					)
				),
				booleanValue = true
			)
		)
	)
	val simpleService2 = DecryptedService(
		id = "service2",
		content = mapOf(
			"it" to DecryptedContent(
				stringValue = "ciao"
			),
			"en" to DecryptedContent(
				stringValue = "hello"
			)
		)
	)
	val simpleService3 = DecryptedService(
		id = "service3",
		content = mapOf(
			"xx" to DecryptedContent(
				numberValue = 1.0,
				binaryValue = byteArrayOf(1, 2, 3)
			)
		)
	)
	// A mix of simple and compound services in the content map will be encrypted as a simple service
	val simpleService4 = DecryptedService(
		id = "service4",
		content = mapOf(
			"xx" to DecryptedContent(
				numberValue = 1.0,
				binaryValue = byteArrayOf(1, 2, 3)
			),
			"yy" to DecryptedContent(
				compoundValue = listOf(
					DecryptedService(
						id = "sub1",
						content = mapOf(
							"xx" to DecryptedContent(
								numberValue = 1.0
							)
						)
					)
				)
			),
			"zz" to DecryptedContent() // An empty content should be treated as simple and not as compound
		)
	)

	val simpleServicesIds = setOf(simpleService1.id, simpleService2.id, simpleService3.id, simpleService4.id)

	val compoundService = DecryptedService(
		id = "compound",
		content = mapOf(
			"xx" to DecryptedContent(
				compoundValue = listOf(
					DecryptedService(
						id = "compound.nested1",
						content = mapOf(
							"xx" to DecryptedContent(
								numberValue = 1.2
							)
						)
					),
					DecryptedService(
						id = "compound.nested2",
						content = mapOf(
							"yz" to DecryptedContent(
								fuzzyDateValue = 20200404
							)
						)
					)
				)
			)
		)
	)

	fun legacyVerifyHasCorrectlyEncryptedCompoundService(
		contact: EncryptedContact
	) {
		val actualService = contact.services.find { it.id == compoundService.id }.shouldNotBeNull()
		val subservices = actualService.content.getValue("xx").compoundValue.shouldNotBeNull()
		subservices.map { it.id }.toSet() shouldBe setOf("compound.nested1", "compound.nested2")
		subservices.forEach { it.content.shouldBeEmpty() }
	}

	// If all contents are only compound then each content is encrypted as a compound
	val multiContentCompound = DecryptedService(
		id = "multiContentCompound",
		content = mapOf(
			"xx" to DecryptedContent(
				compoundValue = listOf(
					DecryptedService(
						id = "compound.xx.nested1",
						content = mapOf(
							"xx" to DecryptedContent(
								numberValue = 1.2
							)
						)
					),
					DecryptedService(
						id = "compound.xx.nested2",
						content = mapOf(
							"yz" to DecryptedContent(
								fuzzyDateValue = 20200404
							)
						)
					)
				)
			),
			"yy" to DecryptedContent(
				compoundValue = listOf(
					DecryptedService(
						id = "compound.yy.nested1",
						content = mapOf(
							"xx" to DecryptedContent(
								numberValue = 1.3
							)
						)
					),
					DecryptedService(
						id = "compound.yy.nested2",
						content = mapOf(
							"yz" to DecryptedContent(
								fuzzyDateValue = 20200405
							)
						)
					)
				)
			)
		)
	)

	fun legacyVerifyHasCorrectlyEncryptedMultiContentCompoundService(
		contact: EncryptedContact
	) {
		val actualService = contact.services.find { it.id == multiContentCompound.id }.shouldNotBeNull()
		val subservicesXx = actualService.content.getValue("xx").compoundValue.shouldNotBeNull()
		val subservicesYy = actualService.content.getValue("yy").compoundValue.shouldNotBeNull()
		subservicesXx.map { it.id }.toSet() shouldBe setOf("compound.xx.nested1", "compound.xx.nested2")
		subservicesYy.map { it.id }.toSet() shouldBe setOf("compound.yy.nested1", "compound.yy.nested2")
		(subservicesXx + subservicesYy).forEach { it.content.shouldBeEmpty() }
	}

	val deepCompound = DecryptedService(
		id = "deepCompound",
		content = mapOf(
			"xx" to DecryptedContent(
				compoundValue = listOf(
					DecryptedService(
						id = "compound.deep1",
						content = mapOf(
							"xx" to DecryptedContent(
								compoundValue = listOf(
									DecryptedService(
										id = "compound.deep1.nested1",
										content = mapOf(
											"xx" to DecryptedContent(
												booleanValue = true
											)
										)
									),
									DecryptedService(
										id = "compound.deep1.nested2",
										content = mapOf(
											"yz" to DecryptedContent(
												documentId = uuid()
											)
										)
									)
								)
							)
						)
					),
					DecryptedService(
						id = "compound.deep2",
						content = mapOf(
							"yy" to DecryptedContent(
								stringValue = "oplà"
							)
						)
					)
				)
			)
		)
	)

	fun legacyVerifyHasCorrectlyEncryptedDeepCompoundService(
		contact: EncryptedContact
	) {
		val actualService = contact.services.find { it.id == deepCompound.id }.shouldNotBeNull()
		val subservices = actualService.content.getValue("xx").compoundValue.shouldNotBeNull()
		val deepSubservices = subservices.find { it.id == "compound.deep1" }.shouldNotBeNull()
			.content.getValue("xx").compoundValue.shouldNotBeNull()
		subservices.find { it.id == "compound.deep2" }.shouldNotBeNull().also {
			it.content.shouldBeEmpty()
		}
		deepSubservices.forEach {
			it.content.shouldBeEmpty()
		}
	}

	fun Content.isCompound(): Boolean =
		!compoundValue.isNullOrEmpty() &&
			stringValue == null &&
			numberValue == null &&
			booleanValue == null &&
			instantValue == null &&
			fuzzyDateValue == null &&
			binaryValue == null &&
			documentId == null &&
			measureValue == null &&
			medicationValue == null &&
			timeSeries == null &&
			ratio.isNullOrEmpty() &&
			range.isNullOrEmpty()

	fun modifyOneNestedService(
		service: EncryptedService,
		modifyService: (EncryptedService) -> EncryptedService
	): EncryptedService =
		if (service.content.values.firstOrNull()?.isCompound() == true) {
			service.copy(
				content = service.content.toList().mapIndexed { i, entry ->
					if (i == 0) {
						entry.first to entry.second.copy(
							compoundValue = entry.second.compoundValue!!.mapIndexed { j, subservice ->
								if (j == 0) {
									modifyOneNestedService(subservice, modifyService)
								} else subservice
							}
						)
					} else entry
				}.toMap()
			)
		} else modifyService(service)

	"Legacy content encryption - Content of service should be encrypted in full if it contains non compound data".config(enabled = DEFAULT_ENABLED) {
		val contact = sdkLegacy.contact.createContact(
			sdkLegacy.contact.withEncryptionMetadata(
				DecryptedContact(
					id = uuid(),
					services = setOf(simpleService1, simpleService2, simpleService3, simpleService4)
				),
				patient
			)
		)
		val encryptedContact = sdkLegacy.contact.encrypted.getContact(contact.id).shouldNotBeNull()
		encryptedContact.services.forEach { service ->
			service.content.shouldBeEmpty()
		}
		checkDecryptedServicesContent(
			contact.id,
			listOf(simpleService1, simpleService2, simpleService3, simpleService4)
		)
	}

	"Legacy content encryption - Content of service should be encrypted recursively on compound data".config(enabled = DEFAULT_ENABLED) {
		val contact = sdkLegacy.contact.createContact(
			sdkLegacy.contact.withEncryptionMetadata(
				DecryptedContact(
					id = uuid(),
					services = setOf(compoundService, multiContentCompound, deepCompound)
				),
				patient
			)
		)
		val encryptedContact = sdkLegacy.contact.encrypted.getContact(contact.id).shouldNotBeNull()
		legacyVerifyHasCorrectlyEncryptedCompoundService(encryptedContact)
		legacyVerifyHasCorrectlyEncryptedMultiContentCompoundService(encryptedContact)
		legacyVerifyHasCorrectlyEncryptedDeepCompoundService(encryptedContact)
		checkDecryptedServicesContent(
			contact.id,
			listOf(compoundService, multiContentCompound, deepCompound)
		)
	}

	"Legacy content encryption - A mix of compound and simple service should each have their content encrypted as needed".config(enabled = DEFAULT_ENABLED) {
		val contact = sdkLegacy.contact.createContact(
			sdkLegacy.contact.withEncryptionMetadata(
				DecryptedContact(
					id = uuid(),
					services = setOf(
						compoundService,
						multiContentCompound,
						deepCompound,
						simpleService1,
						simpleService2,
						simpleService3,
						simpleService4
					)
				),
				patient
			)
		)
		val encryptedContact = sdkLegacy.contact.encrypted.getContact(contact.id).shouldNotBeNull()
		legacyVerifyHasCorrectlyEncryptedCompoundService(encryptedContact)
		legacyVerifyHasCorrectlyEncryptedMultiContentCompoundService(encryptedContact)
		legacyVerifyHasCorrectlyEncryptedDeepCompoundService(encryptedContact)
		encryptedContact.services.filter { it.id in simpleServicesIds }.forEach {
			it.content.shouldBeEmpty()
		}
		checkDecryptedServicesContent(
			contact.id,
			listOf(
				compoundService,
				multiContentCompound,
				deepCompound,
				simpleService1,
				simpleService2,
				simpleService3,
				simpleService4
			)
		)
	}

	fun defaultVerifyHasCorrectlyEncryptedServiceContent(
		actualService: EncryptedService,
		expectedService: DecryptedService
	) {
		actualService.content.keys shouldBe expectedService.content.keys
		expectedService.content.forEach { (key, expectedContent) ->
			val actualContent = actualService.content.getValue(key)
			// All fields other than compoundValue are always encrypted in full, regardless of whether the
			// content is a simple value, a compound value, or a mix of the two.
			actualContent.stringValue.shouldBeNull()
			actualContent.numberValue.shouldBeNull()
			actualContent.booleanValue.shouldBeNull()
			actualContent.instantValue.shouldBeNull()
			actualContent.fuzzyDateValue.shouldBeNull()
			actualContent.binaryValue.shouldBeNull()
			actualContent.documentId.shouldBeNull()
			actualContent.measureValue.shouldBeNull()
			actualContent.medicationValue.shouldBeNull()
			actualContent.timeSeries.shouldBeNull()
			actualContent.ratio.shouldBeNull()
			actualContent.range.shouldBeNull()
			if (
				expectedContent.stringValue != null ||
				expectedContent.numberValue != null ||
				expectedContent.booleanValue != null ||
				expectedContent.instantValue != null ||
				expectedContent.fuzzyDateValue != null ||
				expectedContent.binaryValue != null ||
				expectedContent.documentId != null ||
				expectedContent.measureValue != null ||
				expectedContent.medicationValue != null ||
				expectedContent.timeSeries != null ||
				expectedContent.ratio != null ||
				expectedContent.range != null
			) {
				actualContent.encryptedSelf.shouldNotBeNull()
			} else {
				actualContent.encryptedSelf.shouldBeNull()
			}
			val expectedCompoundValue = expectedContent.compoundValue
			if (expectedCompoundValue.isNullOrEmpty()) {
				actualContent.compoundValue shouldBe expectedCompoundValue
			} else {
				val actualCompoundValue = actualContent.compoundValue.shouldNotBeNull()
				actualCompoundValue.map { it.id }.toSet() shouldBe expectedCompoundValue.map { it.id }.toSet()
				expectedCompoundValue.forEach { expectedSubservice ->
					val actualSubservice = actualCompoundValue.find { it.id == expectedSubservice.id }.shouldNotBeNull()
					defaultVerifyHasCorrectlyEncryptedServiceContent(actualSubservice, expectedSubservice)
				}
			}
		}
	}

	"Default content encryption - A content compound value should be always encrypted recursively while all other parts of the service content should be encrypted in full".config(enabled = DEFAULT_ENABLED) {
		val contact = sdkDefault.contact.createContact(
			sdkDefault.contact.withEncryptionMetadata(
				DecryptedContact(
					id = uuid(),
					services = setOf(
						compoundService,
						multiContentCompound,
						deepCompound,
						simpleService1,
						simpleService2,
						simpleService3,
						simpleService4
					)
				),
				patient
			)
		)
		val encryptedContact = sdkDefault.contact.encrypted.getContact(contact.id).shouldNotBeNull()
		sdkDefault.contact.getContact(contact.id).shouldNotBeNull()
		listOf(
			compoundService,
			multiContentCompound,
			deepCompound,
			simpleService1,
			simpleService2,
			simpleService3,
			simpleService4
		).forEach { expectedService ->
			val actualService = encryptedContact.services.find { it.id == expectedService.id }.shouldNotBeNull()
			defaultVerifyHasCorrectlyEncryptedServiceContent(actualService, expectedService)
		}
		checkDecryptedServicesContent(
			contact.id,
			listOf(
				compoundService,
				multiContentCompound,
				deepCompound,
				simpleService1,
				simpleService2,
				simpleService3,
				simpleService4
			)
		)
	}
})
