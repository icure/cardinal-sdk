// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {CalendarItem, EncryptedCalendarItem} from '../model/CalendarItem.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface CalendarItemBasicInGroupApi {

	/**
	 *
	 *  In-group version of [CalendarItemBasicApi.matchCalendarItemsBy]
	 */
	matchCalendarItemsBy(groupId: string,
			filter: BaseFilterOptions<CalendarItem>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicApi.matchCalendarItemsBySorted]
	 */
	matchCalendarItemsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<CalendarItem>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicApi.filterCalendarItemsBy]
	 */
	filterCalendarItemsBy(groupId: string,
			filter: BaseFilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicApi.filterCalendarItemsBySorted]
	 */
	filterCalendarItemsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItemById]
	 */
	deleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItemsByIds]
	 */
	deleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItemById]
	 */
	purgeCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItemsByIds]
	 */
	purgeCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItem]
	 */
	deleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItems]
	 */
	deleteCalendarItems(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItem]
	 */
	purgeCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<void>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItems]
	 */
	purgeCalendarItems(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.createCalendarItem].
	 */
	createCalendarItem(entity: GroupScoped<EncryptedCalendarItem>): Promise<GroupScoped<EncryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.createCalendarItems].
	 */
	createCalendarItems(entities: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItemById]
	 */
	undeleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItemsByIds]
	 */
	undeleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItem]
	 */
	undeleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<EncryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItems]
	 */
	undeleteCalendarItems(calendarItems: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.modifyCalendarItem]
	 */
	modifyCalendarItem(entity: GroupScoped<EncryptedCalendarItem>): Promise<GroupScoped<EncryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.modifyCalendarItems]
	 */
	modifyCalendarItems(entities: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.getCalendarItem]
	 */
	getCalendarItem(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedCalendarItem> | undefined>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.getCalendarItems]
	 */
	getCalendarItems(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

}
