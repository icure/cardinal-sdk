package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.String

/**
 * DTO representing a key-document ID pair used for cursor-based pagination in CouchDB views.
 * /
 */
@Serializable
public data class PaginatedDocumentKeyIdPair(
	/**
	 * The view key to start the next page from.
	 */
	public val startKey: JsonElement? = null,
	/**
	 * The document identifier to start the next page from, used to disambiguate when multiple
	 * documents share the same key.
	 */
	public val startKeyDocId: String? = null,
)
