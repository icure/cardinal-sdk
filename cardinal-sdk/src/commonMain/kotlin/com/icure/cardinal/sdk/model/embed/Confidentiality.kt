package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the levels of confidentiality that can be applied to medical data.
 */
@Serializable
public enum class Confidentiality(
	internal val dtoSerialName: String,
) {
	@SerialName("freeaccess")
	Freeaccess("freeaccess"),

	@SerialName("personal")
	Personal("personal"),

	@SerialName("secret")
	Secret("secret"),
}
