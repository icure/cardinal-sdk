package com.icure.cardinal.sdk.crypto.encryptor;

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.utils.intersects
import kotlinx.serialization.Serializable

/**
 * An encryption manifest for a specific type of custom entity.
 * The actual custom properties encryption is handled by the [extensionsManifestsByModelVersion] and
 * [currentExtensionsManifest] properties.;
 */
@Serializable
data class CustomEntityEncryptionManifest(
	override val fieldsToEncrypt: Set<String>,
	override val recursiveEncryption: Map<String, String>,
	/**
	 * Specifies how to decrypt extensions based on the version of the custom model:
	 * - Map keys are a known version for the custom entity type handled by this manifest
	 * - Map values are keys in [EntitiesEncryptionManifests.extensionsManifestsByName]
	 *
	 * Unlike builtin entities the version number is enough for a given custom entity type, since it is not possible to
	 * use embedded builtin entities in a fully custom entity.
	 */
	val extensionsManifestsByModelVersion: Map<Int, String>,
	/**
	 * Specifies how to encrypt the extensions, matches the current version of custom entity (the value is a key of
	 * [EntitiesEncryptionManifests.extensionsManifestsByName]).
	 */
	val currentExtensionsManifest: String?
) : EntityEncryptionManifest {
	init {
		// CustomEntityBase can't have an encryptedSelf (and can't embed other encryptable entities), so for now only the
		// extensions can be encrypted. If this changes the encryptor generation for CustomEntityBase must be updated too.
		require(fieldsToEncrypt.isEmpty()) {
			"Custom entities don't support encryption of base fields, but fieldsToEncrypt is $fieldsToEncrypt"
		}
		require(recursiveEncryption.isEmpty()) {
			"Custom entities don't support recursive encryption of base fields, but recursiveEncryption is $recursiveEncryption"
		}
		require (!recursiveEncryption.keys.intersects(fieldsToEncrypt)) {
			"Recursive encryption and direct encryption cannot be used on the same field"
		}
	}
}
