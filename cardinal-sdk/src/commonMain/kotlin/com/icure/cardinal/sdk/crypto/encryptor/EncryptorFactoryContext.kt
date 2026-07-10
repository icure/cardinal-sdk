package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.utils.InternalIcureApi
import kotlin.reflect.KClass

/**
 * A context used with [EntityEncryptorFactory.create] for creating multiple [EntityEncryptor]s that use an
 * [EntityEncryptionManifest] coming from the same group of [EntitiesEncryptionManifests].
 */
@InternalIcureApi
internal interface EncryptorFactoryContext {
	/**
	 * Registers the manifest for use with the [ENCRYPTED]+[DECRYPTED] types and gives a lazy provider for an
	 * [EntityEncryptor] of the requested type.
	 *
	 * Fails fast if the manifest name is not valid, if the manifest was already registered for other types, or
	 * if there is no encryptor available for the requested types: if this method returns then it guarantees that the
	 * lazy will be able to initialize properly.
	 */
	fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getEntityEncryptorProvider(
		entityManifestName: String,
		encryptedClass: KClass<ENCRYPTED>,
		decryptedClass: KClass<DECRYPTED>,
	): Lazy<EntityEncryptor<ENCRYPTED, DECRYPTED>>

	/**
	 * Get the manifest with the given name, fails if the manifest is not available in this context.
	 */
	fun getManifest(manifestName: String): EntityEncryptionManifest

	/**
	 * If true the content of encrypted self in entities will be serialized using the legacy field names rather than
	 * the cardinal SDK names (for example [com.icure.cardinal.sdk.model.embed.InvoicingCode.pricingId] will be
	 * serialized as "tarificationId" instead of "pricingId").
	 *
	 * This is required to ensure that the legacy iCure typescript SDK can correctly deserialize the entities.
	 */
	val serializeEncryptedSelfUsingLegacyNames: Boolean
}