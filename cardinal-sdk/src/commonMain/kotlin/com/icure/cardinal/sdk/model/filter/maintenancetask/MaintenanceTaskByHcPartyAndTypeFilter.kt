package com.icure.cardinal.sdk.model.filter.maintenancetask

import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches maintenance tasks by healthcare party and task type.
 * /
 */
@SerialName("MaintenanceTaskByHcPartyAndTypeFilter")
@Serializable
public data class MaintenanceTaskByHcPartyAndTypeFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The type of maintenance task to match.
	 */
	public val type: String,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
) : AbstractFilter<MaintenanceTask>
