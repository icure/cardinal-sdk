// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.EncryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogBasicApi")
public external interface AccessLogBasicApiJs {
	public val inGroup: AccessLogBasicInGroupApiJs

	public fun matchAccessLogsBy(filter: BaseFilterOptionsJs<AccessLogJs>): Promise<Array<String>>

	public fun matchAccessLogsBySorted(filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<Array<String>>

	public fun filterAccessLogsBy(filter: BaseFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>>

	public fun filterAccessLogsBySorted(filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>>

	public fun deleteAccessLogById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeAccessLogById(id: String, rev: String): Promise<Unit>

	public fun purgeAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteAccessLog(accessLog: AccessLogJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteAccessLogs(accessLogs: Array<AccessLogJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeAccessLog(accessLog: AccessLogJs): Promise<Unit>

	public fun purgeAccessLogs(accessLogs: Array<AccessLogJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun createAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs>

	public fun createAccessLogs(entities: Array<EncryptedAccessLogJs>):
			Promise<Array<EncryptedAccessLogJs>>

	public fun undeleteAccessLogById(id: String, rev: String): Promise<EncryptedAccessLogJs>

	public fun undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedAccessLogJs>>

	public fun undeleteAccessLog(accessLog: AccessLogJs): Promise<EncryptedAccessLogJs>

	public fun undeleteAccessLogs(accessLogs: Array<AccessLogJs>): Promise<Array<EncryptedAccessLogJs>>

	public fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs>

	public fun modifyAccessLogs(entities: Array<EncryptedAccessLogJs>):
			Promise<Array<EncryptedAccessLogJs>>

	public fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs?>

	public fun getAccessLogs(entityIds: Array<String>): Promise<Array<EncryptedAccessLogJs>>
}
