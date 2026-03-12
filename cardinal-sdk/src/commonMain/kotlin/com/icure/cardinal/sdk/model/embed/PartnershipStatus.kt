// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible statuses of a partnership (relationship between persons).
 */
@Serializable
enum class PartnershipStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("active")
	Active("active"),

	@SerialName("complicated")
	Complicated("complicated"),

	@SerialName("past")
	Past("past"),
}
