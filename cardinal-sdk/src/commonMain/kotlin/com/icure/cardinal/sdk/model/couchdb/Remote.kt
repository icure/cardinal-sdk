// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Data transfer object representing a remote CouchDB endpoint with its URL and optional
 * authentication.
 * /
 */
@Serializable
data class Remote(
	/**
	 * The URL of the remote CouchDB instance.
	 */
	public val url: String,
	/**
	 * The authentication configuration for connecting to the remote instance.
	 */
	public val auth: RemoteAuthentication? = null,
) {
	// region Remote-Remote

	// endregion
}
