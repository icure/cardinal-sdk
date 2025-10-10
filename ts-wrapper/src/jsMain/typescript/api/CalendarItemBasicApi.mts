// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {CalendarItem, EncryptedCalendarItem} from '../model/CalendarItem.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {CalendarItemBasicInGroupApi} from './CalendarItemBasicInGroupApi.mjs';


export interface CalendarItemBasicApi {

	inGroup: CalendarItemBasicInGroupApi;

	matchCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): Promise<Array<string>>;

	matchCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): Promise<Array<string>>;

	filterCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): Promise<PaginatedListIterator<EncryptedCalendarItem>>;

	filterCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<EncryptedCalendarItem>>;

	deleteCalendarItemUnsafe(entityId: string): Promise<StoredDocumentIdentifier>;

	deleteCalendarItemsUnsafe(entityIds: Array<string>): Promise<Array<StoredDocumentIdentifier>>;

	deleteCalendarItemById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeCalendarItemById(id: string, rev: string): Promise<void>;

	deleteCalendarItem(calendarItem: CalendarItem): Promise<StoredDocumentIdentifier>;

	deleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<StoredDocumentIdentifier>>;

	purgeCalendarItem(calendarItem: CalendarItem): Promise<void>;

	createCalendarItem(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	bookCalendarItemCheckingAvailability(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	undeleteCalendarItemById(id: string, rev: string): Promise<EncryptedCalendarItem>;

	undeleteCalendarItem(calendarItem: CalendarItem): Promise<EncryptedCalendarItem>;

	modifyCalendarItem(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	getCalendarItem(entityId: string): Promise<EncryptedCalendarItem | undefined>;

	getCalendarItems(entityIds: Array<string>): Promise<Array<EncryptedCalendarItem>>;

	getCalendarItemsByPeriodAndHcPartyId(startDate: number, endDate: number,
			hcPartyId: string): Promise<Array<EncryptedCalendarItem>>;

	getCalendarsByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<EncryptedCalendarItem>>;

	findCalendarItemsByRecurrenceId(recurrenceId: string, startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number): Promise<PaginatedList<EncryptedCalendarItem>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<CalendarItem>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedCalendarItem>>;

}
