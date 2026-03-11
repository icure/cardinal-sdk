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
public data class AlwaysPermissionItem(
	/**
	 * The permission type that is always granted or revoked by this item.
	 */
	override val type: PermissionType,
) : PermissionItem {
	@DefaultValue("AlwaysPredicate()")
	override val predicate: AlwaysPredicate = AlwaysPredicate()
}
