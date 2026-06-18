// auto-generated file
package com.icure.cardinal.sdk.js.model.filter

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.model.filter.FilterOptionGroupWithViews
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun filterOptionGroupWithViews_toJs(obj: FilterOptionGroupWithViews):
		FilterOptionGroupWithViewsJs {
	val name = obj.name
	val factoryMethods = listToArray(
		obj.factoryMethods,
		{ x1: String ->
			x1
		},
	)
	val targetFilter = obj.targetFilter
	val views = listToArray(
		obj.views,
		{ x1: String ->
			x1
		},
	)
	return FilterOptionGroupWithViewsJs(js("{" +
		"name:name," +
		"factoryMethods:factoryMethods," +
		"targetFilter:targetFilter," +
		"views:views" +
	"}"))
}

public fun filterOptionGroupWithViews_fromJs(obj: FilterOptionGroupWithViewsJs):
		FilterOptionGroupWithViews {
	val name = obj.name
	val factoryMethods = arrayToList(
		obj.factoryMethods,
		"obj.factoryMethods",
		{ x1: String ->
			x1
		},
	)
	val targetFilter = obj.targetFilter
	val views = arrayToList(
		obj.views,
		"obj.views",
		{ x1: String ->
			x1
		},
	)
	return FilterOptionGroupWithViews(
		name = name,
		factoryMethods = factoryMethods,
		targetFilter = targetFilter,
		views = views,
	)
}
