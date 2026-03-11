// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible locations of a document within a message: annex or body.
 */
@Serializable
enum class DocumentLocation(
	internal val dtoSerialName: String,
) {
	@SerialName("annex")
	Annex("annex"),

	@SerialName("body")
	Body("body"),
}
