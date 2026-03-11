package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible locations of a document within a message: annex or body.
 */
@Serializable
public enum class DocumentLocation(
	internal val dtoSerialName: String,
) {
	@SerialName("annex")
	Annex("annex"),

	@SerialName("body")
	Body("body"),
}
