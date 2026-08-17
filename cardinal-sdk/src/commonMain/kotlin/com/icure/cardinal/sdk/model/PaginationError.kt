// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 * The error that aborted a page of results, reported in the body of an otherwise successful
 * response.
 * /
 */
@Serializable
data class PaginationError(
	/**
	 * The status code the request would have failed with, had the error been found before returning
	 * any result.
	 */
	public val statusCode: Int,
	/**
	 * A human readable description of what went wrong.
	 */
	public val message: String,
	/**
	 * A machine readable discriminator for the error, for the errors that define one.
	 */
	public val exceptionDetail: String? = null,
) {
	// region PaginationError-PaginationError
	// endregion
}
