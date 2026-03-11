// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of users in the system.
 */
@Serializable
enum class UserType(
	internal val dtoSerialName: String,
) {
	@SerialName("HCP")
	Hcp("HCP"),

	@SerialName("PATIENT")
	Patient("PATIENT"),

	@SerialName("DEVICE")
	Device("DEVICE"),

	@SerialName("USER")
	User("USER"),
}
