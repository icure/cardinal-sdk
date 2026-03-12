// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Agenda} from '../model/Agenda.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {AgendaInGroupApi} from './AgendaInGroupApi.mjs';


export interface AgendaApi {

	inGroup: AgendaInGroupApi;

	createAgenda(agenda: Agenda): Promise<Agenda>;

	createAgendas(agendas: Array<Agenda>): Promise<Array<Agenda>>;

	/**
	 *
	 *  Deletes an agenda. If you don't have write access to the agenda the method will fail.
	 *  @param entityId id of the agenda.
	 *  @param rev the latest known rev of the agenda to delete
	 *  @return the id and revision of the deleted agenda.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteAgendaById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many agendas. Ids that don't correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the agendas to delete.
	 *  @return the id and revision of the deleted agendas. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteAgendasByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a agenda.
	 *  @param id id of the agenda to purge
	 *  @param rev latest revision of the agenda
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeAgendaById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes a batch of agendas.
	 *  @param entityIds ids and revisions of the agendas to purge
	 *  @return the id and revision of the purged agendas. If some entities couldn't be deleted (for example
	 *  because you had no write access to them or their revision is outdated) they will not be included in this list.
	 */
	purgeAgendasByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Restores an agenda that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteAgendaById(id: string, rev: string): Promise<Agenda>;

	/**
	 *
	 *  Restores a batch of agendas that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the agendas to restore.
	 *  @return the restored agendas. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  outdated), then those entities will not be restored and will not appear in this list.
	 */
	undeleteAgendasByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<Agenda>>;

	/**
	 *
	 *  Deletes an agenda. If you don't have write access to the agenda the method will fail.
	 *  @param agenda the agenda to delete
	 *  @return the id and revision of the deleted agenda.
	 *  @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	deleteAgenda(agenda: Agenda): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many agendas. Ignores agenda for which you don't have write access or that don't match the latest revision.
	 *  @param agendas the agendas to delete
	 *  @return the id and revision of the deleted agendas. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteAgendas(agendas: Array<Agenda>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a agenda.
	 *  @param agenda the agenda to purge.
	 *  @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	purgeAgenda(agenda: Agenda): Promise<void>;

	/**
	 *
	 *  Permanently deletes a batch of agendas.
	 *  @param agendas the agendas to purge
	 *  @return the id and revision of the purged agendas. If some entities couldn't be deleted (for example
	 *  because you had no write access to them or their revision is outdated) they will not be included in this list.
	 */
	purgeAgendas(agendas: Array<Agenda>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Restores an agenda that was marked as deleted.
	 *  @param agenda the agenda to undelete
	 *  @return the restored agenda.
	 *  @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	undeleteAgenda(agenda: Agenda): Promise<Agenda>;

	/**
	 *
	 *  Restores a batch of agendas that were marked as deleted.
	 *  @param agendas the agendas to restore.
	 *  @return the restored agendas. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  outdated), then those entities will not be restored and will not appear in this list.
	 */
	undeleteAgendas(agendas: Array<Agenda>): Promise<Array<Agenda>>;

	getAgenda(agendaId: string): Promise<Agenda | undefined>;

	getAgendas(agendaIds: Array<string>): Promise<Array<Agenda>>;

	modifyAgenda(agenda: Agenda): Promise<Agenda>;

	modifyAgendas(agendas: Array<Agenda>): Promise<Array<Agenda>>;

	matchAgendasBy(filter: BaseFilterOptions<Agenda>): Promise<Array<string>>;

	matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): Promise<Array<string>>;

	filterAgendasBy(filter: BaseFilterOptions<Agenda>): Promise<PaginatedListIterator<Agenda>>;

	filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): Promise<PaginatedListIterator<Agenda>>;

}
