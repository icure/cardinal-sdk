package com.icure.cardinal.sdk.crypto.encryptor.impl

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
import kotlin.jvm.JvmName

@InternalIcureApi
internal class ExtensionsEncryptor(
	val fullEncryptionFields: Set<String>,
	val recursivelyEncrypt: Map<String, Recursive>,
	val cryptoService: CryptoService
) {
	companion object {
		const val ENCRYPTED_SELF = "encryptedSelf"
	}

	/**
	 * Encrypt extensions, potentially recursively using other instances of extensions encryptor.
	 * Unlike standard entity encryptors default values are not checked here: we assume that if an extension had a
	 * default value it was omitted from the provided JsonObject by the layer handling extension decoding/encoding.
	 */
	suspend fun encryptExtension(
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
		recursivelyEncrypt.forEach { (fieldName, encryptor) ->
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

	@JvmName("encryptExtensionNullable")
	suspend fun encryptExtension(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		extensions: JsonObject?
	): JsonObject? {
		if (extensions == null) return null
		return encryptExtension(encryptionKey, extensions)
	}

	interface Recursive {
		suspend fun encryptExtensionValue(
			encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
			value: JsonElement,
		): JsonElement

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
		}

		class Object(
			val encryptor: Lazy<ExtensionsEncryptor>
		) : Recursive {
			override suspend fun encryptExtensionValue(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				value: JsonElement,
			): JsonElement {
				if (value == JsonNull) return value
				ensure(value is JsonObject) { "Expected JsonObject or JsonNull, got ${value::class.simpleName}" }
				return encryptor.value.encryptExtension(encryptionKey, value)
			}
		}
	}
}