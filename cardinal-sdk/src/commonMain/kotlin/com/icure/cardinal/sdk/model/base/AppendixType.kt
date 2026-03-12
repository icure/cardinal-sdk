// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumeration of appendix types that can be associated with a code or other entity.
 */
@Serializable
enum class AppendixType(
	internal val dtoSerialName: String,
) {
	@SerialName("externalLink")
	ExternalLink("externalLink"),

	@SerialName("video")
	Video("video"),

	@SerialName("description")
	Description("description"),
}
