// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.GroupDeletionReport
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun groupDeletionReport_toJs(obj: GroupDeletionReport): GroupDeletionReportJs {
	val type = obj.type
	val id = obj.id
	val server = obj.server
	val status = obj.status.name
	val message = nullToUndefined(
		obj.message
	)
	return GroupDeletionReportJs(js("{" +
		"type:type," +
		"id:id," +
		"server:server," +
		"status:status," +
		"message:message" +
	"}"))
}

public fun groupDeletionReport_fromJs(obj: GroupDeletionReportJs): GroupDeletionReport {
	val type = obj.type
	val id = obj.id
	val server = obj.server
	val status = GroupDeletionReport.Status.valueOf(obj.status)
	val message = undefinedToNull(obj.message)
	return GroupDeletionReport(
		type = type,
		id = id,
		server = server,
		status = status,
		message = message,
	)
}
