// auto-generated file
package com.icure.cardinal.sdk.py.filters.ContactFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.ContactFilters
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class AllContactsForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allContactsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AllContactsForDataOwnerParams>(params)
	ContactFilters.allContactsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class AllContactsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun allContactsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<AllContactsForDataOwnerInGroupParams>(params)
	ContactFilters.allContactsForDataOwnerInGroup(
		decodedParams.dataOwner,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

public fun allContactsForSelf(): String = kotlin.runCatching {
	ContactFilters.allContactsForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByFormIdsForDataOwnerParams(
	public val dataOwnerId: String,
	public val formIds: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun byFormIdsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByFormIdsForDataOwnerParams>(params)
	ContactFilters.byFormIdsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.formIds,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByFormIdsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val formIds: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun byFormIdsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByFormIdsForDataOwnerInGroupParams>(params)
	ContactFilters.byFormIdsForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.formIds,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByFormIdsForSelfParams(
	public val formIds: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun byFormIdsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByFormIdsForSelfParams>(params)
	ContactFilters.byFormIdsForSelf(
		decodedParams.formIds,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsOpeningDateForDataOwnerParams>(params)
	ContactFilters.byPatientsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsOpeningDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<GroupScoped<Patient>>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsOpeningDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsOpeningDateForDataOwnerInGroupParams>(params)
	ContactFilters.byPatientsOpeningDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsOpeningDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsOpeningDateForSelfParams>(params)
	ContactFilters.byPatientsOpeningDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientSecretIdsOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsOpeningDateForDataOwnerParams>(params)
	ContactFilters.byPatientSecretIdsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientSecretIdsOpeningDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsOpeningDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsOpeningDateForDataOwnerInGroupParams>(params)
	ContactFilters.byPatientSecretIdsOpeningDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientSecretIdsOpeningDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsOpeningDateForSelfParams>(params)
	ContactFilters.byPatientSecretIdsOpeningDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersForSelfParams>(params)
	ContactFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	ContactFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByIdentifiersForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerInGroupParams>(params)
	ContactFilters.byIdentifiersForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByCodeAndOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeAndOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodeAndOpeningDateForDataOwnerParams>(params)
	ContactFilters.byCodeAndOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByCodeAndOpeningDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeAndOpeningDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodeAndOpeningDateForDataOwnerInGroupParams>(params)
	ContactFilters.byCodeAndOpeningDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByCodeAndOpeningDateForSelfParams(
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeAndOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodeAndOpeningDateForSelfParams>(params)
	ContactFilters.byCodeAndOpeningDateForSelf(
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByTagAndOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagAndOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagAndOpeningDateForDataOwnerParams>(params)
	ContactFilters.byTagAndOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByTagAndOpeningDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagAndOpeningDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagAndOpeningDateForDataOwnerInGroupParams>(params)
	ContactFilters.byTagAndOpeningDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByOpeningDateForDataOwnerParams>(params)
	ContactFilters.byOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.startDate,
		decodedParams.endDate,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByOpeningDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byOpeningDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByOpeningDateForDataOwnerInGroupParams>(params)
	ContactFilters.byOpeningDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.startDate,
		decodedParams.endDate,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByOpeningDateForSelfParams(
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByOpeningDateForSelfParams>(params)
	ContactFilters.byOpeningDateForSelf(
		decodedParams.startDate,
		decodedParams.endDate,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByServiceTagForSelfParams(
	public val tagType: String,
	public val tagCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byServiceTagForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByServiceTagForSelfParams>(params)
	ContactFilters.byServiceTagForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByServiceTagForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byServiceTagForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByServiceTagForDataOwnerParams>(params)
	ContactFilters.byServiceTagForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByServiceTagForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val tagType: String,
	public val tagCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byServiceTagForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByServiceTagForDataOwnerInGroupParams>(params)
	ContactFilters.byServiceTagForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByServiceCodeForSelfParams(
	public val codeType: String,
	public val codeCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byServiceCodeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByServiceCodeForSelfParams>(params)
	ContactFilters.byServiceCodeForSelf(
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByServiceCodeForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byServiceCodeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByServiceCodeForDataOwnerParams>(params)
	ContactFilters.byServiceCodeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByServiceCodeForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val codeType: String,
	public val codeCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byServiceCodeForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByServiceCodeForDataOwnerInGroupParams>(params)
	ContactFilters.byServiceCodeForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByTagAndOpeningDateForSelfParams(
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagAndOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagAndOpeningDateForSelfParams>(params)
	ContactFilters.byTagAndOpeningDateForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsForDataOwnerParams>(params)
	ContactFilters.byPatientsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<GroupScoped<Patient>>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsForDataOwnerInGroupParams>(params)
	ContactFilters.byPatientsForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsForSelfParams(
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsForSelfParams>(params)
	ContactFilters.byPatientsForSelf(
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsSecretIdsForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForDataOwnerParams>(params)
	ContactFilters.byPatientsSecretIdsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsSecretIdsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForDataOwnerInGroupParams>(params)
	ContactFilters.byPatientsSecretIdsForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByPatientsSecretIdsForSelfParams(
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForSelfParams>(params)
	ContactFilters.byPatientsSecretIdsForSelf(
		decodedParams.secretIds,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))

@Serializable
private class ByServiceIdsParams(
	public val serviceIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byServiceIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByServiceIdsParams>(params)
	ContactFilters.byServiceIds(
		decodedParams.serviceIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)))
