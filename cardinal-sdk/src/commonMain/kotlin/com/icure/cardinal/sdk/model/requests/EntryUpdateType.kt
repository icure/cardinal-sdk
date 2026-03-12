package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Specifies if an entry should be created anew or deleted
 */
@Serializable
public enum class EntryUpdateType(
	internal val dtoSerialName: String,
) {
	@SerialName("CREATE")
	Create("CREATE"),

	@SerialName("DELETE")
	Delete("DELETE"),
}
