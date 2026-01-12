package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("UserByNameEmailPhoneFilter")
@Serializable
public data class UserByNameEmailPhoneFilter(
	public val searchString: String,
	override val desc: String? = null,
) : AbstractFilter<User>
