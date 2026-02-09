// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AgendaJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AgendaInGroupApi")
public external interface AgendaInGroupApiJs {
	public fun getAgenda(groupId: String, entityId: String): Promise<GroupScopedJs<AgendaJs>?>

	public fun getAgendas(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<AgendaJs>>>

	public fun createAgenda(entity: GroupScopedJs<AgendaJs>): Promise<GroupScopedJs<AgendaJs>>

	public fun createAgendas(entities: Array<GroupScopedJs<AgendaJs>>):
			Promise<Array<GroupScopedJs<AgendaJs>>>

	public fun modifyAgenda(entity: GroupScopedJs<AgendaJs>): Promise<GroupScopedJs<AgendaJs>>

	public fun modifyAgendas(entities: Array<GroupScopedJs<AgendaJs>>):
			Promise<Array<GroupScopedJs<AgendaJs>>>

	public fun deleteAgendasByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteAgendaById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteAgendas(agendas: Array<GroupScopedJs<AgendaJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteAgenda(agenda: GroupScopedJs<AgendaJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun undeleteAgendasByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<AgendaJs>>>

	public fun undeleteAgendaById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<AgendaJs>>

	public fun undeleteAgendas(agendas: Array<GroupScopedJs<AgendaJs>>):
			Promise<Array<GroupScopedJs<AgendaJs>>>

	public fun undeleteAgenda(agenda: GroupScopedJs<AgendaJs>): Promise<GroupScopedJs<AgendaJs>>

	public fun purgeAgendasByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeAgendaById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeAgendas(agendas: Array<GroupScopedJs<AgendaJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeAgenda(agenda: GroupScopedJs<AgendaJs>): Promise<Unit>

	public fun matchAgendasBy(groupId: String, filter: BaseFilterOptionsJs<AgendaJs>):
			Promise<Array<String>>

	public fun matchAgendasBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<Array<String>>

	public fun filterAgendasBy(groupId: String, filter: BaseFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<AgendaJs>>>

	public fun filterAgendasBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<AgendaJs>>>
}
