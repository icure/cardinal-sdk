// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates privileged operations that can be authorized via a dedicated operation token.
 */
@Serializable
enum class Operation(
	internal val dtoSerialName: String,
) {
	@SerialName("TRANSFER_GROUP")
	TransferGroup("TRANSFER_GROUP"),
}
