package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class InvoiceInterventionType(
	internal val dtoSerialName: String,
) {
	@SerialName("total")
	Total("total"),

	@SerialName("userfees")
	Userfees("userfees"),
}
