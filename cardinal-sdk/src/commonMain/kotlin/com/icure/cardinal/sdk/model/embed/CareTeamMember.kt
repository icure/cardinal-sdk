package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String

public sealed interface CareTeamMember : Encryptable, Identifiable<String> {
	override val id: String

	public val careTeamMemberType: CareTeamMemberType?

	public val healthcarePartyId: String?

	public val quality: CodeStub?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedCareTeamMember(
	override val id: String,
	override val careTeamMemberType: CareTeamMemberType? = null,
	override val healthcarePartyId: String? = null,
	override val quality: CodeStub? = null,
	override val encryptedSelf: Base64String? = null,
) : CareTeamMember

@Serializable
public data class EncryptedCareTeamMember(
	override val id: String,
	override val careTeamMemberType: CareTeamMemberType? = null,
	override val healthcarePartyId: String? = null,
	override val quality: CodeStub? = null,
	override val encryptedSelf: Base64String? = null,
) : CareTeamMember
