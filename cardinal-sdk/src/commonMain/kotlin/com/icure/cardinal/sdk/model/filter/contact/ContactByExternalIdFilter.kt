package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("ContactByExternalIdFilter")
@Serializable
public data class ContactByExternalIdFilter(
	public val externalId: String,
	override val desc: String? = null,
) : AbstractFilter<Contact>
