package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

public sealed interface PlanOfAction : Encryptable, ICureDocument<String>, Named {
	override val id: String

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

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

	public val status: Int

	public val documentIds: Set<String>

	public val numberOfCares: Int?

	public val careTeamMemberships: List<CareTeamMembership?>

	public val relevant: Boolean

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedPlanOfAction(
	override val id: String,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
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
	@DefaultValue("0")
	override val status: Int = 0,
	@DefaultValue("emptySet()")
	override val documentIds: Set<String> = emptySet(),
	override val numberOfCares: Int? = null,
	@DefaultValue("emptyList()")
	override val careTeamMemberships: List<DecryptedCareTeamMembership?> = emptyList(),
	@DefaultValue("true")
	override val relevant: Boolean = true,
	override val encryptedSelf: Base64String? = null,
) : PlanOfAction

@Serializable
public data class EncryptedPlanOfAction(
	override val id: String,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
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
	@DefaultValue("0")
	override val status: Int = 0,
	@DefaultValue("emptySet()")
	override val documentIds: Set<String> = emptySet(),
	override val numberOfCares: Int? = null,
	@DefaultValue("emptyList()")
	override val careTeamMemberships: List<EncryptedCareTeamMembership?> = emptyList(),
	@DefaultValue("true")
	override val relevant: Boolean = true,
	override val encryptedSelf: Base64String? = null,
) : PlanOfAction
