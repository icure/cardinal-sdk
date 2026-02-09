package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface CalendarItemBasicFlavourlessApi {
	/**
	 * Deletes a calendarItem. If you don't have write access to the calendarItem the method will fail.
	 * @param entityId id of the calendarItem.
	 * @param rev the latest known rev of the calendarItem to delete
	 * @return the id and revision of the deleted calendarItem.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteCalendarItemById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many calendarItems. Ids that don't correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the calendarItems to delete.
	 * @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteCalendarItemsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a calendarItem.
	 * @param id id of the calendarItem to purge
	 * @param rev latest revision of the calendarItem
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeCalendarItemById(id: String, rev: String)

	/**
	 * Permanently deletes many calendarItems.
	 * @param entityIds ids and revisions of the calendarItems to delete
	 * @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeCalendarItemsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Deletes a calendarItem. If you don't have write access to the calendarItem the method will fail.
	 * @param calendarItem the calendarItem to delete
	 * @return the id and revision of the deleted calendarItem.
	 * @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	suspend fun deleteCalendarItem(calendarItem: CalendarItem): StoredDocumentIdentifier =
		deleteCalendarItemById(calendarItem.id, requireNotNull(calendarItem.rev) { "Can't delete a calendarItem that has no rev" })

	/**
	 * Deletes many calendarItems. Ignores calendarItem for which you don't have write access or that don't match the latest revision.
	 * @param calendarItems the calendarItems to delete
	 * @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteCalendarItems(calendarItems: List<CalendarItem>): List<StoredDocumentIdentifier> =
		deleteCalendarItemsByIds(calendarItems.map { calendarItem ->
			calendarItem.toStoredDocumentIdentifier()
		})

	/**
	 * Permanently deletes a calendarItem.
	 * @param calendarItem the calendarItem to purge.
	 * @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	suspend fun purgeCalendarItem(calendarItem: CalendarItem) {
		purgeCalendarItemById(calendarItem.id, requireNotNull(calendarItem.rev) { "Can't delete a calendarItem that has no rev" })
	}

	/**
	 * Permanently deletes many calendarItems.
	 * @param calendarItems the calendarItems to purge.
	 * @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeCalendarItems(calendarItems: List<CalendarItem>): List<StoredDocumentIdentifier> =
		purgeCalendarItemsByIds(calendarItems.map { calendarItem ->
			calendarItem.toStoredDocumentIdentifier()
		})
}

interface CalendarItemBasicFlavourlessInGroupApi {
	/**
	 * In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItemById]
	 */
	suspend fun deleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>

	/**
	 * In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItemsByIds]
	 */
	 suspend fun deleteCalendarItemsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItemById]
	 */
	suspend fun purgeCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>)

	/**
	 * In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItemsByIds]
	 */
	suspend fun purgeCalendarItemsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItem]
	 */
	suspend fun deleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): GroupScoped<StoredDocumentIdentifier> =
		deleteCalendarItemById(calendarItem.toStoredDocumentIdentifier())

	/**
	 * In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItems]
	 */
	suspend fun deleteCalendarItems(calendarItems: List<GroupScoped<CalendarItem>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteCalendarItemsByIds(calendarItems.toStoredDocumentIdentifier())

	/**
	 * In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItem]
	 */
	suspend fun purgeCalendarItem(calendarItem: GroupScoped<CalendarItem>) {
		purgeCalendarItemById(calendarItem.toStoredDocumentIdentifier())
	}

	/**
	 * In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItems]
	 */
	suspend fun purgeCalendarItems(calendarItems: List<GroupScoped<CalendarItem>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeCalendarItemsByIds(calendarItems.map { it.toStoredDocumentIdentifier() })
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface CalendarItemBasicFlavouredApi<E : CalendarItem> {
	/**
	 * Create a new calendar item. The provided calendar item must have the encryption metadata initialized.
	 * @param entity a calendar item with initialized encryption metadata
	 * @return the created calendar item with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createCalendarItem(entity: E): E

	/**
	 * Create a batch of new calendarItems. All the provided calendarItems must have the encryption metadata initialized.
	 * @param entities the calendarItems with initialized encryption metadata
	 * @return the created calendarItems with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	suspend fun createCalendarItems(entities: List<E>): List<E>

	/**
	 * Book a calendar item while checking that there is availability for it in its agenda.
	 * This method is more restrictive than [createCalendarItem], but it also requires weaker permissions:
	 * - The calendar item must have booking details initialized ([CalendarItem.agendaId], [CalendarItem.startTime], [CalendarItem.calendarItemTypeId]...)
	 * - The calendar item can't have some fields that customize the availability calculation initialized ([CalendarItem.resourceGroup], [CalendarItem.availabilitiesAssignmentStrategy])
	 * - The calendar item booking details must match an availability of the agenda
	 * This method can also be used by users that would have the permissions to use [createCalendarItem] to ensure there
	 * is no double-booking.
	 * This method can't be used with kraken-lite instances.
	 * @param entity a calendar item with initialized encryption metadata and booking details.
	 * @return the created calendar item with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata or booking details of the input was not initialized.
	 * @throws com.icure.cardinal.sdk.exceptions.MissingAvailabilityException if there is no availability for the calendar item.
	 */
	suspend fun bookCalendarItemCheckingAvailability(entity: E): E

	/**
	 * Restores a calendarItem that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteCalendarItemById(id: String, rev: String): E

	/**
	 * Restores a batch of calendarItems that were marked as deleted.
	 * @param entityIds the ids and the revisions of the calendarItems to restore.
	 * @return the restored calendarItems. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteCalendarItemsByIds(entityIds: List<StoredDocumentIdentifier>): List<E>

	/**
	 * Restores a calendarItem that was marked as deleted.
	 * @param calendarItem the calendarItem to undelete
	 * @return the restored calendarItem.
	 * @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	suspend fun undeleteCalendarItem(calendarItem: CalendarItem): E =
		undeleteCalendarItemById(calendarItem.id, requireNotNull(calendarItem.rev) { "Can't delete a calendarItem that has no rev" })

	/**
	 * Restores a batch of calendarItems that were marked as deleted.
	 * @param calendarItems the calendarItems to restore.
	 * @return the restored calendarItems. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteCalendarItems(calendarItems: List<CalendarItem>): List<E> =
		undeleteCalendarItemsByIds(calendarItems.map { it.toStoredDocumentIdentifier() })

	/**
	 * Modifies a calendar item. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a calendar item with update content
	 * @return the calendar item updated with the provided content and a new revision.
	 */
	suspend fun modifyCalendarItem(entity: E): E

	/**
	 * Modifies a batch of calendarItems.
	 * Flavoured method-
	 * @param entities the updated calendarItems.
	 * @return the updated calendarItems with their new revisions. If some entities couldn't be updated (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	suspend fun modifyCalendarItems(entities: List<E>): List<E>

	/**
	 * Get a calendar item by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a calendar item, or corresponds to an entity for which you don't have
	 * read access.
	 * @param entityId a calendar item id.
	 * @return the calendar item with id [entityId].
	 */
	suspend fun getCalendarItem(
		entityId: String
	): E?

	/**
	 * Get multiple calendar items by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a calendar item, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of calendar items ids
	 * @return all calendar items that you can access with one of the provided ids.
	 */
	suspend fun getCalendarItems(entityIds: List<String>): List<E>

}

interface CalendarItemBasicFlavouredInGroupApi<E : CalendarItem> {
	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.createCalendarItem].
	 */
	suspend fun createCalendarItem(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.createCalendarItems].
	 */
	suspend fun createCalendarItems(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItemById]
	 */
	suspend fun undeleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E>

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItemsByIds]
	 */
	suspend fun undeleteCalendarItemsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>>

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItem]
	 */
	suspend fun undeleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): GroupScoped<E> =
		undeleteCalendarItemById(calendarItem.toStoredDocumentIdentifier())

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItems]
	 */
	suspend fun undeleteCalendarItems(calendarItems: List<GroupScoped<E>>): List<GroupScoped<E>> =
		undeleteCalendarItemsByIds(calendarItems.map { it.toStoredDocumentIdentifier() })

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.modifyCalendarItem]
	 */
	suspend fun modifyCalendarItem(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.modifyCalendarItems]
	 */
	suspend fun modifyCalendarItems(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.getCalendarItem]
	 */
	suspend fun getCalendarItem(groupId: String, entityId: String): GroupScoped<E>?

	/**
	 * In-group version of [CalendarItemBasicFlavouredApi.getCalendarItems]
	 */
	suspend fun getCalendarItems(groupId: String, entityIds: List<String>): List<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface CalendarItemFlavouredApi<E : CalendarItem> : CalendarItemBasicFlavouredApi<E> {
	/**
	 * Share a calendar item with another data owner. The calendar item must already exist in the database for this method to
	 * succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * @param delegateId the owner that will gain access to the calendar item
	 * @param calendarItem the calendar item to share with [delegateId]
	 * @param options specifies how the calendar item will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the calendar item. Refer
	 * to the documentation of [CalendarItemShareOptions] for more information.
	 * @return the updated calendar item
	 */
	suspend fun shareWith(
		delegateId: String,
		calendarItem: E,
		@DefaultValue("null")
		options: CalendarItemShareOptions? = null
	): E

	/**
	 * Share a calendar item with multiple data owners. The calendar item must already exist in the database for this method to
	 * succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * Throws an exception if the operation fails.
	 * @param calendarItem the calendar item to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated calendar item.
	 */
	suspend fun shareWithMany(
		calendarItem: E,
		delegates: Map<String, CalendarItemShareOptions>
	): E

	/**
	 * Links a calendar item with a patient. Note that this operation is not reversible: it is not possible to change the patient linked to a calendar
	 * item.
	 * @param calendarItem a calendar item.
	 * @param patient the patient which will be linked to the calendar item.
	 * @param shareLinkWithDelegates data owners other than the current data owner which will also be able to decrypt the id of the newly linked
	 * patient. If any of these data owners do not already have access to the calendar item, they will be granted read access (no write).
	 * @return the updated calendar item.
	 */
	suspend fun linkToPatient(calendarItem: CalendarItem, patient: Patient, shareLinkWithDelegates: Set<String>): E

	/**
	 * Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterCalendarItemsBySorted] instead.
	 *
	 * @param filter a calendarItem filter
	 * @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	suspend fun filterCalendarItemsBy(
		filter: FilterOptions<CalendarItem>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterCalendarItemsBy].
	 *
	 * @param filter a calendarItem filter
	 * @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	suspend fun filterCalendarItemsBySorted(
		filter: SortableFilterOptions<CalendarItem>
	): PaginatedListIterator<E>
}

interface CalendarItemFlavouredInGroupApi<E : CalendarItem> : CalendarItemBasicFlavouredInGroupApi<E> {
	/**
	 * In-group version of [CalendarItemFlavouredApi.shareWith]
	 */
	suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		calendarItem: GroupScoped<E>,
		@DefaultValue("null")
		options: CalendarItemShareOptions? = null
	): GroupScoped<E>

	/**
	 * In-group version of [CalendarItemFlavouredApi.shareWithMany]
	 */
	suspend fun shareWithMany(
		calendarItem: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, CalendarItemShareOptions>
	): GroupScoped<E>

	/**
	 * In-group version of [CalendarItemFlavouredApi.linkToPatient]
	 */
	// TODO? suspend fun linkToPatient(calendarItem: CalendarItem, patient: Patient, shareLinkWithDelegates: Set<String>): E

	/**
	 * In-group version of [CalendarItemFlavouredApi.filterCalendarItemsBy]
	 */
	suspend fun filterCalendarItemsBy(groupId: String, filter: FilterOptions<CalendarItem>): PaginatedListIterator<GroupScoped<E>>

	/**
	 * In-group version of [CalendarItemFlavouredApi.filterCalendarItemsBySorted]
	 */
	suspend fun filterCalendarItemsBySorted(groupId: String, filter: SortableFilterOptions<CalendarItem>): PaginatedListIterator<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface CalendarItemApi : CalendarItemBasicFlavourlessApi, CalendarItemFlavouredApi<DecryptedCalendarItem>,
	Subscribable<CalendarItem, EncryptedCalendarItem, FilterOptions<CalendarItem>> {

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: CalendarItemFlavouredApi<CalendarItem>

	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: CalendarItemInGroupApi

	/**
	 * Creates a new calendar item entity with initialized encryption metadata.
	 * NOTE: this method doesn't send the entity to the backend, to store it you will need to pass the entity to the
	 * [createCalendarItem] method.
	 * @param base a calendar item with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the calendar item.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new calendar item
	 * @return a calendar item with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedCalendarItem?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedCalendarItem

	/**
	 * Attempts to extract the encryption keys of a calendar item. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param calendarItem a calendar item
	 * @return the encryption keys extracted from the provided calendar item.
	 */
	suspend fun getEncryptionKeysOf(calendarItem: CalendarItem): Set<HexString>

	/**
	 * Specifies if the current user has write access to a calendar item through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 * side this method will still return true if there is a delegation to the parent.
	 * @param calendarItem a calendar item
	 * @return if the current user has write access to the provided calendar item
	 */
	suspend fun hasWriteAccess(calendarItem: CalendarItem): Boolean

	/**
	 * Attempts to extract the patient id linked to a calendar item.
	 * Note: calendar items usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param calendarItem a calendar item
	 * @return the id of the patient linked to the calendar item, or empty if the current user can't access any patient id
	 * of the calendar item.
	 */
	suspend fun decryptPatientIdOf(calendarItem: CalendarItem): Set<EntityReferenceInGroup>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a calendar item.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided calendar item. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the calendar item the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any CalendarItem,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a calendar item E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any calendar item that you have shared with P, H will be able to know that the calendar item was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a calendar item that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a calendar item
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: CalendarItem, delegates: Set<String>)

	/**
	 * Decrypts CalendarItems, throwing an exception if it is not possible.
	 * @param calendarItems encrypted CalendarItems
	 * @return the decrypted CalendarItems
	 * @throws EntityEncryptionException if any of the provided CalendarItems couldn't be decrypted
	 */
	suspend fun decrypt(calendarItems: List<EncryptedCalendarItem>): List<DecryptedCalendarItem>

	/**
	 * Tries to decrypt a CalendarItem, returns the input if it is not possible.
	 * @param calendarItems encrypted CalendarItems
	 * @return all the provided CalendarItems, each of them decrypted if possible or unchanged (still encrypted)
	 */
	suspend fun tryDecrypt(calendarItems: List<EncryptedCalendarItem>): List<CalendarItem>

	/**
	 * Encrypts provided decrypted CalendarItems, and validates already encrypted CalendarItems.
	 * @param calendarItems CalendarItems to encrypt and/or validate
	 * @return the encrypted and validates CalendarItems
	 * @throws EntityEncryptionException if any of the provided decrypted CalendarItems couldn't be encrypted (the current
	 * user can't access its encryption key or no key was initialized) or if the already encrypted CalendarItems don't
	 * respect the manifest.
	 */
	suspend fun encryptOrValidate(calendarItems: List<CalendarItem>): List<EncryptedCalendarItem>

	/**
	 * Get the ids of all calendarItems matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchCalendarItemsBySorted] instead.
	 *
	 * @param filter a calendarItem filter
	 * @return a list of calendarItem ids
	 */
	suspend fun matchCalendarItemsBy(filter: FilterOptions<CalendarItem>): List<String>

	/**
	 * Get the ids of all calendarItems matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchCalendarItemsBy].
	 *
	 * @param filter a calendarItem filter
	 * @return a list of calendarItem ids
	 */
	suspend fun matchCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): List<String>
}

