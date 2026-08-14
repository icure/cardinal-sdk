// auto-generated file
package com.icure.cardinal.sdk.js.model.base

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun dataOwnerHierarchyInfo_toJs(obj: DataOwnerHierarchyInfo): DataOwnerHierarchyInfoJs {
	val id = obj.id
	val dataOwnerType = obj.dataOwnerType.name
	val links = listToArray(
		obj.links,
		{ x1: DataOwnerHierarchyInfo.HierarchyNode ->
			dataOwnerHierarchyInfo_HierarchyNode_toJs(x1)
		},
	)
	return DataOwnerHierarchyInfoJs(js("{" +
		"id:id," +
		"dataOwnerType:dataOwnerType," +
		"links:links" +
	"}"))
}

public fun dataOwnerHierarchyInfo_fromJs(obj: DataOwnerHierarchyInfoJs): DataOwnerHierarchyInfo {
	val id = obj.id
	val dataOwnerType = DataOwnerType.valueOf(obj.dataOwnerType)
	val links = arrayToList(
		obj.links,
		"obj.links",
		{ x1: DataOwnerHierarchyInfoJs_HierarchyNodeJs ->
			dataOwnerHierarchyInfo_HierarchyNode_fromJs(x1)
		},
	)
	return DataOwnerHierarchyInfo(
		id = id,
		dataOwnerType = dataOwnerType,
		links = links,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun dataOwnerHierarchyInfo_HierarchyNode_toJs(obj: DataOwnerHierarchyInfo.HierarchyNode):
		DataOwnerHierarchyInfoJs_HierarchyNodeJs {
	val linkedGroupId = obj.linkedGroupId
	val linkType = obj.linkType.name
	val transitiveLinks = listToArray(
		obj.transitiveLinks,
		{ x1: DataOwnerHierarchyInfo.HierarchyNode ->
			dataOwnerHierarchyInfo_HierarchyNode_toJs(x1)
		},
	)
	return DataOwnerHierarchyInfoJs_HierarchyNodeJs(js("{" +
		"linkedGroupId:linkedGroupId," +
		"linkType:linkType," +
		"transitiveLinks:transitiveLinks" +
	"}"))
}

public
		fun dataOwnerHierarchyInfo_HierarchyNode_fromJs(obj: DataOwnerHierarchyInfoJs_HierarchyNodeJs):
		DataOwnerHierarchyInfo.HierarchyNode {
	val linkedGroupId = obj.linkedGroupId
	val linkType = DataOwnerGroupLinkType.valueOf(obj.linkType)
	val transitiveLinks = arrayToList(
		obj.transitiveLinks,
		"obj.transitiveLinks",
		{ x1: DataOwnerHierarchyInfoJs_HierarchyNodeJs ->
			dataOwnerHierarchyInfo_HierarchyNode_fromJs(x1)
		},
	)
	return DataOwnerHierarchyInfo.HierarchyNode(
		linkedGroupId = linkedGroupId,
		linkType = linkType,
		transitiveLinks = transitiveLinks,
	)
}
