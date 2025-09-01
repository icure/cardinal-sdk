package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@SerialName("ContactByHcPartyTagCodeDateFilter")
@Serializable
public data class ContactByHcPartyTagCodeDateFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val tagType: String? = null,
	public val tagCode: String? = null,
	public val codeType: String? = null,
	public val codeCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
) : AbstractFilter<Contact>
