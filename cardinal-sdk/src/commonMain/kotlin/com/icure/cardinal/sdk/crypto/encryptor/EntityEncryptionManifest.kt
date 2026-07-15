package com.icure.cardinal.sdk.crypto.encryptor;

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.utils.intersects
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonObject

@Serializable
data class EntityEncryptionManifest(
	/**
	 * Fields to encrypt directly in the entity.
	 * When a field is encrypted the value in the encrypted entity is replaced by the default value for that field,
	 * and the real value is kept in the encryptedSelf content.
	 */
	val fieldsToEncrypt: Set<String>,
	/**
	 * Fields to encrypt recursively using another manifest, the key is the field name, the value is the name of the
	 * manifest, which must be in the [EntitiesEncryptionManifests.manifestsByName] map.
	 *
	 * If the field is a map or collection the manifest will be applied to the corresponding values or elements;
	 * multiple levels are also supported.
	 */
	val recursiveEncryption: Map<String, String>,
	/**
	 * Specifies how to decrypt extensions based on the version of the customized model:
	 * - Outer map keys are [CustomisedModelVersion.modelType]
	 * - Inner map keys are [CustomisedModelVersion.typeVersion]
	 * - Inner map values are keys in [EntitiesEncryptionManifests.extensionsManifestsByName]
	 *
	 * There are multiple manifests that could be used, and they are indexed by a pair of model version number and type,
	 * since the model version number is not enough. For example:
	 * - Patient V1 depends on Address V1, Hcp V1 depends also on Address V1
	 * - updates something in extensions of Patient -> get Patient V2, but address stays Address V1
	 * - updates something in Address -> get Address V2, Patient V3 depends on Address V2, Hcp V2 depends on Address V2
	 * -> Knowing only the version of the root model is not enough: V2 of a root model points to Address V1 if the root
	 *    model is patient or Address V2 if the root model is Hcp
	 */
	val extensionsManifestsByModelVersion: Map<EntityWithEncryptionMetadataTypeName, Map<Int, String>>,
	/**
	 * Specifies how to encrypt the extensions, matches the current version of customised model (value is a key of
	 * [EntitiesEncryptionManifests.extensionsManifestsByName]).
	 * This is always the same independently of the root model.
	 */
	val currentExtensionsManifest: String?
) {
	init {
		require (!recursiveEncryption.keys.intersects(fieldsToEncrypt)) {
			"Recursive encryption and direct encryption cannot be used on the same field"
		}
	}
}
