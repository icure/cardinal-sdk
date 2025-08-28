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
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class HealthcareParty(
	override val id: String,
	override val rev: String? = null,
	public val created: Long? = null,
	public val modified: Long? = null,
	override val deletionDate: Long? = null,
	@DefaultValue("emptyList()")
	public val identifier: List<Identifier> = emptyList(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val name: String? = null,
	override val lastName: String? = null,
	override val firstName: String? = null,
	@DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	override val gender: Gender? = null,
	override val civility: String? = null,
	override val companyName: String? = null,
	public val speciality: String? = null,
	public val bankAccount: String? = null,
	public val bic: String? = null,
	public val proxyBankAccount: String? = null,
	public val proxyBic: String? = null,
	public val invoiceHeader: String? = null,
	public val cbe: String? = null,
	public val ehp: String? = null,
	public val userId: String? = null,
	override val parentId: String? = null,
	public val convention: Int? = null,
	public val nihii: String? = null,
	public val nihiiSpecCode: String? = null,
	public val ssin: String? = null,
	@DefaultValue("emptyList()")
	override val addresses: List<DecryptedAddress> = emptyList(),
	@DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	@Serializable(with = ByteArraySerializer::class)
	public val picture: ByteArray? = null,
	@DefaultValue("emptySet()")
	public val statuses: Set<HealthcarePartyStatus> = emptySet(),
	@DefaultValue("emptyList()")
	public val statusHistory: List<HealthcarePartyHistoryStatus> = emptyList(),
	@DefaultValue("emptySet()")
	public val specialityCodes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptyMap()")
	public val sendFormats: Map<TelecomType, String> = emptyMap(),
	public val notes: String? = null,
	@DefaultValue("emptyList()")
	public val financialInstitutionInformation: List<DecryptedFinancialInstitutionInformation> =
		emptyList(),
	public val descr: Map<String, String>? = null,
	public val billingType: String? = null,
	public val type: String? = null,
	public val contactPerson: String? = null,
	public val contactPersonHcpId: String? = null,
	public val supervisorId: String? = null,
	@DefaultValue("emptyList()")
	public val flatRateTarifications: List<DecryptedFlatRateTarification> = emptyList(),
	@DefaultValue("emptyMap()")
	public val importedData: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	@Deprecated("Use properties instead")
	public val options: Map<String, String> = emptyMap(),
	@DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	@DefaultValue("false")
	public val `public`: Boolean = false,
	override val cryptoActorProperties: Set<DecryptedPropertyStub>? = null,
	@DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	@DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	@DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	override val publicKey: SpkiHexString? = null,
	@DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
) : StoredDocument, Named, Person, CryptoActor, DataOwner, HasCodes, HasTags {
	// region HealthcareParty-HealthcareParty
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.HealthcareParty"
	}
	// endregion
}
