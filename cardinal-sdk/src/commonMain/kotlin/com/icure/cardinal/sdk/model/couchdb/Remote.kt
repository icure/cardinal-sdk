package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Data transfer object representing a remote CouchDB endpoint with its URL and optional
 * authentication.
 * /
 */
@Serializable
public data class Remote(
	/**
	 * The URL of the remote CouchDB instance.
	 */
	public val url: String,
	/**
	 * The authentication configuration for connecting to the remote instance.
	 */
	public val auth: RemoteAuthentication? = null,
)
