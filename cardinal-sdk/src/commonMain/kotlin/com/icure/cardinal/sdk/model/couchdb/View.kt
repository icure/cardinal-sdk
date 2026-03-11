package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Data transfer object representing a CouchDB view definition within a design document.
 */
@Serializable
public data class View(
	/**
	 * The map function source code for this view.
	 */
	public val map: String,
	/**
	 * The optional reduce function source code for this view.
	 */
	public val reduce: String? = null,
)
