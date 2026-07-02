// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.InsuranceFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.InsuranceJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.model.base.Identifier
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalInsuranceFiltersObj {
	public fun all(): BaseFilterOptionsJs<InsuranceJs> {
		val result = InsuranceFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byIdentifiers(identifiers: Array<IdentifierJs>): BaseFilterOptionsJs<InsuranceJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = InsuranceFilters.byIdentifiers(
			identifiersConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byCode(codeType: String, options: dynamic): BaseSortableFilterOptionsJs<InsuranceJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val result = InsuranceFilters.byCode(
			codeTypeConverted,
			codeCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTag(tagType: String, options: dynamic): BaseSortableFilterOptionsJs<InsuranceJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val result = InsuranceFilters.byTag(
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
