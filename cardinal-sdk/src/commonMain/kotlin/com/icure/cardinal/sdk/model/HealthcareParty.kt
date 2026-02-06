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

@Serializable
public data class HealthcareParty(
	override val id: String,
	override val rev: String? = null,
	public val created: Long? = null,
	public val modified: Long? = null,
	override val deletionDate: Long? = null,
	@param:DefaultValue("emptyList()")
	public val identifier: List<Identifier> = emptyList(),
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val name: String? = null,
	override val lastName: String? = null,
	override val firstName: String? = null,
	@param:DefaultValue("emptyList()")
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
	override val parentId: String? = null,
	public val ssin: String? = null,
	@param:DefaultValue("emptyList()")
	override val addresses: List<DecryptedAddress> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	@param:DefaultValue("emptySet()")
	public val specialityCodes: Set<CodeStub> = emptySet(),
	public val notes: String? = null,
	@param:DefaultValue("emptyList()")
	public val financialInstitutionInformation: List<DecryptedFinancialInstitutionInformation> =
		emptyList(),
	@param:DefaultValue("emptyMap()")
	public val descr: Map<String, String> = emptyMap(),
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	@param:DefaultValue("false")
	public val `public`: Boolean = false,
	public val publicProperties: Set<DecryptedPropertyStub>? = null,
	override val cryptoActorProperties: Set<DecryptedPropertyStub> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	override val publicKey: SpkiHexString? = null,
	@param:DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
) : StoredDocument, Named, Person, CryptoActor, DataOwner, HasCodes, HasTags
