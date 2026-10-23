// This file is auto-generated
@file:Suppress("ktlint:standard:max-line-length")

package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.CustomEntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractCustomEntityBaseEncryptor
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress

@InternalIcureApi
internal object CustomEntityBaseEncryptorFactory {
	public fun create(
		customEntityTypeId: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedCustomEntityBase, DecryptedCustomEntityBase> {
		val manifest = encryptorsFactoryContext.getCustomEntityManifest(customEntityTypeId)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedCustomEntityBase::class,
					decryptedClass = DecryptedCustomEntityBase::class,
				)
			}
		return CustomEntityBaseEncryptor(
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
			manifest = manifest,
			customEntityTypeId = customEntityTypeId,
		)
	}
}

@InternalIcureApi
private class CustomEntityBaseEncryptor(
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
	manifest: CustomEntityEncryptionManifest,
	customEntityTypeId: String,
) : AbstractCustomEntityBaseEncryptor(manifest, customEntityTypeId, cryptoService) {
	override suspend fun encryptValidated(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCustomEntityBase,
	): EncryptedCustomEntityBase =
		EncryptedCustomEntityBase(
			id = clearEntity.id,
			rev = clearEntity.rev,
			deletionDate = clearEntity.deletionDate,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			securityMetadata = clearEntity.securityMetadata,
			created = clearEntity.created,
			modified = clearEntity.modified,
			author = clearEntity.author,
			responsible = clearEntity.responsible,
			endOfLife = clearEntity.endOfLife,
			tags = clearEntity.tags,
			codes = clearEntity.codes,
			customisedModelVersion = clearEntity.customisedModelVersion,
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
			dataAttachments = clearEntity.dataAttachments,
			deletedAttachments = clearEntity.deletedAttachments,
			encryptedSelf = null,
		)
}
