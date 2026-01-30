package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.api.AuthApi
import com.icure.cardinal.sdk.api.CalendarItemTypeApi
import com.icure.cardinal.sdk.api.FrontEndMigrationApi
import com.icure.cardinal.sdk.api.GroupApi
import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.MedicalLocationApi
import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.api.SystemApi
import com.icure.cardinal.sdk.api.TarificationApi
import com.icure.cardinal.sdk.api.UserApi
import com.icure.cardinal.sdk.api.impl.AgendaApiImpl
import com.icure.cardinal.sdk.api.impl.AuthApiImpl
import com.icure.cardinal.sdk.api.impl.CalendarItemTypeApiImpl
import com.icure.cardinal.sdk.api.impl.CodeApiImpl
import com.icure.cardinal.sdk.api.impl.DeviceApiImpl
import com.icure.cardinal.sdk.api.impl.FrontEndMigrationApiImpl
import com.icure.cardinal.sdk.api.impl.GroupApiImpl
import com.icure.cardinal.sdk.api.impl.HealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.impl.InsuranceApiImpl
import com.icure.cardinal.sdk.api.impl.MedicalLocationApiImpl
import com.icure.cardinal.sdk.api.impl.PermissionApiImpl
import com.icure.cardinal.sdk.api.impl.PlaceApiImpl
import com.icure.cardinal.sdk.api.impl.initReceiptBasicApi
import com.icure.cardinal.sdk.api.impl.RoleApiImpl
import com.icure.cardinal.sdk.api.impl.SystemApiImpl
import com.icure.cardinal.sdk.api.impl.TarificationApiImpl
import com.icure.cardinal.sdk.api.impl.TimeTableApiImpl
import com.icure.cardinal.sdk.api.impl.TopicBasicApiImpl
import com.icure.cardinal.sdk.api.impl.UserApiImpl
import com.icure.cardinal.sdk.api.impl.initAccessLogBasicApi
import com.icure.cardinal.sdk.api.impl.initCalendarItemBasicApi
import com.icure.cardinal.sdk.api.impl.initContactBasicApi
import com.icure.cardinal.sdk.api.impl.initDocumentBasicApi
import com.icure.cardinal.sdk.api.impl.initFormBasicApi
import com.icure.cardinal.sdk.api.impl.initHealthElementBasicApi
import com.icure.cardinal.sdk.api.impl.initInvoiceBasicApi
import com.icure.cardinal.sdk.api.impl.initMessageBasicApi
import com.icure.cardinal.sdk.api.impl.initPatientBasicApi
import com.icure.cardinal.sdk.api.raw.RawAnonymousAuthApi
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAccessLogApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawAgendaApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCalendarItemApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCalendarItemTypeApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCodeApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawContactApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDeviceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDocumentApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawFormApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawFrontEndMigrationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthElementApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawICureApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawInsuranceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawInvoiceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawMedicalLocationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawMessageApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPermissionApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPlaceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawReceiptApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawRoleApiImpl
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
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.impl.BasicEntityAccessInformationProvider
import com.icure.cardinal.sdk.crypto.impl.BasicInternalCryptoApiImpl
import com.icure.cardinal.sdk.crypto.impl.EntityValidationServiceImpl
import com.icure.cardinal.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.cardinal.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.model.LoginCredentials
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfigurationImpl
import com.icure.cardinal.sdk.options.BasicSdkOptions
import com.icure.cardinal.sdk.options.BasicToFullSdkOptions
import com.icure.cardinal.sdk.options.EncryptedFieldsConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.RequestRetryConfiguration
import com.icure.cardinal.sdk.options.UnboundBasicApiConfigurationImpl
import com.icure.cardinal.sdk.options.UnboundBasicSdkOptions
import com.icure.cardinal.sdk.options.configuredClientOrDefault
import com.icure.cardinal.sdk.options.configuredJsonOrDefault
import com.icure.cardinal.sdk.options.getAuthProvider
import com.icure.cardinal.sdk.options.getGroupAndAuthProvider
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.retryWithDelays
import com.icure.utils.InternalIcureApi
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Similar to the [CardinalBaseSdk] but is not bound to a specific user and/or group.
 * This allows using proxy authentication methods.
 */
