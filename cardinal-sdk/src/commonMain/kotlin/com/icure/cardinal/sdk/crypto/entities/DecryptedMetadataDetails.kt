package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.utils.InternalIcureApi

/**
 * Contains decrypted metadata and the data owners part of the current data owner hierarchy which have access to it.
 */
@InternalIcureApi
data class DecryptedMetadataDetails<T : Any>(
	/**
	 * The decrypted metadata
	 */
	val value: T,
	/**
	 * The ids data owners know to have access to [value].
	 */
	val dataOwnersWithAccess: Set<EntityReferenceInGroup>
) {
	companion object {
		/**
		 * Groups the [DecryptedMetadataDetails] to have
		 * Only works if T has proper equals hash code which is ok for all current concrete uses as of writing
		 */
		internal fun <T : Any> List<DecryptedMetadataDetails<T>>.groupedByValueToAllDataOwnersWithAccess(): Map<T, Set<EntityReferenceInGroup>> =
			groupingBy {
				it.value
			}.aggregate<_, _, MutableSet<EntityReferenceInGroup>> { _, accumulator, element, _ ->
				accumulator?.also {
					it.addAll(element.dataOwnersWithAccess)
				} ?: element.dataOwnersWithAccess.toMutableSet()
			}
	}
}