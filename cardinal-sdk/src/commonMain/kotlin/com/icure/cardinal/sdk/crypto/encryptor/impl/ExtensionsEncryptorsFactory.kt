package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptionManifest
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
internal object ExtensionsEncryptorsFactory {
	fun create(
		manifestName: String,
		context : ExtensionsEncryptorFactoryContext,
		cryptoService: CryptoService,
	): ExtensionsEncryptors {
		val manifest = context.getExtensionsManifest(manifestName)
		return ExtensionsEncryptorsImpl(
			fullEncryptionFields = manifest.fullEncryptionFields,
			recursiveEncryption = manifest.recursiveEncryptionFields.mapValues { (_, recursive) ->
				resolveRecursive(recursive, context)
			},
			cryptoService = cryptoService
		)
	}

	private fun resolveRecursive(
		recursive: ExtensionsEncryptionManifest.Recursive,
		context: ExtensionsEncryptorFactoryContext,
	): ExtensionsEncryptorsImpl.Recursive = when (recursive) {
		is ExtensionsEncryptionManifest.Recursive.Collection -> ExtensionsEncryptorsImpl.Recursive.Collection(
			resolveRecursive(recursive.recursive, context),
		)
		is ExtensionsEncryptionManifest.Recursive.Map -> ExtensionsEncryptorsImpl.Recursive.Map(
			resolveRecursive(recursive.recursive, context),
		)
		is ExtensionsEncryptionManifest.Recursive.Object -> ExtensionsEncryptorsImpl.Recursive.Object(
			context.getExtensionEncryptorsProvider(recursive.manifestName)
		)
	}
}