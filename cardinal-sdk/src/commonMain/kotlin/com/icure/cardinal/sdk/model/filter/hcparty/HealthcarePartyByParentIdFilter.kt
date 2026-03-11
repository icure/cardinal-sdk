package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches healthcare parties by their parent identifier.
 * /
 */
@SerialName("HealthcarePartyByParentIdFilter")
@Serializable
public data class HealthcarePartyByParentIdFilter(
	/**
	 * The identifier of the parent healthcare party.
	 */
	public val parentId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
