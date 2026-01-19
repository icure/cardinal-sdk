// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.AccessLogBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object AccessLogBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "matchAccessLogsBy" -> matchAccessLogsBy(parameters, resultCallback)
    "matchAccessLogsBySorted" -> matchAccessLogsBySorted(parameters, resultCallback)
    "filterAccessLogsBy" -> filterAccessLogsBy(parameters, resultCallback)
    "filterAccessLogsBySorted" -> filterAccessLogsBySorted(parameters, resultCallback)
    "deleteAccessLogById" -> deleteAccessLogById(parameters, resultCallback)
    "deleteAccessLogsByIds" -> deleteAccessLogsByIds(parameters, resultCallback)
    "purgeAccessLogById" -> purgeAccessLogById(parameters, resultCallback)
    "deleteAccessLog" -> deleteAccessLog(parameters, resultCallback)
    "deleteAccessLogs" -> deleteAccessLogs(parameters, resultCallback)
    "purgeAccessLog" -> purgeAccessLog(parameters, resultCallback)
    "createAccessLog" -> createAccessLog(parameters, resultCallback)
    "undeleteAccessLogById" -> undeleteAccessLogById(parameters, resultCallback)
    "undeleteAccessLog" -> undeleteAccessLog(parameters, resultCallback)
    "modifyAccessLog" -> modifyAccessLog(parameters, resultCallback)
    "getAccessLog" -> getAccessLog(parameters, resultCallback)
    "getAccessLogs" -> getAccessLogs(parameters, resultCallback)
    "inGroup.matchAccessLogsBy" -> inGroup_matchAccessLogsBy(parameters, resultCallback)
    "inGroup.matchAccessLogsBySorted" -> inGroup_matchAccessLogsBySorted(parameters, resultCallback)
    "inGroup.filterAccessLogsBy" -> inGroup_filterAccessLogsBy(parameters, resultCallback)
    "inGroup.filterAccessLogsBySorted" -> inGroup_filterAccessLogsBySorted(parameters, resultCallback)
    "inGroup.deleteAccessLogById" -> inGroup_deleteAccessLogById(parameters, resultCallback)
    "inGroup.deleteAccessLogsByIds" -> inGroup_deleteAccessLogsByIds(parameters, resultCallback)
    "inGroup.deleteAccessLog" -> inGroup_deleteAccessLog(parameters, resultCallback)
    "inGroup.deleteAccessLogs" -> inGroup_deleteAccessLogs(parameters, resultCallback)
    "inGroup.createAccessLog" -> inGroup_createAccessLog(parameters, resultCallback)
    "inGroup.modifyAccessLog" -> inGroup_modifyAccessLog(parameters, resultCallback)
    "inGroup.getAccessLog" -> inGroup_getAccessLog(parameters, resultCallback)
    "inGroup.getAccessLogs" -> inGroup_getAccessLogs(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchAccessLogsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.matchAccessLogsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchAccessLogsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.matchAccessLogsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterAccessLogsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.filterAccessLogsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterAccessLogsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.filterAccessLogsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.deleteAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteAccessLogsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.deleteAccessLogsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.purgeAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.deleteAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun deleteAccessLogs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.deleteAccessLogs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLogs"),
    )
  }

  private fun purgeAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.purgeAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun createAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.createAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.undeleteAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.undeleteAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun modifyAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.modifyAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.getAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getAccessLogs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.getAccessLogs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun inGroup_matchAccessLogsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.matchAccessLogsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_matchAccessLogsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.matchAccessLogsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_filterAccessLogsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.filterAccessLogsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_filterAccessLogsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.filterAccessLogsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_deleteAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.deleteAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun inGroup_deleteAccessLogsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.deleteAccessLogsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun inGroup_deleteAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.deleteAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun inGroup_deleteAccessLogs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.deleteAccessLogs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLogs"),
    )
  }

  private fun inGroup_createAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.createAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun inGroup_modifyAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.modifyAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun inGroup_getAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.getAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityId"),
    )
  }

  private fun inGroup_getAccessLogs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogBasicApi.inGroup.getAccessLogs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityIds"),
    )
  }
}
