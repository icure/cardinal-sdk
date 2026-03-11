package com.icure.cardinal.sdk.model.filter.device

import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches devices by their responsible healthcare party.
 * /
 */
@SerialName("DeviceByHcPartyFilter")
@Serializable
public data class DeviceByHcPartyFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the responsible healthcare party.
	 */
	public val responsibleId: String? = null,
) : AbstractFilter<Device>
