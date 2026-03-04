package com.icure.cardinal.sdk.storage

import com.icure.cardinal.sdk.exceptions.SecureStorageException
import com.icure.cardinal.sdk.storage.EncryptedStorageFacade.Companion.SECRET_KEY
import com.icure.kryptom.apple.toByteArray
import com.icure.kryptom.apple.toNSData
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesAlgorithm.CbcWithPkcs7Padding
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.defaultCryptoService
import io.ktor.utils.io.core.toByteArray
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.value
import platform.CoreFoundation.CFDataRefVar
import platform.CoreFoundation.CFDictionaryAddValue
import platform.CoreFoundation.CFDictionaryCreateMutable
import platform.CoreFoundation.CFRelease
import platform.CoreFoundation.kCFAllocatorDefault
import platform.CoreFoundation.kCFBooleanTrue
import platform.CoreFoundation.kCFTypeDictionaryKeyCallBacks
import platform.CoreFoundation.kCFTypeDictionaryValueCallBacks
import platform.Foundation.CFBridgingRetain
import platform.Security.SecAccessControlCreateFlags
import platform.Security.SecAccessControlCreateWithFlags
import platform.Security.SecItemAdd
import platform.Security.SecItemCopyMatching
import platform.Security.errSecItemNotFound
import platform.Security.errSecSuccess
import platform.Security.kSecAccessControlBiometryAny
import platform.Security.kSecAccessControlDevicePasscode
import platform.Security.kSecAccessControlOr
import platform.Security.kSecAttrAccessControl
import platform.Security.kSecAttrAccessibleWhenUnlocked
import platform.Security.kSecAttrApplicationTag
import platform.Security.kSecClass
import platform.Security.kSecClassKey
import platform.Security.kSecMatchLimit
import platform.Security.kSecMatchLimitOne
import platform.Security.kSecReturnData
import platform.Security.kSecValueData

/**
 * Create a secure storage facade for Apple OSes.
 *
 * @param storage The storage facade to use to store the encrypted values.
 * @param accessLevel The access level required to access the secure key.
 *
 * @return A secure storage facade.
 */
@Suppress("FunctionName")
suspend fun AppleSecureStorageFacade(
	storage: StorageFacade,
	accessLevel: Set<SecureKeyAccessLevel>,
): StorageFacade {
	val encryptionKey = getOrCreateSecretKey(SECRET_KEY, accessLevel)
	return EncryptedStorageFacade(storage, encryptionKey)
}

private suspend fun getOrCreateSecretKey(key: String, accessLevel: Set<SecureKeyAccessLevel>): AesKey<AesAlgorithm.CbcWithPkcs7Padding> {
	return getSecretKey(key) ?: createSecretKey(accessLevel, key)
}

@OptIn(ExperimentalForeignApi::class)
private suspend fun getSecretKey(key: String): AesKey<CbcWithPkcs7Padding>? {
	val query = CFDictionaryCreateMutable(
		allocator = kCFAllocatorDefault,
		capacity = 4,
		keyCallBacks = kCFTypeDictionaryKeyCallBacks.ptr,
		valueCallBacks = kCFTypeDictionaryValueCallBacks.ptr,
	)

	try {
		CFDictionaryAddValue(query, kSecClass, kSecClassKey)
		CFDictionaryAddValue(query, kSecAttrApplicationTag, CFBridgingRetain(key.toByteArray().toNSData()))
		CFDictionaryAddValue(query, kSecReturnData, kCFBooleanTrue)
		CFDictionaryAddValue(query, kSecMatchLimit, kSecMatchLimitOne)

		return memScoped {
			var item = alloc<CFDataRefVar>()

			when (SecItemCopyMatching(query, item.ptr.reinterpret())) {
				errSecSuccess -> {
					val data = item.value ?: throw SecureStorageException("Failed to get key data from CFDataRefVar")
					val bytes = data.toByteArray()
					defaultCryptoService.aes.loadKey(CbcWithPkcs7Padding, bytes)
				}

				errSecItemNotFound -> null
				else -> throw SecureStorageException("Failed to get key data")
			}
		}
	} finally {
		CFRelease(query)
	}
}

@OptIn(ExperimentalForeignApi::class)
private suspend fun createSecretKey(accessLevel: Set<SecureKeyAccessLevel>, key: String): AesKey<CbcWithPkcs7Padding> {

	val aesKey = defaultCryptoService.aes.generateKey(CbcWithPkcs7Padding)
	val bytes = defaultCryptoService.aes.exportKey(aesKey)

	val accessControlFlags: SecAccessControlCreateFlags =
		accessLevel.fold(0.toULong()) { acc, level -> acc or level.toSecAccessControlCreateFlags() }.let {
			if (accessLevel.size > 1) it or kSecAccessControlOr
			else it
		}

	val accessControl = SecAccessControlCreateWithFlags(
		allocator = kCFAllocatorDefault,
		protection = kSecAttrAccessibleWhenUnlocked,
		flags = accessControlFlags,
		error = null,
	) ?: throw SecureStorageException("Failed to create access control")

	try {
		val query = CFDictionaryCreateMutable(
			allocator = kCFAllocatorDefault,
			capacity = 4,
			keyCallBacks = kCFTypeDictionaryKeyCallBacks.ptr,
			valueCallBacks = kCFTypeDictionaryValueCallBacks.ptr,
		)

		try {
			CFDictionaryAddValue(query, kSecClass, kSecClassKey)
			CFDictionaryAddValue(query, kSecAttrApplicationTag, CFBridgingRetain(key.toByteArray().toNSData()))
			CFDictionaryAddValue(query, kSecValueData, CFBridgingRetain(bytes.toNSData()))
			CFDictionaryAddValue(query, kSecAttrAccessControl, accessControl)

			return when (SecItemAdd(query, null)) {
				errSecSuccess -> aesKey
				else -> throw SecureStorageException("Failed to generate key data")
			}
		} finally {
			CFRelease(query)
		}
	} finally {
		CFRelease(accessControl)
	}
}

private fun SecureKeyAccessLevel.toSecAccessControlCreateFlags(): SecAccessControlCreateFlags {
	return when (this) {
		SecureKeyAccessLevel.DevicePasscode -> kSecAccessControlDevicePasscode
		SecureKeyAccessLevel.Biometric -> kSecAccessControlBiometryAny
	}
}
