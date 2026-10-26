package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.BuiltinRootEntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.RootEntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.impl.generated.ContactEncryptorFactory
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json

@InternalIcureApi
internal object LegacyContactEncryptorFactory : RootEntityEncryptorFactory<EncryptedContact, DecryptedContact> {
	override fun create(
		manifest: BuiltinRootEntityEncryptionManifest,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService
	): EntityEncryptor<EncryptedContact, DecryptedContact> {
		if (manifest.recursiveEncryption["services"] == null) throw UnsupportedOperationException(
			"Legacy service encryption requires that you specify a manifest for the encryption of Contact.services"
		)
		return ContactEncryptorFactory.create(manifest, encryptorsFactoryContext, encodingJson, cryptoService)
	}
}