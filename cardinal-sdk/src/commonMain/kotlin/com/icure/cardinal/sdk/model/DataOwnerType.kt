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
public enum class DataOwnerType(
	internal val dtoSerialName: String,
) {
	@SerialName("hcp")
	Hcp("hcp"),

	@SerialName("device")
	Device("device"),

	@SerialName("patient")
	Patient("patient"),
}
