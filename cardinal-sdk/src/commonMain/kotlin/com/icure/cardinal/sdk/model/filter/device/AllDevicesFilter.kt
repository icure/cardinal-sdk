package com.icure.cardinal.sdk.model.filter.device

import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches all devices without any filtering criteria.
 * /
 */
@SerialName("AllDevicesFilter")
@Serializable
public data class AllDevicesFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Device>, Filter.AllFilter<Device>
