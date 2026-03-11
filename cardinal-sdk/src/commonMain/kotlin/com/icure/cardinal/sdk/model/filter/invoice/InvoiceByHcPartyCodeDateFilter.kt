package com.icure.cardinal.sdk.model.filter.invoice

import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Filter that matches invoices by healthcare party, code, and invoice date range.
 * /
 */
@SerialName("InvoiceByHcPartyCodeDateFilter")
@Serializable
public data class InvoiceByHcPartyCodeDateFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The code to match.
	 */
	public val code: String,
	/**
	 * The start of the invoice date range.
	 */
	public val startInvoiceDate: Long? = null,
	/**
	 * The end of the invoice date range.
	 */
	public val endInvoiceDate: Long? = null,
) : AbstractFilter<Invoice>
