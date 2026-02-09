// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
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
public object MaintenanceTaskApi {
  public fun withEncryptionMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTaskString: String,
    userString: String,
    delegatesString: String,
    alternateRootDelegateIdString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      DecryptedMaintenanceTask.serializer().nullable,
      maintenanceTaskString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer().nullable,
      userString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), AccessLevel.serializer()),
      delegatesString
    )
    val alternateRootDelegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      alternateRootDelegateIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.withEncryptionMetadata(
        maintenanceTask,
        user,
        delegates,
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
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.getEncryptionKeysOf(
        maintenanceTask,
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
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.hasWriteAccess(
        maintenanceTask,
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
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.decryptPatientIdOf(
        maintenanceTask,
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
      PolymorphicSerializer(MaintenanceTask::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.createDelegationDeAnonymizationMetadata(
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
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      EncryptedMaintenanceTask.serializer(),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.decrypt(
        maintenanceTask,
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
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      EncryptedMaintenanceTask.serializer(),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(MaintenanceTask::class)) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryDecrypt(
        maintenanceTask,
      )
    }
  }

  public fun matchMaintenanceTasksBy(
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
      FilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.matchMaintenanceTasksBy(
        filter,
      )
    }
  }

  public fun matchMaintenanceTasksBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.matchMaintenanceTasksBySorted(
        filter,
      )
    }
  }

  public fun deleteMaintenanceTaskById(
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
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.deleteMaintenanceTaskById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteMaintenanceTasksByIds(
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
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.deleteMaintenanceTasksByIds(
        entityIds,
      )
    }
  }

  public fun purgeMaintenanceTaskById(
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
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.purgeMaintenanceTaskById(
        id,
        rev,
      )
    }
  }

  public fun deleteMaintenanceTask(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.deleteMaintenanceTask(
        maintenanceTask,
      )
    }
  }

  public fun deleteMaintenanceTasks(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTasksString: String,
  ) {
    val maintenanceTasks = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(MaintenanceTask::class)),
      maintenanceTasksString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.deleteMaintenanceTasks(
        maintenanceTasks,
      )
    }
  }

  public fun purgeMaintenanceTask(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.purgeMaintenanceTask(
        maintenanceTask,
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
    maintenanceTaskString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      DecryptedMaintenanceTask.serializer(),
      maintenanceTaskString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      MaintenanceTaskShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.shareWith(
        delegateId,
        maintenanceTask,
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
    maintenanceTaskString: String,
    delegatesString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      DecryptedMaintenanceTask.serializer(),
      maintenanceTaskString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), MaintenanceTaskShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.shareWithMany(
        maintenanceTask,
        delegates,
      )
    }
  }

  public fun filterMaintenanceTasksBy(
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
      FilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.filterMaintenanceTasksBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedMaintenanceTask.serializer()
      ))
    }
  }

  public fun filterMaintenanceTasksBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.filterMaintenanceTasksBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedMaintenanceTask.serializer()
      ))
    }
  }

  public fun createMaintenanceTask(
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
      DecryptedMaintenanceTask.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.createMaintenanceTask(
        entity,
      )
    }
  }

  public fun undeleteMaintenanceTask(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(MaintenanceTask::class)) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.undeleteMaintenanceTask(
        maintenanceTask,
      )
    }
  }

  public fun undeleteMaintenanceTaskById(
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
      DecryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.undeleteMaintenanceTaskById(
        id,
        rev,
      )
    }
  }

  public fun modifyMaintenanceTask(
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
      DecryptedMaintenanceTask.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.modifyMaintenanceTask(
        entity,
      )
    }
  }

  public fun getMaintenanceTask(
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
      DecryptedMaintenanceTask.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.getMaintenanceTask(
        entityId,
      )
    }
  }

  public fun getMaintenanceTasks(
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
      ListSerializer(DecryptedMaintenanceTask.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.getMaintenanceTasks(
        entityIds,
      )
    }
  }

  public fun subscribeToEvents(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    eventsString: String,
    filterString: String,
    subscriptionConfigString: String,
  ) {
    val events = fullLanguageInteropJson.decodeFromString(
      SetSerializer(SubscriptionEventType.serializer()),
      eventsString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedMaintenanceTask.serializer()
      ))
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
      maintenanceTaskString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val maintenanceTask = fullLanguageInteropJson.decodeFromString(
        EncryptedMaintenanceTask.serializer(),
        maintenanceTaskString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        MaintenanceTaskShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMaintenanceTask.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.shareWith(
          delegateId,
          maintenanceTask,
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
      maintenanceTaskString: String,
      delegatesString: String,
    ) {
      val maintenanceTask = fullLanguageInteropJson.decodeFromString(
        EncryptedMaintenanceTask.serializer(),
        maintenanceTaskString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), MaintenanceTaskShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMaintenanceTask.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.shareWithMany(
          maintenanceTask,
          delegates,
        )
      }
    }

    public fun filterMaintenanceTasksBy(
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
        FilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.filterMaintenanceTasksBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedMaintenanceTask.serializer()
        ))
      }
    }

    public fun filterMaintenanceTasksBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.filterMaintenanceTasksBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedMaintenanceTask.serializer()
        ))
      }
    }

    public fun createMaintenanceTask(
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
        EncryptedMaintenanceTask.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMaintenanceTask.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.createMaintenanceTask(
          entity,
        )
      }
    }

    public fun undeleteMaintenanceTask(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      maintenanceTaskString: String,
    ) {
      val maintenanceTask = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(MaintenanceTask::class),
        maintenanceTaskString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(MaintenanceTask::class)) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.undeleteMaintenanceTask(
          maintenanceTask,
        )
      }
    }

    public fun undeleteMaintenanceTaskById(
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
        EncryptedMaintenanceTask.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.undeleteMaintenanceTaskById(
          id,
          rev,
        )
      }
    }

    public fun modifyMaintenanceTask(
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
        EncryptedMaintenanceTask.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMaintenanceTask.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.modifyMaintenanceTask(
          entity,
        )
      }
    }

    public fun getMaintenanceTask(
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
        EncryptedMaintenanceTask.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.getMaintenanceTask(
          entityId,
        )
      }
    }

    public fun getMaintenanceTasks(
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
        ListSerializer(EncryptedMaintenanceTask.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.encrypted.getMaintenanceTasks(
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
      maintenanceTaskString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val maintenanceTask = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(MaintenanceTask::class),
        maintenanceTaskString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        MaintenanceTaskShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(MaintenanceTask::class)) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.shareWith(
          delegateId,
          maintenanceTask,
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
      maintenanceTaskString: String,
      delegatesString: String,
    ) {
      val maintenanceTask = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(MaintenanceTask::class),
        maintenanceTaskString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), MaintenanceTaskShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(MaintenanceTask::class)) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.shareWithMany(
          maintenanceTask,
          delegates,
        )
      }
    }

    public fun filterMaintenanceTasksBy(
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
        FilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.filterMaintenanceTasksBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(MaintenanceTask::class)
        ))
      }
    }

    public fun filterMaintenanceTasksBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.filterMaintenanceTasksBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(MaintenanceTask::class)
        ))
      }
    }

    public fun createMaintenanceTask(
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
        PolymorphicSerializer(MaintenanceTask::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(MaintenanceTask::class)) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.createMaintenanceTask(
          entity,
        )
      }
    }

    public fun undeleteMaintenanceTask(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      maintenanceTaskString: String,
    ) {
      val maintenanceTask = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(MaintenanceTask::class),
        maintenanceTaskString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(MaintenanceTask::class)) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.undeleteMaintenanceTask(
          maintenanceTask,
        )
      }
    }

    public fun undeleteMaintenanceTaskById(
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
        PolymorphicSerializer(MaintenanceTask::class)) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.undeleteMaintenanceTaskById(
          id,
          rev,
        )
      }
    }

    public fun modifyMaintenanceTask(
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
        PolymorphicSerializer(MaintenanceTask::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(MaintenanceTask::class)) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.modifyMaintenanceTask(
          entity,
        )
      }
    }

    public fun getMaintenanceTask(
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
        PolymorphicSerializer(MaintenanceTask::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.getMaintenanceTask(
          entityId,
        )
      }
    }

    public fun getMaintenanceTasks(
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
        ListSerializer(PolymorphicSerializer(MaintenanceTask::class))) {
        NativeReferences.get<CardinalApis>(sdkId).maintenanceTask.tryAndRecover.getMaintenanceTasks(
          entityIds,
        )
      }
    }
  }
}
