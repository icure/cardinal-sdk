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

/**
 * This entity is a root-level object. It represents a contact. It is serialized in JSON and saved
 * in the underlying
 * icure-contact CouchDB database.
 *
 * A contact is an entry in the day-to-day journal of the medical file of a patient. A contact
 * happens between one
 * patient, one or several healthcare parties (with one healthcare party promoted as the responsible
 * of the contact),
 * at one place during one (fairly short) period of time.
 * A contact contains a series of services (acts, observations, exchanges) performed on the patient.
 * These services
 * can be linked to healthcare elements.
 *
 * A contact can occur with or without direct interaction between the patient and the healthcare
 * party. For example,
 * when a healthcare party encodes data received from laboratory's test result, this is done in the
 * absence of a patient.
 * /
 */
public sealed interface Contact :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable,
	HasEndOfLife {
	/**
	 * The Id of the contact. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the contact in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String?

	/**
	 * The timestamp (unix epoch in ms) of creation of the contact, will be filled automatically if
	 * missing. Not enforced by the application server.
	 */
	override val created: Long?

	/**
	 * The date (unix epoch in ms) of the latest modification of the contact, will be filled
	 * automatically if missing. Not enforced by the application server.
	 */
	override val modified: Long?

	/**
	 * The id of the User that has created this contact, will be filled automatically if missing. Not
	 * enforced by the application server.
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this contact, will be filled automatically
	 * if missing. Not enforced by the application server.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the contact as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular contact.
	 */
	override val codes: Set<CodeStub>

	/**
	 * The identifiers of the Contact.
	 */
	public val identifier: List<Identifier>

	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long?

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * Separate contacts can be merged in one logical contact if they share the same groupId. When a
	 * contact must be split to selectively assign rights to healthcare parties, the split contacts all
	 * share the same groupId.
	 */
	public val groupId: String?

	/**
	 * The date (YYYYMMDDhhmmss) of the start of the contact.
	 */
	public val openingDate: Long?

	/**
	 * The date (YYYYMMDDhhmmss) marking the end of the contact.
	 */
	public val closingDate: Long?

	/**
	 * Description of the contact.
	 */
	public val descr: String?

	/**
	 * Location where the contact was recorded.
	 */
	public val location: String?

	/**
	 * The type of encounter made for the contact.
	 */
	public val encounterType: CodeStub?

	/**
	 * The location where the encounter took place.
	 */
	public val encounterLocation: Address?

	/**
	 * Set of all sub-contacts recorded during the given contact. Sub-contacts are used to link
	 * services embedded inside this contact to healthcare elements, healthcare approaches and/or forms.
	 */
	public val subContacts: Set<SubContact>

	/**
	 * Set of all services provided to the patient during the contact.
	 */
	public val services: Set<Service>

	/**
	 * The list of participants to the contact, with their type and data owner id.
	 */
	public val participantList: List<ContactParticipant>

	/**
	 * The secret patient key, encrypted in the patient document, in clear here.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The public patient key, encrypted here for separate Crypto Actors.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The contact secret encryption key used to encrypt the secured properties (like services for
	 * example), encrypted for separate Crypto Actors.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The encrypted fields of this contact.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of this contact, tracking access control information.
	 */
	override val securityMetadata: SecurityMetadata?

	/**
	 * Comments and notes recorded by a healthcare party about this contact.
	 */
	public val notes: List<Annotation>
}

/**
 * This entity is a root-level object. It represents a contact. It is serialized in JSON and saved
 * in the underlying
 * icure-contact CouchDB database.
 *
 * A contact is an entry in the day-to-day journal of the medical file of a patient. A contact
 * happens between one
 * patient, one or several healthcare parties (with one healthcare party promoted as the responsible
 * of the contact),
 * at one place during one (fairly short) period of time.
 * A contact contains a series of services (acts, observations, exchanges) performed on the patient.
 * These services
 * can be linked to healthcare elements.
 *
 * A contact can occur with or without direct interaction between the patient and the healthcare
 * party. For example,
 * when a healthcare party encodes data received from laboratory's test result, this is done in the
 * absence of a patient.
 * /
 */
