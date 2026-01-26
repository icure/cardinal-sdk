package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.api.AccessLogApi
import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.api.AuthApi
import com.icure.cardinal.sdk.api.CalendarItemApi
import com.icure.cardinal.sdk.api.CalendarItemTypeApi
import com.icure.cardinal.sdk.api.CardinalMaintenanceTaskApi
import com.icure.cardinal.sdk.api.CodeApi
import com.icure.cardinal.sdk.api.ContactApi
import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.DeviceApi
import com.icure.cardinal.sdk.api.DocumentApi
import com.icure.cardinal.sdk.api.DocumentTemplateApi
import com.icure.cardinal.sdk.api.EntityReferenceApi
import com.icure.cardinal.sdk.api.EntityTemplateApi
import com.icure.cardinal.sdk.api.FormApi
import com.icure.cardinal.sdk.api.FrontEndMigrationApi
import com.icure.cardinal.sdk.api.GroupApi
import com.icure.cardinal.sdk.api.HealthElementApi
import com.icure.cardinal.sdk.api.HealthcarePartyApi
import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.InvoiceApi
import com.icure.cardinal.sdk.api.KeywordApi
import com.icure.cardinal.sdk.api.MaintenanceTaskApi
import com.icure.cardinal.sdk.api.MedicalLocationApi
import com.icure.cardinal.sdk.api.MessageApi
import com.icure.cardinal.sdk.api.PatientApi
import com.icure.cardinal.sdk.api.PermissionApi
import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.api.ReceiptApi
import com.icure.cardinal.sdk.api.RecoveryApi
import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.api.SystemApi
import com.icure.cardinal.sdk.api.TarificationApi
import com.icure.cardinal.sdk.api.TimeTableApi
import com.icure.cardinal.sdk.api.TopicApi
import com.icure.cardinal.sdk.api.UserApi
import com.icure.cardinal.sdk.api.impl.AgendaApiImpl
import com.icure.cardinal.sdk.api.impl.AuthApiImpl
import com.icure.cardinal.sdk.api.impl.CalendarItemTypeApiImpl
import com.icure.cardinal.sdk.api.impl.CardinalMaintenanceTaskApiImpl
import com.icure.cardinal.sdk.api.impl.CodeApiImpl
import com.icure.cardinal.sdk.api.impl.CryptoApiImpl
import com.icure.cardinal.sdk.api.impl.DataOwnerApiImpl
import com.icure.cardinal.sdk.api.impl.DeviceApiImpl
import com.icure.cardinal.sdk.api.impl.DocumentTemplateApiImpl
import com.icure.cardinal.sdk.api.impl.EntityReferenceApiImpl
import com.icure.cardinal.sdk.api.impl.EntityTemplateApiImpl
import com.icure.cardinal.sdk.api.impl.FormApiImpl
import com.icure.cardinal.sdk.api.impl.FrontEndMigrationApiImpl
import com.icure.cardinal.sdk.api.impl.GroupApiImpl
import com.icure.cardinal.sdk.api.impl.HealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.impl.InsuranceApiImpl
import com.icure.cardinal.sdk.api.impl.InvoiceApiImpl
import com.icure.cardinal.sdk.api.impl.KeywordApiImpl
import com.icure.cardinal.sdk.api.impl.MaintenanceTaskApiImpl
import com.icure.cardinal.sdk.api.impl.MedicalLocationApiImpl
import com.icure.cardinal.sdk.api.impl.MessageApiImpl
import com.icure.cardinal.sdk.api.impl.PermissionApiImpl
import com.icure.cardinal.sdk.api.impl.PlaceApiImpl
import com.icure.cardinal.sdk.api.impl.ReceiptApiImpl
import com.icure.cardinal.sdk.api.impl.RecoveryApiImpl
import com.icure.cardinal.sdk.api.impl.RoleApiImpl
import com.icure.cardinal.sdk.api.impl.ShamirKeysManagerApiImpl
import com.icure.cardinal.sdk.api.impl.SystemApiImpl
import com.icure.cardinal.sdk.api.impl.TarificationApiImpl
import com.icure.cardinal.sdk.api.impl.TimeTableApiImpl
import com.icure.cardinal.sdk.api.impl.TopicApiImpl
import com.icure.cardinal.sdk.api.impl.UserApiImpl
import com.icure.cardinal.sdk.api.impl.initAccessLogApi
import com.icure.cardinal.sdk.api.impl.initCalendarItemApi
import com.icure.cardinal.sdk.api.impl.initContactApi
import com.icure.cardinal.sdk.api.impl.initDocumentApi
import com.icure.cardinal.sdk.api.impl.initHealthElementApi
import com.icure.cardinal.sdk.api.impl.initPatientApi
import com.icure.cardinal.sdk.api.raw.RawAnonymousAuthApi
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAccessLogApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawAgendaApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCalendarItemApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCalendarItemTypeApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawClassificationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCodeApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawContactApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDataOwnerApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDeviceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDocumentApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDocumentTemplateApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawEntityReferenceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawEntityTemplateApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawExchangeDataApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawExchangeDataMapApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawFormApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawFrontEndMigrationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthElementApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawICureApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawInsuranceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawInvoiceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawKeywordApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawMaintenanceTaskApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawMedicalLocationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawMessageApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPermissionApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPlaceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawReceiptApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawRecoveryDataApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawRoleApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawSecureDelegationKeyMapApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTarificationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTimeTableApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTopicApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.cardinal.sdk.auth.AuthenticationProcessTemplateParameters
import com.icure.cardinal.sdk.auth.CaptchaOptions
import com.icure.cardinal.sdk.auth.JwtBearer
import com.icure.cardinal.sdk.auth.JwtCredentials
import com.icure.cardinal.sdk.auth.JwtRefresh
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.impl.AccessControlKeysHeadersProviderImpl
import com.icure.cardinal.sdk.crypto.impl.BaseExchangeDataManagerImpl
import com.icure.cardinal.sdk.crypto.impl.BaseExchangeKeysManagerImpl
import com.icure.cardinal.sdk.crypto.impl.BaseSecurityMetadataDecryptorImpl
import com.icure.cardinal.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.cardinal.sdk.crypto.impl.CachedLruExchangeDataManager
import com.icure.cardinal.sdk.crypto.impl.CardinalKeyRecoveryImpl
import com.icure.cardinal.sdk.crypto.impl.DelegationsDeAnonymizationImpl
import com.icure.cardinal.sdk.crypto.impl.EntityEncryptionServiceImpl
import com.icure.cardinal.sdk.crypto.impl.ExchangeDataMapManagerImpl
import com.icure.cardinal.sdk.crypto.impl.ExchangeKeysManagerImpl
import com.icure.cardinal.sdk.crypto.impl.FullyCachedExchangeDataManager
import com.icure.cardinal.sdk.crypto.impl.IncrementalSecurityMetadataDecryptorImpl
import com.icure.cardinal.sdk.crypto.impl.InternalCryptoApiImpl
import com.icure.cardinal.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.cardinal.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.impl.RecoveryDataEncryptionImpl
import com.icure.cardinal.sdk.crypto.impl.SecureDelegationsEncryptionImpl
import com.icure.cardinal.sdk.crypto.impl.SecureDelegationsManagerImpl
import com.icure.cardinal.sdk.crypto.impl.ShamirSecretSharingService
import com.icure.cardinal.sdk.crypto.impl.TransferKeysManagerImpl
import com.icure.cardinal.sdk.crypto.impl.UserEncryptionKeysManagerImpl
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.LoginCredentials
import com.icure.cardinal.sdk.model.extensions.asStub
import com.icure.cardinal.sdk.model.extensions.type
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.ApiConfigurationImpl
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.EncryptedFieldsConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.options.RequestRetryConfiguration
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.options.configuredClientOrDefault
import com.icure.cardinal.sdk.options.configuredJsonOrDefault
import com.icure.cardinal.sdk.options.getGroupAndAuthProvider
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.cardinal.sdk.storage.KeyStorageFacade
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.cardinal.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.newPlatformHttpClient
import com.icure.cardinal.sdk.utils.retryWithDelays
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

