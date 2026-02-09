// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.DocumentApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object DocumentApiDispatcher {
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
    "withEncryptionMetadataLinkedToMessage" -> withEncryptionMetadataLinkedToMessage(parameters, resultCallback)
    "withEncryptionMetadataLinkedToPatient" -> withEncryptionMetadataLinkedToPatient(parameters, resultCallback)
    "withEncryptionMetadataUnlinked" -> withEncryptionMetadataUnlinked(parameters, resultCallback)
    "getAndTryDecryptMainAttachment" -> getAndTryDecryptMainAttachment(parameters, resultCallback)
    "getAndDecryptMainAttachment" -> getAndDecryptMainAttachment(parameters, resultCallback)
    "encryptAndSetMainAttachment" -> encryptAndSetMainAttachment(parameters, resultCallback)
    "getAndDecryptSecondaryAttachment" -> getAndDecryptSecondaryAttachment(parameters, resultCallback)
    "encryptAndSetSecondaryAttachment" -> encryptAndSetSecondaryAttachment(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptOwningEntityIdsOf" -> decryptOwningEntityIdsOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "tryDecryptAttachment" -> tryDecryptAttachment(parameters, resultCallback)
    "matchDocumentsBy" -> matchDocumentsBy(parameters, resultCallback)
    "matchDocumentsBySorted" -> matchDocumentsBySorted(parameters, resultCallback)
    "deleteDocumentById" -> deleteDocumentById(parameters, resultCallback)
    "deleteDocumentsByIds" -> deleteDocumentsByIds(parameters, resultCallback)
    "purgeDocumentById" -> purgeDocumentById(parameters, resultCallback)
    "deleteDocument" -> deleteDocument(parameters, resultCallback)
    "deleteDocuments" -> deleteDocuments(parameters, resultCallback)
    "purgeDocument" -> purgeDocument(parameters, resultCallback)
    "getRawMainAttachment" -> getRawMainAttachment(parameters, resultCallback)
    "getRawSecondaryAttachment" -> getRawSecondaryAttachment(parameters, resultCallback)
    "setRawMainAttachment" -> setRawMainAttachment(parameters, resultCallback)
    "setRawSecondaryAttachment" -> setRawSecondaryAttachment(parameters, resultCallback)
    "deleteMainAttachment" -> deleteMainAttachment(parameters, resultCallback)
    "deleteSecondaryAttachment" -> deleteSecondaryAttachment(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterDocumentsBy" -> filterDocumentsBy(parameters, resultCallback)
    "filterDocumentsBySorted" -> filterDocumentsBySorted(parameters, resultCallback)
    "createDocument" -> createDocument(parameters, resultCallback)
    "undeleteDocumentById" -> undeleteDocumentById(parameters, resultCallback)
    "undeleteDocument" -> undeleteDocument(parameters, resultCallback)
    "modifyDocument" -> modifyDocument(parameters, resultCallback)
    "getDocument" -> getDocument(parameters, resultCallback)
    "getDocuments" -> getDocuments(parameters, resultCallback)
    "modifyDocuments" -> modifyDocuments(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterDocumentsBy" -> encrypted_filterDocumentsBy(parameters, resultCallback)
    "encrypted.filterDocumentsBySorted" -> encrypted_filterDocumentsBySorted(parameters, resultCallback)
    "encrypted.createDocument" -> encrypted_createDocument(parameters, resultCallback)
    "encrypted.undeleteDocumentById" -> encrypted_undeleteDocumentById(parameters, resultCallback)
    "encrypted.undeleteDocument" -> encrypted_undeleteDocument(parameters, resultCallback)
    "encrypted.modifyDocument" -> encrypted_modifyDocument(parameters, resultCallback)
    "encrypted.getDocument" -> encrypted_getDocument(parameters, resultCallback)
    "encrypted.getDocuments" -> encrypted_getDocuments(parameters, resultCallback)
    "encrypted.modifyDocuments" -> encrypted_modifyDocuments(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterDocumentsBy" -> tryAndRecover_filterDocumentsBy(parameters, resultCallback)
    "tryAndRecover.filterDocumentsBySorted" -> tryAndRecover_filterDocumentsBySorted(parameters, resultCallback)
    "tryAndRecover.createDocument" -> tryAndRecover_createDocument(parameters, resultCallback)
    "tryAndRecover.undeleteDocumentById" -> tryAndRecover_undeleteDocumentById(parameters, resultCallback)
    "tryAndRecover.undeleteDocument" -> tryAndRecover_undeleteDocument(parameters, resultCallback)
    "tryAndRecover.modifyDocument" -> tryAndRecover_modifyDocument(parameters, resultCallback)
    "tryAndRecover.getDocument" -> tryAndRecover_getDocument(parameters, resultCallback)
    "tryAndRecover.getDocuments" -> tryAndRecover_getDocuments(parameters, resultCallback)
    "tryAndRecover.modifyDocuments" -> tryAndRecover_modifyDocuments(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun withEncryptionMetadataLinkedToMessage(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.withEncryptionMetadataLinkedToMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("base"),
      parameters.getValue("message"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
      parameters.getValue("secretId"),
      parameters.getValue("alternateRootDelegateId"),
    )
  }

  private fun withEncryptionMetadataLinkedToPatient(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.withEncryptionMetadataLinkedToPatient(
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

  private fun withEncryptionMetadataUnlinked(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.withEncryptionMetadataUnlinked(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("base"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
      parameters.getValue("alternateRootDelegateId"),
    )
  }

  private fun getAndTryDecryptMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.getAndTryDecryptMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("decryptedAttachmentValidator"),
    )
  }

  private fun getAndDecryptMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.getAndDecryptMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("decryptedAttachmentValidator"),
    )
  }

  private fun encryptAndSetMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encryptAndSetMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("utis"),
      parameters.getValue("attachment"),
    )
  }

  private fun getAndDecryptSecondaryAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.getAndDecryptSecondaryAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("key"),
      parameters.getValue("decryptedAttachmentValidator"),
    )
  }

  private fun encryptAndSetSecondaryAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encryptAndSetSecondaryAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("key"),
      parameters.getValue("utis"),
      parameters.getValue("attachment"),
    )
  }

  private fun getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun decryptOwningEntityIdsOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.decryptOwningEntityIdsOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.createDelegationDeAnonymizationMetadata(
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
    DocumentApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun tryDecryptAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryDecryptAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("encryptedAttachment"),
      parameters.getValue("decryptedAttachmentValidator"),
    )
  }

  private fun matchDocumentsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.matchDocumentsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchDocumentsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.matchDocumentsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteDocumentById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.deleteDocumentById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteDocumentsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.deleteDocumentsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeDocumentById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.purgeDocumentById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.deleteDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun deleteDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.deleteDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documents"),
    )
  }

  private fun purgeDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.purgeDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun getRawMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.getRawMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
    )
  }

  private fun getRawSecondaryAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.getRawSecondaryAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("key"),
    )
  }

  private fun setRawMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.setRawMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("rev"),
      parameters.getValue("utis"),
      parameters.getValue("attachment"),
      parameters.getValue("encrypted"),
    )
  }

  private fun setRawSecondaryAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.setRawSecondaryAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("key"),
      parameters.getValue("rev"),
      parameters.getValue("utis"),
      parameters.getValue("attachment"),
      parameters.getValue("encrypted"),
    )
  }

  private fun deleteMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.deleteMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteSecondaryAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.deleteSecondaryAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("key"),
      parameters.getValue("rev"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("document"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterDocumentsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.filterDocumentsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterDocumentsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.filterDocumentsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.createDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteDocumentById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.undeleteDocumentById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.undeleteDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun modifyDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.modifyDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.getDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.getDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun modifyDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.modifyDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("document"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterDocumentsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.filterDocumentsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterDocumentsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.filterDocumentsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_createDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.createDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeleteDocumentById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.undeleteDocumentById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_undeleteDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.undeleteDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun encrypted_modifyDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.modifyDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_getDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.getDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.getDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun encrypted_modifyDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.encrypted.modifyDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("document"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterDocumentsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.filterDocumentsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterDocumentsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.filterDocumentsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_createDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.createDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeleteDocumentById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.undeleteDocumentById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_undeleteDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.undeleteDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun tryAndRecover_modifyDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.modifyDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_getDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.getDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.getDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_modifyDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentApi.tryAndRecover.modifyDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }
}
