package com.icure.cardinal.sdk.model.filter.maintenancetask

import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MaintenanceTaskByHcPartyAndTypeFilter")
@Serializable
data class MaintenanceTaskByHcPartyAndTypeFilter(
	desc: String? = null,
	type: String,
	healthcarePartyId: String? = null,
) : AbstractFilter<MaintenanceTask> {
	// region MaintenanceTaskByHcPartyAndTypeFilter-MaintenanceTaskByHcPartyAndTypeFilter

	// endregion
}
