// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible statuses of a healthcare party regarding their professional standing.
 */
@Serializable
enum class HealthcarePartyStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("trainee")
	Trainee("trainee"),

	@SerialName("withconvention")
	Withconvention("withconvention"),

	@SerialName("accreditated")
	Accreditated("accreditated"),
}
