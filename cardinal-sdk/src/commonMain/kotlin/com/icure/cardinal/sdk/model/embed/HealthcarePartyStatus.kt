package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible statuses of a healthcare party regarding their professional standing.
 */
@Serializable
public enum class HealthcarePartyStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("trainee")
	Trainee("trainee"),

	@SerialName("withconvention")
	Withconvention("withconvention"),

	@SerialName("accreditated")
	Accreditated("accreditated"),
}
