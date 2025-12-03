package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

public sealed interface Service : Encryptable, ICureDocument<String> {
	override val id: String

	public val transactionId: String?

	public val identifier: List<Identifier>

	public val contactId: String?

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

	public val encryptedContent: String?

	public val textIndexes: Map<String, String>

	public val valueDate: Long?

	public val openingDate: Long?

	public val closingDate: Long?

	public val formId: String?

	override val created: Long?

	override val modified: Long?

	override val endOfLife: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	public val comment: String?

	public val status: Int?

	public val invoicingCodes: Set<String>

	public val notes: List<Annotation>

	public val qualifiedLinks: Map<LinkQualification, Map<String, String>>

	override val codes: Set<CodeStub>

	override val tags: Set<CodeStub>

	override val encryptedSelf: Base64String?

	public val securityMetadata: SecurityMetadata?
}

@Serializable
public data class DecryptedService(
	override val id: String,
	override val transactionId: String? = null,
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val contactId: String? = null,
	override val subContactIds: Set<String>? = null,
	override val plansOfActionIds: Set<String>? = null,
	override val healthElementsIds: Set<String>? = null,
	override val formIds: Set<String>? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String>? = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val label: String? = null,
	override val index: Long? = null,
	@DefaultValue("emptyMap()")
	override val content: Map<String, DecryptedContent> = emptyMap(),
	override val encryptedContent: String? = null,
	@DefaultValue("emptyMap()")
	override val textIndexes: Map<String, String> = emptyMap(),
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val formId: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val endOfLife: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val comment: String? = null,
	override val status: Int? = null,
	@DefaultValue("emptySet()")
	override val invoicingCodes: Set<String> = emptySet(),
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("emptyMap()")
	override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Service

@Serializable
public data class EncryptedService(
	override val id: String,
	override val transactionId: String? = null,
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val contactId: String? = null,
	override val subContactIds: Set<String>? = null,
	override val plansOfActionIds: Set<String>? = null,
	override val healthElementsIds: Set<String>? = null,
	override val formIds: Set<String>? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String>? = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val label: String? = null,
	override val index: Long? = null,
	@DefaultValue("emptyMap()")
	override val content: Map<String, EncryptedContent> = emptyMap(),
	override val encryptedContent: String? = null,
	@DefaultValue("emptyMap()")
	override val textIndexes: Map<String, String> = emptyMap(),
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val formId: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val endOfLife: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val comment: String? = null,
	override val status: Int? = null,
	@DefaultValue("emptySet()")
	override val invoicingCodes: Set<String> = emptySet(),
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("emptyMap()")
	override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Service
