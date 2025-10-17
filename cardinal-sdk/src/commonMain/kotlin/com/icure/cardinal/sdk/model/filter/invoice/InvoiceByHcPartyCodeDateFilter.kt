package com.icure.cardinal.sdk.model.filter.invoice

import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@SerialName("InvoiceByHcPartyCodeDateFilter")
@Serializable
public data class InvoiceByHcPartyCodeDateFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val code: String,
	public val startInvoiceDate: Long? = null,
	public val endInvoiceDate: Long? = null,
) : AbstractFilter<Invoice>
