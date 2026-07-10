package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptionManifests
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptionManifest

sealed interface EncryptedFieldsOptions {
	data object Default : EncryptedFieldsOptions
	data object Legacy : EncryptedFieldsOptions
	data class Custom(
		val manifests: EntitiesEncryptionManifests,
		val encryptorOptions: EncryptorOptions,
	) : EncryptedFieldsOptions
}

private val legacyEncryptorOptions = EncryptorOptions(
	useLegacyServiceContentEncryption = true,
	serializeEncryptedSelfUsingLegacyNames = true,
)
private val defaultEncryptorOptions = EncryptorOptions(
	useLegacyServiceContentEncryption = false,
	serializeEncryptedSelfUsingLegacyNames = false,
)

internal val EncryptedFieldsOptions?.encryptorOptions: EncryptorOptions get() = when (this) {
	EncryptedFieldsOptions.Legacy -> legacyEncryptorOptions
	EncryptedFieldsOptions.Default, null -> defaultEncryptorOptions
	is EncryptedFieldsOptions.Custom -> encryptorOptions
}

internal val EncryptedFieldsOptions?.manifests: EntitiesEncryptionManifests get() = when (this) {
	EncryptedFieldsOptions.Legacy -> legacyEntitiesEncryptionManifests
	EncryptedFieldsOptions.Default, null -> defaultEntitiesEncryptionManifests
	is EncryptedFieldsOptions.Custom -> manifests
}