interface CalendarItemInGroupApi : CalendarItemBasicFlavourlessInGroupApi, CalendarItemFlavouredInGroupApi<DecryptedCalendarItem> { // TODO subscribable?
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: CalendarItemFlavouredInGroupApi<EncryptedCalendarItem>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: CalendarItemFlavouredInGroupApi<CalendarItem>

	/**
	 * In-group version of [CalendarItemApi.withEncryptionMetadata]
	 */
	suspend fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedCalendarItem?,
		patient: GroupScoped<Patient>?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
		@DefaultValue("null")
		alternateRootDelegateReference: EntityReferenceInGroup? = null,
	): GroupScoped<DecryptedCalendarItem>

	/**
	 * In-group version of [CalendarItemApi.getEncryptionKeysOf]
	 */
	suspend fun getEncryptionKeysOf(calendarItem: GroupScoped<CalendarItem>): Set<HexString>

	/**
	 * In-group version of [CalendarItemApi.hasWriteAccess]
	 */
	suspend fun hasWriteAccess(calendarItem: GroupScoped<CalendarItem>): Boolean

	/**
	 * In-group version of [CalendarItemApi.decryptPatientIdOf]
	 */
	suspend fun decryptPatientIdOf(calendarItem: GroupScoped<CalendarItem>): Set<EntityReferenceInGroup>

	/**
	 * In-group version of [CalendarItemApi.createDelegationDeAnonymizationMetadata]
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: GroupScoped<CalendarItem>, delegates: Set<EntityReferenceInGroup>)

	/**
	 * In-group version of [CalendarItemApi.decrypt]
	 */
	suspend fun decrypt(calendarItems: List<GroupScoped<EncryptedCalendarItem>>): List<GroupScoped<DecryptedCalendarItem>>

	/**
	 * In-group version of [CalendarItemApi.tryDecrypt]
	 */
	suspend fun tryDecrypt(calendarItems: List<GroupScoped<EncryptedCalendarItem>>): List<GroupScoped<CalendarItem>>

	/**
	 * In-group version of [CalendarItemApi.encryptOrValidate]
	 */
	suspend fun encryptOrValidate(calendarItems: List<GroupScoped<CalendarItem>>): List<GroupScoped<EncryptedCalendarItem>>

	/**
	 * In-group version of [CalendarItemApi.matchCalendarItemsBy]
	 */
	suspend fun matchCalendarItemsBy(groupId: String, filter: FilterOptions<CalendarItem>): List<String>

	/**
	 * In-group version of [CalendarItemApi.matchCalendarItemsBySorted]
	 */
	 suspend fun matchCalendarItemsBySorted(groupId: String, filter: SortableFilterOptions<CalendarItem>): List<String>
}

