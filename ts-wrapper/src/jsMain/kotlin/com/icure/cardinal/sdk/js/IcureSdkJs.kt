package com.icure.cardinal.sdk.js

import com.icure.cardinal.sdk.CardinalAnonymousApis
import com.icure.cardinal.sdk.CardinalAnonymousSdk
import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.cardinal.sdk.auth.AuthenticationProcessTemplateParameters
import com.icure.cardinal.sdk.js.api.AccessLogApiJs
import com.icure.cardinal.sdk.js.api.AccessLogBasicApiJs
import com.icure.cardinal.sdk.js.api.AgendaApiJs
import com.icure.cardinal.sdk.js.api.AnonymousAgendaApiJs
import com.icure.cardinal.sdk.js.api.AnonymousHealthcarePartyApiJs
import com.icure.cardinal.sdk.js.api.ApplicationSettingsApiJs
import com.icure.cardinal.sdk.js.api.AuthApiJs
import com.icure.cardinal.sdk.js.api.CalendarItemApiJs
import com.icure.cardinal.sdk.js.api.CalendarItemBasicApiJs
import com.icure.cardinal.sdk.js.api.CalendarItemTypeApiJs
import com.icure.cardinal.sdk.js.api.CardinalMaintenanceTaskApiJs
import com.icure.cardinal.sdk.js.api.ClassificationApiJs
import com.icure.cardinal.sdk.js.api.ClassificationBasicApiJs
import com.icure.cardinal.sdk.js.api.CodeApiJs
import com.icure.cardinal.sdk.js.api.ContactApiJs
import com.icure.cardinal.sdk.js.api.ContactBasicApiJs
import com.icure.cardinal.sdk.js.api.CryptoApiJs
import com.icure.cardinal.sdk.js.api.DataOwnerApiJs
import com.icure.cardinal.sdk.js.api.DeviceApiJs
import com.icure.cardinal.sdk.js.api.DocumentApiJs
import com.icure.cardinal.sdk.js.api.DocumentBasicApiJs
import com.icure.cardinal.sdk.js.api.DocumentTemplateApiJs
import com.icure.cardinal.sdk.js.api.EntityReferenceApiJs
import com.icure.cardinal.sdk.js.api.EntityTemplateApiJs
import com.icure.cardinal.sdk.js.api.FormApiJs
import com.icure.cardinal.sdk.js.api.FormBasicApiJs
import com.icure.cardinal.sdk.js.api.FrontEndMigrationApiJs
import com.icure.cardinal.sdk.js.api.GroupApiJs
import com.icure.cardinal.sdk.js.api.HealthElementApiJs
import com.icure.cardinal.sdk.js.api.HealthElementBasicApiJs
import com.icure.cardinal.sdk.js.api.HealthcarePartyApiJs
import com.icure.cardinal.sdk.js.api.InsuranceApiJs
import com.icure.cardinal.sdk.js.api.InvoiceApiJs
import com.icure.cardinal.sdk.js.api.InvoiceBasicApiJs
import com.icure.cardinal.sdk.js.api.KeywordApiJs
import com.icure.cardinal.sdk.js.api.MaintenanceTaskApiJs
import com.icure.cardinal.sdk.js.api.MaintenanceTaskBasicApiJs
import com.icure.cardinal.sdk.js.api.MedicalLocationApiJs
import com.icure.cardinal.sdk.js.api.MessageApiJs
import com.icure.cardinal.sdk.js.api.MessageBasicApiJs
import com.icure.cardinal.sdk.js.api.PatientApiJs
import com.icure.cardinal.sdk.js.api.PatientBasicApiJs
import com.icure.cardinal.sdk.js.api.PermissionApiJs
import com.icure.cardinal.sdk.js.api.PlaceApiJs
import com.icure.cardinal.sdk.js.api.ReceiptApiJs
import com.icure.cardinal.sdk.js.api.ReceiptBasicApiJs
import com.icure.cardinal.sdk.js.api.RecoveryApiJs
import com.icure.cardinal.sdk.js.api.RoleApiJs
import com.icure.cardinal.sdk.js.api.SystemApiJs
import com.icure.cardinal.sdk.js.api.TarificationApiJs
import com.icure.cardinal.sdk.js.api.TimeTableApiJs
import com.icure.cardinal.sdk.js.api.TopicApiJs
import com.icure.cardinal.sdk.js.api.TopicBasicApiJs
import com.icure.cardinal.sdk.js.api.UserApiJs
import com.icure.cardinal.sdk.js.api.impl.AccessLogApiImplJs
import com.icure.cardinal.sdk.js.api.impl.AccessLogBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.AgendaApiImplJs
import com.icure.cardinal.sdk.js.api.impl.AnonymousAgendaApiImplJs
import com.icure.cardinal.sdk.js.api.impl.AnonymousHealthcarePartyApiImplJs
import com.icure.cardinal.sdk.js.api.impl.ApplicationSettingsApiImplJs
import com.icure.cardinal.sdk.js.api.impl.AuthApiImplJs
import com.icure.cardinal.sdk.js.api.impl.CalendarItemApiImplJs
import com.icure.cardinal.sdk.js.api.impl.CalendarItemBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.CalendarItemTypeApiImplJs
import com.icure.cardinal.sdk.js.api.impl.CardinalMaintenanceTaskApiImplJs
import com.icure.cardinal.sdk.js.api.impl.ClassificationApiImplJs
import com.icure.cardinal.sdk.js.api.impl.ClassificationBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.CodeApiImplJs
import com.icure.cardinal.sdk.js.api.impl.ContactApiImplJs
import com.icure.cardinal.sdk.js.api.impl.ContactBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.CryptoApiImplJs
import com.icure.cardinal.sdk.js.api.impl.DataOwnerApiImplJs
import com.icure.cardinal.sdk.js.api.impl.DeviceApiImplJs
import com.icure.cardinal.sdk.js.api.impl.DocumentApiImplJs
import com.icure.cardinal.sdk.js.api.impl.DocumentBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.DocumentTemplateApiImplJs
import com.icure.cardinal.sdk.js.api.impl.EntityReferenceApiImplJs
import com.icure.cardinal.sdk.js.api.impl.EntityTemplateApiImplJs
import com.icure.cardinal.sdk.js.api.impl.FormApiImplJs
import com.icure.cardinal.sdk.js.api.impl.FormBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.FrontEndMigrationApiImplJs
import com.icure.cardinal.sdk.js.api.impl.GroupApiImplJs
import com.icure.cardinal.sdk.js.api.impl.HealthElementApiImplJs
import com.icure.cardinal.sdk.js.api.impl.HealthElementBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.HealthcarePartyApiImplJs
import com.icure.cardinal.sdk.js.api.impl.InsuranceApiImplJs
import com.icure.cardinal.sdk.js.api.impl.InvoiceApiImplJs
import com.icure.cardinal.sdk.js.api.impl.InvoiceBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.KeywordApiImplJs
import com.icure.cardinal.sdk.js.api.impl.MaintenanceTaskApiImplJs
import com.icure.cardinal.sdk.js.api.impl.MaintenanceTaskBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.MedicalLocationApiImplJs
import com.icure.cardinal.sdk.js.api.impl.MessageApiImplJs
import com.icure.cardinal.sdk.js.api.impl.MessageBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.PatientApiImplJs
import com.icure.cardinal.sdk.js.api.impl.PatientBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.PermissionApiImplJs
import com.icure.cardinal.sdk.js.api.impl.PlaceApiImplJs
import com.icure.cardinal.sdk.js.api.impl.ReceiptApiImplJs
import com.icure.cardinal.sdk.js.api.impl.ReceiptBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.RecoveryApiImplJs
import com.icure.cardinal.sdk.js.api.impl.RoleApiImplJs
import com.icure.cardinal.sdk.js.api.impl.SystemApiImplJs
import com.icure.cardinal.sdk.js.api.impl.TarificationApiImplJs
import com.icure.cardinal.sdk.js.api.impl.TimeTableApiImplJs
import com.icure.cardinal.sdk.js.api.impl.TopicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.TopicBasicApiImplJs
import com.icure.cardinal.sdk.js.api.impl.UserApiImplJs
import com.icure.cardinal.sdk.js.auth.CaptchaOptionsJs
import com.icure.cardinal.sdk.js.auth.captchaOptions_fromJs
import com.icure.cardinal.sdk.js.externalsdk.AuthenticationWithProcessStepJs
import com.icure.cardinal.sdk.js.externalsdk.BaseAuthenticationWithProcessStepJs
import com.icure.cardinal.sdk.js.externalsdk.CardinalApisJs
import com.icure.cardinal.sdk.js.externalsdk.CardinalAnonymousApisJs
import com.icure.cardinal.sdk.js.externalsdk.CardinalAnonymousSdkJs
import com.icure.cardinal.sdk.js.externalsdk.CardinalBaseApisJs
import com.icure.cardinal.sdk.js.externalsdk.CardinalBaseSdkJs
import com.icure.cardinal.sdk.js.externalsdk.CardinalSdkJs
import com.icure.cardinal.sdk.js.options.external.AnonymousSdkOptionsJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationMethodJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationProcessTemplateParametersJs
import com.icure.cardinal.sdk.js.options.external.BasicSdkOptionsJs
import com.icure.cardinal.sdk.js.options.external.BasicToFullSdkOptionsJs
import com.icure.cardinal.sdk.js.options.external.SdkOptionsJs
import com.icure.cardinal.sdk.js.options.toKt
import com.icure.cardinal.sdk.js.storage.loadStorageOptions
import com.icure.cardinal.sdk.options.AnonymousSdkOptions
import com.icure.cardinal.sdk.options.BasicSdkOptions
import com.icure.cardinal.sdk.options.BasicToFullSdkOptions
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.adaptCryptoServiceForExternal
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.promise
import kotlin.js.Promise


