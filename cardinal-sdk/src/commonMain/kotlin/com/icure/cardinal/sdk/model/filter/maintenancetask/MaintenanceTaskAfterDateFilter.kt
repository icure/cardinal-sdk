package com.icure.cardinal.sdk.model.filter.maintenancetask

import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Filter that matches maintenance tasks created after a specific date.
 * /
 */
@SerialName("MaintenanceTaskAfterDateFilter")
@Serializable
public data class MaintenanceTaskAfterDateFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The date threshold; only tasks after this date are matched.
	 */
	public val date: Long,
) : AbstractFilter<MaintenanceTask>
