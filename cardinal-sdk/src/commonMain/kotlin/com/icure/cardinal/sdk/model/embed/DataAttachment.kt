package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DataAttachment(
	public val couchDbAttachmentId: String? = null,
	public val objectStoreAttachmentId: String? = null,
	@param:DefaultValue("emptyList()")
	public val utis: List<String> = emptyList(),
) {
	// region DataAttachment-DataAttachment

	// endregion
}
