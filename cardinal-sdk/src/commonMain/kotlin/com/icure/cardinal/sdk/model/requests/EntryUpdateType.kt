// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Specifies if an entry should be created anew or deleted
 */
@Serializable
enum class EntryUpdateType(
	internal val dtoSerialName: String,
) {
	@SerialName("CREATE")
	Create("CREATE"),

	@SerialName("DELETE")
	Delete("DELETE"),
}
