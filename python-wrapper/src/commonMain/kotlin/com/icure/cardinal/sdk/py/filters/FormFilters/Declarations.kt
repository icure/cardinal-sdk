// auto-generated file
package com.icure.cardinal.sdk.py.filters.FormFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.FormFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class ByParentIdForDataOwnerParams(
	public val dataOwnerId: String,
	public val parentId: String,
)

@OptIn(InternalIcureApi::class)
public fun byParentIdForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByParentIdForDataOwnerParams>(params)
	FormFilters.byParentIdForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.parentId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Form::class)))

@Serializable
private class ByParentIdForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val parentId: String,
)

@OptIn(InternalIcureApi::class)
public fun byParentIdForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByParentIdForDataOwnerInGroupParams>(params)
	FormFilters.byParentIdForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.parentId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Form::class)))

@Serializable
private class ByParentIdForSelfParams(
	public val parentId: String,
)

@OptIn(InternalIcureApi::class)
public fun byParentIdForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByParentIdForSelfParams>(params)
	FormFilters.byParentIdForSelf(
		decodedParams.parentId,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Form::class)))

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
	FormFilters.byPatientsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Form::class)))

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
	FormFilters.byPatientsOpeningDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Form::class)))

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
	FormFilters.byPatientsOpeningDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Form::class)))

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
	FormFilters.byPatientSecretIdsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Form::class)))

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
	FormFilters.byPatientSecretIdsOpeningDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Form::class)))

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
	FormFilters.byPatientSecretIdsOpeningDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Form::class)))

@Serializable
private class ByUniqueIdParams(
	public val uniqueId: String,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byUniqueId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByUniqueIdParams>(params)
	FormFilters.byUniqueId(
		decodedParams.uniqueId,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Form::class)))
