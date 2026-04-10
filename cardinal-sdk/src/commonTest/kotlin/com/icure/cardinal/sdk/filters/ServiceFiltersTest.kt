package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

@OptIn(InternalIcureApi::class)
class ServiceFiltersTest : StringSpec({

	val dataOwnerId = "data-owner-1"
	val codeCodes = mapOf("LOINC" to listOf("12345", "67890"), "ATC" to listOf("A01"))
	val tagCodes = mapOf("CD-ITEM" to listOf("clinical", "technical"), "CD-LIFECYCLE" to listOf("active"))
	val codeType = "LOINC"
	val codeCodePrefix = "123"
	val tagType = "CD-ITEM"
	val tagCodePrefix = "clin"
	val startDate = 20240101L
	val endDate = 20241231L
	val secretIds = listOf("secret-1", "secret-2")
	val patients = listOf(
		DecryptedPatient(id = "patient-1"),
		DecryptedPatient(id = "patient-2")
	)
	val patientStubs = patients.map { it.toEncryptionMetadataStub() }
	val inGroupRef = EntityReferenceInGroup(entityId = "data-owner-2", groupId = "group-1")

	// --- Codes (Map) filters ---

	"byCodesAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byCodesAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			codeCodes = codeCodes,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<BaseFilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.codeCodes shouldBe codeCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byCodesAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byCodesAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			codeCodes = codeCodes,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.codeCodes shouldBe codeCodes
		internal.startOfServiceValueDate shouldBe null
		internal.endOfServiceValueDate shouldBe null
	}

	"byCodesAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byCodesAndValueDateForSelf(
			codeCodes = codeCodes,
			startOfServiceValueDate = startDate,
		)
		filter.shouldBeInstanceOf<FilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByCodesAndValueDateForSelf>()
		internal.codeCodes shouldBe codeCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe null
	}

	// --- Code prefix filters ---

	"byCodePrefixAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byCodePrefixAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<BaseFilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByCodePrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.codeType shouldBe codeType
		internal.codeCodePrefix shouldBe codeCodePrefix
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byCodePrefixAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byCodePrefixAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByCodePrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.codeType shouldBe codeType
		internal.codeCodePrefix shouldBe codeCodePrefix
	}

	"byCodePrefixAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byCodePrefixAndValueDateForSelf(
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
			endOfServiceValueDate = endDate,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByCodePrefixAndValueDateForSelf>()
		internal.codeType shouldBe codeType
		internal.codeCodePrefix shouldBe codeCodePrefix
		internal.startOfServiceValueDate shouldBe null
		internal.endOfServiceValueDate shouldBe endDate
	}

	// --- Tag codes (Map) filters ---

	"byTagCodesAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byTagCodesAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			tagCodes = tagCodes,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<BaseFilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByTagCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.tagCodes shouldBe tagCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byTagCodesAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byTagCodesAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			tagCodes = tagCodes,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByTagCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.tagCodes shouldBe tagCodes
	}

	"byTagCodesAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byTagCodesAndValueDateForSelf(
			tagCodes = tagCodes,
			startOfServiceValueDate = startDate,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByTagCodesAndValueDateForSelf>()
		internal.tagCodes shouldBe tagCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe null
	}

	// --- Tag prefix filters ---

	"byTagPrefixAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byTagPrefixAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<BaseFilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByTagPrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.tagType shouldBe tagType
		internal.tagCodePrefix shouldBe tagCodePrefix
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byTagPrefixAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byTagPrefixAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByTagPrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.tagType shouldBe tagType
		internal.tagCodePrefix shouldBe tagCodePrefix
	}

	"byTagPrefixAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byTagPrefixAndValueDateForSelf(
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByTagPrefixAndValueDateForSelf>()
		internal.tagType shouldBe tagType
		internal.tagCodePrefix shouldBe tagCodePrefix
		internal.startOfServiceValueDate shouldBe null
		internal.endOfServiceValueDate shouldBe null
	}

	// --- Patient codes (Map) filters ---

	"byPatientsCodesAndValueDateForDataOwner creates correct filter with patient stubs".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsCodesAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			patients = patients,
			codeCodes = codeCodes,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<FilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.patients shouldBe patientStubs
		internal.codeCodes shouldBe codeCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byPatientsCodesAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsCodesAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			patients = patients,
			codeCodes = codeCodes,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.patients shouldBe patientStubs
		internal.codeCodes shouldBe codeCodes
	}

	"byPatientsCodesAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsCodesAndValueDateForSelf(
			patients = patients,
			codeCodes = codeCodes,
			startOfServiceValueDate = startDate,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsCodesAndValueDateForSelf>()
		internal.patients shouldBe patientStubs
		internal.codeCodes shouldBe codeCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe null
	}

	"byPatientSecretIdsCodesAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			secretIds = secretIds,
			codeCodes = codeCodes,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<BaseFilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.secretIds shouldBe secretIds
		internal.codeCodes shouldBe codeCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byPatientSecretIdsCodesAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			secretIds = secretIds,
			codeCodes = codeCodes,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.secretIds shouldBe secretIds
	}

	"byPatientSecretIdsCodesAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsCodesAndValueDateForSelf(
			secretIds = secretIds,
			codeCodes = codeCodes,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsCodesAndValueDateForSelf>()
		internal.secretIds shouldBe secretIds
		internal.codeCodes shouldBe codeCodes
		internal.startOfServiceValueDate shouldBe null
		internal.endOfServiceValueDate shouldBe null
	}

	// --- Patient code prefix filters ---

	"byPatientsCodePrefixAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsCodePrefixAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			patients = patients,
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsCodePrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.patients shouldBe patientStubs
		internal.codeType shouldBe codeType
		internal.codeCodePrefix shouldBe codeCodePrefix
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byPatientsCodePrefixAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsCodePrefixAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			patients = patients,
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsCodePrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.patients shouldBe patientStubs
	}

	"byPatientsCodePrefixAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsCodePrefixAndValueDateForSelf(
			patients = patients,
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsCodePrefixAndValueDateForSelf>()
		internal.patients shouldBe patientStubs
		internal.codeType shouldBe codeType
		internal.codeCodePrefix shouldBe codeCodePrefix
	}

	"byPatientSecretIdsCodePrefixAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			secretIds = secretIds,
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<BaseFilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsCodePrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.secretIds shouldBe secretIds
		internal.codeType shouldBe codeType
		internal.codeCodePrefix shouldBe codeCodePrefix
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			secretIds = secretIds,
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsCodePrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
	}

	"byPatientSecretIdsCodePrefixAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForSelf(
			secretIds = secretIds,
			codeType = codeType,
			codeCodePrefix = codeCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsCodePrefixAndValueDateForSelf>()
		internal.secretIds shouldBe secretIds
		internal.codeType shouldBe codeType
		internal.codeCodePrefix shouldBe codeCodePrefix
	}

	// --- Patient tag codes (Map) filters ---

	"byPatientsTagCodesAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsTagCodesAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			patients = patients,
			tagCodes = tagCodes,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsTagCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.patients shouldBe patientStubs
		internal.tagCodes shouldBe tagCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byPatientsTagCodesAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsTagCodesAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			patients = patients,
			tagCodes = tagCodes,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsTagCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.patients shouldBe patientStubs
		internal.tagCodes shouldBe tagCodes
	}

	"byPatientsTagCodesAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsTagCodesAndValueDateForSelf(
			patients = patients,
			tagCodes = tagCodes,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsTagCodesAndValueDateForSelf>()
		internal.patients shouldBe patientStubs
		internal.tagCodes shouldBe tagCodes
		internal.startOfServiceValueDate shouldBe null
		internal.endOfServiceValueDate shouldBe null
	}

	"byPatientSecretIdsTagCodesAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			secretIds = secretIds,
			tagCodes = tagCodes,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<BaseFilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsTagCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.secretIds shouldBe secretIds
		internal.tagCodes shouldBe tagCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			secretIds = secretIds,
			tagCodes = tagCodes,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsTagCodesAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.secretIds shouldBe secretIds
	}

	"byPatientSecretIdsTagCodesAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForSelf(
			secretIds = secretIds,
			tagCodes = tagCodes,
			startOfServiceValueDate = startDate,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsTagCodesAndValueDateForSelf>()
		internal.secretIds shouldBe secretIds
		internal.tagCodes shouldBe tagCodes
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe null
	}

	// --- Patient tag prefix filters ---

	"byPatientsTagPrefixAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsTagPrefixAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			patients = patients,
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsTagPrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.patients shouldBe patientStubs
		internal.tagType shouldBe tagType
		internal.tagCodePrefix shouldBe tagCodePrefix
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byPatientsTagPrefixAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsTagPrefixAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			patients = patients,
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsTagPrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.patients shouldBe patientStubs
	}

	"byPatientsTagPrefixAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientsTagPrefixAndValueDateForSelf(
			patients = patients,
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientsTagPrefixAndValueDateForSelf>()
		internal.patients shouldBe patientStubs
		internal.tagType shouldBe tagType
		internal.tagCodePrefix shouldBe tagCodePrefix
	}

	"byPatientSecretIdsTagPrefixAndValueDateForDataOwner creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForDataOwner(
			dataOwnerId = dataOwnerId,
			secretIds = secretIds,
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
			startOfServiceValueDate = startDate,
			endOfServiceValueDate = endDate,
		)
		filter.shouldBeInstanceOf<BaseFilterOptions<*>>()
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsTagPrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
		internal.secretIds shouldBe secretIds
		internal.tagType shouldBe tagType
		internal.tagCodePrefix shouldBe tagCodePrefix
		internal.startOfServiceValueDate shouldBe startDate
		internal.endOfServiceValueDate shouldBe endDate
	}

	"byPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroup passes reference through".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroup(
			dataOwner = inGroupRef,
			secretIds = secretIds,
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsTagPrefixAndValueDateForDataOwner>()
		internal.dataOwnerId shouldBe inGroupRef
		internal.secretIds shouldBe secretIds
	}

	"byPatientSecretIdsTagPrefixAndValueDateForSelf creates correct filter".config(enabled = DEFAULT_ENABLED) {
		val filter = ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForSelf(
			secretIds = secretIds,
			tagType = tagType,
			tagCodePrefix = tagCodePrefix,
			endOfServiceValueDate = endDate,
		)
		val internal = filter.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsTagPrefixAndValueDateForSelf>()
		internal.secretIds shouldBe secretIds
		internal.tagType shouldBe tagType
		internal.tagCodePrefix shouldBe tagCodePrefix
		internal.startOfServiceValueDate shouldBe null
		internal.endOfServiceValueDate shouldBe endDate
	}
})
