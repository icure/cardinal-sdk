package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Filter that matches contacts by healthcare party, tag, code, and opening date range.
 * /
 */
@SerialName("ContactByHcPartyTagCodeDateFilter")
@Serializable
public data class ContactByHcPartyTagCodeDateFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The type of the tag to filter on.
	 */
	public val tagType: String? = null,
	/**
	 * The tag code value to match.
	 */
	public val tagCode: String? = null,
	/**
	 * The type of the code to filter on.
	 */
	public val codeType: String? = null,
	/**
	 * The code value to match.
	 */
	public val codeCode: String? = null,
	/**
	 * The start of the contact opening date range.
	 */
	public val startOfContactOpeningDate: Long? = null,
	/**
	 * The end of the contact opening date range.
	 */
	public val endOfContactOpeningDate: Long? = null,
) : AbstractFilter<Contact>
