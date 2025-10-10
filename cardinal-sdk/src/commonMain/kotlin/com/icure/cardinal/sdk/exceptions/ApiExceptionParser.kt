package com.icure.cardinal.sdk.exceptions

import com.icure.cardinal.sdk.api.raw.ApiExceptionBody

internal interface ApiExceptionParser {
	fun tryParseExceptionBody(
		exceptionBody: ApiExceptionBody,
		requestStatusCode: Int,
	): Throwable?
}