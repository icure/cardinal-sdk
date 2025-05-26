package com.icure.cardinal.sdk.model.requests.document

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class BulkAttachmentUpdateOptions(
	@DefaultValue("emptyMap()")
	public val updateAttachmentsMetadata: Map<String, AttachmentMetadata> = emptyMap(),
	@DefaultValue("emptySet()")
	public val deleteAttachments: Set<String> = emptySet(),
) {
	public val dtoSerialName: String

	@Serializable
	public data class AttachmentMetadata(
		@DefaultValue("emptyList()")
		public val utis: List<String> = emptyList(),
		public val dataIsEncrypted: Boolean? = null,
	) {
		public val dtoSerialName: String
	}
	// region BulkAttachmentUpdateOptions-BulkAttachmentUpdateOptions

	// endregion
}
