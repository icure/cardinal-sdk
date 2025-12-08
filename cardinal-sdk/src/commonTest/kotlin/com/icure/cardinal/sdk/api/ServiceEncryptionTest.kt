package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.maps.shouldBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ServiceEncryptionTest : StringSpec({
	lateinit var hcp: DataOwnerDetails
	lateinit var sdk: CardinalSdk
	lateinit var patient: DecryptedPatient
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
		hcp = createHcpUser()
		sdk = hcp.api(specJob)
		patient = sdk.patient.createPatient(sdk.patient.withEncryptionMetadata(DecryptedPatient(uuid())))
	}

	fun checkDecryptedServicesContent(
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
						binaryValue = null
					) shouldBe expectedContent.copy(
						compoundValue = null,
						binaryValue = null
					)
					actualContent.binaryValue?.toList() shouldBe expectedContent.binaryValue?.toList()
					checkDecryptedServicesContent(
						actualContent.compoundValue.orEmpty(),
						expectedContent.compoundValue.orEmpty()
					)
				}
			}
		}
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

	fun verifyHasCorrectlyEncryptedCompoundService(
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

	fun verifyHasCorrectlyEncryptedMultiContentCompoundService(
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

	fun verifyHasCorrectlyEncryptedDeepCompoundService(
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

	fun addToServiceNotes(
		service: EncryptedService
	): EncryptedService =
		service.copy(
			notes = service.notes + Annotation(id = "some note", markdown = mapOf("en" to "don't do this"))
		)

	fun addToServiceContent(
		service: EncryptedService
	): EncryptedService = service.copy(
		content = service.content.also { it.shouldBeEmpty() } + Pair(
			"xx",
			/*TODO
			 * adding a compound content may actually be allowed -> BAD
			 * If we figure out an easy way of doing a check we can improve this, otherwise we just accept that this can't
			 * be detected (especially with no decryption context) and just write in the documentation that the validation
			 * is done on a best effor basis (note it is actually already best effort, if you use different manifests in
			 * different parts of the app validation is going to be useless...)
			 */
			EncryptedContent(booleanValue = false)
		)
	)

	fun copyWithLegalChanges(service: EncryptedService): EncryptedService =
		service.copy(
			codes = service.codes + CodeStub("type|code|1", type = "type", code = "code", version = "1"),
			content = service.content.mapValues { (_, content) ->
				content.copy(
					compoundValue = content.compoundValue?.map { copyWithLegalChanges(it) }
				)
			}
		)

	suspend fun checkEncryptedValidation(contact: EncryptedContact) {
		shouldThrow<EntityEncryptionException> {
			sdk.contact.encrypted.modifyContact(contact.copy(descr = "Something"))
		}
		listOf(
			::addToServiceNotes,
			::addToServiceContent
		).forEach { doIllegalModify ->
			contact.services.indices.forEach { currModifyServiceIndex ->
				val modified = contact.copy(services = contact.services.mapIndexed { i, service ->
					if (i == currModifyServiceIndex) {
						modifyOneNestedService(service, doIllegalModify)
					} else service
				}.toSet())
				shouldThrow<EntityEncryptionException> {
					sdk.contact.encrypted.modifyContact(modified)
				}
			}
		}
		val legalChanges = contact.copy(
			codes = contact.codes + CodeStub("type|code|1", type = "type", code = "code", version = "1"),
			services = contact.services.map { copyWithLegalChanges(it) }.toSet()
		)
		sdk.contact.encrypted.modifyContact(legalChanges).rev shouldNotBe legalChanges.rev // It should work
	}

	"Content of service should be encrypted in full if it contains non compound data".config(enabled = DEFAULT_ENABLED) {
		val contact = sdk.contact.createContact(
			sdk.contact.withEncryptionMetadata(
                DecryptedContact(
                    id = uuid(),
                    services = setOf(simpleService1, simpleService2, simpleService3, simpleService4)
                ),
                patient
			)
		)
		val encryptedContact = sdk.contact.encrypted.getContact(contact.id).shouldNotBeNull()
		encryptedContact.services.forEach { service ->
			service.content.shouldBeEmpty()
		}
		checkDecryptedServicesContent(
			sdk.contact.getContact(contact.id).shouldNotBeNull().services,
			listOf(simpleService1, simpleService2, simpleService3, simpleService4)
		)
		checkEncryptedValidation(encryptedContact)
	}

	"Content of service should be encrypted recursively on compound data".config(enabled = DEFAULT_ENABLED) {
		val contact = sdk.contact.createContact(
			sdk.contact.withEncryptionMetadata(
                DecryptedContact(
                    id = uuid(),
                    services = setOf(compoundService, multiContentCompound, deepCompound)
                ),
                patient
			)
		)
		val encryptedContact = sdk.contact.encrypted.getContact(contact.id).shouldNotBeNull()
		verifyHasCorrectlyEncryptedCompoundService(encryptedContact)
		verifyHasCorrectlyEncryptedMultiContentCompoundService(encryptedContact)
		verifyHasCorrectlyEncryptedDeepCompoundService(encryptedContact)
		checkDecryptedServicesContent(
			sdk.contact.getContact(contact.id).shouldNotBeNull().services,
			listOf(compoundService, multiContentCompound, deepCompound)
		)
		checkEncryptedValidation(encryptedContact)
	}

	"A mix of compund and simple service should each have their content encrypted as needed".config(enabled = DEFAULT_ENABLED) {
		val contact = sdk.contact.createContact(
			sdk.contact.withEncryptionMetadata(
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
		val encryptedContact = sdk.contact.encrypted.getContact(contact.id).shouldNotBeNull()
		verifyHasCorrectlyEncryptedCompoundService(encryptedContact)
		verifyHasCorrectlyEncryptedMultiContentCompoundService(encryptedContact)
		verifyHasCorrectlyEncryptedDeepCompoundService(encryptedContact)
		encryptedContact.services.filter { it.id in simpleServicesIds }.forEach {
			it.content.shouldBeEmpty()
		}
		checkDecryptedServicesContent(
			sdk.contact.getContact(contact.id).shouldNotBeNull().services,
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
		checkEncryptedValidation(encryptedContact)
	}
})
