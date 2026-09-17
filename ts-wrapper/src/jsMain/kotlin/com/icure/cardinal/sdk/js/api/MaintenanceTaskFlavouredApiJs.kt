// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.MaintenanceTaskJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MaintenanceTaskFlavouredApi")
public external interface MaintenanceTaskFlavouredApiJs<E : MaintenanceTaskJs> {
	public fun shareWith(
		delegateId: String,
		maintenanceTask: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(maintenanceTask: E, delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<E>

	public fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>): Promise<PaginatedListIteratorJs<E>>

	public fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>): Promise<PaginatedListIteratorJs<E>>

	public fun createMaintenanceTask(entity: E): Promise<E>

	public fun undeleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<MaintenanceTaskJs>

	public fun undeleteMaintenanceTaskById(id: String, rev: String): Promise<E>

	public fun modifyMaintenanceTask(entity: E): Promise<E>

	public fun getMaintenanceTask(entityId: String): Promise<E?>

	public fun getMaintenanceTasks(entityIds: Array<String>): Promise<Array<E>>
}
