package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.DecryptedSubContact
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.EncryptedSubContact
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.embed.SubContact
import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Contact :
	StoredDocument,
	ICureDocument<T>,
	HasEncryptionMetadata,
	Encryptable {
	override val id: String

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

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

	public val externalId: String?

	public val encounterType: CodeStub?

	public val subContacts: Set<SubContact>

	public val services: Set<Service>

	public val healthcarePartyId: String?

	public val modifiedContactId: String?

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?

	public val notes: List<Annotation>
	// region Contact-Contact

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
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val identifier: List<Identifier> = emptyList(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val groupId: String? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val descr: String? = null,
	override val location: String? = null,
	override val externalId: String? = null,
	override val encounterType: CodeStub? = null,
	override val subContacts: Set<DecryptedSubContact> = emptySet(),
	override val services: Set<DecryptedService> = emptySet(),
	override val healthcarePartyId: String? = null,
	override val modifiedContactId: String? = null,
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
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
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val identifier: List<Identifier> = emptyList(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val groupId: String? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val descr: String? = null,
	override val location: String? = null,
	override val externalId: String? = null,
	override val encounterType: CodeStub? = null,
	override val subContacts: Set<EncryptedSubContact> = emptySet(),
	override val services: Set<EncryptedService> = emptySet(),
	override val healthcarePartyId: String? = null,
	override val modifiedContactId: String? = null,
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val notes: List<Annotation> = emptyList(),
) : Contact {
	// region Contact-EncryptedContact
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedContact =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
