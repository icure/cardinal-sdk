package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class DocumentLocation(
	internal val dtoSerialName: String,
) {
	@SerialName("annex")
	Annex("annex"),

	@SerialName("body")
	Body("body"),
}
