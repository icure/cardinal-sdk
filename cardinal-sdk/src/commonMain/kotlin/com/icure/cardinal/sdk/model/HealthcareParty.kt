// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.CustomisableRoot
import com.icure.cardinal.sdk.model.base.DataOwner
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLink
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.base.Extendable
import com.icure.cardinal.sdk.model.base.HasCodes
import com.icure.cardinal.sdk.model.base.HasIdentifier
import com.icure.cardinal.sdk.model.base.HasTags
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.Person
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.HealthcarePartyHistoryStatus
import com.icure.cardinal.sdk.model.embed.HealthcarePartyStatus
import com.icure.cardinal.sdk.model.embed.PersonName
import com.icure.cardinal.sdk.model.embed.TelecomType
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a healthcare party. A healthcare party is a person or organization that provides healthcare services,
 * such as a physician, nurse, hospital, or medical practice. It is serialized in JSON and saved in the underlying
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
	 * The revision of the healthcare party in the database, used for conflict management / optimistic locking.
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
	 * The healthcare party's identifiers, used by the client to identify uniquely and unambiguously the HCP.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
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
	 * Identifier number for institution type if the healthcare party is an enterprise.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val cbe: String? = null,
	/**
	 * Identifier number for the institution if the healthcare party is an organization.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val ehp: String? = null,
	/**
	 * The id of the user that usually handles this healthcare party.
	 */
	@Deprecated("Discouraged, use custom property if you really want them")
	public val userId: String? = null,
	/**
	 * The id of the parent healthcare party.
	 */
	@Deprecated("Use dataOwnerGroups with a DataOwnerGroupLinkTypeDto.parent link instead")
	override val parentId: String? = null,
	/**
	 * The links to the data owners representing the groups this healthcare party belongs to.
	 */
	@param:DefaultValue("emptyList()")
	override val dataOwnerGroups: List<DataOwnerGroupLink> = emptyList(),
	override val groupLinkType: DataOwnerGroupLinkType? = null,
	/**
	 * The convention number (0, 1, 2, or 9).
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val convention: Int? = null,
	/**
	 * National Institute for Health and Invalidity Insurance number.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val nihii: String? = null,
	/**
	 * NIHII specialization code.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val nihiiSpecCode: String? = null,
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
	 * A picture usually saved in JPEG format.
	 */
	@Serializable(with = ByteArraySerializer::class)
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val picture: ByteArray? = null,
	/**
	 * The healthcare party's status: 'trainee' or 'withconvention' or 'accredited'.
	 */
	@param:DefaultValue("emptySet()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val statuses: Set<HealthcarePartyStatus> = emptySet(),
	/**
	 * The healthcare party's status history.
	 */
	@param:DefaultValue("emptyList()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val statusHistory: List<HealthcarePartyHistoryStatus> = emptyList(),
	/**
	 * Medical specialty of the healthcare party codified using FHIR or Kmehr codification scheme.
	 */
	@param:DefaultValue("emptySet()")
	public val specialityCodes: Set<CodeStub> = emptySet(),
	/**
	 * The type of format for contacting the healthcare party.
	 */
	@param:DefaultValue("emptyMap()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val sendFormats: Map<TelecomType, String> = emptyMap(),
	/**
	 * Text notes.
	 */
	public val notes: String? = null,
	/**
	 * List of financial information (Bank, bank account).
	 */
	@param:DefaultValue("emptyList()")
	public val financialInstitutionInformation: List<DecryptedFinancialInstitutionInformation> = emptyList(),
	/**
	 * A description of the HCP, meant for the public and in multiple languages.
	 */
	@param:DefaultValue("emptyMap()")
	public val descr: Map<String, String> = emptyMap(),
	/**
	 * The invoicing scheme this healthcare party adheres to: 'service fee' or 'flat rate'.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val billingType: String? = null,
	/**
	 * The type of healthcare party (e.g., 'persphysician', 'medicalHouse', 'perstechnician').
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val type: String? = null,
	/**
	 * Contact person name.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val contactPerson: String? = null,
	/**
	 * Contact person healthcare party id.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val contactPersonHcpId: String? = null,
	/**
	 * The id of the supervisor.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val supervisorId: String? = null,
	/**
	 * List of flat rate tarifications for medical houses.
	 */
	@param:DefaultValue("emptyList()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val flatRateTarifications: List<DecryptedFlatRateTarification> = emptyList(),
	/**
	 * Imported data map.
	 */
	@param:DefaultValue("emptyMap()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val importedData: Map<String, String> = emptyMap(),
	/**
	 * Additional options (deprecated, use properties instead).
	 */
	@param:DefaultValue("emptyMap()")
	@Deprecated("Use properties instead")
	public val options: Map<String, String> = emptyMap(),
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
	override val aesExchangeKeys:
		Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> = emptyMap(),
	/**
	 * Keys used to transfer ownership of encrypted data between key pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val transferKeys:
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> = emptyMap(),
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
	override val extensions: JsonObject? = null,
	override val customisedModelVersion: Int? = null,
) : StoredDocument,
	Named,
	Person,
	CryptoActor,
	DataOwner,
	HasCodes,
	HasTags,
	HasIdentifier,
	CustomisableRoot,
	Extendable {
	// region HealthcareParty-HealthcareParty
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.HealthcareParty"
	}
	// endregion
}
