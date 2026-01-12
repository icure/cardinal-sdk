package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Set

@Serializable
public data class Permission(
	@DefaultValue("emptySet()")
	public val grants: Set<PermissionItem> = emptySet(),
	@DefaultValue("emptySet()")
	public val revokes: Set<PermissionItem> = emptySet(),
)
