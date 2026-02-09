// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object CalendarItemBasicApi {
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
      BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.matchCalendarItemsBy(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.matchCalendarItemsBySorted(
        filter,
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
      BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.filterCalendarItemsBy(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.filterCalendarItemsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedCalendarItem.serializer()
      ))
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.deleteCalendarItemById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.deleteCalendarItemsByIds(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.purgeCalendarItemById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.deleteCalendarItem(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.deleteCalendarItems(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.purgeCalendarItem(
        calendarItem,
      )
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.createCalendarItem(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.bookCalendarItemCheckingAvailability(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.undeleteCalendarItemById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.undeleteCalendarItem(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.modifyCalendarItem(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.getCalendarItem(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.getCalendarItems(
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
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.subscribeToEvents(
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
  public object inGroup {
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
        BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.matchCalendarItemsBy(
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
        BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.matchCalendarItemsBySorted(
          groupId,
          filter,
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
        BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.filterCalendarItemsBy(
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
        BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.filterCalendarItemsBySorted(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(EncryptedCalendarItem.serializer())
        ))
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
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.deleteCalendarItemById(
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
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.deleteCalendarItemsByIds(
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
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.deleteCalendarItem(
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
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.deleteCalendarItems(
          calendarItems,
        )
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
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.createCalendarItem(
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
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.modifyCalendarItem(
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
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.getCalendarItem(
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
        NativeReferences.get<CardinalBaseApis>(sdkId).calendarItem.inGroup.getCalendarItems(
          groupId,
          entityIds,
        )
      }
    }
  }
}
