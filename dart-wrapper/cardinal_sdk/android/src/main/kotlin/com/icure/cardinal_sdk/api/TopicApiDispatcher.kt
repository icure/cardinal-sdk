// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.TopicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object TopicApiDispatcher {
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
    "matchTopicsBy" -> matchTopicsBy(parameters, resultCallback)
    "matchTopicsBySorted" -> matchTopicsBySorted(parameters, resultCallback)
    "deleteTopicById" -> deleteTopicById(parameters, resultCallback)
    "deleteTopicsByIds" -> deleteTopicsByIds(parameters, resultCallback)
    "purgeTopicById" -> purgeTopicById(parameters, resultCallback)
    "deleteTopic" -> deleteTopic(parameters, resultCallback)
    "deleteTopics" -> deleteTopics(parameters, resultCallback)
    "purgeTopic" -> purgeTopic(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterTopicsBy" -> filterTopicsBy(parameters, resultCallback)
    "filterTopicsBySorted" -> filterTopicsBySorted(parameters, resultCallback)
    "createTopic" -> createTopic(parameters, resultCallback)
    "undeleteTopic" -> undeleteTopic(parameters, resultCallback)
    "modifyTopic" -> modifyTopic(parameters, resultCallback)
    "undeleteTopicById" -> undeleteTopicById(parameters, resultCallback)
    "getTopic" -> getTopic(parameters, resultCallback)
    "getTopics" -> getTopics(parameters, resultCallback)
    "addParticipant" -> addParticipant(parameters, resultCallback)
    "removeParticipant" -> removeParticipant(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterTopicsBy" -> encrypted_filterTopicsBy(parameters, resultCallback)
    "encrypted.filterTopicsBySorted" -> encrypted_filterTopicsBySorted(parameters, resultCallback)
    "encrypted.createTopic" -> encrypted_createTopic(parameters, resultCallback)
    "encrypted.undeleteTopic" -> encrypted_undeleteTopic(parameters, resultCallback)
    "encrypted.modifyTopic" -> encrypted_modifyTopic(parameters, resultCallback)
    "encrypted.undeleteTopicById" -> encrypted_undeleteTopicById(parameters, resultCallback)
    "encrypted.getTopic" -> encrypted_getTopic(parameters, resultCallback)
    "encrypted.getTopics" -> encrypted_getTopics(parameters, resultCallback)
    "encrypted.addParticipant" -> encrypted_addParticipant(parameters, resultCallback)
    "encrypted.removeParticipant" -> encrypted_removeParticipant(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterTopicsBy" -> tryAndRecover_filterTopicsBy(parameters, resultCallback)
    "tryAndRecover.filterTopicsBySorted" -> tryAndRecover_filterTopicsBySorted(parameters, resultCallback)
    "tryAndRecover.createTopic" -> tryAndRecover_createTopic(parameters, resultCallback)
    "tryAndRecover.undeleteTopic" -> tryAndRecover_undeleteTopic(parameters, resultCallback)
    "tryAndRecover.modifyTopic" -> tryAndRecover_modifyTopic(parameters, resultCallback)
    "tryAndRecover.undeleteTopicById" -> tryAndRecover_undeleteTopicById(parameters, resultCallback)
    "tryAndRecover.getTopic" -> tryAndRecover_getTopic(parameters, resultCallback)
    "tryAndRecover.getTopics" -> tryAndRecover_getTopics(parameters, resultCallback)
    "tryAndRecover.addParticipant" -> tryAndRecover_addParticipant(parameters, resultCallback)
    "tryAndRecover.removeParticipant" -> tryAndRecover_removeParticipant(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.withEncryptionMetadata(
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
    TopicApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.createDelegationDeAnonymizationMetadata(
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
    TopicApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun matchTopicsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.matchTopicsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchTopicsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.matchTopicsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteTopicById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.deleteTopicById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteTopicsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.deleteTopicsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeTopicById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.purgeTopicById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.deleteTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun deleteTopics(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.deleteTopics(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topics"),
    )
  }

  private fun purgeTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.purgeTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("topic"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterTopicsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.filterTopicsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterTopicsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.filterTopicsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.createTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.undeleteTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun modifyTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.modifyTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteTopicById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.undeleteTopicById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun getTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.getTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getTopics(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.getTopics(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun addParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.addParticipant(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("dataOwnerId"),
      parameters.getValue("topicRole"),
    )
  }

  private fun removeParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.removeParticipant(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.subscribeToEvents(
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
    TopicApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("topic"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterTopicsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.filterTopicsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterTopicsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.filterTopicsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_createTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.createTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeleteTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.undeleteTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun encrypted_modifyTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.modifyTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeleteTopicById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.undeleteTopicById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_getTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.getTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getTopics(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.getTopics(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun encrypted_addParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.addParticipant(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("dataOwnerId"),
      parameters.getValue("topicRole"),
    )
  }

  private fun encrypted_removeParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.encrypted.removeParticipant(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("topic"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterTopicsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.filterTopicsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterTopicsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.filterTopicsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_createTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.createTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeleteTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.undeleteTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun tryAndRecover_modifyTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.modifyTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeleteTopicById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.undeleteTopicById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_getTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.getTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getTopics(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.getTopics(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_addParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.addParticipant(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("dataOwnerId"),
      parameters.getValue("topicRole"),
    )
  }

  private fun tryAndRecover_removeParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicApi.tryAndRecover.removeParticipant(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("dataOwnerId"),
    )
  }
}
