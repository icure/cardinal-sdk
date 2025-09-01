package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.Versionable
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class CryptoActorStub(
	override val id: String,
	override val rev: String,
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
	override val publicKeysForOaepWithSha256: Set<SpkiHexString>,
	override val parentId: String? = null,
	override val cryptoActorProperties: Set<DecryptedPropertyStub>? = null,
) : Versionable<String>, CryptoActor
