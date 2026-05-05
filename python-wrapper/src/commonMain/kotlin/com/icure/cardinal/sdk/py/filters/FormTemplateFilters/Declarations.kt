// auto-generated file
package com.icure.cardinal.sdk.py.filters.FormTemplateFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.FormTemplateFilters
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
private class BySpecialtyCodeParams(
	public val specialtyCode: String,
)

@OptIn(InternalIcureApi::class)
public fun bySpecialtyCode(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<BySpecialtyCodeParams>(params)
	FormTemplateFilters.bySpecialtyCode(
		decodedParams.specialtyCode,
	)
}.toPyString(BaseFilterOptions.serializer(FormTemplate.serializer()))
