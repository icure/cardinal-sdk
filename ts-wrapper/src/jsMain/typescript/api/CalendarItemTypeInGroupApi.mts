// auto-generated file
import {CalendarItemType} from '../model/CalendarItemType.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface CalendarItemTypeInGroupApi {

	createCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): Promise<GroupScoped<CalendarItemType>>;

	createCalendarItemTypes(calendarItemTypes: Array<GroupScoped<CalendarItemType>>): Promise<Array<GroupScoped<CalendarItemType>>>;

	getCalendarItemType(groupId: string,
			calendarItemTypeId: string): Promise<GroupScoped<CalendarItemType> | undefined>;

	getCalendarItemTypes(groupId: string,
			calendarItemTypesIds: Array<string>): Promise<Array<GroupScoped<CalendarItemType>>>;

	modifyCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): Promise<GroupScoped<CalendarItemType>>;

	modifyCalendarItemTypes(calendarItemTypes: Array<GroupScoped<CalendarItemType>>): Promise<Array<GroupScoped<CalendarItemType>>>;

	deleteCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteCalendarItemTypeByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteCalendarItemTypes(calendarItemTypes: Array<GroupScoped<CalendarItemType>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	undeleteCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<CalendarItemType>>;

	undeleteCalendarItemTypeByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<CalendarItemType>>>;

	undeleteCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): Promise<GroupScoped<CalendarItemType>>;

	undeleteCalendarItemTypes(calendarItemTypes: Array<GroupScoped<CalendarItemType>>): Promise<Array<GroupScoped<CalendarItemType>>>;

	purgeCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeCalendarItemTypeByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): Promise<void>;

	purgeCalendarItemTypes(calendarItemTypes: Array<GroupScoped<CalendarItemType>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

}
