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

	/**
	 *
	 *  Get the ids of all calendarItems matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchCalendarItemsBySorted] instead.
	 *
	 *  @param filter a calendarItem filter
	 *  @return a list of calendarItem ids
	 */
	matchCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all calendarItems matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchCalendarItemsBy].
	 *
	 *  @param filter a calendarItem filter
	 *  @return a list of calendarItem ids
	 */
	matchCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): Promise<Array<string>>;

	/**
	 *
	 *  Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterCalendarItemsBySorted] instead.
	 *
	 *  @param filter a calendarItem filter
	 *  @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	filterCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): Promise<PaginatedListIterator<EncryptedCalendarItem>>;

	/**
	 *
	 *  Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterCalendarItemsBy].
	 *
	 *  @param filter a calendarItem filter
	 *  @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	filterCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<EncryptedCalendarItem>>;

	/**
	 *
	 *  Deletes a calendarItem. If you don't have write access to the calendarItem the method will fail.
	 *  @param entityId id of the calendarItem.
	 *  @param rev the latest known rev of the calendarItem to delete
	 *  @return the id and revision of the deleted calendarItem.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteCalendarItemById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many calendarItems. Ids that don't correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the calendarItems to delete.
	 *  @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a calendarItem.
	 *  @param id id of the calendarItem to purge
	 *  @param rev latest revision of the calendarItem
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeCalendarItemById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many calendarItems.
	 *  @param entityIds ids and revisions of the calendarItems to delete
	 *  @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a calendarItem. If you don't have write access to the calendarItem the method will fail.
	 *  @param calendarItem the calendarItem to delete
	 *  @return the id and revision of the deleted calendarItem.
	 *  @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	deleteCalendarItem(calendarItem: CalendarItem): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many calendarItems. Ignores calendarItem for which you don't have write access or that don't match the latest revision.
	 *  @param calendarItems the calendarItems to delete
	 *  @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a calendarItem.
	 *  @param calendarItem the calendarItem to purge.
	 *  @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	purgeCalendarItem(calendarItem: CalendarItem): Promise<void>;

	/**
	 *
	 *  Permanently deletes many calendarItems.
	 *  @param calendarItems the calendarItems to purge.
	 *  @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Create a new calendar item. The provided calendar item must have the encryption metadata initialized.
	 *  @param entity a calendar item with initialized encryption metadata
	 *  @return the created calendar item with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createCalendarItem(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	/**
	 *
	 *  Create a batch of new calendarItems. All the provided calendarItems must have the encryption metadata initialized.
	 *  @param entities the calendarItems with initialized encryption metadata
	 *  @return the created calendarItems with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	createCalendarItems(entities: Array<EncryptedCalendarItem>): Promise<Array<EncryptedCalendarItem>>;

	/**
	 *
	 *  Book a calendar item while checking that there is availability for it in its agenda.
	 *  This method is more restrictive than [createCalendarItem], but it also requires weaker permissions:
	 *  - The calendar item must have booking details initialized ([CalendarItem.agendaId], [CalendarItem.startTime], [CalendarItem.calendarItemTypeId]...)
	 *  - The calendar item can't have some fields that customize the availability calculation initialized ([CalendarItem.resourceGroup], [CalendarItem.availabilitiesAssignmentStrategy])
	 *  - The calendar item booking details must match an availability of the agenda
	 *  This method can also be used by users that would have the permissions to use [createCalendarItem] to ensure there
	 *  is no double-booking.
	 *  This method can't be used with kraken-lite instances.
	 *  @param entity a calendar item with initialized encryption metadata and booking details.
	 *  @return the created calendar item with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata or booking details of the input was not initialized.
	 *  @throws com.icure.cardinal.sdk.exceptions.MissingAvailabilityException if there is no availability for the calendar item.
	 */
	bookCalendarItemCheckingAvailability(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	/**
	 *
	 *  Restores a calendarItem that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteCalendarItemById(id: string, rev: string): Promise<EncryptedCalendarItem>;

	/**
	 *
	 *  Restores a batch of calendarItems that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the calendarItems to restore.
	 *  @return the restored calendarItems. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedCalendarItem>>;

	/**
	 *
	 *  Restores a calendarItem that was marked as deleted.
	 *  @param calendarItem the calendarItem to undelete
	 *  @return the restored calendarItem.
	 *  @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	undeleteCalendarItem(calendarItem: CalendarItem): Promise<EncryptedCalendarItem>;

	/**
	 *
	 *  Restores a batch of calendarItems that were marked as deleted.
	 *  @param calendarItems the calendarItems to restore.
	 *  @return the restored calendarItems. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<EncryptedCalendarItem>>;

	/**
	 *
	 *  Modifies a calendar item. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a calendar item with update content
	 *  @return the calendar item updated with the provided content and a new revision.
	 */
	modifyCalendarItem(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	/**
	 *
	 *  Modifies a batch of calendarItems.
	 *  Flavoured method-
	 *  @param entities the updated calendarItems.
	 *  @return the updated calendarItems with their new revisions. If some entities couldn't be updated (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	modifyCalendarItems(entities: Array<EncryptedCalendarItem>): Promise<Array<EncryptedCalendarItem>>;

	/**
	 *
	 *  Get a calendar item by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a calendar item, or corresponds to an entity for which you don't have
	 *  read access.
	 *  @param entityId a calendar item id.
	 *  @return the calendar item with id [entityId].
	 */
	getCalendarItem(entityId: string): Promise<EncryptedCalendarItem | undefined>;

	/**
	 *
	 *  Get multiple calendar items by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a calendar item, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of calendar items ids
	 *  @return all calendar items that you can access with one of the provided ids.
	 */
	getCalendarItems(entityIds: Array<string>): Promise<Array<EncryptedCalendarItem>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<CalendarItem>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedCalendarItem>>;

}
