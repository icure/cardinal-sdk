package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptionManifests
import com.icure.cardinal.sdk.crypto.encryptor.BuiltinEmbeddedEntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.BuiltinRootEntityEncryptionManifest

sealed interface EncryptedFieldsOptions {
	data object Default : EncryptedFieldsOptions
	data object Legacy : EncryptedFieldsOptions
	/**
	 * Encryption configuration of a customised SDK.
	 *
	 * @param manifests the manifests for the encryption of entities: root entities without a manifest are not
	 * supported by the SDK.
	 * @param useLegacyServiceContentEncryption see [EncryptorOptions.useLegacyServiceContentEncryption].
	 * @param serializeEncryptedSelfUsingLegacyNames see [EncryptorOptions.serializeEncryptedSelfUsingLegacyNames].
	 */
	data class Custom(
		val manifests: EntitiesEncryptionManifests,
		val useLegacyServiceContentEncryption: Boolean = false,
		val serializeEncryptedSelfUsingLegacyNames: Boolean = false,
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
	is EncryptedFieldsOptions.Custom -> EncryptorOptions(
		useLegacyServiceContentEncryption = useLegacyServiceContentEncryption,
		serializeEncryptedSelfUsingLegacyNames = serializeEncryptedSelfUsingLegacyNames,
	)
}

internal val EncryptedFieldsOptions?.manifests: EntitiesEncryptionManifests get() = when (this) {
	EncryptedFieldsOptions.Legacy -> legacyEntitiesEncryptionManifests
	EncryptedFieldsOptions.Default, null -> defaultEntitiesEncryptionManifests
	is EncryptedFieldsOptions.Custom -> manifests
}

private fun createDefaultEntitiesEncryptionManifests(
	useLegacyServiceContentEncryption: Boolean,
) = EntitiesEncryptionManifests(
	embeddedManifestsByName = listOfNotNull(
		"Annotation" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("markdown"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"CalendarItemTag" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("code", "date", "userId", "userName"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Service" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("comment"),
			recursiveEncryption = listOfNotNull(
				"notes" to "Annotation",
				if (useLegacyServiceContentEncryption) null else ("content" to "Content")
			).toMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		if (useLegacyServiceContentEncryption) null else (
			"Content" to BuiltinEmbeddedEntityEncryptionManifest(
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
				extensionsManifestsByModelVersion = emptyMap(),
				currentExtensionsManifest = null,
			)
		),
		"CareTeamMember" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("careTeamMemberType", "healthcarePartyId", "quality"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Episode" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("name", "comment"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Insurability" to BuiltinEmbeddedEntityEncryptionManifest(
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Partnership" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("type", "status", "partnerId"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"PatientHealthCareParty" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("type", "healthcarePartyId", "sendFormats", "referralPeriods", "properties"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"FinancialInstitutionInformation" to BuiltinEmbeddedEntityEncryptionManifest(
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"SchoolingInfo" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("startDate", "endDate", "school", "typeOfEducation"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"EmploymentInfo" to BuiltinEmbeddedEntityEncryptionManifest(
			fieldsToEncrypt = setOf("startDate", "endDate", "professionType", "employer"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"MedicalHouseContract" to BuiltinEmbeddedEntityEncryptionManifest(
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
	).toMap(),
	extensionsManifestsByName = emptyMap(),
	accessLog = BuiltinRootEntityEncryptionManifest(
		fieldsToEncrypt = setOf(
			"detail",
			"objectId",
			"patientId", // Deprecated and ignored unless using the legacy support SDK
		),
		recursiveEncryption = emptyMap(),
	),
	calendarItem = BuiltinRootEntityEncryptionManifest(
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
	contact = BuiltinRootEntityEncryptionManifest(
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
	healthElement = BuiltinRootEntityEncryptionManifest(
		fieldsToEncrypt = setOf(
			"descr",
			"note",
			"asserters",
		),
		recursiveEncryption = mapOf(
			"notes" to "Annotation",
			"careTeam" to "CareTeamMember",
			"episodes" to "Episode",
		),
	),
	patient = BuiltinRootEntityEncryptionManifest(
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
	message = BuiltinRootEntityEncryptionManifest(
		fieldsToEncrypt = setOf("subject"),
		recursiveEncryption = emptyMap(),
	),
	topic = BuiltinRootEntityEncryptionManifest(
		fieldsToEncrypt = setOf("description", "linkedServices", "linkedHealthElements"),
		recursiveEncryption = emptyMap(),
	),
	document = BuiltinRootEntityEncryptionManifest(
		fieldsToEncrypt = setOf(
			"medicalLocationId", // Deprecated and ignored unless using the legacy support SDK
			"name",
		),
		recursiveEncryption = emptyMap(),
	),
	form = BuiltinRootEntityEncryptionManifest(
		fieldsToEncrypt = setOf("descr"),
		recursiveEncryption = emptyMap(),
	),
	invoice = BuiltinRootEntityEncryptionManifest(
		fieldsToEncrypt = setOf("reason"),
		recursiveEncryption = emptyMap(),
	),
	relatedPerson = BuiltinRootEntityEncryptionManifest(
		fieldsToEncrypt = setOf(
			"created",
			"modified",
			"companyName",
			"languages",
			"civility"
		),
		recursiveEncryption = emptyMap(),
	),
	customEntitiesManifestByEntityTypeId = emptyMap(),
)

private val defaultEntitiesEncryptionManifests = createDefaultEntitiesEncryptionManifests(useLegacyServiceContentEncryption = false)
private val legacyEntitiesEncryptionManifests = createDefaultEntitiesEncryptionManifests(useLegacyServiceContentEncryption = true)
