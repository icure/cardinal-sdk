package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.utils.InternalIcureApi
import kotlin.reflect.KClass

@InternalIcureApi
internal interface EntitiesEncryptorsInitializer {
	/**
	 * Used for initializing encryptors that are not configurable / customizable
	 */
	fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> initializeSingleEntityEncryptors(
		mainManifestName: String,
		manifestsByName: Map<String, EntityEncryptionManifest>,
		encryptorOptions: EncryptorOptions,
		decryptorOptions: DecryptorOptions,
		sharedOptions: SharedEncryptorsOptions,
		mainManifestEncryptedEntity: KClass<ENCRYPTED>,
		mainManifestDecryptedEntity: KClass<DECRYPTED>,
	): EntityEncryptors<ENCRYPTED, DECRYPTED>

	/**
	 * Initialize the encryptors for the given manifests and options.
	 */
	fun initializeEncryptorsForManifests(
		manifests: EntitiesEncryptionManifests,
		encryptorOptions: EncryptorOptions,
		decryptorOptions: DecryptorOptions,
		sharedOptions: SharedEncryptorsOptions,
	): RootEntitiesEncryptors
}

@InternalIcureApi
internal inline fun <
	reified ENCRYPTED : Encryptable,
	reified DECRYPTED : Encryptable
> EntitiesEncryptorsInitializer.initializeSingleEntityEncryptors(
	mainManifestName: String,
	manifestsByName: Map<String, EntityEncryptionManifest>,
	encryptorOptions: EncryptorOptions,
	decryptorOptions: DecryptorOptions,
	sharedOptions: SharedEncryptorsOptions,
): EntityEncryptors<ENCRYPTED, DECRYPTED> =
	initializeSingleEntityEncryptors(
		mainManifestName,
		manifestsByName,
		encryptorOptions,
		decryptorOptions,
		sharedOptions,
		ENCRYPTED::class,
		DECRYPTED::class
	)
