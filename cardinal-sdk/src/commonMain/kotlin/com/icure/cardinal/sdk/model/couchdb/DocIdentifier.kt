// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Data transfer object that uniquely identifies a CouchDB document by its id and revision.
 */
@Serializable
data class DocIdentifier(
	/**
	 * The document identifier.
	 */
	public val id: String? = null,
	/**
	 * The document revision.
	 */
	public val rev: String? = null,
) {
	// region DocIdentifier-DocIdentifier

	// endregion
}
