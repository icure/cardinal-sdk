@file:OptIn(ExperimentalJsExport::class)

package com.icure.cardinal.sdk.exceptions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Base exception for all user-actionable errors that occur during secure storage operations
 * (key generation, encryption, decryption, keychain/keystore access).
 *
 * This exception and its subclasses represent failures that the SDK consumer can potentially
 * recover from by taking an appropriate action (e.g. re-authenticating, clearing storage,
 * changing configuration).
 *
 * Callers can catch this base class to handle all secure storage failures uniformly, or catch
 * specific subclasses to implement targeted recovery strategies:
 * - [SecureStorageCorruptedException]: storage is inconsistent, clear and re-initialize
 * - [SecureStorageKeyInvalidatedException]: key is permanently lost, re-enroll
 * - [SecureStorageCryptoException]: authentication required, prompt user and retry
 * - [SecureStorageConfigurationException]: invalid configuration for device, adjust settings
 *
 * @param message A human-readable description of the failure, including platform-specific
 *   details (e.g. OSStatus codes on Apple, exception class names on Android).
 * @param cause The underlying platform exception, if any. On Android this may be a
 *   `android.security.keystore.UserNotAuthenticatedException` or
 *   `android.security.keystore.KeyPermanentlyInvalidatedException`. On Apple, the cause is
 *   typically null since Keychain APIs return OSStatus codes rather than throwing exceptions.
 */
@JsExport
open class SecureStorageException(message: String, cause: Throwable? = null) : Exception(message, cause)

/**
 * Thrown when the secure storage is in an inconsistent state: the encrypted key data stored
 * via [com.icure.cardinal.sdk.storage.StorageFacade] is out of sync with the platform keystore/keychain.
 *
 * This can happen when:
 * - **Android**: The app's storage contains an IV or cipher text but not both
 *   (e.g. the app was killed during a write), or the storage has encrypted data but
 *   the Android KeyStore no longer contains the corresponding wrapping key (e.g. the keystore
 *   was cleared independently of the app's storage).
 * - **Apple**: Not currently applicable, the key is stored directly in the Keychain without
 *   a separate local storage component.
 *
 * **Recovery**: Clear the secure storage entries and re-initialize the SDK. This will generate
 * a new encryption key. Any data encrypted with the previous key will be unrecoverable.
 */
@JsExport
class SecureStorageCorruptedException(message: String, cause: Throwable? = null) : SecureStorageException(message, cause)

/**
 * Thrown when the cryptographic key used for secure storage has been permanently invalidated
 * by the operating system and can no longer be used for any operations.
 *
 * This can happen when:
 * - **Android**: The user changed their biometric enrollment (added/removed fingerprint or face),
 *   changed their device lock (PIN/password/pattern), or the device security policy changed.
 *   The underlying cause will be a `android.security.keystore.KeyPermanentlyInvalidatedException`.
 * - **Apple**: The Keychain item's access control constraints can no longer be satisfied
 *   (e.g. biometric data was reset).
 *
 * **Recovery**: Delete the invalidated key, clear the associated secure storage entries, and
 * re-create the key from scratch. The user will need to re-enroll or re-provision any secrets
 * that were protected by the old key.
 */
@JsExport
class SecureStorageKeyInvalidatedException(message: String, cause: Throwable? = null) : SecureStorageException(message, cause)

/**
 * Thrown when a cryptographic operation (encrypt/decrypt) or keychain/keystore access failed
 * because the user has not authenticated, or their authentication has expired.
 *
 * This can happen when:
 * - **Android**: The key requires user authentication (biometric or device credential) and the
 *   authentication validity period has expired. The underlying cause will be a
 *   `android.security.keystore.UserNotAuthenticatedException`.
 * - **Apple**: The Keychain operation returned `errSecAuthFailed` (authentication failed),
 *   `errSecInteractionNotAllowed` (user interaction required but not possible, e.g. app is in
 *   background or device is locked), or `errSecUserCanceled` (user dismissed the auth prompt).
 *
 * **Recovery**: Prompt the user to authenticate via the appropriate mechanism (BiometricPrompt
 * on Android, LAContext on Apple), then retry the operation. On Apple, if the error is
 * `errSecInteractionNotAllowed`, ensure the operation runs while the app is in the foreground
 * and the device is unlocked.
 *
 * On Apple, the [message] includes the `OSStatus` code for debugging purposes.
 */
@JsExport
class SecureStorageCryptoException(message: String, cause: Throwable? = null) : SecureStorageException(message, cause)

/**
 * Thrown when the secure storage configuration is invalid for the current device.
 *
 * This can happen when:
 * - **Apple**: `SecAccessControlCreateWithFlags` returned null because the requested
 *   [com.icure.cardinal.sdk.storage.SecureKeyAccessLevel] combination is not supported by
 *   the device hardware. For example, requesting biometric on a device that has no biometric
 *   sensor, or requesting a combination of access levels that the Secure Enclave does not support.
 * - **Android**: The `KeyGenParameterSpec` specifies authentication parameters that the device
 *   cannot satisfy (less common — Android typically throws at key-use time, not at config time).
 *
 * **Recovery**: Change the access level set passed to the secure storage factory function to
 * match the device's capabilities. For example, fall back to device passcode if biometric is
 * unavailable.
 */
@JsExport
class SecureStorageConfigurationException(message: String, cause: Throwable? = null) : SecureStorageException(message, cause)
