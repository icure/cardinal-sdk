package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

@Serializable
public data class IdentityDocumentReader(
	public val justificatifDocumentNumber: String? = null,
	public val supportSerialNumber: String? = null,
	public val timeReadingEIdDocument: Long? = null,
	public val eidDocumentSupportType: Int,
	public val reasonManualEncoding: Int,
	public val reasonUsingVignette: Int,
)
