// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of intervention on an invoice: total amount or user fees only.
 */
@Serializable
enum class InvoiceInterventionType(
	internal val dtoSerialName: String,
) {
	@SerialName("total")
	Total("total"),

	@SerialName("userfees")
	Userfees("userfees"),
}
