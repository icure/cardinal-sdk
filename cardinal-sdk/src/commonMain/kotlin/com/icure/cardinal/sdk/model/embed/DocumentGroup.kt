package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a grouping of documents, identified by a GUID and a human-readable name.
 * /
 */
@Serializable
public data class DocumentGroup(
	/**
	 * The globally unique identifier for this document group.
	 */
	public val guid: String? = null,
	/**
	 * The human-readable name of the document group.
	 */
	public val name: String? = null,
)
