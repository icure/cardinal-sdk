package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches contacts by their external identifier.
 * /
 */
@SerialName("ContactByExternalIdFilter")
@Serializable
public data class ContactByExternalIdFilter(
	/**
	 * The external identifier to match.
	 */
	public val externalId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Contact>
