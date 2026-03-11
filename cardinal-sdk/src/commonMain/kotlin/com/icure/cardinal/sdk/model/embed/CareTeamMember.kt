// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a member of a care team involved in a patient's care, linking a healthcare party with
 * their role.
 * /
 */

sealed interface CareTeamMember : Encryptable, Identifiable<String> {
	/**
	 * The unique identifier of this care team member.
	 */
	override val id: String

	/**
	 * The type of care team member (physician, specialist, or other).
	 */
	public val careTeamMemberType: CareTeamMemberType?

	/**
	 * The identifier of the associated healthcare party.
	 */
	public val healthcarePartyId: String?

	/**
	 * A code describing the quality or qualification of this care team member.
	 */
	public val quality: CodeStub?

	/**
	 * The base64-encoded encrypted content of this care team member.
	 */
	override val encryptedSelf: Base64String?
	// region CareTeamMember-CareTeamMember

	// endregion
}

/**
 * Represents a member of a care team involved in a patient's care, linking a healthcare party with
 * their role.
 * /
 */
@Serializable
data class DecryptedCareTeamMember(
	/**
	 * The unique identifier of this care team member.
	 */
	override val id: String,
	/**
	 * The type of care team member (physician, specialist, or other).
	 */
	override val careTeamMemberType: CareTeamMemberType? = null,
	/**
	 * The identifier of the associated healthcare party.
	 */
	override val healthcarePartyId: String? = null,
	/**
	 * A code describing the quality or qualification of this care team member.
	 */
	override val quality: CodeStub? = null,
	/**
	 * The base64-encoded encrypted content of this care team member.
	 */
	override val encryptedSelf: Base64String? = null,
) : CareTeamMember {
	// region CareTeamMember-DecryptedCareTeamMember

	// endregion
}

/**
 * Represents a member of a care team involved in a patient's care, linking a healthcare party with
 * their role.
 * /
 */
@Serializable
data class EncryptedCareTeamMember(
	/**
	 * The unique identifier of this care team member.
	 */
	override val id: String,
	/**
	 * The type of care team member (physician, specialist, or other).
	 */
	override val careTeamMemberType: CareTeamMemberType? = null,
	/**
	 * The identifier of the associated healthcare party.
	 */
	override val healthcarePartyId: String? = null,
	/**
	 * A code describing the quality or qualification of this care team member.
	 */
	override val quality: CodeStub? = null,
	/**
	 * The base64-encoded encrypted content of this care team member.
	 */
	override val encryptedSelf: Base64String? = null,
) : CareTeamMember {
	// region CareTeamMember-EncryptedCareTeamMember

	// endregion
}
