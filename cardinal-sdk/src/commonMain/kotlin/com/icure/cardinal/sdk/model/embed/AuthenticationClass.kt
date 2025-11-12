package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class AuthenticationClass(
	internal val dtoSerialName: String,
) {
	@SerialName("DIGITAL_ID")
	DigitalId("DIGITAL_ID"),

	@SerialName("TWO_FACTOR_AUTHENTICATION")
	TwoFactorAuthentication("TWO_FACTOR_AUTHENTICATION"),

	@SerialName("SHORT_LIVED_TOKEN")
	ShortLivedToken("SHORT_LIVED_TOKEN"),

	@SerialName("EXTERNAL_AUTHENTICATION")
	ExternalAuthentication("EXTERNAL_AUTHENTICATION"),

	@SerialName("PASSWORD")
	Password("PASSWORD"),

	@SerialName("LONG_LIVED_TOKEN")
	LongLivedToken("LONG_LIVED_TOKEN"),
}
