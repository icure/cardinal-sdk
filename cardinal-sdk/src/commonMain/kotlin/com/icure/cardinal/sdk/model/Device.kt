package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.DataOwner
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class Device(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	@param:DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val name: String? = null,
	public val type: String? = null,
	public val brand: String? = null,
	public val model: String? = null,
	public val serialNumber: String? = null,
	override val parentId: String? = null,
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
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
	override val cryptoActorProperties: Set<DecryptedPropertyStub>? = null,
) : StoredDocument, ICureDocument<String>, Named, CryptoActor, DataOwner
