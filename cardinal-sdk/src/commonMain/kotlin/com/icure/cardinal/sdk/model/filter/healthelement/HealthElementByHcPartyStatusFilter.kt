package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 * Filter that matches health elements by healthcare party and status.
 * /
 */
@SerialName("HealthElementByHcPartyStatusFilter")
@Serializable
public data class HealthElementByHcPartyStatusFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val hcPartyId: String,
	/**
	 * The status value to match.
	 */
	public val status: Int,
) : AbstractFilter<HealthElement>
