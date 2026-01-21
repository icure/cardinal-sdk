package com.icure.cardinal.sdk.model.filter.device

import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("DeviceByHcPartyFilter")
@Serializable
data class DeviceByHcPartyFilter(
	desc: String? = null,
	responsibleId: String? = null,
) : AbstractFilter<Device> {
	// region DeviceByHcPartyFilter-DeviceByHcPartyFilter

	// endregion
}
