// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.AccessLogShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogFlavouredApi")
public external interface AccessLogFlavouredApiJs<E : AccessLogJs> {
	public fun shareWith(
		delegateId: String,
		accessLog: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(accessLog: E, delegates: Record<String, AccessLogShareOptionsJs>):
			Promise<E>

	public fun filterAccessLogsBy(filter: FilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterAccessLogsBySorted(filter: SortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createAccessLog(entity: E): Promise<E>

	public fun createAccessLogs(entities: Array<E>): Promise<Array<E>>

	public fun undeleteAccessLogById(id: String, rev: String): Promise<E>

	public fun undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<E>>

	public fun undeleteAccessLog(accessLog: AccessLogJs): Promise<E>

	public fun undeleteAccessLogs(accessLogs: Array<AccessLogJs>): Promise<Array<E>>

	public fun modifyAccessLog(entity: E): Promise<E>

	public fun modifyAccessLogs(entities: Array<E>): Promise<Array<E>>

	public fun getAccessLog(entityId: String): Promise<E?>

	public fun getAccessLogs(entityIds: Array<String>): Promise<Array<E>>
}