private fun createDefaultEntitiesEncryptionManifests(
	useLegacyServiceContentEncryption: Boolean,
) = EntitiesEncryptionManifests(
	manifestsByName = listOfNotNull(
		"Annotation" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("markdown"),
			recursiveEncryption = emptyMap(),
		),
		"CalendarItemTag" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("code", "date", "userId", "userName"),
			recursiveEncryption = emptyMap(),
		),
		"Service" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("comment"),
			recursiveEncryption = listOfNotNull(
				"notes" to "Annotation",
				if (useLegacyServiceContentEncryption) null else ("content" to "Content")
			).toMap(),
		),
		if (useLegacyServiceContentEncryption) null else (
			"Content" to EntityEncryptionManifest(
				fieldsToEncrypt = setOf(
					"stringValue",
					"numberValue",
					"booleanValue",
					"instantValue",
					"fuzzyDateValue",
					"binaryValue",
					"documentId",
					"measureValue",
					"medicationValue",
					"timeSeries",
					"ratio",
					"range",
				),
				recursiveEncryption = mapOf(
					"compoundValue" to "Service",
				),
			)
		),
		"CareTeamMember" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("careTeamMemberType", "healthcarePartyId", "quality"),
			recursiveEncryption = emptyMap(),
		),
		"Episode" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("name", "comment"),
			recursiveEncryption = emptyMap(),
		),
		"Insurability" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"identificationNumber",
				"parameters",
				"hospitalisation",
				"ambulatory",
				"dental",
				"insuranceId",
				"startDate",
				"endDate",
				"titularyId",
			),
			recursiveEncryption = emptyMap(),
		),
		"Partnership" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("type", "status", "partnerId"),
			recursiveEncryption = emptyMap(),
		),
		"PatientHealthCareParty" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("type", "healthcarePartyId", "sendFormats", "referralPeriods", "properties"),
			recursiveEncryption = emptyMap(),
		),
		"FinancialInstitutionInformation" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"name",
				"key",
				"bankAccount",
				"bic",
				"proxyBankAccount",
				"proxyBic",
				"preferredFiiForPartners",
			),
			recursiveEncryption = emptyMap(),
		),
		"SchoolingInfo" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("startDate", "endDate", "school", "typeOfEducation"),
			recursiveEncryption = emptyMap(),
		),
		"EmploymentInfo" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("startDate", "endDate", "professionType", "employer"),
			recursiveEncryption = emptyMap(),
		),
		"MedicalHouseContract" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"contractId",
				"validFrom",
				"validTo",
				"mmNihii",
				"hcpId",
				"changeType",
				"parentContractId",
				"changedBy",
				"startOfContract",
				"startOfCoverage",
				"endOfContract",
				"endOfCoverage",
				"kine",
				"gp",
				"ptd",
				"nurse",
				"noKine",
				"noGp",
				"noNurse",
				"unsubscriptionReasonId",
				"ptdStart",
				"ptdEnd",
				"ptdLastInvoiced",
				"startOfSuspension",
				"endOfSuspension",
				"suspensionReason",
				"suspensionSource",
				"forcedSuspension",
				"signatureType",
				"status",
				"options",
				"receipts",
			),
			recursiveEncryption = emptyMap(),
		),
		"AccessLog" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"detail",
				"objectId",
				"patientId", // Deprecated and ignored unless using the legacy support SDK
			),
			recursiveEncryption = emptyMap(),
		),
		"CalendarItem" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"details",
				"title",
				"patientId", // Deprecated and ignored unless using the legacy support SDK
				"phoneNumber",
				"address",
				"addressText",
				"flowItem", // Deprecated and ignored unless using the legacy support SDK
			),
			// The old configuration used "meetingTags[].*" (encrypt every field of each tag); there is no
			// equivalent wildcard anymore, so we emulate it with a dedicated manifest listing every field.
			recursiveEncryption = mapOf("meetingTags" to "CalendarItemTag"),
		),
		"Contact" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"descr",
				"location",
				"encounterLocation",
				"participants", // Deprecated and ignored unless using the legacy support SDK
				"participantList",
			),
			recursiveEncryption = mapOf(
				"notes" to "Annotation",
				"services" to "Service",
			),
		),
		"HealthElement" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("descr", "note"),
			recursiveEncryption = mapOf(
				"notes" to "Annotation",
				"careTeam" to "CareTeamMember",
				"episodes" to "Episode",
			),
		),
		"Patient" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"note",
				"created",
				"modified",
				"companyName",
				"languages",
				"civility",
				"birthSex",
				"personalStatus",
				"nationality",
				"race",
				"ethnicity",
				"picture", // Deprecated and ignored unless using the legacy support SDK
				"patientProfessions",
				"comment", // Deprecated and ignored unless using the legacy support SDK
				"warning", // Deprecated and ignored unless using the legacy support SDK
				"fatherBirthCountry", // Deprecated and ignored unless using the legacy support SDK
				"birthCountry", // Deprecated and ignored unless using the legacy support SDK
				"nativeCountry", // Deprecated and ignored unless using the legacy support SDK
				"socialStatus", // Deprecated and ignored unless using the legacy support SDK
				"mainSourceOfIncome", // Deprecated and ignored unless using the legacy support SDK
			),
			recursiveEncryption = mapOf(
				"notes" to "Annotation",
				"insurabilities" to "Insurability",
				"partnerships" to "Partnership",
				"patientHealthCareParties" to "PatientHealthCareParty",
				"financialInstitutionInformation" to "FinancialInstitutionInformation",
				"medicalHouseContracts" to "MedicalHouseContract",
				"schoolingInfos" to "SchoolingInfo", // Deprecated and ignored unless using the legacy support SDK
				"employementInfos" to "EmploymentInfo", // Deprecated and ignored unless using the legacy support SDK
			),
		),
		"Message" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("subject"),
			recursiveEncryption = emptyMap(),
		),
		"Topic" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("description", "linkedServices", "linkedHealthElements"),
			recursiveEncryption = emptyMap(),
		),
		"Document" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"medicalLocationId", // Deprecated and ignored unless using the legacy support SDK
				"name",
			),
			recursiveEncryption = emptyMap(),
		),
		"Form" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("descr"),
			recursiveEncryption = emptyMap(),
		),
		"Receipt" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("references"),
			recursiveEncryption = emptyMap(),
		),
		"Classification" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("label"),
			recursiveEncryption = emptyMap(),
		),
		"Invoice" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("reason"),
			recursiveEncryption = emptyMap(),
		),
	).toMap(),
	accessLog = "AccessLog",
	calendarItem = "CalendarItem",
	contact = "Contact",
	healthElement = "HealthElement",
	patient = "Patient",
	message = "Message",
	topic = "Topic",
	document = "Document",
	form = "Form",
	receipt = "Receipt",
	classification = "Classification",
	invoice = "Invoice",
)

private val defaultEntitiesEncryptionManifests = createDefaultEntitiesEncryptionManifests(useLegacyServiceContentEncryption = false)
private val legacyEntitiesEncryptionManifests = createDefaultEntitiesEncryptionManifests(useLegacyServiceContentEncryption = true)
