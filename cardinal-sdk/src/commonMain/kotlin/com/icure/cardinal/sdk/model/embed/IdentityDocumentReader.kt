package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class IdentityDocumentReader(
	public val justificatifDocumentNumber: String? = null,
	public val supportSerialNumber: String? = null,
	public val timeReadingEIdDocument: Long? = null,
	@param:DefaultValue("0")
	public val eidDocumentSupportType: Int = 0,
	@param:DefaultValue("0")
	public val reasonManualEncoding: Int = 0,
	@param:DefaultValue("0")
	public val reasonUsingVignette: Int = 0,
) {
	// region IdentityDocumentReader-IdentityDocumentReader

	// endregion
}
