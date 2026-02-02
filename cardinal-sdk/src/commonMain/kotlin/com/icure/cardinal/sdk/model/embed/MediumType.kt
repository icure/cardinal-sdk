package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class MediumType(
	internal val dtoSerialName: String,
) {
	@SerialName("cdrom")
	Cdrom("cdrom"),

	@SerialName("eattest")
	Eattest("eattest"),

	@SerialName("efact")
	Efact("efact"),

	@SerialName("email")
	Email("email"),

	@SerialName("mediprima")
	Mediprima("mediprima"),

	@SerialName("paper")
	Paper("paper"),

	@SerialName("stat")
	Stat("stat"),
}
