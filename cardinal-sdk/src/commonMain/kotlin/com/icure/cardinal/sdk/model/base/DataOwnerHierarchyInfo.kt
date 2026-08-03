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
	 * Flattens this hierarchy tree into a deduplicated set of ids containing the data owner's own [id] plus the
	 * ids of all groups linked to it.
	 * A path is only followed while every link type it goes through is in [filterLinkTypes] (or unconditionally if
	 * [filterLinkTypes] is null); traversal stops as soon as it meets a link whose type is not in
	 * [filterLinkTypes], and does not resume even if a link further down the same path would have matched again. A
	 * group reachable through several paths appears only once, and its own links are traversed only once, the
	 * first time it is reached.
	 */
	fun flattened(filterLinkTypes: Set<DataOwnerGroupLinkType>? = null): Set<String> {
		val res = mutableSetOf(id)
		val remainingNodes = if (filterLinkTypes != null) {
			links.filterTo(ArrayDeque()) { it.linkType in filterLinkTypes }
		} else {
			ArrayDeque(links)
		}
		while (remainingNodes.isNotEmpty()) {
			val node = remainingNodes.removeFirst()
			if (res.add(node.linkedGroupId)) {
				node.transitiveLinks.forEach {
					if (filterLinkTypes == null || filterLinkTypes.contains(it.linkType)) {
						remainingNodes.add(it)
					}
				}
			}
		}
		return res
	}


	/**
	 * Restricts this hierarchy tree to the nodes reachable exclusively through [DataOwnerGroupLinkType.Parent]
	 * links, dropping any node reached through a link of another type together with its whole subtree. If
	 * [from] is not null the returned hierarchy is re-rooted at the node with that id, which must be part of the
	 * parent-only hierarchy.
	 * @throws IllegalArgumentException if [from] is not part of the parent-only hierarchy of this data owner.
	 */
	internal fun parentHierarchy(from: String? = null): DataOwnerHierarchyInfo {
		val parentOnlyLinks = links.onlyParentLinks()
		return if (from == null) {
			copy(links = parentOnlyLinks)
		} else {
			val node = parentOnlyLinks.findByLinkedGroupId(from)
			require(node != null) {
				"Data owner $from is not part of the parent hierarchy of $id."
			}
			DataOwnerHierarchyInfo(id = from, dataOwnerType = dataOwnerType, links = node.transitiveLinks)
		}
	}

	private fun List<HierarchyNode>.onlyParentLinks(): List<HierarchyNode> = filter {
		it.linkType == DataOwnerGroupLinkType.Parent
	}.map {
		it.copy(transitiveLinks = it.transitiveLinks.onlyParentLinks())
	}

	private fun List<HierarchyNode>.findByLinkedGroupId(linkedGroupId: String): HierarchyNode? {
		for (node in this) {
			if (node.linkedGroupId == linkedGroupId) return node
			node.transitiveLinks.findByLinkedGroupId(linkedGroupId)?.let { return it }
		}
		return null
	}

	// endregion

}
