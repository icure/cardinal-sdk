// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Represents the lifecycle status of a user account in the iCure system.
 */
@Serializable
enum class UsersStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("ACTIVE")
	Active("ACTIVE"),

	@SerialName("DISABLED")
	Disabled("DISABLED"),

	@SerialName("REGISTERING")
	Registering("REGISTERING"),
}
