package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import com.icure.cardinal.sdk.model.filter.service.ServiceByDataOwnerCodeCodesFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByDataOwnerPatientCodeCodesFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByDataOwnerPatientTagCodesFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByDataOwnerTagCodesFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyCodesFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyPatientCodesFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyPatientTagCodesFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyTagCodesFilter
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

@OptIn(InternalIcureApi::class)
class ServiceFiltersTest : StringSpec({

	val dataOwnerId = "data-owner-1"
	val codeCodes = mapOf("LOINC" to setOf("12345", "67890"), "ATC" to setOf("A01"))
	val tagCodes = mapOf("CD-ITEM" to setOf("clinical", "technical"), "CD-LIFECYCLE" to setOf("active"))
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

	// --- Version filtering of the codes and tag codes filters ---

	suspend fun mapped(filter: FilterOptions<com.icure.cardinal.sdk.model.embed.Service>) =
		mapServiceFilterOptions(filter, selfDataOwner = null, entityEncryptionService = null, boundGroup = null, requestGroup = null)

	"codes and tag codes filters have no version filtering by default".config(enabled = DEFAULT_ENABLED) {
		ServiceFilters.byCodesAndValueDateForDataOwner(dataOwnerId, codeCodes)
			.shouldBeInstanceOf<ServiceFilters.ByCodesAndValueDateForDataOwner>().versionFiltering shouldBe null
		ServiceFilters.byTagCodesAndValueDateForSelf(tagCodes)
			.shouldBeInstanceOf<ServiceFilters.ByTagCodesAndValueDateForSelf>().versionFiltering shouldBe null
		ServiceFilters.byPatientsCodesAndValueDateForSelf(patients, codeCodes)
			.shouldBeInstanceOf<ServiceFilters.ByPatientsCodesAndValueDateForSelf>().versionFiltering shouldBe null
		ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(inGroupRef, secretIds, tagCodes)
			.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsTagCodesAndValueDateForDataOwner>().versionFiltering shouldBe null
	}

	"codes and tag codes filters keep their version filtering".config(enabled = DEFAULT_ENABLED) {
		ServiceFilters.byCodesAndValueDateForDataOwnerInGroup(inGroupRef, codeCodes, versionFiltering = VersionFiltering.Any)
			.shouldBeInstanceOf<ServiceFilters.ByCodesAndValueDateForDataOwner>().versionFiltering shouldBe VersionFiltering.Any
		ServiceFilters.byTagCodesAndValueDateForDataOwner(dataOwnerId, tagCodes, versionFiltering = VersionFiltering.Latest)
			.shouldBeInstanceOf<ServiceFilters.ByTagCodesAndValueDateForDataOwner>().versionFiltering shouldBe VersionFiltering.Latest
		ServiceFilters.byPatientsTagCodesAndValueDateForDataOwner(dataOwnerId, patients, tagCodes, versionFiltering = VersionFiltering.Any)
			.shouldBeInstanceOf<ServiceFilters.ByPatientsTagCodesAndValueDateForDataOwner>().versionFiltering shouldBe VersionFiltering.Any
		ServiceFilters.byPatientSecretIdsCodesAndValueDateForSelf(secretIds, codeCodes, versionFiltering = VersionFiltering.Any)
			.shouldBeInstanceOf<ServiceFilters.ByPatientSecretIdsCodesAndValueDateForSelf>().versionFiltering shouldBe VersionFiltering.Any
	}

	"codes filter without version filtering maps to ServiceByHcPartyCodesFilter".config(enabled = DEFAULT_ENABLED) {
		mapped(ServiceFilters.byCodesAndValueDateForDataOwner(dataOwnerId, codeCodes, startDate, endDate)) shouldBe
			ServiceByHcPartyCodesFilter(
				healthcarePartyId = dataOwnerId,
				codeCodes = codeCodes,
				startValueDate = startDate,
				endValueDate = endDate,
			)
	}

	"codes filter with version filtering maps to ServiceByDataOwnerCodeCodesFilter".config(enabled = DEFAULT_ENABLED) {
		mapped(ServiceFilters.byCodesAndValueDateForDataOwner(dataOwnerId, codeCodes, startDate, endDate, VersionFiltering.Any)) shouldBe
			ServiceByDataOwnerCodeCodesFilter(
				dataOwnerId = dataOwnerId,
				codeCodes = codeCodes,
				startValueDate = startDate,
				endValueDate = endDate,
				filterVersion = VersionFiltering.Any,
			)
	}

	"tag codes filter maps to the filter matching its version filtering".config(enabled = DEFAULT_ENABLED) {
		mapped(ServiceFilters.byTagCodesAndValueDateForDataOwner(dataOwnerId, tagCodes)) shouldBe
			ServiceByHcPartyTagCodesFilter(healthcarePartyId = dataOwnerId, tagCodes = tagCodes)
		mapped(ServiceFilters.byTagCodesAndValueDateForDataOwner(dataOwnerId, tagCodes, versionFiltering = VersionFiltering.Latest)) shouldBe
			ServiceByDataOwnerTagCodesFilter(dataOwnerId = dataOwnerId, tagCodes = tagCodes, filterVersion = VersionFiltering.Latest)
	}

	"patient secret ids codes filter maps to the filter matching its version filtering".config(enabled = DEFAULT_ENABLED) {
		mapped(ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwner(dataOwnerId, secretIds, codeCodes)) shouldBe
			ServiceByHcPartyPatientCodesFilter(
				healthcarePartyId = dataOwnerId,
				patientSecretForeignKeys = secretIds.toSet(),
				codeCodes = codeCodes,
			)
		mapped(ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwner(dataOwnerId, secretIds, codeCodes, versionFiltering = VersionFiltering.Any)) shouldBe
			ServiceByDataOwnerPatientCodeCodesFilter(
				dataOwnerId = dataOwnerId,
				patientSecretForeignKeys = secretIds.toSet(),
				codeCodes = codeCodes,
				filterVersion = VersionFiltering.Any,
			)
	}

	"patient secret ids tag codes filter maps to the filter matching its version filtering".config(enabled = DEFAULT_ENABLED) {
		mapped(ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(inGroupRef, secretIds, tagCodes)) shouldBe
			ServiceByHcPartyPatientTagCodesFilter(
				healthcarePartyId = "group-1/data-owner-2",
				patientSecretForeignKeys = secretIds.toSet(),
				tagCodes = tagCodes,
			)
		mapped(ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(inGroupRef, secretIds, tagCodes, versionFiltering = VersionFiltering.Latest)) shouldBe
			ServiceByDataOwnerPatientTagCodesFilter(
				dataOwnerId = "group-1/data-owner-2",
				patientSecretForeignKeys = secretIds.toSet(),
				tagCodes = tagCodes,
				filterVersion = VersionFiltering.Latest,
			)
	}
})
