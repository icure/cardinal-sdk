// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.EncryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogBasicInGroupApi")
public external interface AccessLogBasicInGroupApiJs {
	public fun matchAccessLogsBy(groupId: String, filter: BaseFilterOptionsJs<AccessLogJs>):
			Promise<Array<String>>

	public fun matchAccessLogsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<AccessLogJs>): Promise<Array<String>>

	public fun filterAccessLogsBy(groupId: String, filter: BaseFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedAccessLogJs>>>

	public fun filterAccessLogsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedAccessLogJs>>>

	public fun deleteAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteAccessLog(accessLog: GroupScopedJs<AccessLogJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeAccessLog(accessLog: GroupScopedJs<AccessLogJs>): Promise<Unit>

	public fun purgeAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createAccessLog(entity: GroupScopedJs<EncryptedAccessLogJs>):
			Promise<GroupScopedJs<EncryptedAccessLogJs>>

	public fun createAccessLogs(entities: Array<GroupScopedJs<EncryptedAccessLogJs>>):
			Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>>

	public fun undeleteAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedAccessLogJs>>

	public fun undeleteAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>>

	public fun undeleteAccessLog(accessLog: GroupScopedJs<AccessLogJs>):
			Promise<GroupScopedJs<EncryptedAccessLogJs>>

	public fun undeleteAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
			Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>>

	public fun modifyAccessLog(entity: GroupScopedJs<EncryptedAccessLogJs>):
			Promise<GroupScopedJs<EncryptedAccessLogJs>>

	public fun modifyAccessLogs(entities: Array<GroupScopedJs<EncryptedAccessLogJs>>):
			Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>>

	public fun getAccessLog(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedAccessLogJs>?>

	public fun getAccessLogs(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>>
}
