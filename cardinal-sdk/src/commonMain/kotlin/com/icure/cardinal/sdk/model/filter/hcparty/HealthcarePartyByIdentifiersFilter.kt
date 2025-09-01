package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("HealthcarePartyByIdentifiersFilter")
@Serializable
public data class HealthcarePartyByIdentifiersFilter(
	@DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