interface CalendarItemBasicApi : CalendarItemBasicFlavourlessApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem>,
	Subscribable<CalendarItem, EncryptedCalendarItem, FilterOptions<CalendarItem>> {

	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: CalendarItemBasicInGroupApi

	/**
	 * Get the ids of all calendarItems matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchCalendarItemsBySorted] instead.
	 *
	 * @param filter a calendarItem filter
	 * @return a list of calendarItem ids
	 */
	suspend fun matchCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): List<String>

	/**
	 * Get the ids of all calendarItems matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchCalendarItemsBy].
	 *
	 * @param filter a calendarItem filter
	 * @return a list of calendarItem ids
	 */
	suspend fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): List<String>

	/**
	 * Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterCalendarItemsBySorted] instead.
	 *
	 * @param filter a calendarItem filter
	 * @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	suspend fun filterCalendarItemsBy(
		filter: BaseFilterOptions<CalendarItem>
	): PaginatedListIterator<EncryptedCalendarItem>

	/**
	 * Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterCalendarItemsBy].
	 *
	 * @param filter a calendarItem filter
	 * @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	suspend fun filterCalendarItemsBySorted(
		filter: BaseSortableFilterOptions<CalendarItem>
	): PaginatedListIterator<EncryptedCalendarItem>
}

interface CalendarItemBasicInGroupApi : CalendarItemBasicFlavourlessInGroupApi, CalendarItemBasicFlavouredInGroupApi<EncryptedCalendarItem> { // TODO subscribable
	/**
	 * In-group version of [CalendarItemBasicApi.matchCalendarItemsBy]
	 */
	suspend fun matchCalendarItemsBy(groupId: String, filter: BaseFilterOptions<CalendarItem>): List<String>

	/**
	 * In-group version of [CalendarItemBasicApi.matchCalendarItemsBySorted]
	 */
	suspend fun matchCalendarItemsBySorted(groupId: String, filter: BaseSortableFilterOptions<CalendarItem>): List<String>

	/**
	 * In-group version of [CalendarItemBasicApi.filterCalendarItemsBy]
	 */
	 suspend fun filterCalendarItemsBy(groupId: String, filter: BaseFilterOptions<CalendarItem>): PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>

	/**
	 * In-group version of [CalendarItemBasicApi.filterCalendarItemsBySorted]
	 */
	suspend fun filterCalendarItemsBySorted(groupId: String, filter: BaseSortableFilterOptions<CalendarItem>): PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>
}
