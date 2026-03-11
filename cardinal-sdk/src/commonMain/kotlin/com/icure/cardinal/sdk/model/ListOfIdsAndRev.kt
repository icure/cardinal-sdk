// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 *
 *  DTO wrapping a list of identifier-revision pairs, used for bulk operations on versioned
 * entities.
 */
@Serializable
data class ListOfIdsAndRev(
	/**
	 * The list of identifier-revision pairs.
	 */
	public val ids: List<IdWithRev>,
) {
	// region ListOfIdsAndRev-ListOfIdsAndRev

	companion object {
		operator fun invoke(ids: List<StoredDocumentIdentifier>) = ListOfIdsAndRev(ids.map { IdWithRev(it.id, it.rev) })
	}
	// endregion
}
