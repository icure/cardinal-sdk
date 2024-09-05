// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.MaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MaintenanceTaskApi")
public external interface MaintenanceTaskApiJs {
	public val encrypted: MaintenanceTaskFlavouredApiJs<EncryptedMaintenanceTaskJs>

	public val tryAndRecover: MaintenanceTaskFlavouredApiJs<MaintenanceTaskJs>

	public fun createMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs>

	public fun withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTaskJs?, options: dynamic):
			Promise<DecryptedMaintenanceTaskJs>

	public fun getEncryptionKeysOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>>

	public fun hasWriteAccess(maintenanceTask: MaintenanceTaskJs): Promise<Boolean>

	public fun decryptPatientIdOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTaskJs,
			delegates: Array<String>): Promise<Unit>

	public fun decrypt(maintenanceTask: EncryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs>

	public fun tryDecrypt(maintenanceTask: EncryptedMaintenanceTaskJs): Promise<MaintenanceTaskJs>

	public fun matchMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>>

	public fun matchMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>>

	public fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		maintenanceTask: DecryptedMaintenanceTaskJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>>

	public fun tryShareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>>

	public fun shareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<DecryptedMaintenanceTaskJs>

	public fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<DecryptedMaintenanceTaskJs>>

	public fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<DecryptedMaintenanceTaskJs>>

	public fun modifyMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs>

	public fun getMaintenanceTask(entityId: String): Promise<DecryptedMaintenanceTaskJs>

	public fun getMaintenanceTasks(entityIds: Array<String>):
			Promise<Array<DecryptedMaintenanceTaskJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<MaintenanceTaskJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMaintenanceTaskJs>>
}
