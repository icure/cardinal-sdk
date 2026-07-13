package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json

internal data class SharedEncryptorsOptions(
	/**
	 * Json to use for encoding and decoding.
	 */
	val json: Json,
	/**
	 * Crypto service to use for encryption and decryption.
	 */
	val cryptoService: CryptoService,
)
