// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthcarePartyApiInGroup")
public external interface HealthcarePartyApiInGroupJs {
	public fun matchHealthcarePartiesBy(groupId: String,
			filter: BaseFilterOptionsJs<HealthcarePartyJs>): Promise<Array<String>>
}
