package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

/**
 *
 *  Data transfer object representing a CouchDB design document, which contains views, lists, shows,
 * filters,
 *  and update handlers used for querying and transforming data.
 */
@Serializable
public data class DesignDocument(
	/**
	 * The identifier of the design document.
	 */
	public val id: String,
	/**
	 * The current revision of the design document.
	 */
	public val rev: String? = null,
	/**
	 * A map of revision history entries.
	 */
	@param:DefaultValue("emptyMap()")
	public val revHistory: Map<String, String> = emptyMap(),
	/**
	 * The programming language used for the design document functions.
	 */
	public val language: String? = null,
	/**
	 * A map of view names to their definitions.
	 */
	@param:DefaultValue("emptyMap()")
	public val views: Map<String, View> = emptyMap(),
	/**
	 * A map of list function names to their source code.
	 */
	@param:DefaultValue("emptyMap()")
	public val lists: Map<String, String> = emptyMap(),
	/**
	 * A map of show function names to their source code.
	 */
	@param:DefaultValue("emptyMap()")
	public val shows: Map<String, String> = emptyMap(),
	/**
	 * A map of update handler names to their source code.
	 */
	public val updateHandlers: Map<String, String>? = null,
	/**
	 * A map of filter function names to their source code.
	 */
	@param:DefaultValue("emptyMap()")
	public val filters: Map<String, String> = emptyMap(),
)
