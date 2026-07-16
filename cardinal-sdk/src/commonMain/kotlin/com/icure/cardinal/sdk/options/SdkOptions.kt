package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.storage.KeyStorageFacade
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import io.ktor.client.HttpClient
import kotlinx.coroutines.Job
import kotlinx.serialization.json.Json
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

interface HttpSdkOptions {
	/**
	 * Specify which client to use for performing http requests (rest).
	 * You will be responsible for closing the client after you are done using the sdk.
	 *
	 * This client must support json serialization.
	 *
	 * If null an http client instance shared across all sdks will be used.
	 */
	val httpClient: HttpClient?
	/**
	 * The instance of [Json] used by the provided [httpClient] (leave null if [httpClient] is null).
	 * Note that this json is used only for handling serialization of entities from/to the backend and is not used for
	 * handling serialization of encrypted content.
	 */
	val httpClientJson: Json?
	/**
	 * Configure a global timeout for requests, overriding the configuration on [httpClient] if provided.
	 * The default timeout on the default http client is 60s
	 */
	val requestTimeout: Duration?
	/**
	 * Configures how requests should be retried in case of server errors or connection errors.
	 */
	val requestRetryConfiguration: RequestRetryConfiguration?
}

interface SerializationOptions {
	/**
	 * If true, on deserialization of data coming from the backend any field that is not present in the data model will
	 * be ignored.
	 *
	 * If false any unknown field will cause the deserialization to fail. This can happen if:
	 * - You are using data that was created using the legacy iCure typescript SDK (pre-cardinal).
	 * - A new field has been added to the data model, and a new version of your application already uses the new field,
	 *   but this instance still depends on an older version of the SDK.
	 *
	 * Note that updating an entity where some fields were ignored during deserialization will potentially result in
	 * data loss.
	 *
	 * If a custom [HttpSdkOptions.httpClientJson] is provided, this option must be unconfigured (null) or match the
	 * ignoreUnknownKeys configuration of that.
	 * If no [HttpSdkOptions.httpClientJson] is configured the default for this behaviour is disabled by default (strict
	 * by default).
	 */
	val ignoreUnknownFields: Boolean?
}

interface CommonSdkOptions : HttpSdkOptions, SerializationOptions {
	/**
	 * Specifies which fields should be encrypted for each entity, root or embedded.
	 * Normally this parameter should be automatically filled by the generated customized SDK.
	 */
	val encryptedFieldsOptions: EncryptedFieldsOptions?
	/**
	 * Service for encryption primitives
	 */
	val cryptoService: CryptoService
}

interface BoundSdkOptions : CommonSdkOptions {
	/**
	 * An instance of iCure SDK is initialized for working as a specific user in a single group.
	 * However, the user credentials may match multiple users in different groups (but at most one per group).
	 * If that is the case, this function will be used to pick the actual user for which the sdk will be initialized.
	 *
	 * This is mandatory in multi-group applications, where a single user could exist in multiple groups.
	 * If this parameter is null and the user credentials match multiple users the api initialisation will fail.
	 * In single-group applications this parameter won't be used, so it can be left as null.
	 */
	val groupSelector: GroupSelector?
	/**
	 * If not null the SDK will immediately set the data owner scope to the provided value after login.
	 */
	val dataOwnerScope: String?
}

/**
 * A function taking in input the information on all groups and user that some credentials can authenticate as, and
 * the group id of one of the input values.
 */
typealias GroupSelector = suspend (availableGroups: List<UserGroup>) -> String

data class AnonymousSdkOptions(
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val requestTimeout: Duration? = null,
	override val requestRetryConfiguration: RequestRetryConfiguration = RequestRetryConfiguration(),
	override val ignoreUnknownFields: Boolean? = null,
): HttpSdkOptions, SerializationOptions {
	init {
		validateHttpAndSerializationOptions()
	}
}

/**
 * Optional parameters used in teh conversion from a basic sdk to a full sdk.
 */
data class BasicToFullSdkOptions(
	/**
	 * Refer to [SdkOptions.useHierarchicalDataOwners]
	 */
	val useHierarchicalDataOwners: Boolean = true,
	/**
	 * Refer to [SdkOptions.createTransferKeys]
	 */
	val createTransferKeys: Boolean = true,
	/**
	 * Refer to [SdkOptions.autoCreateEncryptionKeyForExistingLegacyData]
	 */
	val autoCreateEncryptionKeyForExistingLegacyData: Boolean = false,
	/**
	 * Refer to [SdkOptions.keyStorage]
	 */
	val keyStorage: KeyStorageFacade? = null,
	/**
	 * Refer to [SdkOptions.cryptoStrategies]
	 */
	val cryptoStrategies: CryptoStrategies? = null,
	/**
	 * Refer to [SdkOptions.parentJob]
	 */
	val parentJob: Job? = null,
	/**
	 * Refer to [SdkOptions.unversionedEntitiesDecryptedJsonStrictness]
	 */
	val unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness? = null
)

