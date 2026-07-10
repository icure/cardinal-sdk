package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
object LegacyContactEncryptor : EntityEncryptor<EncryptedContact, DecryptedContact> {
	override val empty: EntityEncryptor<EncryptedContact, DecryptedContact>
		get() = throw UnsupportedOperationException("It is not allowed to use legacy service encryption with an empty encryptor factory for contact.")
}