package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches services associated with a specific healthcare party.
 * /
 */
@SerialName("ServiceByHcPartyFilter")
@Serializable
public data class ServiceByHcPartyFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val hcpId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Service>