@Serializable
public data class DecryptedContact(
	/**
	 * The Id of the contact. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the contact in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of the contact, will be filled automatically if
	 * missing. Not enforced by the application server.
	 */
	override val created: Long? = null,
	/**
	 * The date (unix epoch in ms) of the latest modification of the contact, will be filled
	 * automatically if missing. Not enforced by the application server.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that has created this contact, will be filled automatically if missing. Not
	 * enforced by the application server.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this contact, will be filled automatically
	 * if missing. Not enforced by the application server.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the contact as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular contact.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * The identifiers of the Contact.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Separate contacts can be merged in one logical contact if they share the same groupId. When a
	 * contact must be split to selectively assign rights to healthcare parties, the split contacts all
	 * share the same groupId.
	 */
	override val groupId: String? = null,
	/**
	 * The date (YYYYMMDDhhmmss) of the start of the contact.
	 */
	override val openingDate: Long? = null,
	/**
	 * The date (YYYYMMDDhhmmss) marking the end of the contact.
	 */
	override val closingDate: Long? = null,
	/**
	 * Description of the contact.
	 */
	override val descr: String? = null,
	/**
	 * Location where the contact was recorded.
	 */
	override val location: String? = null,
	/**
	 * The type of encounter made for the contact.
	 */
	override val encounterType: CodeStub? = null,
	/**
	 * The location where the encounter took place.
	 */
	override val encounterLocation: DecryptedAddress? = null,
	/**
	 * Set of all sub-contacts recorded during the given contact. Sub-contacts are used to link
	 * services embedded inside this contact to healthcare elements, healthcare approaches and/or forms.
	 */
	@param:DefaultValue("emptySet()")
	override val subContacts: Set<DecryptedSubContact> = emptySet(),
	/**
	 * Set of all services provided to the patient during the contact.
	 */
	@param:DefaultValue("emptySet()")
	override val services: Set<DecryptedService> = emptySet(),
	/**
	 * The list of participants to the contact, with their type and data owner id.
	 */
	@param:DefaultValue("emptyList()")
	override val participantList: List<ContactParticipant> = emptyList(),
	/**
	 * The secret patient key, encrypted in the patient document, in clear here.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The public patient key, encrypted here for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The contact secret encryption key used to encrypt the secured properties (like services for
	 * example), encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encrypted fields of this contact.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this contact, tracking access control information.
	 */
	override val securityMetadata: SecurityMetadata? = null,
	/**
	 * Comments and notes recorded by a healthcare party about this contact.
	 */
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
) : Contact

/**
 * This entity is a root-level object. It represents a contact. It is serialized in JSON and saved
 * in the underlying
 * icure-contact CouchDB database.
 *
 * A contact is an entry in the day-to-day journal of the medical file of a patient. A contact
 * happens between one
 * patient, one or several healthcare parties (with one healthcare party promoted as the responsible
 * of the contact),
 * at one place during one (fairly short) period of time.
 * A contact contains a series of services (acts, observations, exchanges) performed on the patient.
 * These services
 * can be linked to healthcare elements.
 *
 * A contact can occur with or without direct interaction between the patient and the healthcare
 * party. For example,
 * when a healthcare party encodes data received from laboratory's test result, this is done in the
 * absence of a patient.
 * /
 */
@Serializable
public data class EncryptedContact(
	/**
	 * The Id of the contact. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the contact in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of the contact, will be filled automatically if
	 * missing. Not enforced by the application server.
	 */
	override val created: Long? = null,
	/**
	 * The date (unix epoch in ms) of the latest modification of the contact, will be filled
	 * automatically if missing. Not enforced by the application server.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that has created this contact, will be filled automatically if missing. Not
	 * enforced by the application server.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this contact, will be filled automatically
	 * if missing. Not enforced by the application server.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the contact as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular contact.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * The identifiers of the Contact.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Separate contacts can be merged in one logical contact if they share the same groupId. When a
	 * contact must be split to selectively assign rights to healthcare parties, the split contacts all
	 * share the same groupId.
	 */
	override val groupId: String? = null,
	/**
	 * The date (YYYYMMDDhhmmss) of the start of the contact.
	 */
	override val openingDate: Long? = null,
	/**
	 * The date (YYYYMMDDhhmmss) marking the end of the contact.
	 */
	override val closingDate: Long? = null,
	/**
	 * Description of the contact.
	 */
	override val descr: String? = null,
	/**
	 * Location where the contact was recorded.
	 */
	override val location: String? = null,
	/**
	 * The type of encounter made for the contact.
	 */
	override val encounterType: CodeStub? = null,
	/**
	 * The location where the encounter took place.
	 */
	override val encounterLocation: EncryptedAddress? = null,
	/**
	 * Set of all sub-contacts recorded during the given contact. Sub-contacts are used to link
	 * services embedded inside this contact to healthcare elements, healthcare approaches and/or forms.
	 */
	@param:DefaultValue("emptySet()")
	override val subContacts: Set<EncryptedSubContact> = emptySet(),
	/**
	 * Set of all services provided to the patient during the contact.
	 */
	@param:DefaultValue("emptySet()")
	override val services: Set<EncryptedService> = emptySet(),
	/**
	 * The list of participants to the contact, with their type and data owner id.
	 */
	@param:DefaultValue("emptyList()")
	override val participantList: List<ContactParticipant> = emptyList(),
	/**
	 * The secret patient key, encrypted in the patient document, in clear here.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The public patient key, encrypted here for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The contact secret encryption key used to encrypt the secured properties (like services for
	 * example), encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encrypted fields of this contact.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this contact, tracking access control information.
	 */
	override val securityMetadata: SecurityMetadata? = null,
	/**
	 * Comments and notes recorded by a healthcare party about this contact.
	 */
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
) : Contact
