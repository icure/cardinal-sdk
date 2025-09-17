package com.icure.cardinal.sdk.model.filter.device

import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("DeviceByHcPartyFilter")
@Serializable
public data class DeviceByHcPartyFilter(
	override val desc: String? = null,
	public val responsibleId: String? = null,
) : AbstractFilter<Device>
