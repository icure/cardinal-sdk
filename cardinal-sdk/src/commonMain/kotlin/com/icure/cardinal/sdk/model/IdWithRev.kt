package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  DTO representing an entity identifier paired with its optional revision. Commonly used in
 *  bulk operations and responses to identify stored documents.
 */
@Serializable
public data class IdWithRev(
	/**
	 * The unique identifier of the entity.
	 */
	public val id: String,
	/**
	 * The revision of the entity, used for optimistic locking.
	 */
	public val rev: String? = null,
)
