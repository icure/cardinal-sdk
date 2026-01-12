package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("HealthElementByHcPartyFilter")
@Serializable
public data class HealthElementByHcPartyFilter(
	override val hcpId: String,
	override val desc: String? = null,
) : AbstractFilter<HealthElement>, Filter.ByHcpartyFilter<HealthElement>
