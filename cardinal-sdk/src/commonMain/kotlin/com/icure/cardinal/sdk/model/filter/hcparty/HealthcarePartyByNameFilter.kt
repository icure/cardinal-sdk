package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("HealthcarePartyByNameFilter")
@Serializable
public data class HealthcarePartyByNameFilter(
	override val desc: String? = null,
	public val name: String,
	public val descending: Boolean? = null,
) : AbstractFilter<HealthcareParty>
