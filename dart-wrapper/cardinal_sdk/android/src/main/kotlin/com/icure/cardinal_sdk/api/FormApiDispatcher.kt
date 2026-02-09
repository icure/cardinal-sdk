// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.FormApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object FormApiDispatcher {
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
    "matchFormsBy" -> matchFormsBy(parameters, resultCallback)
    "matchFormsBySorted" -> matchFormsBySorted(parameters, resultCallback)
    "deleteFormById" -> deleteFormById(parameters, resultCallback)
    "deleteFormsByIds" -> deleteFormsByIds(parameters, resultCallback)
    "purgeFormById" -> purgeFormById(parameters, resultCallback)
    "deleteForm" -> deleteForm(parameters, resultCallback)
    "deleteForms" -> deleteForms(parameters, resultCallback)
    "purgeForm" -> purgeForm(parameters, resultCallback)
    "getFormTemplate" -> getFormTemplate(parameters, resultCallback)
    "createFormTemplate" -> createFormTemplate(parameters, resultCallback)
    "deleteFormTemplate" -> deleteFormTemplate(parameters, resultCallback)
    "updateFormTemplate" -> updateFormTemplate(parameters, resultCallback)
    "setTemplateAttachment" -> setTemplateAttachment(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterFormsBy" -> filterFormsBy(parameters, resultCallback)
    "filterFormsBySorted" -> filterFormsBySorted(parameters, resultCallback)
    "createForm" -> createForm(parameters, resultCallback)
    "createForms" -> createForms(parameters, resultCallback)
    "modifyForm" -> modifyForm(parameters, resultCallback)
    "undeleteFormById" -> undeleteFormById(parameters, resultCallback)
    "undeleteForm" -> undeleteForm(parameters, resultCallback)
    "modifyForms" -> modifyForms(parameters, resultCallback)
    "getForm" -> getForm(parameters, resultCallback)
    "getForms" -> getForms(parameters, resultCallback)
    "getLatestFormByLogicalUuid" -> getLatestFormByLogicalUuid(parameters, resultCallback)
    "getLatestFormByUniqueId" -> getLatestFormByUniqueId(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterFormsBy" -> encrypted_filterFormsBy(parameters, resultCallback)
    "encrypted.filterFormsBySorted" -> encrypted_filterFormsBySorted(parameters, resultCallback)
    "encrypted.createForm" -> encrypted_createForm(parameters, resultCallback)
    "encrypted.createForms" -> encrypted_createForms(parameters, resultCallback)
    "encrypted.modifyForm" -> encrypted_modifyForm(parameters, resultCallback)
    "encrypted.undeleteFormById" -> encrypted_undeleteFormById(parameters, resultCallback)
    "encrypted.undeleteForm" -> encrypted_undeleteForm(parameters, resultCallback)
    "encrypted.modifyForms" -> encrypted_modifyForms(parameters, resultCallback)
    "encrypted.getForm" -> encrypted_getForm(parameters, resultCallback)
    "encrypted.getForms" -> encrypted_getForms(parameters, resultCallback)
    "encrypted.getLatestFormByLogicalUuid" -> encrypted_getLatestFormByLogicalUuid(parameters, resultCallback)
    "encrypted.getLatestFormByUniqueId" -> encrypted_getLatestFormByUniqueId(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterFormsBy" -> tryAndRecover_filterFormsBy(parameters, resultCallback)
    "tryAndRecover.filterFormsBySorted" -> tryAndRecover_filterFormsBySorted(parameters, resultCallback)
    "tryAndRecover.createForm" -> tryAndRecover_createForm(parameters, resultCallback)
    "tryAndRecover.createForms" -> tryAndRecover_createForms(parameters, resultCallback)
    "tryAndRecover.modifyForm" -> tryAndRecover_modifyForm(parameters, resultCallback)
    "tryAndRecover.undeleteFormById" -> tryAndRecover_undeleteFormById(parameters, resultCallback)
    "tryAndRecover.undeleteForm" -> tryAndRecover_undeleteForm(parameters, resultCallback)
    "tryAndRecover.modifyForms" -> tryAndRecover_modifyForms(parameters, resultCallback)
    "tryAndRecover.getForm" -> tryAndRecover_getForm(parameters, resultCallback)
    "tryAndRecover.getForms" -> tryAndRecover_getForms(parameters, resultCallback)
    "tryAndRecover.getLatestFormByLogicalUuid" -> tryAndRecover_getLatestFormByLogicalUuid(parameters, resultCallback)
    "tryAndRecover.getLatestFormByUniqueId" -> tryAndRecover_getLatestFormByUniqueId(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.withEncryptionMetadata(
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
    FormApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.createDelegationDeAnonymizationMetadata(
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
    FormApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun matchFormsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.matchFormsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchFormsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.matchFormsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteFormById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.deleteFormById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteFormsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.deleteFormsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeFormById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.purgeFormById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.deleteForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun deleteForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.deleteForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("forms"),
    )
  }

  private fun purgeForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.purgeForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun getFormTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.getFormTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplateId"),
      parameters.getValue("raw"),
    )
  }

  private fun createFormTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.createFormTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplate"),
    )
  }

  private fun deleteFormTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.deleteFormTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplateId"),
    )
  }

  private fun updateFormTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.updateFormTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplate"),
    )
  }

  private fun setTemplateAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.setTemplateAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplateId"),
      parameters.getValue("payload"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("form"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterFormsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.filterFormsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterFormsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.filterFormsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.createForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun createForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.createForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun modifyForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.modifyForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteFormById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.undeleteFormById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.undeleteForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun modifyForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.modifyForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun getForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.getForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.getForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun getLatestFormByLogicalUuid(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.getLatestFormByLogicalUuid(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("logicalUuid"),
    )
  }

  private fun getLatestFormByUniqueId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.getLatestFormByUniqueId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("uniqueId"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("form"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterFormsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.filterFormsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterFormsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.filterFormsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_createForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.createForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_createForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.createForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun encrypted_modifyForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.modifyForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeleteFormById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.undeleteFormById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_undeleteForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.undeleteForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun encrypted_modifyForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.modifyForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun encrypted_getForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.getForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.getForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun encrypted_getLatestFormByLogicalUuid(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.getLatestFormByLogicalUuid(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("logicalUuid"),
    )
  }

  private fun encrypted_getLatestFormByUniqueId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.encrypted.getLatestFormByUniqueId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("uniqueId"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("form"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterFormsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.filterFormsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterFormsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.filterFormsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_createForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.createForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_createForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.createForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun tryAndRecover_modifyForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.modifyForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeleteFormById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.undeleteFormById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_undeleteForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.undeleteForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun tryAndRecover_modifyForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.modifyForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun tryAndRecover_getForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.getForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.getForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_getLatestFormByLogicalUuid(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.getLatestFormByLogicalUuid(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("logicalUuid"),
    )
  }

  private fun tryAndRecover_getLatestFormByUniqueId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormApi.tryAndRecover.getLatestFormByUniqueId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("uniqueId"),
    )
  }
}
