package com.icure.cardinal.sdk.model.filter.maintenancetask

import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("MaintenanceTaskByHcPartyAndTypeFilter")
@Serializable
public data class MaintenanceTaskByHcPartyAndTypeFilter(
	override val desc: String? = null,
	public val type: String,
	public val healthcarePartyId: String? = null,
) : AbstractFilter<MaintenanceTask>
