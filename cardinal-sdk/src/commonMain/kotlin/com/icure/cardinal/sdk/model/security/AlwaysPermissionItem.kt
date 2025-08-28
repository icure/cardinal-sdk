package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AlwaysPermissionItemDto")
@Serializable
data class AlwaysPermissionItem(
	override val type: PermissionType,
) : PermissionItem {
	override val predicate: AlwaysPredicate
	// region AlwaysPermissionItem-AlwaysPermissionItem

	// endregion
}
