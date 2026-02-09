// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {CalendarItem, EncryptedCalendarItem} from '../model/CalendarItem.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface CalendarItemBasicInGroupApi {

	matchCalendarItemsBy(groupId: string,
			filter: BaseFilterOptions<CalendarItem>): Promise<Array<string>>;

	matchCalendarItemsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<CalendarItem>): Promise<Array<string>>;

	filterCalendarItemsBy(groupId: string,
			filter: BaseFilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>>;

	filterCalendarItemsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>>;

	deleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteCalendarItems(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<void>;

	purgeCalendarItems(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createCalendarItem(entity: GroupScoped<EncryptedCalendarItem>): Promise<GroupScoped<EncryptedCalendarItem>>;

	createCalendarItems(entities: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	undeleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedCalendarItem>>;

	undeleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	undeleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<EncryptedCalendarItem>>;

	undeleteCalendarItems(calendarItems: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	modifyCalendarItem(entity: GroupScoped<EncryptedCalendarItem>): Promise<GroupScoped<EncryptedCalendarItem>>;

	modifyCalendarItems(entities: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	getCalendarItem(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedCalendarItem> | undefined>;

	getCalendarItems(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

}
