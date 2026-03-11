// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of membership a care team member can hold.
 */
@Serializable
enum class MembershipType(
	internal val dtoSerialName: String,
) {
	@SerialName("doctor")
	Doctor("doctor"),

	@SerialName("mutuality")
	Mutuality("mutuality"),

	@SerialName("patient")
	Patient("patient"),

	@SerialName("specialist")
	Specialist("specialist"),

	@SerialName("other")
	Other("other"),
}
