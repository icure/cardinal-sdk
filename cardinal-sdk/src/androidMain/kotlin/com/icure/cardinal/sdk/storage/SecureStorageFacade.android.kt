package com.icure.cardinal.sdk.storage

import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.annotation.RequiresApi
import com.icure.cardinal.sdk.exceptions.SecureStorageException
import com.icure.cardinal.sdk.storage.EncryptedStorageFacade.Companion.SECRET_KEY
import com.icure.kryptom.crypto.AesAlgorithm.CbcWithPkcs7Padding
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

/**
 * Create a secure storage facade for Android.
 *
 * @param storage The storage facade to use to store the encrypted values.
 * @param accessLevel The access level required to access the secure key.
 * @param authorizationTimeoutSeconds Duration in seconds or 0 if user authentication must take place for every use of the key.
 *
 * @return A secure storage facade.
 *
 * @throws UnsupportedOperationException If the device is not running Android 11 or above.
 */
@RequiresApi(Build.VERSION_CODES.R)
@Suppress("FunctionName")
suspend fun AndroidSecureStorageFacade(
	storage: StorageFacade,
	accessLevel: Set<SecureKeyAccessLevel>,
	authorizationTimeoutSeconds: Int = 0
): EncryptedStorageFacade {
	val encryptionKey = getOrCreateSecretKey(storage, SECRET_KEY, accessLevel, authorizationTimeoutSeconds)
	return EncryptedStorageFacade(storage, encryptionKey)
}

/**
 * Get or create a secret key for encryption.
 *
 * @param storageFacade The storage facade to use to store the secret key.
 * @param key The key to use to store/access the AES key.
 */
@RequiresApi(Build.VERSION_CODES.R)
private suspend fun getOrCreateSecretKey(
	storageFacade: StorageFacade,
	key: String,
	accessLevel: Set<SecureKeyAccessLevel>,
	authorizationTimeoutSeconds: Int
): AesKey<CbcWithPkcs7Padding> {
	if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) throw UnsupportedOperationException("Secure storage is only supported on Android 11 and above")
	return getSecretKey(key, storageFacade) ?: createSecretKey(accessLevel, key, storageFacade, authorizationTimeoutSeconds)
}

private suspend fun getSecretKey(key: String, storage: StorageFacade): AesKey<CbcWithPkcs7Padding>? {
	val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
	val iv = storage.getItem("$key.iv")?.let { base64Decode(it) }
	val cipherBytes = storage.getItem("$key.cipher")?.let { base64Decode(it) }

	if (iv == null && cipherBytes == null && !keyStore.containsAlias(key)) return null
	if (iv == null || cipherBytes == null) throw SecureStorageException("Missing IV or cipher bytes")
	if (!keyStore.containsAlias(key)) throw SecureStorageException("Key not found in keystore")

	val keyStoreKey = (keyStore.getEntry(key, null) as KeyStore.SecretKeyEntry).secretKey
	return decryptKey(cipherBytes, iv, keyStoreKey)
}

@RequiresApi(Build.VERSION_CODES.R)
private suspend fun createSecretKey(
	accessLevel: Set<SecureKeyAccessLevel>,
	key: String,
	storage: StorageFacade,
	authorizationTimeoutSeconds: Int
): AesKey<CbcWithPkcs7Padding> {
	val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
	val keyGenParameterSpec = KeyGenParameterSpec.Builder(key, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
		.setBlockModes(KeyProperties.BLOCK_MODE_CBC)
		.setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
		.apply {
			if (accessLevel.isNotEmpty()) {
				setUserAuthenticationRequired(true)
				setUserAuthenticationParameters(authorizationTimeoutSeconds, accessLevel.fold(0) { acc, level -> acc or level.toKeyProperties() })
			} else {
				setUserAuthenticationRequired(false)
			}
		}
		.build()
	keyGenerator.init(keyGenParameterSpec)
	val keyStoreKey = keyGenerator.generateKey()
	val aesKey = defaultCryptoService.aes.generateKey(CbcWithPkcs7Padding)
	val (iv, cipherBytes) = encryptKey(aesKey, keyStoreKey)
	storage.setItem("$key.iv", base64Encode(iv))
	storage.setItem("$key.cipher", base64Encode(cipherBytes))
	return aesKey
}

private suspend fun encryptKey(aesKey: AesKey<CbcWithPkcs7Padding>, secretKey: SecretKey): Pair<ByteArray, ByteArray> {
	return try {
		val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
		cipher.init(Cipher.ENCRYPT_MODE, secretKey)

		val iv = cipher.iv
		val cipherBytes = cipher.doFinal(defaultCryptoService.aes.exportKey(aesKey))
		Pair(iv, cipherBytes)
	} catch (e: Exception) {
		throw SecureStorageException("Failed to encrypt key", e)
	}
}

private suspend fun decryptKey(cipherBytes: ByteArray, iv: ByteArray, secretKey: SecretKey): AesKey<CbcWithPkcs7Padding> {
	return try {
		val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
		val spec = IvParameterSpec(iv)
		cipher.init(Cipher.DECRYPT_MODE, secretKey, spec)

		val aesKeyBytes = cipher.doFinal(cipherBytes)
		defaultCryptoService.aes.loadKey(CbcWithPkcs7Padding, aesKeyBytes)
	} catch (e: Exception) {
		throw SecureStorageException("Failed to decrypt key", e)
	}
}

@RequiresApi(Build.VERSION_CODES.R)
private fun SecureKeyAccessLevel.toKeyProperties(): Int {
	return when (this) {
		SecureKeyAccessLevel.DevicePasscode -> KeyProperties.AUTH_DEVICE_CREDENTIAL
		SecureKeyAccessLevel.Biometric -> KeyProperties.AUTH_BIOMETRIC_STRONG
	}
}