interface CardinalSdk : CardinalApis {
	/**
	 * The id of the group this SDK is bound to. Always `null` when working with kraken-lite instances.
	 */
	val boundGroupId: String?

	/**
	 * Represents an intermediate stage in the initialization of an SDK through an authentication process
	 * The initialization can complete only after the user provides the validation code received via email/sms.
	 */
	interface AuthenticationWithProcessStep {
		/**
		 * Complete the authentication of the user and finishes the initialization of the SDK.
		 * In case the provided validation code is wrong this method will throw an exception, but it is still possible
		 * to call to re-attempt authentication by calling this method with a different validation code.
		 */
		suspend fun completeAuthentication(validationCode: String): CardinalSdk
	}

	/**
	 * Get a new sdk using the same configurations and user authentication methods but for a different group.
	 * To use this method, the authentication method provided at initialization of this sdk must be valid also for the
	 * new group.
	 *
	 * Note that the switched sdk will reuse components like the http client.
	 * Don't close the client of this sdk while you are using the new sdk.
	 *
	 * @param groupId the id of the new group to switch to
	 * @return a new sdk for executing requests in the provided group
	 */
	suspend fun switchGroup(groupId: String): CardinalSdk

	/**
	 * Get a new instance of the sdk associated to a data owner that may be different from the one linked to the logged
	 * user.
	 *
	 * You need appropriate permissions and access to the keys of the data owner.
	 *
	 * Note that the switched sdk will reuse components like the http client.
	 * Don't close the client of this sdk while you are using the new sdk.
	 *
	 * @param dataOwnerId id of the data owner to use in the new sdk
	 * @return a new sdk for executing requests as the provided data owner
	 */
	suspend fun changeScope(dataOwnerId: String): CardinalSdk

