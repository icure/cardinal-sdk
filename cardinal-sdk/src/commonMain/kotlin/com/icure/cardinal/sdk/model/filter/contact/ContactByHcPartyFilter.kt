package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("ContactByHcPartyFilter")
@Serializable
public data class ContactByHcPartyFilter(
	override val hcpId: String,
	override val desc: String? = null,
) : AbstractFilter<Contact>, Filter.ByHcpartyFilter<Contact>
