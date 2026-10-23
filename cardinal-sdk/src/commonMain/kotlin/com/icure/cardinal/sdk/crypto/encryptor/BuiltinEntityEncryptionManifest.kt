package com.icure.cardinal.sdk.crypto.encryptor;

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.utils.intersects
import kotlinx.serialization.Serializable

@Serializable
data class BuiltinEntityEncryptionManifest(
	override val fieldsToEncrypt: Set<String>,
	override val recursiveEncryption: Map<String, String>,
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
	val extensionsManifestsByModelVersion: Map<EntityWithEncryptionMetadataTypeName.Builtin, Map<Int, String>>,
	/**
	 * Specifies how to encrypt the extensions, matches the current version of customised model (value is a key of
	 * [EntitiesEncryptionManifests.extensionsManifestsByName]).
	 * This is always the same independently of the root model.
	 */
	val currentExtensionsManifest: String?,
	/**
	 * Only meaningful for manifests of root entities with a customisable model (e.g. Patient), ignored for manifests of
	 * embedded entities: the customised model version that entities must have to be encrypted with this manifest.
	 * Entities at older versions must be migrated to the current version before being encrypted, otherwise they would
	 * be encrypted using a different manifest than the one used for their decryption.
	 *
	 * Null for roots that are not customised: in this case the entities to encrypt must also have no customised model
	 * version. If not null, the version must be in [extensionsManifestsByModelVersion] for the root entity type, and
	 * map to [currentExtensionsManifest].
	 */
	val currentVersion: Int? = null,
) : EntityEncryptionManifest {
	init {
		require (!recursiveEncryption.keys.intersects(fieldsToEncrypt)) {
			"Recursive encryption and direct encryption cannot be used on the same field"
		}
	}
}
