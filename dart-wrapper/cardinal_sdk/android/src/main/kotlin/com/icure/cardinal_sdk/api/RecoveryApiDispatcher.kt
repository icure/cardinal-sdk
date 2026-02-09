// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.RecoveryApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object RecoveryApiDispatcher {
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
    "createRecoveryInfoForAvailableKeyPairs" -> createRecoveryInfoForAvailableKeyPairs(parameters, resultCallback)
    "recoverKeyPairs" -> recoverKeyPairs(parameters, resultCallback)
    "recoverKeyPairsWaitingForCreation" -> recoverKeyPairsWaitingForCreation(parameters, resultCallback)
    "createExchangeDataRecoveryInfo" -> createExchangeDataRecoveryInfo(parameters, resultCallback)
    "recoverExchangeData" -> recoverExchangeData(parameters, resultCallback)
    "getRecoveryExchangeData" -> getRecoveryExchangeData(parameters, resultCallback)
    "purgeRecoveryInfo" -> purgeRecoveryInfo(parameters, resultCallback)
    "purgeAllRecoveryInfoFor" -> purgeAllRecoveryInfoFor(parameters, resultCallback)
    "purgeAllKeyPairRecoveryInfoFor" -> purgeAllKeyPairRecoveryInfoFor(parameters, resultCallback)
    "purgeAllExchangeDataRecoveryInfoFor" -> purgeAllExchangeDataRecoveryInfoFor(parameters, resultCallback)
    "preGenerateRecoveryKey" -> preGenerateRecoveryKey(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createRecoveryInfoForAvailableKeyPairs(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.createRecoveryInfoForAvailableKeyPairs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("includeParentsKeys"),
      parameters.getValue("lifetimeSeconds"),
      parameters.getValue("recoveryKeyOptions"),
    )
  }

  private fun recoverKeyPairs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.recoverKeyPairs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("recoveryKey"),
      parameters.getValue("autoDelete"),
    )
  }

  private fun recoverKeyPairsWaitingForCreation(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.recoverKeyPairsWaitingForCreation(
      resultCallback,
      parameters.getValue("cancellationToken").toLong(),
      parameters.getValue("sdkId"),
      parameters.getValue("recoveryKey"),
      parameters.getValue("autoDelete"),
      parameters.getValue("waitSeconds"),
    )
  }

  private fun createExchangeDataRecoveryInfo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.createExchangeDataRecoveryInfo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("lifetimeSeconds"),
      parameters.getValue("recoveryKeyOptions"),
      parameters.getValue("includeBiDirectional"),
      parameters.getValue("includeAsParent"),
    )
  }

  private fun recoverExchangeData(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.recoverExchangeData(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("recoveryKey"),
    )
  }

  private fun getRecoveryExchangeData(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.getRecoveryExchangeData(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("recoveryKey"),
      parameters.getValue("autoDelete"),
    )
  }

  private fun purgeRecoveryInfo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.purgeRecoveryInfo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("recoveryKey"),
    )
  }

  private fun purgeAllRecoveryInfoFor(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.purgeAllRecoveryInfoFor(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun purgeAllKeyPairRecoveryInfoFor(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.purgeAllKeyPairRecoveryInfoFor(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun purgeAllExchangeDataRecoveryInfoFor(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.purgeAllExchangeDataRecoveryInfoFor(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun preGenerateRecoveryKey(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RecoveryApi.preGenerateRecoveryKey(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("keySize"),
    )
  }
}
