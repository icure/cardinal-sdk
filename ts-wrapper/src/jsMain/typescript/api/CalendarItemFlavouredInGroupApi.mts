// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItemShareOptions} from '../crypto/entities/CalendarItemShareOptions.mjs';
import {CalendarItem} from '../model/CalendarItem.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface CalendarItemFlavouredInGroupApi<E extends CalendarItem> {

	shareWith(delegate: EntityReferenceInGroup, calendarItem: GroupScoped<E>,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(calendarItem: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: CalendarItemShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	filterCalendarItemsBy(groupId: string,
			filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterCalendarItemsBySorted(groupId: string,
			filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createCalendarItem(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createCalendarItems(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<E>>;

	undeleteCalendarItems(calendarItems: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyCalendarItem(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyCalendarItems(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getCalendarItem(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getCalendarItems(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
