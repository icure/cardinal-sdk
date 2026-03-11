// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class Permission(
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
) {
	// region Permission-Permission

	// endregion
}
