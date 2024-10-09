// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.EncryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogBasicApi")
public external interface AccessLogBasicApiJs {
	public fun matchAccessLogsBy(filter: BaseFilterOptionsJs<AccessLogJs>): Promise<Array<String>>

	public fun matchAccessLogsBySorted(filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<Array<String>>

	public fun filterAccessLogsBy(filter: BaseFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>>

	public fun filterAccessLogsBySorted(filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>>

	public fun deleteAccessLogUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteAccessLogsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteAccessLogById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteAccessLogsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeAccessLogById(id: String, rev: String): Promise<Unit>

	public fun deleteAccessLog(accessLog: AccessLogJs): Promise<DocIdentifierJs>

	public fun deleteAccessLogs(accessLogs: Array<AccessLogJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeAccessLog(accessLog: AccessLogJs): Promise<Unit>

	public fun undeleteAccessLogById(id: String, rev: String): Promise<EncryptedAccessLogJs>

	public fun undeleteAccessLog(accessLog: AccessLogJs): Promise<EncryptedAccessLogJs>

	public fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs>

	public fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs>

	public fun getAccessLogs(entityIds: Array<String>): Promise<Array<EncryptedAccessLogJs>>

	public fun findAccessLogsBy(
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedAccessLogJs>>

	public fun findAccessLogsByUserAfterDate(userId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedAccessLogJs>>

	public fun findAccessLogsInGroup(groupId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedAccessLogJs>>
}
