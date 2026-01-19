// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.InsuranceApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object InsuranceApiDispatcher {
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
    "getInsurance" -> getInsurance(parameters, resultCallback)
    "getInsurances" -> getInsurances(parameters, resultCallback)
    "createInsurance" -> createInsurance(parameters, resultCallback)
    "deleteInsurance" -> deleteInsurance(parameters, resultCallback)
    "listInsurancesByCode" -> listInsurancesByCode(parameters, resultCallback)
    "listInsurancesByName" -> listInsurancesByName(parameters, resultCallback)
    "modifyInsurance" -> modifyInsurance(parameters, resultCallback)
    "createInsurancesInGroup" -> createInsurancesInGroup(parameters, resultCallback)
    "getInsurancesInGroup" -> getInsurancesInGroup(parameters, resultCallback)
    "modifyInsurancesInGroup" -> modifyInsurancesInGroup(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getInsurance(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.getInsurance(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("insuranceId"),
    )
  }

  private fun getInsurances(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.getInsurances(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("insuranceIds"),
    )
  }

  private fun createInsurance(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.createInsurance(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("insurance"),
    )
  }

  private fun deleteInsurance(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.deleteInsurance(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("insuranceId"),
    )
  }

  private fun listInsurancesByCode(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.listInsurancesByCode(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("insuranceCode"),
    )
  }

  private fun listInsurancesByName(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.listInsurancesByName(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("insuranceName"),
    )
  }

  private fun modifyInsurance(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.modifyInsurance(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("insurance"),
    )
  }

  private fun createInsurancesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.createInsurancesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("insuranceBatch"),
    )
  }

  private fun getInsurancesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.getInsurancesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("insuranceIds"),
    )
  }

  private fun modifyInsurancesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    InsuranceApi.modifyInsurancesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("insuranceBatch"),
    )
  }
}
