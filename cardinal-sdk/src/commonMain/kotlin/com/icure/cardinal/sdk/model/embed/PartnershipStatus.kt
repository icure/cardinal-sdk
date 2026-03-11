package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible statuses of a partnership (relationship between persons).
 */
@Serializable
public enum class PartnershipStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("active")
	Active("active"),

	@SerialName("complicated")
	Complicated("complicated"),

	@SerialName("past")
	Past("past"),
}
