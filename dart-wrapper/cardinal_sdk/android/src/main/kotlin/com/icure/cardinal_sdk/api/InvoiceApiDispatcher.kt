// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.InvoiceApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object InvoiceApiDispatcher {
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
    "createInvoice" -> createInvoice(parameters, resultCallback)
    "createInvoices" -> createInvoices(parameters, resultCallback)
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptPatientIdOf" -> decryptPatientIdOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "deleteInvoice" -> deleteInvoice(parameters, resultCallback)
    "getTarificationsCodesOccurrences" -> getTarificationsCodesOccurrences(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "modifyInvoice" -> modifyInvoice(parameters, resultCallback)
    "modifyInvoices" -> modifyInvoices(parameters, resultCallback)
    "getInvoice" -> getInvoice(parameters, resultCallback)
    "getInvoices" -> getInvoices(parameters, resultCallback)
    "reassignInvoice" -> reassignInvoice(parameters, resultCallback)
    "mergeTo" -> mergeTo(parameters, resultCallback)
    "validate" -> validate(parameters, resultCallback)
    "appendCodes" -> appendCodes(parameters, resultCallback)
    "removeCodes" -> removeCodes(parameters, resultCallback)
    "listInvoicesByHcPartyAndGroupId" -> listInvoicesByHcPartyAndGroupId(parameters, resultCallback)
    "listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate" -> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters, resultCallback)
    "listInvoicesByContactIds" -> listInvoicesByContactIds(parameters, resultCallback)
    "listInvoicesByRecipientsIds" -> listInvoicesByRecipientsIds(parameters, resultCallback)
    "listToInsurances" -> listToInsurances(parameters, resultCallback)
    "listToInsurancesUnsent" -> listToInsurancesUnsent(parameters, resultCallback)
    "listToPatients" -> listToPatients(parameters, resultCallback)
    "listToPatientsUnsent" -> listToPatientsUnsent(parameters, resultCallback)
    "listInvoicesByIds" -> listInvoicesByIds(parameters, resultCallback)
    "listInvoicesByHcpartySendingModeStatusDate" -> listInvoicesByHcpartySendingModeStatusDate(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.modifyInvoice" -> encrypted_modifyInvoice(parameters, resultCallback)
    "encrypted.modifyInvoices" -> encrypted_modifyInvoices(parameters, resultCallback)
    "encrypted.getInvoice" -> encrypted_getInvoice(parameters, resultCallback)
    "encrypted.getInvoices" -> encrypted_getInvoices(parameters, resultCallback)
    "encrypted.reassignInvoice" -> encrypted_reassignInvoice(parameters, resultCallback)
    "encrypted.mergeTo" -> encrypted_mergeTo(parameters, resultCallback)
    "encrypted.validate" -> encrypted_validate(parameters, resultCallback)
    "encrypted.appendCodes" -> encrypted_appendCodes(parameters, resultCallback)
    "encrypted.removeCodes" -> encrypted_removeCodes(parameters, resultCallback)
    "encrypted.listInvoicesByHcPartyAndGroupId" -> encrypted_listInvoicesByHcPartyAndGroupId(parameters, resultCallback)
    "encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate" -> encrypted_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters, resultCallback)
    "encrypted.listInvoicesByContactIds" -> encrypted_listInvoicesByContactIds(parameters, resultCallback)
    "encrypted.listInvoicesByRecipientsIds" -> encrypted_listInvoicesByRecipientsIds(parameters, resultCallback)
    "encrypted.listToInsurances" -> encrypted_listToInsurances(parameters, resultCallback)
    "encrypted.listToInsurancesUnsent" -> encrypted_listToInsurancesUnsent(parameters, resultCallback)
    "encrypted.listToPatients" -> encrypted_listToPatients(parameters, resultCallback)
    "encrypted.listToPatientsUnsent" -> encrypted_listToPatientsUnsent(parameters, resultCallback)
    "encrypted.listInvoicesByIds" -> encrypted_listInvoicesByIds(parameters, resultCallback)
    "encrypted.listInvoicesByHcpartySendingModeStatusDate" -> encrypted_listInvoicesByHcpartySendingModeStatusDate(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.modifyInvoice" -> tryAndRecover_modifyInvoice(parameters, resultCallback)
    "tryAndRecover.modifyInvoices" -> tryAndRecover_modifyInvoices(parameters, resultCallback)
    "tryAndRecover.getInvoice" -> tryAndRecover_getInvoice(parameters, resultCallback)
    "tryAndRecover.getInvoices" -> tryAndRecover_getInvoices(parameters, resultCallback)
    "tryAndRecover.reassignInvoice" -> tryAndRecover_reassignInvoice(parameters, resultCallback)
    "tryAndRecover.mergeTo" -> tryAndRecover_mergeTo(parameters, resultCallback)
    "tryAndRecover.validate" -> tryAndRecover_validate(parameters, resultCallback)
    "tryAndRecover.appendCodes" -> tryAndRecover_appendCodes(parameters, resultCallback)
    "tryAndRecover.removeCodes" -> tryAndRecover_removeCodes(parameters, resultCallback)
    "tryAndRecover.listInvoicesByHcPartyAndGroupId" -> tryAndRecover_listInvoicesByHcPartyAndGroupId(parameters, resultCallback)
    "tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate" -> tryAndRecover_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters, resultCallback)
    "tryAndRecover.listInvoicesByContactIds" -> tryAndRecover_listInvoicesByContactIds(parameters, resultCallback)
    "tryAndRecover.listInvoicesByRecipientsIds" -> tryAndRecover_listInvoicesByRecipientsIds(parameters, resultCallback)
    "tryAndRecover.listToInsurances" -> tryAndRecover_listToInsurances(parameters, resultCallback)
    "tryAndRecover.listToInsurancesUnsent" -> tryAndRecover_listToInsurancesUnsent(parameters, resultCallback)
    "tryAndRecover.listToPatients" -> tryAndRecover_listToPatients(parameters, resultCallback)
    "tryAndRecover.listToPatientsUnsent" -> tryAndRecover_listToPatientsUnsent(parameters, resultCallback)
    "tryAndRecover.listInvoicesByIds" -> tryAndRecover_listInvoicesByIds(parameters, resultCallback)
    "tryAndRecover.listInvoicesByHcpartySendingModeStatusDate" -> tryAndRecover_listInvoicesByHcpartySendingModeStatusDate(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.createInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
      parameters.getValue("prefix"),
    )
  }

  private fun createInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.createInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.withEncryptionMetadata(
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
    InvoiceApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.createDelegationDeAnonymizationMetadata(
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
    InvoiceApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun deleteInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.deleteInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getTarificationsCodesOccurrences(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.getTarificationsCodesOccurrences(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("minOccurrence"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("invoice"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
      parameters.getValue("delegates"),
    )
  }

  private fun modifyInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.modifyInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.modifyInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun getInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.getInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.getInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun reassignInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.reassignInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun mergeTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.mergeTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("ids"),
    )
  }

  private fun validate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.validate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("scheme"),
      parameters.getValue("forcedValue"),
    )
  }

  private fun appendCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.appendCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("type"),
      parameters.getValue("sentMediumType"),
      parameters.getValue("secretFKeys"),
      parameters.getValue("insuranceId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("gracePeriod"),
      parameters.getValue("invoicingCodes"),
    )
  }

  private fun removeCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.removeCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("serviceId"),
      parameters.getValue("secretFKeys"),
      parameters.getValue("tarificationIds"),
    )
  }

  private fun listInvoicesByHcPartyAndGroupId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listInvoicesByHcPartyAndGroupId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("groupId"),
    )
  }

  private
      fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("sentMediumType"),
      parameters.getValue("invoiceType"),
      parameters.getValue("sent"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun listInvoicesByContactIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listInvoicesByContactIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contactIds"),
    )
  }

  private fun listInvoicesByRecipientsIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listInvoicesByRecipientsIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("recipientsIds"),
    )
  }

  private fun listToInsurances(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listToInsurances(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun listToInsurancesUnsent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listToInsurancesUnsent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun listToPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listToPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
    )
  }

  private fun listToPatientsUnsent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listToPatientsUnsent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
    )
  }

  private fun listInvoicesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listInvoicesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun listInvoicesByHcpartySendingModeStatusDate(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.listInvoicesByHcpartySendingModeStatusDate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("sendingMode"),
      parameters.getValue("status"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("invoice"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_modifyInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.modifyInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_modifyInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.modifyInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun encrypted_getInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.getInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.getInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun encrypted_reassignInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.reassignInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun encrypted_mergeTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.mergeTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("ids"),
    )
  }

  private fun encrypted_validate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.validate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("scheme"),
      parameters.getValue("forcedValue"),
    )
  }

  private fun encrypted_appendCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.appendCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("type"),
      parameters.getValue("sentMediumType"),
      parameters.getValue("secretFKeys"),
      parameters.getValue("insuranceId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("gracePeriod"),
      parameters.getValue("invoicingCodes"),
    )
  }

  private fun encrypted_removeCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.removeCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("serviceId"),
      parameters.getValue("secretFKeys"),
      parameters.getValue("tarificationIds"),
    )
  }

  private fun encrypted_listInvoicesByHcPartyAndGroupId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listInvoicesByHcPartyAndGroupId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("groupId"),
    )
  }

  private
      fun encrypted_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("sentMediumType"),
      parameters.getValue("invoiceType"),
      parameters.getValue("sent"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun encrypted_listInvoicesByContactIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listInvoicesByContactIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contactIds"),
    )
  }

  private fun encrypted_listInvoicesByRecipientsIds(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listInvoicesByRecipientsIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("recipientsIds"),
    )
  }

  private fun encrypted_listToInsurances(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listToInsurances(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun encrypted_listToInsurancesUnsent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listToInsurancesUnsent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun encrypted_listToPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listToPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
    )
  }

  private fun encrypted_listToPatientsUnsent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listToPatientsUnsent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
    )
  }

  private fun encrypted_listInvoicesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listInvoicesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun encrypted_listInvoicesByHcpartySendingModeStatusDate(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("sendingMode"),
      parameters.getValue("status"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("invoice"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_modifyInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.modifyInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_modifyInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.modifyInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun tryAndRecover_getInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.getInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.getInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_reassignInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.reassignInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun tryAndRecover_mergeTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.mergeTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("ids"),
    )
  }

  private fun tryAndRecover_validate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.validate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("scheme"),
      parameters.getValue("forcedValue"),
    )
  }

  private fun tryAndRecover_appendCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.appendCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("type"),
      parameters.getValue("sentMediumType"),
      parameters.getValue("secretFKeys"),
      parameters.getValue("insuranceId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("gracePeriod"),
      parameters.getValue("invoicingCodes"),
    )
  }

  private fun tryAndRecover_removeCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.removeCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("serviceId"),
      parameters.getValue("secretFKeys"),
      parameters.getValue("tarificationIds"),
    )
  }

  private fun tryAndRecover_listInvoicesByHcPartyAndGroupId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("groupId"),
    )
  }

  private
      fun tryAndRecover_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("sentMediumType"),
      parameters.getValue("invoiceType"),
      parameters.getValue("sent"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun tryAndRecover_listInvoicesByContactIds(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listInvoicesByContactIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contactIds"),
    )
  }

  private fun tryAndRecover_listInvoicesByRecipientsIds(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listInvoicesByRecipientsIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("recipientsIds"),
    )
  }

  private fun tryAndRecover_listToInsurances(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listToInsurances(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun tryAndRecover_listToInsurancesUnsent(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listToInsurancesUnsent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun tryAndRecover_listToPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listToPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
    )
  }

  private fun tryAndRecover_listToPatientsUnsent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listToPatientsUnsent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
    )
  }

  private fun tryAndRecover_listInvoicesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listInvoicesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private
      fun tryAndRecover_listInvoicesByHcpartySendingModeStatusDate(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("sendingMode"),
      parameters.getValue("status"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }
}
