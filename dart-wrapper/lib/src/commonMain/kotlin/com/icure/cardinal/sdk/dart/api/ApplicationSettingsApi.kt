// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.EncryptedApplicationSettings
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer

@OptIn(InternalIcureApi::class)
public object ApplicationSettingsApi {
  public fun getApplicationSettings(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedApplicationSettings.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).applicationSettings.getApplicationSettings()
    }
  }

  public fun createApplicationSettings(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    applicationSettingsString: String,
  ) {
    val applicationSettings = fullLanguageInteropJson.decodeFromString(
      EncryptedApplicationSettings.serializer(),
      applicationSettingsString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedApplicationSettings.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).applicationSettings.createApplicationSettings(
        applicationSettings,
      )
    }
  }

  public fun updateApplicationSettings(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    applicationSettingsString: String,
  ) {
    val applicationSettings = fullLanguageInteropJson.decodeFromString(
      EncryptedApplicationSettings.serializer(),
      applicationSettingsString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedApplicationSettings.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).applicationSettings.updateApplicationSettings(
        applicationSettings,
      )
    }
  }
}
