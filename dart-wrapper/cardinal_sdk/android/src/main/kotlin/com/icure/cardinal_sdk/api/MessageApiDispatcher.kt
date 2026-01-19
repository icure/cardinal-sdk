// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.MessageApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MessageApiDispatcher {
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
    "getSecretIdsOf" -> getSecretIdsOf(parameters, resultCallback)
    "matchMessagesBy" -> matchMessagesBy(parameters, resultCallback)
    "matchMessagesBySorted" -> matchMessagesBySorted(parameters, resultCallback)
    "deleteMessageById" -> deleteMessageById(parameters, resultCallback)
    "deleteMessagesByIds" -> deleteMessagesByIds(parameters, resultCallback)
    "purgeMessageById" -> purgeMessageById(parameters, resultCallback)
    "deleteMessage" -> deleteMessage(parameters, resultCallback)
    "deleteMessages" -> deleteMessages(parameters, resultCallback)
    "purgeMessage" -> purgeMessage(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterMessagesBy" -> filterMessagesBy(parameters, resultCallback)
    "filterMessagesBySorted" -> filterMessagesBySorted(parameters, resultCallback)
    "createMessage" -> createMessage(parameters, resultCallback)
    "createMessageInTopic" -> createMessageInTopic(parameters, resultCallback)
    "undeleteMessage" -> undeleteMessage(parameters, resultCallback)
    "modifyMessage" -> modifyMessage(parameters, resultCallback)
    "undeleteMessageById" -> undeleteMessageById(parameters, resultCallback)
    "getMessage" -> getMessage(parameters, resultCallback)
    "getMessages" -> getMessages(parameters, resultCallback)
    "setMessagesReadStatus" -> setMessagesReadStatus(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterMessagesBy" -> encrypted_filterMessagesBy(parameters, resultCallback)
    "encrypted.filterMessagesBySorted" -> encrypted_filterMessagesBySorted(parameters, resultCallback)
    "encrypted.createMessage" -> encrypted_createMessage(parameters, resultCallback)
    "encrypted.createMessageInTopic" -> encrypted_createMessageInTopic(parameters, resultCallback)
    "encrypted.undeleteMessage" -> encrypted_undeleteMessage(parameters, resultCallback)
    "encrypted.modifyMessage" -> encrypted_modifyMessage(parameters, resultCallback)
    "encrypted.undeleteMessageById" -> encrypted_undeleteMessageById(parameters, resultCallback)
    "encrypted.getMessage" -> encrypted_getMessage(parameters, resultCallback)
    "encrypted.getMessages" -> encrypted_getMessages(parameters, resultCallback)
    "encrypted.setMessagesReadStatus" -> encrypted_setMessagesReadStatus(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterMessagesBy" -> tryAndRecover_filterMessagesBy(parameters, resultCallback)
    "tryAndRecover.filterMessagesBySorted" -> tryAndRecover_filterMessagesBySorted(parameters, resultCallback)
    "tryAndRecover.createMessage" -> tryAndRecover_createMessage(parameters, resultCallback)
    "tryAndRecover.createMessageInTopic" -> tryAndRecover_createMessageInTopic(parameters, resultCallback)
    "tryAndRecover.undeleteMessage" -> tryAndRecover_undeleteMessage(parameters, resultCallback)
    "tryAndRecover.modifyMessage" -> tryAndRecover_modifyMessage(parameters, resultCallback)
    "tryAndRecover.undeleteMessageById" -> tryAndRecover_undeleteMessageById(parameters, resultCallback)
    "tryAndRecover.getMessage" -> tryAndRecover_getMessage(parameters, resultCallback)
    "tryAndRecover.getMessages" -> tryAndRecover_getMessages(parameters, resultCallback)
    "tryAndRecover.setMessagesReadStatus" -> tryAndRecover_setMessagesReadStatus(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.withEncryptionMetadata(
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
    MessageApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.createDelegationDeAnonymizationMetadata(
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
    MessageApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun getSecretIdsOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.getSecretIdsOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun matchMessagesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.matchMessagesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchMessagesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.matchMessagesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteMessageById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.deleteMessageById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteMessagesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.deleteMessagesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeMessageById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.purgeMessageById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.deleteMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun deleteMessages(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.deleteMessages(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("messages"),
    )
  }

  private fun purgeMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.purgeMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("message"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterMessagesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.filterMessagesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterMessagesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.filterMessagesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.createMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun createMessageInTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.createMessageInTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.undeleteMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun modifyMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.modifyMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteMessageById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.undeleteMessageById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun getMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.getMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getMessages(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.getMessages(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun setMessagesReadStatus(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.setMessagesReadStatus(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
      parameters.getValue("time"),
      parameters.getValue("readStatus"),
      parameters.getValue("userId"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.subscribeToEvents(
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
    MessageApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("message"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterMessagesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.filterMessagesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterMessagesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.filterMessagesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_createMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.createMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_createMessageInTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.createMessageInTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeleteMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.undeleteMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun encrypted_modifyMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.modifyMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeleteMessageById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.undeleteMessageById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_getMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.getMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getMessages(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.getMessages(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun encrypted_setMessagesReadStatus(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.encrypted.setMessagesReadStatus(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
      parameters.getValue("time"),
      parameters.getValue("readStatus"),
      parameters.getValue("userId"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("message"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterMessagesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.filterMessagesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterMessagesBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.filterMessagesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_createMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.createMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_createMessageInTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.createMessageInTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeleteMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.undeleteMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun tryAndRecover_modifyMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.modifyMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeleteMessageById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.undeleteMessageById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_getMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.getMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getMessages(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.getMessages(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_setMessagesReadStatus(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageApi.tryAndRecover.setMessagesReadStatus(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
      parameters.getValue("time"),
      parameters.getValue("readStatus"),
      parameters.getValue("userId"),
    )
  }
}
