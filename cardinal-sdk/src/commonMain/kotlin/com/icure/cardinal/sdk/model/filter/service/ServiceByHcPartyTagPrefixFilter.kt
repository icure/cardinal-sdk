package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("ServiceByHcPartyTagPrefixFilter")
@Serializable
public data class ServiceByHcPartyTagPrefixFilter(
	public val healthcarePartyId: String,
	public val tagType: String,
	public val tagCodePrefix: String,
	override val desc: String? = null,
) : AbstractFilter<Service>
