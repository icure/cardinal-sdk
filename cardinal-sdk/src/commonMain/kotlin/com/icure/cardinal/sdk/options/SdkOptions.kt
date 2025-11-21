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
import kotlinx.serialization.Serializable
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
	 */
	val httpClientJson: Json?
	/**
	 * If true the SDK will use lenient deserialization of the entities coming from the backend.
	 *
	 * This could be helpful when developing using the nightly deployments of the backend, as the SDK will ignore minor changes to the data model.
	 *
	 * This option however could cause loss of data when connecting with incompatible versions of the backend, and should be disabled in production.
	 */
	val lenientJson: Boolean
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

interface CommonSdkOptions : HttpSdkOptions {
	/**
	 * Configure which fields of entities should be encrypted
	 */
	val encryptedFields: EncryptedFieldsConfiguration
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
}

/**
 * A function taking in input the information on all groups and user that some credentials can authenticate as, and
 * the group id of one of the input values.
 */
typealias GroupSelector = suspend (availableGroups: List<UserGroup>) -> String

data class AnonymousSdkOptions(
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val lenientJson: Boolean = false,
	override val requestTimeout: Duration? = null,
	override val requestRetryConfiguration: RequestRetryConfiguration = RequestRetryConfiguration()
): HttpSdkOptions

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
	 * Refer to [SdkOptions.jsonPatcher]
	 */
	val jsonPatcher: JsonPatcher? = null,
	/**
	 * Refer to [SdkOptions.parentJob]
	 */
	val parentJob: Job? = null,
)

data class SdkOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
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
	 * Patcher for the decrypted entities json.
	 * This allows adapting to changes in the data model of entities even if the changes are done to the encrypted part
	 * of the entity.
	 */
	val jsonPatcher: JsonPatcher? = null,
	override val lenientJson: Boolean = false,
	/**
	 * Sets a parent job to use in the sdk scope.
	 * When that job is canceled, the SDK scope which runs all background tasks will also be canceled.
	 * The SDK shouldn't be used anymore after this job is canceled.
	 */
	val parentJob: Job? = null,
	override val requestTimeout: Duration? = null,
	override val requestRetryConfiguration: RequestRetryConfiguration = RequestRetryConfiguration(),
): BoundSdkOptions {
	init {
		if (httpClientJson != null) {
			require(httpClient != null) {
				"httpClient should be provided if httpClientJson is provided"
			}
		}

		if (lenientJson) {
			require(httpClient == null) {
				"Cannot use lenientJson with a custom httpClient"
			}
		}
	}
}

data class BasicSdkOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val cryptoService: CryptoService = defaultCryptoService,
	override val groupSelector: GroupSelector? = null,
	override val lenientJson: Boolean = false,
	override val requestTimeout: Duration? = null,
	override val requestRetryConfiguration: RequestRetryConfiguration = RequestRetryConfiguration(),
): BoundSdkOptions {
	init {
		if (httpClientJson != null) {
			require(httpClient != null) {
				"httpClient should be provided if httpClientJson is provided"
			}
		}

		if (lenientJson) {
			require(httpClient == null) {
				"Cannot use lenientJson with a custom httpClient"
			}
		}
	}
}

data class UnboundBasicSdkOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val cryptoService: CryptoService = defaultCryptoService,
	override val lenientJson: Boolean = false,
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
): CommonSdkOptions {
	init {
		if (httpClientJson != null) {
			require(httpClient != null) {
				"httpClient should be provided if httpClientJson is provided"
			}
		}

		if (lenientJson) {
			require(httpClient == null) {
				"Cannot use lenientJson with a custom httpClient"
			}
		}
	}
}

@Serializable
data class EncryptedFieldsConfiguration(
	val accessLog: Set<String> = setOf(
		"detail",
		"objectId",
		"patientId"
	),
	val calendarItem: Set<String> = setOf(
		"details",
		"title",
		"patientId",
		"phoneNumber",
		"address",
		"addressText",
		"meetingTags[].*",
		"flowItem"
	),
	val contact: Set<String> = setOf(
		"descr",
		"notes[].markdown",
		"location",
		"encounterLocation",
		"participants",
	),
	val service: Set<String> = setOf(
		"notes[].markdown",
		"comment",
	),
	val healthElement: Set<String> = setOf(
		"descr",
		"note",
		"notes[].markdown",
		"careTeam[].*",
		"episode[].name",
		"episode[].comment"
	),
	val maintenanceTask: Set<String> = setOf(
		"properties",
	),
	val patient: Set<String> = setOf(
		"note",
		"notes[].markdown",
		"created",
		"modified",
		"companyName",
		"languages",
		"civility",
		"birthSex",
		"personalStatus",
		"nationality",
		"race",
		"ethnicity",
		"picture",
		"insurabilities[].*",
		"partnerships[].*",
		"patientHealthCareParties[].*",
		"financialInstitutionInformation[].*",
		"medicalHouseContracts[].*",
		"patientProfessions",
		"comment",
		"warning",
		"fatherBirthCountry",
		"birthCountry",
		"nativeCountry",
		"socialStatus",
		"mainSourceOfIncome",
		"schoolingInfos[].*",
		"employementInfos[].*",
	),
	val message: Set<String> = setOf(
		"subject"
	),
	val topic: Set<String> = setOf(
		"description",
		"linkedServices",
		"linkedHealthElements"
	),
	val document: Set<String> = setOf(
		"medicalLocationId",
		"name"
	),
	val form: Set<String> = setOf(
		"descr"
	),
	val receipt: Set<String> = setOf(
		"references"
	),
	val classification: Set<String> = setOf(
		"label"
	),
	val timeTable: Set<String> = emptySet(),
	val invoice: Set<String> = setOf(
		"reason"
	),
)

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

internal fun HttpSdkOptions.configuredClientOrDefault() = this.httpClient ?: (if (this.lenientJson) CardinalSdk.sharedHttpClientUsingLenientJson else CardinalSdk.sharedHttpClient)
internal fun HttpSdkOptions.configuredJsonOrDefault() = this.httpClientJson ?: (if (this.lenientJson) Serialization.lenientJson else Serialization.json)
