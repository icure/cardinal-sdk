// auto-generated file
package com.icure.cardinal.sdk.py.filters.HealthcarePartyFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.HealthcarePartyFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	HealthcarePartyFilters.all()
}.toPyString(BaseFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByIdentifiersParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiers(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersParams>(params)
	HealthcarePartyFilters.byIdentifiers(
		decodedParams.identifiers,
	)
}.toPyString(BaseFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByCodeParams(
	public val codeType: String,
	public val codeCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCode(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByCodeParams>(params)
	HealthcarePartyFilters.byCode(
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByTagParams(
	public val tagType: String,
	public val tagCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTag(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTagParams>(params)
	HealthcarePartyFilters.byTag(
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	HealthcarePartyFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(SortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByNameParams(
	public val searchString: String,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byName(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByNameParams>(params)
	HealthcarePartyFilters.byName(
		decodedParams.searchString,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByNationalIdentifierParams(
	public val searchString: String,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byNationalIdentifier(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByNationalIdentifierParams>(params)
	HealthcarePartyFilters.byNationalIdentifier(
		decodedParams.searchString,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByParentIdParams(
	public val parentId: String,
)

@OptIn(InternalIcureApi::class)
public fun byParentId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByParentIdParams>(params)
	HealthcarePartyFilters.byParentId(
		decodedParams.parentId,
	)
}.toPyString(BaseFilterOptions.serializer(HealthcareParty.serializer()))
