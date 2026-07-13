package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.options.DecryptedJsonStrictness

internal data class DecryptorOptions(
	/**
	 * Refer to [com.icure.cardinal.sdk.options.SdkOptions.unversionedEntitiesDecryptedJsonStrictness]
	 */
	val unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness
)
