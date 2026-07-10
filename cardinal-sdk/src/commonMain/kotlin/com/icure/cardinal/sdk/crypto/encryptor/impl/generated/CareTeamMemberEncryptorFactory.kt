// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
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
internal object CareTeamMemberEncryptorFactory :
	EntityEncryptorFactory<EncryptedCareTeamMember, DecryptedCareTeamMember> {
	override val empty: EntityEncryptor<EncryptedCareTeamMember, DecryptedCareTeamMember> =
		object :
			EntityEncryptor<EncryptedCareTeamMember, DecryptedCareTeamMember> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedCareTeamMember,
			): EncryptedCareTeamMember =
				EncryptedCareTeamMember(
					id = clearEntity.id,
					careTeamMemberType = clearEntity.careTeamMemberType,
					healthcarePartyId = clearEntity.healthcarePartyId,
					quality = clearEntity.quality,
					encryptedSelf = null,
					extensions = clearEntity.extensions,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedCareTeamMember, DecryptedCareTeamMember> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return CareTeamMemberEncryptor(
			careTeamMemberType_e = "careTeamMemberType" in manifest.fieldsToEncrypt,
			healthcarePartyId_e = "healthcarePartyId" in manifest.fieldsToEncrypt,
			quality_e = "quality" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class CareTeamMemberEncryptor(
	private val careTeamMemberType_e: Boolean,
	private val healthcarePartyId_e: Boolean,
	private val quality_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedCareTeamMember, DecryptedCareTeamMember>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCareTeamMember,
	): EncryptedCareTeamMember {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (careTeamMemberType_e && clearEntity.careTeamMemberType != null) {
			dataToEncrypt["careTeamMemberType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.careTeamMemberType,
				)
		}
		if (healthcarePartyId_e && clearEntity.healthcarePartyId != null) {
			dataToEncrypt["healthcarePartyId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.healthcarePartyId,
				)
		}
		if (quality_e && clearEntity.quality != null) dataToEncrypt["quality"] = encodingJson.encodeToJsonElement(clearEntity.quality)
		return EncryptedCareTeamMember(
			id = clearEntity.id,
			careTeamMemberType = if (careTeamMemberType_e) null else clearEntity.careTeamMemberType,
			healthcarePartyId = if (healthcarePartyId_e) null else clearEntity.healthcarePartyId,
			quality = if (quality_e) null else clearEntity.quality,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			extensions = clearEntity.extensions,
		)
	}
}
