// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object InsuranceApi {
  public fun getInsurance(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceIdString: String,
  ) {
    val insuranceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      insuranceIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Insurance.serializer().nullable) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.getInsurance(
        insuranceId,
      )
    }
  }

  public fun getInsurances(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceIdsString: String,
  ) {
    val insuranceIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      insuranceIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.getInsurances(
        insuranceIds,
      )
    }
  }

  public fun createInsurance(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceString: String,
  ) {
    val insurance = fullLanguageInteropJson.decodeFromString(
      Insurance.serializer(),
      insuranceString
    )
    ApiScope.execute(
      dartResultCallback,
      Insurance.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.createInsurance(
        insurance,
      )
    }
  }

  public fun deleteInsurance(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceIdString: String,
  ) {
    val insuranceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      insuranceIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.deleteInsurance(
        insuranceId,
      )
    }
  }

  public fun listInsurancesByCode(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceCodeString: String,
  ) {
    val insuranceCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      insuranceCodeString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.listInsurancesByCode(
        insuranceCode,
      )
    }
  }

  public fun listInsurancesByName(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceNameString: String,
  ) {
    val insuranceName = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      insuranceNameString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.listInsurancesByName(
        insuranceName,
      )
    }
  }

  public fun modifyInsurance(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceString: String,
  ) {
    val insurance = fullLanguageInteropJson.decodeFromString(
      Insurance.serializer(),
      insuranceString
    )
    ApiScope.execute(
      dartResultCallback,
      Insurance.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.modifyInsurance(
        insurance,
      )
    }
  }

  public fun createInsurancesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    insuranceBatchString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val insuranceBatch = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Insurance.serializer()),
      insuranceBatchString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.createInsurancesInGroup(
        groupId,
        insuranceBatch,
      )
    }
  }

  public fun getInsurancesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    insuranceIdsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val insuranceIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      insuranceIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.getInsurancesInGroup(
        groupId,
        insuranceIds,
      )
    }
  }

  public fun modifyInsurancesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    insuranceBatchString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val insuranceBatch = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Insurance.serializer()),
      insuranceBatchString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).insurance.modifyInsurancesInGroup(
        groupId,
        insuranceBatch,
      )
    }
  }
}
