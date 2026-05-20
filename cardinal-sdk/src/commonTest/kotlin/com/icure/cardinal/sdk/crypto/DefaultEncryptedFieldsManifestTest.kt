package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.PropertyTypeStub
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ParticipantType
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.CareTeamMemberType
import com.icure.cardinal.sdk.model.embed.ContactParticipant
import com.icure.cardinal.sdk.model.embed.ContractChangeType
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.DecryptedPartnership
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.MhcSignatureType
import com.icure.cardinal.sdk.model.embed.Partnership
import com.icure.cardinal.sdk.model.embed.PartnershipStatus
import com.icure.cardinal.sdk.model.embed.PartnershipType
import com.icure.cardinal.sdk.model.embed.PatientHealthCarePartyType
import com.icure.cardinal.sdk.model.embed.PersonalStatus
import com.icure.cardinal.sdk.model.embed.ReferralPeriod
import com.icure.cardinal.sdk.model.embed.SuspensionReason
import com.icure.cardinal.sdk.model.embed.TelecomType
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class DefaultEncryptedFieldsManifestTest : StringSpec({
	val specJob = autoCancelJob()
	lateinit var hcpApi: CardinalSdk
	lateinit var testLinkedPatient: DecryptedPatient

	beforeSpec {
		initializeTestEnvironment()
		hcpApi = createHcpUser(roles = setOf("TOPIC_MANAGER", "BASIC_DATA_OWNER", "LEGACY_MESSAGE_MANAGER")).api(specJob)
		testLinkedPatient = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(uuid(), firstName = "Gino")
			)
		)
	}

	"Default access log encrypted fields configuration should be valid" {
		val decryptedAccessLog = DecryptedAccessLog(
			id = uuid(),
			objectId = uuid(),
			detail = uuid(),
			accessType = uuid()
		)
		hcpApi.accessLog.createAccessLog(
			hcpApi.accessLog.withEncryptionMetadata(decryptedAccessLog, testLinkedPatient)
		)
		val retrievedAccessLog = hcpApi.accessLog.getAccessLog(decryptedAccessLog.id).shouldNotBeNull()
		val encryptedAccessLog = hcpApi.accessLog.encrypted.getAccessLog(decryptedAccessLog.id).shouldNotBeNull()
		retrievedAccessLog.objectId shouldBe decryptedAccessLog.objectId
		retrievedAccessLog.detail shouldBe decryptedAccessLog.detail
		retrievedAccessLog.accessType shouldBe decryptedAccessLog.accessType
		encryptedAccessLog.objectId shouldBe null
		encryptedAccessLog.detail shouldBe null
		encryptedAccessLog.encryptedSelf shouldNotBe null
		encryptedAccessLog.accessType shouldBe decryptedAccessLog.accessType
	}

	"Default calendar item encrypted fields configuration should be valid" {
		val decryptedCalendarItem = DecryptedCalendarItem(
			id = uuid(),
			details = uuid(),
			title = uuid(),
			phoneNumber = uuid(),
			addressText = uuid(),
			calendarItemTypeId = uuid(),
			address = DecryptedAddress(city = "TestCity"),
			meetingTags = setOf(
				DecryptedCalendarItemTag(
					code = uuid(),
					date = 20240101L,
					userId = uuid(),
					userName = "TestUser"
				)
			)
		)
		hcpApi.calendarItem.createCalendarItem(
			hcpApi.calendarItem.withEncryptionMetadata(decryptedCalendarItem, testLinkedPatient)
		)
		val retrievedCalendarItem = hcpApi.calendarItem.getCalendarItem(decryptedCalendarItem.id).shouldNotBeNull()
		val encryptedCalendarItem = hcpApi.calendarItem.encrypted.getCalendarItem(decryptedCalendarItem.id).shouldNotBeNull()
		retrievedCalendarItem.details shouldBe decryptedCalendarItem.details
		retrievedCalendarItem.title shouldBe decryptedCalendarItem.title
		retrievedCalendarItem.phoneNumber shouldBe decryptedCalendarItem.phoneNumber
		retrievedCalendarItem.addressText shouldBe decryptedCalendarItem.addressText
		retrievedCalendarItem.calendarItemTypeId shouldBe decryptedCalendarItem.calendarItemTypeId
		retrievedCalendarItem.address?.city shouldBe "TestCity"
		val decryptedTag = decryptedCalendarItem.meetingTags.first()
		val retrievedTag = retrievedCalendarItem.meetingTags.first()
		retrievedTag.code shouldBe decryptedTag.code
		retrievedTag.date shouldBe decryptedTag.date
		retrievedTag.userId shouldBe decryptedTag.userId
		retrievedTag.userName shouldBe decryptedTag.userName
		encryptedCalendarItem.details shouldBe null
		encryptedCalendarItem.title shouldBe null
		encryptedCalendarItem.phoneNumber shouldBe null
		encryptedCalendarItem.addressText shouldBe null
		encryptedCalendarItem.address shouldBe null
		encryptedCalendarItem.calendarItemTypeId shouldBe decryptedCalendarItem.calendarItemTypeId
		encryptedCalendarItem.encryptedSelf shouldNotBe null
		// meetingTags[].*: all fields nullable → all null in encrypted, encryptedSelf set
		val encryptedTag = encryptedCalendarItem.meetingTags.first()
		encryptedTag.code shouldBe null
		encryptedTag.date shouldBe null
		encryptedTag.userId shouldBe null
		encryptedTag.userName shouldBe null
		encryptedTag.encryptedSelf shouldNotBe null
	}

	"Default contact encrypted fields configuration should be valid" {
		val decryptedContact = DecryptedContact(
			id = uuid(),
			descr = uuid(),
			location = uuid(),
			openingDate = 20240101L,
			encounterLocation = DecryptedAddress(city = "Brussels"),
			notes = listOf(Annotation(id = uuid(), markdown = mapOf("en" to "contact note"))),
			participantList = listOf(ContactParticipant(type = ParticipantType.Attender, hcpId = uuid()))
		)
		hcpApi.contact.createContact(
			hcpApi.contact.withEncryptionMetadata(decryptedContact, testLinkedPatient)
		)
		val retrievedContact = hcpApi.contact.getContact(decryptedContact.id).shouldNotBeNull()
		val encryptedContact = hcpApi.contact.encrypted.getContact(decryptedContact.id).shouldNotBeNull()
		retrievedContact.descr shouldBe decryptedContact.descr
		retrievedContact.location shouldBe decryptedContact.location
		retrievedContact.openingDate shouldBe decryptedContact.openingDate
		retrievedContact.notes.first().markdown shouldBe mapOf("en" to "contact note")
		retrievedContact.encounterLocation?.city shouldBe "Brussels"
		retrievedContact.participantList.first().type shouldBe ParticipantType.Attender
		retrievedContact.participantList.first().hcpId shouldBe decryptedContact.participantList.first().hcpId
		encryptedContact.descr shouldBe null
		encryptedContact.location shouldBe null
		encryptedContact.encounterLocation shouldBe null
		encryptedContact.openingDate shouldBe decryptedContact.openingDate
		encryptedContact.notes.first().markdown shouldBe emptyMap()
		encryptedContact.notes.first().encryptedSelf shouldNotBe null
		encryptedContact.participantList shouldBe emptyList()
		encryptedContact.encryptedSelf shouldNotBe null
	}

	"Default service encrypted fields configuration should be valid" {
		val decryptedService = DecryptedService(
			id = uuid(),
			comment = uuid(),
			label = uuid(),
			notes = listOf(Annotation(id = uuid(), markdown = mapOf("en" to "service note")))
		)
		val decryptedContact = DecryptedContact(
			id = uuid(),
			services = setOf(decryptedService)
		)
		hcpApi.contact.createContact(
			hcpApi.contact.withEncryptionMetadata(decryptedContact, testLinkedPatient)
		)
		val retrievedContact = hcpApi.contact.getContact(decryptedContact.id).shouldNotBeNull()
		val encryptedContact = hcpApi.contact.encrypted.getContact(decryptedContact.id).shouldNotBeNull()
		val retrievedService = retrievedContact.services.first()
		retrievedService.comment shouldBe decryptedService.comment
		retrievedService.label shouldBe decryptedService.label
		retrievedService.notes.first().markdown shouldBe mapOf("en" to "service note")
		val encryptedService = encryptedContact.services.first()
		encryptedService.comment shouldBe null
		encryptedService.label shouldBe decryptedService.label
		encryptedService.notes.first().markdown shouldBe emptyMap()
		encryptedService.notes.first().encryptedSelf shouldNotBe null
		encryptedService.encryptedSelf shouldNotBe null
	}

	"Default health element encrypted fields configuration should be valid" {
		val decryptedHealthElement = DecryptedHealthElement(
			id = uuid(),
			descr = uuid(),
			note = uuid(),
			healthElementId = uuid(),
			notes = listOf(Annotation(id = uuid(), markdown = mapOf("en" to "health note"))),
			careTeam = listOf(
				DecryptedCareTeamMember(
					id = uuid(),
					healthcarePartyId = uuid(),
					careTeamMemberType = CareTeamMemberType.Physician,
					quality = CodeStub(id = uuid(), type = "quality", code = uuid())
				)
			),
			episodes = listOf(
				DecryptedEpisode(
					id = uuid(),
					name = "Episode Name",
					comment = "Episode Comment",
					startDate = 20240101L
				)
			)
		)
		hcpApi.healthElement.createHealthElement(
			hcpApi.healthElement.withEncryptionMetadata(decryptedHealthElement, testLinkedPatient)
		)
		val retrievedHe = hcpApi.healthElement.getHealthElement(decryptedHealthElement.id).shouldNotBeNull()
		val encryptedHe = hcpApi.healthElement.encrypted.getHealthElement(decryptedHealthElement.id).shouldNotBeNull()
		val decryptedMember = decryptedHealthElement.careTeam.first()
		val decryptedEpisode = decryptedHealthElement.episodes.first()
		retrievedHe.descr shouldBe decryptedHealthElement.descr
		retrievedHe.note shouldBe decryptedHealthElement.note
		retrievedHe.healthElementId shouldBe decryptedHealthElement.healthElementId
		retrievedHe.notes.first().markdown shouldBe mapOf("en" to "health note")
		retrievedHe.careTeam.first().id shouldBe decryptedMember.id
		retrievedHe.careTeam.first().healthcarePartyId shouldBe decryptedMember.healthcarePartyId
		retrievedHe.careTeam.first().careTeamMemberType shouldBe CareTeamMemberType.Physician
		retrievedHe.careTeam.first().quality shouldBe decryptedMember.quality
		retrievedHe.episodes.first().id shouldBe decryptedEpisode.id
		retrievedHe.episodes.first().name shouldBe "Episode Name"
		retrievedHe.episodes.first().comment shouldBe "Episode Comment"
		retrievedHe.episodes.first().startDate shouldBe 20240101L
		encryptedHe.descr shouldBe null
		encryptedHe.note shouldBe null
		encryptedHe.healthElementId shouldBe decryptedHealthElement.healthElementId
		encryptedHe.notes.first().markdown shouldBe emptyMap()
		encryptedHe.notes.first().encryptedSelf shouldNotBe null
		// careTeam[].x: everything except id
		encryptedHe.careTeam.first().id shouldBe decryptedMember.id
		encryptedHe.careTeam.first().careTeamMemberType shouldBe null
		encryptedHe.careTeam.first().healthcarePartyId shouldBe null
		encryptedHe.careTeam.first().quality shouldBe null
		encryptedHe.careTeam.first().encryptedSelf shouldNotBe null
		// episode[].name and episode[].comment are encrypted; id and startDate are not
		encryptedHe.episodes.first().id shouldBe decryptedEpisode.id
		encryptedHe.episodes.first().name shouldBe null
		encryptedHe.episodes.first().comment shouldBe null
		encryptedHe.episodes.first().startDate shouldBe 20240101L
		encryptedHe.episodes.first().encryptedSelf shouldNotBe null
		encryptedHe.encryptedSelf shouldNotBe null
	}

	"Default maintenance task encrypted fields configuration should be valid" {
		val decryptedMaintenanceTask = DecryptedMaintenanceTask(
			id = uuid(),
			taskType = uuid(),
			properties = setOf(
				DecryptedPropertyStub(id = uuid(), type = PropertyTypeStub(identifier = uuid()))
			)
		)
		hcpApi.maintenanceTask.createMaintenanceTask(
			hcpApi.maintenanceTask.withEncryptionMetadata(decryptedMaintenanceTask)
		)
		val retrievedTask = hcpApi.maintenanceTask.getMaintenanceTask(decryptedMaintenanceTask.id).shouldNotBeNull()
		val encryptedTask = hcpApi.maintenanceTask.encrypted.getMaintenanceTask(decryptedMaintenanceTask.id).shouldNotBeNull()
		val decryptedProp = decryptedMaintenanceTask.properties.first()
		retrievedTask.taskType shouldBe decryptedMaintenanceTask.taskType
		retrievedTask.properties shouldHaveSize 1
		retrievedTask.properties.first().id shouldBe decryptedProp.id
		retrievedTask.properties.first().type?.identifier shouldBe decryptedProp.type?.identifier
		encryptedTask.taskType shouldBe decryptedMaintenanceTask.taskType
		encryptedTask.properties shouldBe emptySet()
		encryptedTask.encryptedSelf shouldNotBe null
	}

	"Default patient encrypted fields configuration should be valid" {
		val decryptedPatient = DecryptedPatient(
			id = uuid(),
			firstName = "Gino",
			note = uuid(),
			companyName = uuid(),
			nationality = uuid(),
			race = uuid(),
			ethnicity = uuid(),
			birthSex = Gender.Male,
			personalStatus = PersonalStatus.Single,
			civility = "Dr",
			languages = listOf("en", "fr"),
			patientProfessions = listOf(CodeStub(id = uuid(), type = "profession", code = uuid())),
			notes = listOf(Annotation(id = uuid(), markdown = mapOf("en" to "patient note"))),
			partnerships = listOf(
				DecryptedPartnership(
					type = PartnershipType.Spouse,
					status = PartnershipStatus.Active,
					partnerId = uuid()
				)
			),
			insurabilities = listOf(DecryptedInsurability(
				identificationNumber = uuid(),
				parameters = mapOf("paramKey" to "paramValue"),
				hospitalisation = true,
				ambulatory = true,
				dental = true,
				insuranceId = uuid(),
				startDate = 20240101L,
				endDate = 20241231L,
				titularyId = uuid()
			)),
			patientHealthCareParties = listOf(DecryptedPatientHealthCareParty(
				type = PatientHealthCarePartyType.Doctor,
				healthcarePartyId = uuid(),
				sendFormats = mapOf(TelecomType.Mobile to "0123456789"),
				referralPeriods = listOf(ReferralPeriod(comment = "test referral")),
				properties = setOf(DecryptedPropertyStub(id = uuid(), type = PropertyTypeStub(identifier = uuid())))
			)),
			financialInstitutionInformation = listOf(DecryptedFinancialInstitutionInformation(
				name = uuid(),
				key = uuid(),
				bankAccount = uuid(),
				bic = uuid(),
				proxyBankAccount = uuid(),
				proxyBic = uuid(),
				preferredFiiForPartners = setOf("partner1")
			)),
			medicalHouseContracts = listOf(DecryptedMedicalHouseContract(
				contractId = uuid(),
				validFrom = 20240101L,
				validTo = 20241231L,
				mmNihii = uuid(),
				hcpId = uuid(),
				changeType = ContractChangeType.InscriptionStart,
				parentContractId = uuid(),
				changedBy = uuid(),
				startOfContract = 20240101L,
				startOfCoverage = 20240101L,
				endOfContract = 20241231L,
				endOfCoverage = 20241231L,
				kine = true,
				gp = true,
				ptd = true,
				nurse = true,
				noKine = true,
				noGp = true,
				noNurse = true,
				unsubscriptionReasonId = 42,
				ptdStart = 20240101L,
				ptdEnd = 20241231L,
				ptdLastInvoiced = 20240601L,
				startOfSuspension = 20240101L,
				endOfSuspension = 20240601L,
				suspensionReason = SuspensionReason.NotInsured,
				suspensionSource = uuid(),
				forcedSuspension = true,
				signatureType = MhcSignatureType.HolderEid,
				status = 1,
				options = mapOf("optKey" to "optVal"),
				receipts = mapOf("recKey" to "recVal")
			))
		)
		hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(decryptedPatient)
		)
		val retrievedPatient = hcpApi.patient.getPatient(decryptedPatient.id).shouldNotBeNull()
		val encryptedPatient = hcpApi.patient.encrypted.getPatient(decryptedPatient.id).shouldNotBeNull()

		// top-level non-encrypted field — same in retrieved and encrypted
		retrievedPatient.firstName shouldBe "Gino"
		encryptedPatient.firstName shouldBe "Gino"
		// top-level encrypted fields
		retrievedPatient.note shouldBe decryptedPatient.note
		retrievedPatient.companyName shouldBe decryptedPatient.companyName
		retrievedPatient.nationality shouldBe decryptedPatient.nationality
		retrievedPatient.race shouldBe decryptedPatient.race
		retrievedPatient.ethnicity shouldBe decryptedPatient.ethnicity
		retrievedPatient.birthSex shouldBe Gender.Male
		retrievedPatient.personalStatus shouldBe PersonalStatus.Single
		retrievedPatient.civility shouldBe "Dr"
		retrievedPatient.languages shouldBe listOf("en", "fr")
		retrievedPatient.patientProfessions shouldHaveSize 1
		retrievedPatient.notes.first().markdown shouldBe mapOf("en" to "patient note")
		encryptedPatient.note shouldBe null
		encryptedPatient.companyName shouldBe null
		encryptedPatient.nationality shouldBe null
		encryptedPatient.race shouldBe null
		encryptedPatient.ethnicity shouldBe null
		encryptedPatient.birthSex shouldBe Gender.Unknown
		encryptedPatient.personalStatus shouldBe PersonalStatus.Unknown
		encryptedPatient.civility shouldBe null
		encryptedPatient.languages shouldBe emptyList()
		encryptedPatient.patientProfessions shouldBe emptyList()
		encryptedPatient.notes.first().markdown shouldBe emptyMap()
		encryptedPatient.notes.first().encryptedSelf shouldNotBe null
		encryptedPatient.encryptedSelf shouldNotBe null

		// partnerships[].*
		val decryptedPartnership = decryptedPatient.partnerships.first()
		retrievedPatient.partnerships.first().type shouldBe PartnershipType.Spouse
		retrievedPatient.partnerships.first().status shouldBe PartnershipStatus.Active
		retrievedPatient.partnerships.first().partnerId shouldBe decryptedPartnership.partnerId
		encryptedPatient.partnerships.shouldHaveSize(1).first().apply {
			type shouldBe null
			status shouldBe null
			partnerId shouldBe null
			encryptedSelf shouldNotBe null
		}

		// insurabilities[].*: all fields (including non-nullable parameters) encrypted
		val decryptedInsurability = decryptedPatient.insurabilities.first()
		retrievedPatient.insurabilities.first().identificationNumber shouldBe decryptedInsurability.identificationNumber
		retrievedPatient.insurabilities.first().parameters shouldBe mapOf("paramKey" to "paramValue")
		retrievedPatient.insurabilities.first().hospitalisation shouldBe true
		retrievedPatient.insurabilities.first().ambulatory shouldBe true
		retrievedPatient.insurabilities.first().dental shouldBe true
		retrievedPatient.insurabilities.first().insuranceId shouldBe decryptedInsurability.insuranceId
		retrievedPatient.insurabilities.first().startDate shouldBe 20240101L
		retrievedPatient.insurabilities.first().endDate shouldBe 20241231L
		retrievedPatient.insurabilities.first().titularyId shouldBe decryptedInsurability.titularyId
		encryptedPatient.insurabilities.first().identificationNumber shouldBe null
		encryptedPatient.insurabilities.first().parameters shouldBe emptyMap()
		encryptedPatient.insurabilities.first().hospitalisation shouldBe null
		encryptedPatient.insurabilities.first().ambulatory shouldBe null
		encryptedPatient.insurabilities.first().dental shouldBe null
		encryptedPatient.insurabilities.first().insuranceId shouldBe null
		encryptedPatient.insurabilities.first().startDate shouldBe null
		encryptedPatient.insurabilities.first().endDate shouldBe null
		encryptedPatient.insurabilities.first().titularyId shouldBe null
		encryptedPatient.insurabilities.first().encryptedSelf shouldNotBe null

		// patientHealthCareParties[].*: all fields encrypted, non-nullable collections revert to defaults
		val decryptedPhcp = decryptedPatient.patientHealthCareParties.first()
		retrievedPatient.patientHealthCareParties.first().type shouldBe PatientHealthCarePartyType.Doctor
		retrievedPatient.patientHealthCareParties.first().healthcarePartyId shouldBe decryptedPhcp.healthcarePartyId
		retrievedPatient.patientHealthCareParties.first().sendFormats shouldBe mapOf(TelecomType.Mobile to "0123456789")
		retrievedPatient.patientHealthCareParties.first().referralPeriods shouldBe listOf(ReferralPeriod(comment = "test referral"))
		retrievedPatient.patientHealthCareParties.first().properties?.first()?.id shouldBe decryptedPhcp.properties?.first()?.id
		encryptedPatient.patientHealthCareParties.first().type shouldBe null
		encryptedPatient.patientHealthCareParties.first().healthcarePartyId shouldBe null
		encryptedPatient.patientHealthCareParties.first().sendFormats shouldBe emptyMap()
		encryptedPatient.patientHealthCareParties.first().referralPeriods shouldBe emptyList()
		encryptedPatient.patientHealthCareParties.first().properties shouldBe null
		encryptedPatient.patientHealthCareParties.first().encryptedSelf shouldNotBe null

		// financialInstitutionInformation[].*: all fields encrypted, non-nullable preferredFiiForPartners reverts to emptySet()
		val decryptedFii = decryptedPatient.financialInstitutionInformation.first()
		retrievedPatient.financialInstitutionInformation.first().name shouldBe decryptedFii.name
		retrievedPatient.financialInstitutionInformation.first().key shouldBe decryptedFii.key
		retrievedPatient.financialInstitutionInformation.first().bankAccount shouldBe decryptedFii.bankAccount
		retrievedPatient.financialInstitutionInformation.first().bic shouldBe decryptedFii.bic
		retrievedPatient.financialInstitutionInformation.first().proxyBankAccount shouldBe decryptedFii.proxyBankAccount
		retrievedPatient.financialInstitutionInformation.first().proxyBic shouldBe decryptedFii.proxyBic
		retrievedPatient.financialInstitutionInformation.first().preferredFiiForPartners shouldBe setOf("partner1")
		encryptedPatient.financialInstitutionInformation.first().name shouldBe null
		encryptedPatient.financialInstitutionInformation.first().key shouldBe null
		encryptedPatient.financialInstitutionInformation.first().bankAccount shouldBe null
		encryptedPatient.financialInstitutionInformation.first().bic shouldBe null
		encryptedPatient.financialInstitutionInformation.first().proxyBankAccount shouldBe null
		encryptedPatient.financialInstitutionInformation.first().proxyBic shouldBe null
		encryptedPatient.financialInstitutionInformation.first().preferredFiiForPartners shouldBe emptySet()
		encryptedPatient.financialInstitutionInformation.first().encryptedSelf shouldNotBe null

		// medicalHouseContracts[].*: all fields encrypted; non-nullable booleans revert to false, maps to emptyMap()
		val decryptedMhc = decryptedPatient.medicalHouseContracts.first()
		retrievedPatient.medicalHouseContracts.first().contractId shouldBe decryptedMhc.contractId
		retrievedPatient.medicalHouseContracts.first().validFrom shouldBe 20240101L
		retrievedPatient.medicalHouseContracts.first().validTo shouldBe 20241231L
		retrievedPatient.medicalHouseContracts.first().mmNihii shouldBe decryptedMhc.mmNihii
		retrievedPatient.medicalHouseContracts.first().hcpId shouldBe decryptedMhc.hcpId
		retrievedPatient.medicalHouseContracts.first().changeType shouldBe ContractChangeType.InscriptionStart
		retrievedPatient.medicalHouseContracts.first().parentContractId shouldBe decryptedMhc.parentContractId
		retrievedPatient.medicalHouseContracts.first().changedBy shouldBe decryptedMhc.changedBy
		retrievedPatient.medicalHouseContracts.first().startOfContract shouldBe 20240101L
		retrievedPatient.medicalHouseContracts.first().startOfCoverage shouldBe 20240101L
		retrievedPatient.medicalHouseContracts.first().endOfContract shouldBe 20241231L
		retrievedPatient.medicalHouseContracts.first().endOfCoverage shouldBe 20241231L
		retrievedPatient.medicalHouseContracts.first().kine shouldBe true
		retrievedPatient.medicalHouseContracts.first().gp shouldBe true
		retrievedPatient.medicalHouseContracts.first().ptd shouldBe true
		retrievedPatient.medicalHouseContracts.first().nurse shouldBe true
		retrievedPatient.medicalHouseContracts.first().noKine shouldBe true
		retrievedPatient.medicalHouseContracts.first().noGp shouldBe true
		retrievedPatient.medicalHouseContracts.first().noNurse shouldBe true
		retrievedPatient.medicalHouseContracts.first().unsubscriptionReasonId shouldBe 42
		retrievedPatient.medicalHouseContracts.first().ptdStart shouldBe 20240101L
		retrievedPatient.medicalHouseContracts.first().ptdEnd shouldBe 20241231L
		retrievedPatient.medicalHouseContracts.first().ptdLastInvoiced shouldBe 20240601L
		retrievedPatient.medicalHouseContracts.first().startOfSuspension shouldBe 20240101L
		retrievedPatient.medicalHouseContracts.first().endOfSuspension shouldBe 20240601L
		retrievedPatient.medicalHouseContracts.first().suspensionReason shouldBe SuspensionReason.NotInsured
		retrievedPatient.medicalHouseContracts.first().suspensionSource shouldBe decryptedMhc.suspensionSource
		retrievedPatient.medicalHouseContracts.first().forcedSuspension shouldBe true
		retrievedPatient.medicalHouseContracts.first().signatureType shouldBe MhcSignatureType.HolderEid
		retrievedPatient.medicalHouseContracts.first().status shouldBe 1
		retrievedPatient.medicalHouseContracts.first().options shouldBe mapOf("optKey" to "optVal")
		retrievedPatient.medicalHouseContracts.first().receipts shouldBe mapOf("recKey" to "recVal")
		encryptedPatient.medicalHouseContracts.first().contractId shouldBe null
		encryptedPatient.medicalHouseContracts.first().validFrom shouldBe null
		encryptedPatient.medicalHouseContracts.first().validTo shouldBe null
		encryptedPatient.medicalHouseContracts.first().mmNihii shouldBe null
		encryptedPatient.medicalHouseContracts.first().hcpId shouldBe null
		encryptedPatient.medicalHouseContracts.first().changeType shouldBe null
		encryptedPatient.medicalHouseContracts.first().parentContractId shouldBe null
		encryptedPatient.medicalHouseContracts.first().changedBy shouldBe null
		encryptedPatient.medicalHouseContracts.first().startOfContract shouldBe null
		encryptedPatient.medicalHouseContracts.first().startOfCoverage shouldBe null
		encryptedPatient.medicalHouseContracts.first().endOfContract shouldBe null
		encryptedPatient.medicalHouseContracts.first().endOfCoverage shouldBe null
		encryptedPatient.medicalHouseContracts.first().kine shouldBe false
		encryptedPatient.medicalHouseContracts.first().gp shouldBe false
		encryptedPatient.medicalHouseContracts.first().ptd shouldBe false
		encryptedPatient.medicalHouseContracts.first().nurse shouldBe false
		encryptedPatient.medicalHouseContracts.first().noKine shouldBe false
		encryptedPatient.medicalHouseContracts.first().noGp shouldBe false
		encryptedPatient.medicalHouseContracts.first().noNurse shouldBe false
		encryptedPatient.medicalHouseContracts.first().unsubscriptionReasonId shouldBe null
		encryptedPatient.medicalHouseContracts.first().ptdStart shouldBe null
		encryptedPatient.medicalHouseContracts.first().ptdEnd shouldBe null
		encryptedPatient.medicalHouseContracts.first().ptdLastInvoiced shouldBe null
		encryptedPatient.medicalHouseContracts.first().startOfSuspension shouldBe null
		encryptedPatient.medicalHouseContracts.first().endOfSuspension shouldBe null
		encryptedPatient.medicalHouseContracts.first().suspensionReason shouldBe null
		encryptedPatient.medicalHouseContracts.first().suspensionSource shouldBe null
		encryptedPatient.medicalHouseContracts.first().forcedSuspension shouldBe false
		encryptedPatient.medicalHouseContracts.first().signatureType shouldBe null
		encryptedPatient.medicalHouseContracts.first().status shouldBe null
		encryptedPatient.medicalHouseContracts.first().options shouldBe emptyMap()
		encryptedPatient.medicalHouseContracts.first().receipts shouldBe emptyMap()
		encryptedPatient.medicalHouseContracts.first().encryptedSelf shouldNotBe null
	}

	"Default message encrypted fields configuration should be valid" {
		val decryptedMessage = DecryptedMessage(
			id = uuid(),
			subject = uuid(),
			fromAddress = uuid()
		)
		hcpApi.message.createMessage(
			hcpApi.message.withEncryptionMetadata(decryptedMessage, testLinkedPatient)
		)
		val retrievedMessage = hcpApi.message.getMessage(decryptedMessage.id).shouldNotBeNull()
		val encryptedMessage = hcpApi.message.encrypted.getMessage(decryptedMessage.id).shouldNotBeNull()
		retrievedMessage.subject shouldBe decryptedMessage.subject
		retrievedMessage.fromAddress shouldBe decryptedMessage.fromAddress
		encryptedMessage.subject shouldBe null
		encryptedMessage.fromAddress shouldBe decryptedMessage.fromAddress
		encryptedMessage.encryptedSelf shouldNotBe null
	}

	"Default topic encrypted fields configuration should be valid" {
		val decryptedTopic = DecryptedTopic(
			id = uuid(),
			description = uuid(),
			linkedServices = setOf(uuid()),
			linkedHealthElements = setOf(uuid()),
			tags = setOf(CodeStub(id = "topicTag"))
		)
		hcpApi.topic.createTopic(
			hcpApi.topic.withEncryptionMetadata(decryptedTopic, testLinkedPatient)
		)
		val retrievedTopic = hcpApi.topic.getTopic(decryptedTopic.id).shouldNotBeNull()
		val encryptedTopic = hcpApi.topic.encrypted.getTopic(decryptedTopic.id).shouldNotBeNull()
		retrievedTopic.description shouldBe decryptedTopic.description
		retrievedTopic.linkedServices shouldBe decryptedTopic.linkedServices
		retrievedTopic.linkedHealthElements shouldBe decryptedTopic.linkedHealthElements
		retrievedTopic.tags shouldBe setOf(CodeStub(id = "topicTag"))
		encryptedTopic.description shouldBe null
		encryptedTopic.linkedServices shouldBe emptySet()
		encryptedTopic.linkedHealthElements shouldBe emptySet()
		encryptedTopic.tags shouldBe setOf(CodeStub(id = "topicTag"))
		encryptedTopic.encryptedSelf shouldNotBe null
	}

	"Default document encrypted fields configuration should be valid" {
		val decryptedDocument = DecryptedDocument(
			id = uuid(),
			name = uuid(),
			version = uuid()
		)
		hcpApi.document.createDocument(
			hcpApi.document.withEncryptionMetadataLinkedToPatient(decryptedDocument, testLinkedPatient)
		)
		val retrievedDocument = hcpApi.document.getDocument(decryptedDocument.id).shouldNotBeNull()
		val encryptedDocument = hcpApi.document.encrypted.getDocument(decryptedDocument.id).shouldNotBeNull()
		retrievedDocument.name shouldBe decryptedDocument.name
		retrievedDocument.version shouldBe decryptedDocument.version
		encryptedDocument.name shouldBe null
		encryptedDocument.version shouldBe decryptedDocument.version
		encryptedDocument.encryptedSelf shouldNotBe null
	}

	"Default form encrypted fields configuration should be valid" {
		val decryptedForm = DecryptedForm(
			id = uuid(),
			descr = uuid(),
			formTemplateId = uuid()
		)
		hcpApi.form.createForm(
			hcpApi.form.withEncryptionMetadata(decryptedForm, testLinkedPatient)
		)
		val retrievedForm = hcpApi.form.getForm(decryptedForm.id).shouldNotBeNull()
		val encryptedForm = hcpApi.form.encrypted.getForm(decryptedForm.id).shouldNotBeNull()
		retrievedForm.descr shouldBe decryptedForm.descr
		retrievedForm.formTemplateId shouldBe decryptedForm.formTemplateId
		encryptedForm.descr shouldBe null
		encryptedForm.formTemplateId shouldBe decryptedForm.formTemplateId
		encryptedForm.encryptedSelf shouldNotBe null
	}

	"Default receipt encrypted fields configuration should be valid" {
		val decryptedReceipt = DecryptedReceipt(
			id = uuid(),
			references = listOf(uuid()),
			documentId = uuid()
		)
		hcpApi.receipt.createReceipt(
			hcpApi.receipt.withEncryptionMetadata(decryptedReceipt, testLinkedPatient)
		)
		val retrievedReceipt = hcpApi.receipt.getReceipt(decryptedReceipt.id).shouldNotBeNull()
		val encryptedReceipt = hcpApi.receipt.encrypted.getReceipt(decryptedReceipt.id).shouldNotBeNull()
		retrievedReceipt.references shouldBe decryptedReceipt.references
		retrievedReceipt.documentId shouldBe decryptedReceipt.documentId
		encryptedReceipt.references shouldBe emptyList()
		encryptedReceipt.documentId shouldBe decryptedReceipt.documentId
		encryptedReceipt.encryptedSelf shouldNotBe null
	}

	// NOTE: Classification does not have a direct public API on CardinalSdk (it is used internally
	//       by PatientApi). The encrypted field `label` cannot be tested here directly.

	// NOTE: TimeTable has an empty encrypted fields configuration; there are no encrypted fields to test.

	"Default invoice encrypted fields configuration should be valid" {
		val decryptedInvoice = DecryptedInvoice(
			id = uuid(),
			reason = uuid(),
			invoiceDate = 20240101L
		)
		hcpApi.invoice.createInvoice(
			hcpApi.invoice.withEncryptionMetadata(decryptedInvoice, testLinkedPatient)
		)
		val retrievedInvoice = hcpApi.invoice.getInvoice(decryptedInvoice.id).shouldNotBeNull()
		val encryptedInvoice = hcpApi.invoice.encrypted.getInvoice(decryptedInvoice.id).shouldNotBeNull()
		retrievedInvoice.reason shouldBe decryptedInvoice.reason
		retrievedInvoice.invoiceDate shouldBe decryptedInvoice.invoiceDate
		encryptedInvoice.reason shouldBe null
		encryptedInvoice.invoiceDate shouldBe decryptedInvoice.invoiceDate
		encryptedInvoice.encryptedSelf shouldNotBe null
	}
})
