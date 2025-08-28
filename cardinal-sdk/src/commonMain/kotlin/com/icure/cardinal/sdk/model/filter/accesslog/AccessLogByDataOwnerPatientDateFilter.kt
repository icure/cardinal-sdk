package com.icure.cardinal.sdk.model.filter.accesslog

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.Set

@SerialName("AccessLogByDataOwnerPatientDateFilter")
@Serializable
public data class AccessLogByDataOwnerPatientDateFilter(
	public val dataOwnerId: String,
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant?,
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant?,
	public val secretPatientIds: Set<String>,
	public val descending: Boolean?,
	override val desc: String? = null,
) : AbstractFilter<AccessLog>
