package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

public sealed interface Topic :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	override val id: String

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	public val healthElementId: String?

	public val contactId: String?

	public val description: String?

	override val codes: Set<CodeStub>

	override val tags: Set<CodeStub>

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val endOfLife: Long?

	override val deletionDate: Long?

	public val activeParticipants: Map<String, TopicRole>

	override val securityMetadata: SecurityMetadata?

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	public val linkedHealthElements: Set<String>

	public val linkedServices: Set<String>
}

@Serializable
public data class DecryptedTopic(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val healthElementId: String? = null,
	override val contactId: String? = null,
	override val description: String? = null,
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	@DefaultValue("emptyMap()")
	override val activeParticipants: Map<String, TopicRole> = emptyMap(),
	override val securityMetadata: SecurityMetadata? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	@DefaultValue("emptySet()")
	override val linkedHealthElements: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	override val linkedServices: Set<String> = emptySet(),
) : Topic

@Serializable
public data class EncryptedTopic(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val healthElementId: String? = null,
	override val contactId: String? = null,
	override val description: String? = null,
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	@DefaultValue("emptyMap()")
	override val activeParticipants: Map<String, TopicRole> = emptyMap(),
	override val securityMetadata: SecurityMetadata? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	@DefaultValue("emptySet()")
	override val linkedHealthElements: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	override val linkedServices: Set<String> = emptySet(),
) : Topic
