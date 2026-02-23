// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.FormTemplateFilters
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import kotlin.String
import kotlin.js.JsExport

@JsExport
public object InternalFormTemplateFiltersObj {
	public fun bySpecialtyCode(specialtyCode: String): BaseFilterOptionsJs<FormTemplateJs> {
		val specialtyCodeConverted: String = specialtyCode
		val result = FormTemplateFilters.bySpecialtyCode(
			specialtyCodeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
