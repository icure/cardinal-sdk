package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("HealthcarePartyByTypeSpecialtyPostCodeFilter")
@Serializable
public data class HealthcarePartyByTypeSpecialtyPostCodeFilter(
	public val specialty: String,
	public val specCode: String,
	public val startPostCode: String,
	public val endPostCode: String,
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
