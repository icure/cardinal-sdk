package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors

internal interface ExtensionsEncryptorFactoryContext {
	fun getExtensionEncryptorsProvider(
		extensionsManifestName: String,
	): Lazy<ExtensionsEncryptors>

	fun getExtensionsManifest(name: String): ExtensionsEncryptionManifest
}