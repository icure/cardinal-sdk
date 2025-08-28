package com.icure.cardinal.sdk.model.filter.accesslog

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("AccessLogByDateFilter")
@Serializable
public data class AccessLogByDateFilter(
	override val desc: String? = null,
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant?,
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant?,
	public val descending: Boolean?,
) : AbstractFilter<AccessLog>