data class SdkOptions(
	/**
	 * Has only effect when logging in as an hcp user.
	 *
	 * If true the api will be initialized in a hierarchical mode, where each data owner is considered to have access
	 * to all data of his parents (requires corresponding permission on the server side).
	 * In this case the sdk will also expect to have access to at least a key for each parent data owner of the current
	 * user.
	 *
	 * If false the api will ignore the data owner hierarchies.
	 * Each data owner is considered to have access only to data shared explicitly with him, and has access only to his
	 * own keys.
	 */
	val useHierarchicalDataOwners: Boolean = true,
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	/**
	 * If true (default) the sdk will automatically create the transfer keys for the current user if a new keypair is
	 * created.
	 */
	val createTransferKeys: Boolean = true,
	override val cryptoService: CryptoService = defaultCryptoService,
	override val groupSelector: GroupSelector? = null,
	/**
	 * Options to support the migration of data created using iCure versions from before 2018.
	 * Leave it as false (default) unless explicitly instructed to set it to true by the iCure team.
	 */
	val autoCreateEncryptionKeyForExistingLegacyData: Boolean = false,
	/**
	 * Implementation of key storage to use.
	 * If not provided the sdk will store the keys in the [StorageFacade] provided to the api initialization method.
	 */
	val keyStorage: KeyStorageFacade? = null,
	/**
	 * Custom crypto strategies. If not provided the sdk will use crypto strategies that:
	 * - Allow for the creation of a new key of the data owner
	 * - Do not use any custom key recovery solutions
	 * - Considers any keys recovered using iCure's recovery methods as unverified
	 * - Considers all public keys of other data owners as verified
	 * - Considers patients as anonymous data owners
	 */
	val cryptoStrategies: CryptoStrategies? = null,
	/**
	 * Sets a parent job to use in the sdk scope.
	 * When that job is canceled, the SDK scope which runs all background tasks will also be canceled.
	 * The SDK shouldn't be used anymore after this job is canceled.
	 */
	val parentJob: Job? = null,
	override val requestTimeout: Duration? = null,
	override val requestRetryConfiguration: RequestRetryConfiguration = RequestRetryConfiguration(),
	override val dataOwnerScope: String? = null,
	override val ignoreUnknownFields: Boolean? = null,
	override val encryptedFieldsOptions: EncryptedFieldsOptions? = null,
	/**
	 * Specifies how strict json decoding should be when decoding the encrypted content of an entity that is not using
	 * the versioned data model (created before cardinal 3.0). For all entities that are already using the versioned
	 * data model the decoding is always equivalent to [DecryptedJsonStrictness.IgnoreBadValues].
	 *
	 * We recommend to use [DecryptedJsonStrictness.Strict]:
	 * - If your application does not depend on data coming from the legacy iCure typescript SDK then your application
	 *   will not have content that is invalid for cardinal
	 * - If your application uses data from the legacy iCure typescript SDK AND that data is not fully supported by
	 *   cardinal you can detect it before potentially destroying part of its content. A future version of cardinal
	 *   will allow you to specify a "patcher" that can modify the encrypted content before cardinal tries to interpret
	 *   it so that you can migrate the existing data to a format understandable by cardinal.
	 *
	 * When [ignoreUnknownFields] is false or defaults to false then this defaults to [DecryptedJsonStrictness.Strict],
	 * else it defaults to [DecryptedJsonStrictness.IgnoreUnknownFields].
	 *
	 * It is still possible to override the default with any value of [DecryptedJsonStrictness] regardless of the value
	 * of [ignoreUnknownFields].
	 */
	val unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness? = null,
): BoundSdkOptions {
	init {
		validateHttpAndSerializationOptions()
	}
}

data class BasicSdkOptions(
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val cryptoService: CryptoService = defaultCryptoService,
	override val groupSelector: GroupSelector? = null,
	override val requestTimeout: Duration? = null,
	override val requestRetryConfiguration: RequestRetryConfiguration = RequestRetryConfiguration(),
	override val dataOwnerScope: String? = null,
	override val ignoreUnknownFields: Boolean? = null,
	override val encryptedFieldsOptions: EncryptedFieldsOptions? = null,
): BoundSdkOptions {
	init {
		validateHttpAndSerializationOptions()
	}
}

