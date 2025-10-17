package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public data class DeletedAttachment(
	public val couchDbAttachmentId: String? = null,
	public val objectStoreAttachmentId: String? = null,
	public val key: String? = null,
	public val deletionTime: Long? = null,
)
