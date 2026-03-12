package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumeration of appendix types that can be associated with a code or other entity.
 */
@Serializable
public enum class AppendixType(
	internal val dtoSerialName: String,
) {
	@SerialName("externalLink")
	ExternalLink("externalLink"),

	@SerialName("video")
	Video("video"),

	@SerialName("description")
	Description("description"),
}
