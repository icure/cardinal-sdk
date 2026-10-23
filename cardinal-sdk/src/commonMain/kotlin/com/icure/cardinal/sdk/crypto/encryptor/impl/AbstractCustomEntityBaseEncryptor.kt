package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.CustomEntityEncryptionManifest
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi

/**
 * Validation of custom entities before encryption; the actual encryption is implemented by the generated
 * CustomEntityBaseEncryptor in [encryptValidated].
 */
@InternalIcureApi
internal abstract class AbstractCustomEntityBaseEncryptor(
	manifest: CustomEntityEncryptionManifest,
	private val customEntityTypeId: String,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedCustomEntityBase, DecryptedCustomEntityBase>(cryptoService) {
	private val currentVersion: Int = manifest.currentVersion

	final override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCustomEntityBase,
	): EncryptedCustomEntityBase {
		// The extensions are always encrypted using the extensions manifest of the current version: entities at older
		// versions would be decrypted using a different manifest than the one used for encryption.
		require(clearEntity.customisedModelVersion == currentVersion) {
			"Can't encrypt custom entity of type $customEntityTypeId with version ${clearEntity.customisedModelVersion}: only entities at the current version $currentVersion can be encrypted, the entity must be migrated first"
		}
		return encryptValidated(encryptionKey, clearEntity)
	}

	protected abstract suspend fun encryptValidated(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCustomEntityBase,
	): EncryptedCustomEntityBase
}
