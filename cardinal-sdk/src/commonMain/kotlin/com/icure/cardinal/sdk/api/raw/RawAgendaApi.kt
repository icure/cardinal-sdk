package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAgendaApi {
	// region common endpoints

	suspend fun getAgendas(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Agenda>>

	suspend fun createAgenda(agendaDto: Agenda): HttpResponse<Agenda>

	suspend fun createAgendas(agendasDto: List<Agenda>): HttpResponse<List<Agenda>>

	suspend fun deleteAgendas(agendaIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAgendasWithRev(agendaIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAgenda(
		agendaId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteAgenda(
		agendaId: String,
		rev: String,
	): HttpResponse<Agenda>

	suspend fun undeleteAgendas(agendaIds: ListOfIdsAndRev): HttpResponse<List<Agenda>>

	suspend fun purgeAgenda(
		agendaId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeAgendas(agendaIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun getAgenda(agendaId: String): HttpResponse<Agenda>

	suspend fun getAgendasForUser(userId: String): HttpResponse<Agenda>

	suspend fun modifyAgenda(agendaDto: Agenda): HttpResponse<Agenda>

	suspend fun modifyAgendas(agendaDtos: List<Agenda>): HttpResponse<List<Agenda>>

	suspend fun matchAgendasBy(filter: AbstractFilter<Agenda>): HttpResponse<List<String>>

	suspend fun getAgendasByIds(agendaIds: ListOfIds): HttpResponse<List<Agenda>>
	// endregion

	// region cloud endpoints

	suspend fun createAgendaInGroup(
		groupId: String,
		agendaDto: Agenda,
	): HttpResponse<Agenda>

	suspend fun createAgendasInGroup(
		groupId: String,
		agendaDtos: List<Agenda>,
	): HttpResponse<List<Agenda>>

	suspend fun modifyAgendaInGroup(
		groupId: String,
		agendaDto: Agenda,
	): HttpResponse<Agenda>

	suspend fun modifyAgendasInGroup(
		groupId: String,
		agendaDtos: List<Agenda>,
	): HttpResponse<List<Agenda>>

	suspend fun getAgendaInGroup(
		groupId: String,
		agendaId: String,
	): HttpResponse<Agenda>

	suspend fun getAgendasInGroup(
		groupId: String,
		agendaIds: ListOfIds,
	): HttpResponse<List<Agenda>>

	suspend fun deleteAgendasInGroup(
		groupId: String,
		agendaIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAgendaInGroup(
		groupId: String,
		agendaId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteAgendasInGroup(
		groupId: String,
		agendaIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<Agenda>>

	suspend fun undeleteAgendaInGroup(
		groupId: String,
		agendaId: String,
		rev: String,
	): HttpResponse<Agenda>

	suspend fun purgeAgendasInGroup(
		groupId: String,
		agendaIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun purgeAgendaInGroup(
		groupId: String,
		agendaId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun matchAgendasInGroupBy(
		filter: AbstractFilter<Agenda>,
		groupId: String,
	): HttpResponse<List<String>>
	// endregion
}
