package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable
import kotlin.ByteArray
import kotlin.String

/**
 * Data transfer object representing a MIME attachment with binary data, a file name, and a content
 * type.
 * /
 */
@Serializable
public data class MimeAttachment(
	/**
	 * The binary content of the attachment.
	 */
	@Serializable(with = ByteArraySerializer::class)
	public val `data`: ByteArray? = null,
	/**
	 * The name of the attached file.
	 */
	public val fileName: String? = null,
	/**
	 * The MIME type of the attachment (e.g. application/pdf, image/png).
	 */
	public val mimeType: String? = null,
)
