// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.HealthcarePartyFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.model.base.Identifier
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalHealthcarePartyFiltersObj {
	public fun all(): BaseFilterOptionsJs<HealthcarePartyJs> {
		val result = HealthcarePartyFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byIdentifiers(identifiers: Array<IdentifierJs>):
			BaseFilterOptionsJs<HealthcarePartyJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = HealthcarePartyFilters.byIdentifiers(
			identifiersConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byCode(codeType: String, options: dynamic):
			BaseSortableFilterOptionsJs<HealthcarePartyJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val result = HealthcarePartyFilters.byCode(
			codeTypeConverted,
			codeCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTag(tagType: String, options: dynamic):
			BaseSortableFilterOptionsJs<HealthcarePartyJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val result = HealthcarePartyFilters.byTag(
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): SortableFilterOptionsJs<HealthcarePartyJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = HealthcarePartyFilters.byIds(
			idsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byName(searchString: String, options: dynamic):
			BaseSortableFilterOptionsJs<HealthcarePartyJs> {
		val _options = options ?: js("{}")
		val searchStringConverted: String = searchString
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = HealthcarePartyFilters.byName(
			searchStringConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byNationalIdentifier(searchString: String, options: dynamic):
			BaseSortableFilterOptionsJs<HealthcarePartyJs> {
		val _options = options ?: js("{}")
		val searchStringConverted: String = searchString
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = HealthcarePartyFilters.byNationalIdentifier(
			searchStringConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byParentId(parentId: String): BaseFilterOptionsJs<HealthcarePartyJs> {
		val parentIdConverted: String = parentId
		val result = HealthcarePartyFilters.byParentId(
			parentIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
