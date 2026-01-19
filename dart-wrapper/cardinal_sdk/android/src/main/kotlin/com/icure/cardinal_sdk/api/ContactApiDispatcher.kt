// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.ContactApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ContactApiDispatcher {
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
    "matchContactsBy" -> matchContactsBy(parameters, resultCallback)
    "matchServicesBy" -> matchServicesBy(parameters, resultCallback)
    "matchContactsBySorted" -> matchContactsBySorted(parameters, resultCallback)
    "matchServicesBySorted" -> matchServicesBySorted(parameters, resultCallback)
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptPatientIdOf" -> decryptPatientIdOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "decryptService" -> decryptService(parameters, resultCallback)
    "tryDecryptService" -> tryDecryptService(parameters, resultCallback)
    "subscribeToServiceCreateOrUpdateEvents" -> subscribeToServiceCreateOrUpdateEvents(parameters, resultCallback)
    "deleteContactById" -> deleteContactById(parameters, resultCallback)
    "deleteContactsByIds" -> deleteContactsByIds(parameters, resultCallback)
    "purgeContactById" -> purgeContactById(parameters, resultCallback)
    "deleteContact" -> deleteContact(parameters, resultCallback)
    "deleteContacts" -> deleteContacts(parameters, resultCallback)
    "purgeContact" -> purgeContact(parameters, resultCallback)
    "getServiceCodesOccurrences" -> getServiceCodesOccurrences(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterContactsBy" -> filterContactsBy(parameters, resultCallback)
    "filterServicesBy" -> filterServicesBy(parameters, resultCallback)
    "filterContactsBySorted" -> filterContactsBySorted(parameters, resultCallback)
    "filterServicesBySorted" -> filterServicesBySorted(parameters, resultCallback)
    "createContact" -> createContact(parameters, resultCallback)
    "createContacts" -> createContacts(parameters, resultCallback)
    "undeleteContactById" -> undeleteContactById(parameters, resultCallback)
    "undeleteContact" -> undeleteContact(parameters, resultCallback)
    "modifyContact" -> modifyContact(parameters, resultCallback)
    "modifyContacts" -> modifyContacts(parameters, resultCallback)
    "getContact" -> getContact(parameters, resultCallback)
    "getContacts" -> getContacts(parameters, resultCallback)
    "getService" -> getService(parameters, resultCallback)
    "getServices" -> getServices(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterContactsBy" -> encrypted_filterContactsBy(parameters, resultCallback)
    "encrypted.filterServicesBy" -> encrypted_filterServicesBy(parameters, resultCallback)
    "encrypted.filterContactsBySorted" -> encrypted_filterContactsBySorted(parameters, resultCallback)
    "encrypted.filterServicesBySorted" -> encrypted_filterServicesBySorted(parameters, resultCallback)
    "encrypted.createContact" -> encrypted_createContact(parameters, resultCallback)
    "encrypted.createContacts" -> encrypted_createContacts(parameters, resultCallback)
    "encrypted.undeleteContactById" -> encrypted_undeleteContactById(parameters, resultCallback)
    "encrypted.undeleteContact" -> encrypted_undeleteContact(parameters, resultCallback)
    "encrypted.modifyContact" -> encrypted_modifyContact(parameters, resultCallback)
    "encrypted.modifyContacts" -> encrypted_modifyContacts(parameters, resultCallback)
    "encrypted.getContact" -> encrypted_getContact(parameters, resultCallback)
    "encrypted.getContacts" -> encrypted_getContacts(parameters, resultCallback)
    "encrypted.getService" -> encrypted_getService(parameters, resultCallback)
    "encrypted.getServices" -> encrypted_getServices(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterContactsBy" -> tryAndRecover_filterContactsBy(parameters, resultCallback)
    "tryAndRecover.filterServicesBy" -> tryAndRecover_filterServicesBy(parameters, resultCallback)
    "tryAndRecover.filterContactsBySorted" -> tryAndRecover_filterContactsBySorted(parameters, resultCallback)
    "tryAndRecover.filterServicesBySorted" -> tryAndRecover_filterServicesBySorted(parameters, resultCallback)
    "tryAndRecover.createContact" -> tryAndRecover_createContact(parameters, resultCallback)
    "tryAndRecover.createContacts" -> tryAndRecover_createContacts(parameters, resultCallback)
    "tryAndRecover.undeleteContactById" -> tryAndRecover_undeleteContactById(parameters, resultCallback)
    "tryAndRecover.undeleteContact" -> tryAndRecover_undeleteContact(parameters, resultCallback)
    "tryAndRecover.modifyContact" -> tryAndRecover_modifyContact(parameters, resultCallback)
    "tryAndRecover.modifyContacts" -> tryAndRecover_modifyContacts(parameters, resultCallback)
    "tryAndRecover.getContact" -> tryAndRecover_getContact(parameters, resultCallback)
    "tryAndRecover.getContacts" -> tryAndRecover_getContacts(parameters, resultCallback)
    "tryAndRecover.getService" -> tryAndRecover_getService(parameters, resultCallback)
    "tryAndRecover.getServices" -> tryAndRecover_getServices(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchContactsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.matchContactsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchServicesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.matchServicesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchContactsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.matchContactsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchServicesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.matchServicesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.withEncryptionMetadata(
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
    ContactApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.createDelegationDeAnonymizationMetadata(
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
    ContactApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun decryptService(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.decryptService(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("service"),
    )
  }

  private fun tryDecryptService(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryDecryptService(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("service"),
    )
  }

  private fun subscribeToServiceCreateOrUpdateEvents(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.subscribeToServiceCreateOrUpdateEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun deleteContactById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.deleteContactById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteContactsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.deleteContactsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeContactById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.purgeContactById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.deleteContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun deleteContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.deleteContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contacts"),
    )
  }

  private fun purgeContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.purgeContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun getServiceCodesOccurrences(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.getServiceCodesOccurrences(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("codeType"),
      parameters.getValue("minOccurrences"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("contact"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterContactsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.filterContactsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterServicesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.filterServicesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterContactsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.filterContactsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterServicesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.filterServicesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.createContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun createContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.createContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun undeleteContactById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.undeleteContactById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.undeleteContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun modifyContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.modifyContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.modifyContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun getContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.getContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.getContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun getService(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.getService(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("serviceId"),
    )
  }

  private fun getServices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.getServices(
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
    ContactApi.subscribeToEvents(
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
    ContactApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("contact"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterContactsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.filterContactsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterServicesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.filterServicesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterContactsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.filterContactsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterServicesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.filterServicesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_createContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.createContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_createContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.createContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun encrypted_undeleteContactById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.undeleteContactById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_undeleteContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.undeleteContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun encrypted_modifyContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.modifyContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_modifyContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.modifyContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun encrypted_getContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.getContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.getContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun encrypted_getService(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.getService(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("serviceId"),
    )
  }

  private fun encrypted_getServices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.encrypted.getServices(
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
    ContactApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("contact"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterContactsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.filterContactsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterServicesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.filterServicesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterContactsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.filterContactsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterServicesBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.filterServicesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_createContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.createContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_createContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.createContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun tryAndRecover_undeleteContactById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.undeleteContactById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_undeleteContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.undeleteContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun tryAndRecover_modifyContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.modifyContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_modifyContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.modifyContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun tryAndRecover_getContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.getContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.getContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_getService(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.getService(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("serviceId"),
    )
  }

  private fun tryAndRecover_getServices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactApi.tryAndRecover.getServices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }
}
