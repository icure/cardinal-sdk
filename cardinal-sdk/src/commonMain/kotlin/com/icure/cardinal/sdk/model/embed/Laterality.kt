// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible laterality values for a medical observation or procedure.
 */
@Serializable
enum class Laterality(
	internal val dtoSerialName: String,
) {
	@SerialName("left")
	Left("left"),

	@SerialName("right")
	Right("right"),
}
