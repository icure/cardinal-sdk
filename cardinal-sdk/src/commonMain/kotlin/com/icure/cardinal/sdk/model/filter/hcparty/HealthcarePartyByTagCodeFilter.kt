package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches healthcare parties by tag and/or code.
 * /
 */
@SerialName("HealthcarePartyByTagCodeFilter")
@Serializable
public data class HealthcarePartyByTagCodeFilter(
	/**
	 * The type of the tag to filter on.
	 */
	public val tagType: String? = null,
	/**
	 * The tag code value to match.
	 */
	public val tagCode: String? = null,
	/**
	 * The type of the code to filter on.
	 */
	public val codeType: String? = null,
	/**
	 * The code value to match.
	 */
	public val codeCode: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
