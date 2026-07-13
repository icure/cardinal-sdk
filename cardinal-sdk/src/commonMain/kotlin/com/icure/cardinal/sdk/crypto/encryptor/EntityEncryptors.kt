package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class EntityEncryptors <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> (
	val encryptor: EntityEncryptor<ENCRYPTED, DECRYPTED>,
	val decryptor: EntityDecryptor<ENCRYPTED, DECRYPTED>
)