@JsExport
object InternalSdkInitializers {
	fun initializeSdk(
		applicationId: String?,
		baseUrl: String,
		authenticationMethod: AuthenticationMethodJs,
		storageFacade: dynamic,
		options: SdkOptionsJs?
	): Promise<CardinalSdkJs> = GlobalScope.promise {
		CardinalSdkJsImpl(CardinalSdk.initialize(
			applicationId,
			baseUrl,
			authenticationMethod.toKt(),
			loadStorageOptions(storageFacade),
			options?.toKt() ?: SdkOptions(),
		))
	}

	fun initializeWithProcess(
		applicationId: String?,
		baseUrl: String,
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: String,
		userTelecom: String,
		captchaOptions: CaptchaOptionsJs,
		baseStorage: dynamic,
		authenticationProcessTemplateParameters: AuthenticationProcessTemplateParametersJs?,
		options: SdkOptionsJs?
	): Promise<AuthenticationWithProcessStepJs> = GlobalScope.promise {
		val ktStep = CardinalSdk.initializeWithProcess(
			applicationId,
			baseUrl,
			messageGatewayUrl,
			externalServicesSpecId,
			processId,
			AuthenticationProcessTelecomType.valueOf(userTelecomType),
			userTelecom,
			captchaOptions_fromJs(captchaOptions),
			loadStorageOptions(baseStorage),
			authenticationProcessTemplateParameters?.toKt() ?: AuthenticationProcessTemplateParameters(),
			options?.toKt() ?: SdkOptions()
		)
		object : AuthenticationWithProcessStepJs {
			override fun completeAuthentication(validationCode: String): Promise<CardinalSdkJs> = GlobalScope.promise {
				CardinalSdkJsImpl(ktStep.completeAuthentication(validationCode))
			}
		}
	}

