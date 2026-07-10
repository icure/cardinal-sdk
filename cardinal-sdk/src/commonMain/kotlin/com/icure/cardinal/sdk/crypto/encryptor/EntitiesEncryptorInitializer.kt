package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.utils.InternalIcureApi
import kotlin.reflect.KClass

@InternalIcureApi
internal interface EntitiesEncryptorInitializer {
	/**
	 * Used for initializing encryptors that are not configurable / customizable
	 */
	fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> initializeSingleEncryptor(
		mainManifestName: String,
		manifestsByName: Map<String, EntityEncryptionManifest>,
		encryptorOptions: EncryptorOptions,
		mainManifestEncryptedEntity: KClass<ENCRYPTED>,
		mainManifestDecryptedEntity: KClass<DECRYPTED>,
	): EntityEncryptor<ENCRYPTED, DECRYPTED>

	/**
	 * Initialize the encryptors for the given manifests and options.
	 */
	fun initializeEncryptorsForManifests(
		manifests: EntitiesEncryptionManifests,
		encryptorOptions: EncryptorOptions,
	): RootEntitiesEncryptors
}

@InternalIcureApi
internal inline fun <
	reified ENCRYPTED : Encryptable,
	reified DECRYPTED : Encryptable
> EntitiesEncryptorInitializer.initializeSingleEncryptor(
	mainManifestName: String,
	manifestsByName: Map<String, EntityEncryptionManifest>,
	encryptorOptions: EncryptorOptions,
): EntityEncryptor<ENCRYPTED, DECRYPTED> =
	initializeSingleEncryptor(
		mainManifestName,
		manifestsByName,
		encryptorOptions,
		ENCRYPTED::class,
		DECRYPTED::class
	)
