// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.String

/**
 * DTO representing a key-document ID pair used for cursor-based pagination in CouchDB views.
 * /
 */
@Serializable
data class PaginatedDocumentKeyIdPair(
	/**
	 * The view key to start the next page from.
	 */
	public val startKey: JsonElement? = null,
	/**
	 * The document identifier to start the next page from, used to disambiguate when multiple
	 * documents share the same key.
	 */
	public val startKeyDocId: String? = null,
) {
	// region PaginatedDocumentKeyIdPair-PaginatedDocumentKeyIdPair

	// endregion
}
