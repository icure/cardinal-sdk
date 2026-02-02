package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.ContactParticipant
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.DecryptedSubContact
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedSubContact
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.embed.SubContact
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.base.ParticipantType
import kotlin.Deprecated

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Contact :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable,
	HasEndOfLife {
	override val id: String

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	public val identifier: List<Identifier>

	override val endOfLife: Long?

	override val deletionDate: Long?

	public val groupId: String?

	public val openingDate: Long?

	public val closingDate: Long?

	public val descr: String?

	public val location: String?

	public val encounterType: CodeStub?

	public val encounterLocation: Address?

	public val subContacts: Set<SubContact>

	public val services: Set<Service>

	public val participantList: List<ContactParticipant>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?

	public val notes: List<Annotation>
	// region Contact-Contact
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.Contact"
	}
	// endregion
}

@Serializable
data class DecryptedContact(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val groupId: String? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val descr: String? = null,
	override val location: String? = null,
	override val encounterType: CodeStub? = null,
	override val encounterLocation: DecryptedAddress? = null,
	@param:DefaultValue("emptySet()")
	override val subContacts: Set<DecryptedSubContact> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val services: Set<DecryptedService> = emptySet(),
	@param:DefaultValue("emptyList()")
	override val participantList: List<ContactParticipant> = emptyList(),
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
) : Contact {
	// region Contact-DecryptedContact
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedContact =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedContact(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val groupId: String? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val descr: String? = null,
	override val location: String? = null,
	override val encounterType: CodeStub? = null,
	override val encounterLocation: EncryptedAddress? = null,
	@param:DefaultValue("emptySet()")
	override val subContacts: Set<EncryptedSubContact> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val services: Set<EncryptedService> = emptySet(),
	@param:DefaultValue("emptyList()")
	override val participantList: List<ContactParticipant> = emptyList(),
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
) : Contact {
	// region Contact-EncryptedContact
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedContact =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
