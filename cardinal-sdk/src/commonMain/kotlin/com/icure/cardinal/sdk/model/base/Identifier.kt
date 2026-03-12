// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  An identifier intended for computation
 *
 *  An identifier - identifies some entity uniquely and unambiguously. Typically this is used for
 *  business identifiers.
 */
@Serializable
data class Identifier(
	/**
	 *
	 *  Unique id for inter-element referencing
	 */
	public val id: String? = null,
	/**
	 *
	 *  Organization that issued id (may be just text)
	 */
	public val assigner: String? = null,
	/**
	 *
	 *  Time period when id is/was valid for use
	 */
	public val start: String? = null,
	public val end: String? = null,
	/**
	 *
	 *  The namespace for the identifier value
	 */
	public val system: String? = null,
	/**
	 *
	 *  Description of identifier
	 */
	public val type: CodeStub? = null,
	/**
	 *
	 *  usual | official | temp | secondary | old (If known)
	 */
	public val use: String? = null,
	/**
	 *
	 *  The value that is unique
	 */
	public val `value`: String? = null,
) {
	// region Identifier-Identifier

	// endregion
}
