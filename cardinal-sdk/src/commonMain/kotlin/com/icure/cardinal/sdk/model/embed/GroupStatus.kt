// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  The commercial status of a group. Groups whose status is not explicitly set are reported with
 * the status of the
 *  first ancestor group that is [PAYING] or [FREE] ([FREE] if there is none).
 */
@Serializable
enum class GroupStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("PAYING")
	Paying("PAYING"),

	@SerialName("FREE")
	Free("FREE"),
}
