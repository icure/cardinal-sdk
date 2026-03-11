package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents a time-bounded membership of a care team member, specifying the period and type of
 * involvement.
 * /
 */
public sealed interface CareTeamMembership : Encryptable {
	/**
	 * The start date (unix epoch in ms) of this membership.
	 */
	public val startDate: Long?

	/**
	 * The end date (unix epoch in ms) of this membership.
	 */
	public val endDate: Long?

	/**
	 * The identifier of the care team member.
	 */
	public val careTeamMemberId: String?

	/**
	 * The type of membership.
	 */
	public val membershipType: MembershipType?

	/**
	 * The base64-encoded encrypted content of this membership.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * Represents a time-bounded membership of a care team member, specifying the period and type of
 * involvement.
 * /
 */
@Serializable
public data class DecryptedCareTeamMembership(
	/**
	 * The start date (unix epoch in ms) of this membership.
	 */
	override val startDate: Long? = null,
	/**
	 * The end date (unix epoch in ms) of this membership.
	 */
	override val endDate: Long? = null,
	/**
	 * The identifier of the care team member.
	 */
	override val careTeamMemberId: String? = null,
	/**
	 * The type of membership.
	 */
	override val membershipType: MembershipType? = null,
	/**
	 * The base64-encoded encrypted content of this membership.
	 */
	override val encryptedSelf: Base64String? = null,
) : CareTeamMembership

/**
 * Represents a time-bounded membership of a care team member, specifying the period and type of
 * involvement.
 * /
 */
@Serializable
public data class EncryptedCareTeamMembership(
	/**
	 * The start date (unix epoch in ms) of this membership.
	 */
	override val startDate: Long? = null,
	/**
	 * The end date (unix epoch in ms) of this membership.
	 */
	override val endDate: Long? = null,
	/**
	 * The identifier of the care team member.
	 */
	override val careTeamMemberId: String? = null,
	/**
	 * The type of membership.
	 */
	override val membershipType: MembershipType? = null,
	/**
	 * The base64-encoded encrypted content of this membership.
	 */
	override val encryptedSelf: Base64String? = null,
) : CareTeamMembership
