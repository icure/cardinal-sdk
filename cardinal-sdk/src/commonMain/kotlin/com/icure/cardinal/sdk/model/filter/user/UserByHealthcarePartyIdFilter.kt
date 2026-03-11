package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * A filter that matches users linked to a specific healthcare party.
 * /
 */
@SerialName("UserByHealthcarePartyIdFilter")
@Serializable
public data class UserByHealthcarePartyIdFilter(
	/**
	 * The identifier of the healthcare party whose associated users should be returned.
	 */
	public val healthcarePartyId: String,
	/**
	 * Optional human-readable description of this filter instance.
	 */
	override val desc: String? = null,
) : AbstractFilter<User>
