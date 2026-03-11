package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Data transfer object that uniquely identifies a CouchDB document by its id and revision.
 */
@Serializable
public data class DocIdentifier(
	/**
	 * The document identifier.
	 */
	public val id: String? = null,
	/**
	 * The document revision.
	 */
	public val rev: String? = null,
)
