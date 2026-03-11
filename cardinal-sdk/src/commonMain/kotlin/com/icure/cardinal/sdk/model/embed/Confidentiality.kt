// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the levels of confidentiality that can be applied to medical data.
 */
@Serializable
enum class Confidentiality(
	internal val dtoSerialName: String,
) {
	@SerialName("freeaccess")
	Freeaccess("freeaccess"),

	@SerialName("personal")
	Personal("personal"),

	@SerialName("secret")
	Secret("secret"),
}
