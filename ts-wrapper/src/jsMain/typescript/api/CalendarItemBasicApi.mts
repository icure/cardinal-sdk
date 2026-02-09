// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {CalendarItem, EncryptedCalendarItem} from '../model/CalendarItem.mjs';
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

	deleteCalendarItemById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeCalendarItemById(id: string, rev: string): Promise<void>;

	purgeCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteCalendarItem(calendarItem: CalendarItem): Promise<StoredDocumentIdentifier>;

	deleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<StoredDocumentIdentifier>>;

	purgeCalendarItem(calendarItem: CalendarItem): Promise<void>;

	purgeCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<StoredDocumentIdentifier>>;

	createCalendarItem(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	createCalendarItems(entities: Array<EncryptedCalendarItem>): Promise<Array<EncryptedCalendarItem>>;

	bookCalendarItemCheckingAvailability(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	undeleteCalendarItemById(id: string, rev: string): Promise<EncryptedCalendarItem>;

	undeleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedCalendarItem>>;

	undeleteCalendarItem(calendarItem: CalendarItem): Promise<EncryptedCalendarItem>;

	undeleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<EncryptedCalendarItem>>;

	modifyCalendarItem(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	modifyCalendarItems(entities: Array<EncryptedCalendarItem>): Promise<Array<EncryptedCalendarItem>>;

	getCalendarItem(entityId: string): Promise<EncryptedCalendarItem | undefined>;

	getCalendarItems(entityIds: Array<string>): Promise<Array<EncryptedCalendarItem>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<CalendarItem>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedCalendarItem>>;

}
