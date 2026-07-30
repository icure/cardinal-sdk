package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptionManifests
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptionManifest
import kotlinx.serialization.Serializable

sealed interface EncryptedFieldsOptions {
	data object Default : EncryptedFieldsOptions
	data object Legacy : EncryptedFieldsOptions
	data class Custom(
		val manifests: PartialEncryptedManifest,
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
		useLegacyServiceContentEncryption = manifests.useLegacyBase,
		serializeEncryptedSelfUsingLegacyNames = manifests.useLegacyBase,
	)
}

internal val EncryptedFieldsOptions?.manifests: EntitiesEncryptionManifests get() = when (this) {
	EncryptedFieldsOptions.Legacy -> legacyEntitiesEncryptionManifests
	EncryptedFieldsOptions.Default, null -> defaultEntitiesEncryptionManifests
	is EncryptedFieldsOptions.Custom -> manifests.buildFullManifest()
}

private fun createDefaultEntitiesEncryptionManifests(
	useLegacyServiceContentEncryption: Boolean,
) = EntitiesEncryptionManifests(
	manifestsByName = listOfNotNull(
		"Annotation" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("markdown"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"CalendarItemTag" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("code", "date", "userId", "userName"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Service" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("comment"),
			recursiveEncryption = listOfNotNull(
				"notes" to "Annotation",
				if (useLegacyServiceContentEncryption) null else ("content" to "Content")
			).toMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
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
				extensionsManifestsByModelVersion = emptyMap(),
				currentExtensionsManifest = null,
			)
		),
		"CareTeamMember" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("careTeamMemberType", "healthcarePartyId", "quality"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Episode" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("name", "comment"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Partnership" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("type", "status", "partnerId"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"PatientHealthCareParty" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("type", "healthcarePartyId", "sendFormats", "referralPeriods", "properties"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"SchoolingInfo" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("startDate", "endDate", "school", "typeOfEducation"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"EmploymentInfo" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("startDate", "endDate", "professionType", "employer"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"AccessLog" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"detail",
				"objectId",
				"patientId", // Deprecated and ignored unless using the legacy support SDK
			),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"HealthElement" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("descr", "note"),
			recursiveEncryption = mapOf(
				"notes" to "Annotation",
				"careTeam" to "CareTeamMember",
				"episodes" to "Episode",
			),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
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
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Message" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("subject"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Topic" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("description", "linkedServices", "linkedHealthElements"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Document" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"medicalLocationId", // Deprecated and ignored unless using the legacy support SDK
				"name",
			),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Form" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("descr"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Receipt" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("references"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Classification" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("label"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"Invoice" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf("reason"),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		),
		"RelatedPerson" to EntityEncryptionManifest(
			fieldsToEncrypt = setOf(
				"created",
				"modified",
				"companyName",
				"languages",
				"civility"
			),
			recursiveEncryption = emptyMap(),
			extensionsManifestsByModelVersion = emptyMap(),
			currentExtensionsManifest = null,
		)
	).toMap(),
	extensionsManifestsByName = emptyMap(),
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
	relatedPerson = "RelatedPerson",
)

private val defaultEntitiesEncryptionManifests = createDefaultEntitiesEncryptionManifests(useLegacyServiceContentEncryption = false)
private val legacyEntitiesEncryptionManifests = createDefaultEntitiesEncryptionManifests(useLegacyServiceContentEncryption = true)

// TODO will be non-nullable later on, everything must be defined by the custom config, even if it matches default / base
@Serializable
data class PartialEncryptedManifest(
	val manifestsByName: Map<String, EntityEncryptionManifest>,
	val extensionsManifestsByName: Map<String, ExtensionsEncryptionManifest>,
	val accessLog: String? = null,
	val calendarItem: String? = null,
	val contact: String? = null,
	val healthElement: String? = null,
	val patient: String? = null,
	val message: String? = null,
	val topic: String? = null,
	val document: String? = null,
	val form: String? = null,
	val receipt: String? = null,
	val classification: String? = null,
	val invoice: String? = null,
	val relatedPerson: String? = null,
	val useLegacyBase: Boolean = false,
)

/*
 * Names of the builtin manifests (entity or extensions manifests) that clash with a name provided by the custom
 * configuration can't be used as-is: instead of failing we mask them by prepending underscores until we get a name
 * that is not used by the custom configuration nor by any other (masked or not) builtin manifest name.
 */
private fun maskClashingBaseNames(baseNames: Set<String>, customNames: Set<String>): Map<String, String> {
	val takenNames = (baseNames + customNames).toMutableSet()
	val translations = mutableMapOf<String, String>()
	for (baseName in baseNames) {
		if (baseName in customNames) {
			var maskedName = "_$baseName"
			while (maskedName in takenNames) maskedName = "_$maskedName"
			translations[baseName] = maskedName
			takenNames += maskedName
		}
	}
	return translations
}

private fun ExtensionsEncryptionManifest.Recursive.masked(mask: Map<String, String>): ExtensionsEncryptionManifest.Recursive = when (this) {
	is ExtensionsEncryptionManifest.Recursive.Collection -> ExtensionsEncryptionManifest.Recursive.Collection(recursive.masked(mask))
	is ExtensionsEncryptionManifest.Recursive.Map -> ExtensionsEncryptionManifest.Recursive.Map(recursive.masked(mask))
	is ExtensionsEncryptionManifest.Recursive.Object -> ExtensionsEncryptionManifest.Recursive.Object(mask[manifestName] ?: manifestName)
}

private fun ExtensionsEncryptionManifest.masked(mask: Map<String, String>): ExtensionsEncryptionManifest = ExtensionsEncryptionManifest(
	fullEncryptionFields = fullEncryptionFields,
	recursiveEncryptionFields = recursiveEncryptionFields.mapValues { (_, recursive) -> recursive.masked(mask) },
)

private fun PartialEncryptedManifest.buildFullManifest(): EntitiesEncryptionManifests {
	val base = if (useLegacyBase) legacyEntitiesEncryptionManifests else defaultEntitiesEncryptionManifests
	val baseNameMask = maskClashingBaseNames(base.manifestsByName.keys, manifestsByName.keys)
	val baseExtensionsNameMask = maskClashingBaseNames(base.extensionsManifestsByName.keys, extensionsManifestsByName.keys)
	fun String.masked() = baseNameMask[this] ?: this
	fun String.maskedExtension() = baseExtensionsNameMask[this] ?: this
	val maskedBaseManifestsByName = base.manifestsByName.entries.associate { (name, manifest) ->
		name.masked() to manifest.copy(
			recursiveEncryption = manifest.recursiveEncryption.mapValues { (_, referencedName) -> referencedName.masked() },
			extensionsManifestsByModelVersion = manifest.extensionsManifestsByModelVersion.mapValues { (_, byVersion) ->
				byVersion.mapValues { (_, extensionsManifestName) -> extensionsManifestName.maskedExtension() }
			},
			currentExtensionsManifest = manifest.currentExtensionsManifest?.maskedExtension(),
		)
	}
	val maskedBaseExtensionsManifestsByName = base.extensionsManifestsByName.entries.associate { (name, manifest) ->
		name.maskedExtension() to manifest.masked(baseExtensionsNameMask)
	}
	return EntitiesEncryptionManifests(
		manifestsByName = manifestsByName + maskedBaseManifestsByName,
		extensionsManifestsByName = extensionsManifestsByName + maskedBaseExtensionsManifestsByName,
		accessLog = accessLog ?: base.accessLog.masked(),
		calendarItem = calendarItem ?: base.calendarItem.masked(),
		contact = contact ?: base.contact.masked(),
		healthElement = healthElement ?: base.healthElement.masked(),
		patient = patient ?: base.patient.masked(),
		message = message ?: base.message.masked(),
		topic = topic ?: base.topic.masked(),
		document = document ?: base.document.masked(),
		form = form ?: base.form.masked(),
		receipt = receipt ?: base.receipt.masked(),
		classification = classification ?: base.classification.masked(),
		invoice = invoice ?: base.invoice.masked(),
		relatedPerson = relatedPerson ?: base.relatedPerson.masked(),
	)
}