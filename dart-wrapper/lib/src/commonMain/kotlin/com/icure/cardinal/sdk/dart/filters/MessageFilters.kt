// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.time.Instant
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object MessageFilters {
  public fun allMessagesForDataOwner(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, dataOwnerIdString: String) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.allMessagesForDataOwner(
        dataOwnerId,
      )
    }
  }

  public fun allMessagesForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.allMessagesForSelf(
      )
    }
  }

  public fun byTransportGuidForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    transportGuidString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val transportGuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      transportGuidString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byTransportGuidForDataOwner(
        dataOwnerId,
        transportGuid,
      )
    }
  }

  public fun byTransportGuidForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, transportGuidString: String) {
    val transportGuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      transportGuidString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byTransportGuidForSelf(
        transportGuid,
      )
    }
  }

  public fun fromAddressForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    addressString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val address = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      addressString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.fromAddressForDataOwner(
        dataOwnerId,
        address,
      )
    }
  }

  public fun fromAddressForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, addressString: String) {
    val address = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      addressString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.fromAddressForSelf(
        address,
      )
    }
  }

  public fun byPatientsSentDateForDataOwner(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byPatientsSentDateForDataOwner(
        dataOwnerId,
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsSentDateForSelf(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byPatientsSentDateForSelf(
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsSentDateForDataOwner(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byPatientSecretIdsSentDateForDataOwner(
        dataOwnerId,
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsSentDateForSelf(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byPatientSecretIdsSentDateForSelf(
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun toAddressForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    addressString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val address = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      addressString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.toAddressForDataOwner(
        dataOwnerId,
        address,
      )
    }
  }

  public fun toAddressForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, addressString: String) {
    val address = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      addressString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.toAddressForSelf(
        address,
      )
    }
  }

  public fun byTransportGuidSentDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    transportGuidString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val transportGuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      transportGuidString
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byTransportGuidSentDateForDataOwner(
        dataOwnerId,
        transportGuid,
        from,
        to,
        descending,
      )
    }
  }

  public fun byTransportGuidSentDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    transportGuidString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val transportGuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      transportGuidString
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byTransportGuidSentDateForSelf(
        transportGuid,
        from,
        to,
        descending,
      )
    }
  }

  public fun latestByTransportGuidForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    transportGuidString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val transportGuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      transportGuidString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.latestByTransportGuidForDataOwner(
        dataOwnerId,
        transportGuid,
      )
    }
  }

  public fun latestByTransportGuidForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, transportGuidString: String) {
    val transportGuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      transportGuidString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.latestByTransportGuidForSelf(
        transportGuid,
      )
    }
  }

  public fun byInvoiceIds(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, invoiceIdsString: String) {
    val invoiceIds = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      invoiceIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byInvoiceIds(
        invoiceIds,
      )
    }
  }

  public fun byParentIds(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, parentIdsString: String) {
    val parentIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      parentIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.byParentIds(
        parentIds,
      )
    }
  }

  public fun lifecycleBetweenForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    startTimestampString: String,
    endTimestampString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val startTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startTimestampString
    )
    val endTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endTimestampString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.lifecycleBetweenForDataOwner(
        dataOwnerId,
        startTimestamp,
        endTimestamp,
        descending,
      )
    }
  }

  public fun lifecycleBetweenForDataOwnerInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerString: String,
    startTimestampString: String,
    endTimestampString: String,
    descendingString: String,
  ) {
    val dataOwner = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      dataOwnerString
    )
    val startTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startTimestampString
    )
    val endTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endTimestampString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.lifecycleBetweenForDataOwnerInGroup(
        dataOwner,
        startTimestamp,
        endTimestamp,
        descending,
      )
    }
  }

  public fun lifecycleBetweenForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    startTimestampString: String,
    endTimestampString: String,
    descendingString: String,
  ) {
    val startTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startTimestampString
    )
    val endTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endTimestampString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Message::class))
    ) {
      com.icure.cardinal.sdk.filters.MessageFilters.lifecycleBetweenForSelf(
        startTimestamp,
        endTimestamp,
        descending,
      )
    }
  }
}
