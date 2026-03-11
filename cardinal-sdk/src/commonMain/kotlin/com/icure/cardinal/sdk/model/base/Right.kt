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
public data class Right(
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
)
