package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable
import kotlin.ByteArray
import kotlin.String

@Serializable
public data class MimeAttachment(
	@Serializable(with = ByteArraySerializer::class)
	public val `data`: ByteArray? = null,
	public val fileName: String? = null,
	public val mimeType: String? = null,
)
