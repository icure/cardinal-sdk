package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("ServiceByHcPartyIdentifiersFilter")
@Serializable
public data class ServiceByHcPartyIdentifiersFilter(
	public val healthcarePartyId: String? = null,
	@DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
	override val desc: String? = null,
) : AbstractFilter<Service>
