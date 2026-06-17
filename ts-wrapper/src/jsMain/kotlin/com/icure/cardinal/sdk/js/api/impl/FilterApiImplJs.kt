// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.FilterApi
import com.icure.cardinal.sdk.js.api.FilterApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.filter.FilterOptionGroupWithViewsJs
import com.icure.cardinal.sdk.js.model.filter.filterOptionGroupWithViews_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.filter.FilterOptionGroupWithViews
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class FilterApiImplJs(
	private val filterApi: FilterApi,
) : FilterApiJs {
	override fun getFilterOptionsDefinitions():
			Promise<Record<String, Array<FilterOptionGroupWithViewsJs>>> = GlobalScope.promise {
		val result = filterApi.getFilterOptionsDefinitions(
		)
		mapToObject(
			result,
			{ x1: String ->
				x1
			},
			{ x1: List<FilterOptionGroupWithViews> ->
				listToArray(
					x1,
					{ x2: FilterOptionGroupWithViews ->
						filterOptionGroupWithViews_toJs(x2)
					},
				)
			},
		)
	}
}
