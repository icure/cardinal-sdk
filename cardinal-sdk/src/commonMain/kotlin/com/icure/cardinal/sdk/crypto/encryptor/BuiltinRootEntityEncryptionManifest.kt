package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.utils.intersects
import kotlinx.serialization.Serializable

/**
 * Encryption manifest for a builtin root entity (e.g. Patient, Form): each manifest is used only for the entity type
 * of the [EntitiesEncryptionManifests] property holding it.
 */
@Serializable
data class BuiltinRootEntityEncryptionManifest(
	override val fieldsToEncrypt: Set<String>,
	/**
	 * Values are keys of [EntitiesEncryptionManifests.embeddedManifestsByName].
	 */
	override val recursiveEncryption: Map<String, String>,
	/**
	 * Specifies how to decrypt extensions based on the customised model version of the entity:
	 * - Map keys are a known version of the customised model of the root entity
	 * - Map values are keys in [EntitiesEncryptionManifests.extensionsManifestsByName]
	 *
	 * Every version of the customised model must be present, even if it has nothing to encrypt (using an empty
	 * extensions manifest), as entities with a version that is not in this map can't be decrypted.
	 */
	val extensionsManifestsByModelVersion: Map<Int, String> = emptyMap(),
	/**
	 * The current version of the customised model of the root entity: entities can only be encrypted if they have
	 * this version (older entities must be migrated first), and their extensions are encrypted using the extensions
	 * manifest of this version.
	 *
	 * Null for roots that are not customised: in this case the entities to encrypt must also have no customised model
	 * version, and their extensions are not encrypted. Always null for root entities without a customisable model
	 * (e.g. Form).
	 */
	val currentVersion: Int? = null,
) : EntityEncryptionManifest {
	/**
	 * The extensions manifest to use for the encryption, a key of [EntitiesEncryptionManifests.extensionsManifestsByName],
	 * or null if extensions should not be encrypted.
	 */
	val currentExtensionsManifest: String? get() = currentVersion?.let { extensionsManifestsByModelVersion.getValue(it) }

	init {
		require (!recursiveEncryption.keys.intersects(fieldsToEncrypt)) {
			"Recursive encryption and direct encryption cannot be used on the same field"
		}
		if (currentVersion != null) {
			require(currentVersion in extensionsManifestsByModelVersion) {
				"The current version $currentVersion must be in extensionsManifestsByModelVersion"
			}
		}
	}
}
