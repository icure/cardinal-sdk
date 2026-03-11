package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches contacts by data owner and service code.
 * /
 */
@SerialName("ContactByDataOwnerServiceCodeFilter")
@Serializable
public data class ContactByDataOwnerServiceCodeFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The type of the service code.
	 */
	public val codeType: String,
	/**
	 * The code value to match.
	 */
	public val codeCode: String?,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Contact>
