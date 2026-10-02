// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.GroupFilters
import com.icure.cardinal.sdk.js.model.GroupJs
import kotlin.String
import kotlin.js.JsExport

@JsExport
public object InternalGroupFiltersObj {
	public fun all(): BaseFilterOptionsJs<GroupJs> {
		val result = GroupFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun bySuperGroup(superGroupId: String): BaseFilterOptionsJs<GroupJs> {
		val superGroupIdConverted: String = superGroupId
		val result = GroupFilters.bySuperGroup(
			superGroupIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun withContent(superGroupId: String, searchString: String): BaseSortableFilterOptionsJs<GroupJs> {
		val superGroupIdConverted: String = superGroupId
		val searchStringConverted: String = searchString
		val result = GroupFilters.withContent(
			superGroupIdConverted,
			searchStringConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
