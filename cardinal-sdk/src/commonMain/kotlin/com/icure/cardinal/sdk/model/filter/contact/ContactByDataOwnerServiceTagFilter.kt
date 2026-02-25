package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("ContactByDataOwnerServiceTagFilter")
@Serializable
public data class ContactByDataOwnerServiceTagFilter(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String?,
	override val desc: String? = null,
) : AbstractFilter<Contact>
