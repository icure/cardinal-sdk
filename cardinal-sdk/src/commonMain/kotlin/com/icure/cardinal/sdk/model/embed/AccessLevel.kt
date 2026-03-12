package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Specifies whether a user has read-only permission or read-write permissions.
 *  Used for entity-level permissions.
 */
@Serializable
public enum class AccessLevel(
	internal val dtoSerialName: String,
) {
	@SerialName("READ")
	Read("READ"),

	@SerialName("WRITE")
	Write("WRITE"),
}
