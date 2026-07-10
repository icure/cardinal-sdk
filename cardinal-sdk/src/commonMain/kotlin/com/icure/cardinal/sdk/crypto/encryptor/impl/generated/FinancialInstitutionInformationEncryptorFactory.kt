// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
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
internal object FinancialInstitutionInformationEncryptorFactory :
	EntityEncryptorFactory<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> {
	override val empty:
		EntityEncryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> =
		object :
			EntityEncryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedFinancialInstitutionInformation,
			): EncryptedFinancialInstitutionInformation =
				EncryptedFinancialInstitutionInformation(
					name = clearEntity.name,
					key = clearEntity.key,
					bankAccount = clearEntity.bankAccount,
					bic = clearEntity.bic,
					proxyBankAccount = clearEntity.proxyBankAccount,
					proxyBic = clearEntity.proxyBic,
					preferredFiiForPartners = clearEntity.preferredFiiForPartners,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return FinancialInstitutionInformationEncryptor(
			name_e = "name" in manifest.fieldsToEncrypt,
			key_e = "key" in manifest.fieldsToEncrypt,
			bankAccount_e = "bankAccount" in manifest.fieldsToEncrypt,
			bic_e = "bic" in manifest.fieldsToEncrypt,
			proxyBankAccount_e = "proxyBankAccount" in manifest.fieldsToEncrypt,
			proxyBic_e = "proxyBic" in manifest.fieldsToEncrypt,
			preferredFiiForPartners_e = "preferredFiiForPartners" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class FinancialInstitutionInformationEncryptor(
	private val name_e: Boolean,
	private val key_e: Boolean,
	private val bankAccount_e: Boolean,
	private val bic_e: Boolean,
	private val proxyBankAccount_e: Boolean,
	private val proxyBic_e: Boolean,
	private val preferredFiiForPartners_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) :
	AbstractEntityEncryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedFinancialInstitutionInformation,
	): EncryptedFinancialInstitutionInformation {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (name_e && clearEntity.name != null) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (key_e && clearEntity.key != null) dataToEncrypt["key"] = encodingJson.encodeToJsonElement(clearEntity.key)
		if (bankAccount_e && clearEntity.bankAccount != null) {
			dataToEncrypt["bankAccount"] =
				encodingJson.encodeToJsonElement(
					clearEntity.bankAccount,
				)
		}
		if (bic_e && clearEntity.bic != null) dataToEncrypt["bic"] = encodingJson.encodeToJsonElement(clearEntity.bic)
		if (proxyBankAccount_e && clearEntity.proxyBankAccount != null) {
			dataToEncrypt["proxyBankAccount"] =
				encodingJson.encodeToJsonElement(
					clearEntity.proxyBankAccount,
				)
		}
		if (proxyBic_e && clearEntity.proxyBic != null) dataToEncrypt["proxyBic"] = encodingJson.encodeToJsonElement(clearEntity.proxyBic)
		if (preferredFiiForPartners_e && clearEntity.preferredFiiForPartners.isNotEmpty()) {
			dataToEncrypt["preferredFiiForPartners"] =
				encodingJson.encodeToJsonElement(
					clearEntity.preferredFiiForPartners,
				)
		}
		return EncryptedFinancialInstitutionInformation(
			name = if (name_e) null else clearEntity.name,
			key = if (key_e) null else clearEntity.key,
			bankAccount = if (bankAccount_e) null else clearEntity.bankAccount,
			bic = if (bic_e) null else clearEntity.bic,
			proxyBankAccount = if (proxyBankAccount_e) null else clearEntity.proxyBankAccount,
			proxyBic = if (proxyBic_e) null else clearEntity.proxyBic,
			preferredFiiForPartners = if (preferredFiiForPartners_e) emptySet() else clearEntity.preferredFiiForPartners,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}
