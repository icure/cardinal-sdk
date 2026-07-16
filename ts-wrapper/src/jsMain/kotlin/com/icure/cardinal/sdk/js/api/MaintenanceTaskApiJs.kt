// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.MaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
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

	public fun withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTaskJs?, options: dynamic):
			Promise<DecryptedMaintenanceTaskJs>

	public fun getEncryptionKeysOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>>

	public fun hasWriteAccess(maintenanceTask: MaintenanceTaskJs): Promise<Boolean>

	public fun decryptPatientIdOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTaskJs,
			delegates: Array<String>): Promise<Unit>

	public fun decrypt(maintenanceTasks: Array<EncryptedMaintenanceTaskJs>):
			Promise<Array<DecryptedMaintenanceTaskJs>>

	public fun tryDecrypt(maintenanceTasks: Array<EncryptedMaintenanceTaskJs>):
			Promise<Array<MaintenanceTaskJs>>

	public fun matchMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>>

	public fun matchMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>>

	public fun deleteMaintenanceTaskUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasksUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteMaintenanceTaskById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasksByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeMaintenanceTaskById(id: String, rev: String): Promise<Unit>

	public fun deleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasks(maintenanceTasks: Array<MaintenanceTaskJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<Unit>

	public fun shareWith(
		delegateId: String,
		maintenanceTask: DecryptedMaintenanceTaskJs,
		options: dynamic,
	): Promise<DecryptedMaintenanceTaskJs>

	public fun shareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<DecryptedMaintenanceTaskJs>

	public fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<DecryptedMaintenanceTaskJs>>

	public fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<DecryptedMaintenanceTaskJs>>

	public fun createMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs>

	public fun undeleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<MaintenanceTaskJs>

	public fun undeleteMaintenanceTaskById(id: String, rev: String):
			Promise<DecryptedMaintenanceTaskJs>

	public fun modifyMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs>

	public fun getMaintenanceTask(entityId: String): Promise<DecryptedMaintenanceTaskJs?>

	public fun getMaintenanceTasks(entityIds: Array<String>):
			Promise<Array<DecryptedMaintenanceTaskJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<MaintenanceTaskJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMaintenanceTaskJs>>
}
