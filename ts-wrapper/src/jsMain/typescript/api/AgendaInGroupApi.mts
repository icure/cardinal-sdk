// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Agenda} from '../model/Agenda.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface AgendaInGroupApi {

	getAgenda(groupId: string, entityId: string): Promise<GroupScoped<Agenda> | undefined>;

	getAgendas(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<Agenda>>>;

	createAgenda(entity: GroupScoped<Agenda>): Promise<GroupScoped<Agenda>>;

	createAgendas(entities: Array<GroupScoped<Agenda>>): Promise<Array<GroupScoped<Agenda>>>;

	modifyAgenda(entity: GroupScoped<Agenda>): Promise<GroupScoped<Agenda>>;

	modifyAgendas(entities: Array<GroupScoped<Agenda>>): Promise<Array<GroupScoped<Agenda>>>;

	deleteAgendasByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteAgendas(agendas: Array<GroupScoped<Agenda>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteAgenda(agenda: GroupScoped<Agenda>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	undeleteAgendasByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<Agenda>>>;

	undeleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<Agenda>>;

	undeleteAgendas(agendas: Array<GroupScoped<Agenda>>): Promise<Array<GroupScoped<Agenda>>>;

	undeleteAgenda(agenda: GroupScoped<Agenda>): Promise<GroupScoped<Agenda>>;

	purgeAgendasByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeAgendas(agendas: Array<GroupScoped<Agenda>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeAgenda(agenda: GroupScoped<Agenda>): Promise<void>;

	matchAgendasBy(groupId: string, filter: BaseFilterOptions<Agenda>): Promise<Array<string>>;

	matchAgendasBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Agenda>): Promise<Array<string>>;

	filterAgendasBy(groupId: string,
			filter: BaseFilterOptions<Agenda>): Promise<PaginatedListIterator<GroupScoped<Agenda>>>;

	filterAgendasBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Agenda>): Promise<PaginatedListIterator<GroupScoped<Agenda>>>;

}
