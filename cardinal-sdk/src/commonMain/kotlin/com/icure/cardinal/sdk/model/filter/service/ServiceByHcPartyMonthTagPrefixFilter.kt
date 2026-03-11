package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * Filter that matches services by healthcare party, year/month, tag prefix, and value date range.
 * /
 */
@SerialName("ServiceByHcPartyMonthTagPrefixFilter")
@Serializable
public data class ServiceByHcPartyMonthTagPrefixFilter(
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
	 * The type of the tag to match.
	 */
	public val tagType: String,
	/**
	 * The tag code prefix to match.
	 */
	public val tagCodePrefix: String,
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
