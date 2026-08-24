// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 *
 *  The id of a data owner together with its group hierarchies as a tree of ids.
 */
@Serializable
data class DataOwnerHierarchyInfo(
	/**
	 * The id of the data owner.
	 */
	public val id: String,
	/**
	 * The id of the data owner.
	 */
	public val dataOwnerType: DataOwnerType,
	/**
	 *
	 *  One node for each group the data owner is directly linked to, through the legacy parentId or a
	 * dataOwnerGroups
	 *  link, in the declaration order of the links. A group reachable through multiple paths appears
	 * in each path.
	 */
	@param:DefaultValue("emptyList()")
	public val links: List<HierarchyNode> = emptyList(),
) {
	@Serializable
	public data class HierarchyNode(
		public val linkedGroupId: String,
		public val linkType: DataOwnerGroupLinkType,
		@param:DefaultValue("emptyList()")
		public val transitiveLinks: List<HierarchyNode> = emptyList(),
	)

	// region DataOwnerHierarchyInfo-DataOwnerHierarchyInfo

	/**
	 * Lazily traverses the nodes of this hierarchy tree breadth-first, following only the links accepted by
	 * [followLink]: as soon as a link is rejected, the node it points to is not emitted and its own links are not
	 * followed, even if a link further down that same path would have been accepted.
	 * The links of a group reachable through several paths are followed only once, the first time the group is
	 * reached, but the group itself is emitted once per path, so callers that need distinct ids must deduplicate
	 * the emitted nodes.
	 */
	private fun traverseNodes(followLink: (HierarchyNode) -> Boolean = { true }): Sequence<HierarchyNode> = sequence {
		val traversed = mutableSetOf(id)
		val remainingNodes = links.filterTo(ArrayDeque(), followLink)
		while (remainingNodes.isNotEmpty()) {
			val node = remainingNodes.removeFirst()
			yield(node)
			if (traversed.add(node.linkedGroupId)) {
				node.transitiveLinks.filterTo(remainingNodes, followLink)
			}
		}
	}

	/**
	 * Flattens this hierarchy tree into a deduplicated set of ids containing the data owner's own [id] plus the
	 * ids of all groups linked to it.
	 * A path is only followed while every link type it goes through is in [filterLinkTypes] (or unconditionally if
	 * [filterLinkTypes] is null); traversal stops as soon as it meets a link whose type is not in
	 * [filterLinkTypes], and does not resume even if a link further down the same path would have matched again. A
	 * group reachable through several paths appears only once, and its own links are traversed only once, the
	 * first time it is reached.
	 */
	fun flattened(filterLinkTypes: Set<DataOwnerGroupLinkType>? = null): Set<String> =
		traverseNodes { filterLinkTypes == null || it.linkType in filterLinkTypes }
			.mapTo(mutableSetOf(id)) { it.linkedGroupId }

	/**
	 * Restricts this hierarchy tree to the nodes reachable exclusively through [DataOwnerGroupLinkType.Parent]
	 * links, dropping any node reached through a link of another type together with its whole subtree. If
	 * [from] is not null the returned hierarchy is re-rooted at the node with that id, which must be part of the
	 * parent-only hierarchy.
	 * @throws IllegalArgumentException if [from] is not part of the parent-only hierarchy of this data owner.
	 */
	internal fun parentHierarchy(from: String? = null): DataOwnerHierarchyInfo {
		val parentOnlyHierarchy = filterLinks { it.linkType == DataOwnerGroupLinkType.Parent }
		return if (from == null) {
			parentOnlyHierarchy
		} else {
			val node = parentOnlyHierarchy.traverseNodes().firstOrNull { it.linkedGroupId == from }
			require(node != null) {
				"Data owner $from is not part of the parent hierarchy of $id."
			}
			DataOwnerHierarchyInfo(id = from, dataOwnerType = dataOwnerType, links = node.transitiveLinks)
		}
	}

	/**
	 * The ids of all data owners in this hierarchy tree (excluding [id] itself, unless it has no [links]) that
	 * have no further transitive links, deduplicated. As with [flattened], a group reachable through several
	 * paths has its own links traversed only once, the first time it is reached.
	 */
	fun leaves(): Set<String> =
		if (links.isEmpty()) {
			setOf(id)
		} else {
			traverseNodes().filter { it.transitiveLinks.isEmpty() }.mapTo(mutableSetOf()) { it.linkedGroupId }
		}

	/**
	 * Checks whether [dataOwnerId] is [id] itself or the id of any group reachable through this hierarchy tree,
	 * regardless of link type. As with [flattened], a group reachable through several paths has its own links
	 * traversed only once, the first time it is reached; unlike [flattened], traversal stops as soon as a match
	 * is found instead of building the full set of ids first.
	 */
	operator fun contains(dataOwnerId: String): Boolean =
		id == dataOwnerId || traverseNodes().any { it.linkedGroupId == dataOwnerId }

	/**
	 * Returns a copy of this hierarchy tree keeping only the links accepted by [predicate], at any depth.
	 * A rejected node is dropped together with its whole subtree, even if some of the links inside that subtree
	 * would have been accepted: this mirrors reachability, since a group that can only be reached through a
	 * dropped link cannot be reached at all. Filtering by link type this way and then flattening the result is
	 * therefore equivalent to [flattened] with `filterLinkTypes`, but builds an intermediate tree.
	 * [id] and [dataOwnerType] are never affected, so the result may end up with no [links] at all. Note that
	 * [leaves] of the filtered hierarchy may include nodes that were not leaves of the original one, because all
	 * of their own links were dropped.
	 * [predicate] is applied to the nodes of the original tree: the [HierarchyNode.transitiveLinks] of the node it
	 * receives are not filtered yet.
	 */
	fun filterLinks(predicate: (HierarchyNode) -> Boolean): DataOwnerHierarchyInfo =
		copy(
			links = links.filterRecursively(predicate)
		)

	/**
	 * Recursively filters this list of nodes (and their [HierarchyNode.transitiveLinks]) to keep only the nodes
	 * accepted by [predicate].
	 */
	private fun List<HierarchyNode>.filterRecursively(predicate: (HierarchyNode) -> Boolean): List<HierarchyNode> =
		filter(predicate).map {
			it.copy(transitiveLinks = it.transitiveLinks.filterRecursively(predicate))
		}

	// endregion
}
