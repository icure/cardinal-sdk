package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface AgendaApi {

	val inGroup: AgendaInGroupApi

	suspend fun createAgenda(agenda: Agenda): Agenda

	suspend fun createAgendas(agendas: List<Agenda>): List<Agenda>

	/**
	 * Deletes an agenda. If you don't have write access to the agenda the method will fail.
	 * @param entityId id of the agenda.
	 * @param rev the latest known rev of the agenda to delete
	 * @return the id and revision of the deleted agenda.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteAgendaById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many agendas. Ids that don't correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the agendas to delete.
	 * @return the id and revision of the deleted agendas. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a agenda.
	 * @param id id of the agenda to purge
	 * @param rev latest revision of the agenda
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeAgendaById(id: String, rev: String)

	/**
	 * Permanently deletes a batch of agendas.
	 * @param entityIds ids and revisions of the agendas to purge
	 * @return the id and revision of the purged agendas. If some entities couldn't be deleted (for example
	 * because you had no write access to them or their revision is outdated) they will not be included in this list.
	 */
	suspend fun purgeAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Restores an agenda that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteAgendaById(id: String, rev: String): Agenda

	/**
	 * Restores a batch of agendas that were marked as deleted.
	 * @param entityIds the ids and the revisions of the agendas to restore.
	 * @return the restored agendas. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * outdated), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<Agenda>

	/**
	 * Deletes an agenda. If you don't have write access to the agenda the method will fail.
	 * @param agenda the agenda to delete
	 * @return the id and revision of the deleted agenda.
	 * @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	suspend fun deleteAgenda(agenda: Agenda): StoredDocumentIdentifier =
		deleteAgendaById(agenda.id, requireNotNull(agenda.rev) { "Can't delete an agenda that has no rev" })

	/**
	 * Deletes many agendas. Ignores agenda for which you don't have write access or that don't match the latest revision.
	 * @param agendas the agendas to delete
	 * @return the id and revision of the deleted agendas. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteAgendas(agendas: List<Agenda>): List<StoredDocumentIdentifier> =
		deleteAgendasByIds(agendas.map { agenda ->
			agenda.toStoredDocumentIdentifier()
		})

	/**
	 * Permanently deletes a agenda.
	 * @param agenda the agenda to purge.
	 * @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	suspend fun purgeAgenda(agenda: Agenda) {
		purgeAgendaById(agenda.id, requireNotNull(agenda.rev) { "Can't delete an agenda that has no rev" })
	}

	/**
	 * Permanently deletes a batch of agendas.
	 * @param agendas the agendas to purge
	 * @return the id and revision of the purged agendas. If some entities couldn't be deleted (for example
	 * because you had no write access to them or their revision is outdated) they will not be included in this list.
	 */
	suspend fun purgeAgendas(agendas: List<Agenda>): List<StoredDocumentIdentifier> =
		purgeAgendasByIds(agendas.map { it.toStoredDocumentIdentifier() })

	/**
	 * Restores an agenda that was marked as deleted.
	 * @param agenda the agenda to undelete
	 * @return the restored agenda.
	 * @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	suspend fun undeleteAgenda(agenda: Agenda): Agenda =
		undeleteAgendaById(agenda.id, requireNotNull(agenda.rev) { "Can't delete an agenda that has no rev" })

	/**
	 * Restores a batch of agendas that were marked as deleted.
	 * @param agendas the agendas to restore.
	 * @return the restored agendas. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * outdated), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteAgendas(agendas: List<Agenda>): List<Agenda> =
		undeleteAgendasByIds(agendas.map { it.toStoredDocumentIdentifier() })

	suspend fun getAgenda(agendaId: String): Agenda?

	suspend fun getAgendas(agendaIds: List<String>): List<Agenda>

	suspend fun modifyAgenda(agenda: Agenda): Agenda

	suspend fun modifyAgendas(agendas: List<Agenda>): List<Agenda>

	suspend fun matchAgendasBy(filter: BaseFilterOptions<Agenda>): List<String>

	suspend fun matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): List<String>

	suspend fun filterAgendasBy(filter: BaseFilterOptions<Agenda>): PaginatedListIterator<Agenda>

	suspend fun filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<Agenda>
}


interface AgendaInGroupApi {

	suspend fun getAgenda(groupId: String, entityId: String): GroupScoped<Agenda>?

	suspend fun getAgendas(groupId: String, entityIds: List<String>): List<GroupScoped<Agenda>>

	suspend fun createAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda>

	suspend fun createAgendas(entities: List<GroupScoped<Agenda>>): List<GroupScoped<Agenda>>

	suspend fun modifyAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda>

	suspend fun modifyAgendas(entities: List<GroupScoped<Agenda>>): List<GroupScoped<Agenda>>

	suspend fun deleteAgendasByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>

	suspend fun deleteAgendas(agendas: List<GroupScoped<Agenda>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteAgendasByIds(agendas.map { it.toStoredDocumentIdentifier() })

	suspend fun deleteAgenda(agenda: GroupScoped<Agenda>): GroupScoped<StoredDocumentIdentifier> =
		deleteAgendaById(agenda.toStoredDocumentIdentifier())

	suspend fun undeleteAgendasByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Agenda>>

	suspend fun undeleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Agenda>

	suspend fun undeleteAgendas(agendas: List<GroupScoped<Agenda>>): List<GroupScoped<Agenda>> =
		undeleteAgendasByIds(agendas.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteAgenda(agenda: GroupScoped<Agenda>): GroupScoped<Agenda> =
		undeleteAgendaById(agenda.toStoredDocumentIdentifier())

	suspend fun purgeAgendasByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun purgeAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>)

	suspend fun purgeAgendas(agendas: List<GroupScoped<Agenda>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeAgendasByIds(agendas.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeAgenda(agenda: GroupScoped<Agenda>) {
		purgeAgendaById(agenda.toStoredDocumentIdentifier())
	}

	suspend fun matchAgendasBy(groupId: String, filter: BaseFilterOptions<Agenda>): List<String>

	suspend fun matchAgendasBySorted(groupId: String, filter: BaseSortableFilterOptions<Agenda>): List<String>

	suspend fun filterAgendasBy(groupId: String, filter: BaseFilterOptions<Agenda>): PaginatedListIterator<GroupScoped<Agenda>>

	suspend fun filterAgendasBySorted(groupId: String, filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<GroupScoped<Agenda>>
}
