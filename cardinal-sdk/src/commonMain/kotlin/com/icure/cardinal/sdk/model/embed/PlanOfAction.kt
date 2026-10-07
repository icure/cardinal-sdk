// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Extendable
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.HasMedicalLocation
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

sealed interface PlanOfAction :
	Encryptable,
	ICureDocument<String>,
	HasMedicalLocation,
	Named,
	HasEndOfLife,
	Extendable {
	override val id: String

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	public val prescriberId: String?

	public val valueDate: Long?

	public val openingDate: Long?

	public val closingDate: Long?

	public val deadlineDate: Long?

	override val name: String?

	public val descr: String?

	public val note: String?

	public val idOpeningContact: String?

	public val idClosingContact: String?

	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val status: Int

	@Deprecated("Use services linked to this healthcare approach")
	public val documentIds: Set<String>

	@Deprecated("Use services (one per care) linked to this healthcare approach")
	public val numberOfCares: Int?

	public val careTeamMemberships: List<CareTeamMembership>

	@Deprecated("Use status")
	public val relevant: Boolean

	override val encryptedSelf: Base64String?

	override val extensions: JsonObject?
	// region PlanOfAction-PlanOfAction

	// endregion
}

@Serializable
data class DecryptedPlanOfAction(
	override val id: String,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val prescriberId: String? = null,
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val deadlineDate: Long? = null,
	override val name: String? = null,
	override val descr: String? = null,
	override val note: String? = null,
	override val idOpeningContact: String? = null,
	override val idClosingContact: String? = null,
	@param:DefaultValue("0")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val status: Int = 0,
	@param:DefaultValue("emptySet()")
	@Deprecated("Use services linked to this healthcare approach")
	override val documentIds: Set<String> = emptySet(),
	@Deprecated("Use services (one per care) linked to this healthcare approach")
	override val numberOfCares: Int? = null,
	@param:DefaultValue("emptyList()")
	override val careTeamMemberships: List<DecryptedCareTeamMembership> = emptyList(),
	@param:DefaultValue("true")
	@Deprecated("Use status")
	override val relevant: Boolean = true,
	override val encryptedSelf: Base64String? = null,
	override val extensions: JsonObject? = null,
) : PlanOfAction {
	// region PlanOfAction-DecryptedPlanOfAction

	// endregion
}

@Serializable
data class EncryptedPlanOfAction(
	override val id: String,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val prescriberId: String? = null,
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val deadlineDate: Long? = null,
	override val name: String? = null,
	override val descr: String? = null,
	override val note: String? = null,
	override val idOpeningContact: String? = null,
	override val idClosingContact: String? = null,
	@param:DefaultValue("0")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val status: Int = 0,
	@param:DefaultValue("emptySet()")
	@Deprecated("Use services linked to this healthcare approach")
	override val documentIds: Set<String> = emptySet(),
	@Deprecated("Use services (one per care) linked to this healthcare approach")
	override val numberOfCares: Int? = null,
	@param:DefaultValue("emptyList()")
	override val careTeamMemberships: List<EncryptedCareTeamMembership> = emptyList(),
	@param:DefaultValue("true")
	@Deprecated("Use status")
	override val relevant: Boolean = true,
	override val encryptedSelf: Base64String? = null,
	override val extensions: JsonObject? = null,
) : PlanOfAction {
	// region PlanOfAction-EncryptedPlanOfAction

	// endregion
}
