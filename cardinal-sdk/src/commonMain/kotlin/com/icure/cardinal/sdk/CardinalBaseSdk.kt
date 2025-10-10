package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.api.ApplicationSettingsApi
import com.icure.cardinal.sdk.api.AuthApi
import com.icure.cardinal.sdk.api.CalendarItemTypeApi
import com.icure.cardinal.sdk.api.DocumentTemplateApi
import com.icure.cardinal.sdk.api.EntityReferenceApi
import com.icure.cardinal.sdk.api.EntityTemplateApi
import com.icure.cardinal.sdk.api.FrontEndMigrationApi
import com.icure.cardinal.sdk.api.GroupApi
import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.KeywordApi
import com.icure.cardinal.sdk.api.MedicalLocationApi
import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.api.SystemApi
import com.icure.cardinal.sdk.api.TarificationApi
import com.icure.cardinal.sdk.api.UserApi
import com.icure.cardinal.sdk.api.impl.AccessLogBasicApiImpl
import com.icure.cardinal.sdk.api.impl.AgendaApiImpl
import com.icure.cardinal.sdk.api.impl.ApplicationSettingsApiImpl
import com.icure.cardinal.sdk.api.impl.AuthApiImpl
import com.icure.cardinal.sdk.api.impl.CalendarItemTypeApiImpl
import com.icure.cardinal.sdk.api.impl.ClassificationBasicApiImpl
import com.icure.cardinal.sdk.api.impl.CodeApiImpl
import com.icure.cardinal.sdk.api.impl.ContactBasicApiImpl
import com.icure.cardinal.sdk.api.impl.DeviceApiImpl
import com.icure.cardinal.sdk.api.impl.DocumentBasicApiImpl
import com.icure.cardinal.sdk.api.impl.DocumentTemplateApiImpl
import com.icure.cardinal.sdk.api.impl.EntityReferenceApiImpl
import com.icure.cardinal.sdk.api.impl.EntityTemplateApiImpl
import com.icure.cardinal.sdk.api.impl.FormBasicApiImpl
import com.icure.cardinal.sdk.api.impl.FrontEndMigrationApiImpl
import com.icure.cardinal.sdk.api.impl.GroupApiImpl
import com.icure.cardinal.sdk.api.impl.HealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.impl.InsuranceApiImpl
import com.icure.cardinal.sdk.api.impl.InvoiceBasicApiImpl
import com.icure.cardinal.sdk.api.impl.KeywordApiImpl
import com.icure.cardinal.sdk.api.impl.MaintenanceTaskBasicApiImpl
import com.icure.cardinal.sdk.api.impl.MedicalLocationApiImpl
import com.icure.cardinal.sdk.api.impl.MessageBasicApiImpl
import com.icure.cardinal.sdk.api.impl.PermissionApiImpl
import com.icure.cardinal.sdk.api.impl.PlaceApiImpl
import com.icure.cardinal.sdk.api.impl.ReceiptBasicApiImpl
import com.icure.cardinal.sdk.api.impl.RoleApiImpl
import com.icure.cardinal.sdk.api.impl.SystemApiImpl
import com.icure.cardinal.sdk.api.impl.TarificationApiImpl
import com.icure.cardinal.sdk.api.impl.TimeTableApiImpl
import com.icure.cardinal.sdk.api.impl.TopicBasicApiImpl
import com.icure.cardinal.sdk.api.impl.UserApiImpl
import com.icure.cardinal.sdk.api.impl.initCalendarItemBasicApi
import com.icure.cardinal.sdk.api.impl.initHealthElementBasicApi
import com.icure.cardinal.sdk.api.impl.initPatientBasicApi
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAccessLogApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawAgendaApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawApplicationSettingsApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCalendarItemApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCalendarItemTypeApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawClassificationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCodeApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawContactApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDeviceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDocumentApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDocumentTemplateApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawEntityReferenceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawEntityTemplateApiImpl
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
import com.icure.cardinal.sdk.api.raw.impl.RawRoleApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTarificationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTimeTableApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTopicApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.impl.BasicEntityAccessInformationProvider
import com.icure.cardinal.sdk.crypto.impl.BasicInternalCryptoApiImpl
import com.icure.cardinal.sdk.crypto.impl.EntityValidationServiceImpl
import com.icure.cardinal.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.cardinal.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfigurationImpl
import com.icure.cardinal.sdk.options.BasicSdkOptions
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.UnboundBasicApiConfigurationImpl
import com.icure.cardinal.sdk.options.UnboundBasicSdkOptions
import com.icure.cardinal.sdk.options.configuredClientOrDefault
import com.icure.cardinal.sdk.options.configuredJsonOrDefault
import com.icure.cardinal.sdk.options.getAuthProvider
import com.icure.cardinal.sdk.options.getGroupAndAuthProvider
import com.icure.utils.InternalIcureApi
import kotlin.coroutines.CoroutineContext

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
		fun initialize(
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: UnboundBasicSdkOptions = UnboundBasicSdkOptions()
		): CardinalUnboundBaseSdk {
			val client = options.configuredClientOrDefault()
			val json = options.configuredJsonOrDefault()
			val cryptoService = options.cryptoService
			val apiUrl = baseUrl
			val rawApiConfig = RawApiConfig(
				httpClient = client,
				json = json,
				requestTimeout = options.requestTimeout,
				additionalHeaders = emptyMap(),
				retryConfiguration = options.requestRetryConfiguration
			)
			val rawAuthApi = RawAnonymousAuthApiImpl(
				apiUrl = apiUrl,
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
				apiUrl,
				if (authProvider is JwtBasedAuthProvider) authProvider else null,
				BasicInternalCryptoApiImpl(
					jsonEncryptionService,
					EntityValidationServiceImpl(jsonEncryptionService),
					BasicEntityAccessInformationProvider(boundGroupProvider)
				),
				manifests,
				rawApiConfig,
				boundGroupProvider
			)
			return object : CardinalUnboundBaseSdk, CardinalBaseApis by CardinalBaseSdkImpl(
				authProvider,
				config,
				null
			) {}
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

	companion object {
		/**
		 * Initialize a new instance of icure base sdks for a specific user.
		 *
		 * @param applicationId a string to uniquely identify your iCure application.
		 * @param baseUrl the url of the iCure backend to use
		 * @param authenticationMethod specifies how the sdk should authenticate.
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@OptIn(InternalIcureApi::class)
		suspend fun initialize(
			applicationId: String?,
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: BasicSdkOptions = BasicSdkOptions()
		): CardinalBaseSdk {
			val client = options.configuredClientOrDefault()
			val json = options.configuredJsonOrDefault()
			val cryptoService = options.cryptoService
			val apiUrl = baseUrl
			val rawApiConfig = RawApiConfig(
				httpClient = client,
				json = json,
				requestTimeout = options.requestTimeout,
				additionalHeaders = emptyMap(),
				retryConfiguration = options.requestRetryConfiguration
			)
			val (chosenGroup, authProvider) = authenticationMethod.getGroupAndAuthProvider(
				baseUrl = baseUrl,
				apiUrl = apiUrl,
				cryptoService = cryptoService,
				applicationId = applicationId,
				options = options,
				groupSelector = options.groupSelector,
				rawApiConfig = rawApiConfig,
			)
			val boundGroup = chosenGroup?.let(::SdkBoundGroup)
			val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)
			val jsonEncryptionService = JsonEncryptionServiceImpl(cryptoService)
			val config = BasicApiConfigurationImpl(
				apiUrl,
				if (authProvider is JwtBasedAuthProvider) authProvider else null,
				BasicInternalCryptoApiImpl(
					jsonEncryptionService,
					EntityValidationServiceImpl(jsonEncryptionService),
					BasicEntityAccessInformationProvider { boundGroup }
				),
				manifests,
				rawApiConfig,
				boundGroup
			)
			return CardinalBaseSdkImpl(
				authProvider,
				config,
				chosenGroup
			)
		}
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
		AccessLogBasicApiImpl(
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
	override val classification by lazy {
		ClassificationBasicApiImpl(
			RawClassificationApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val code by lazy { CodeApiImpl(RawCodeApiImpl(apiUrl, authProvider, config.rawApiConfig)) }
	override val calendarItemType: CalendarItemTypeApi by lazy {
		CalendarItemTypeApiImpl(RawCalendarItemTypeApiImpl(apiUrl, authProvider, config.rawApiConfig))
	}
	override val contact by lazy {
		ContactBasicApiImpl(
			RawContactApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val device by lazy { DeviceApiImpl(RawDeviceApiImpl(apiUrl, authProvider, config.rawApiConfig), config) }
	override val document by lazy {
		DocumentBasicApiImpl(
			RawDocumentApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val form by lazy {
		FormBasicApiImpl(
			RawFormApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
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
		InvoiceBasicApiImpl(
			RawInvoiceApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val maintenanceTask by lazy {
		MaintenanceTaskBasicApiImpl(
			RawMaintenanceTaskApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
		)
	}
	override val message by lazy {
		MessageBasicApiImpl(
			RawMessageApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				config.rawApiConfig
			), config
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
		ReceiptBasicApiImpl(
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

	override val applicationSettings: ApplicationSettingsApi by lazy {
		ApplicationSettingsApiImpl(RawApplicationSettingsApiImpl(apiUrl, authProvider, config.rawApiConfig))
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
	override val agenda: AgendaApi by lazy {
		AgendaApiImpl(RawAgendaApiImpl(apiUrl, authProvider, config.rawApiConfig), config)
	}
}

@InternalIcureApi
private class CardinalBaseSdkImpl(
	private val authProvider: AuthProvider,
	private val config: BasicApiConfiguration,
	override val boundGroupId: String?
) : CardinalBaseSdk, CardinalBaseApis by CardinalBaseApisImpl(authProvider, config) {
	override suspend fun switchGroup(groupId: String): CardinalBaseSdk = CardinalBaseSdkImpl(
		authProvider.switchGroup(groupId),
		config,
		groupId
	)
}
