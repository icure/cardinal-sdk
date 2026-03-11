// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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

sealed interface CareTeamMembership : Encryptable {
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
	// region CareTeamMembership-CareTeamMembership

	// endregion
}

/**
 * Represents a time-bounded membership of a care team member, specifying the period and type of
 * involvement.
 * /
 */
@Serializable
data class DecryptedCareTeamMembership(
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
) : CareTeamMembership {
	// region CareTeamMembership-DecryptedCareTeamMembership

	// endregion
}

/**
 * Represents a time-bounded membership of a care team member, specifying the period and type of
 * involvement.
 * /
 */
@Serializable
data class EncryptedCareTeamMembership(
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
) : CareTeamMembership {
	// region CareTeamMembership-EncryptedCareTeamMembership

	// endregion
}
