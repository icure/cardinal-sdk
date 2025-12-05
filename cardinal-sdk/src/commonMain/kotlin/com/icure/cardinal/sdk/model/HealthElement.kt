package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.CareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.Episode
import com.icure.cardinal.sdk.model.embed.Laterality
import com.icure.cardinal.sdk.model.embed.PlanOfAction
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

public sealed interface HealthElement :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	override val id: String

	public val identifiers: List<Identifier>

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	override val deletionDate: Long?

	public val healthElementId: String?

	public val valueDate: Long?

	public val openingDate: Long?

	public val closingDate: Long?

	public val descr: String?

	public val note: String?

	public val notes: List<Annotation>

	public val relevant: Boolean

	public val idOpeningContact: String?

	public val idClosingContact: String?

	public val idService: String?

	public val status: Int

	public val laterality: Laterality?

	public val plansOfAction: List<PlanOfAction>

	public val episodes: List<Episode>

	public val careTeam: List<CareTeamMember>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?
}

@Serializable
public data class DecryptedHealthElement(
	override val id: String,
	@DefaultValue("emptyList()")
	override val identifiers: List<Identifier> = emptyList(),
	override val rev: String? = null,
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
	override val deletionDate: Long? = null,
	override val healthElementId: String? = null,
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val descr: String? = null,
	override val note: String? = null,
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("true")
	override val relevant: Boolean = true,
	override val idOpeningContact: String? = null,
	override val idClosingContact: String? = null,
	override val idService: String? = null,
	@DefaultValue("0")
	override val status: Int = 0,
	override val laterality: Laterality? = null,
	@DefaultValue("emptyList()")
	override val plansOfAction: List<DecryptedPlanOfAction> = emptyList(),
	@DefaultValue("emptyList()")
	override val episodes: List<DecryptedEpisode> = emptyList(),
	@DefaultValue("emptyList()")
	override val careTeam: List<DecryptedCareTeamMember> = emptyList(),
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : HealthElement

@Serializable
public data class EncryptedHealthElement(
	override val id: String,
	@DefaultValue("emptyList()")
	override val identifiers: List<Identifier> = emptyList(),
	override val rev: String? = null,
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
	override val deletionDate: Long? = null,
	override val healthElementId: String? = null,
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val descr: String? = null,
	override val note: String? = null,
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("true")
	override val relevant: Boolean = true,
	override val idOpeningContact: String? = null,
	override val idClosingContact: String? = null,
	override val idService: String? = null,
	@DefaultValue("0")
	override val status: Int = 0,
	override val laterality: Laterality? = null,
	@DefaultValue("emptyList()")
	override val plansOfAction: List<EncryptedPlanOfAction> = emptyList(),
	@DefaultValue("emptyList()")
	override val episodes: List<EncryptedEpisode> = emptyList(),
	@DefaultValue("emptyList()")
	override val careTeam: List<EncryptedCareTeamMember> = emptyList(),
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : HealthElement
