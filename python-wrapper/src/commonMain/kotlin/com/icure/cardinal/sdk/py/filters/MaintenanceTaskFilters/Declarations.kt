// auto-generated file
package com.icure.cardinal.sdk.py.filters.MaintenanceTaskFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.MaintenanceTaskFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	MaintenanceTaskFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	MaintenanceTaskFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersForSelfParams>(params)
	MaintenanceTaskFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)))

@Serializable
private class ByTypeForDataOwnerParams(
	public val dataOwnerId: String,
	public val type: String,
)

@OptIn(InternalIcureApi::class)
public fun byTypeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTypeForDataOwnerParams>(params)
	MaintenanceTaskFilters.byTypeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.type,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)))

@Serializable
private class ByTypeForSelfParams(
	public val type: String,
)

@OptIn(InternalIcureApi::class)
public fun byTypeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTypeForSelfParams>(params)
	MaintenanceTaskFilters.byTypeForSelf(
		decodedParams.type,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)))

@Serializable
private class AfterDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val date: Long,
)

@OptIn(InternalIcureApi::class)
public fun afterDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AfterDateForDataOwnerParams>(params)
	MaintenanceTaskFilters.afterDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.date,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)))

@Serializable
private class AfterDateForSelfParams(
	public val date: Long,
)

@OptIn(InternalIcureApi::class)
public fun afterDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AfterDateForSelfParams>(params)
	MaintenanceTaskFilters.afterDateForSelf(
		decodedParams.date,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)))
