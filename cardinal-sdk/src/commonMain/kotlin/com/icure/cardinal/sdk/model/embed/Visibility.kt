package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class Visibility(
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
