// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.serialization.Pkcs8BytesAsBase64Serializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object CryptoApi {
  public fun getAccessControlKeys(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityTypeString: String,
  ) {
    val entityType = fullLanguageInteropJson.decodeFromString(
      EntityWithEncryptionMetadataTypeName.serializer(),
      entityTypeString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).crypto.getAccessControlKeys(
        entityType,
      )
    }
  }

  public fun forceReload(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).crypto.forceReload()
    }
  }

  public fun currentDataOwnerKeys(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterTrustedKeysString: String,
  ) {
    val filterTrustedKeys = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      filterTrustedKeysString
    )
    ApiScope.execute(
      dartResultCallback,
      MapSerializer(String.serializer(), MapSerializer(KeypairFingerprintV1String.serializer(),
          Pkcs8BytesAsBase64Serializer))) {
      NativeReferences.get<CardinalApis>(sdkId).crypto.currentDataOwnerKeys(
        filterTrustedKeys,
      )
    }
  }

  public fun keylessCreateExchangeDataTo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    delegateString: String,
  ) {
    val delegate = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateString
    )
    ApiScope.execute(
      dartResultCallback,
      RawDecryptedExchangeData.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).crypto.keylessCreateExchangeDataTo(
        delegate,
      )
    }
  }

  public fun injectExchangeData(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    detailsString: String,
    reEncryptWithOwnKeysString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      groupIdString
    )
    val details = fullLanguageInteropJson.decodeFromString(
      ListSerializer(ExchangeDataInjectionDetails.serializer()),
      detailsString
    )
    val reEncryptWithOwnKeys = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      reEncryptWithOwnKeysString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).crypto.injectExchangeData(
        groupId,
        details,
        reEncryptWithOwnKeys,
      )
    }
  }

  @OptIn(InternalIcureApi::class)
  public object inGroup {
    public fun keylessCreateExchangeDataTo(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      delegateString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        groupIdString
      )
      val delegate = fullLanguageInteropJson.decodeFromString(
        EntityReferenceInGroup.serializer(),
        delegateString
      )
      ApiScope.execute(
        dartResultCallback,
        RawDecryptedExchangeData.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).crypto.inGroup.keylessCreateExchangeDataTo(
          groupId,
          delegate,
        )
      }
    }

    public fun getAccessControlKeys(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      entityTypeString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        groupIdString
      )
      val entityType = fullLanguageInteropJson.decodeFromString(
        EntityWithEncryptionMetadataTypeName.serializer(),
        entityTypeString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).crypto.inGroup.getAccessControlKeys(
          groupId,
          entityType,
        )
      }
    }
  }
}
