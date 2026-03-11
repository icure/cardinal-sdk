// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A permission item whose predicate always evaluates to true, unconditionally granting or revoking
 * the specified permission type.
 * /
 */
@SerialName("AlwaysPermissionItemDto")
@Serializable
data class AlwaysPermissionItem(
	/**
	 * The permission type that is always granted or revoked by this item.
	 */
	override val type: PermissionType,
) : PermissionItem {
	@DefaultValue("AlwaysPredicate()")
	override val predicate: AlwaysPredicate = AlwaysPredicate()
	// region AlwaysPermissionItem-AlwaysPermissionItem

	// endregion
}
