// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 *
 *  The id of a data owner together with its group hierarchies as a tree of ids.
 */
@Serializable
data class DataOwnerIdWithHierarchy(
	/**
	 * The id of the data owner.
	 */
	public val id: String,
	/**
	 *
	 *  One node for each group the data owner is directly linked to, through the legacy parentId or a
	 * dataOwnerGroups
	 *  link, in the declaration order of the links. A group reachable through multiple paths appears
	 * once per path.
	 */
	@param:DefaultValue("emptyList()")
	public val parents: List<DataOwnerIdWithHierarchy> = emptyList(),
) {
	// region DataOwnerIdWithHierarchy-DataOwnerIdWithHierarchy
	// endregion
}
