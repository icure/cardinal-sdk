package com.icure.cardinal.sdk.model.filter.maintenancetask

import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches maintenance tasks by healthcare party and a list of identifiers.
 * /
 */
@SerialName("MaintenanceTaskByHcPartyAndIdentifiersFilter")
@Serializable
public data class MaintenanceTaskByHcPartyAndIdentifiersFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The list of identifiers to match.
	 */
	@param:DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<MaintenanceTask>
