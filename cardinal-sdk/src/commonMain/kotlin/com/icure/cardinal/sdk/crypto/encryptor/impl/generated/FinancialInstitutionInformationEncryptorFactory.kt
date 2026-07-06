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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object FinancialInstitutionInformationEncryptorFactory :
	EntityEncryptorFactory<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> {
	override val empty:
		EntityEncryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> =
		FinancialInstitutionInformationEncryptor(
			name = false,
			key = false,
			bankAccount = false,
			bic = false,
			proxyBankAccount = false,
			proxyBic = false,
			preferredFiiForPartners = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return FinancialInstitutionInformationEncryptor(
			name = "name" in manifest.fieldsToEncrypt,
			key = "key" in manifest.fieldsToEncrypt,
			bankAccount = "bankAccount" in manifest.fieldsToEncrypt,
			bic = "bic" in manifest.fieldsToEncrypt,
			proxyBankAccount = "proxyBankAccount" in manifest.fieldsToEncrypt,
			proxyBic = "proxyBic" in manifest.fieldsToEncrypt,
			preferredFiiForPartners = "preferredFiiForPartners" in manifest.fieldsToEncrypt,
		)
	}
}

private class FinancialInstitutionInformationEncryptor(
	private val name: Boolean,
	private val key: Boolean,
	private val bankAccount: Boolean,
	private val bic: Boolean,
	private val proxyBankAccount: Boolean,
	private val proxyBic: Boolean,
	private val preferredFiiForPartners: Boolean,
) :
	AbstractEntityEncryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedFinancialInstitutionInformation,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedFinancialInstitutionInformation {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (name) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (key) dataToEncrypt["key"] = encodingJson.encodeToJsonElement(clearEntity.key)
		if (bankAccount) dataToEncrypt["bankAccount"] = encodingJson.encodeToJsonElement(clearEntity.bankAccount)
		if (bic) dataToEncrypt["bic"] = encodingJson.encodeToJsonElement(clearEntity.bic)
		if (proxyBankAccount) dataToEncrypt["proxyBankAccount"] = encodingJson.encodeToJsonElement(clearEntity.proxyBankAccount)
		if (proxyBic) dataToEncrypt["proxyBic"] = encodingJson.encodeToJsonElement(clearEntity.proxyBic)
		if (preferredFiiForPartners) {
			dataToEncrypt["preferredFiiForPartners"] =
				encodingJson.encodeToJsonElement(
					clearEntity.preferredFiiForPartners,
				)
		}
		return EncryptedFinancialInstitutionInformation(
			name = if (name) null else clearEntity.name,
			key = if (key) null else clearEntity.key,
			bankAccount = if (bankAccount) null else clearEntity.bankAccount,
			bic = if (bic) null else clearEntity.bic,
			proxyBankAccount = if (proxyBankAccount) null else clearEntity.proxyBankAccount,
			proxyBic = if (proxyBic) null else clearEntity.proxyBic,
			preferredFiiForPartners = if (preferredFiiForPartners) emptySet() else clearEntity.preferredFiiForPartners,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}
