package com.icure.cardinal.sdk.model.filter.device

import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllDevicesFilter")
@Serializable
public data class AllDevicesFilter(
	override val desc: String? = null,
) : AbstractFilter<Device>, Filter.AllFilter<Device>
