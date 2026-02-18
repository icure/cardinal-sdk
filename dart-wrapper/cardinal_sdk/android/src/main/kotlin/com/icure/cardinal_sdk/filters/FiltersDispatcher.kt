// auto-generated file
package com.icure.cardinal_sdk.filters

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public fun dispatchFilter(
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
  "FormFilters" -> FormFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "AccessLogFilters" -> AccessLogFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "ContactFilters" -> ContactFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "PatientFilters" -> PatientFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "DeviceFilters" -> DeviceFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "UserFilters" -> UserFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "ClassificationFilters" -> ClassificationFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "CodeFilters" -> CodeFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "GroupFilters" -> GroupFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "TopicFilters" -> TopicFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "HealthcarePartyFilters" -> HealthcarePartyFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "CalendarItemFilters" -> CalendarItemFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "DocumentFilters" -> DocumentFiltersDispatcher.dispatch(methodName, parameters, resultCallback)

  "MaintenanceTaskFilters" -> MaintenanceTaskFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "ServiceFilters" -> ServiceFiltersDispatcher.dispatch(methodName, parameters, resultCallback)

  "MessageFilters" -> MessageFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "AgendaFilters" -> AgendaFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "HealthElementFilters" -> HealthElementFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  "MetaFilters" -> MetaFiltersDispatcher.dispatch(methodName, parameters, resultCallback)
  else -> false
}
