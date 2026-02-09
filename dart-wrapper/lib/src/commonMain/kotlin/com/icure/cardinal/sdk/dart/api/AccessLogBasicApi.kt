// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object AccessLogBasicApi {
  public fun matchAccessLogsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.matchAccessLogsBy(
        filter,
      )
    }
  }

  public fun matchAccessLogsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.matchAccessLogsBySorted(
        filter,
      )
    }
  }

  public fun filterAccessLogsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.filterAccessLogsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedAccessLog.serializer()
      ))
    }
  }

  public fun filterAccessLogsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.filterAccessLogsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedAccessLog.serializer()
      ))
    }
  }

  public fun deleteAccessLogById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      StoredDocumentIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.deleteAccessLogById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteAccessLogsByIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(StoredDocumentIdentifier.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(StoredDocumentIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.deleteAccessLogsByIds(
        entityIds,
      )
    }
  }

  public fun purgeAccessLogById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.purgeAccessLogById(
        id,
        rev,
      )
    }
  }

  public fun deleteAccessLog(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    accessLogString: String,
  ) {
    val accessLog = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(AccessLog::class),
      accessLogString
    )
    ApiScope.execute(
      dartResultCallback,
      StoredDocumentIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.deleteAccessLog(
        accessLog,
      )
    }
  }

  public fun deleteAccessLogs(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    accessLogsString: String,
  ) {
    val accessLogs = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(AccessLog::class)),
      accessLogsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(StoredDocumentIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.deleteAccessLogs(
        accessLogs,
      )
    }
  }

  public fun purgeAccessLog(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    accessLogString: String,
  ) {
    val accessLog = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(AccessLog::class),
      accessLogString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.purgeAccessLog(
        accessLog,
      )
    }
  }

  public fun createAccessLog(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      EncryptedAccessLog.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.createAccessLog(
        entity,
      )
    }
  }

  public fun undeleteAccessLogById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.undeleteAccessLogById(
        id,
        rev,
      )
    }
  }

  public fun undeleteAccessLog(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    accessLogString: String,
  ) {
    val accessLog = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(AccessLog::class),
      accessLogString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.undeleteAccessLog(
        accessLog,
      )
    }
  }

  public fun modifyAccessLog(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      EncryptedAccessLog.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.modifyAccessLog(
        entity,
      )
    }
  }

  public fun getAccessLog(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedAccessLog.serializer().nullable) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.getAccessLog(
        entityId,
      )
    }
  }

  public fun getAccessLogs(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedAccessLog.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.getAccessLogs(
        entityIds,
      )
    }
  }

  @OptIn(InternalIcureApi::class)
  public object inGroup {
    public fun matchAccessLogsBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.matchAccessLogsBy(
          groupId,
          filter,
        )
      }
    }

    public fun matchAccessLogsBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.matchAccessLogsBySorted(
          groupId,
          filter,
        )
      }
    }

    public fun filterAccessLogsBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.filterAccessLogsBy(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(EncryptedAccessLog.serializer())
        ))
      }
    }

    public fun filterAccessLogsBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.filterAccessLogsBySorted(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(EncryptedAccessLog.serializer())
        ))
      }
    }

    public fun deleteAccessLogById(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdString: String,
    ) {
      val entityId = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
        entityIdString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(StoredDocumentIdentifier.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.deleteAccessLogById(
          entityId,
        )
      }
    }

    public fun deleteAccessLogsByIds(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdsString: String,
    ) {
      val entityIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
        entityIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.deleteAccessLogsByIds(
          entityIds,
        )
      }
    }

    public fun deleteAccessLog(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      accessLogString: String,
    ) {
      val accessLog = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)),
        accessLogString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(StoredDocumentIdentifier.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.deleteAccessLog(
          accessLog,
        )
      }
    }

    public fun deleteAccessLogs(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      accessLogsString: String,
    ) {
      val accessLogs = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(PolymorphicSerializer(AccessLog::class))),
        accessLogsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.deleteAccessLogs(
          accessLogs,
        )
      }
    }

    public fun createAccessLog(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(EncryptedAccessLog.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(EncryptedAccessLog.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.createAccessLog(
          entity,
        )
      }
    }

    public fun modifyAccessLog(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(EncryptedAccessLog.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(EncryptedAccessLog.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.modifyAccessLog(
          entity,
        )
      }
    }

    public fun getAccessLog(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      entityIdString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(EncryptedAccessLog.serializer()).nullable) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.getAccessLog(
          groupId,
          entityId,
        )
      }
    }

    public fun getAccessLogs(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      entityIdsString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val entityIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        entityIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(EncryptedAccessLog.serializer()))) {
        NativeReferences.get<CardinalBaseApis>(sdkId).accessLog.inGroup.getAccessLogs(
          groupId,
          entityIds,
        )
      }
    }
  }
}
