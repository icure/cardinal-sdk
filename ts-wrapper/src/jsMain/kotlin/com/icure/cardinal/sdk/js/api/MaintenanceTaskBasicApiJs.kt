// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.MaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MaintenanceTaskBasicApi")
public external interface MaintenanceTaskBasicApiJs {
	public fun matchMaintenanceTasksBy(filter: BaseFilterOptionsJs<MaintenanceTaskJs>): Promise<Array<String>>

	public fun matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptionsJs<MaintenanceTaskJs>): Promise<Array<String>>

	public fun filterMaintenanceTasksBy(filter: BaseFilterOptionsJs<MaintenanceTaskJs>): Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>>

	public fun filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptionsJs<MaintenanceTaskJs>): Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>>

	public fun deleteMaintenanceTaskUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasksUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteMaintenanceTaskById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasksByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeMaintenanceTaskById(id: String, rev: String): Promise<Unit>

	public fun deleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasks(maintenanceTasks: Array<MaintenanceTaskJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<Unit>

	public fun createMaintenanceTask(entity: EncryptedMaintenanceTaskJs): Promise<EncryptedMaintenanceTaskJs>

	public fun undeleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<MaintenanceTaskJs>

	public fun undeleteMaintenanceTaskById(id: String, rev: String): Promise<EncryptedMaintenanceTaskJs>

	public fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs): Promise<EncryptedMaintenanceTaskJs>

	public fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs?>

	public fun getMaintenanceTasks(entityIds: Array<String>): Promise<Array<EncryptedMaintenanceTaskJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<MaintenanceTaskJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMaintenanceTaskJs>>
}
