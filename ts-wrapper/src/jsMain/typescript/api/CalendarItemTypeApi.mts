// auto-generated file
import {CalendarItemType} from '../model/CalendarItemType.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {CalendarItemTypeInGroupApi} from './CalendarItemTypeInGroupApi.mjs';


export interface CalendarItemTypeApi {

	inGroup: CalendarItemTypeInGroupApi;

	createCalendarItemType(calendarItemType: CalendarItemType): Promise<CalendarItemType>;

	createCalendarItemTypes(calendarItemTypes: Array<CalendarItemType>): Promise<Array<CalendarItemType>>;

	getCalendarItemType(calendarItemTypeId: string): Promise<CalendarItemType | undefined>;

	getCalendarItemTypes(calendarItemTypesIds: Array<string>): Promise<Array<CalendarItemType>>;

	modifyCalendarItemType(calendarItemType: CalendarItemType): Promise<CalendarItemType>;

	modifyCalendarItemTypes(calendarItemTypes: Array<CalendarItemType>): Promise<Array<CalendarItemType>>;

	deleteCalendarItemTypeById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteCalendarItemType(calendarItemType: CalendarItemType): Promise<StoredDocumentIdentifier>;

	deleteCalendarItemTypes(calendarItemTypes: Array<CalendarItemType>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteCalendarItemTypeById(entityId: string, rev: string): Promise<CalendarItemType>;

	undeleteCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<CalendarItemType>>;

	undeleteCalendarItemType(calendarItemType: CalendarItemType): Promise<CalendarItemType>;

	undeleteCalendarItemTypes(calendarItemTypes: Array<CalendarItemType>): Promise<Array<CalendarItemType>>;

	purgeCalendarItemTypeById(entityId: string, rev: string): Promise<void>;

	purgeCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeCalendarItemType(calendarItemType: CalendarItemType): Promise<void>;

	purgeCalendarItemTypes(calendarItemTypes: Array<CalendarItemType>): Promise<Array<StoredDocumentIdentifier>>;

	listCalendarItemTypesByAgendaId(agendaId: string): Promise<Array<CalendarItemType>>;

}
