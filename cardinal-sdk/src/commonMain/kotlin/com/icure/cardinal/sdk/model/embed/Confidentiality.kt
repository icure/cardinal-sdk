package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class Confidentiality(
	internal val dtoSerialName: String,
) {
	@SerialName("freeaccess")
	Freeaccess("freeaccess"),

	@SerialName("personal")
	Personal("personal"),

	@SerialName("secret")
	Secret("secret"),
}
