package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("ContactByServiceIdsFilter")
@Serializable
public data class ContactByServiceIdsFilter(
	override val desc: String? = null,
	public val ids: List<String>? = null,
) : AbstractFilter<Contact>
