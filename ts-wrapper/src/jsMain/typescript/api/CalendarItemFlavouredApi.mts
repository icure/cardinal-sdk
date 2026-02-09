// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItemShareOptions} from '../crypto/entities/CalendarItemShareOptions.mjs';
import {CalendarItem} from '../model/CalendarItem.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface CalendarItemFlavouredApi<E extends CalendarItem> {

	shareWith(delegateId: string, calendarItem: E,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<E>;

	shareWithMany(calendarItem: E,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<E>;

	linkToPatient(calendarItem: CalendarItem, patient: Patient,
			shareLinkWithDelegates: Array<string>): Promise<E>;

	filterCalendarItemsBy(filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<E>>;

	filterCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<E>>;

	createCalendarItem(entity: E): Promise<E>;

	createCalendarItems(entities: Array<E>): Promise<Array<E>>;

	bookCalendarItemCheckingAvailability(entity: E): Promise<E>;

	undeleteCalendarItemById(id: string, rev: string): Promise<E>;

	undeleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteCalendarItem(calendarItem: CalendarItem): Promise<E>;

	undeleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<E>>;

	modifyCalendarItem(entity: E): Promise<E>;

	modifyCalendarItems(entities: Array<E>): Promise<Array<E>>;

	getCalendarItem(entityId: string): Promise<E | undefined>;

	getCalendarItems(entityIds: Array<string>): Promise<Array<E>>;

}
