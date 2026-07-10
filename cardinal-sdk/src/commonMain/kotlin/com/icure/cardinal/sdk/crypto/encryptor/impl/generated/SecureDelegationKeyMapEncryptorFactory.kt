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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object SecureDelegationKeyMapEncryptorFactory :
	EntityEncryptorFactory<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap> {
	override val empty:
		EntityEncryptor<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap> =
		object :
			EntityEncryptor<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedSecureDelegationKeyMap,
			): EncryptedSecureDelegationKeyMap =
				EncryptedSecureDelegationKeyMap(
					id = clearEntity.id,
					rev = clearEntity.rev,
					delegationKey = clearEntity.delegationKey,
					delegator = clearEntity.delegator,
					delegate = clearEntity.delegate,
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
					deletionDate = clearEntity.deletionDate,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return SecureDelegationKeyMapEncryptor(
			delegator_e = "delegator" in manifest.fieldsToEncrypt,
			delegate_e = "delegate" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class SecureDelegationKeyMapEncryptor(
	private val delegator_e: Boolean,
	private val delegate_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) :
	AbstractEntityEncryptor<EncryptedSecureDelegationKeyMap, DecryptedSecureDelegationKeyMap>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedSecureDelegationKeyMap,
	): EncryptedSecureDelegationKeyMap {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (delegator_e && clearEntity.delegator != null) dataToEncrypt["delegator"] = encodingJson.encodeToJsonElement(clearEntity.delegator)
		if (delegate_e && clearEntity.delegate != null) dataToEncrypt["delegate"] = encodingJson.encodeToJsonElement(clearEntity.delegate)
		return EncryptedSecureDelegationKeyMap(
			id = clearEntity.id,
			rev = clearEntity.rev,
			delegationKey = clearEntity.delegationKey,
			delegator = if (delegator_e) null else clearEntity.delegator,
			delegate = if (delegate_e) null else clearEntity.delegate,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
			deletionDate = clearEntity.deletionDate,
		)
	}
}
