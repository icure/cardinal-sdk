package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

@Serializable
public data class HealthcarePartyHistoryStatus(
	public val status: HealthcarePartyStatus,
	public val specialisationCode: String,
	public val startDate: Long,
	public val active: Boolean,
)
