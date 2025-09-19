package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

@SerialName("ServiceByHcPartyMonthCodePrefixFilter")
@Serializable
public data class ServiceByHcPartyMonthCodePrefixFilter(
	public val healthcarePartyId: String,
	public val year: Int? = null,
	public val month: Int? = null,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startValueDate: Long? = null,
	public val endValueDate: Long? = null,
	override val desc: String? = null,
) : AbstractFilter<Service>
