package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllUsersFilter")
@Serializable
public data class AllUsersFilter(
	override val desc: String? = null,
) : AbstractFilter<User>, Filter.AllFilter<User>
