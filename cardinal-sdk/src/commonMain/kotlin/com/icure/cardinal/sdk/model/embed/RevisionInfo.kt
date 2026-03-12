package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents revision information for a CouchDB document, including the revision identifier and its
 * status.
 * /
 */
@Serializable
public data class RevisionInfo(
	/**
	 * The revision identifier.
	 */
	public val rev: String? = null,
	/**
	 * The status of this revision (e.g., available, missing, deleted).
	 */
	public val status: String? = null,
)
