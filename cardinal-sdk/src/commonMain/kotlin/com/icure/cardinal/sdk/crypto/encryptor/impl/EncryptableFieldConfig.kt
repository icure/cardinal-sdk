package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal sealed interface EncryptableFieldConfig<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> {
	val encryptor: EntityEncryptor<ENCRYPTED, DECRYPTED>?
	val fullEncryption: Boolean

	companion object {
		@Suppress("UNCHECKED_CAST")
		fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> Full() =
			Full as EncryptableFieldConfig<ENCRYPTED, DECRYPTED>
	}

	private data object Full : EncryptableFieldConfig<Nothing, Nothing> {
		override val encryptor: EntityEncryptor<Nothing, Nothing>? = null
		override val fullEncryption: Boolean get() = true
	}

	class None<ENCRYPTED : Encryptable, DECRYPTED : Encryptable>(
		private val factory: EntityEncryptorFactory<ENCRYPTED, DECRYPTED>
	) : EncryptableFieldConfig<ENCRYPTED, DECRYPTED> {
		override val encryptor: EntityEncryptor<ENCRYPTED, DECRYPTED> get() = factory.empty
		override val fullEncryption: Boolean get() = false
	}

	data class Configured<ENCRYPTED : Encryptable, DECRYPTED : Encryptable>(
		private val configuration: Lazy<EntityEncryptor<ENCRYPTED, DECRYPTED>>
	) : EncryptableFieldConfig<ENCRYPTED, DECRYPTED> {
		override val encryptor: EntityEncryptor<ENCRYPTED, DECRYPTED>
			get() = configuration.value
		override val fullEncryption: Boolean get() = false
	}

}