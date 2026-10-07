// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.model.embed.HealthcarePartyHistoryStatus
import com.icure.cardinal.sdk.model.embed.HealthcarePartyStatus
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthcarePartyHistoryStatus_toJs(obj: HealthcarePartyHistoryStatus): HealthcarePartyHistoryStatusJs {
	val status = obj.status.name
	val specialisationCode = obj.specialisationCode
	val startDate = longToNumber(obj.startDate)
	val active = obj.active
	return HealthcarePartyHistoryStatusJs(js("{" +
		"status:status," +
		"specialisationCode:specialisationCode," +
		"startDate:startDate," +
		"active:active" +
	"}"))
}

public fun healthcarePartyHistoryStatus_fromJs(obj: HealthcarePartyHistoryStatusJs): HealthcarePartyHistoryStatus {
	val status = HealthcarePartyStatus.valueOf(obj.status)
	val specialisationCode = obj.specialisationCode
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val active = obj.active
	return HealthcarePartyHistoryStatus(
		status = status,
		specialisationCode = specialisationCode,
		startDate = startDate,
		active = active,
	)
}
