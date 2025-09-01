package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@SerialName("ContactByDataOwnerPatientOpeningDateFilter")
@Serializable
public data class ContactByDataOwnerPatientOpeningDateFilter(
	public val dataOwnerId: String,
	public val secretForeignKeys: Set<String>,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<Contact>
