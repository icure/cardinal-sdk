// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
enum class AccessLevel(
	internal val dtoSerialName: String,
) {
	@SerialName("READ")
	Read("READ"),

	@SerialName("WRITE")
	Write("WRITE"),
}
