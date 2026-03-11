package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches services by healthcare party and code prefix.
 * /
 */
@SerialName("ServiceByHcPartyCodePrefixFilter")
@Serializable
public data class ServiceByHcPartyCodePrefixFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The type of the code to match.
	 */
	public val codeType: String,
	/**
	 * The code prefix to match.
	 */
	public val codeCodePrefix: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Service>
