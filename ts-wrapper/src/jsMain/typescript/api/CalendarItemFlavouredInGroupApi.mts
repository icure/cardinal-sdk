// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItemShareOptions} from '../crypto/entities/CalendarItemShareOptions.mjs';
import {CalendarItem} from '../model/CalendarItem.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface CalendarItemFlavouredInGroupApi<E extends CalendarItem> {

	/**
	 *
	 *  In-group version of [CalendarItemFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, calendarItem: GroupScoped<E>,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CalendarItemFlavouredApi.shareWithMany]
	 */
	shareWithMany(calendarItem: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: CalendarItemShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CalendarItemFlavouredApi.filterCalendarItemsBy]
	 */
	filterCalendarItemsBy(groupId: string,
			filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CalendarItemFlavouredApi.filterCalendarItemsBySorted]
	 */
	filterCalendarItemsBySorted(groupId: string,
			filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.createCalendarItem].
	 */
	createCalendarItem(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.createCalendarItems].
	 */
	createCalendarItems(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItemById]
	 */
	undeleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItemsByIds]
	 */
	undeleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItem]
	 */
	undeleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItems]
	 */
	undeleteCalendarItems(calendarItems: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.modifyCalendarItem]
	 */
	modifyCalendarItem(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.modifyCalendarItems]
	 */
	modifyCalendarItems(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.getCalendarItem]
	 */
	getCalendarItem(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.getCalendarItems]
	 */
	getCalendarItems(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
