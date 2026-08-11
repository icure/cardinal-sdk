// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.HasIdentifier
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.Person
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.PersonName
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 *
 *  A person related to one or more patients, that is neither a patient nor a healthcare party:
 * typically a contact
 *  person (parent of a child patient, caregiver, ...), referenced from a patient's partnership with
 *  partnerType = relatedPerson. It is a standalone encryptable entity but NOT a crypto actor nor a
 * data owner.
 */

sealed interface RelatedPerson :
	StoredDocument,
	ICureDocument<String>,
	Person,
	HasEncryptionMetadata,
	Encryptable,
	HasIdentifier,
	HasEndOfLife {
	/**
	 * The Id of the related person. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the related person in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String?

	/**
	 * The identifiers of the related person.
	 */
	override val identifier: List<Identifier>

	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long?

	/**
	 * The id of the User that created this related person.
	 */
	override val author: String?

	/**
	 * The id of the data owner that is responsible for this related person.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the related person as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular related person.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long?

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * The firstname (name) of the related person.
	 */
	override val firstName: String?

	/**
	 * The lastname (surname) of the related person.
	 */
	override val lastName: String?

	/**
	 * The list of all names of the related person, also containing the official full name information.
	 *
	 */
	override val names: List<PersonName>

	/**
	 * The name of the company this related person is member of.
	 */
	override val companyName: String?

	/**
	 * The list of languages spoken by the related person, in ISO 639-2 alpha-2 code.
	 */
	override val languages: List<String>

	/**
	 * The addresses and telecoms of the related person.
	 */
	override val addresses: List<Address>

	/**
	 * Mr., Ms., Pr., Dr. ...
	 */
	override val civility: String?

	/**
	 * The gender of the related person.
	 */
	override val gender: Gender?

	/**
	 * Extra properties of the related person.
	 */
	public val properties: Set<PropertyStub>

	/**
	 * The secret foreign keys of this entity.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The foreign keys encrypted in the delegates' AES keys.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to this related person.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The keys used to encrypt this entity when the entity is stored encrypted.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata?

	// region RelatedPerson-RelatedPerson

	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.RelatedPerson"
	}

	// endregion
}

/**
 *
 *  A person related to one or more patients, that is neither a patient nor a healthcare party:
 * typically a contact
 *  person (parent of a child patient, caregiver, ...), referenced from a patient's partnership with
 *  partnerType = relatedPerson. It is a standalone encryptable entity but NOT a crypto actor nor a
 * data owner.
 */
@Serializable
data class DecryptedRelatedPerson(
	/**
	 * The Id of the related person. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the related person in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The identifiers of the related person.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this related person.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this related person.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the related person as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular related person.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The firstname (name) of the related person.
	 */
	override val firstName: String? = null,
	/**
	 * The lastname (surname) of the related person.
	 */
	override val lastName: String? = null,
	/**
	 * The list of all names of the related person, also containing the official full name information.
	 *
	 */
	@param:DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	/**
	 * The name of the company this related person is member of.
	 */
	override val companyName: String? = null,
	/**
	 * The list of languages spoken by the related person, in ISO 639-2 alpha-2 code.
	 */
	@param:DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	/**
	 * The addresses and telecoms of the related person.
	 */
	@param:DefaultValue("emptyList()")
	override val addresses: List<DecryptedAddress> = emptyList(),
	/**
	 * Mr., Ms., Pr., Dr. ...
	 */
	override val civility: String? = null,
	/**
	 * The gender of the related person.
	 */
	override val gender: Gender? = null,
	/**
	 * Extra properties of the related person.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * The secret foreign keys of this entity.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The foreign keys encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to this related person.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when the entity is stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : RelatedPerson {
	// region RelatedPerson-DecryptedRelatedPerson
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedRelatedPerson =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

/**
 *
 *  A person related to one or more patients, that is neither a patient nor a healthcare party:
 * typically a contact
 *  person (parent of a child patient, caregiver, ...), referenced from a patient's partnership with
 *  partnerType = relatedPerson. It is a standalone encryptable entity but NOT a crypto actor nor a
 * data owner.
 */
@Serializable
data class EncryptedRelatedPerson(
	/**
	 * The Id of the related person. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the related person in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The identifiers of the related person.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this related person.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this related person.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the related person as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular related person.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The firstname (name) of the related person.
	 */
	override val firstName: String? = null,
	/**
	 * The lastname (surname) of the related person.
	 */
	override val lastName: String? = null,
	/**
	 * The list of all names of the related person, also containing the official full name information.
	 *
	 */
	@param:DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	/**
	 * The name of the company this related person is member of.
	 */
	override val companyName: String? = null,
	/**
	 * The list of languages spoken by the related person, in ISO 639-2 alpha-2 code.
	 */
	@param:DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	/**
	 * The addresses and telecoms of the related person.
	 */
	@param:DefaultValue("emptyList()")
	override val addresses: List<EncryptedAddress> = emptyList(),
	/**
	 * Mr., Ms., Pr., Dr. ...
	 */
	override val civility: String? = null,
	/**
	 * The gender of the related person.
	 */
	override val gender: Gender? = null,
	/**
	 * Extra properties of the related person.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<EncryptedPropertyStub> = emptySet(),
	/**
	 * The secret foreign keys of this entity.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The foreign keys encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to this related person.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when the entity is stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : RelatedPerson {
	// region RelatedPerson-EncryptedRelatedPerson
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedRelatedPerson =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
