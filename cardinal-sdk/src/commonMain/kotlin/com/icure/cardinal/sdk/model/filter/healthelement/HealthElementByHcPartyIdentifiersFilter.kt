package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches health elements by healthcare party and a list of identifiers.
 * /
 */
@SerialName("HealthElementByHcPartyIdentifiersFilter")
@Serializable
public data class HealthElementByHcPartyIdentifiersFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val hcPartyId: String,
	/**
	 * The list of identifiers to match.
	 */
	@param:DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<HealthElement>
