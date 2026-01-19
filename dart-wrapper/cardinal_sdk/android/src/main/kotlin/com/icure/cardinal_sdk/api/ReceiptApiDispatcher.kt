// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.ReceiptApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ReceiptApiDispatcher {
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
    "getAndDecryptReceiptAttachment" -> getAndDecryptReceiptAttachment(parameters, resultCallback)
    "encryptAndSetReceiptAttachment" -> encryptAndSetReceiptAttachment(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptPatientIdOf" -> decryptPatientIdOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "logReceipt" -> logReceipt(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "deleteReceipt" -> deleteReceipt(parameters, resultCallback)
    "deleteReceipts" -> deleteReceipts(parameters, resultCallback)
    "getRawReceiptAttachment" -> getRawReceiptAttachment(parameters, resultCallback)
    "setRawReceiptAttachment" -> setRawReceiptAttachment(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "createReceipt" -> createReceipt(parameters, resultCallback)
    "modifyReceipt" -> modifyReceipt(parameters, resultCallback)
    "getReceipt" -> getReceipt(parameters, resultCallback)
    "listByReference" -> listByReference(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.createReceipt" -> encrypted_createReceipt(parameters, resultCallback)
    "encrypted.modifyReceipt" -> encrypted_modifyReceipt(parameters, resultCallback)
    "encrypted.getReceipt" -> encrypted_getReceipt(parameters, resultCallback)
    "encrypted.listByReference" -> encrypted_listByReference(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.createReceipt" -> tryAndRecover_createReceipt(parameters, resultCallback)
    "tryAndRecover.modifyReceipt" -> tryAndRecover_modifyReceipt(parameters, resultCallback)
    "tryAndRecover.getReceipt" -> tryAndRecover_getReceipt(parameters, resultCallback)
    "tryAndRecover.listByReference" -> tryAndRecover_listByReference(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.withEncryptionMetadata(
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

  private fun getAndDecryptReceiptAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.getAndDecryptReceiptAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
      parameters.getValue("attachmentId"),
    )
  }

  private fun encryptAndSetReceiptAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.encryptAndSetReceiptAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
      parameters.getValue("blobType"),
      parameters.getValue("attachment"),
    )
  }

  private fun getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.createDelegationDeAnonymizationMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
      parameters.getValue("delegates"),
    )
  }

  private fun logReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.logReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("user"),
      parameters.getValue("docId"),
      parameters.getValue("refs"),
      parameters.getValue("blobType"),
      parameters.getValue("blob"),
    )
  }

  private fun decrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
    )
  }

  private fun deleteReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.deleteReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun deleteReceipts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.deleteReceipts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun getRawReceiptAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.getRawReceiptAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receiptId"),
      parameters.getValue("attachmentId"),
    )
  }

  private fun setRawReceiptAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.setRawReceiptAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receiptId"),
      parameters.getValue("rev"),
      parameters.getValue("blobType"),
      parameters.getValue("attachment"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("receipt"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
      parameters.getValue("delegates"),
    )
  }

  private fun createReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.createReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.modifyReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.getReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun listByReference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.listByReference(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("reference"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("receipt"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_createReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.encrypted.createReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_modifyReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.encrypted.modifyReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_getReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.encrypted.getReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_listByReference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.encrypted.listByReference(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("reference"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("receipt"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receipt"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_createReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.tryAndRecover.createReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_modifyReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.tryAndRecover.modifyReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_getReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.tryAndRecover.getReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_listByReference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptApi.tryAndRecover.listByReference(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("reference"),
    )
  }
}
