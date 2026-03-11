// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of groups in the system hierarchy: root, app, or database.
 */
@Serializable
enum class GroupType(
	internal val dtoSerialName: String,
) {
	@SerialName("root")
	Root("root"),

	@SerialName("app")
	App("app"),

	@SerialName("database")
	Database("database"),
}
