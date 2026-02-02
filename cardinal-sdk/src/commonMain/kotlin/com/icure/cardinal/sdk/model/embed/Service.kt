package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.Int

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Service : Encryptable, ICureDocument<String>, HasEndOfLife {
	override val id: String

	public val transactionId: String?

	public val identifier: List<Identifier>

	public val subContactIds: Set<String>?

	public val plansOfActionIds: Set<String>?

	public val healthElementsIds: Set<String>?

	public val formIds: Set<String>?

	public val secretForeignKeys: Set<String>?

	public val cryptedForeignKeys: Map<String, Set<Delegation>>

	public val delegations: Map<String, Set<Delegation>>

	public val encryptionKeys: Map<String, Set<Delegation>>

	public val label: String?

	public val index: Long?

	public val content: Map<String, Content>

	public val textIndexes: Map<String, String>

	public val valueDate: Long?

	public val openingDate: Long?

	public val closingDate: Long?

	override val created: Long?

	override val modified: Long?

	override val endOfLife: Long?

	override val author: String?

	override val responsible: String?

	public val comment: String?

	public val invoicingCodes: Set<String>

	public val notes: List<Annotation>

	public val qualifiedLinks: Map<LinkQualification, Map<String, String>>

	override val codes: Set<CodeStub>

	override val tags: Set<CodeStub>

	override val encryptedSelf: Base64String?

	public val securityMetadata: SecurityMetadata?
	// region Service-Service
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.embed.Service"
	}
	// endregion
}

@Serializable
data class DecryptedService(
	override val id: String,
	override val transactionId: String? = null,
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val subContactIds: Set<String>? = null,
	override val plansOfActionIds: Set<String>? = null,
	override val healthElementsIds: Set<String>? = null,
	override val formIds: Set<String>? = null,
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String>? = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val label: String? = null,
	override val index: Long? = null,
	@param:DefaultValue("emptyMap()")
	override val content: Map<String, DecryptedContent> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val textIndexes: Map<String, String> = emptyMap(),
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val endOfLife: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val comment: String? = null,
	@param:DefaultValue("emptySet()")
	override val invoicingCodes: Set<String> = emptySet(),
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@param:DefaultValue("emptyMap()")
	override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Service {
	// region Service-DecryptedService

	// endregion
}

@Serializable
data class EncryptedService(
	override val id: String,
	override val transactionId: String? = null,
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val subContactIds: Set<String>? = null,
	override val plansOfActionIds: Set<String>? = null,
	override val healthElementsIds: Set<String>? = null,
	override val formIds: Set<String>? = null,
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String>? = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val label: String? = null,
	override val index: Long? = null,
	@param:DefaultValue("emptyMap()")
	override val content: Map<String, EncryptedContent> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val textIndexes: Map<String, String> = emptyMap(),
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val endOfLife: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val comment: String? = null,
	@param:DefaultValue("emptySet()")
	override val invoicingCodes: Set<String> = emptySet(),
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@param:DefaultValue("emptyMap()")
	override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Service {
	// region Service-EncryptedService

	// endregion
}