	fun initializeBase(
		applicationId: String?,
		baseUrl: String,
		authenticationMethod: AuthenticationMethodJs,
		options: BasicSdkOptionsJs?
	): Promise<CardinalBaseSdkJs> = GlobalScope.promise {
		CardinalBaseSdkJsImpl(
			CardinalBaseSdk.initialize(
				applicationId,
				baseUrl,
				authenticationMethod.toKt(),
				options?.toKt() ?: BasicSdkOptions()
			),
			options?.cryptoService ?: adaptCryptoServiceForExternal(defaultCryptoService)
		)
	}

	fun initializeWithProcessBase(
		applicationId: String?,
		baseUrl: String,
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: String,
		userTelecom: String,
		captchaOptions: CaptchaOptionsJs,
		authenticationProcessTemplateParameters: AuthenticationProcessTemplateParametersJs?,
		options: BasicSdkOptionsJs?
	): Promise<BaseAuthenticationWithProcessStepJs> = GlobalScope.promise {
		val ktStep = CardinalBaseSdk.initializeWithProcess(
			applicationId,
			baseUrl,
			messageGatewayUrl,
			externalServicesSpecId,
			processId,
			AuthenticationProcessTelecomType.valueOf(userTelecomType),
			userTelecom,
			captchaOptions_fromJs(captchaOptions),
			authenticationProcessTemplateParameters?.toKt() ?: AuthenticationProcessTemplateParameters(),
			options?.toKt() ?: BasicSdkOptions()
		)
		object : BaseAuthenticationWithProcessStepJs {
			override fun completeAuthentication(validationCode: String): Promise<CardinalBaseSdkJs> = GlobalScope.promise {
				CardinalBaseSdkJsImpl(
					ktStep.completeAuthentication(validationCode),
					options?.cryptoService ?: adaptCryptoServiceForExternal(defaultCryptoService)
				)
			}
		}
	}

