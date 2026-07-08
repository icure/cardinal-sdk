package com.icure.cardinal.sdk.crypto.encryptor

internal interface EntitiesEncryptorInitializer {
	/**
	 * Initialize the encryptors for the given manifests.
	 *
	 * [useLegacyServiceContentEncryption] can be used to enforce the use of the legacy way of encrypting the service
	 * content:
	 * - If all the values of the service content have non-null and non-empty values only for
	 *   [com.icure.cardinal.sdk.model.embed.Content.compoundValue] then the content is not encrypted in full, instead
	 *   the contained compound Services are encrypted using this same manifest.
	 *   This also means that the content's map keys will be unencrypted.
	 * - In all other cases the content map is encrypted in its entirety: the map keys and any compound service will be
	 *   completely hidden within the encrypted content.
	 *
	 * If [useLegacyServiceContentEncryption] is true any configuration on how content should be encrypted is ignored.
	 */
	fun initializeEncryptorsForManifests(
		manifests: EntitiesEncryptionManifests,
		useLegacyServiceContentEncryption: Boolean,
	): RootEntitiesEncryptors
}
