package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Permission(
	@param:DefaultValue("emptySet()")
	public val grants: Set<PermissionItem> = emptySet(),
	@param:DefaultValue("emptySet()")
	public val revokes: Set<PermissionItem> = emptySet(),
) {
	// region Permission-Permission

	// endregion
}
