// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItemShareOptions} from '../crypto/entities/CalendarItemShareOptions.mjs';
import {CalendarItem} from '../model/CalendarItem.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface CalendarItemFlavouredApi<E extends CalendarItem> {

	/**
	 *
	 *  Share a calendar item with another data owner. The calendar item must already exist in the database for this method to
	 *  succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the calendar item
	 *  @param calendarItem the calendar item to share with [delegateId]
	 *  @param options specifies how the calendar item will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the calendar item. Refer
	 *  to the documentation of [CalendarItemShareOptions] for more information.
	 *  @return the updated calendar item
	 */
	shareWith(delegateId: string, calendarItem: E,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share a calendar item with multiple data owners. The calendar item must already exist in the database for this method to
	 *  succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param calendarItem the calendar item to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated calendar item.
	 */
	shareWithMany(calendarItem: E,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<E>;

	/**
	 *
	 *  Links a calendar item with a patient. Note that this operation is not reversible: it is not possible to change the patient linked to a calendar
	 *  item.
	 *  @param calendarItem a calendar item.
	 *  @param patient the patient which will be linked to the calendar item.
	 *  @param shareLinkWithDelegates data owners other than the current data owner which will also be able to decrypt the id of the newly linked
	 *  patient. If any of these data owners do not already have access to the calendar item, they will be granted read access (no write).
	 *  @return the updated calendar item.
	 */
	linkToPatient(calendarItem: CalendarItem, patient: Patient,
			shareLinkWithDelegates: Array<string>): Promise<E>;

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
	filterCalendarItemsBy(filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<E>>;

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
	filterCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new calendar item. The provided calendar item must have the encryption metadata initialized.
	 *  @param entity a calendar item with initialized encryption metadata
	 *  @return the created calendar item with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createCalendarItem(entity: E): Promise<E>;

	/**
	 *
	 *  Create a batch of new calendarItems. All the provided calendarItems must have the encryption metadata initialized.
	 *  @param entities the calendarItems with initialized encryption metadata
	 *  @return the created calendarItems with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	createCalendarItems(entities: Array<E>): Promise<Array<E>>;

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
	bookCalendarItemCheckingAvailability(entity: E): Promise<E>;

	/**
	 *
	 *  Restores a calendarItem that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteCalendarItemById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of calendarItems that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the calendarItems to restore.
	 *  @return the restored calendarItems. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a calendarItem that was marked as deleted.
	 *  @param calendarItem the calendarItem to undelete
	 *  @return the restored calendarItem.
	 *  @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	undeleteCalendarItem(calendarItem: CalendarItem): Promise<E>;

	/**
	 *
	 *  Restores a batch of calendarItems that were marked as deleted.
	 *  @param calendarItems the calendarItems to restore.
	 *  @return the restored calendarItems. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a calendar item. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a calendar item with update content
	 *  @return the calendar item updated with the provided content and a new revision.
	 */
	modifyCalendarItem(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies a batch of calendarItems.
	 *  Flavoured method-
	 *  @param entities the updated calendarItems.
	 *  @return the updated calendarItems with their new revisions. If some entities couldn't be updated (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	modifyCalendarItems(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a calendar item by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a calendar item, or corresponds to an entity for which you don't have
	 *  read access.
	 *  @param entityId a calendar item id.
	 *  @return the calendar item with id [entityId].
	 */
	getCalendarItem(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple calendar items by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a calendar item, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of calendar items ids
	 *  @return all calendar items that you can access with one of the provided ids.
	 */
	getCalendarItems(entityIds: Array<string>): Promise<Array<E>>;

}