	fun initializeAnonymous(
		baseUrl: String,
		options: AnonymousSdkOptionsJs?
	): CardinalAnonymousSdkJs = CardinalAnonymousSdkJsImpl(
		CardinalAnonymousSdk.initialize(
			baseUrl,
			options?.toKt() ?: AnonymousSdkOptions()
		)
	)
}

internal class CardinalApisJsImpl(
	private val sdk: CardinalApis
) : CardinalApisJs {
	override val auth: AuthApiJs by lazy { AuthApiImplJs(sdk.auth) }
	override val applicationSettings: ApplicationSettingsApiJs by lazy { ApplicationSettingsApiImplJs(sdk.applicationSettings) }
	override val code: CodeApiJs by lazy { CodeApiImplJs(sdk.code) }
	override val device: DeviceApiJs by lazy { DeviceApiImplJs(sdk.device) }
	override val documentTemplate: DocumentTemplateApiJs by lazy { DocumentTemplateApiImplJs(sdk.documentTemplate) }
	override val entityReference: EntityReferenceApiJs by lazy { EntityReferenceApiImplJs(sdk.entityReference) }
	override val entityTemplate: EntityTemplateApiJs by lazy { EntityTemplateApiImplJs(sdk.entityTemplate) }
	override val frontEndMigration: FrontEndMigrationApiJs by lazy { FrontEndMigrationApiImplJs(sdk.frontEndMigration) }
	override val group: GroupApiJs by lazy { GroupApiImplJs(sdk.group) }
	override val healthcareParty: HealthcarePartyApiJs by lazy { HealthcarePartyApiImplJs(sdk.healthcareParty) }
	override val system: SystemApiJs by lazy { SystemApiImplJs(sdk.system) }
	override val insurance: InsuranceApiJs by lazy { InsuranceApiImplJs(sdk.insurance) }
	override val keyword: KeywordApiJs by lazy { KeywordApiImplJs(sdk.keyword) }
	override val permission: PermissionApiJs by lazy { PermissionApiImplJs(sdk.permission) }
	override val place: PlaceApiJs by lazy { PlaceApiImplJs(sdk.place) }
	override val role: RoleApiJs by lazy { RoleApiImplJs(sdk.role) }
	override val tarification: TarificationApiJs by lazy { TarificationApiImplJs(sdk.tarification) }
	override val user: UserApiJs by lazy { UserApiImplJs(sdk.user) }
	override val medicalLocation: MedicalLocationApiJs by lazy { MedicalLocationApiImplJs(sdk.medicalLocation) }
	override val agenda: AgendaApiJs by lazy { AgendaApiImplJs(sdk.agenda) }
	override val accessLog: AccessLogApiJs by lazy { AccessLogApiImplJs(sdk.accessLog) }
	override val calendarItem: CalendarItemApiJs by lazy { CalendarItemApiImplJs(sdk.calendarItem) }
	override val classification: ClassificationApiJs by lazy { ClassificationApiImplJs(sdk.classification) }
	override val contact: ContactApiJs by lazy { ContactApiImplJs(sdk.contact) }
	override val document: DocumentApiJs by lazy { DocumentApiImplJs(sdk.document) }
	override val form: FormApiJs by lazy { FormApiImplJs(sdk.form) }
	override val healthElement: HealthElementApiJs by lazy { HealthElementApiImplJs(sdk.healthElement) }
	override val invoice: InvoiceApiJs by lazy { InvoiceApiImplJs(sdk.invoice) }
	override val maintenanceTask: MaintenanceTaskApiJs by lazy { MaintenanceTaskApiImplJs(sdk.maintenanceTask) }
	override val message: MessageApiJs by lazy { MessageApiImplJs(sdk.message) }
	override val patient: PatientApiJs by lazy { PatientApiImplJs(sdk.patient) }
	override val receipt: ReceiptApiJs by lazy { ReceiptApiImplJs(sdk.receipt) }
	override val timeTable: TimeTableApiJs by lazy { TimeTableApiImplJs(sdk.timeTable) }
	override val topic: TopicApiJs by lazy { TopicApiImplJs(sdk.topic) }
	override val crypto: CryptoApiJs by lazy { CryptoApiImplJs(sdk.crypto) }
	override val recovery: RecoveryApiJs by lazy { RecoveryApiImplJs(sdk.recovery) }
	override val cardinalMaintenanceTask: CardinalMaintenanceTaskApiJs by lazy { CardinalMaintenanceTaskApiImplJs(sdk.cardinalMaintenanceTask) }
	override val dataOwner: DataOwnerApiJs by lazy { DataOwnerApiImplJs(sdk.dataOwner) }
	override val calendarItemType: CalendarItemTypeApiJs by lazy { CalendarItemTypeApiImplJs(sdk.calendarItemType) }
}

