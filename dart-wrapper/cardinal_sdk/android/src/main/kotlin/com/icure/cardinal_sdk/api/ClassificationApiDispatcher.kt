// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.ClassificationApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ClassificationApiDispatcher {
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
    "matchClassificationsBy" -> matchClassificationsBy(parameters, resultCallback)
    "matchClassificationsBySorted" -> matchClassificationsBySorted(parameters, resultCallback)
    "deleteClassification" -> deleteClassification(parameters, resultCallback)
    "deleteClassifications" -> deleteClassifications(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterClassificationsBy" -> filterClassificationsBy(parameters, resultCallback)
    "filterClassificationsBySorted" -> filterClassificationsBySorted(parameters, resultCallback)
    "createClassification" -> createClassification(parameters, resultCallback)
    "modifyClassification" -> modifyClassification(parameters, resultCallback)
    "getClassification" -> getClassification(parameters, resultCallback)
    "getClassifications" -> getClassifications(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterClassificationsBy" -> encrypted_filterClassificationsBy(parameters, resultCallback)
    "encrypted.filterClassificationsBySorted" -> encrypted_filterClassificationsBySorted(parameters, resultCallback)
    "encrypted.createClassification" -> encrypted_createClassification(parameters, resultCallback)
    "encrypted.modifyClassification" -> encrypted_modifyClassification(parameters, resultCallback)
    "encrypted.getClassification" -> encrypted_getClassification(parameters, resultCallback)
    "encrypted.getClassifications" -> encrypted_getClassifications(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterClassificationsBy" -> tryAndRecover_filterClassificationsBy(parameters, resultCallback)
    "tryAndRecover.filterClassificationsBySorted" -> tryAndRecover_filterClassificationsBySorted(parameters, resultCallback)
    "tryAndRecover.createClassification" -> tryAndRecover_createClassification(parameters, resultCallback)
    "tryAndRecover.modifyClassification" -> tryAndRecover_modifyClassification(parameters, resultCallback)
    "tryAndRecover.getClassification" -> tryAndRecover_getClassification(parameters, resultCallback)
    "tryAndRecover.getClassifications" -> tryAndRecover_getClassifications(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.withEncryptionMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("base"),
      parameters.getValue("patient"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
      parameters.getValue("secretId"),
      parameters.getValue("alternateRootDelegateId"),
    )
  }

  private fun getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("classification"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("classification"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("classification"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.createDelegationDeAnonymizationMetadata(
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
    ClassificationApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("classification"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("classification"),
    )
  }

  private fun matchClassificationsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.matchClassificationsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchClassificationsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.matchClassificationsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.deleteClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun deleteClassifications(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.deleteClassifications(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("classification"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("classification"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterClassificationsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.filterClassificationsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterClassificationsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.filterClassificationsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.createClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.modifyClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.getClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getClassifications(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.getClassifications(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("classification"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("classification"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterClassificationsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.encrypted.filterClassificationsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterClassificationsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.encrypted.filterClassificationsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_createClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.encrypted.createClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_modifyClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.encrypted.modifyClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_getClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.encrypted.getClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getClassifications(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.encrypted.getClassifications(
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
    ClassificationApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("classification"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("classification"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterClassificationsBy(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.tryAndRecover.filterClassificationsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterClassificationsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.tryAndRecover.filterClassificationsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_createClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.tryAndRecover.createClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_modifyClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.tryAndRecover.modifyClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_getClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.tryAndRecover.getClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getClassifications(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationApi.tryAndRecover.getClassifications(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }
}
