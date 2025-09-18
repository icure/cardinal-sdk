package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("UserByHealthcarePartyIdFilter")
@Serializable
public data class UserByHealthcarePartyIdFilter(
	public val healthcarePartyId: String,
	override val desc: String? = null,
) : AbstractFilter<User>
