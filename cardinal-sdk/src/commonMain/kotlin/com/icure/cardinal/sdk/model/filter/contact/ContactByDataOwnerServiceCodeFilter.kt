package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("ContactByDataOwnerServiceCodeFilter")
@Serializable
public data class ContactByDataOwnerServiceCodeFilter(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String?,
	override val desc: String? = null,
) : AbstractFilter<Contact>
