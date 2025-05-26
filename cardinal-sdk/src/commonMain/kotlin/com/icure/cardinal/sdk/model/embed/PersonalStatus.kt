package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PersonalStatus(
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
