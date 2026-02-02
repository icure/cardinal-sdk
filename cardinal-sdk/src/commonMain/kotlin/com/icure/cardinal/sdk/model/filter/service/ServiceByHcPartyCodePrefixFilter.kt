package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("ServiceByHcPartyCodePrefixFilter")
@Serializable
public data class ServiceByHcPartyCodePrefixFilter(
	public val healthcarePartyId: String,
	public val codeType: String,
	public val codeCodePrefix: String,
	override val desc: String? = null,
) : AbstractFilter<Service>
