// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItemShareOptions} from '../crypto/entities/CalendarItemShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {CalendarItem, DecryptedCalendarItem, EncryptedCalendarItem} from '../model/CalendarItem.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {CalendarItemFlavouredApi} from './CalendarItemFlavouredApi.mjs';
import {CalendarItemInGroupApi} from './CalendarItemInGroupApi.mjs';


export interface CalendarItemApi {

	encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem>;

	tryAndRecover: CalendarItemFlavouredApi<CalendarItem>;

	inGroup: CalendarItemInGroupApi;

	/**
	 *
	 *  Creates a new calendar item entity with initialized encryption metadata.
	 *  NOTE: this method doesn't send the entity to the backend, to store it you will need to pass the entity to the
	 *  [createCalendarItem] method.
	 *  @param base a calendar item with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the calendar item.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new calendar item
	 *  @return a calendar item with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedCalendarItem | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedCalendarItem>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a calendar item. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param calendarItem a calendar item
	 *  @return the encryption keys extracted from the provided calendar item.
	 */
	getEncryptionKeysOf(calendarItem: CalendarItem): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a calendar item through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param calendarItem a calendar item
	 *  @return if the current user has write access to the provided calendar item
	 */
	hasWriteAccess(calendarItem: CalendarItem): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a calendar item.
	 *  Note: calendar items usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param calendarItem a calendar item
	 *  @return the id of the patient linked to the calendar item, or empty if the current user can't access any patient id
	 *  of the calendar item.
	 */
	decryptPatientIdOf(calendarItem: CalendarItem): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a calendar item.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided calendar item. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the calendar item the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any CalendarItem,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a calendar item E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any calendar item that you have shared with P, H will be able to know that the calendar item was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a calendar item that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a calendar item
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: CalendarItem,
			delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts CalendarItems, throwing an exception if it is not possible.
	 *  @param calendarItems encrypted CalendarItems
	 *  @return the decrypted CalendarItems
	 *  @throws EntityEncryptionException if any of the provided CalendarItems couldn't be decrypted
	 */
	decrypt(calendarItems: Array<EncryptedCalendarItem>): Promise<Array<DecryptedCalendarItem>>;

	/**
	 *
	 *  Tries to decrypt a CalendarItem, returns the input if it is not possible.
	 *  @param calendarItems encrypted CalendarItems
	 *  @return all the provided CalendarItems, each of them decrypted if possible or unchanged (still encrypted)
	 */
	tryDecrypt(calendarItems: Array<EncryptedCalendarItem>): Promise<Array<CalendarItem>>;

	/**
	 *
	 *  Encrypts provided decrypted CalendarItems, and validates already encrypted CalendarItems.
	 *  @param calendarItems CalendarItems to encrypt and/or validate
	 *  @return the encrypted and validates CalendarItems
	 *  @throws EntityEncryptionException if any of the provided decrypted CalendarItems couldn't be encrypted (the current
	 *  user can't access its encryption key or no key was initialized) or if the already encrypted CalendarItems don't
	 *  respect the manifest.
	 */
	encryptOrValidate(calendarItems: Array<CalendarItem>): Promise<Array<EncryptedCalendarItem>>;

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
	matchCalendarItemsBy(filter: FilterOptions<CalendarItem>): Promise<Array<string>>;

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
	matchCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): Promise<Array<string>>;

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
	shareWith(delegateId: string, calendarItem: DecryptedCalendarItem,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<DecryptedCalendarItem>;

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
	shareWithMany(calendarItem: DecryptedCalendarItem,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<DecryptedCalendarItem>;

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
			shareLinkWithDelegates: Array<string>): Promise<DecryptedCalendarItem>;

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
	filterCalendarItemsBy(filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<DecryptedCalendarItem>>;

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
	filterCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<DecryptedCalendarItem>>;

	/**
	 *
	 *  Create a new calendar item. The provided calendar item must have the encryption metadata initialized.
	 *  @param entity a calendar item with initialized encryption metadata
	 *  @return the created calendar item with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createCalendarItem(entity: DecryptedCalendarItem): Promise<DecryptedCalendarItem>;

	/**
	 *
	 *  Create a batch of new calendarItems. All the provided calendarItems must have the encryption metadata initialized.
	 *  @param entities the calendarItems with initialized encryption metadata
	 *  @return the created calendarItems with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	createCalendarItems(entities: Array<DecryptedCalendarItem>): Promise<Array<DecryptedCalendarItem>>;

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
	bookCalendarItemCheckingAvailability(entity: DecryptedCalendarItem): Promise<DecryptedCalendarItem>;

	/**
	 *
	 *  Restores a calendarItem that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteCalendarItemById(id: string, rev: string): Promise<DecryptedCalendarItem>;

	/**
	 *
	 *  Restores a batch of calendarItems that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the calendarItems to restore.
	 *  @return the restored calendarItems. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedCalendarItem>>;

	/**
	 *
	 *  Restores a calendarItem that was marked as deleted.
	 *  @param calendarItem the calendarItem to undelete
	 *  @return the restored calendarItem.
	 *  @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	undeleteCalendarItem(calendarItem: CalendarItem): Promise<DecryptedCalendarItem>;

	/**
	 *
	 *  Restores a batch of calendarItems that were marked as deleted.
	 *  @param calendarItems the calendarItems to restore.
	 *  @return the restored calendarItems. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<DecryptedCalendarItem>>;

	/**
	 *
	 *  Modifies a calendar item. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a calendar item with update content
	 *  @return the calendar item updated with the provided content and a new revision.
	 */
	modifyCalendarItem(entity: DecryptedCalendarItem): Promise<DecryptedCalendarItem>;

	/**
	 *
	 *  Modifies a batch of calendarItems.
	 *  Flavoured method-
	 *  @param entities the updated calendarItems.
	 *  @return the updated calendarItems with their new revisions. If some entities couldn't be updated (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	modifyCalendarItems(entities: Array<DecryptedCalendarItem>): Promise<Array<DecryptedCalendarItem>>;

	/**
	 *
	 *  Get a calendar item by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a calendar item, or corresponds to an entity for which you don't have
	 *  read access.
	 *  @param entityId a calendar item id.
	 *  @return the calendar item with id [entityId].
	 */
	getCalendarItem(entityId: string): Promise<DecryptedCalendarItem | undefined>;

	/**
	 *
	 *  Get multiple calendar items by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a calendar item, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of calendar items ids
	 *  @return all calendar items that you can access with one of the provided ids.
	 */
	getCalendarItems(entityIds: Array<string>): Promise<Array<DecryptedCalendarItem>>;

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
