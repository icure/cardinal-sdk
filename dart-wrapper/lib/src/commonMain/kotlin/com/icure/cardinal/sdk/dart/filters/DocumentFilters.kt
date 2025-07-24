// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.DocumentType
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
public object DocumentFilters {
  public fun byPatientsCreatedForDataOwner(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Document::class))
    ) {
      com.icure.cardinal.sdk.filters.DocumentFilters.byPatientsCreatedForDataOwner(
        dataOwnerId,
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsCreatedForSelf(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Document::class))
    ) {
      com.icure.cardinal.sdk.filters.DocumentFilters.byPatientsCreatedForSelf(
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsCreatedForDataOwner(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Document::class))
    ) {
      com.icure.cardinal.sdk.filters.DocumentFilters.byPatientSecretIdsCreatedForDataOwner(
        dataOwnerId,
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsCreatedForSelf(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Document::class))
    ) {
      com.icure.cardinal.sdk.filters.DocumentFilters.byPatientSecretIdsCreatedForSelf(
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsAndTypeForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    documentTypeString: String,
    patientsString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val documentType = fullLanguageInteropJson.decodeFromString(
      DocumentType.serializer(),
      documentTypeString
    )
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Document::class))
    ) {
      com.icure.cardinal.sdk.filters.DocumentFilters.byPatientsAndTypeForDataOwner(
        dataOwnerId,
        documentType,
        patients,
      )
    }
  }

  public fun byPatientsAndTypeForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    documentTypeString: String,
    patientsString: String,
  ) {
    val documentType = fullLanguageInteropJson.decodeFromString(
      DocumentType.serializer(),
      documentTypeString
    )
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Document::class))
    ) {
      com.icure.cardinal.sdk.filters.DocumentFilters.byPatientsAndTypeForSelf(
        documentType,
        patients,
      )
    }
  }

  public fun byPatientSecretIdsAndTypeForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    documentTypeString: String,
    secretIdsString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val documentType = fullLanguageInteropJson.decodeFromString(
      DocumentType.serializer(),
      documentTypeString
    )
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Document::class))
    ) {
      com.icure.cardinal.sdk.filters.DocumentFilters.byPatientSecretIdsAndTypeForDataOwner(
        dataOwnerId,
        documentType,
        secretIds,
      )
    }
  }

  public fun byPatientSecretIdsAndTypeForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    documentTypeString: String,
    secretIdsString: String,
  ) {
    val documentType = fullLanguageInteropJson.decodeFromString(
      DocumentType.serializer(),
      documentTypeString
    )
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Document::class))
    ) {
      com.icure.cardinal.sdk.filters.DocumentFilters.byPatientSecretIdsAndTypeForSelf(
        documentType,
        secretIds,
      )
    }
  }
}
