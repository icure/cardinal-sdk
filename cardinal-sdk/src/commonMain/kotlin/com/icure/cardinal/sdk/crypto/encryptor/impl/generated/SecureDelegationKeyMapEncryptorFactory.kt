// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object SecureDelegationKeyMapEncryptorFactory :
	EntityEncryptorFactory<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap> {
	override val empty:
		EntityEncryptor<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap> =
		SecureDelegationKeyMapEncryptor(
			delegator = false,
			delegate = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return SecureDelegationKeyMapEncryptor(
			delegator = "delegator" in manifest.fieldsToEncrypt,
			delegate = "delegate" in manifest.fieldsToEncrypt,
		)
	}
}

private class SecureDelegationKeyMapEncryptor(
	private val delegator: Boolean,
	private val `delegate`: Boolean,
) : AbstractEntityEncryptor<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedSecureDelegationKeyMap,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedSecureDelegationKeyMap {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (delegator) dataToEncrypt["delegator"] = encodingJson.encodeToJsonElement(clearEntity.delegator)
		if (delegate) dataToEncrypt["delegate"] = encodingJson.encodeToJsonElement(clearEntity.delegate)
		return EncryptedSecureDelegationKeyMap(
			id = clearEntity.id,
			rev = clearEntity.rev,
			delegationKey = clearEntity.delegationKey,
			delegator = if (delegator) null else clearEntity.delegator,
			delegate = if (delegate) null else clearEntity.delegate,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
			deletionDate = clearEntity.deletionDate,
		)
	}
}
