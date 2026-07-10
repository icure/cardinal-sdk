// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
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
internal object CareTeamMembershipEncryptorFactory :
	EntityEncryptorFactory<EncryptedCareTeamMembership, DecryptedCareTeamMembership> {
	override val empty: EntityEncryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership> =
		object : EntityEncryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedCareTeamMembership,
			): EncryptedCareTeamMembership =
				EncryptedCareTeamMembership(
					startDate = clearEntity.startDate,
					endDate = clearEntity.endDate,
					careTeamMemberId = clearEntity.careTeamMemberId,
					membershipType = clearEntity.membershipType,
					encryptedSelf = null,
					extensions = clearEntity.extensions,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return CareTeamMembershipEncryptor(
			startDate_e = "startDate" in manifest.fieldsToEncrypt,
			endDate_e = "endDate" in manifest.fieldsToEncrypt,
			careTeamMemberId_e = "careTeamMemberId" in manifest.fieldsToEncrypt,
			membershipType_e = "membershipType" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class CareTeamMembershipEncryptor(
	private val startDate_e: Boolean,
	private val endDate_e: Boolean,
	private val careTeamMemberId_e: Boolean,
	private val membershipType_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCareTeamMembership,
	): EncryptedCareTeamMembership {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (startDate_e && clearEntity.startDate != null) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate_e && clearEntity.endDate != null) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		if (careTeamMemberId_e && clearEntity.careTeamMemberId != null) {
			dataToEncrypt["careTeamMemberId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.careTeamMemberId,
				)
		}
		if (membershipType_e && clearEntity.membershipType != null) {
			dataToEncrypt["membershipType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.membershipType,
				)
		}
		return EncryptedCareTeamMembership(
			startDate = if (startDate_e) null else clearEntity.startDate,
			endDate = if (endDate_e) null else clearEntity.endDate,
			careTeamMemberId = if (careTeamMemberId_e) null else clearEntity.careTeamMemberId,
			membershipType = if (membershipType_e) null else clearEntity.membershipType,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			extensions = clearEntity.extensions,
		)
	}
}
