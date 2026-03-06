package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class PersonNameUse(
	internal val dtoSerialName: String,
) {
	@SerialName("usual")
	Usual("usual"),

	@SerialName("official")
	Official("official"),

	@SerialName("temp")
	Temp("temp"),

	@SerialName("nickname")
	Nickname("nickname"),

	@SerialName("anonymous")
	Anonymous("anonymous"),

	@SerialName("maiden")
	Maiden("maiden"),

	@SerialName("old")
	Old("old"),

	@SerialName("other")
	Other("other"),
}
