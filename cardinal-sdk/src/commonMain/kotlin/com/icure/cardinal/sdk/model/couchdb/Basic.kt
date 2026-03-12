// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Data transfer object representing basic authentication credentials for a CouchDB remote
 * connection.
 * /
 */
@Serializable
data class Basic(
	/**
	 * The username for authentication.
	 */
	public val username: String,
	/**
	 * The password for authentication.
	 */
	public val password: String,
) {
	// region Basic-Basic

	// endregion
}
