package com.icure.cardinal.sdk.model.filter.maintenancetask

import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@SerialName("MaintenanceTaskAfterDateFilter")
@Serializable
public data class MaintenanceTaskAfterDateFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val date: Long,
) : AbstractFilter<MaintenanceTask>
