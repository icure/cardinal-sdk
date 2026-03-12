package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * A filter that matches users whose identifiers are contained in the provided set.
 * /
 */
@SerialName("UserByIdsFilter")
@Serializable
public data class UserByIdsFilter(
	/**
	 * The set of user identifiers to match against.
	 */
	override val ids: Set<String>,
	/**
	 * Optional human-readable description of this filter instance.
	 */
	override val desc: String? = null,
) : AbstractFilter<User>, Filter.IdsFilter<String, User>
