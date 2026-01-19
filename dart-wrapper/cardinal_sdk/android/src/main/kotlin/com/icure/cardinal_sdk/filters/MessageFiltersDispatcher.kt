// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.MessageFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MessageFiltersDispatcher {
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
    "allMessagesForDataOwner" -> allMessagesForDataOwner(parameters, resultCallback)
    "allMessagesForSelf" -> allMessagesForSelf(parameters, resultCallback)
    "byTransportGuidForDataOwner" -> byTransportGuidForDataOwner(parameters, resultCallback)
    "byTransportGuidForSelf" -> byTransportGuidForSelf(parameters, resultCallback)
    "fromAddressForDataOwner" -> fromAddressForDataOwner(parameters, resultCallback)
    "fromAddressForSelf" -> fromAddressForSelf(parameters, resultCallback)
    "byPatientsSentDateForDataOwner" -> byPatientsSentDateForDataOwner(parameters, resultCallback)
    "byPatientsSentDateForSelf" -> byPatientsSentDateForSelf(parameters, resultCallback)
    "byPatientSecretIdsSentDateForDataOwner" -> byPatientSecretIdsSentDateForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsSentDateForSelf" -> byPatientSecretIdsSentDateForSelf(parameters, resultCallback)
    "toAddressForDataOwner" -> toAddressForDataOwner(parameters, resultCallback)
    "toAddressForSelf" -> toAddressForSelf(parameters, resultCallback)
    "byTransportGuidSentDateForDataOwner" -> byTransportGuidSentDateForDataOwner(parameters, resultCallback)
    "byTransportGuidSentDateForSelf" -> byTransportGuidSentDateForSelf(parameters, resultCallback)
    "latestByTransportGuidForDataOwner" -> latestByTransportGuidForDataOwner(parameters, resultCallback)
    "latestByTransportGuidForSelf" -> latestByTransportGuidForSelf(parameters, resultCallback)
    "byInvoiceIds" -> byInvoiceIds(parameters, resultCallback)
    "byParentIds" -> byParentIds(parameters, resultCallback)
    "lifecycleBetweenForDataOwner" -> lifecycleBetweenForDataOwner(parameters, resultCallback)
    "lifecycleBetweenForDataOwnerInGroup" -> lifecycleBetweenForDataOwnerInGroup(parameters, resultCallback)
    "lifecycleBetweenForSelf" -> lifecycleBetweenForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun allMessagesForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.allMessagesForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun allMessagesForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.allMessagesForSelf(
      resultCallback,
    )
  }

  private fun byTransportGuidForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byTransportGuidForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("transportGuid"),
    )
  }

  private fun byTransportGuidForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byTransportGuidForSelf(
      resultCallback,
      parameters.getValue("transportGuid"),
    )
  }

  private fun fromAddressForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.fromAddressForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("address"),
    )
  }

  private fun fromAddressForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.fromAddressForSelf(
      resultCallback,
      parameters.getValue("address"),
    )
  }

  private fun byPatientsSentDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byPatientsSentDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsSentDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byPatientsSentDateForSelf(
      resultCallback,
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsSentDateForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byPatientSecretIdsSentDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsSentDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byPatientSecretIdsSentDateForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun toAddressForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.toAddressForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("address"),
    )
  }

  private fun toAddressForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.toAddressForSelf(
      resultCallback,
      parameters.getValue("address"),
    )
  }

  private fun byTransportGuidSentDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byTransportGuidSentDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("transportGuid"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byTransportGuidSentDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byTransportGuidSentDateForSelf(
      resultCallback,
      parameters.getValue("transportGuid"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun latestByTransportGuidForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.latestByTransportGuidForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("transportGuid"),
    )
  }

  private fun latestByTransportGuidForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.latestByTransportGuidForSelf(
      resultCallback,
      parameters.getValue("transportGuid"),
    )
  }

  private fun byInvoiceIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byInvoiceIds(
      resultCallback,
      parameters.getValue("invoiceIds"),
    )
  }

  private fun byParentIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.byParentIds(
      resultCallback,
      parameters.getValue("parentIds"),
    )
  }

  private fun lifecycleBetweenForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.lifecycleBetweenForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("startTimestamp"),
      parameters.getValue("endTimestamp"),
      parameters.getValue("descending"),
    )
  }

  private fun lifecycleBetweenForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.lifecycleBetweenForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("startTimestamp"),
      parameters.getValue("endTimestamp"),
      parameters.getValue("descending"),
    )
  }

  private fun lifecycleBetweenForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageFilters.lifecycleBetweenForSelf(
      resultCallback,
      parameters.getValue("startTimestamp"),
      parameters.getValue("endTimestamp"),
      parameters.getValue("descending"),
    )
  }
}
