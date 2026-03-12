package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of intervention on an invoice: total amount or user fees only.
 */
@Serializable
public enum class InvoiceInterventionType(
	internal val dtoSerialName: String,
) {
	@SerialName("total")
	Total("total"),

	@SerialName("userfees")
	Userfees("userfees"),
}
