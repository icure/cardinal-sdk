package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches contacts associated with a specific healthcare party.
 * /
 */
@SerialName("ContactByHcPartyFilter")
@Serializable
public data class ContactByHcPartyFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	override val hcpId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Contact>, Filter.ByHcpartyFilter<Contact>
