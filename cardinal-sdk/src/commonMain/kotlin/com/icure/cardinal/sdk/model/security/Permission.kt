package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Set

/**
 * Represents the combined set of granted and revoked permissions for a user or role.
 * Revocations take precedence over grants when both apply to the same permission type.
 * /
 */
@Serializable
public data class Permission(
	/**
	 * The set of permission items that are explicitly granted.
	 */
	@param:DefaultValue("emptySet()")
	public val grants: Set<PermissionItem> = emptySet(),
	/**
	 * The set of permission items that are explicitly revoked.
	 */
	@param:DefaultValue("emptySet()")
	public val revokes: Set<PermissionItem> = emptySet(),
)
