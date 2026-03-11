// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Options for filtering versioned entities, like services or health elements.
 */
@Serializable
enum class VersionFiltering(
	internal val dtoSerialName: String,
) {
	@SerialName("LATEST")
	Latest("LATEST"),

	@SerialName("ANY")
	Any("ANY"),
}
