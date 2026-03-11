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
public data class IdentityDocumentReader(
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
)