@InternalIcureApi
interface CardinalUnboundBaseSdk : CardinalBaseApis {
	companion object {
		/**
		 * Initialize a new instance of icure base sdks that is not bound to a specific user.
		 * Each request may be done as a different user, depending on the provided authentication method.
		 *
		 * This allows implementing services between the end user and the icure backend that act as proxy and perform
		 * some requests on behalf of the user.
		 *
		 * @param baseUrl the url of the iCure backend to use
		 * @param authenticationMethod specifies how the sdk should authenticate.
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@InternalIcureApi
		suspend fun initialize(
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: UnboundBasicSdkOptions = UnboundBasicSdkOptions()
		): CardinalUnboundBaseSdk {
			val client = options.configuredClientOrDefault()
			val json = options.configuredJsonOrDefault()
			val cryptoService = options.cryptoService
			val rawApiConfig = RawApiConfig(
				httpClient = client,
				json = json,
				requestTimeout = options.requestTimeout,
				additionalHeaders = emptyMap(),
				retryConfiguration = options.requestRetryConfiguration
			)
			val rawAuthApi = RawAnonymousAuthApiImpl(
				apiUrl = baseUrl,
				rawApiConfig = rawApiConfig
			)
			val authProvider = authenticationMethod.getAuthProvider(
				rawAuthApi,
				cryptoService,
				null,
				options,
				RawMessageGatewayApi(client, cryptoService),
				krakenUrl = baseUrl
			)
			val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)
			val jsonEncryptionService = JsonEncryptionServiceImpl(cryptoService)
			val boundGroupProvider = { context: CoroutineContext -> options.getBoundGroupId(context)?.let(::SdkBoundGroup) }
			val config = UnboundBasicApiConfigurationImpl(
				apiUrl = baseUrl,
				webSocketAuthProvider = authProvider as? JwtBasedAuthProvider,
				crypto = BasicInternalCryptoApiImpl(
					primitives = options.cryptoService,
					jsonEncryption = jsonEncryptionService,
					validationService = EntityValidationServiceImpl(jsonEncryptionService),
					entityAccessInformationProvider = BasicEntityAccessInformationProvider(boundGroupProvider)
				),
				encryption =manifests,
				rawApiConfig = rawApiConfig,
				boundGroupProvider = boundGroupProvider
			)
			return object : CardinalUnboundBaseSdk, CardinalBaseApis by CardinalBaseApisImpl(authProvider, config) {}
		}
	}
}

interface CardinalBaseSdk : CardinalBaseApis {
	/**
	 * The id of the group this SDK is bound to. Always `null` when working with kraken-lite instances.
	 */
	val boundGroupId: String?

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
	suspend fun switchGroup(groupId: String): CardinalBaseSdk

	/**
	 * Get a new sdk using the same configurations and user authentication methods but for a different data owner
	 * in the same group.
	 * To use this method, the authentication method provided at initialization of this sdk must be valid also for the
	 * new data owner.
	 *
	 * Note that the switched sdk will reuse components like the http client.
	 * Don't close the client of this sdk while you are using the new sdk.
	 *
	 * @param dataOwnerId the id of the new data owner to act as
	 * @return a new sdk for executing requests as the provided data owner
	 */
	suspend fun changeScope(dataOwnerId: String): CardinalBaseSdk

	/**
	 * Use the authentication for this base sdk to create a full sdk for the same user. Can only be used if the
	 * current user is a data owner.
	 * @param baseStorage an implementation of the [StorageFacade], used for persistent storage of various
	 * information including the user keys if [BasicToFullSdkOptions.keyStorage] is not provided.
	 * @param options additional options for the creation of the full sdk
	 */
	suspend fun toFullSdk(
		baseStorage: StorageFacade,
		options: BasicToFullSdkOptions
	): CardinalSdk

	/**
	 * Represents an intermediate stage in the initialization of a base SDK through an authentication process
	 * The initialization can complete only after the user provides the validation code received via email/sms.
	 */
	interface BaseAuthenticationWithProcessStep {
		/**
		 * Complete the authentication of the user and finishes the initialization of the SDK.
		 * In case the provided validation code is wrong this method will throw an exception, but it is still possible
		 * to call to re-attempt authentication by calling this method with a different validation code.
		 */
		suspend fun completeAuthentication(validationCode: String): CardinalBaseSdk
	}

	companion object {
		/**
		 * Initialize a new instance of icure base sdks for a specific user.
		 *
		 * @param projectId a string to uniquely identify your iCure project.
		 * @param baseUrl the url of the iCure backend to use
		 * @param authenticationMethod specifies how the sdk should authenticate.
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@OptIn(InternalIcureApi::class)
		suspend fun initialize(
			projectId: String?,
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: BasicSdkOptions = BasicSdkOptions()
		): CardinalBaseSdk {
			val client = options.configuredClientOrDefault()
			val json = options.configuredJsonOrDefault()
			val cryptoService = options.cryptoService
			val rawApiConfig = RawApiConfig(
				httpClient = client,
				json = json,
				requestTimeout = options.requestTimeout,
				additionalHeaders = emptyMap(),
				retryConfiguration = options.requestRetryConfiguration
			)
			val (chosenGroup, authProvider) = authenticationMethod.getGroupAndAuthProvider(
				baseUrl = baseUrl,
				apiUrl = baseUrl,
				cryptoService = cryptoService,
				projectId = projectId,
				options = options,
				rawApiConfig = rawApiConfig,
			)
			val boundGroup = chosenGroup?.let(::SdkBoundGroup)
			val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)
			val jsonEncryptionService = JsonEncryptionServiceImpl(cryptoService)
			val config = BasicApiConfigurationImpl(
				apiUrl = baseUrl,
				webSocketAuthProvider = authProvider as? JwtBasedAuthProvider,
				crypto = BasicInternalCryptoApiImpl(
					primitives = options.cryptoService,
					jsonEncryption = jsonEncryptionService,
					validationService = EntityValidationServiceImpl(jsonEncryptionService),
					entityAccessInformationProvider = BasicEntityAccessInformationProvider { boundGroup }
				),
				encryption = manifests,
				rawApiConfig = rawApiConfig,
				boundGroup = boundGroup
			)
			return CardinalBaseSdkImpl(
				authProvider,
				config,
				chosenGroup,
				options.asInitialized()
			)
		}

		/**
		 * Initialize a new instance of the icure base sdk for a specific user.
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
			authenticationProcessTemplateParameters: AuthenticationProcessTemplateParameters = AuthenticationProcessTemplateParameters(),
			options: BasicSdkOptions = BasicSdkOptions()
		): BaseAuthenticationWithProcessStep {
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
			return BaseAuthenticationWithProcessStepImpl(
				projectId = projectId,
				baseUrl = baseUrl,
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
private class BaseAuthenticationWithProcessStepImpl(
	private val projectId: String?,
	private val baseUrl: String,
	private val options: BasicSdkOptions,
	private val api: RawMessageGatewayApi,
	private val messageGatewayUrl: String,
	private val externalServicesSpecId: String,
	private val requestId: String,
	private val userTelecom: String,
) : CardinalBaseSdk.BaseAuthenticationWithProcessStep {
	override suspend fun completeAuthentication(validationCode: String): CardinalBaseSdk {
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
		return CardinalBaseSdk.initialize(
			projectId,
			baseUrl,
			AuthenticationMethod.UsingCredentials(JwtCredentials(
				JwtBearer(ensureNonNull(loginResult.token)  { "Successful login gave null bearer token"}),
				JwtRefresh(ensureNonNull(loginResult.refreshToken)  { "Successful login gave null refresh token"}),
			)),
			options
		)
	}
}

@OptIn(InternalIcureApi::class)
private class CardinalBaseApisImpl(
	private val authProvider: AuthProvider,
	private val config: BasicApiConfiguration
) : CardinalBaseApis {
	private val apiUrl get() = config.apiUrl

	override val auth: AuthApi by lazy {
		AuthApiImpl(
			authProvider = authProvider,
		)
	}

	override val accessLog by lazy {
		initAccessLogBasicApi(
			RawAccessLogApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val calendarItem by lazy {
		initCalendarItemBasicApi(
			RawCalendarItemApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val code by lazy { CodeApiImpl(RawCodeApiImpl(apiUrl, authProvider, config.rawApiConfig), config) }
	override val calendarItemType: CalendarItemTypeApi by lazy {
		CalendarItemTypeApiImpl(RawCalendarItemTypeApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val contact by lazy {
		initContactBasicApi(
			RawContactApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			),
			config
		)
	}
	override val device by lazy { DeviceApiImpl(RawDeviceApiImpl(apiUrl, authProvider, config.rawApiConfig), config) }
	override val document by lazy {
		initDocumentBasicApi(
			rawApi = RawDocumentApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			),
			config
		)
	}
	override val form by lazy {
		initFormBasicApi(
			rawApi = RawFormApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			),
			config = config
		)
	}
	override val group: GroupApi by lazy {
		GroupApiImpl(
			RawGroupApiImpl(
				apiUrl,
				authProvider,
				config.rawApiConfig
			)
		)
	}
	override val healthElement by lazy {
		initHealthElementBasicApi(
			RawHealthElementApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val healthcareParty by lazy {
		HealthcarePartyApiImpl(
			RawHealthcarePartyApiImpl(
				apiUrl,
				authProvider,
				config.rawApiConfig
			),
			config
		)
	}

	@Deprecated("The invoice API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	override val invoice by lazy {
		initInvoiceBasicApi(
			rawApi = RawInvoiceApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			),
			config = config
		)
	}

	override val message by lazy {
		initMessageBasicApi(
			rawApi = RawMessageApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			),
			config = config
		)
	}
	override val patient by lazy {
		initPatientBasicApi(
			RawPatientApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val permission by lazy {
		PermissionApiImpl(
			RawPermissionApiImpl(
				apiUrl,
				authProvider,
				config.rawApiConfig
			)
		)
	}

	@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	override val receipt by lazy {
		initReceiptBasicApi(
			RawReceiptApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val timeTable by lazy {
		TimeTableApiImpl(
			RawTimeTableApiImpl(
				apiUrl,
				authProvider,
				config.rawApiConfig
			)
		)
	}
	override val topic by lazy {
		TopicBasicApiImpl(
			RawTopicApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val user: UserApi by lazy {
		UserApiImpl(
			RawUserApiImpl(apiUrl, authProvider, config.rawApiConfig),
			RawPermissionApiImpl(apiUrl, authProvider, config.rawApiConfig),
			config
		)
	}
	override val frontEndMigration: FrontEndMigrationApi by lazy {
		FrontEndMigrationApiImpl(RawFrontEndMigrationApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val system: SystemApi by lazy {
		SystemApiImpl(RawICureApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val insurance: InsuranceApi by lazy {
		InsuranceApiImpl(RawInsuranceApiImpl(apiUrl, authProvider, config.rawApiConfig))
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
	override val agenda: AgendaApi by lazy {
		AgendaApiImpl(RawAgendaApiImpl(apiUrl, authProvider, config.rawApiConfig), config)
	}
}

private fun BasicSdkOptions.asInitialized() =
	InitializedBaseSdkOptions(
		encryptedFields = encryptedFields,
		requestTimeout = requestTimeout,
		requestRetryConfiguration = requestRetryConfiguration,
	)

private data class InitializedBaseSdkOptions(
	val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	val requestTimeout: Duration? = null,
	val requestRetryConfiguration: RequestRetryConfiguration = RequestRetryConfiguration(),
)

private fun makeInitializedSdkOptions(
	base: InitializedBaseSdkOptions,
	full: BasicToFullSdkOptions,
	storage: StorageFacade
) = InitializedSdkOptions(
	encryptedFields = base.encryptedFields,
	useHierarchicalDataOwners = full.useHierarchicalDataOwners,
	createTransferKeys = full.createTransferKeys,
	autoCreateEncryptionKeyForExistingLegacyData = full.autoCreateEncryptionKeyForExistingLegacyData,
	jsonPatcher = full.jsonPatcher,
	parentJob = full.parentJob,
	requestTimeout = base.requestTimeout,
	requestRetryConfiguration = base.requestRetryConfiguration,
	keyStorage = full.keyStorage,
	baseStorage = storage,
)

@InternalIcureApi
private class CardinalBaseSdkImpl(
	private val authProvider: AuthProvider,
	private val config: BasicApiConfiguration,
	override val boundGroupId: String?,
	private val options: InitializedBaseSdkOptions,
) : CardinalBaseSdk, CardinalBaseApis by CardinalBaseApisImpl(authProvider, config) {
	override suspend fun switchGroup(groupId: String): CardinalBaseSdk = CardinalBaseSdkImpl(
		authProvider.switchGroup(groupId),
		config,
		groupId,
		options,
	)

	override suspend fun changeScope(dataOwnerId: String): CardinalBaseSdk = CardinalBaseSdkImpl(
		authProvider.changeScope(dataOwnerId),
		config,
		boundGroupId,
		options,
	)

	override suspend fun toFullSdk(
		baseStorage: StorageFacade,
		options: BasicToFullSdkOptions
	): CardinalSdk {
		val initializedSdkOptions = makeInitializedSdkOptions(this.options, options, baseStorage)
		val (initializedCrypto, newKey, scope) = initializeApiCrypto(
			config.apiUrl,
			authProvider,
			config.rawApiConfig.httpClient,
			config.rawApiConfig.json,
			options.cryptoStrategies,
			config.crypto.primitives,
			boundGroupId,
			initializedSdkOptions,
		)
		return CardinalSdkImpl(
			this.authProvider,
			initializedCrypto,
			initializedSdkOptions,
			boundGroupId,
			scope
		).also { initializedCrypto.notifyNewKeyIfAny(it, newKey) }
	}
}
