package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

public sealed interface CareTeamMembership : Encryptable {
	public val startDate: Long?

	public val endDate: Long?

	public val careTeamMemberId: String?

	public val membershipType: MembershipType?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedCareTeamMembership(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val careTeamMemberId: String? = null,
	override val membershipType: MembershipType? = null,
	override val encryptedSelf: Base64String? = null,
) : CareTeamMembership

@Serializable
public data class EncryptedCareTeamMembership(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val careTeamMemberId: String? = null,
	override val membershipType: MembershipType? = null,
	override val encryptedSelf: Base64String? = null,
) : CareTeamMembership
