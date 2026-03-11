// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumeration of the possible types of data owners in the iCure platform: healthcare parties,
 * devices, and patients.
 */
@Serializable
enum class DataOwnerType(
	internal val dtoSerialName: String,
) {
	@SerialName("hcp")
	Hcp("hcp"),

	@SerialName("device")
	Device("device"),

	@SerialName("patient")
	Patient("patient"),
}
