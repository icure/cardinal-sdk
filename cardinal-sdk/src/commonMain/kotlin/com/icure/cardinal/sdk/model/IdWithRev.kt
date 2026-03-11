// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  DTO representing an entity identifier paired with its optional revision. Commonly used in
 *  bulk operations and responses to identify stored documents.
 */
@Serializable
data class IdWithRev(
	/**
	 * The unique identifier of the entity.
	 */
	public val id: String,
	/**
	 * The revision of the entity, used for optimistic locking.
	 */
	public val rev: String? = null,
) {
	// region IdWithRev-IdWithRev

	// endregion
}
