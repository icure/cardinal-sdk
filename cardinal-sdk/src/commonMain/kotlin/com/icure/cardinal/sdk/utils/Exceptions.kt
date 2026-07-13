package com.icure.cardinal.sdk.utils

import com.icure.utils.InternalIcureApi
import io.ktor.http.HttpMethod
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.reflect.KClass

/**
 * Exception thrown when a certain resource is not found.
 * @param resourceId An identifier that does not match some expected resource. The format of this identifier depends on
 * the resource type.
 * @param resourceClass The type of the missing resource that was not found.
 */
class ResourceNotFoundException(
	val resourceId: String,
	val resourceClass: KClass<*>
) : Exception("Resource $resourceId of type ${resourceClass.simpleName} not found")

/**
 * Exception thrown when a retrieved entity does not conform to the expected format.
 */
class IllegalEntityException(message: String, cause: Throwable? = null) : Exception(message, cause)

/**
 * A common supertype for errors that occurred during the decryption, encryption, or encryption validation
 * of an entity.
 * @param message a human-readable message describing the error.
 * @param cause if this was triggered by another error that error (may provide additional details).
 */
sealed class EntityEncryptionException(
	message: String,
	cause: Throwable? = null
) : Exception(
	message,
	cause
)

/**
 * The entity or related content can't be decrypted or encrypted because this instance of the SDK can't access the
 * encryption key of the entity.
 *
 * This can happen, for example, if:
 * - The entity was not shared with the user of this cardinal SDK
 * - This instance of cardinal SDK does not have access to the private key of the user that is required for the
 *   decryption of the entity.
 */
class UnavailableEncryptionKeyException(
	message: String,
	cause: Throwable? = null
) : EntityEncryptionException(
	message,
	cause
)

/**
 * This instance of the SDK is able to decrypt one or more keys of the entity, but the entity contains at least
 * some encrypted content that can't be decrypted using the provided key.
 *
 * This could happen for example if:
 * - The entity is a result of a merge between different entities, and there are now multiple encryption keys
 *   associated to this entity. The user does not have access to all the keys and can't decrypt at least a
 *   part of the entity.
 * - A user intentionally created a new entity with invalid encrypted content
 * - A user with write access to an existing entity intentionally replaced the encrypted content with invalid
 *   data.
 */
class UndecryptableContentException(
	message: String,
	cause: Throwable? = null
) : EntityEncryptionException(
	message,
	cause
)


/**
 * This instance of the SDK is able to decrypt and parse the encrypted structured content of the entity, but the
 * decrypted content does not match the expected structure, for example:
 * - The decrypted content contains data fields that the SDK does not know of
 * - The decrypted content contains a known data field, but the type is not what the SDK expects, or the SDK can't
 *   decode to the known type.
 *
 * This could happen for example if:
 * - The entity was created with the legacy iCure SKD (predating-cardinal) and the encrypted content was not migrated
 * - A user intentionally created a new entity or modified an existing entity with invalid encrypted content
 */
class UnexpectedEncryptedContentException(
	message: String,
	cause: Throwable? = null
) : EntityEncryptionException(
	message,
	cause
)

class RequestStatusException(
	val requestMethod: HttpMethod,
	val url: String,
	val statusCode: Int,
	val body: String?
) : Exception(
	"Request $requestMethod $url failed with status code $statusCode${if (body == null) "" else " ($body)"}"
)

class UnexpectedResponseContentException(message: String) : Exception(message)

/**
 * Represents a failure in the iCure SDK implementation. This exception is thrown in case of unexpected behaviours which
 * are most likely caused by bugs in the SDK. If you encounter this exception, please report it to the iCure team.
 */
class InternalCardinalException(message: String, cause: Throwable? = null) : Exception(message, cause)

/**
 * Checks an invariant at runtime. If value is not true there is an implementation error on iCure's side.
 */
@OptIn(ExperimentalContracts::class)
@InternalIcureApi
inline fun ensure(value: Boolean, lazyMessage: () -> String) {
	contract {
		returns() implies value
	}
	if (!value) {
		throw InternalCardinalException(lazyMessage())
	}
}

@OptIn(ExperimentalContracts::class)
@InternalIcureApi
inline fun <T> ensureNonNull(value: T?, lazyMessage: () -> String): T {
	contract {
		returns() implies (value != null)
	}
	if (value == null) {
		throw InternalCardinalException(lazyMessage())
	} else return value
}


@OptIn(ExperimentalContracts::class)
@InternalIcureApi
inline fun validateResponseContent(
	isValid: Boolean,
	lazyMessage: () -> String
) {
	contract {
		returns() implies isValid
	}
	if (!isValid) {
		throw UnexpectedResponseContentException(lazyMessage())
	}
}

