// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.maintenancetask

import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches maintenance tasks by their unique identifiers.
 * /
 */
@SerialName("MaintenanceTaskByIdsFilter")
@Serializable
data class MaintenanceTaskByIdsFilter(
	/**
	 * The set of maintenance task identifiers to match.
	 */
	override val ids: Set<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<MaintenanceTask>, Filter.IdsFilter<String, MaintenanceTask> {
	// region MaintenanceTaskByIdsFilter-MaintenanceTaskByIdsFilter

	// endregion
}
