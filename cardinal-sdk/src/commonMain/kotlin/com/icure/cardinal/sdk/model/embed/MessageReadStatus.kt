package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class MessageReadStatus(
	public val time: Long? = null,
	@param:DefaultValue("false")
	public val read: Boolean = false,
) {
	// region MessageReadStatus-MessageReadStatus

	// endregion
}
