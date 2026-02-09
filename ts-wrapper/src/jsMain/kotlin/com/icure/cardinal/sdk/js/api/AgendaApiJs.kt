// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AgendaJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AgendaApi")
public external interface AgendaApiJs {
	public val inGroup: AgendaInGroupApiJs

	public fun createAgenda(agenda: AgendaJs): Promise<AgendaJs>

	public fun createAgendas(agendas: Array<AgendaJs>): Promise<Array<AgendaJs>>

	public fun deleteAgendaById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteAgendasByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeAgendaById(id: String, rev: String): Promise<Unit>

	public fun purgeAgendasByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteAgendaById(id: String, rev: String): Promise<AgendaJs>

	public fun undeleteAgendasByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<AgendaJs>>

	public fun deleteAgenda(agenda: AgendaJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteAgendas(agendas: Array<AgendaJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeAgenda(agenda: AgendaJs): Promise<Unit>

	public fun purgeAgendas(agendas: Array<AgendaJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteAgenda(agenda: AgendaJs): Promise<AgendaJs>

	public fun undeleteAgendas(agendas: Array<AgendaJs>): Promise<Array<AgendaJs>>

	public fun getAgenda(agendaId: String): Promise<AgendaJs?>

	public fun getAgendas(agendaIds: Array<String>): Promise<Array<AgendaJs>>

	public fun modifyAgenda(agenda: AgendaJs): Promise<AgendaJs>

	public fun modifyAgendas(agendas: Array<AgendaJs>): Promise<Array<AgendaJs>>

	public fun matchAgendasBy(filter: BaseFilterOptionsJs<AgendaJs>): Promise<Array<String>>

	public fun matchAgendasBySorted(filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<Array<String>>

	public fun filterAgendasBy(filter: BaseFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<AgendaJs>>

	public fun filterAgendasBySorted(filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<AgendaJs>>
}
