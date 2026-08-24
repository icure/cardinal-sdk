// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.PaginationError
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun paginationError_toJs(obj: PaginationError): PaginationErrorJs {
	val statusCode = intToNumber(obj.statusCode)
	val message = obj.message
	val exceptionDetail = nullToUndefined(
		obj.exceptionDetail
	)
	return PaginationErrorJs(js("{" +
		"statusCode:statusCode," +
		"message:message," +
		"exceptionDetail:exceptionDetail" +
	"}"))
}

public fun paginationError_fromJs(obj: PaginationErrorJs): PaginationError {
	val statusCode = numberToInt(obj.statusCode, "obj.statusCode")
	val message = obj.message
	val exceptionDetail = undefinedToNull(obj.exceptionDetail)
	return PaginationError(
		statusCode = statusCode,
		message = message,
		exceptionDetail = exceptionDetail,
	)
}
