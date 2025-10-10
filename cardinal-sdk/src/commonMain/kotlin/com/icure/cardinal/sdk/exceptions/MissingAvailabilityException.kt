package com.icure.cardinal.sdk.exceptions

import com.icure.cardinal.sdk.api.raw.ApiExceptionBody

/**
 * Exception used when booking calendar items
 */
class MissingAvailabilityException(message: String) : Exception(message) {
	internal companion object : ApiExceptionParser {
		override fun tryParseExceptionBody(
			exceptionBody: ApiExceptionBody,
			requestStatusCode: Int
		): Throwable? = if (requestStatusCode == STATUS_CODE && exceptionBody.exceptionDetail == EXCEPTION_DETAIL) {
			MissingAvailabilityException(exceptionBody.message)
		} else null

		private const val EXCEPTION_DETAIL = "MissingAvailability"
		private const val STATUS_CODE = 409
	}
}