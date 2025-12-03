package com.icure.cardinal.sdk.model.requests.document

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class BulkAttachmentUpdateOptions(
	@DefaultValue("emptyMap()")
	public val updateAttachmentsMetadata: Map<String, AttachmentMetadata> = emptyMap(),
	@DefaultValue("emptySet()")
	public val deleteAttachments: Set<String> = emptySet(),
) {
	@Serializable
	public data class AttachmentMetadata(
		@DefaultValue("emptyList()")
		public val utis: List<String> = emptyList(),
		public val dataIsEncrypted: Boolean? = null,
	)
}
