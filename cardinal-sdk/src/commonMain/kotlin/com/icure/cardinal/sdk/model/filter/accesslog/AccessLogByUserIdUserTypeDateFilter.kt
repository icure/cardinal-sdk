package com.icure.cardinal.sdk.model.filter.accesslog

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("AccessLogByUserIdUserTypeDateFilter")
@Serializable
public data class AccessLogByUserIdUserTypeDateFilter(
	public val userId: String,
	public val accessType: String?,
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant?,
	public val descending: Boolean?,
	override val desc: String? = null,
) : AbstractFilter<AccessLog>
