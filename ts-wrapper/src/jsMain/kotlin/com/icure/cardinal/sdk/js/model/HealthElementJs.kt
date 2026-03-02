// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.HasEndOfLifeJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.AnnotationJs
import com.icure.cardinal.sdk.js.model.embed.CareTeamMemberJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedCareTeamMemberJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedEpisodeJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedPlanOfActionJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedCareTeamMemberJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedEpisodeJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedPlanOfActionJs
import com.icure.cardinal.sdk.js.model.embed.EpisodeJs
import com.icure.cardinal.sdk.js.model.embed.PlanOfActionJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HealthElement")
public sealed external interface HealthElementJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs, HasEndOfLifeJs {
	public val identifiers: Array<out IdentifierJs>

	public val healthElementId: String?

	public val valueDate: Double?

	public val openingDate: Double?

	public val closingDate: Double?

	public val descr: String?

	public val note: String?

	public val notes: Array<out AnnotationJs>

	public val relevant: Boolean

	public val idOpeningContact: String?

	public val idClosingContact: String?

	public val idService: String?

	public val laterality: String?

	public val plansOfAction: Array<out PlanOfActionJs>

	public val episodes: Array<out EpisodeJs>

	public val careTeam: Array<out CareTeamMemberJs>

	public val isEncrypted: Boolean
}

@JsName("DecryptedHealthElement")
public external class DecryptedHealthElementJs(
	partial: dynamic,
) : HealthElementJs {
	override val id: String

	override val identifiers: Array<IdentifierJs>

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val healthElementId: String?

	override val valueDate: Double?

	override val openingDate: Double?

	override val closingDate: Double?

	override val descr: String?

	override val note: String?

	override val notes: Array<AnnotationJs>

	override val relevant: Boolean

	override val idOpeningContact: String?

	override val idClosingContact: String?

	override val idService: String?

	override val laterality: String?

	override val plansOfAction: Array<DecryptedPlanOfActionJs>

	override val episodes: Array<DecryptedEpisodeJs>

	override val careTeam: Array<DecryptedCareTeamMemberJs>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}

@JsName("EncryptedHealthElement")
public external class EncryptedHealthElementJs(
	partial: dynamic,
) : HealthElementJs {
	override val id: String

	override val identifiers: Array<IdentifierJs>

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val healthElementId: String?

	override val valueDate: Double?

	override val openingDate: Double?

	override val closingDate: Double?

	override val descr: String?

	override val note: String?

	override val notes: Array<AnnotationJs>

	override val relevant: Boolean

	override val idOpeningContact: String?

	override val idClosingContact: String?

	override val idService: String?

	override val laterality: String?

	override val plansOfAction: Array<EncryptedPlanOfActionJs>

	override val episodes: Array<EncryptedEpisodeJs>

	override val careTeam: Array<EncryptedCareTeamMemberJs>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}
