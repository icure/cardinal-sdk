// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable

/**
 * Data transfer object representing authentication configuration for a remote CouchDB instance.
 * /
 */
@Serializable
data class RemoteAuthentication(
	/**
	 * The basic authentication credentials, if applicable.
	 */
	public val basic: Basic? = null,
) {
	// region RemoteAuthentication-RemoteAuthentication

	// endregion
}
