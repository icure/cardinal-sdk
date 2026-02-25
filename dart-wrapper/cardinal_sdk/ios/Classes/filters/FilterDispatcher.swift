// auto-generated file
func dispatchFilters(
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
  case "FormFilters": return FormFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "AccessLogFilters": return AccessLogFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ContactFilters": return ContactFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "PatientFilters": return PatientFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "DeviceFilters": return DeviceFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "UserFilters": return UserFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ClassificationFilters": return ClassificationFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "CodeFilters": return CodeFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "GroupFilters": return GroupFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "TopicFilters": return TopicFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "HealthcarePartyFilters": return HealthcarePartyFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "CalendarItemFilters": return CalendarItemFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "DocumentFilters": return DocumentFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)

  case "MaintenanceTaskFilters": return MaintenanceTaskFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "ServiceFilters": return ServiceFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)

  case "MessageFilters": return MessageFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "AgendaFilters": return AgendaFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "HealthElementFilters": return HealthElementFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  case "MetaFilters": return MetaFiltersDispatcher.dispatch(methodName: methodName, parameters: parameters, resultCallback: resultCallback)
  default: return false
  }
}
