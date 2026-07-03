package com.icure.cardinal.sdk.crypto.encryptor

internal interface EntitiesEncryptorInitializer {
	/**
	 * Initialize the encryptors for the given manifests.
	 */
	fun initializeEncryptorsForManifests(
		manifests: EntitiesEncryptionManifests
	): RootEntitiesEncryptors
}
