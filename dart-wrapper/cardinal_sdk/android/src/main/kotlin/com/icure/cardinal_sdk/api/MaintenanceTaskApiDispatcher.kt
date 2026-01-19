// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.MaintenanceTaskApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MaintenanceTaskApiDispatcher {
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
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptPatientIdOf" -> decryptPatientIdOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "matchMaintenanceTasksBy" -> matchMaintenanceTasksBy(parameters, resultCallback)
    "matchMaintenanceTasksBySorted" -> matchMaintenanceTasksBySorted(parameters, resultCallback)
    "deleteMaintenanceTaskById" -> deleteMaintenanceTaskById(parameters, resultCallback)
    "deleteMaintenanceTasksByIds" -> deleteMaintenanceTasksByIds(parameters, resultCallback)
    "purgeMaintenanceTaskById" -> purgeMaintenanceTaskById(parameters, resultCallback)
    "deleteMaintenanceTask" -> deleteMaintenanceTask(parameters, resultCallback)
    "deleteMaintenanceTasks" -> deleteMaintenanceTasks(parameters, resultCallback)
    "purgeMaintenanceTask" -> purgeMaintenanceTask(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterMaintenanceTasksBy" -> filterMaintenanceTasksBy(parameters, resultCallback)
    "filterMaintenanceTasksBySorted" -> filterMaintenanceTasksBySorted(parameters, resultCallback)
    "createMaintenanceTask" -> createMaintenanceTask(parameters, resultCallback)
    "undeleteMaintenanceTask" -> undeleteMaintenanceTask(parameters, resultCallback)
    "undeleteMaintenanceTaskById" -> undeleteMaintenanceTaskById(parameters, resultCallback)
    "modifyMaintenanceTask" -> modifyMaintenanceTask(parameters, resultCallback)
    "getMaintenanceTask" -> getMaintenanceTask(parameters, resultCallback)
    "getMaintenanceTasks" -> getMaintenanceTasks(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterMaintenanceTasksBy" -> encrypted_filterMaintenanceTasksBy(parameters, resultCallback)
    "encrypted.filterMaintenanceTasksBySorted" -> encrypted_filterMaintenanceTasksBySorted(parameters, resultCallback)
    "encrypted.createMaintenanceTask" -> encrypted_createMaintenanceTask(parameters, resultCallback)
    "encrypted.undeleteMaintenanceTask" -> encrypted_undeleteMaintenanceTask(parameters, resultCallback)
    "encrypted.undeleteMaintenanceTaskById" -> encrypted_undeleteMaintenanceTaskById(parameters, resultCallback)
    "encrypted.modifyMaintenanceTask" -> encrypted_modifyMaintenanceTask(parameters, resultCallback)
    "encrypted.getMaintenanceTask" -> encrypted_getMaintenanceTask(parameters, resultCallback)
    "encrypted.getMaintenanceTasks" -> encrypted_getMaintenanceTasks(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterMaintenanceTasksBy" -> tryAndRecover_filterMaintenanceTasksBy(parameters, resultCallback)
    "tryAndRecover.filterMaintenanceTasksBySorted" -> tryAndRecover_filterMaintenanceTasksBySorted(parameters, resultCallback)
    "tryAndRecover.createMaintenanceTask" -> tryAndRecover_createMaintenanceTask(parameters, resultCallback)
    "tryAndRecover.undeleteMaintenanceTask" -> tryAndRecover_undeleteMaintenanceTask(parameters, resultCallback)
    "tryAndRecover.undeleteMaintenanceTaskById" -> tryAndRecover_undeleteMaintenanceTaskById(parameters, resultCallback)
    "tryAndRecover.modifyMaintenanceTask" -> tryAndRecover_modifyMaintenanceTask(parameters, resultCallback)
    "tryAndRecover.getMaintenanceTask" -> tryAndRecover_getMaintenanceTask(parameters, resultCallback)
    "tryAndRecover.getMaintenanceTasks" -> tryAndRecover_getMaintenanceTasks(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.withEncryptionMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
      parameters.getValue("alternateRootDelegateId"),
    )
  }

  private fun getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.createDelegationDeAnonymizationMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
      parameters.getValue("delegates"),
    )
  }

  private fun decrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun matchMaintenanceTasksBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.matchMaintenanceTasksBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchMaintenanceTasksBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.matchMaintenanceTasksBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteMaintenanceTaskById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.deleteMaintenanceTaskById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteMaintenanceTasksByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.deleteMaintenanceTasksByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeMaintenanceTaskById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.purgeMaintenanceTaskById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.deleteMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun deleteMaintenanceTasks(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.deleteMaintenanceTasks(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTasks"),
    )
  }

  private fun purgeMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.purgeMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("maintenanceTask"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterMaintenanceTasksBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.filterMaintenanceTasksBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterMaintenanceTasksBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.filterMaintenanceTasksBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.createMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.undeleteMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun undeleteMaintenanceTaskById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.undeleteMaintenanceTaskById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun modifyMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.modifyMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.getMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getMaintenanceTasks(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.getMaintenanceTasks(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("maintenanceTask"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterMaintenanceTasksBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.filterMaintenanceTasksBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterMaintenanceTasksBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.filterMaintenanceTasksBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_createMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.createMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeleteMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.undeleteMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun encrypted_undeleteMaintenanceTaskById(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.undeleteMaintenanceTaskById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_modifyMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.modifyMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_getMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.getMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getMaintenanceTasks(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.encrypted.getMaintenanceTasks(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("maintenanceTask"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterMaintenanceTasksBy(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterMaintenanceTasksBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_createMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.createMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeleteMaintenanceTask(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.undeleteMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun tryAndRecover_undeleteMaintenanceTaskById(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.undeleteMaintenanceTaskById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_modifyMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.modifyMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_getMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.getMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getMaintenanceTasks(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskApi.tryAndRecover.getMaintenanceTasks(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }
}
