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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object CareTeamMembershipEncryptorFactory :
	EntityEncryptorFactory<EncryptedCareTeamMembership, DecryptedCareTeamMembership> {
	override val empty: EntityEncryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership> =
		CareTeamMembershipEncryptor(
			startDate = false,
			endDate = false,
			careTeamMemberId = false,
			membershipType = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return CareTeamMembershipEncryptor(
			startDate = "startDate" in manifest.fieldsToEncrypt,
			endDate = "endDate" in manifest.fieldsToEncrypt,
			careTeamMemberId = "careTeamMemberId" in manifest.fieldsToEncrypt,
			membershipType = "membershipType" in manifest.fieldsToEncrypt,
		)
	}
}

private class CareTeamMembershipEncryptor(
	private val startDate: Boolean,
	private val endDate: Boolean,
	private val careTeamMemberId: Boolean,
	private val membershipType: Boolean,
) : AbstractEntityEncryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCareTeamMembership,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedCareTeamMembership {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (startDate) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		if (careTeamMemberId) dataToEncrypt["careTeamMemberId"] = encodingJson.encodeToJsonElement(clearEntity.careTeamMemberId)
		if (membershipType) dataToEncrypt["membershipType"] = encodingJson.encodeToJsonElement(clearEntity.membershipType)
		return EncryptedCareTeamMembership(
			startDate = if (startDate) null else clearEntity.startDate,
			endDate = if (endDate) null else clearEntity.endDate,
			careTeamMemberId = if (careTeamMemberId) null else clearEntity.careTeamMemberId,
			membershipType = if (membershipType) null else clearEntity.membershipType,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}
