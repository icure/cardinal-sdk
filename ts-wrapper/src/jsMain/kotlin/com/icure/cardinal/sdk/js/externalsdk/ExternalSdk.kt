@file:JsQualifier("sdk")
package com.icure.cardinal.sdk.js.externalsdk

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
import com.icure.cardinal.sdk.js.options.external.BasicToFullSdkOptionsJs
import kotlin.js.Promise

@JsName("CardinalApis")
external interface CardinalApisJs {
	val auth: AuthApiJs
	val applicationSettings: ApplicationSettingsApiJs
	val code: CodeApiJs
	val device: DeviceApiJs
	val documentTemplate: DocumentTemplateApiJs
	val entityReference: EntityReferenceApiJs
	val entityTemplate: EntityTemplateApiJs
	val frontEndMigration: FrontEndMigrationApiJs
	val group: GroupApiJs
	val healthcareParty: HealthcarePartyApiJs
	val system: SystemApiJs
	val insurance: InsuranceApiJs
	val keyword: KeywordApiJs
	val permission: PermissionApiJs
	val place: PlaceApiJs
	val role: RoleApiJs
	val tarification: TarificationApiJs
	val user: UserApiJs
	val medicalLocation: MedicalLocationApiJs
	val agenda: AgendaApiJs
	val accessLog: AccessLogApiJs
	val calendarItem: CalendarItemApiJs
	val classification: ClassificationApiJs
	val contact: ContactApiJs
	val document: DocumentApiJs
	val form: FormApiJs
	val healthElement: HealthElementApiJs
	val invoice: InvoiceApiJs
	val maintenanceTask: MaintenanceTaskApiJs
	val message: MessageApiJs
	val patient: PatientApiJs
	val receipt: ReceiptApiJs
	val timeTable: TimeTableApiJs
	val topic: TopicApiJs
	val crypto: CryptoApiJs
	val recovery: RecoveryApiJs
	val cardinalMaintenanceTask: CardinalMaintenanceTaskApiJs
	val dataOwner: DataOwnerApiJs
	val calendarItemType: CalendarItemTypeApiJs
}

@JsName("CardinalSdk")
external interface CardinalSdkJs : CardinalApisJs {
	fun switchGroup(groupId: String): Promise<CardinalSdkJs>
	fun changeScope(dataOwnerId: String): Promise<CardinalSdkJs>
	fun close()
}

@JsName("CardinalBaseApis")
external interface CardinalBaseApisJs {
	val auth: AuthApiJs
	val applicationSettings: ApplicationSettingsApiJs
	val code: CodeApiJs
	val device: DeviceApiJs
	val documentTemplate: DocumentTemplateApiJs
	val entityReference: EntityReferenceApiJs
	val entityTemplate: EntityTemplateApiJs
	val frontEndMigration: FrontEndMigrationApiJs
	val group: GroupApiJs
	val healthcareParty: HealthcarePartyApiJs
	val system: SystemApiJs
	val insurance: InsuranceApiJs
	val keyword: KeywordApiJs
	val permission: PermissionApiJs
	val place: PlaceApiJs
	val role: RoleApiJs
	val tarification: TarificationApiJs
	val user: UserApiJs
	val medicalLocation: MedicalLocationApiJs
	val agenda: AgendaApiJs
	val accessLog: AccessLogBasicApiJs
	val calendarItem: CalendarItemBasicApiJs
	val classification: ClassificationBasicApiJs
	val contact: ContactBasicApiJs
	val document: DocumentBasicApiJs
	val form: FormBasicApiJs
	val healthElement: HealthElementBasicApiJs
	val invoice: InvoiceBasicApiJs
	val maintenanceTask: MaintenanceTaskBasicApiJs
	val message: MessageBasicApiJs
	val patient: PatientBasicApiJs
	val receipt: ReceiptBasicApiJs
	val timeTable: TimeTableApiJs
	val topic: TopicBasicApiJs
	val calendarItemType: CalendarItemTypeApiJs
}

@JsName("CardinalBaseSdk")
external interface CardinalBaseSdkJs : CardinalBaseApisJs {
	fun switchGroup(groupId: String): Promise<CardinalBaseSdkJs>
	fun changeScope(dataOwnerId: String): Promise<CardinalBaseSdkJs>
	fun toFullSdk(baseStorage: dynamic, options: BasicToFullSdkOptionsJs?): Promise<CardinalSdkJs>
}

@JsName("CardinalAnonymousApis")
external interface CardinalAnonymousApisJs {
	val agenda: AnonymousAgendaApiJs
	val healthcareParty: AnonymousHealthcarePartyApiJs
}

@JsName("CardinalAnonymousSdk")
external interface CardinalAnonymousSdkJs : CardinalAnonymousApisJs {
}
