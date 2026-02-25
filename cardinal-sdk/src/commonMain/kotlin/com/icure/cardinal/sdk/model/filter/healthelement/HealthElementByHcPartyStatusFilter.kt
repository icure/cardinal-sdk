package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@SerialName("HealthElementByHcPartyStatusFilter")
@Serializable
public data class HealthElementByHcPartyStatusFilter(
	override val desc: String? = null,
	public val hcPartyId: String,
	public val status: Int,
) : AbstractFilter<HealthElement>
