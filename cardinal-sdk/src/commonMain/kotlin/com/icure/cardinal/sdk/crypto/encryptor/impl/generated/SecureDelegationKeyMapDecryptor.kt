// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object SecureDelegationKeyMapDecryptor :
	AbstractEntityDecryptor<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedSecureDelegationKeyMap,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedSecureDelegationKeyMap {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedSecureDelegationKeyMap(
				id = encryptedEntity.id,
				rev = encryptedEntity.rev,
				delegationKey = encryptedEntity.delegationKey,
				delegator =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["delegator"]?.also { usedEncryptedContent += "delegator" },
						encryptedEntity.delegator,
						decryptedJsonStrictness,
					),
				delegate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["delegate"]?.also { usedEncryptedContent += "delegate" },
						encryptedEntity.delegate,
						decryptedJsonStrictness,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				deletionDate = encryptedEntity.deletionDate,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The SecureDelegationKeyMap encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
