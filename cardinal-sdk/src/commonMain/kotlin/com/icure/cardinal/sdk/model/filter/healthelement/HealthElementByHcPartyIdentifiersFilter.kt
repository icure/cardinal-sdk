package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("HealthElementByHcPartyIdentifiersFilter")
@Serializable
public data class HealthElementByHcPartyIdentifiersFilter(
	override val desc: String? = null,
	public val hcPartyId: String,
	@DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<HealthElement>
