// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CalendarItemBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.js.api.CalendarItemBasicApiJs
import com.icure.cardinal.sdk.js.api.CalendarItemBasicInGroupApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.calendarItem_fromJs
import com.icure.cardinal.sdk.js.model.calendarItem_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CalendarItemBasicApiImplJs(
	private val calendarItemBasicApi: CalendarItemBasicApi,
) : CalendarItemBasicApiJs {
	override val inGroup: CalendarItemBasicInGroupApiJs = object : CalendarItemBasicInGroupApiJs {
		override fun matchCalendarItemsBy(groupId: String, filter: BaseFilterOptionsJs<CalendarItemJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<CalendarItem> = baseFilterOptions_fromJs(filter)
			val result = calendarItemBasicApi.inGroup.matchCalendarItemsBy(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun matchCalendarItemsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<CalendarItemJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<CalendarItem> =
					baseSortableFilterOptions_fromJs(filter)
			val result = calendarItemBasicApi.inGroup.matchCalendarItemsBySorted(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun filterCalendarItemsBy(groupId: String, filter: BaseFilterOptionsJs<CalendarItemJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedCalendarItemJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<CalendarItem> = baseFilterOptions_fromJs(filter)
			val result = calendarItemBasicApi.inGroup.filterCalendarItemsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedCalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterCalendarItemsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedCalendarItemJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<CalendarItem> =
					baseSortableFilterOptions_fromJs(filter)
			val result = calendarItemBasicApi.inGroup.filterCalendarItemsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedCalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteCalendarItemById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = calendarItemBasicApi.inGroup.deleteCalendarItemById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override
				fun deleteCalendarItemsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemBasicApi.inGroup.deleteCalendarItemsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteCalendarItem(calendarItem: GroupScopedJs<CalendarItemJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val calendarItemConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
				calendarItem,
				{ x1: CalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemBasicApi.inGroup.deleteCalendarItem(
				calendarItemConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteCalendarItems(calendarItems: Array<GroupScopedJs<CalendarItemJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val calendarItemsConverted: List<GroupScoped<CalendarItem>> = arrayToList(
				calendarItems,
				"calendarItems",
				{ x1: GroupScopedJs<CalendarItemJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CalendarItemJs ->
							calendarItem_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemBasicApi.inGroup.deleteCalendarItems(
				calendarItemsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun createCalendarItem(entity: GroupScopedJs<EncryptedCalendarItemJs>):
				Promise<GroupScopedJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedCalendarItem> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedCalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemBasicApi.inGroup.createCalendarItem(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun modifyCalendarItem(entity: GroupScopedJs<EncryptedCalendarItemJs>):
				Promise<GroupScopedJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedCalendarItem> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedCalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemBasicApi.inGroup.modifyCalendarItem(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarItem(groupId: String, entityId: String):
				Promise<GroupScopedJs<EncryptedCalendarItemJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = calendarItemBasicApi.inGroup.getCalendarItem(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedCalendarItem ->
							calendarItem_toJs(x1)
						},
					)
				}
			)
		}

		override fun getCalendarItems(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<EncryptedCalendarItemJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemBasicApi.inGroup.getCalendarItems(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedCalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun matchCalendarItemsBy(filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<CalendarItem> = baseFilterOptions_fromJs(filter)
		val result = calendarItemBasicApi.matchCalendarItemsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<CalendarItem> =
				baseSortableFilterOptions_fromJs(filter)
		val result = calendarItemBasicApi.matchCalendarItemsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterCalendarItemsBy(filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<CalendarItem> = baseFilterOptions_fromJs(filter)
		val result = calendarItemBasicApi.filterCalendarItemsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun filterCalendarItemsBySorted(filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<CalendarItem> =
				baseSortableFilterOptions_fromJs(filter)
		val result = calendarItemBasicApi.filterCalendarItemsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun deleteCalendarItemUnsafe(entityId: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = calendarItemBasicApi.deleteCalendarItemUnsafe(
			entityIdConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCalendarItemsUnsafe(entityIds: Array<String>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemBasicApi.deleteCalendarItemsUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteCalendarItemById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = calendarItemBasicApi.deleteCalendarItemById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = calendarItemBasicApi.deleteCalendarItemsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeCalendarItemById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		calendarItemBasicApi.purgeCalendarItemById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteCalendarItem(calendarItem: CalendarItemJs): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemBasicApi.deleteCalendarItem(
			calendarItemConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCalendarItems(calendarItems: Array<CalendarItemJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val calendarItemsConverted: List<CalendarItem> = arrayToList(
			calendarItems,
			"calendarItems",
			{ x1: CalendarItemJs ->
				calendarItem_fromJs(x1)
			},
		)
		val result = calendarItemBasicApi.deleteCalendarItems(
			calendarItemsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeCalendarItem(calendarItem: CalendarItemJs): Promise<Unit> = GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		calendarItemBasicApi.purgeCalendarItem(
			calendarItemConverted,
		)

	}

	override fun createCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>
			= GlobalScope.promise {
		val entityConverted: EncryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemBasicApi.createCalendarItem(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun bookCalendarItemCheckingAvailability(entity: EncryptedCalendarItemJs):
			Promise<EncryptedCalendarItemJs> = GlobalScope.promise {
		val entityConverted: EncryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemBasicApi.bookCalendarItemCheckingAvailability(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun undeleteCalendarItemById(id: String, rev: String): Promise<EncryptedCalendarItemJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = calendarItemBasicApi.undeleteCalendarItemById(
			idConverted,
			revConverted,
		)
		calendarItem_toJs(result)
	}

	override fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<EncryptedCalendarItemJs> =
			GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemBasicApi.undeleteCalendarItem(
			calendarItemConverted,
		)
		calendarItem_toJs(result)
	}

	override fun modifyCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>
			= GlobalScope.promise {
		val entityConverted: EncryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemBasicApi.modifyCalendarItem(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun getCalendarItem(entityId: String): Promise<EncryptedCalendarItemJs?> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = calendarItemBasicApi.getCalendarItem(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				calendarItem_toJs(nonNull1)
			}
		)
	}

	override fun getCalendarItems(entityIds: Array<String>): Promise<Array<EncryptedCalendarItemJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemBasicApi.getCalendarItems(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val hcPartyIdConverted: String = hcPartyId
		val result = calendarItemBasicApi.getCalendarItemsByPeriodAndHcPartyId(
			startDateConverted,
			endDateConverted,
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val agendaIdConverted: String = agendaId
		val result = calendarItemBasicApi.getCalendarsByPeriodAndAgendaId(
			startDateConverted,
			endDateConverted,
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val recurrenceIdConverted: String = recurrenceId
		val startKeyConverted: String? = undefinedToNull(startKey)
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int = numberToInt(limit, "limit")
		val result = calendarItemBasicApi.findCalendarItemsByRecurrenceId(
			recurrenceIdConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<CalendarItemJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedCalendarItemJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = calendarItemBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}
}
