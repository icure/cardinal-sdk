// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.AccessLogShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.MapAsArraySerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object AccessLogApi {
  public fun withEncryptionMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    baseString: String,
    patientString: String,
    userString: String,
    delegatesString: String,
    secretIdString: String,
    alternateRootDelegateIdString: String,
  ) {
    val base = fullLanguageInteropJson.decodeFromString(
      DecryptedAccessLog.serializer().nullable,
      baseString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer().nullable,
      userString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), AccessLevel.serializer()),
      delegatesString
    )
    val secretId = fullLanguageInteropJson.decodeFromString(
      SecretIdUseOption.serializer(),
      secretIdString
    )
    val alternateRootDelegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      alternateRootDelegateIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.withEncryptionMetadata(
        base,
        patient,
        user,
        delegates,
        secretId,
        alternateRootDelegateId,
      )
    }
  }

  public fun getEncryptionKeysOf(
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
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.getEncryptionKeysOf(
        accessLog,
      )
    }
  }

  public fun hasWriteAccess(
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
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.hasWriteAccess(
        accessLog,
      )
    }
  }

  public fun decryptPatientIdOf(
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
      SetSerializer(EntityReferenceInGroup.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.decryptPatientIdOf(
        accessLog,
      )
    }
  }

  public fun createDelegationDeAnonymizationMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
    delegatesString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(AccessLog::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.createDelegationDeAnonymizationMetadata(
        entity,
        delegates,
      )
    }
  }

  public fun decrypt(
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
      EncryptedAccessLog.serializer(),
      accessLogString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.decrypt(
        accessLog,
      )
    }
  }

  public fun tryDecrypt(
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
      EncryptedAccessLog.serializer(),
      accessLogString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(AccessLog::class)) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.tryDecrypt(
        accessLog,
      )
    }
  }

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
      FilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.matchAccessLogsBy(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.matchAccessLogsBySorted(
        filter,
      )
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
      NativeReferences.get<CardinalApis>(sdkId).accessLog.deleteAccessLogById(
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
      NativeReferences.get<CardinalApis>(sdkId).accessLog.deleteAccessLogsByIds(
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
      NativeReferences.get<CardinalApis>(sdkId).accessLog.purgeAccessLogById(
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
      NativeReferences.get<CardinalApis>(sdkId).accessLog.deleteAccessLog(
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
      NativeReferences.get<CardinalApis>(sdkId).accessLog.deleteAccessLogs(
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
      NativeReferences.get<CardinalApis>(sdkId).accessLog.purgeAccessLog(
        accessLog,
      )
    }
  }

  public fun shareWith(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    delegateIdString: String,
    accessLogString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val accessLog = fullLanguageInteropJson.decodeFromString(
      DecryptedAccessLog.serializer(),
      accessLogString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      AccessLogShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.shareWith(
        delegateId,
        accessLog,
        options,
      )
    }
  }

  public fun shareWithMany(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    accessLogString: String,
    delegatesString: String,
  ) {
    val accessLog = fullLanguageInteropJson.decodeFromString(
      DecryptedAccessLog.serializer(),
      accessLogString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), AccessLogShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.shareWithMany(
        accessLog,
        delegates,
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
      FilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).accessLog.filterAccessLogsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedAccessLog.serializer()
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
      SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).accessLog.filterAccessLogsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedAccessLog.serializer()
      ))
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
      DecryptedAccessLog.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.createAccessLog(
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
      DecryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.undeleteAccessLogById(
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
      DecryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.undeleteAccessLog(
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
      DecryptedAccessLog.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedAccessLog.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.modifyAccessLog(
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
      DecryptedAccessLog.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.getAccessLog(
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
      ListSerializer(DecryptedAccessLog.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).accessLog.getAccessLogs(
        entityIds,
      )
    }
  }

  @OptIn(InternalIcureApi::class)
  public object encrypted {
    public fun shareWith(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      accessLogString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val accessLog = fullLanguageInteropJson.decodeFromString(
        EncryptedAccessLog.serializer(),
        accessLogString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        AccessLogShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedAccessLog.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.shareWith(
          delegateId,
          accessLog,
          options,
        )
      }
    }

    public fun shareWithMany(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      accessLogString: String,
      delegatesString: String,
    ) {
      val accessLog = fullLanguageInteropJson.decodeFromString(
        EncryptedAccessLog.serializer(),
        accessLogString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), AccessLogShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedAccessLog.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.shareWithMany(
          accessLog,
          delegates,
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
        FilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.filterAccessLogsBy(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.filterAccessLogsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedAccessLog.serializer()
        ))
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.createAccessLog(
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.undeleteAccessLogById(
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.undeleteAccessLog(
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.modifyAccessLog(
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.getAccessLog(
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.encrypted.getAccessLogs(
          entityIds,
        )
      }
    }
  }

  @OptIn(InternalIcureApi::class)
  public object tryAndRecover {
    public fun shareWith(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      accessLogString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val accessLog = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(AccessLog::class),
        accessLogString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        AccessLogShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(AccessLog::class)) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.shareWith(
          delegateId,
          accessLog,
          options,
        )
      }
    }

    public fun shareWithMany(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      accessLogString: String,
      delegatesString: String,
    ) {
      val accessLog = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(AccessLog::class),
        accessLogString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), AccessLogShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(AccessLog::class)) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.shareWithMany(
          accessLog,
          delegates,
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
        FilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.filterAccessLogsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(AccessLog::class)
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
        SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.filterAccessLogsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(AccessLog::class)
        ))
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
        PolymorphicSerializer(AccessLog::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(AccessLog::class)) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.createAccessLog(
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
        PolymorphicSerializer(AccessLog::class)) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.undeleteAccessLogById(
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
        PolymorphicSerializer(AccessLog::class)) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.undeleteAccessLog(
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
        PolymorphicSerializer(AccessLog::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(AccessLog::class)) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.modifyAccessLog(
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
        PolymorphicSerializer(AccessLog::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.getAccessLog(
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
        ListSerializer(PolymorphicSerializer(AccessLog::class))) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.tryAndRecover.getAccessLogs(
          entityIds,
        )
      }
    }
  }

  @OptIn(InternalIcureApi::class)
  public object inGroup {
    public fun withEncryptionMetadata(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityGroupIdString: String,
      baseString: String,
      patientString: String,
      userString: String,
      delegatesString: String,
      secretIdString: String,
      alternateRootDelegateReferenceString: String,
    ) {
      val entityGroupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityGroupIdString
      )
      val base = fullLanguageInteropJson.decodeFromString(
        DecryptedAccessLog.serializer().nullable,
        baseString
      )
      val patient = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(Patient::class)),
        patientString
      )
      val user = fullLanguageInteropJson.decodeFromString(
        User.serializer().nullable,
        userString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapAsArraySerializer(EntityReferenceInGroup.serializer(), AccessLevel.serializer()),
        delegatesString
      )
      val secretId = fullLanguageInteropJson.decodeFromString(
        SecretIdUseOption.serializer(),
        secretIdString
      )
      val alternateRootDelegateReference = fullLanguageInteropJson.decodeFromString(
        EntityReferenceInGroup.serializer().nullable,
        alternateRootDelegateReferenceString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(DecryptedAccessLog.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.withEncryptionMetadata(
          entityGroupId,
          base,
          patient,
          user,
          delegates,
          secretId,
          alternateRootDelegateReference,
        )
      }
    }

    public fun getEncryptionKeysOf(
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
        SetSerializer(HexString.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.getEncryptionKeysOf(
          accessLog,
        )
      }
    }

    public fun hasWriteAccess(
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
        Boolean.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.hasWriteAccess(
          accessLog,
        )
      }
    }

    public fun decryptPatientIdOf(
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
        SetSerializer(EntityReferenceInGroup.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.decryptPatientIdOf(
          accessLog,
        )
      }
    }

    public fun createDelegationDeAnonymizationMetadata(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
      delegatesString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)),
        entityString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        SetSerializer(EntityReferenceInGroup.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        Unit.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.createDelegationDeAnonymizationMetadata(
          entity,
          delegates,
        )
      }
    }

    public fun decrypt(
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
        ListSerializer(GroupScoped.serializer(EncryptedAccessLog.serializer())),
        accessLogsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(DecryptedAccessLog.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.decrypt(
          accessLogs,
        )
      }
    }

    public fun tryDecrypt(
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
        ListSerializer(GroupScoped.serializer(EncryptedAccessLog.serializer())),
        accessLogsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)))) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryDecrypt(
          accessLogs,
        )
      }
    }

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
        FilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.matchAccessLogsBy(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.matchAccessLogsBySorted(
          groupId,
          filter,
        )
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.deleteAccessLogById(
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.deleteAccessLogsByIds(
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.deleteAccessLog(
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
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.deleteAccessLogs(
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
        GroupScoped.serializer(DecryptedAccessLog.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(DecryptedAccessLog.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.createAccessLog(
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
        GroupScoped.serializer(DecryptedAccessLog.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(DecryptedAccessLog.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.modifyAccessLog(
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
        GroupScoped.serializer(DecryptedAccessLog.serializer()).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.getAccessLog(
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
        ListSerializer(GroupScoped.serializer(DecryptedAccessLog.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.getAccessLogs(
          groupId,
          entityIds,
        )
      }
    }

    @OptIn(InternalIcureApi::class)
    public object encrypted {
      public fun shareWith(
        dartResultCallback: (
          String?,
          String?,
          String?,
          String?,
        ) -> Unit,
        sdkId: String,
        delegateString: String,
        accessLogString: String,
        optionsString: String,
      ) {
        val delegate = fullLanguageInteropJson.decodeFromString(
          EntityReferenceInGroup.serializer(),
          delegateString
        )
        val accessLog = fullLanguageInteropJson.decodeFromString(
          GroupScoped.serializer(EncryptedAccessLog.serializer()),
          accessLogString
        )
        val options = fullLanguageInteropJson.decodeFromString(
          AccessLogShareOptions.serializer().nullable,
          optionsString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(EncryptedAccessLog.serializer())) {
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.encrypted.shareWith(
            delegate,
            accessLog,
            options,
          )
        }
      }

      public fun shareWithMany(
        dartResultCallback: (
          String?,
          String?,
          String?,
          String?,
        ) -> Unit,
        sdkId: String,
        accessLogString: String,
        delegatesString: String,
      ) {
        val accessLog = fullLanguageInteropJson.decodeFromString(
          GroupScoped.serializer(EncryptedAccessLog.serializer()),
          accessLogString
        )
        val delegates = fullLanguageInteropJson.decodeFromString(
          MapAsArraySerializer(EntityReferenceInGroup.serializer(),
              AccessLogShareOptions.serializer()),
          delegatesString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(EncryptedAccessLog.serializer())) {
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.encrypted.shareWithMany(
            accessLog,
            delegates,
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
          FilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
          filterString
        )
        ApiScope.execute(
          dartResultCallback,
          String.serializer()) {
          val richResult =
              NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.encrypted.filterAccessLogsBy(
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
          SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
          filterString
        )
        ApiScope.execute(
          dartResultCallback,
          String.serializer()) {
          val richResult =
              NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.encrypted.filterAccessLogsBySorted(
            groupId,
            filter,
          )
          NativeReferences.create(PaginatedListIteratorWithSerializer(
            richResult,
            GroupScoped.serializer(EncryptedAccessLog.serializer())
          ))
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
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.encrypted.createAccessLog(
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
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.encrypted.modifyAccessLog(
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
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.encrypted.getAccessLog(
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
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.encrypted.getAccessLogs(
            groupId,
            entityIds,
          )
        }
      }
    }

    @OptIn(InternalIcureApi::class)
    public object tryAndRecover {
      public fun shareWith(
        dartResultCallback: (
          String?,
          String?,
          String?,
          String?,
        ) -> Unit,
        sdkId: String,
        delegateString: String,
        accessLogString: String,
        optionsString: String,
      ) {
        val delegate = fullLanguageInteropJson.decodeFromString(
          EntityReferenceInGroup.serializer(),
          delegateString
        )
        val accessLog = fullLanguageInteropJson.decodeFromString(
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)),
          accessLogString
        )
        val options = fullLanguageInteropJson.decodeFromString(
          AccessLogShareOptions.serializer().nullable,
          optionsString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class))) {
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryAndRecover.shareWith(
            delegate,
            accessLog,
            options,
          )
        }
      }

      public fun shareWithMany(
        dartResultCallback: (
          String?,
          String?,
          String?,
          String?,
        ) -> Unit,
        sdkId: String,
        accessLogString: String,
        delegatesString: String,
      ) {
        val accessLog = fullLanguageInteropJson.decodeFromString(
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)),
          accessLogString
        )
        val delegates = fullLanguageInteropJson.decodeFromString(
          MapAsArraySerializer(EntityReferenceInGroup.serializer(),
              AccessLogShareOptions.serializer()),
          delegatesString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class))) {
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryAndRecover.shareWithMany(
            accessLog,
            delegates,
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
          FilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
          filterString
        )
        ApiScope.execute(
          dartResultCallback,
          String.serializer()) {
          val richResult =
              NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryAndRecover.filterAccessLogsBy(
            groupId,
            filter,
          )
          NativeReferences.create(PaginatedListIteratorWithSerializer(
            richResult,
            GroupScoped.serializer(PolymorphicSerializer(AccessLog::class))
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
          SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)),
          filterString
        )
        ApiScope.execute(
          dartResultCallback,
          String.serializer()) {
          val richResult =
              NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryAndRecover.filterAccessLogsBySorted(
            groupId,
            filter,
          )
          NativeReferences.create(PaginatedListIteratorWithSerializer(
            richResult,
            GroupScoped.serializer(PolymorphicSerializer(AccessLog::class))
          ))
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
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)),
          entityString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class))) {
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryAndRecover.createAccessLog(
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
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)),
          entityString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class))) {
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryAndRecover.modifyAccessLog(
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
          GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)).nullable) {
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryAndRecover.getAccessLog(
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
          ListSerializer(GroupScoped.serializer(PolymorphicSerializer(AccessLog::class)))) {
          NativeReferences.get<CardinalApis>(sdkId).accessLog.inGroup.tryAndRecover.getAccessLogs(
            groupId,
            entityIds,
          )
        }
      }
    }
  }
}
