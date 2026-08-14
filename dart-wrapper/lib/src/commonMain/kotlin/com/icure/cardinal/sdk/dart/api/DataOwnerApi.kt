// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object DataOwnerApi {
  public fun getCurrentDataOwner(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      DataOwnerWithType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwner()
    }
  }

  public fun getCurrentDataOwnerStub(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      CryptoActorStubWithType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwnerStub()
    }
  }

  public fun getCurrentDataOwnerId(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwnerId()
    }
  }

  public fun getCurrentDataOwnerReference(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      EntityReferenceInGroup.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwnerReference()
    }
  }

  public fun getCurrentDataOwnerHierarchyIds(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwnerHierarchyIds()
    }
  }

  public fun getCurrentDataOwnerHierarchyIdsReference(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EntityReferenceInGroup.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwnerHierarchyIdsReference()
    }
  }

  public fun getDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    ownerIdString: String,
  ) {
    val ownerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      ownerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DataOwnerWithType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getDataOwner(
        ownerId,
      )
    }
  }

  public fun getCryptoActorStub(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    ownerIdString: String,
  ) {
    val ownerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      ownerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      CryptoActorStubWithType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCryptoActorStub(
        ownerId,
      )
    }
  }

  public fun getCryptoActorStubInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityReferenceInGroupString: String,
  ) {
    val entityReferenceInGroup = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      entityReferenceInGroupString
    )
    ApiScope.execute(
      dartResultCallback,
      CryptoActorStubWithType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCryptoActorStubInGroup(
        entityReferenceInGroup,
      )
    }
  }

  public fun getCurrentDataOwnerHierarchyIdsFrom(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    parentIdString: String,
  ) {
    val parentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      parentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwnerParentHierarchy(
        parentId,
      )
    }
  }

  public fun getCurrentDataOwnerHierarchy(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DataOwnerWithType.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwnerHierarchy()
    }
  }

  public fun modifyDataOwnerStub(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    cryptoActorStubWithTypeDtoString: String,
  ) {
    val cryptoActorStubWithTypeDto = fullLanguageInteropJson.decodeFromString(
      CryptoActorStubWithType.serializer(),
      cryptoActorStubWithTypeDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      CryptoActorStubWithType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.modifyDataOwnerStub(
        cryptoActorStubWithTypeDto,
      )
    }
  }

  public fun getCurrentDataOwnerType(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      DataOwnerType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.getCurrentDataOwnerType()
    }
  }

  public fun clearCurrentDataOwnerIdsCache(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).dataOwner.clearCurrentDataOwnerIdsCache()
    }
  }
}
