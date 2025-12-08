// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogFlavouredInGroupApi")
public external interface AccessLogFlavouredInGroupApiJs<E : AccessLogJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		accessLog: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(accessLog: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterAccessLogsBy(groupId: String, filter: FilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterAccessLogsBySorted(groupId: String, filter: SortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createAccessLog(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyAccessLog(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun getAccessLog(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getAccessLogs(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<E>>>
}
