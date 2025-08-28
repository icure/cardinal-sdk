package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class IdentityDocumentReader(
	public val justificatifDocumentNumber: String? = null,
	public val supportSerialNumber: String? = null,
	public val timeReadingEIdDocument: Long? = null,
	public val eidDocumentSupportType: Int,
	public val reasonManualEncoding: Int,
	public val reasonUsingVignette: Int,
) {
	// region IdentityDocumentReader-IdentityDocumentReader

	// endregion
}