	/**
	 * Exposes the scope used by the SDK to perform background tasks.
	 * Should be canceled when the SDK is not needed anymore.
	 */
	val scope: CoroutineScope

	companion object {
		private fun createHttpClient(json: Json): HttpClient {
			return newPlatformHttpClient {
				install(ContentNegotiation) {
					json(json = json)
				}
				install(HttpTimeout) {
					requestTimeoutMillis = 60_000
				}
				install(WebSockets)
			}
		}

		/**
		 * A shared http client to use as the default across all instances of iCure.
		 * Initialized only when needed.
		 * Previous versions of the icure SDK (in different languages) did not need explicit disposal, but this is
		 * necessary in the multiplatform sdk. The use of this shared client allows to minimise the resource leaking
		 * when creating multiple instances of the iCure API without proper disposal of the client.
		 */
		internal val sharedHttpClient by lazy {
			createHttpClient(Serialization.json)
		}

		/**
		 * A shared http client to use as the default across all instances of iCure.
		 * Initialized only when needed.
		 * Previous versions of the icure SDK (in different languages) did not need explicit disposal, but this is
		 * necessary in the multiplatform sdk. The use of this shared client allows to minimise the resource leaking
		 * when creating multiple instances of the iCure API without proper disposal of the client.
		 */
		internal val sharedHttpClientUsingLenientJson by lazy {
			createHttpClient(Serialization.lenientJson)
		}

		/**
		 * Close the default http client used for api instances. You should call this method if you want to gracefully
		 * shut down your application, and you have created at least one instance of the iCure API without providing
		 * your own instance of http client.
		 * Not closing the client will prevent the application from terminating (even if the main method terminated).
		 *
		 * Note: closing the client will cause any existing and future api instances that are using the default client
		 * to become unusable, as there is a shared default client used across all instances of the Api. Call this
		 * method only when you want to shut down the application.
		 */
		fun closeSharedClient() {
			sharedHttpClient.close()
			sharedHttpClientUsingLenientJson.close()
		}

		/**
		 * Initialize a new instance of the icure sdk for a specific user.
		 *
		 * @param projectId a string to uniquely identify your iCure project.
		 * @param baseUrl the url of the iCure backend to use
		 * @param authenticationMethod specifies how the sdk should authenticate.
		 * @param baseStorage an implementation of the [StorageFacade], used for persistent storage of various
		 * information including the user keys if [SdkOptions.keyStorage] is not provided.
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@OptIn(InternalIcureApi::class)
		suspend fun initialize(
			projectId: String?,
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			baseStorage: StorageFacade,
			options: SdkOptions = SdkOptions()
		): CardinalSdk {
			val client = options.configuredClientOrDefault()
			val json = options.configuredJsonOrDefault()
			val cryptoService = options.cryptoService
			val (chosenGroupId, authProvider) = authenticationMethod.getGroupAndAuthProvider(
				baseUrl = baseUrl,
				apiUrl = baseUrl,
				cryptoService = cryptoService,
				projectId = projectId,
				options = options,
				rawApiConfig = RawApiConfig(
					httpClient = client,
					additionalHeaders = emptyMap(),
					requestTimeout = options.requestTimeout,
					json = json,
					retryConfiguration = options.requestRetryConfiguration
				)
			)
			val initializedSdkOptions = options.asInitialized(baseStorage)
			val (initializedCrypto, newKey, scope) = initializeApiCrypto(
				baseUrl,
				authProvider,
				client,
				json,
				options.cryptoStrategies,
				cryptoService,
				chosenGroupId,
				initializedSdkOptions,
			)
			return CardinalSdkImpl(
				authProvider,
				initializedCrypto,
				initializedSdkOptions,
				chosenGroupId,
				scope
			).also { initializedCrypto.notifyNewKeyIfAny(it, newKey) }
		}

		/**
		 * Initialize a new instance of the icure sdk for a specific user.
		 * The authentication will be performed through an authentication process.
		 *
		 * @param projectId a string to uniquely identify your iCure project.
		 * @param baseUrl the url of the iCure backend to use
		 * @param messageGatewayUrl the url of the iCure message gateway you want to use. Usually this should be
		 * @param externalServicesSpecId an identifier that allows the message gateway to connect the request to your
		 * services for email / sms communication of the process tokens.
		 * @param processId the id of the process you want to execute.
		 * @param userTelecomType the type of telecom number used for the user.
		 * @param userTelecom the telecom number of the user for which you want to execute the process. This should be an
		 * email address or phone number depending on the type of process you are executing.
		 * @param captcha Captcha options for authentication. This is used to prevent abuse of the message gateway and
		 * connected external services.
		 * @param baseStorage an implementation of the [StorageFacade], used for persistent storage of various
		 * information including the user keys if [SdkOptions.keyStorage] is not provided.
		 * @param authenticationProcessTemplateParameters optional parameters which may be used by sms/email templates.
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@OptIn(InternalIcureApi::class)
		suspend fun initializeWithProcess(
			projectId: String?,
			baseUrl: String,
			messageGatewayUrl: String,
			externalServicesSpecId: String,
			processId: String,
			userTelecomType: AuthenticationProcessTelecomType,
			userTelecom: String,
			captcha: CaptchaOptions,
			baseStorage: StorageFacade,
			authenticationProcessTemplateParameters: AuthenticationProcessTemplateParameters = AuthenticationProcessTemplateParameters(),
			options: SdkOptions = SdkOptions()
		): AuthenticationWithProcessStep {
			val api = RawMessageGatewayApi(options.configuredClientOrDefault(), options.cryptoService)
			val requestId = api.startProcess(
				messageGatewayUrl = messageGatewayUrl,
				externalServicesSpecId = externalServicesSpecId,
				processId = processId,
				captcha = captcha,
				firstName = authenticationProcessTemplateParameters.firstName,
				lastName = authenticationProcessTemplateParameters.lastName,
				userTelecom = userTelecom,
				userTelecomType = userTelecomType,
				krakenUrl = baseUrl
			)
			return AuthenticationWithProcessStepImpl(
				projectId = projectId,
				baseUrl = baseUrl,
				baseStorage = baseStorage,
				options = options,
				api = api,
				messageGatewayUrl = messageGatewayUrl,
				externalServicesSpecId = externalServicesSpecId,
				requestId = requestId,
				userTelecom = userTelecom,
			)
		}
	}
}

@InternalIcureApi
private class AuthenticationWithProcessStepImpl(
	private val projectId: String?,
	private val baseUrl: String,
	private val baseStorage: StorageFacade,
	private val options: SdkOptions,
	private val api: RawMessageGatewayApi,
	private val messageGatewayUrl: String,
	private val externalServicesSpecId: String,
	private val requestId: String,
	private val userTelecom: String,
) : CardinalSdk.AuthenticationWithProcessStep {
	override suspend fun completeAuthentication(validationCode: String): CardinalSdk {
		api.completeProcess(
			messageGatewayUrl = messageGatewayUrl,
			externalServicesSpecId = externalServicesSpecId,
			requestId = requestId,
			validationCode = validationCode
		)
		val rawAuthApi: RawAnonymousAuthApi = RawAnonymousAuthApiImpl(
			apiUrl = baseUrl,
			RawApiConfig(
				httpClient = options.configuredClientOrDefault(),
				json = options.configuredJsonOrDefault(),
				additionalHeaders = emptyMap(),
				requestTimeout = options.requestTimeout,
				retryConfiguration = options.requestRetryConfiguration
			)
		)
		val loginResult = retryWithDelays(
			listOf(100.milliseconds, 500.milliseconds, 1.seconds)
		) {
			rawAuthApi.login(
				loginCredentials = LoginCredentials(username = userTelecom, password = validationCode),
				applicationId = projectId
			).successBody()
		}
		return CardinalSdk.initialize(
			projectId,
			baseUrl,
			AuthenticationMethod.UsingCredentials(JwtCredentials(
				JwtBearer(ensureNonNull(loginResult.token)  { "Successful login gave null bearer token"}),
				JwtRefresh(ensureNonNull(loginResult.refreshToken)  { "Successful login gave null refresh token"}),
			)),
			baseStorage,
			options
		)
	}
}

private fun SdkOptions.asInitialized(baseStorage: StorageFacade): InitializedSdkOptions = InitializedSdkOptions(
	encryptedFields = encryptedFields,
	useHierarchicalDataOwners = useHierarchicalDataOwners,
	createTransferKeys = createTransferKeys,
	autoCreateEncryptionKeyForExistingLegacyData = autoCreateEncryptionKeyForExistingLegacyData,
	jsonPatcher = jsonPatcher,
	parentJob = parentJob,
	requestTimeout = requestTimeout,
	requestRetryConfiguration = requestRetryConfiguration,
	baseStorage = baseStorage,
	keyStorage = keyStorage
)

internal data class InitializedSdkOptions(
	val encryptedFields: EncryptedFieldsConfiguration,
	val useHierarchicalDataOwners: Boolean,
	val createTransferKeys: Boolean,
	val autoCreateEncryptionKeyForExistingLegacyData: Boolean,
	val jsonPatcher: JsonPatcher?,
	val parentJob: Job?,
	val requestTimeout: Duration?,
	val requestRetryConfiguration: RequestRetryConfiguration,
	val keyStorage: KeyStorageFacade?,
	val baseStorage: StorageFacade,
)

private const val ANONYMITY_HEADER = "Icure-Request-Autofix-Anonymity"
@InternalIcureApi
internal suspend fun initializeApiCrypto(
	apiUrl: String,
	authProvider: AuthProvider,
	client: HttpClient,
	json: Json,
	providedCryptoStrategies: CryptoStrategies?,
	cryptoService: CryptoService,
	groupId: String?,
	options: InitializedSdkOptions
): Triple<ApiConfiguration, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>?, CoroutineScope> {
	val cryptoStrategies = providedCryptoStrategies ?: BasicCryptoStrategies
	val keysStorage = options.keyStorage ?: JsonAndBase64KeyStorage(options.baseStorage)
	val iCureStorage =
		CardinalStorageFacade(keysStorage, options.baseStorage, DefaultStorageEntryKeysFactory, cryptoService, false)
	val boundGroup = groupId?.let(::SdkBoundGroup)
	// Failure of any child doesn't cause the scope nor the parent to cancel
	val sdkScope = CoroutineScope(Dispatchers.Default + SupervisorJob(options.parentJob))
	val mutableAdditionalHeaders = mutableMapOf<String, String>() // Only mutated once to add anonymity header
	val rawApiConfig = RawApiConfig(
		httpClient = client,
		json = json,
		additionalHeaders = mutableAdditionalHeaders,
		requestTimeout = options.requestTimeout,
		retryConfiguration = options.requestRetryConfiguration
	)
	val dataOwnerApi = DataOwnerApiImpl(
		RawDataOwnerApiImpl(
			apiUrl,
			authProvider,
			rawApiConfig
		),
		boundGroup
	)
	val self = dataOwnerApi.getCurrentDataOwner()
	val selfIsAnonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(self.asStub(), null)
	when {
		self.type != DataOwnerType.Hcp && !selfIsAnonymous -> "false"
		self.type == DataOwnerType.Hcp && selfIsAnonymous -> "true"
		else -> null
	}?.let { anonymityHeaderValue ->
		mutableAdditionalHeaders[ANONYMITY_HEADER] = anonymityHeaderValue
	}
	val rawPatientApiNoAccessKeys = RawPatientApiImpl(apiUrl, authProvider, null, rawApiConfig)
	val rawHealthcarePartyApi = RawHealthcarePartyApiImpl(apiUrl, authProvider, rawApiConfig)
	val rawDeviceApi = RawDeviceApiImpl(apiUrl, authProvider, rawApiConfig)
	val exchangeDataMapManager = ExchangeDataMapManagerImpl(
		RawExchangeDataMapApiImpl(apiUrl, authProvider, rawApiConfig),
		cryptoService,
		boundGroup
	)
	val baseExchangeDataManager = BaseExchangeDataManagerImpl(
		RawExchangeDataApiImpl(apiUrl, authProvider, rawApiConfig),
		cryptoService,
		boundGroup
	)
	val baseExchangeKeysManager = BaseExchangeKeysManagerImpl(
		cryptoService,
		dataOwnerApi,
		rawPatientApiNoAccessKeys,
		rawDeviceApi,
		rawHealthcarePartyApi,
	)
	val shamirService = ShamirSecretSharingService(cryptoService.strongRandom)
	val icureKeyRecovery = CardinalKeyRecoveryImpl(
		baseExchangeKeysManager,
		baseExchangeDataManager,
		cryptoService,
		shamirService
	)
	val recoveryDataEncryption = RecoveryDataEncryptionImpl(
		cryptoService,
		rawApiConfig,
	) { RawRecoveryDataApiImpl(apiUrl, authProvider, it) }
	val userEncryptionKeysInitInfo = UserEncryptionKeysManagerImpl.Factory(
		cryptoService,
		cryptoStrategies,
		dataOwnerApi,
		iCureStorage,
		icureKeyRecovery,
		recoveryDataEncryption,
		options.useHierarchicalDataOwners,
	).initialize()
	val userEncryptionKeys = userEncryptionKeysInitInfo.manager
	val delegatorActorIsAnonymous = userEncryptionKeys.delegatorActorIsAnonymous()
	val exchangeDataManager = if (delegatorActorIsAnonymous)
		FullyCachedExchangeDataManager(
			baseExchangeDataManager,
			userEncryptionKeys,
			cryptoStrategies,
			dataOwnerApi,
			cryptoService,
			sdkScope,
			boundGroup
		).also {
			it.clearOrRepopulateCache()
		}
	else
		CachedLruExchangeDataManager(
			baseExchangeDataManager,
			userEncryptionKeys,
			cryptoStrategies,
			dataOwnerApi,
			cryptoService,
			sdkScope,
			boundGroup
		)
	val secureDelegationsEncryption = SecureDelegationsEncryptionImpl(
		userEncryptionKeys,
		cryptoService
	)
	val secureDelegationsManager = SecureDelegationsManagerImpl(
		exchangeDataManager,
		exchangeDataMapManager,
		secureDelegationsEncryption,
		userEncryptionKeys,
		cryptoService,
		dataOwnerApi,
		cryptoStrategies,
		boundGroup
	)
	val exchangeKeysManager = ExchangeKeysManagerImpl(
		dataOwnerApi,
		baseExchangeKeysManager,
		userEncryptionKeys,
		sdkScope
	)
	val baseSecurityMetadataDecryptor = BaseSecurityMetadataDecryptorImpl(
		boundGroup,
		cryptoService,
		exchangeKeysManager,
		exchangeDataManager,
		secureDelegationsEncryption,
		exchangeDataMapManager,
		userEncryptionKeys
	)
	val incrementalSecurityMetadataDecryptor = IncrementalSecurityMetadataDecryptorImpl(
		baseSecurityMetadataDecryptor,
		userEncryptionKeys,
		cryptoService
	)
	val jsonEncryptionService = JsonEncryptionServiceImpl(cryptoService)
	val entityEncryptionService = EntityEncryptionServiceImpl(
		secureDelegationsManager = secureDelegationsManager,
		baseSecurityMetadataDecryptor = baseSecurityMetadataDecryptor,
		incrementalSecurityMetadataDecryptor = incrementalSecurityMetadataDecryptor,
		dataOwnerApi = dataOwnerApi,
		cryptoService = cryptoService,
		jsonEncryptionService = jsonEncryptionService,
		autoCreateEncryptionKeyForExistingLegacyData = options.autoCreateEncryptionKeyForExistingLegacyData,
		userEncryptionKeysManager = userEncryptionKeys,
		boundGroup = boundGroup
	)
	val headersProvider: AccessControlKeysHeadersProvider =
		if (delegatorActorIsAnonymous)
			AccessControlKeysHeadersProviderImpl(exchangeDataManager)
		else
			NoAccessControlKeysHeadersProvider
	val crypto = InternalCryptoApiImpl(
		entityEncryptionService,
		cryptoService,
		exchangeDataManager,
		exchangeKeysManager,
		jsonEncryptionService,
		DelegationsDeAnonymizationImpl(
			baseSecurityMetadataDecryptor,
			RawSecureDelegationKeyMapApiImpl(apiUrl, authProvider, rawApiConfig),
			headersProvider,
			entityEncryptionService,
			cryptoService,
			boundGroup,
			userEncryptionKeys
		),
		dataOwnerApi,
		userEncryptionKeys,
		recoveryDataEncryption,
		headersProvider,
		cryptoStrategies,
		secureDelegationsManager,
		incrementalSecurityMetadataDecryptor,
		baseSecurityMetadataDecryptor,
		iCureStorage
	)
	if (options.createTransferKeys) {
		TransferKeysManagerImpl(
			userEncryptionKeys,
			iCureStorage,
			cryptoService,
			exchangeDataManager,
			dataOwnerApi
		).updateSelfTransferKeys()
	}

	val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)
	return Triple(
		ApiConfigurationImpl(
			apiUrl,
			if (authProvider is JwtBasedAuthProvider) authProvider else null,
			!selfIsAnonymous,
			crypto,
			manifests,
			options.jsonPatcher ?: object : JsonPatcher {},
			options.parentJob,
			rawApiConfig,
			boundGroup
		),
		userEncryptionKeysInitInfo.newKey?.key,
		sdkScope
	)
}

@OptIn(InternalIcureApi::class)
internal class CardinalSdkImpl(
	private val authProvider: AuthProvider,
	private val config: ApiConfiguration,
	private val options: InitializedSdkOptions,
	override val boundGroupId: String?,
	override val scope: CoroutineScope
): CardinalSdk {
	private val apiUrl get() = config.apiUrl

	private val rawDataOwnerApi by lazy {
		RawDataOwnerApiImpl(
			apiUrl,
			authProvider,
			config.rawApiConfig,
		)
	}

	private val rawCalendarItemApi by lazy {
		RawCalendarItemApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val calendarItem: CalendarItemApi by lazy {
		initCalendarItemApi(
			rawCalendarItemApi,
			rawDataOwnerApi,
			config
		)
	}

	private val rawContactApi by lazy {
		RawContactApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	private val rawHealthcarePartyApi by lazy {
		RawHealthcarePartyApiImpl(
			apiUrl,
			authProvider,
			config.rawApiConfig,
		)
	}

	override val contact: ContactApi by lazy {
		initContactApi(
			rawContactApi,
			config,
		)
	}

	private val rawPatientApi by lazy {
		RawPatientApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val patient: PatientApi by lazy {
		initPatientApi(
			rawPatientApi,
			rawHealthcarePartyApi,
			rawHealthElementApi,
			rawFormApi,
			rawContactApi,
			rawInvoiceApi,
			rawCalendarItemApi,
			rawClassificationApi,
			config
		)
	}

	private val rawHealthElementApi by lazy {
		RawHealthElementApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val healthElement: HealthElementApi by lazy {
		initHealthElementApi(
			rawHealthElementApi,
			config
		)
	}

	override val dataOwner: DataOwnerApi get() = config.crypto.dataOwnerApi

	override val user: UserApi by lazy {
		UserApiImpl(
			RawUserApiImpl(
				apiUrl,
				authProvider,
				config.rawApiConfig,
			),
			RawPermissionApiImpl(
				apiUrl,
				authProvider,
				config.rawApiConfig,
			),
			config
		)
	}
	override val crypto: CryptoApi by lazy {
		CryptoApiImpl(
			ShamirKeysManagerApiImpl(
				config.crypto.dataOwnerApi,
				config.crypto.userEncryptionKeysManager,
				config.crypto.exchangeDataManager,
				config.crypto.primitives,
				ShamirSecretSharingService(config.crypto.primitives.strongRandom)
			),
			config.crypto
		)
	}

	private val rawMaintenanceTaskApi by lazy {
		RawMaintenanceTaskApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val maintenanceTask: MaintenanceTaskApi by lazy {
		MaintenanceTaskApiImpl(
			rawMaintenanceTaskApi,
			config
		)
	}

	override val cardinalMaintenanceTask: CardinalMaintenanceTaskApi by lazy {
		CardinalMaintenanceTaskApiImpl(
			config.crypto.exchangeDataManager,
			config.crypto.exchangeKeysManager.base,
			config.crypto.userEncryptionKeysManager,
			maintenanceTask,
			dataOwner,
			config.crypto.primitives.strongRandom,
		)
	}

	private val rawAccessLogApi by lazy {
		RawAccessLogApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val accessLog: AccessLogApi by lazy {
		initAccessLogApi(
			rawAccessLogApi,
			config
		)
	}

	private val rawMessageApi by lazy {
		RawMessageApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val message: MessageApi by lazy {
		MessageApiImpl(
			rawMessageApi,
			config
		)
	}

	private val rawTopicApi by lazy {
		RawTopicApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val topic: TopicApi by lazy {
		TopicApiImpl(
			rawTopicApi,
			config
		)
	}

	private val rawDocumentApi by lazy {
		RawDocumentApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val document: DocumentApi by lazy {
		initDocumentApi(
			rawApi = rawDocumentApi,
			config = config
		)
	}

	private val rawTimeTableApi by lazy {
		RawTimeTableApiImpl(
			apiUrl,
			authProvider,
			config.rawApiConfig,
		)
	}

	override val timeTable: TimeTableApi by lazy {
		TimeTableApiImpl(rawTimeTableApi)
	}

	private val rawClassificationApi by lazy {
		RawClassificationApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	private val rawFormApi by lazy {
		RawFormApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	override val form: FormApi by lazy {
		FormApiImpl(
			rawFormApi,
			config
		)
	}

	private val rawInvoiceApi by lazy {
		RawInvoiceApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	private val rawEntityReferenceApi by lazy {
		RawEntityReferenceApiImpl(
			apiUrl,
			authProvider,
			config.rawApiConfig,
		)
	}

	@Deprecated("The invoice API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	override val invoice: InvoiceApi by lazy {
		InvoiceApiImpl(
			rawInvoiceApi,
			rawEntityReferenceApi,
			config
		)
	}

	private val rawReceiptApi by lazy {
		RawReceiptApiImpl(
			apiUrl,
			authProvider,
			config.crypto.headersProvider,
			config.rawApiConfig,
		)
	}

	@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	override val receipt: ReceiptApi by lazy {
		ReceiptApiImpl(
			rawReceiptApi,
			config
		)
	}

	override val recovery: RecoveryApi by lazy {
		RecoveryApiImpl(config.crypto)
	}

	override val device: DeviceApi by lazy {
		DeviceApiImpl(RawDeviceApiImpl(apiUrl, authProvider, config.rawApiConfig), config)
	}

	override val permission: PermissionApi by lazy {
		PermissionApiImpl(RawPermissionApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}


	override val code: CodeApi by lazy {
		CodeApiImpl(
			RawCodeApiImpl(apiUrl, authProvider, config.rawApiConfig),
			config
		)
	}
	override val calendarItemType: CalendarItemTypeApi by lazy {
		CalendarItemTypeApiImpl(RawCalendarItemTypeApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val documentTemplate: DocumentTemplateApi by lazy {
		DocumentTemplateApiImpl(apiUrl, RawDocumentTemplateApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val entityReference: EntityReferenceApi by lazy {
		EntityReferenceApiImpl(RawEntityReferenceApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val entityTemplate: EntityTemplateApi by lazy {
		EntityTemplateApiImpl(RawEntityTemplateApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val frontEndMigration: FrontEndMigrationApi by lazy {
		FrontEndMigrationApiImpl(RawFrontEndMigrationApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val group: GroupApi by lazy {
		GroupApiImpl(RawGroupApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val healthcareParty: HealthcarePartyApi by lazy {
		HealthcarePartyApiImpl(RawHealthcarePartyApiImpl(apiUrl, authProvider, config.rawApiConfig), config)
	}
	override val system: SystemApi by lazy {
		SystemApiImpl(RawICureApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val insurance: InsuranceApi by lazy {
		InsuranceApiImpl(RawInsuranceApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val keyword: KeywordApi by lazy {
		KeywordApiImpl(RawKeywordApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val place: PlaceApi by lazy {
		PlaceApiImpl(RawPlaceApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val role: RoleApi by lazy {
		RoleApiImpl(RawRoleApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val tarification: TarificationApi by lazy {
		TarificationApiImpl(RawTarificationApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val medicalLocation: MedicalLocationApi by lazy {
		MedicalLocationApiImpl(RawMedicalLocationApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val auth: AuthApi by lazy {
		AuthApiImpl(authProvider)
	}
	override val agenda: AgendaApi by lazy {
		AgendaApiImpl(RawAgendaApiImpl(apiUrl, authProvider, config.rawApiConfig), config)
	}

	override suspend fun switchGroup(groupId: String): CardinalSdk =
		withSwitchedProvider(authProvider.switchGroup(groupId), groupId)

	override suspend fun changeScope(dataOwnerId: String): CardinalSdk =
		withSwitchedProvider(authProvider.changeScope(dataOwnerId), this.boundGroupId)

	private suspend fun withSwitchedProvider(
		switchedProvider: AuthProvider,
		boundGroupId: String?
	): CardinalSdk {
		val (switchedCryptoConfigs, newKey, scope) = initializeApiCrypto(
			config.apiUrl,
			switchedProvider,
			config.rawApiConfig.httpClient,
			config.rawApiConfig.json,
			config.crypto.strategies,
			config.crypto.primitives,
			boundGroupId,
			options
		)
		return CardinalSdkImpl(
			switchedProvider,
			switchedCryptoConfigs,
			options,
			boundGroupId,
			scope
		).also { switchedCryptoConfigs.notifyNewKeyIfAny(it, newKey) }
	}
}

@InternalIcureApi
internal suspend fun ApiConfiguration.notifyNewKeyIfAny(
	sdk: CardinalSdk,
	key: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>?
) {
	if (key != null) {
		crypto.strategies.notifyNewKeyCreated(
			sdk,
			key,
			crypto.primitives
		)
	}
}
