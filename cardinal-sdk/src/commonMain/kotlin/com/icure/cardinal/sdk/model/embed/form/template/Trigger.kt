// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the trigger events that can activate a launcher in a form template.
 */
@Serializable
enum class Trigger(
	internal val dtoSerialName: String,
) {
	@SerialName("INIT")
	Init("INIT"),

	@SerialName("CHANGE")
	Change("CHANGE"),

	@SerialName("CLICK")
	Click("CLICK"),

	@SerialName("VISIBLE")
	Visible("VISIBLE"),

	@SerialName("ERROR")
	Error("ERROR"),

	@SerialName("VALID")
	Valid("VALID"),

	@SerialName("EVENT")
	Event("EVENT"),
}
