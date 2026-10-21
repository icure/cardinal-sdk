// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.MaintenanceTaskBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.MaintenanceTaskBasicApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.MaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.maintenanceTask_fromJs
import com.icure.cardinal.sdk.js.model.maintenanceTask_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
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
internal class MaintenanceTaskBasicApiImplJs(
	private val maintenanceTaskBasicApi: MaintenanceTaskBasicApi,
) : MaintenanceTaskBasicApiJs {
	override fun matchMaintenanceTasksBy(filter: BaseFilterOptionsJs<MaintenanceTaskJs>): Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<MaintenanceTask> = baseFilterOptions_fromJs(filter)
		val result = maintenanceTaskBasicApi.matchMaintenanceTasksBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptionsJs<MaintenanceTaskJs>): Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<MaintenanceTask> = baseSortableFilterOptions_fromJs(filter)
		val result = maintenanceTaskBasicApi.matchMaintenanceTasksBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterMaintenanceTasksBy(filter: BaseFilterOptionsJs<MaintenanceTaskJs>): Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<MaintenanceTask> = baseFilterOptions_fromJs(filter)
		val result = maintenanceTaskBasicApi.filterMaintenanceTasksBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptionsJs<MaintenanceTaskJs>): Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<MaintenanceTask> = baseSortableFilterOptions_fromJs(filter)
		val result = maintenanceTaskBasicApi.filterMaintenanceTasksBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun deleteMaintenanceTaskUnsafe(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = maintenanceTaskBasicApi.deleteMaintenanceTaskUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMaintenanceTasksUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = maintenanceTaskBasicApi.deleteMaintenanceTasksUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteMaintenanceTaskById(entityId: String, rev: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = maintenanceTaskBasicApi.deleteMaintenanceTaskById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMaintenanceTasksByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = maintenanceTaskBasicApi.deleteMaintenanceTasksByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeMaintenanceTaskById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		maintenanceTaskBasicApi.purgeMaintenanceTaskById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskBasicApi.deleteMaintenanceTask(
			maintenanceTaskConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMaintenanceTasks(maintenanceTasks: Array<MaintenanceTaskJs>): Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val maintenanceTasksConverted: List<MaintenanceTask> = arrayToList(
			maintenanceTasks,
			"maintenanceTasks",
			{ x1: MaintenanceTaskJs ->
				maintenanceTask_fromJs(x1)
			},
		)
		val result = maintenanceTaskBasicApi.deleteMaintenanceTasks(
			maintenanceTasksConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<Unit> = GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		maintenanceTaskBasicApi.purgeMaintenanceTask(
			maintenanceTaskConverted,
		)

	}

	override fun createMaintenanceTask(entity: EncryptedMaintenanceTaskJs): Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
		val entityConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(entity)
		val result = maintenanceTaskBasicApi.createMaintenanceTask(
			entityConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun undeleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<MaintenanceTaskJs> = GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskBasicApi.undeleteMaintenanceTask(
			maintenanceTaskConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun undeleteMaintenanceTaskById(id: String, rev: String): Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = maintenanceTaskBasicApi.undeleteMaintenanceTaskById(
			idConverted,
			revConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs): Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
		val entityConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(entity)
		val result = maintenanceTaskBasicApi.modifyMaintenanceTask(
			entityConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = maintenanceTaskBasicApi.getMaintenanceTask(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				maintenanceTask_toJs(nonNull1)
			}
		)
	}

	override fun getMaintenanceTasks(entityIds: Array<String>): Promise<Array<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = maintenanceTaskBasicApi.getMaintenanceTasks(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<MaintenanceTaskJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMaintenanceTaskJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<MaintenanceTask> = baseFilterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? = convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = maintenanceTaskBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}
}
