// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Data transfer object representing a set of access rights defined by user names and roles.
 * /
 */
@Serializable
data class Right(
	/**
	 * The set of user names that have this right.
	 */
	@param:DefaultValue("emptySet()")
	public val names: Set<String> = emptySet(),
	/**
	 * The set of roles that have this right.
	 */
	@param:DefaultValue("emptySet()")
	public val roles: Set<String> = emptySet(),
) {
	// region Right-Right

	// endregion
}
