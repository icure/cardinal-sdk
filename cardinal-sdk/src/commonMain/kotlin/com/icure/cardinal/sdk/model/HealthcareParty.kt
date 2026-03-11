// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.DataOwner
import com.icure.cardinal.sdk.model.base.HasCodes
import com.icure.cardinal.sdk.model.base.HasTags
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.Person
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.PersonName
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.HealthcarePartyHistoryStatus
import com.icure.cardinal.sdk.model.embed.HealthcarePartyStatus
import com.icure.cardinal.sdk.model.embed.TelecomType
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int

/**
 * Represents a healthcare party. A healthcare party is a person or organization that provides
 * healthcare services,
 * such as a physician, nurse, hospital, or medical practice. It is serialized in JSON and saved in
 * the underlying
 * icure-healthdata CouchDB database.
 * /
 */
@Serializable
data class HealthcareParty(
	/**
	 * The Id of the healthcare party. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the healthcare party in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * Creation timestamp (unix epoch in ms) of the object.
	 */
	public val created: Long? = null,
	/**
	 * Last modification timestamp (unix epoch in ms) of the object.
	 */
	public val modified: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The healthcare party's identifiers, used by the client to identify uniquely and unambiguously
	 * the HCP.
	 */
	@param:DefaultValue("emptyList()")
	public val identifier: List<Identifier> = emptyList(),
	/**
	 * Tags that qualify the healthcare party as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular healthcare party.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * The full name of the healthcare party, used mainly when the healthcare party is an organization.
	 *
	 */
	override val name: String? = null,
	/**
	 * The lastname (surname) of the healthcare party.
	 */
	override val lastName: String? = null,
	/**
	 * The firstname (name) of the healthcare party.
	 */
	override val firstName: String? = null,
	/**
	 * The list of all names of the healthcare party, ordered by preference of use.
	 */
	@param:DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	/**
	 * The gender of the healthcare party.
	 */
	override val gender: Gender? = null,
	/**
	 * Mr., Ms., Pr., Dr. ...
	 */
	override val civility: String? = null,
	/**
	 * The name of the company this healthcare party is member of.
	 */
	override val companyName: String? = null,
	/**
	 * Medical specialty of the healthcare party.
	 */
	public val speciality: String? = null,
	/**
	 * Bank Account identifier of the healthcare party (IBAN).
	 */
	public val bankAccount: String? = null,
	/**
	 * Bank Identifier Code (SWIFT Address) assigned to the bank.
	 */
	public val bic: String? = null,
	/**
	 * Proxy bank account number.
	 */
	public val proxyBankAccount: String? = null,
	/**
	 * Proxy bank identifier code.
	 */
	public val proxyBic: String? = null,
	/**
	 * All details included in the invoice header.
	 */
	public val invoiceHeader: String? = null,
	/**
	 * The id of the parent healthcare party.
	 */
	override val parentId: String? = null,
	/**
	 * Social security inscription number.
	 */
	public val ssin: String? = null,
	/**
	 * The list of addresses (with address type).
	 */
	@param:DefaultValue("emptyList()")
	override val addresses: List<DecryptedAddress> = emptyList(),
	/**
	 * The list of languages spoken by the healthcare party ordered by fluency (alpha-2 code).
	 */
	@param:DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	/**
	 * Medical specialty of the healthcare party codified using FHIR or Kmehr codification scheme.
	 */
	@param:DefaultValue("emptySet()")
	public val specialityCodes: Set<CodeStub> = emptySet(),
	/**
	 * Text notes.
	 */
	public val notes: String? = null,
	/**
	 * List of financial information (Bank, bank account).
	 */
	@param:DefaultValue("emptyList()")
	public val financialInstitutionInformation: List<DecryptedFinancialInstitutionInformation> =
		emptyList(),
	/**
	 * A description of the HCP, meant for the public and in multiple languages.
	 */
	@param:DefaultValue("emptyMap()")
	public val descr: Map<String, String> = emptyMap(),
	/**
	 * Extra properties for the healthcare party.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * Whether the healthcare party profile is publicly visible.
	 */
	@param:DefaultValue("false")
	public val `public`: Boolean = false,
	/**
	 * Properties that are publicly visible.
	 */
	public val publicProperties: Set<DecryptedPropertyStub>? = null,
	/**
	 * Properties related to crypto actor functionality.
	 */
	override val cryptoActorProperties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * For each couple of HcParties (delegate and owner), this map contains the AES exchange key.
	 */
	@param:DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	/**
	 * Extra AES exchange keys, indexed by the owner of the pair and target data owner id.
	 */
	@param:DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	/**
	 * Keys used to transfer ownership of encrypted data between key pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	/**
	 * Shamir partitions of the private key.
	 */
	@param:DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	/**
	 * The public key of this HCP, used to encrypt data for this HCP.
	 */
	override val publicKey: SpkiHexString? = null,
	/**
	 * Public keys for OAEP with SHA-256 encryption.
	 */
	@param:DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
) : StoredDocument, Named, Person, CryptoActor, DataOwner, HasCodes, HasTags {
	// region HealthcareParty-HealthcareParty
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.HealthcareParty"
	}
	// endregion
}
