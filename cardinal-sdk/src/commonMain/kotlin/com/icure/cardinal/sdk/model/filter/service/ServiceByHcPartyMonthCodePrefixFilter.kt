package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * Filter that matches services by healthcare party, year/month, code prefix, and value date range.
 * /
 */
@SerialName("ServiceByHcPartyMonthCodePrefixFilter")
@Serializable
public data class ServiceByHcPartyMonthCodePrefixFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The year to filter on.
	 */
	public val year: Int? = null,
	/**
	 * The month to filter on.
	 */
	public val month: Int? = null,
	/**
	 * The type of the code to match.
	 */
	public val codeType: String,
	/**
	 * The code prefix to match.
	 */
	public val codeCodePrefix: String,
	/**
	 * The start of the value date range.
	 */
	public val startValueDate: Long? = null,
	/**
	 * The end of the value date range.
	 */
	public val endValueDate: Long? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Service>
