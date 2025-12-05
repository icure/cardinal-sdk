package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("ServiceByHcPartyHealthElementIdsFilter")
@Serializable
public data class ServiceByHcPartyHealthElementIdsFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	@DefaultValue("emptyList()")
	public val healthElementIds: List<String> = emptyList(),
) : AbstractFilter<Service>