internal class CardinalSdkJsImpl(
	private val sdk: CardinalSdk
) : CardinalSdkJs, CardinalApisJs by CardinalApisJsImpl(sdk) {
	override fun switchGroup(groupId: String): Promise<CardinalSdkJs> = GlobalScope.promise {
		CardinalSdkJsImpl(sdk.switchGroup(groupId))
	}

	override fun changeScope(dataOwnerId: String): Promise<CardinalSdkJs> = GlobalScope.promise {
		CardinalSdkJsImpl(sdk.changeScope(dataOwnerId))
	}

	override fun close() {
		sdk.scope.cancel()
	}
}

internal class CardinalBaseApisJsImpl(
	private val sdk: CardinalBaseApis
) : CardinalBaseApisJs {
	override val auth: AuthApiJs by lazy { AuthApiImplJs(sdk.auth) }
	override val applicationSettings: ApplicationSettingsApiJs by lazy { ApplicationSettingsApiImplJs(sdk.applicationSettings) }
	override val code: CodeApiJs by lazy { CodeApiImplJs(sdk.code) }
	override val device: DeviceApiJs by lazy { DeviceApiImplJs(sdk.device) }
	override val documentTemplate: DocumentTemplateApiJs by lazy { DocumentTemplateApiImplJs(sdk.documentTemplate) }
	override val entityReference: EntityReferenceApiJs by lazy { EntityReferenceApiImplJs(sdk.entityReference) }
	override val entityTemplate: EntityTemplateApiJs by lazy { EntityTemplateApiImplJs(sdk.entityTemplate) }
	override val frontEndMigration: FrontEndMigrationApiJs by lazy { FrontEndMigrationApiImplJs(sdk.frontEndMigration) }
	override val group: GroupApiJs by lazy { GroupApiImplJs(sdk.group) }
	override val healthcareParty: HealthcarePartyApiJs by lazy { HealthcarePartyApiImplJs(sdk.healthcareParty) }
	override val system: SystemApiJs by lazy { SystemApiImplJs(sdk.system) }
	override val insurance: InsuranceApiJs by lazy { InsuranceApiImplJs(sdk.insurance) }
	override val keyword: KeywordApiJs by lazy { KeywordApiImplJs(sdk.keyword) }
	override val permission: PermissionApiJs by lazy { PermissionApiImplJs(sdk.permission) }
	override val place: PlaceApiJs by lazy { PlaceApiImplJs(sdk.place) }
	override val role: RoleApiJs by lazy { RoleApiImplJs(sdk.role) }
	override val tarification: TarificationApiJs by lazy { TarificationApiImplJs(sdk.tarification) }
	override val user: UserApiJs by lazy { UserApiImplJs(sdk.user) }
	override val medicalLocation: MedicalLocationApiJs by lazy { MedicalLocationApiImplJs(sdk.medicalLocation) }
	override val agenda: AgendaApiJs by lazy { AgendaApiImplJs(sdk.agenda) }
	override val accessLog: AccessLogBasicApiJs by lazy { AccessLogBasicApiImplJs(sdk.accessLog) }
	override val calendarItem: CalendarItemBasicApiJs by lazy { CalendarItemBasicApiImplJs(sdk.calendarItem) }
	override val classification: ClassificationBasicApiJs by lazy { ClassificationBasicApiImplJs(sdk.classification) }
	override val contact: ContactBasicApiJs by lazy { ContactBasicApiImplJs(sdk.contact) }
	override val document: DocumentBasicApiJs by lazy { DocumentBasicApiImplJs(sdk.document) }
	override val form: FormBasicApiJs by lazy { FormBasicApiImplJs(sdk.form) }
	override val healthElement: HealthElementBasicApiJs by lazy { HealthElementBasicApiImplJs(sdk.healthElement) }
	override val invoice: InvoiceBasicApiJs by lazy { InvoiceBasicApiImplJs(sdk.invoice) }
	override val maintenanceTask: MaintenanceTaskBasicApiJs by lazy { MaintenanceTaskBasicApiImplJs(sdk.maintenanceTask) }
	override val message: MessageBasicApiJs by lazy { MessageBasicApiImplJs(sdk.message) }
	override val patient: PatientBasicApiJs by lazy { PatientBasicApiImplJs(sdk.patient) }
	override val receipt: ReceiptBasicApiJs by lazy { ReceiptBasicApiImplJs(sdk.receipt) }
	override val timeTable: TimeTableApiJs by lazy { TimeTableApiImplJs(sdk.timeTable) }
	override val topic: TopicBasicApiJs by lazy { TopicBasicApiImplJs(sdk.topic) }
	override val calendarItemType: CalendarItemTypeApiJs by lazy { CalendarItemTypeApiImplJs(sdk.calendarItemType) }
}

