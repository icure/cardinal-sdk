package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.JsonObject
import kotlin.reflect.KClass

/**
 * A context used with [EntityEncryptorFactory.create] for creating multiple [EntityEncryptor]s that use an
 * [EntityEncryptionManifest] coming from the same group of [EntitiesEncryptionManifests].
 */
@InternalIcureApi
internal interface EntityEncryptorsFactoryContext {
	/**
	 * Registers the manifest for use with the [ENCRYPTED]+[DECRYPTED] types and gives a lazy provider for
	 * [EntityEncryptors] of the requested type.
	 *
	 * Fails fast if the manifest name is not valid, if the manifest was already registered for other types, or
	 * if there is no encryptor available for the requested types.
	 *
	 * Part of the validation, however, is done lazily, so there is no guarantee that if this method returns then the
	 * lazy will be able to initialize properly. It is the job of the [EntitiesEncryptorsInitializer] to make sure that
	 * all dependencies are valid before returning the initialized encryptors.
	 */
	fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getEntityEncryptorsProvider(
		entityManifestName: String,
		encryptedClass: KClass<ENCRYPTED>,
		decryptedClass: KClass<DECRYPTED>,
	): Lazy<EntityEncryptors<ENCRYPTED, DECRYPTED>>

	fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getEmptyEntityDecryptorProvider(
		encryptedClass: KClass<ENCRYPTED>,
		decryptedClass: KClass<DECRYPTED>,
	): Lazy<EntityDecryptor<ENCRYPTED, DECRYPTED>>

	/**
	 * Similar to [getEntityEncryptorsProvider] but for extensions encryption.
	 */
	fun getExtensionEncryptorsProvider(
		extensionsManifestName: String,
		encryptedClass: KClass<out Encryptable>,
		decryptedClass: KClass<out Encryptable>,
	): Lazy<ExtensionsEncryptors>

	/**
	 * Get the manifest with the given name, fails if the manifest is not available in this context.
	 */
	fun getManifest(manifestName: String): EntityEncryptionManifest

	/**
	 * Get the decrypted json patcher to use for a certain manifest.
	 */
	fun getManifestDecryptedJsonPatcher(manifestName: String): ((JsonObject) -> JsonObject)?

	/**
	 * If true the content of encrypted self in entities will be serialized using the legacy field names rather than
	 * the cardinal SDK names (for example [com.icure.cardinal.sdk.model.embed.InvoicingCode.pricingId] will be
	 * serialized as "tarificationId" instead of "pricingId").
	 *
	 * This is required to ensure that the legacy iCure typescript SDK can correctly deserialize the entities.
	 */
	val serializeEncryptedSelfUsingLegacyNames: Boolean

	/**
	 * The strictness to use in parsing decrypted json when deserializing entities that have been created without a
	 * customized model version.
	 */
	val unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness
}