// auto-generated file
package com.icure.cardinal_sdk.api

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public fun dispatchApi(
  apiName: String,
  methodName: String,
  parameters: Map<String, String>,
  resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit,
): Boolean = when (apiName) {
  "KeywordApi" -> KeywordApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "DeviceApi" -> DeviceApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "AccessLogBasicApi" -> AccessLogBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "PlaceApi" -> PlaceApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "MedicalLocationApi" -> MedicalLocationApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "TimeTableApi" -> TimeTableApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "DocumentBasicApi" -> DocumentBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "PatientBasicApi" -> PatientBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "ClassificationApi" -> ClassificationApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "CalendarItemBasicApi" -> CalendarItemBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "MaintenanceTaskApi" -> MaintenanceTaskApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "FormBasicApi" -> FormBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "RecoveryApi" -> RecoveryApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "PatientApi" -> PatientApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "MaintenanceTaskBasicApi" -> MaintenanceTaskBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "TarificationApi" -> TarificationApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "ContactApi" -> ContactApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "ReceiptApi" -> ReceiptApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "AnonymousAgendaApi" -> AnonymousAgendaApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "HealthcarePartyApi" -> HealthcarePartyApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "AccessLogApi" -> AccessLogApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "PermissionApi" -> PermissionApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "CodeApi" -> CodeApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "FrontEndMigrationApi" -> FrontEndMigrationApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "TopicApi" -> TopicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "DocumentTemplateApi" -> DocumentTemplateApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "HealthElementBasicApi" -> HealthElementBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "SystemApi" -> SystemApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "ContactBasicApi" -> ContactBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "CalendarItemApi" -> CalendarItemApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "ApplicationSettingsApi" -> ApplicationSettingsApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "CryptoApi" -> CryptoApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "ReceiptBasicApi" -> ReceiptBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "EntityReferenceApi" -> EntityReferenceApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "ClassificationBasicApi" -> ClassificationBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "ShamirKeysManagerApi" -> ShamirKeysManagerApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "DocumentApi" -> DocumentApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "EntityTemplateApi" -> EntityTemplateApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "AuthApi" -> AuthApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "DataOwnerApi" -> DataOwnerApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "UserApi" -> UserApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "RoleApi" -> RoleApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "AnonymousHealthcarePartyApi" -> AnonymousHealthcarePartyApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "MessageBasicApi" -> MessageBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "FormApi" -> FormApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "CardinalMaintenanceTaskApi" -> CardinalMaintenanceTaskApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "InvoiceApi" -> InvoiceApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "MessageApi" -> MessageApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "HealthElementApi" -> HealthElementApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "InvoiceBasicApi" -> InvoiceBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "CalendarItemTypeApi" -> CalendarItemTypeApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "TopicBasicApi" -> TopicBasicApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "InsuranceApi" -> InsuranceApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "AgendaApi" -> AgendaApiDispatcher.dispatch(methodName, parameters, resultCallback)
  "GroupApi" -> GroupApiDispatcher.dispatch(methodName, parameters, resultCallback)
  else -> false
}
