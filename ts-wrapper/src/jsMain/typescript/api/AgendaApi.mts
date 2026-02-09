// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Agenda} from '../model/Agenda.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {AgendaInGroupApi} from './AgendaInGroupApi.mjs';


export interface AgendaApi {

	inGroup: AgendaInGroupApi;

	createAgenda(agenda: Agenda): Promise<Agenda>;

	createAgendas(agendas: Array<Agenda>): Promise<Array<Agenda>>;

	deleteAgendaById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteAgendasByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAgendaById(id: string, rev: string): Promise<void>;

	purgeAgendasByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteAgendaById(id: string, rev: string): Promise<Agenda>;

	undeleteAgendasByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<Agenda>>;

	deleteAgenda(agenda: Agenda): Promise<StoredDocumentIdentifier>;

	deleteAgendas(agendas: Array<Agenda>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAgenda(agenda: Agenda): Promise<void>;

	purgeAgendas(agendas: Array<Agenda>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteAgenda(agenda: Agenda): Promise<Agenda>;

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
