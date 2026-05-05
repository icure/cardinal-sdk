// auto-generated file
package com.icure.cardinal.sdk.py.filters.PatientFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.PatientFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class AllPatientsForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AllPatientsForDataOwnerParams>(params)
	PatientFilters.allPatientsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class AllPatientsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun allPatientsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<AllPatientsForDataOwnerInGroupParams>(params)
	PatientFilters.allPatientsForDataOwnerInGroup(
		decodedParams.dataOwner,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

public fun allPatientsForSelf(): String = kotlin.runCatching {
	PatientFilters.allPatientsForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	PatientFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	PatientFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByIdentifiersForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerInGroupParams>(params)
	PatientFilters.byIdentifiersForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class BySsinsForDataOwnerParams(
	public val dataOwnerId: String,
	public val ssins: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun bySsinsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<BySsinsForDataOwnerParams>(params)
	PatientFilters.bySsinsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.ssins,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class BySsinsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val ssins: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun bySsinsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<BySsinsForDataOwnerInGroupParams>(params)
	PatientFilters.bySsinsForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.ssins,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByDateOfBirthBetweenForDataOwnerParams(
	public val dataOwnerId: String,
	public val fromDate: Int,
	public val toDate: Int,
)

@OptIn(InternalIcureApi::class)
public fun byDateOfBirthBetweenForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByDateOfBirthBetweenForDataOwnerParams>(params)
	PatientFilters.byDateOfBirthBetweenForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.fromDate,
		decodedParams.toDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByDateOfBirthBetweenForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val fromDate: Int,
	public val toDate: Int,
)

@OptIn(InternalIcureApi::class)
public fun byDateOfBirthBetweenForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByDateOfBirthBetweenForDataOwnerInGroupParams>(params)
	PatientFilters.byDateOfBirthBetweenForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.fromDate,
		decodedParams.toDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByFuzzyNameForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byFuzzyNameForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByFuzzyNameForDataOwnerParams>(params)
	PatientFilters.byFuzzyNameForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByFuzzyNameForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byFuzzyNameForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByFuzzyNameForDataOwnerInGroupParams>(params)
	PatientFilters.byFuzzyNameForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.searchString,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByGenderEducationProfessionForDataOwnerParams(
	public val dataOwnerId: String,
	public val gender: Gender,
	public val education: String? = null,
	public val profession: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byGenderEducationProfessionForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByGenderEducationProfessionForDataOwnerParams>(params)
	PatientFilters.byGenderEducationProfessionForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.gender,
		decodedParams.education,
		decodedParams.profession,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByGenderEducationProfessionForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val gender: Gender,
	public val education: String? = null,
	public val profession: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byGenderEducationProfessionForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByGenderEducationProfessionForDataOwnerInGroupParams>(params)
	PatientFilters.byGenderEducationProfessionForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.gender,
		decodedParams.education,
		decodedParams.profession,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByActiveForDataOwnerParams(
	public val dataOwnerId: String,
	public val active: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun byActiveForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByActiveForDataOwnerParams>(params)
	PatientFilters.byActiveForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.active,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByActiveForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val active: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun byActiveForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByActiveForDataOwnerInGroupParams>(params)
	PatientFilters.byActiveForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.active,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByTelecomForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byTelecomForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTelecomForDataOwnerParams>(params)
	PatientFilters.byTelecomForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByTelecomForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byTelecomForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTelecomForDataOwnerInGroupParams>(params)
	PatientFilters.byTelecomForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressPostalCodeHouseNumberForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
	public val postalCode: String,
	public val houseNumber: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byAddressPostalCodeHouseNumberForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByAddressPostalCodeHouseNumberForDataOwnerParams>(params)
	PatientFilters.byAddressPostalCodeHouseNumberForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
		decodedParams.postalCode,
		decodedParams.houseNumber,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressPostalCodeHouseNumberForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val searchString: String,
	public val postalCode: String,
	public val houseNumber: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byAddressPostalCodeHouseNumberForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByAddressPostalCodeHouseNumberForDataOwnerInGroupParams>(params)
	PatientFilters.byAddressPostalCodeHouseNumberForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.searchString,
		decodedParams.postalCode,
		decodedParams.houseNumber,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byAddressForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByAddressForDataOwnerParams>(params)
	PatientFilters.byAddressForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byAddressForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByAddressForDataOwnerInGroupParams>(params)
	PatientFilters.byAddressForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersForSelfParams>(params)
	PatientFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class BySsinsForSelfParams(
	public val ssins: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun bySsinsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<BySsinsForSelfParams>(params)
	PatientFilters.bySsinsForSelf(
		decodedParams.ssins,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByDateOfBirthBetweenForSelfParams(
	public val fromDate: Int,
	public val toDate: Int,
)

@OptIn(InternalIcureApi::class)
public fun byDateOfBirthBetweenForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByDateOfBirthBetweenForSelfParams>(params)
	PatientFilters.byDateOfBirthBetweenForSelf(
		decodedParams.fromDate,
		decodedParams.toDate,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByNameForSelfParams(
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byNameForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByNameForSelfParams>(params)
	PatientFilters.byNameForSelf(
		decodedParams.searchString,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByGenderEducationProfessionForSelfParams(
	public val gender: Gender,
	public val education: String? = null,
	public val profession: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byGenderEducationProfessionForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByGenderEducationProfessionForSelfParams>(params)
	PatientFilters.byGenderEducationProfessionForSelf(
		decodedParams.gender,
		decodedParams.education,
		decodedParams.profession,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByActiveForSelfParams(
	public val active: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun byActiveForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByActiveForSelfParams>(params)
	PatientFilters.byActiveForSelf(
		decodedParams.active,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByTelecomForSelfParams(
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byTelecomForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTelecomForSelfParams>(params)
	PatientFilters.byTelecomForSelf(
		decodedParams.searchString,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressPostalCodeHouseNumberForSelfParams(
	public val searchString: String,
	public val postalCode: String,
	public val houseNumber: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byAddressPostalCodeHouseNumberForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByAddressPostalCodeHouseNumberForSelfParams>(params)
	PatientFilters.byAddressPostalCodeHouseNumberForSelf(
		decodedParams.searchString,
		decodedParams.postalCode,
		decodedParams.houseNumber,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressForSelfParams(
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byAddressForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByAddressForSelfParams>(params)
	PatientFilters.byAddressForSelf(
		decodedParams.searchString,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByTagForSelfParams(
	public val tagType: String,
	public val tagCode: String?,
)

@OptIn(InternalIcureApi::class)
public fun byTagForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTagForSelfParams>(params)
	PatientFilters.byTagForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByTagForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String?,
)

@OptIn(InternalIcureApi::class)
public fun byTagForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTagForDataOwnerParams>(params)
	PatientFilters.byTagForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByTagForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val tagType: String,
	public val tagCode: String?,
)

@OptIn(InternalIcureApi::class)
public fun byTagForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagForDataOwnerInGroupParams>(params)
	PatientFilters.byTagForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))
