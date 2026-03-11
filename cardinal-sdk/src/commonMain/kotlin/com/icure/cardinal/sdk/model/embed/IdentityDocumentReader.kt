// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * Represents information about how an identity document (such as a Belgian eID) was read,
 * including the document number, support serial number, and encoding details.
 * /
 */
@Serializable
data class IdentityDocumentReader(
	/**
	 * The justification document number.
	 */
	public val justificatifDocumentNumber: String? = null,
	/**
	 * The serial number of the support used to read the document.
	 */
	public val supportSerialNumber: String? = null,
	/**
	 * The timestamp (unix epoch in ms) when the eID document was read.
	 */
	public val timeReadingEIdDocument: Long? = null,
	/**
	 * The type of eID document support used.
	 */
	@param:DefaultValue("0")
	public val eidDocumentSupportType: Int = 0,
	/**
	 * The reason code for manual encoding, if applicable.
	 */
	@param:DefaultValue("0")
	public val reasonManualEncoding: Int = 0,
	/**
	 * The reason code for using a vignette, if applicable.
	 */
	@param:DefaultValue("0")
	public val reasonUsingVignette: Int = 0,
) {
	// region IdentityDocumentReader-IdentityDocumentReader

	// endregion
}