internal class CardinalBaseSdkJsImpl(
	private val sdk: CardinalBaseSdk,
	private val jsCryptoService: XCryptoService
) : CardinalBaseSdkJs, CardinalBaseApisJs by CardinalBaseApisJsImpl(sdk) {
	override fun switchGroup(groupId: String): Promise<CardinalBaseSdkJs> = GlobalScope.promise {
		CardinalBaseSdkJsImpl(sdk.switchGroup(groupId), jsCryptoService)
	}

	override fun changeScope(dataOwnerId: String): Promise<CardinalBaseSdkJs> = GlobalScope.promise {
		CardinalBaseSdkJsImpl(sdk.changeScope(dataOwnerId), jsCryptoService)
	}

	override fun toFullSdk(baseStorage: dynamic, options: BasicToFullSdkOptionsJs?): Promise<CardinalSdkJs> = GlobalScope.promise {
		val storageFacade = loadStorageOptions(baseStorage)
		val ktOptions = options?.toKt(jsCryptoService) ?: BasicToFullSdkOptions()
		CardinalSdkJsImpl(sdk.toFullSdk(storageFacade, ktOptions))
	}
}


internal class CardinalAnonymousApisJsImpl(
	private val sdk: CardinalAnonymousApis
) : CardinalAnonymousApisJs {
	override val agenda: AnonymousAgendaApiJs by lazy { AnonymousAgendaApiImplJs(sdk.agenda) }
	override val healthcareParty: AnonymousHealthcarePartyApiJs by lazy { AnonymousHealthcarePartyApiImplJs(sdk.healthcareParty) }
}

internal class CardinalAnonymousSdkJsImpl(
	private val sdk: CardinalAnonymousSdk
) : CardinalAnonymousSdkJs, CardinalAnonymousApisJs by CardinalAnonymousApisJsImpl(sdk)
