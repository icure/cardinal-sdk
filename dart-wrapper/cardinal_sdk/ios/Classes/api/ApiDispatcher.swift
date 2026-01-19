// auto-generated file
func dispatchApi(
  apiName: String,
  methodName: String,
  parameters: [String : String],
  resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void
) -> Bool {
  switch apiName {
  case "KeywordApi": return KeywordApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "DeviceApi": return DeviceApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "AccessLogBasicApi": return AccessLogBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "PlaceApi": return PlaceApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "MedicalLocationApi": return MedicalLocationApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "TimeTableApi": return TimeTableApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "DocumentBasicApi": return DocumentBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "PatientBasicApi": return PatientBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ClassificationApi": return ClassificationApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "CalendarItemBasicApi": return CalendarItemBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "MaintenanceTaskApi": return MaintenanceTaskApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "FormBasicApi": return FormBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "RecoveryApi": return RecoveryApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "PatientApi": return PatientApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "MaintenanceTaskBasicApi": return MaintenanceTaskBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "TarificationApi": return TarificationApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ContactApi": return ContactApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ReceiptApi": return ReceiptApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "HealthcarePartyApi": return HealthcarePartyApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "AccessLogApi": return AccessLogApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "PermissionApi": return PermissionApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "CodeApi": return CodeApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "FrontEndMigrationApi": return FrontEndMigrationApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "TopicApi": return TopicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "DocumentTemplateApi": return DocumentTemplateApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "HealthElementBasicApi": return HealthElementBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "SystemApi": return SystemApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ContactBasicApi": return ContactBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "CalendarItemApi": return CalendarItemApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ApplicationSettingsApi": return ApplicationSettingsApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "CryptoApi": return CryptoApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ReceiptBasicApi": return ReceiptBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "EntityReferenceApi": return EntityReferenceApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ClassificationBasicApi": return ClassificationBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ShamirKeysManagerApi": return ShamirKeysManagerApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "DocumentApi": return DocumentApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "EntityTemplateApi": return EntityTemplateApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "AuthApi": return AuthApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "DataOwnerApi": return DataOwnerApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "UserApi": return UserApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "RoleApi": return RoleApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "MessageBasicApi": return MessageBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "FormApi": return FormApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "CardinalMaintenanceTaskApi": return CardinalMaintenanceTaskApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "InvoiceApi": return InvoiceApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "MessageApi": return MessageApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "HealthElementApi": return HealthElementApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "InvoiceBasicApi": return InvoiceBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "CalendarItemTypeApi": return CalendarItemTypeApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "TopicBasicApi": return TopicBasicApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "InsuranceApi": return InsuranceApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "AgendaApi": return AgendaApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "GroupApi": return GroupApiDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  default: return false
  }
}
