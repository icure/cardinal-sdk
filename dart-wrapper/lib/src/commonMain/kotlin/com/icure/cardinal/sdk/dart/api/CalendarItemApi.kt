// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.MapAsArraySerializer
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
public object CalendarItemApi {
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
      DecryptedCalendarItem.serializer().nullable,
      baseString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class).nullable,
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
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.withEncryptionMetadata(
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
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.getEncryptionKeysOf(
        calendarItem,
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
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.hasWriteAccess(
        calendarItem,
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
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(EntityReferenceInGroup.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.decryptPatientIdOf(
        calendarItem,
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
      PolymorphicSerializer(CalendarItem::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.createDelegationDeAnonymizationMetadata(
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
    calendarItemsString: String,
  ) {
    val calendarItems = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedCalendarItem.serializer()),
      calendarItemsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedCalendarItem.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.decrypt(
        calendarItems,
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
    calendarItemsString: String,
  ) {
    val calendarItems = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedCalendarItem.serializer()),
      calendarItemsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(PolymorphicSerializer(CalendarItem::class))) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryDecrypt(
        calendarItems,
      )
    }
  }

  public fun encryptOrValidate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemsString: String,
  ) {
    val calendarItems = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(CalendarItem::class)),
      calendarItemsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedCalendarItem.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.encryptOrValidate(
        calendarItems,
      )
    }
  }

  public fun matchCalendarItemsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.matchCalendarItemsBy(
        filter,
      )
    }
  }

  public fun matchCalendarItemsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.matchCalendarItemsBySorted(
        filter,
      )
    }
  }

  public fun deleteCalendarItemById(
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
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.deleteCalendarItemById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteCalendarItemsByIds(
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
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.deleteCalendarItemsByIds(
        entityIds,
      )
    }
  }

  public fun purgeCalendarItemById(
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
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.purgeCalendarItemById(
        id,
        rev,
      )
    }
  }

  public fun deleteCalendarItem(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      StoredDocumentIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.deleteCalendarItem(
        calendarItem,
      )
    }
  }

  public fun deleteCalendarItems(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemsString: String,
  ) {
    val calendarItems = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(CalendarItem::class)),
      calendarItemsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(StoredDocumentIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.deleteCalendarItems(
        calendarItems,
      )
    }
  }

  public fun purgeCalendarItem(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.purgeCalendarItem(
        calendarItem,
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
    calendarItemString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      DecryptedCalendarItem.serializer(),
      calendarItemString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      CalendarItemShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.shareWith(
        delegateId,
        calendarItem,
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
    calendarItemString: String,
    delegatesString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      DecryptedCalendarItem.serializer(),
      calendarItemString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), CalendarItemShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.shareWithMany(
        calendarItem,
        delegates,
      )
    }
  }

  public fun linkToPatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
    patientString: String,
    shareLinkWithDelegatesString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    val shareLinkWithDelegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      shareLinkWithDelegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.linkToPatient(
        calendarItem,
        patient,
        shareLinkWithDelegates,
      )
    }
  }

  public fun filterCalendarItemsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).calendarItem.filterCalendarItemsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedCalendarItem.serializer()
      ))
    }
  }

  public fun filterCalendarItemsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.filterCalendarItemsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedCalendarItem.serializer()
      ))
    }
  }

  public fun createCalendarItem(
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
      DecryptedCalendarItem.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.createCalendarItem(
        entity,
      )
    }
  }

  public fun bookCalendarItemCheckingAvailability(
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
      DecryptedCalendarItem.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.bookCalendarItemCheckingAvailability(
        entity,
      )
    }
  }

  public fun undeleteCalendarItemById(
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
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.undeleteCalendarItemById(
        id,
        rev,
      )
    }
  }

  public fun undeleteCalendarItem(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.undeleteCalendarItem(
        calendarItem,
      )
    }
  }

  public fun modifyCalendarItem(
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
      DecryptedCalendarItem.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.modifyCalendarItem(
        entity,
      )
    }
  }

  public fun getCalendarItem(
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
      DecryptedCalendarItem.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.getCalendarItem(
        entityId,
      )
    }
  }

  public fun getCalendarItems(
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
      ListSerializer(DecryptedCalendarItem.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItem.getCalendarItems(
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
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).calendarItem.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedCalendarItem.serializer()
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
      calendarItemString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        EncryptedCalendarItem.serializer(),
        calendarItemString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        CalendarItemShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.shareWith(
          delegateId,
          calendarItem,
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
      calendarItemString: String,
      delegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        EncryptedCalendarItem.serializer(),
        calendarItemString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), CalendarItemShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.shareWithMany(
          calendarItem,
          delegates,
        )
      }
    }

    public fun linkToPatient(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
      patientString: String,
      shareLinkWithDelegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      val patient = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Patient::class),
        patientString
      )
      val shareLinkWithDelegates = fullLanguageInteropJson.decodeFromString(
        SetSerializer(String.serializer()),
        shareLinkWithDelegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.linkToPatient(
          calendarItem,
          patient,
          shareLinkWithDelegates,
        )
      }
    }

    public fun filterCalendarItemsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.filterCalendarItemsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedCalendarItem.serializer()
        ))
      }
    }

    public fun filterCalendarItemsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.filterCalendarItemsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedCalendarItem.serializer()
        ))
      }
    }

    public fun createCalendarItem(
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
        EncryptedCalendarItem.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.createCalendarItem(
          entity,
        )
      }
    }

    public fun bookCalendarItemCheckingAvailability(
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
        EncryptedCalendarItem.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.bookCalendarItemCheckingAvailability(
          entity,
        )
      }
    }

    public fun undeleteCalendarItemById(
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
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.undeleteCalendarItemById(
          id,
          rev,
        )
      }
    }

    public fun undeleteCalendarItem(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.undeleteCalendarItem(
          calendarItem,
        )
      }
    }

    public fun modifyCalendarItem(
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
        EncryptedCalendarItem.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.modifyCalendarItem(
          entity,
        )
      }
    }

    public fun getCalendarItem(
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
        EncryptedCalendarItem.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.getCalendarItem(
          entityId,
        )
      }
    }

    public fun getCalendarItems(
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
        ListSerializer(EncryptedCalendarItem.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.encrypted.getCalendarItems(
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
      calendarItemString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        CalendarItemShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.shareWith(
          delegateId,
          calendarItem,
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
      calendarItemString: String,
      delegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), CalendarItemShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.shareWithMany(
          calendarItem,
          delegates,
        )
      }
    }

    public fun linkToPatient(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
      patientString: String,
      shareLinkWithDelegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      val patient = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Patient::class),
        patientString
      )
      val shareLinkWithDelegates = fullLanguageInteropJson.decodeFromString(
        SetSerializer(String.serializer()),
        shareLinkWithDelegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.linkToPatient(
          calendarItem,
          patient,
          shareLinkWithDelegates,
        )
      }
    }

    public fun filterCalendarItemsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.filterCalendarItemsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(CalendarItem::class)
        ))
      }
    }

    public fun filterCalendarItemsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.filterCalendarItemsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(CalendarItem::class)
        ))
      }
    }

    public fun createCalendarItem(
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
        PolymorphicSerializer(CalendarItem::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.createCalendarItem(
          entity,
        )
      }
    }

    public fun bookCalendarItemCheckingAvailability(
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
        PolymorphicSerializer(CalendarItem::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.bookCalendarItemCheckingAvailability(
          entity,
        )
      }
    }

    public fun undeleteCalendarItemById(
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
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.undeleteCalendarItemById(
          id,
          rev,
        )
      }
    }

    public fun undeleteCalendarItem(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.undeleteCalendarItem(
          calendarItem,
        )
      }
    }

    public fun modifyCalendarItem(
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
        PolymorphicSerializer(CalendarItem::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.modifyCalendarItem(
          entity,
        )
      }
    }

    public fun getCalendarItem(
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
        PolymorphicSerializer(CalendarItem::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.getCalendarItem(
          entityId,
        )
      }
    }

    public fun getCalendarItems(
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
        ListSerializer(PolymorphicSerializer(CalendarItem::class))) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.tryAndRecover.getCalendarItems(
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
        DecryptedCalendarItem.serializer().nullable,
        baseString
      )
      val patient = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(Patient::class)).nullable,
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
        GroupScoped.serializer(DecryptedCalendarItem.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.withEncryptionMetadata(
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
      calendarItemString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
        calendarItemString
      )
      ApiScope.execute(
        dartResultCallback,
        SetSerializer(HexString.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.getEncryptionKeysOf(
          calendarItem,
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
      calendarItemString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
        calendarItemString
      )
      ApiScope.execute(
        dartResultCallback,
        Boolean.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.hasWriteAccess(
          calendarItem,
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
      calendarItemString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
        calendarItemString
      )
      ApiScope.execute(
        dartResultCallback,
        SetSerializer(EntityReferenceInGroup.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.decryptPatientIdOf(
          calendarItem,
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
        GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
        entityString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        SetSerializer(EntityReferenceInGroup.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        Unit.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.createDelegationDeAnonymizationMetadata(
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
      calendarItemsString: String,
    ) {
      val calendarItems = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(EncryptedCalendarItem.serializer())),
        calendarItemsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(DecryptedCalendarItem.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.decrypt(
          calendarItems,
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
      calendarItemsString: String,
    ) {
      val calendarItems = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(EncryptedCalendarItem.serializer())),
        calendarItemsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)))) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryDecrypt(
          calendarItems,
        )
      }
    }

    public fun encryptOrValidate(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemsString: String,
    ) {
      val calendarItems = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))),
        calendarItemsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(EncryptedCalendarItem.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encryptOrValidate(
          calendarItems,
        )
      }
    }

    public fun matchCalendarItemsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.matchCalendarItemsBy(
          groupId,
          filter,
        )
      }
    }

    public fun matchCalendarItemsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.matchCalendarItemsBySorted(
          groupId,
          filter,
        )
      }
    }

    public fun deleteCalendarItemById(
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
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.deleteCalendarItemById(
          entityId,
        )
      }
    }

    public fun deleteCalendarItemsByIds(
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
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.deleteCalendarItemsByIds(
          entityIds,
        )
      }
    }

    public fun deleteCalendarItem(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
        calendarItemString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(StoredDocumentIdentifier.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.deleteCalendarItem(
          calendarItem,
        )
      }
    }

    public fun deleteCalendarItems(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemsString: String,
    ) {
      val calendarItems = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))),
        calendarItemsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.deleteCalendarItems(
          calendarItems,
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
      delegateString: String,
      calendarItemString: String,
      optionsString: String,
    ) {
      val delegate = fullLanguageInteropJson.decodeFromString(
        EntityReferenceInGroup.serializer(),
        delegateString
      )
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(DecryptedCalendarItem.serializer()),
        calendarItemString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        CalendarItemShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(DecryptedCalendarItem.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.shareWith(
          delegate,
          calendarItem,
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
      calendarItemString: String,
      delegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(DecryptedCalendarItem.serializer()),
        calendarItemString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapAsArraySerializer(EntityReferenceInGroup.serializer(),
            CalendarItemShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(DecryptedCalendarItem.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.shareWithMany(
          calendarItem,
          delegates,
        )
      }
    }

    public fun filterCalendarItemsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.filterCalendarItemsBy(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(DecryptedCalendarItem.serializer())
        ))
      }
    }

    public fun filterCalendarItemsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.filterCalendarItemsBySorted(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(DecryptedCalendarItem.serializer())
        ))
      }
    }

    public fun createCalendarItem(
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
        GroupScoped.serializer(DecryptedCalendarItem.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(DecryptedCalendarItem.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.createCalendarItem(
          entity,
        )
      }
    }

    public fun modifyCalendarItem(
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
        GroupScoped.serializer(DecryptedCalendarItem.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(DecryptedCalendarItem.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.modifyCalendarItem(
          entity,
        )
      }
    }

    public fun getCalendarItem(
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
        GroupScoped.serializer(DecryptedCalendarItem.serializer()).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.getCalendarItem(
          groupId,
          entityId,
        )
      }
    }

    public fun getCalendarItems(
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
        ListSerializer(GroupScoped.serializer(DecryptedCalendarItem.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.getCalendarItems(
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
        calendarItemString: String,
        optionsString: String,
      ) {
        val delegate = fullLanguageInteropJson.decodeFromString(
          EntityReferenceInGroup.serializer(),
          delegateString
        )
        val calendarItem = fullLanguageInteropJson.decodeFromString(
          GroupScoped.serializer(EncryptedCalendarItem.serializer()),
          calendarItemString
        )
        val options = fullLanguageInteropJson.decodeFromString(
          CalendarItemShareOptions.serializer().nullable,
          optionsString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(EncryptedCalendarItem.serializer())) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encrypted.shareWith(
            delegate,
            calendarItem,
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
        calendarItemString: String,
        delegatesString: String,
      ) {
        val calendarItem = fullLanguageInteropJson.decodeFromString(
          GroupScoped.serializer(EncryptedCalendarItem.serializer()),
          calendarItemString
        )
        val delegates = fullLanguageInteropJson.decodeFromString(
          MapAsArraySerializer(EntityReferenceInGroup.serializer(),
              CalendarItemShareOptions.serializer()),
          delegatesString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(EncryptedCalendarItem.serializer())) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encrypted.shareWithMany(
            calendarItem,
            delegates,
          )
        }
      }

      public fun filterCalendarItemsBy(
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
          FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
          filterString
        )
        ApiScope.execute(
          dartResultCallback,
          String.serializer()) {
          val richResult =
              NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encrypted.filterCalendarItemsBy(
            groupId,
            filter,
          )
          NativeReferences.create(PaginatedListIteratorWithSerializer(
            richResult,
            GroupScoped.serializer(EncryptedCalendarItem.serializer())
          ))
        }
      }

      public fun filterCalendarItemsBySorted(
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
          SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
          filterString
        )
        ApiScope.execute(
          dartResultCallback,
          String.serializer()) {
          val richResult =
              NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encrypted.filterCalendarItemsBySorted(
            groupId,
            filter,
          )
          NativeReferences.create(PaginatedListIteratorWithSerializer(
            richResult,
            GroupScoped.serializer(EncryptedCalendarItem.serializer())
          ))
        }
      }

      public fun createCalendarItem(
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
          GroupScoped.serializer(EncryptedCalendarItem.serializer()),
          entityString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(EncryptedCalendarItem.serializer())) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encrypted.createCalendarItem(
            entity,
          )
        }
      }

      public fun modifyCalendarItem(
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
          GroupScoped.serializer(EncryptedCalendarItem.serializer()),
          entityString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(EncryptedCalendarItem.serializer())) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encrypted.modifyCalendarItem(
            entity,
          )
        }
      }

      public fun getCalendarItem(
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
          GroupScoped.serializer(EncryptedCalendarItem.serializer()).nullable) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encrypted.getCalendarItem(
            groupId,
            entityId,
          )
        }
      }

      public fun getCalendarItems(
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
          ListSerializer(GroupScoped.serializer(EncryptedCalendarItem.serializer()))) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.encrypted.getCalendarItems(
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
        calendarItemString: String,
        optionsString: String,
      ) {
        val delegate = fullLanguageInteropJson.decodeFromString(
          EntityReferenceInGroup.serializer(),
          delegateString
        )
        val calendarItem = fullLanguageInteropJson.decodeFromString(
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
          calendarItemString
        )
        val options = fullLanguageInteropJson.decodeFromString(
          CalendarItemShareOptions.serializer().nullable,
          optionsString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryAndRecover.shareWith(
            delegate,
            calendarItem,
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
        calendarItemString: String,
        delegatesString: String,
      ) {
        val calendarItem = fullLanguageInteropJson.decodeFromString(
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
          calendarItemString
        )
        val delegates = fullLanguageInteropJson.decodeFromString(
          MapAsArraySerializer(EntityReferenceInGroup.serializer(),
              CalendarItemShareOptions.serializer()),
          delegatesString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryAndRecover.shareWithMany(
            calendarItem,
            delegates,
          )
        }
      }

      public fun filterCalendarItemsBy(
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
          FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
          filterString
        )
        ApiScope.execute(
          dartResultCallback,
          String.serializer()) {
          val richResult =
              NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryAndRecover.filterCalendarItemsBy(
            groupId,
            filter,
          )
          NativeReferences.create(PaginatedListIteratorWithSerializer(
            richResult,
            GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))
          ))
        }
      }

      public fun filterCalendarItemsBySorted(
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
          SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
          filterString
        )
        ApiScope.execute(
          dartResultCallback,
          String.serializer()) {
          val richResult =
              NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryAndRecover.filterCalendarItemsBySorted(
            groupId,
            filter,
          )
          NativeReferences.create(PaginatedListIteratorWithSerializer(
            richResult,
            GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))
          ))
        }
      }

      public fun createCalendarItem(
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
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
          entityString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryAndRecover.createCalendarItem(
            entity,
          )
        }
      }

      public fun modifyCalendarItem(
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
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)),
          entityString
        )
        ApiScope.execute(
          dartResultCallback,
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryAndRecover.modifyCalendarItem(
            entity,
          )
        }
      }

      public fun getCalendarItem(
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
          GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)).nullable) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryAndRecover.getCalendarItem(
            groupId,
            entityId,
          )
        }
      }

      public fun getCalendarItems(
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
          ListSerializer(GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class)))) {
          NativeReferences.get<CardinalApis>(sdkId).calendarItem.inGroup.tryAndRecover.getCalendarItems(
            groupId,
            entityIds,
          )
        }
      }
    }
  }
}