data class UnboundBasicSdkOptions(
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val cryptoService: CryptoService = defaultCryptoService,
	/**
	 * Some basic SDK methods require as context the group where the SDK is acting on.
	 *
	 * Since for unbound SDK the group could change at each request, by default, these methods aren't supported on
	 * unbound SDK instances.
	 *
	 * However, if it is possible for you to extract the group id from the context of the coroutine that is executing
	 * the method, you can provide the function here to allow using these methods also on unbound SDK.
	 */
	val getBoundGroupId: (CoroutineContext) -> String? = { null },
	override val requestTimeout: Duration? = null,
	override val requestRetryConfiguration: RequestRetryConfiguration = RequestRetryConfiguration(),
	override val ignoreUnknownFields: Boolean? = null,
	override val encryptedFieldsOptions: EncryptedFieldsOptions? = null,
): CommonSdkOptions {
	init {
		validateHttpAndSerializationOptions()
	}
}

/**
 * Configures how requests should be retried.
 */
data class RequestRetryConfiguration(
	/**
	 * How many times the request will be retried in case of issues.
	 * Must be >= 0 where 0 means the requests will never be retried.
	 */
	val maxRetries: Int = 3,
	/**
	 * Minimum delay between the first failed request and first retry.
	 */
	val initialDelay: Duration = 2.seconds,
	/**
	 * Factor applied to the milliseconds value of the [initialDelay] in case of multiple failed requests.
	 * For example in a configuration with [initialDelay] 2 seconds and [exponentialBackoffFactor] 2.0 the time
	 * between requests will be 2 s, 4 s, 8 s, and so on, until the request succeeds or [maxRetries] is reached.
	 *
	 * Note the backoff is applied on a per-request basis. Different requests calculate their delays independently of
	 * any other failed or successful request.
	 */
	val exponentialBackoffFactor: Double = 2.0,
	/**
	 * Provides a hard limit to the exponential backoff delay.
	 * For example in a configuration with [initialDelay] 2 seconds, [exponentialBackoffFactor] 2.0 and
	 * [exponentialBackoffCeil] 10 seconds the time between requests will be 2 s, 4 s, 8 s, and 10 seconds for all
	 * remaining requests.
	 * Must be >= initialDelay or null
	 */
	val exponentialBackoffCeil: Duration? = null
) {
	init {
		require(maxRetries >= 0) {
			"`maxRetries` must be >= 0"
		}
		require(exponentialBackoffFactor > 0) {
			"`exponentialBackoffFactor` must be positive"
		}
		require(exponentialBackoffCeil == null || exponentialBackoffCeil.inWholeMilliseconds >= initialDelay.inWholeMilliseconds) {
			"`exponentialBackoffCeil` must be >= `exponentialBackoffFactor`"
		}
	}
}

internal fun <T> T.configuredClientOrDefault() where T : HttpSdkOptions, T : SerializationOptions =
	this.httpClient ?: (if (this.ignoreUnknownFields == true) CardinalSdk.sharedHttpClientUsingLenientJson else CardinalSdk.sharedHttpClient)
internal fun <T> T.configuredJsonOrDefault() where T : HttpSdkOptions, T : SerializationOptions =
	this.httpClientJson ?: (if (this.ignoreUnknownFields == true) Serialization.lenientJson else Serialization.json)
internal fun <T> T.ignoreUnknownFieldsOrDefault() where T : HttpSdkOptions, T : SerializationOptions =
	this.ignoreUnknownFields ?: this.httpClientJson?.configuration?.ignoreUnknownKeys ?: false
internal fun unversionedEntitiesDecryptedJsonStrictnessOrDefault(strictness: DecryptedJsonStrictness?, ignoreUnknownFields: Boolean) =
	strictness ?:
		if (ignoreUnknownFields)
			DecryptedJsonStrictness.IgnoreUnknownFields
		else
			DecryptedJsonStrictness.Strict

private fun <T> T.validateHttpAndSerializationOptions() where T : HttpSdkOptions, T : SerializationOptions {
	if (httpClient != null) {
		require (httpClientJson != null) {
			"When providing a custom httpClient you must also provide the json serializer to use."
		}
	} else {
		require (httpClientJson == null) {
			"httpClientJson should be provided only if you provide a httpClient."
		}
	}

	if (ignoreUnknownFields != null) {
		require (httpClientJson?.configuration?.ignoreUnknownKeys?.let { it == ignoreUnknownFields } ?: true) {
			"ignoreUnknownFields must match the ignoreUnknownKeys configuration of the provided json serializer."
		}
	}
}