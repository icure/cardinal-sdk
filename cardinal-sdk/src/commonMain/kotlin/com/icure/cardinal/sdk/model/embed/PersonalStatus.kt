package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class PersonalStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("single")
	Single("single"),

	@SerialName("in_couple")
	InCouple("in_couple"),

	@SerialName("married")
	Married("married"),

	@SerialName("separated")
	Separated("separated"),

	@SerialName("divorced")
	Divorced("divorced"),

	@SerialName("divorcing")
	Divorcing("divorcing"),

	@SerialName("widowed")
	Widowed("widowed"),

	@SerialName("widower")
	Widower("widower"),

	@SerialName("complicated")
	Complicated("complicated"),

	@SerialName("unknown")
	Unknown("unknown"),

	@SerialName("contract")
	Contract("contract"),

	@SerialName("other")
	Other("other"),

	@SerialName("annulled")
	Annulled("annulled"),

	@SerialName("polygamous")
	Polygamous("polygamous"),
}
