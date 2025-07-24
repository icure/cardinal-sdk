// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.time.Instant
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object AccessLogFilters {
  public fun byPatientsDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    patientsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class))
    ) {
      com.icure.cardinal.sdk.filters.AccessLogFilters.byPatientsDateForDataOwner(
        dataOwnerId,
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    patientsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class))
    ) {
      com.icure.cardinal.sdk.filters.AccessLogFilters.byPatientsDateForSelf(
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    secretIdsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class))
    ) {
      com.icure.cardinal.sdk.filters.AccessLogFilters.byPatientSecretIdsDateForDataOwner(
        dataOwnerId,
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    secretIdsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class))
    ) {
      com.icure.cardinal.sdk.filters.AccessLogFilters.byPatientSecretIdsDateForSelf(
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byDate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val from = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class))
    ) {
      com.icure.cardinal.sdk.filters.AccessLogFilters.byDate(
        from,
        to,
        descending,
      )
    }
  }

  public fun byUserTypeDate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    userIdString: String,
    accessTypeString: String,
    fromString: String,
    descendingString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val accessType = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      accessTypeString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Instant.serializer().nullable,
      fromString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class))
    ) {
      com.icure.cardinal.sdk.filters.AccessLogFilters.byUserTypeDate(
        userId,
        accessType,
        from,
        descending,
      )
    }
  }
}
