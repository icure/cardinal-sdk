// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents revision information for a CouchDB document, including the revision identifier and its
 * status.
 * /
 */
@Serializable
data class RevisionInfo(
	/**
	 * The revision identifier.
	 */
	public val rev: String? = null,
	/**
	 * The status of this revision (e.g., available, missing, deleted).
	 */
	public val status: String? = null,
) {
	// region RevisionInfo-RevisionInfo

	// endregion
}
