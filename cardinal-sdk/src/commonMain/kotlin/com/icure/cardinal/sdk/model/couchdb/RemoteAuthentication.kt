package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable

/**
 * Data transfer object representing authentication configuration for a remote CouchDB instance.
 * /
 */
@Serializable
public data class RemoteAuthentication(
	/**
	 * The basic authentication credentials, if applicable.
	 */
	public val basic: Basic? = null,
)
