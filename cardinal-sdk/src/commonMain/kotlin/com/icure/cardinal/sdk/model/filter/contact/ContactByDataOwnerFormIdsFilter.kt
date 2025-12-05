package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("ContactByDataOwnerFormIdsFilter")
@Serializable
public data class ContactByDataOwnerFormIdsFilter(
	public val dataOwnerId: String,
	public val formIds: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Contact>
