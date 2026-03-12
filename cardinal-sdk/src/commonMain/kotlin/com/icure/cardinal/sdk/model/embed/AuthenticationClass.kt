// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the different classes of authentication that can be used to establish a user session,
 *  ordered from strongest to weakest authentication assurance.
 */
@Serializable
enum class AuthenticationClass(
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
