// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the visibility levels for medical data elements, controlling how they appear in
 * summaries and exports.
 */
@Serializable
enum class Visibility(
	internal val dtoSerialName: String,
) {
	@SerialName("maskedfromsummary")
	Maskedfromsummary("maskedfromsummary"),

	@SerialName("maskedfromexportedfile")
	Maskedfromexportedfile("maskedfromexportedfile"),

	@SerialName("proeminent")
	Proeminent("proeminent"),

	@SerialName("highlighted")
	Highlighted("highlighted"),

	@SerialName("visible")
	Visible("visible"),
}
