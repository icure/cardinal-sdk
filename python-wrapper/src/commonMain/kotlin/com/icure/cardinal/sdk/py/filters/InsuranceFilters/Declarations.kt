// auto-generated file
package com.icure.cardinal.sdk.py.filters.InsuranceFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.InsuranceFilters
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	InsuranceFilters.all()
}.toPyString(BaseFilterOptions.serializer(Insurance.serializer()))

@Serializable
private class ByIdentifiersParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiers(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersParams>(params)
	InsuranceFilters.byIdentifiers(
		decodedParams.identifiers,
	)
}.toPyString(BaseFilterOptions.serializer(Insurance.serializer()))

@Serializable
private class ByCodeParams(
	public val codeType: String,
	public val codeCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCode(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByCodeParams>(params)
	InsuranceFilters.byCode(
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(Insurance.serializer()))

@Serializable
private class ByTagParams(
	public val tagType: String,
	public val tagCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTag(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTagParams>(params)
	InsuranceFilters.byTag(
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(Insurance.serializer()))
