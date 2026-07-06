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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object CareTeamMemberEncryptorFactory :
	EntityEncryptorFactory<EncryptedCareTeamMember, DecryptedCareTeamMember> {
	override val empty: EntityEncryptor<EncryptedCareTeamMember, DecryptedCareTeamMember> =
		CareTeamMemberEncryptor(
			careTeamMemberType = false,
			healthcarePartyId = false,
			quality = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedCareTeamMember, DecryptedCareTeamMember> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return CareTeamMemberEncryptor(
			careTeamMemberType = "careTeamMemberType" in manifest.fieldsToEncrypt,
			healthcarePartyId = "healthcarePartyId" in manifest.fieldsToEncrypt,
			quality = "quality" in manifest.fieldsToEncrypt,
		)
	}
}

private class CareTeamMemberEncryptor(
	private val careTeamMemberType: Boolean,
	private val healthcarePartyId: Boolean,
	private val quality: Boolean,
) : AbstractEntityEncryptor<EncryptedCareTeamMember, DecryptedCareTeamMember>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCareTeamMember,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedCareTeamMember {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (careTeamMemberType) dataToEncrypt["careTeamMemberType"] = encodingJson.encodeToJsonElement(clearEntity.careTeamMemberType)
		if (healthcarePartyId) dataToEncrypt["healthcarePartyId"] = encodingJson.encodeToJsonElement(clearEntity.healthcarePartyId)
		if (quality) dataToEncrypt["quality"] = encodingJson.encodeToJsonElement(clearEntity.quality)
		return EncryptedCareTeamMember(
			id = clearEntity.id,
			careTeamMemberType = if (careTeamMemberType) null else clearEntity.careTeamMemberType,
			healthcarePartyId = if (healthcarePartyId) null else clearEntity.healthcarePartyId,
			quality = if (quality) null else clearEntity.quality,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}
