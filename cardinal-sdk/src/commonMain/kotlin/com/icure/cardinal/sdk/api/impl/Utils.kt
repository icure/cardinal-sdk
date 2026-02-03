package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.base.Versionable
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.utils.InternalIcureApi

internal fun <T> Map<String, T>.keyAsLocalDataOwnerReferences() =
	mapKeys { EntityReferenceInGroup(it.key, null) }

internal fun Set<String>.asLocalDataOwnerReferences(): Set<EntityReferenceInGroup> =
	mapTo(mutableSetOf()) { EntityReferenceInGroup(it, null) }

/**
 * Maps multiple group scoped entities that can also have different groups.
 * For each group calls a single function to map all entities of that group.
 *
 * The map chunk function can return fewer entities than the input, but each entity returned must have an id that is in
 * the input.
 *
 * Guarantees ordering of output to be the same as input (excluding entities that aren't returned by mapChunk).
 * @param mapChunk a function that takes in input a group and a list of entities.
 */
@InternalIcureApi
internal inline fun <
	E : Identifiable<String>,
	T : Identifiable<String>
> List<GroupScoped<E>>.mapUniqueIdentifiablesChunkedByGroup(mapChunk: (groupId: String, entities: List<E>) -> List<T>): List<GroupScoped<T>> {
	require(this.distinctBy { it.entity.id to it.groupId }.size == this.size) {
		"Duplicate entity ids in request: ${this.map { "${it.groupId}/${it.entity.id}" }.groupBy { it }.filter { it.value.size > 1 }.keys}"
	}
	val chunksByGroupWithSourceIndex = this.withIndex().groupBy { it.value.groupId }
	val res = arrayOfNulls<GroupScoped<T>>(this.size)
	chunksByGroupWithSourceIndex.map { (groupId, chunk) ->
		val resIndexById = chunk.associate { it.value.entity.id to it.index }
		val mappedChunk = mapChunk(groupId, chunk.map { it.value.entity })
		mappedChunk.forEach { mappedItem ->
			val resIndex = ensureNonNull(resIndexById[mappedItem.id]) {
				"MapChunk returned entity with id not in input"
			}
			ensure(res[resIndex] == null) { "MapChunk returned duplicate ids" }
			res[resIndex] = GroupScoped(mappedItem, groupId)
		}
	}
	return res.filterNotNull()
}

@InternalIcureApi
internal inline fun <E, T> List<GroupScoped<E>>.mapExactlyChunkedByGroup(
	mapChunk: (groupId: String, entities: List<E>) -> List<T>
): List<GroupScoped<T>> {
	val chunksByGroupWithSourceIndex = this.withIndex().groupBy { it.value.groupId }
	val res = arrayOfNulls<GroupScoped<T>>(this.size)
	chunksByGroupWithSourceIndex.map { (groupId, chunk) ->
		val mappedChunk = mapChunk(groupId, chunk.map { it.value.entity })
		ensure(mappedChunk.size == chunk.size) {
			"Group scoped entities mapped chunk size doesn't match source"
		}
		mappedChunk.forEachIndexed { chunkIndex, mappedItem ->
			res[chunk[chunkIndex].index] = GroupScoped(mappedItem, groupId)
		}
	}
	return res.filterNotNullTo(ArrayList(this.size)) // Nothing will be null
}

fun EntityAccessInformation.mapNullGroupTo(groupId: String): EntityAccessInformation =
	copy(
		permissionsByDataOwnerId = permissionsByDataOwnerId.mapKeys { (k, _) ->
			if (k.groupId == null) k.copy(groupId = groupId) else k
		}
	)

fun Set<EntityReferenceInGroup>.mapNullGroupTo(groupId: String): Set<EntityReferenceInGroup> = mapTo(mutableSetOf()) {
	if (it.groupId == null) EntityReferenceInGroup(entityId = it.entityId, groupId = groupId) else it
}

internal inline fun <E, T> groupScopedWith(input: GroupScoped<E>, block: (groupId: String, entity: E) -> T): GroupScoped<T> =
	GroupScoped(
		entity = block(input.groupId, input.entity),
		groupId = input.groupId,
	)

internal inline fun <T> groupScopedIn(groupId: String, block: (groupId: String) -> T?): GroupScoped<T>? =
	block(groupId)?.let { GroupScoped(entity = it, groupId = groupId) }

internal inline fun <T> groupScopedListIn(groupId: String, block: (groupId: String) -> List<T>): List<GroupScoped<T>> =
	block(groupId).map { GroupScoped(entity = it, groupId = groupId) }

internal inline fun <T, U> skipRequestOnEmptyList(input: List<T>, block: (List<T>) -> List<U>): List<U> =
	if (input.isNotEmpty()) block(input)
	else emptyList()

internal fun <E : Versionable<String>> basicRequireIsValidForCreation(entity: E) {
	require(entity.rev == null) {
		"Entity ${entity.id} must have a null rev for creation."
	}
}

internal fun <E : HasEncryptionMetadata> requireIsValidForCreation(entity: E) {
	basicRequireIsValidForCreation(entity)
	require(entity.securityMetadata != null) {
		"Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method."
	}
}

internal fun <E : Versionable<String>> basicRequireIsValidForCreation(entities: List<E>) =
	entities.forEach { basicRequireIsValidForCreation(it) }

internal fun <E : Versionable<String>> basicRequireIsValidForCreationInGroup(entities: List<GroupScoped<E>>) =
	entities.forEach { basicRequireIsValidForCreation(it.entity) }

internal fun <E : HasEncryptionMetadata> requireIsValidForCreation(entities: List<E>) =
	entities.forEach { requireIsValidForCreation(it) }

internal fun <E : HasEncryptionMetadata> requireIsValidForCreationInGroup(entities: List<GroupScoped<E>>) =
	entities.forEach { requireIsValidForCreation(it.entity) }

internal fun <E : Versionable<String>> requireIsValidForModification(entity: E) {
	require(entity.rev != null) {
		"Entity ${entity.id} must have a non-null rev for modification. Try to get the latest revision of the entity before update."
	}
}

internal fun <E : Versionable<String>> requireIsValidForModification(entity: GroupScoped<E>) =
	requireIsValidForModification(entity.entity)

internal fun <E : Versionable<String>> requireIsValidForModification(entities: List<E>) =
	entities.forEach { requireIsValidForModification(it) }

internal fun <E : Versionable<String>> requireIsValidForModificationInGroup(entities: List<GroupScoped<E>>) =
	entities.forEach { requireIsValidForModification(it) }
