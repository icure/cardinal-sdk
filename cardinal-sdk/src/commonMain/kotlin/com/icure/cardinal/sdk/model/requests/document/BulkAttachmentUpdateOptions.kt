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
	@param:DefaultValue("emptyMap()")
	public val updateAttachmentsMetadata: Map<String, AttachmentMetadata> = emptyMap(),
	@param:DefaultValue("emptySet()")
	public val deleteAttachments: Set<String> = emptySet(),
) {
	@Serializable
	public data class AttachmentMetadata(
		@param:DefaultValue("emptyList()")
		public val utis: List<String> = emptyList(),
		public val dataIsEncrypted: Boolean? = null,
	)
}
