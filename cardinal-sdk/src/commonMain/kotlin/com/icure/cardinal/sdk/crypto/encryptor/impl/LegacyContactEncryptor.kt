package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.impl.generated.ContactEncryptorFactory
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json

@InternalIcureApi
internal object LegacyContactEncryptorFactory : EntityEncryptorFactory<EncryptedContact, DecryptedContact> {
	override val empty: EntityEncryptor<EncryptedContact, DecryptedContact>
		get() = throw UnsupportedOperationException("Legacy service encryption requires that you specify a manifest for the encryption of Contact.services")

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService
	): EntityEncryptor<EncryptedContact, DecryptedContact> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		if (manifest.recursiveEncryption["services"] == null) throw UnsupportedOperationException(
			"Legacy service encryption requires that you specify a manifest for the encryption of Contact.services"
		)
		return ContactEncryptorFactory.create(entityManifestName, encryptorsFactoryContext, encodingJson, cryptoService)
	}
}