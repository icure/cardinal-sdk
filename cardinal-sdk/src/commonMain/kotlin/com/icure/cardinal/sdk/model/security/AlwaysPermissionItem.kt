package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AlwaysPermissionItemDto")
@Serializable
data class AlwaysPermissionItem(
	override val type: PermissionType,
) : PermissionItem {
	@DefaultValue("AlwaysPredicate()")
	override val predicate: AlwaysPredicate = AlwaysPredicate()
	// region AlwaysPermissionItem-AlwaysPermissionItem

	// endregion
}
