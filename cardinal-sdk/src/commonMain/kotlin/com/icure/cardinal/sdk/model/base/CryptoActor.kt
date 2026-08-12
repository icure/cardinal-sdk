// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 *
 *  Interface for entities that participate in the iCure end-to-end encryption system.
 *  A CryptoActor holds the cryptographic keys and key exchange material needed for secure data
 * sharing.
 */

interface CryptoActor : Versionable<String> {
	public val hcPartyKeys: Map<String, List<HexString>>

	public val aesExchangeKeys:
		Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>

	public val transferKeys:
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>

	public val privateKeyShamirPartitions: Map<String, HexString>

	public val publicKey: SpkiHexString?

	public val publicKeysForOaepWithSha256: Set<SpkiHexString>

	public val parentId: String?

	public val cryptoActorProperties: Set<DecryptedPropertyStub>?
	// region CryptoActor-CryptoActor

	// endregion
}
