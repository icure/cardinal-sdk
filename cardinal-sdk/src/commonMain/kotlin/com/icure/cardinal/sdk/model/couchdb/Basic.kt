package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Data transfer object representing basic authentication credentials for a CouchDB remote
 * connection.
 * /
 */
@Serializable
public data class Basic(
	/**
	 * The username for authentication.
	 */
	public val username: String,
	/**
	 * The password for authentication.
	 */
	public val password: String,
)
