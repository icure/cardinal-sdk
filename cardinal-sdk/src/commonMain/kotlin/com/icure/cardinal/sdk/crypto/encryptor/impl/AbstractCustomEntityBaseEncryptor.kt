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
	// The extensions are always encrypted using the current extensions manifest: an entity can be encrypted only if
	// the extensions manifest of its version is the current one, otherwise it would be decrypted using a different
	// manifest than the one used for encryption.
	private val encryptableModelVersions: Set<Int> =
		manifest.extensionsManifestsByModelVersion.filterValues { it == manifest.currentExtensionsManifest }.keys

	final override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCustomEntityBase,
	): EncryptedCustomEntityBase {
		val customisedModelVersion = clearEntity.customisedModelVersion
		require(customisedModelVersion != null) {
			"Fully custom entity should always have a model version"
		}
		require(customisedModelVersion in encryptableModelVersions) {
			"Can't encrypt custom entity of type $customEntityTypeId with version $customisedModelVersion: the entity should be migrated to a version using the current extensions manifest ($encryptableModelVersions)"
		}
		return encryptValidated(encryptionKey, clearEntity)
	}

	protected abstract suspend fun encryptValidated(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCustomEntityBase,
	): EncryptedCustomEntityBase
}
