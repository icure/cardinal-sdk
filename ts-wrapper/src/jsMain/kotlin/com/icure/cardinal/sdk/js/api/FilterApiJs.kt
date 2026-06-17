// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.filter.FilterOptionGroupWithViewsJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FilterApi")
public external interface FilterApiJs {
	public fun getFilterOptionsDefinitions():
			Promise<Record<String, Array<FilterOptionGroupWithViewsJs>>>
}
