package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates privileged operations that can be authorized via a dedicated operation token.
 */
@Serializable
public enum class Operation(
	internal val dtoSerialName: String,
) {
	@SerialName("TRANSFER_GROUP")
	TransferGroup("TRANSFER_GROUP"),
}
