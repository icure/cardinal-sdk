package com.icure.cardinal.sdk.model.filter.maintenancetask

import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("MaintenanceTaskByIdsFilter")
@Serializable
public data class MaintenanceTaskByIdsFilter(
	override val ids: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<MaintenanceTask>, Filter.IdsFilter<String, MaintenanceTask>
