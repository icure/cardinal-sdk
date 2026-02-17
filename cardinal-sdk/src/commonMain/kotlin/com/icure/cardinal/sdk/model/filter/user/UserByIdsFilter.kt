package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("UserByIdsFilter")
@Serializable
public data class UserByIdsFilter(
	override val ids: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<User>, Filter.IdsFilter<String, User>
