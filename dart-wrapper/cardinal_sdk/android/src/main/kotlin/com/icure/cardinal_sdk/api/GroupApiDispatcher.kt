// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.GroupApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object GroupApiDispatcher {
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
    "listGroups" -> listGroups(parameters, resultCallback)
    "getGroup" -> getGroup(parameters, resultCallback)
    "createGroup" -> createGroup(parameters, resultCallback)
    "registerNewGroupAdministrator" -> registerNewGroupAdministrator(parameters, resultCallback)
    "listApps" -> listApps(parameters, resultCallback)
    "getNameOfGroupParent" -> getNameOfGroupParent(parameters, resultCallback)
    "modifyGroupName" -> modifyGroupName(parameters, resultCallback)
    "getOperationToken" -> getOperationToken(parameters, resultCallback)
    "deleteOperationToken" -> deleteOperationToken(parameters, resultCallback)
    "setDefaultRoles" -> setDefaultRoles(parameters, resultCallback)
    "getDefaultRoles" -> getDefaultRoles(parameters, resultCallback)
    "deleteGroup" -> deleteGroup(parameters, resultCallback)
    "changeSuperGroup" -> changeSuperGroup(parameters, resultCallback)
    "hardDeleteGroup" -> hardDeleteGroup(parameters, resultCallback)
    "modifyGroupProperties" -> modifyGroupProperties(parameters, resultCallback)
    "setGroupPassword" -> setGroupPassword(parameters, resultCallback)
    "initDesignDocs" -> initDesignDocs(parameters, resultCallback)
    "solveConflicts" -> solveConflicts(parameters, resultCallback)
    "resetStorage" -> resetStorage(parameters, resultCallback)
    "getGroupsStorageInfos" -> getGroupsStorageInfos(parameters, resultCallback)
    "getReplicationInfo" -> getReplicationInfo(parameters, resultCallback)
    "getHierarchy" -> getHierarchy(parameters, resultCallback)
    "listAllGroupsIds" -> listAllGroupsIds(parameters, resultCallback)
    "createOrUpdateExternalJwtConfig" -> createOrUpdateExternalJwtConfig(parameters, resultCallback)
    "removeExternalJwtConfig" -> removeExternalJwtConfig(parameters, resultCallback)
    "getOperationTokenForGroup" -> getOperationTokenForGroup(parameters, resultCallback)
    "setGroupProjectId" -> setGroupProjectId(parameters, resultCallback)
    "modifyGroupApplicationId" -> modifyGroupApplicationId(parameters, resultCallback)
    "addTagToGroup" -> addTagToGroup(parameters, resultCallback)
    "removeTagFromGroup" -> removeTagFromGroup(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun listGroups(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.listGroups(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.getGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun createGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.createGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("name"),
      parameters.getValue("type"),
      parameters.getValue("password"),
      parameters.getValue("server"),
      parameters.getValue("q"),
      parameters.getValue("n"),
      parameters.getValue("superGroup"),
      parameters.getValue("projectId"),
      parameters.getValue("initialisationData"),
    )
  }

  private fun registerNewGroupAdministrator(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.registerNewGroupAdministrator(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("type"),
      parameters.getValue("role"),
      parameters.getValue("registrationInformation"),
    )
  }

  private fun listApps(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.listApps(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getNameOfGroupParent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.getNameOfGroupParent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun modifyGroupName(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.modifyGroupName(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("name"),
    )
  }

  private fun getOperationToken(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.getOperationToken(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("operation"),
      parameters.getValue("duration"),
      parameters.getValue("description"),
    )
  }

  private fun deleteOperationToken(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.deleteOperationToken(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("tokenId"),
    )
  }

  private fun setDefaultRoles(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.setDefaultRoles(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("userType"),
      parameters.getValue("roleIds"),
    )
  }

  private fun getDefaultRoles(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.getDefaultRoles(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
    )
  }

  private fun deleteGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.deleteGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun changeSuperGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.changeSuperGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("childGroupId"),
      parameters.getValue("operationToken"),
    )
  }

  private fun hardDeleteGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.hardDeleteGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun modifyGroupProperties(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.modifyGroupProperties(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("properties"),
    )
  }

  private fun setGroupPassword(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.setGroupPassword(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("password"),
    )
  }

  private fun initDesignDocs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.initDesignDocs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("clazz"),
      parameters.getValue("warmup"),
      parameters.getValue("dryRun"),
    )
  }

  private fun solveConflicts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.solveConflicts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("limit"),
      parameters.getValue("warmup"),
    )
  }

  private fun resetStorage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.resetStorage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("q"),
      parameters.getValue("n"),
      parameters.getValue("databases"),
    )
  }

  private fun getGroupsStorageInfos(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.getGroupsStorageInfos(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groups"),
    )
  }

  private fun getReplicationInfo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.getReplicationInfo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun getHierarchy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.getHierarchy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun listAllGroupsIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.listAllGroupsIds(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun createOrUpdateExternalJwtConfig(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.createOrUpdateExternalJwtConfig(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("key"),
      parameters.getValue("config"),
    )
  }

  private fun removeExternalJwtConfig(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.removeExternalJwtConfig(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("key"),
    )
  }

  private fun getOperationTokenForGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.getOperationTokenForGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("operation"),
      parameters.getValue("duration"),
      parameters.getValue("description"),
    )
  }

  private fun setGroupProjectId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.setGroupProjectId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("projectId"),
      parameters.getValue("applyToSubgroups"),
    )
  }

  private fun modifyGroupApplicationId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.modifyGroupApplicationId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("applicationId"),
    )
  }

  private fun addTagToGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.addTagToGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
      parameters.getValue("tag"),
    )
  }

  private fun removeTagFromGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupApi.removeTagFromGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
      parameters.getValue("tagId"),
    )
  }
}
