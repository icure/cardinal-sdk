package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo
import kotlinx.serialization.Serializable

/**
 * Expose hierarchical data owner information, following only [DataOwnerGroupLinkType.Parent]-type links.
 * No loops are allowed (this is enforced server-side), but diamond shapes are: a data owner reachable through
 * several paths appears once per path, as in [DataOwnerHierarchyInfo].
 */
@Serializable
data class DataOwnerParentHierarchyWith<T>(
	val value: T,
	val dataOwnerType: DataOwnerType,
	val links: List<HierarchyNode<T>> = emptyList(),
) {
	@Serializable
	data class HierarchyNode<T>(
		val value: T,
		val transitiveLinks: List<HierarchyNode<T>> = emptyList(),
	)

}

/**
 * Flattens this hierarchy tree into a list containing [DataOwnerParentHierarchyWith.value] followed by the
 * [DataOwnerParentHierarchyWith.HierarchyNode.value] of every node, depth-first. A data owner reachable through
 * several paths (diamond shape) appears once per path.
 */
fun <T> DataOwnerParentHierarchyWith<T>.toList(): List<T> {
	val result = mutableListOf(value)
	fun collect(nodes: List<DataOwnerParentHierarchyWith.HierarchyNode<T>>) {
		nodes.forEach {
			result.add(it.value)
			collect(it.transitiveLinks)
		}
	}
	collect(links)
	return result
}

/**
 * Flattens the direct [DataOwnerParentHierarchyWith.links] of this hierarchy tree (excluding the root
 * [DataOwnerParentHierarchyWith.value] itself) into a list ordered from the topmost ancestor to the direct link,
 * depth-first per branch. For a non-branching chain this means the topmost ancestor comes first and the direct
 * parent comes last; order is deterministic, but not otherwise meaningful, once the hierarchy branches (multiple
 * parents / diamonds).
 */
fun <T> List<DataOwnerParentHierarchyWith.HierarchyNode<T>>.flattenTopmostFirst(): List<T> =
	flatMap { it.transitiveLinks.flattenTopmostFirst() + it.value }

/**
 * Returns the first non-null result of applying [transform] to [DataOwnerParentHierarchyWith.value] and to the
 * value of every node of this hierarchy tree, depth-first, or null if [transform] returns null for every one of
 * them.
 */
fun <T, R : Any> DataOwnerParentHierarchyWith<T>.firstNotNullOfOrNull(transform: (T) -> R?): R? {
	transform(value)?.let { return it }
	fun search(nodes: List<DataOwnerParentHierarchyWith.HierarchyNode<T>>): R? {
		for (node in nodes) {
			transform(node.value)?.let { return it }
			search(node.transitiveLinks)?.let { return it }
		}
		return null
	}
	return search(links)
}

/**
 * Builds a [DataOwnerParentHierarchyWith] mirroring the shape of this (already parent-only-filtered, see
 * [DataOwnerHierarchyInfo.parentHierarchy]) hierarchy tree, associating to each data owner id in the tree its
 * value in [valuesById].
 */
internal fun <T> DataOwnerHierarchyInfo.toParentHierarchyWith(valuesById: Map<String, T>): DataOwnerParentHierarchyWith<T> {
	fun buildNode(node: DataOwnerHierarchyInfo.HierarchyNode): DataOwnerParentHierarchyWith.HierarchyNode<T> =
		DataOwnerParentHierarchyWith.HierarchyNode(
			value = valuesById.getValue(node.linkedGroupId),
			transitiveLinks = node.transitiveLinks.map(::buildNode),
		)
	return DataOwnerParentHierarchyWith(
		value = valuesById.getValue(id),
		dataOwnerType = dataOwnerType,
		links = links.map(::buildNode),
	)
}