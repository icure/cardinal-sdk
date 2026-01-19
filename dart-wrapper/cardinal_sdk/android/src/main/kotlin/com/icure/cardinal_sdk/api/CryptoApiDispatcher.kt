// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.CryptoApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CryptoApiDispatcher {
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
    "getAccessControlKeys" -> getAccessControlKeys(parameters, resultCallback)
    "forceReload" -> forceReload(parameters, resultCallback)
    "currentDataOwnerKeys" -> currentDataOwnerKeys(parameters, resultCallback)
    "keylessCreateExchangeDataTo" -> keylessCreateExchangeDataTo(parameters, resultCallback)
    "injectExchangeData" -> injectExchangeData(parameters, resultCallback)
    "inGroup.keylessCreateExchangeDataTo" -> inGroup_keylessCreateExchangeDataTo(parameters, resultCallback)
    "inGroup.getAccessControlKeys" -> inGroup_getAccessControlKeys(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getAccessControlKeys(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.getAccessControlKeys(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityType"),
    )
  }

  private fun forceReload(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.forceReload(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun currentDataOwnerKeys(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.currentDataOwnerKeys(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filterTrustedKeys"),
    )
  }

  private fun keylessCreateExchangeDataTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.keylessCreateExchangeDataTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegate"),
    )
  }

  private fun injectExchangeData(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.injectExchangeData(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("details"),
      parameters.getValue("reEncryptWithOwnKeys"),
    )
  }

  private fun inGroup_keylessCreateExchangeDataTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.inGroup.keylessCreateExchangeDataTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("delegate"),
    )
  }

  private fun inGroup_getAccessControlKeys(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.inGroup.getAccessControlKeys(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityType"),
    )
  }
}
