package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("MessageByInvoiceIdsFilter")
@Serializable
public data class MessageByInvoiceIdsFilter(
	public val invoiceIds: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Message>
