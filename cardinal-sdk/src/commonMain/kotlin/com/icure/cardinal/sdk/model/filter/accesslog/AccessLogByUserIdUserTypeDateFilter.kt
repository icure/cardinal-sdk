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
 * Filter that matches access logs by user identifier, access type, and start date.
 * /
 */
@SerialName("AccessLogByUserIdUserTypeDateFilter")
@Serializable
public data class AccessLogByUserIdUserTypeDateFilter(
	/**
	 * The identifier of the user who created the access log.
	 */
	public val userId: String,
	/**
	 * The type of access to filter on.
	 */
	public val accessType: String?,
	/**
	 * The start date from which to retrieve access logs.
	 */
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant?,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean?,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<AccessLog>
