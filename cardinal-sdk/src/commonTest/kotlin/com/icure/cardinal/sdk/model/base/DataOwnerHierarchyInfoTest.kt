package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

private fun node(
	linkedGroupId: String,
	linkType: DataOwnerGroupLinkType = DataOwnerGroupLinkType.Simple,
	transitiveLinks: List<DataOwnerHierarchyInfo.HierarchyNode> = emptyList(),
) = DataOwnerHierarchyInfo.HierarchyNode(linkedGroupId, linkType, transitiveLinks)

class DataOwnerHierarchyInfoTest : StringSpec({
	/*
	 * A -> B -> D -> E
	 *   -> C -> D -> F
	 *   -> G -> H
	 * D and its subtree (E, F) are reachable through both B and C.
	 */
	val diamondPlusBranch = DataOwnerHierarchyInfo(
		id = "A",
		dataOwnerType = DataOwnerType.Hcp,
		links = listOf(
			node("B", transitiveLinks = listOf(node("D", transitiveLinks = listOf(node("E"), node("F"))))),
			node("C", transitiveLinks = listOf(node("D", transitiveLinks = listOf(node("E"), node("F"))))),
			node("G", transitiveLinks = listOf(node("H"))),
		),
	)

	val singleNode = DataOwnerHierarchyInfo(id = "A", dataOwnerType = DataOwnerType.Hcp)

	val parentChain = DataOwnerHierarchyInfo(
		id = "A",
		dataOwnerType = DataOwnerType.Hcp,
		links = listOf(
			node(
				"B",
				linkType = DataOwnerGroupLinkType.Parent,
				transitiveLinks = listOf(
					node("C", linkType = DataOwnerGroupLinkType.Simple, transitiveLinks = listOf(node("D", linkType = DataOwnerGroupLinkType.Parent))),
				),
			),
		),
	)

	"flattened should include the data owner's own id even with no links".config(enabled = DEFAULT_ENABLED) {
		singleNode.flattened() shouldBe setOf("A")
	}

	"flattened should deduplicate a group reachable through multiple paths".config(enabled = DEFAULT_ENABLED) {
		diamondPlusBranch.flattened() shouldContainExactlyInAnyOrder listOf("A", "B", "C", "D", "E", "F", "G", "H")
	}

	"flattened should stop following a path as soon as a non-matching link type is met".config(enabled = DEFAULT_ENABLED) {
		parentChain.flattened(setOf(DataOwnerGroupLinkType.Parent)) shouldContainExactlyInAnyOrder listOf("A", "B")
	}

	"leaves should be just the data owner's own id when there are no links".config(enabled = DEFAULT_ENABLED) {
		singleNode.leaves() shouldBe setOf("A")
	}

	"leaves should only return nodes without transitive links, deduplicated".config(enabled = DEFAULT_ENABLED) {
		diamondPlusBranch.leaves() shouldContainExactlyInAnyOrder listOf("E", "F", "H")
	}

	"contains should be true for the data owner's own id".config(enabled = DEFAULT_ENABLED) {
		(singleNode.contains("A")) shouldBe true
		("A" in diamondPlusBranch) shouldBe true
	}

	"contains should be true for every id reachable through the tree, including ones reached through multiple paths".config(enabled = DEFAULT_ENABLED) {
		listOf("B", "C", "D", "E", "F", "G", "H").forEach {
			(it in diamondPlusBranch) shouldBe true
		}
	}

	"contains should be false for an id not part of the hierarchy".config(enabled = DEFAULT_ENABLED) {
		("Z" in diamondPlusBranch) shouldBe false
		("Z" in singleNode) shouldBe false
	}

	"parentHierarchy should keep only nodes reachable exclusively through parent links".config(enabled = DEFAULT_ENABLED) {
		parentChain.parentHierarchy().flattened() shouldContainExactlyInAnyOrder listOf("A", "B")
	}

	"parentHierarchy re-rooted at a node should expose only its own parent-only subtree".config(enabled = DEFAULT_ENABLED) {
		val fullParentChain = DataOwnerHierarchyInfo(
			id = "A",
			dataOwnerType = DataOwnerType.Hcp,
			links = listOf(
				node(
					"B",
					linkType = DataOwnerGroupLinkType.Parent,
					transitiveLinks = listOf(node("D", linkType = DataOwnerGroupLinkType.Parent)),
				),
			),
		)
		val reRooted = fullParentChain.parentHierarchy(from = "B")
		reRooted.id shouldBe "B"
		reRooted.flattened() shouldContainExactlyInAnyOrder listOf("B", "D")
	}

	"filterLinks should drop a rejected node together with its whole subtree".config(enabled = DEFAULT_ENABLED) {
		val withoutD = diamondPlusBranch.filterLinks { it.linkedGroupId != "D" }
		withoutD.flattened() shouldContainExactlyInAnyOrder listOf("A", "B", "C", "G", "H")
		withoutD.leaves() shouldContainExactlyInAnyOrder listOf("B", "C", "H")
	}

	"filterLinks by link type should be equivalent to flattened with the same link types".config(enabled = DEFAULT_ENABLED) {
		val parentOnly = parentChain.filterLinks { it.linkType == DataOwnerGroupLinkType.Parent }
		parentOnly.flattened() shouldContainExactlyInAnyOrder
			parentChain.flattened(setOf(DataOwnerGroupLinkType.Parent)).toList()
		parentOnly shouldBe parentChain.parentHierarchy()
	}
})
