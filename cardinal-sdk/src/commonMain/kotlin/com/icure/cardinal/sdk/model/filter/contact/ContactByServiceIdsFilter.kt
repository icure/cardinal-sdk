package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches contacts containing services with the specified identifiers.
 * /
 */
@SerialName("ContactByServiceIdsFilter")
@Serializable
public data class ContactByServiceIdsFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The list of service identifiers to match.
	 */
	public val ids: List<String>? = null,
) : AbstractFilter<Contact>
