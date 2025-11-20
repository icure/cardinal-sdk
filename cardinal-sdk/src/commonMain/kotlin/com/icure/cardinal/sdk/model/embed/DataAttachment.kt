package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class DataAttachment(
	public val couchDbAttachmentId: String? = null,
	public val objectStoreAttachmentId: String? = null,
	@DefaultValue("emptyList()")
	public val utis: List<String> = emptyList(),
)
