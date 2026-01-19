// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.DocumentFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object DocumentFiltersDispatcher {
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
    "byPatientsCreatedForDataOwner" -> byPatientsCreatedForDataOwner(parameters, resultCallback)
    "byMessagesCreatedForDataOwner" -> byMessagesCreatedForDataOwner(parameters, resultCallback)
    "byPatientsCreatedForSelf" -> byPatientsCreatedForSelf(parameters, resultCallback)
    "byMessagesCreatedForSelf" -> byMessagesCreatedForSelf(parameters, resultCallback)
    "byOwningEntitySecretIdsCreatedForDataOwner" -> byOwningEntitySecretIdsCreatedForDataOwner(parameters, resultCallback)
    "byOwningEntitySecretIdsCreatedForSelf" -> byOwningEntitySecretIdsCreatedForSelf(parameters, resultCallback)
    "byPatientsAndTypeForDataOwner" -> byPatientsAndTypeForDataOwner(parameters, resultCallback)
    "byMessagesAndTypeForDataOwner" -> byMessagesAndTypeForDataOwner(parameters, resultCallback)
    "byPatientsAndTypeForSelf" -> byPatientsAndTypeForSelf(parameters, resultCallback)
    "byMessagesAndTypeForSelf" -> byMessagesAndTypeForSelf(parameters, resultCallback)
    "byOwningEntitySecretIdsAndTypeForDataOwner" -> byOwningEntitySecretIdsAndTypeForDataOwner(parameters, resultCallback)
    "byOwningEntitySecretIdsAndTypeForSelf" -> byOwningEntitySecretIdsAndTypeForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun byPatientsCreatedForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientsCreatedForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byMessagesCreatedForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byMessagesCreatedForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("messages"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsCreatedForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientsCreatedForSelf(
      resultCallback,
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byMessagesCreatedForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byMessagesCreatedForSelf(
      resultCallback,
      parameters.getValue("messages"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byOwningEntitySecretIdsCreatedForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byOwningEntitySecretIdsCreatedForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byOwningEntitySecretIdsCreatedForSelf(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byOwningEntitySecretIdsCreatedForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsAndTypeForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientsAndTypeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("documentType"),
      parameters.getValue("patients"),
    )
  }

  private fun byMessagesAndTypeForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byMessagesAndTypeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("documentType"),
      parameters.getValue("messages"),
    )
  }

  private fun byPatientsAndTypeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientsAndTypeForSelf(
      resultCallback,
      parameters.getValue("documentType"),
      parameters.getValue("patients"),
    )
  }

  private fun byMessagesAndTypeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byMessagesAndTypeForSelf(
      resultCallback,
      parameters.getValue("documentType"),
      parameters.getValue("messages"),
    )
  }

  private fun byOwningEntitySecretIdsAndTypeForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byOwningEntitySecretIdsAndTypeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("documentType"),
      parameters.getValue("secretIds"),
    )
  }

  private fun byOwningEntitySecretIdsAndTypeForSelf(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byOwningEntitySecretIdsAndTypeForSelf(
      resultCallback,
      parameters.getValue("documentType"),
      parameters.getValue("secretIds"),
    )
  }
}
