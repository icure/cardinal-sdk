// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Data transfer object representing a CouchDB view definition within a design document.
 */
@Serializable
data class View(
	/**
	 * The map function source code for this view.
	 */
	public val map: String,
	/**
	 * The optional reduce function source code for this view.
	 */
	public val reduce: String? = null,
) {
	// region View-View

	// endregion
}
