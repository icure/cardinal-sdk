// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible statuses of a task in its lifecycle.
 */
@Serializable
enum class TaskStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("pending")
	Pending("pending"),

	@SerialName("ongoing")
	Ongoing("ongoing"),

	@SerialName("cancelled")
	Cancelled("cancelled"),

	@SerialName("completed")
	Completed("completed"),
}
