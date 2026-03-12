// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.accesslog

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.time.Instant

/**
 * Filter that matches access logs within a date range.
 * /
 */
@SerialName("AccessLogByDateFilter")
@Serializable
data class AccessLogByDateFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The start of the date range (inclusive).
	 */
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant?,
	/**
	 * The end of the date range (inclusive).
	 */
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant?,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean?,
) : AbstractFilter<AccessLog> {
	// region AccessLogByDateFilter-AccessLogByDateFilter

	// endregion
}
