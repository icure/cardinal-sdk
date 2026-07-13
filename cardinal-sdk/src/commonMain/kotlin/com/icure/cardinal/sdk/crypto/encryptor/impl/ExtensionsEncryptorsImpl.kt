package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.ensure
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

@InternalIcureApi
internal class ExtensionsEncryptorsImpl(
	val fullEncryptionFields: Set<String>,
	val recursiveEncryption: Map<String, Recursive>,
	val cryptoService: CryptoService
) : ExtensionsEncryptors {
	companion object {
		const val ENCRYPTED_SELF = "encryptedSelf"
	}

	/**
	 * Encrypt extensions, potentially recursively using other instances of extensions encryptor.
	 * Unlike standard entity encryptors default values are not checked here: we assume that if an extension had a
	 * default value it was omitted from the provided JsonObject by the layer handling extension decoding/encoding.
	 */
	override suspend fun encryptExtension(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		extensions: JsonObject,
	): JsonObject {
		val toEncrypt = mutableMapOf<String, JsonElement>()
		val updatedExtensions = extensions.toMutableMap()
		fullEncryptionFields.forEach { fullEncryptionField ->
			val currValue = extensions[fullEncryptionField]
			if (currValue != null) {
				toEncrypt[fullEncryptionField] = currValue
				updatedExtensions.remove(fullEncryptionField)
			}
		}
		recursiveEncryption.forEach { (fieldName, encryptor) ->
			val currValue = extensions[fieldName]
			if (currValue != null) {
				updatedExtensions[fieldName] = encryptor.encryptExtensionValue(encryptionKey, currValue)
			}
		}
		val updatedEncryptedSelf = EncryptorsHelpers.getUpdatedEncryptSelf(
			encryptionKey,
			JsonObject(toEncrypt),
			kotlin.runCatching {
				extensions[ENCRYPTED_SELF]?.let {
					it as? JsonPrimitive
				}?.takeIf {
					it.isString
				}?.let {
					Base64String(it.content)
				}
			}.getOrNull(),
			cryptoService
		)
		if (updatedEncryptedSelf == null) {
			updatedExtensions.remove(ENCRYPTED_SELF)
		} else {
			updatedExtensions[ENCRYPTED_SELF] = JsonPrimitive(updatedEncryptedSelf.s)
		}
		return JsonObject(updatedExtensions)
	}

	/**
	 * This ignores completely encrypted fields that do not match any configured encrypted field, or do not match the
	 * expected structure, but currently there is a limit on how much validation is done (or rather ignored) on the
	 * expected structure.
	 *
	 * If through recursive encryption we expect that we have to decrypt a list of something, and the field stored in
	 * the encryptedSelf is not a list then we can ignore it already now.
	 *
	 * However, this component is not aware of the full structure of the extension: if there is a field `foo` that
	 * should match the custom object definition `Foo` we don't know how to check here if it does; it is the job of
	 * the cardinal->custom model converter to ignore the decrypted fields that do not respect the definition.
	 */
	override suspend fun decryptExtension(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		extensions: JsonObject
	): JsonObject = JsonObject(
		EncryptorsHelpers.decryptEncryptSelf(
			decryptionKeys = decryptionKeys,
			encryptedSelf = extensions[ENCRYPTED_SELF]?.let {
				Base64String((it as JsonPrimitive).content) // Server validates that encrypted self is a base64 string
			},
			cryptoService = cryptoService
		).mapNotNull { (name, value) ->
			if (name in fullEncryptionFields) {
				name to value
			} else {
				recursiveEncryption[name]?.decryptExtensionValue(decryptionKeys, value)?.let { name to it }
			}
		}.toMap()
	)

	interface Recursive {
		suspend fun encryptExtensionValue(
			encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
			value: JsonElement,
		): JsonElement
		/**
		 * Returns null if the decrypted value does not match the expected structure and should be ignored.
		 * When the expected structure is a collection or a map it is possible that only some values can be ignored.
		 */
		suspend fun decryptExtensionValue(
			decryptionKeys: kotlin.collections.Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
			value: JsonElement,
		): JsonElement?

		class Collection(
			val recursive: Recursive,
		) : Recursive {
			override suspend fun encryptExtensionValue(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				value: JsonElement,
			): JsonElement {
				if (value == JsonNull) return value
				ensure(value is JsonArray) { "Expected JsonArray or JsonNull, got ${value::class.simpleName}" }
				return JsonArray(value.map { recursive.encryptExtensionValue(encryptionKey, it) })
			}

			override suspend fun decryptExtensionValue(
				decryptionKeys: kotlin.collections.Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
				value: JsonElement,
			): JsonElement? {
				if (value == JsonNull) return value
				if (value !is JsonArray) return null
				return JsonArray(value.mapNotNull { recursive.decryptExtensionValue(decryptionKeys, it) })
			}
		}

		class Map(
			val recursive: Recursive,
		) : Recursive {
			override suspend fun encryptExtensionValue(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				value: JsonElement,
			): JsonElement {
				if (value == JsonNull) return value
				ensure(value is JsonObject) { "Expected JsonObject or JsonNull, got ${value::class.simpleName}" }
				return JsonObject(value.mapValues { recursive.encryptExtensionValue(encryptionKey, it.value) })
			}

			override suspend fun decryptExtensionValue(
				decryptionKeys: kotlin.collections.Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
				value: JsonElement,
			): JsonElement? {
				if (value == JsonNull) return value
				if (value !is JsonObject) return null
				return JsonObject(value.mapNotNull { (k, v) ->
					recursive.decryptExtensionValue(decryptionKeys, v)?.let { k to v }
				}.toMap())
			}
		}

		class Object(
			val encryptor: Lazy<ExtensionsEncryptors>
		) : Recursive {
			override suspend fun encryptExtensionValue(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				value: JsonElement,
			): JsonElement {
				if (value == JsonNull) return value
				ensure(value is JsonObject) { "Expected JsonObject or JsonNull, got ${value::class.simpleName}" }
				return encryptor.value.encryptExtension(encryptionKey, value)
			}

			override suspend fun decryptExtensionValue(
				decryptionKeys: kotlin.collections.Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
				value: JsonElement,
			): JsonElement? {
				if (value == JsonNull) return value
				if (value !is JsonObject) return null
				return encryptor.value.decryptExtension(decryptionKeys, value)
			}
		}
	}
}