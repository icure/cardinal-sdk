// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible statuses of a front-end migration process.
 */
@Serializable
enum class FrontEndMigrationStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("STARTED")
	Started("STARTED"),

	@SerialName("PAUSED")
	Paused("PAUSED"),

	@SerialName("ERROR")
	Error("ERROR"),

	@SerialName("SUCCESS")
	Success("SUCCESS"),
}
