// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItemShareOptions} from '../crypto/entities/CalendarItemShareOptions.mjs';
import {CalendarItem} from '../model/CalendarItem.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';


export interface CalendarItemFlavouredApi<E extends CalendarItem> {

	shareWith(delegateId: string, calendarItem: E,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<E>;

	shareWithMany(calendarItem: E,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<E>;

	findCalendarItemsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	linkToPatient(calendarItem: CalendarItem, patient: Patient,
			shareLinkWithDelegates: Array<string>): Promise<E>;

	filterCalendarItemsBy(filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<E>>;

	filterCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<E>>;

	createCalendarItem(entity: E): Promise<E>;

	bookCalendarItemCheckingAvailability(entity: E): Promise<E>;

	undeleteCalendarItemById(id: string, rev: string): Promise<E>;

	undeleteCalendarItem(calendarItem: CalendarItem): Promise<E>;

	modifyCalendarItem(entity: E): Promise<E>;

	getCalendarItem(entityId: string): Promise<E | undefined>;

	getCalendarItems(entityIds: Array<string>): Promise<Array<E>>;

	getCalendarItemsByPeriodAndHcPartyId(startDate: number, endDate: number,
			hcPartyId: string): Promise<Array<E>>;

	getCalendarsByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<E>>;

	findCalendarItemsByRecurrenceId(recurrenceId: string, startKey: string | undefined,
			startDocumentId: string | undefined, limit: number): Promise<PaginatedList<E>>;

}
