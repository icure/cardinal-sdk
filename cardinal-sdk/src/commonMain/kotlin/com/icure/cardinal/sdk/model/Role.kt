// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * The RoleDto class represents a role in the system, which can have permissions and can be
 * inheritable up to a certain level by users in child Groups.$
 * down the group hierarchy this role can be inherited by users in child groups. A value of 0 means
 * it cannot be inherited, while a value of -1 means it can be inherited indefinitely.
 * /
 */
@Serializable
data class Role(
	/**
	 * The unique identifier of the role.
	 */
	override val id: String,
	/**
	 * The revision identifier of the role, used for optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp of when the role was deleted, if applicable.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The name of the role.
	 */
	public val name: String? = null,
	/**
	 * The maximum level of inheritance for this role, indicating how far
	 */
	public val inheritableUpTo: Int? = null,
	/**
	 * A set of permissions associated with this role, defining what actions users with this role can
	 * perform.
	 */
	@param:DefaultValue("emptySet()")
	public val permissions: Set<String> = emptySet(),
) : StoredDocument {
	// region Role-Role

	// endregion
}
