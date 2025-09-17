package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

@Serializable
public data class IdentityDocumentReader(
	public val justificatifDocumentNumber: String? = null,
	public val supportSerialNumber: String? = null,
	public val timeReadingEIdDocument: Long? = null,
	@DefaultValue("0")
	public val eidDocumentSupportType: Int = 0,
	@DefaultValue("0")
	public val reasonManualEncoding: Int = 0,
	@DefaultValue("0")
	public val reasonUsingVignette: Int = 0,
)
