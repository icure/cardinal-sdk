package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.utils.intersects
import kotlinx.serialization.Serializable

/**
 * Encryption manifest for a builtin entity embedded in other entities (e.g. Address, Service), referenced by name from
 * [EntityEncryptionManifest.recursiveEncryption] of other manifests.
 *
 * Unlike [BuiltinRootEntityEncryptionManifest] embedded entities have no customised model version of their own: they
 * are always encrypted and decrypted according to the version of the root entity containing them.
 */
@Serializable
data class BuiltinEmbeddedEntityEncryptionManifest(
	override val fieldsToEncrypt: Set<String>,
	override val recursiveEncryption: Map<String, String>,
	/**
	 * Specifies how to decrypt extensions based on the version of the customized model of the root entity:
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
	 *
	 * Unlike [BuiltinRootEntityEncryptionManifest.currentExtensionsManifest] this can't be derived from
	 * [extensionsManifestsByModelVersion]: embedded entities have no version of their own, and the same manifest may be
	 * used by multiple root entity types, each with a different current version.
	 */
	val currentExtensionsManifest: String?,
) : EntityEncryptionManifest {
	init {
		require (!recursiveEncryption.keys.intersects(fieldsToEncrypt)) {
			"Recursive encryption and direct encryption cannot be used on the same field"
		}
	}
}
