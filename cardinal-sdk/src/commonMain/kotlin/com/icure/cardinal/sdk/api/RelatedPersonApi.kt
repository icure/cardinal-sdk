package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.RelatedPersonDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonShareOptions
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.RelatedPerson
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
interface RelatedPersonBasicFlavourlessApi {

	/**
	 * Deletes a relatedPerson. If you don't have write access to the relatedPerson the method will fail.
	 * @param entityId id of the relatedPerson.
	 * @param rev the latest known rev of the relatedPerson to delete
	 * @return the id and revision of the deleted relatedPerson.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteRelatedPersonById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many relatedPersons. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the relatedPersons to delete.
	 * @return the id and revision of the deleted relatedPersons. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteRelatedPersonsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a relatedPerson.
	 * @param id id of the relatedPerson to purge
	 * @param rev latest revision of the relatedPerson
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeRelatedPersonById(id: String, rev: String)

	/**
	 * Permanently deletes many relatedPersons.
	 * @param entityIds ids and revisions of the relatedPersons to delete
	 * @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeRelatedPersonsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Deletes a relatedPerson. If you don't have write access to the relatedPerson the method will fail.
	 * @param relatedPerson the relatedPerson to delete
	 * @return the id and revision of the deleted relatedPerson.
	 * @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	suspend fun deleteRelatedPerson(relatedPerson: RelatedPerson): StoredDocumentIdentifier =
		deleteRelatedPersonById(relatedPerson.id, requireNotNull(relatedPerson.rev) { "Can't delete a relatedPerson that has no rev" })

	/**
	 * Deletes many relatedPersons. Ignores relatedPerson for which you don't have write access or that don't match the latest revision.
	 * @param relatedPersons the relatedPersons to delete
	 * @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteRelatedPersons(relatedPersons: List<RelatedPerson>): List<StoredDocumentIdentifier> =
		deleteRelatedPersonsByIds(relatedPersons.map { relatedPerson ->
			relatedPerson.toStoredDocumentIdentifier()
		})

	/**
	 * Permanently deletes a relatedPerson.
	 * @param relatedPerson the relatedPerson to purge.
	 * @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	suspend fun purgeRelatedPerson(relatedPerson: RelatedPerson) {
		purgeRelatedPersonById(relatedPerson.id, requireNotNull(relatedPerson.rev) { "Can't delete a relatedPerson that has no rev" })
	}

	/**
	 * Permanently deletes many relatedPersons.
	 * @param relatedPersons the relatedPersons to purge.
	 * @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeRelatedPersons(relatedPersons: List<RelatedPerson>): List<StoredDocumentIdentifier> =
		purgeRelatedPersonsByIds(relatedPersons.map { it.toStoredDocumentIdentifier() })
}

interface RelatedPersonBasicFlavourlessInGroupApi {
	/**
	 * In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersonById]
	 */
	suspend fun deleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>

	/**
	 * In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersonsByIds]
	 */
	suspend fun deleteRelatedPersonsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersonById]
	 */
	suspend fun purgeRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>)

	/**
	 * In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersonsByIds]
	 */
	suspend fun purgeRelatedPersonsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPerson]
	 */
	suspend fun deleteRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): GroupScoped<StoredDocumentIdentifier> =
		deleteRelatedPersonById(relatedPerson.toStoredDocumentIdentifier())

	/**
	 * In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersons]
	 */
	suspend fun deleteRelatedPersons(relatedPersons: List<GroupScoped<RelatedPerson>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteRelatedPersonsByIds(relatedPersons.toStoredDocumentIdentifier())

	/**
	 * In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPerson]
	 */
	suspend fun purgeRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>) {
		purgeRelatedPersonById(relatedPerson.toStoredDocumentIdentifier())
	}

	/**
	 * In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersons]
	 */
	suspend fun purgeRelatedPersons(relatedPersons: List<GroupScoped<RelatedPerson>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeRelatedPersonsByIds(relatedPersons.map { it.toStoredDocumentIdentifier() })
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface RelatedPersonBasicFlavouredApi<E : RelatedPerson> {
	/**
	 * Create a new related person. The provided related person must have the encryption metadata initialized.
	 * @param entity a related person with initialized encryption metadata
	 * @return the created related person with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createRelatedPerson(entity: E): E

	/**
	 * Create multiple related persons. All the provided related persons must have the encryption metadata initialized,
	 * otherwise this method fails without doing anything.
	 * @param entities related persons with initialized encryption metadata
	 * @return the created related persons with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any related person in the input was not initialized.
	 */
	suspend fun createRelatedPersons(entities: List<E>): List<E>

	/**
	 * Restores a relatedPerson that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteRelatedPersonById(id: String, rev: String): E

	/**
	 * Restores a batch of relatedPersons that were marked as deleted.
	 * @param entityIds the ids and the revisions of the relatedPersons to restore.
	 * @return the restored relatedPersons. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteRelatedPersonsByIds(entityIds: List<StoredDocumentIdentifier>): List<E>

	/**
	 * Restores a relatedPerson that was marked as deleted.
	 * @param relatedPerson the relatedPerson to undelete
	 * @return the restored relatedPerson.
	 * @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	suspend fun undeleteRelatedPerson(relatedPerson: RelatedPerson): E =
		undeleteRelatedPersonById(relatedPerson.id, requireNotNull(relatedPerson.rev) { "Can't undelete a relatedPerson that has no rev" })

	/**
	 * Restores a batch of relatedPersons that were marked as deleted.
	 * @param relatedPersons the relatedPersons to restore.
	 * @return the restored relatedPersons. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteRelatedPersons(relatedPersons: List<RelatedPerson>): List<E> =
		undeleteRelatedPersonsByIds(relatedPersons.map { it.toStoredDocumentIdentifier() })

	/**
	 * Modifies a related person. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a related person with update content
	 * @return the related person updated with the provided content and a new revision.
	 */
	suspend fun modifyRelatedPerson(entity: E): E

	/**
	 * Modifies multiple related persons. Ignores all related persons for which you don't have write access.
	 * Flavoured method.
	 * @param entities related persons with update content
	 * @return the updated related persons with a new revision.
	 */
	suspend fun modifyRelatedPersons(entities: List<E>): List<E>

	/**
	 * Get a related person by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a related person, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a related person id.
	 * @return the related person with id [entityId].
	 */
	suspend fun getRelatedPerson(entityId: String): E?

	/**
	 * Get multiple related persons by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a related person, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of related persons ids
	 * @return all related persons that you can access with one of the provided ids.
	 */
	suspend fun getRelatedPersons(entityIds: List<String>): List<E>
}

interface RelatedPersonBasicFlavouredInGroupApi<E : RelatedPerson> {
	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.createRelatedPerson]
	 */
	suspend fun createRelatedPerson(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.createRelatedPersons]
	 */
	suspend fun createRelatedPersons(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersonById]
	 */
	suspend fun undeleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E>

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersonsByIds]
	 */
	suspend fun undeleteRelatedPersonsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>>

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPerson]
	 */
	suspend fun undeleteRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): GroupScoped<E> =
		undeleteRelatedPersonById(relatedPerson.toStoredDocumentIdentifier())

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersons]
	 */
	suspend fun undeleteRelatedPersons(relatedPersons: List<GroupScoped<E>>): List<GroupScoped<E>> =
		undeleteRelatedPersonsByIds(relatedPersons.map { it.toStoredDocumentIdentifier() })

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.modifyRelatedPerson]
	 */
	suspend fun modifyRelatedPerson(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.modifyRelatedPersons]
	 */
	suspend fun modifyRelatedPersons(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.getRelatedPerson]
	 */
	suspend fun getRelatedPerson(groupId: String, entityId: String): GroupScoped<E>?

	/**
	 * In-group version of [RelatedPersonBasicFlavouredApi.getRelatedPersons]
	 */
	suspend fun getRelatedPersons(groupId: String, entityIds: List<String>): List<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface RelatedPersonFlavouredApi<E : RelatedPerson> : RelatedPersonBasicFlavouredApi<E> {
	/**
	 * Share a related person with another data owner. The related person must already exist in the database for this method to
	 * succeed. If you want to share the related person before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * @param delegateId the owner that will gain access to the related person
	 * @param relatedPerson the related person to share with [delegateId]
	 * @param options specifies how the related person will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the related person. Refer
	 * to the documentation of [RelatedPersonShareOptions] for more information.
	 * @return the updated related person if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		relatedPerson: E,
		@DefaultValue("null")
		options: RelatedPersonShareOptions? = null
	): E

	/**
	 * Share a related person with multiple data owners. The related person must already exist in the database for this method to
	 * succeed. If you want to share the related person before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * Throws an exception if the operation fails.
	 * @param relatedPerson the related person to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated related person.
	 */
	suspend fun shareWithMany(
		relatedPerson: E,
		delegates: Map<String, RelatedPersonShareOptions>
	): E

	/**
	 * Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterRelatedPersonsBySorted] instead.
	 *
	 * @param filter a related person filter
	 * @return an iterator that iterates over all related persons matching the provided filter.
	 */
	suspend fun filterRelatedPersonsBy(
		filter: FilterOptions<RelatedPerson>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterRelatedPersonsBy].
	 *
	 * @param filter a related person filter
	 * @return an iterator that iterates over all related persons matching the provided filter.
	 */
	suspend fun filterRelatedPersonsBySorted(
		filter: SortableFilterOptions<RelatedPerson>
	): PaginatedListIterator<E>
}

interface RelatedPersonFlavouredInGroupApi<E : RelatedPerson> : RelatedPersonBasicFlavouredInGroupApi<E> {
	/**
	 * In-group version of [RelatedPersonFlavouredApi.shareWith]
	 */
	suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		relatedPerson: GroupScoped<E>,
		@DefaultValue("null")
		options: RelatedPersonShareOptions? = null
	): GroupScoped<E>

	/**
	 * In-group version of [RelatedPersonFlavouredApi.shareWithMany]
	 */
	suspend fun shareWithMany(
		relatedPerson: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, RelatedPersonShareOptions>
	): GroupScoped<E>

	/**
	 * In-group version of [RelatedPersonFlavouredApi.filterRelatedPersonsBy]
	 */
	suspend fun filterRelatedPersonsBy(groupId: String, filter: FilterOptions<RelatedPerson>): PaginatedListIterator<GroupScoped<E>>

	/**
	 * In-group version of [RelatedPersonFlavouredApi.filterRelatedPersonsBySorted]
	 */
	suspend fun filterRelatedPersonsBySorted(groupId: String, filter: SortableFilterOptions<RelatedPerson>): PaginatedListIterator<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface RelatedPersonApi : RelatedPersonBasicFlavourlessApi, RelatedPersonFlavouredApi<DecryptedRelatedPerson>, Subscribable<RelatedPerson, EncryptedRelatedPerson, FilterOptions<RelatedPerson>> {
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: RelatedPersonFlavouredApi<EncryptedRelatedPerson>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: RelatedPersonFlavouredApi<RelatedPerson>

	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: RelatedPersonInGroupApi

	/**
	 * Creates a new related person with initialized encryption metadata.
	 *
	 * A related person is a root entity: it isn't linked to any owning entity, and it has its own secret ids.
	 *
	 * @param base a related person with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @return a related person with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedRelatedPerson?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedRelatedPerson

	/**
	 * Creates a new related person with initialized encryption metadata, specifying fine-grained options for each
	 * additional data owner that will have access to the entity.
	 * @param base a related person with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity and if they will have access to the secretIds and/or
	 * encryptionKeys of the new entity.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @return a related person with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadataAndDelegates(
		base: DecryptedRelatedPerson?,
		delegates: Map<String, RelatedPersonDelegateOptions>,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedRelatedPerson

	/**
	 * Attempts to extract the encryption keys of a related person. If the user does not have access to any encryption key
	 * of the related person the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param relatedPerson a related person
	 * @return the encryption keys extracted from the provided related person.
	 */
	suspend fun getEncryptionKeysOf(relatedPerson: RelatedPerson): Set<HexString>

	/**
	 * Specifies if the current user has write access to a related person through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 * side this method will still return true if there is a delegation to the parent.
	 * @param relatedPerson a related person
	 * @return if the current user has write access to the provided related person
	 */
	suspend fun hasWriteAccess(relatedPerson: RelatedPerson): Boolean

	/**
	 * Attempts to extract the secret ids of a related person. Since a related person is a root entity these secret ids
	 * may be used to link other entities to it.
	 * @param relatedPerson a related person
	 * @return the secret ids of the provided related person that the current user can access.
	 */
	suspend fun getSecretIdsOf(relatedPerson: RelatedPerson): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a related person.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided related person. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the related person the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any RelatedPerson,
	 * not only in the provided instance.
	 *
	 * @param entity a related person
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: RelatedPerson, delegates: Set<String>)

	/**
	 * Decrypts RelatedPersons, throwing an exception if it is not possible.
	 * @param relatedPersons encrypted RelatedPersons
	 * @return the decrypted RelatedPersons
	 * @throws EntityEncryptionException if any of the provided RelatedPersons couldn't be decrypted
	 */
	suspend fun decrypt(relatedPersons: List<EncryptedRelatedPerson>): List<DecryptedRelatedPerson>

	/**
	 * Tries to decrypt a RelatedPerson, returns the input if it is not possible.
	 * @param relatedPersons encrypted RelatedPersons
	 * @return all the provided RelatedPersons, each of them decrypted if possible or unchanged (still encrypted)
	 */
	suspend fun tryDecrypt(relatedPersons: List<EncryptedRelatedPerson>): List<RelatedPerson>

	/**
	 * Encrypts provided decrypted RelatedPersons, and validates already encrypted RelatedPersons.
	 * @param relatedPersons RelatedPersons to encrypt and/or validate
	 * @return the encrypted and validates RelatedPersons
	 * @throws EntityEncryptionException if any of the provided decrypted RelatedPersons couldn't be encrypted (the current
	 * user can't access its encryption key or no key was initialized) or if the already encrypted RelatedPersons don't
	 * respect the manifest.
	 */
	suspend fun encryptOrValidate(relatedPersons: List<RelatedPerson>): List<EncryptedRelatedPerson>

	/**
	 * Get the ids of all related persons matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchRelatedPersonsBySorted] instead.
	 *
	 * @param filter a related person filter
	 * @return a list of related person ids
	 */
	suspend fun matchRelatedPersonsBy(filter: FilterOptions<RelatedPerson>): List<String>

	/**
	 * Get the ids of all related persons matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchRelatedPersonsBy].
	 *
	 * @param filter a related person filter
	 * @return a list of related person ids
	 */
	suspend fun matchRelatedPersonsBySorted(filter: SortableFilterOptions<RelatedPerson>): List<String>
}

interface RelatedPersonInGroupApi : RelatedPersonBasicFlavourlessInGroupApi, RelatedPersonFlavouredInGroupApi<DecryptedRelatedPerson> { // TODO subscribable
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: RelatedPersonFlavouredInGroupApi<EncryptedRelatedPerson>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: RelatedPersonFlavouredInGroupApi<RelatedPerson>

	/**
	 * In-group version of [RelatedPersonApi.withEncryptionMetadata]
	 */
	suspend fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedRelatedPerson?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
		@DefaultValue("null")
		alternateRootDelegateReference: EntityReferenceInGroup? = null,
	): GroupScoped<DecryptedRelatedPerson>

	/**
	 * In-group version of [RelatedPersonApi.withEncryptionMetadataAndDelegates]
	 */
	suspend fun withEncryptionMetadataAndDelegates(
		entityGroupId: String,
		base: DecryptedRelatedPerson?,
		delegates: @JsMapAsObjectArray(
			keyEntryName = "delegate",
			valueEntryName = "delegateOptions"
		) Map<EntityReferenceInGroup, RelatedPersonDelegateOptions>,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("null")
		alternateRootDelegateReference: EntityReferenceInGroup? = null,
	): GroupScoped<DecryptedRelatedPerson>

	/**
	 * In-group version of [RelatedPersonApi.getEncryptionKeysOf]
	 */
	suspend fun getEncryptionKeysOf(relatedPerson: GroupScoped<RelatedPerson>): Set<HexString>

	/**
	 * In-group version of [RelatedPersonApi.hasWriteAccess]
	 */
	suspend fun hasWriteAccess(relatedPerson: GroupScoped<RelatedPerson>): Boolean

	/**
	 * In-group version of [RelatedPersonApi.getSecretIdsOf]
	 */
	suspend fun getSecretIdsOf(relatedPerson: GroupScoped<RelatedPerson>): Set<String>

	/**
	 * In-group version of [RelatedPersonApi.createDelegationDeAnonymizationMetadata]
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: GroupScoped<RelatedPerson>, delegates: Set<EntityReferenceInGroup>)

	/**
	 * In-group version of [RelatedPersonApi.decrypt]
	 */
	suspend fun decrypt(relatedPersons: List<GroupScoped<EncryptedRelatedPerson>>): List<GroupScoped<DecryptedRelatedPerson>>

	/**
	 * In-group version of [RelatedPersonApi.tryDecrypt]
	 */
	suspend fun tryDecrypt(relatedPersons: List<GroupScoped<EncryptedRelatedPerson>>): List<GroupScoped<RelatedPerson>>

	/**
	 * In-group version of [RelatedPersonApi.encryptOrValidate]
	 */
	suspend fun encryptOrValidate(relatedPersons: List<GroupScoped<RelatedPerson>>): List<GroupScoped<EncryptedRelatedPerson>>

	/**
	 * In-group version of [RelatedPersonApi.matchRelatedPersonsBy]
	 */
	suspend fun matchRelatedPersonsBy(groupId: String, filter: FilterOptions<RelatedPerson>): List<String>

	/**
	 * In-group version of [RelatedPersonApi.matchRelatedPersonsBySorted]
	 */
	suspend fun matchRelatedPersonsBySorted(groupId: String, filter: SortableFilterOptions<RelatedPerson>): List<String>
}

interface RelatedPersonBasicApi : RelatedPersonBasicFlavourlessApi, RelatedPersonBasicFlavouredApi<EncryptedRelatedPerson> {
	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: RelatedPersonBasicInGroupApi

	/**
	 * Get the ids of all related persons matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchRelatedPersonsBySorted] instead.
	 *
	 * @param filter a related person filter
	 * @return a list of related person ids
	 */
	suspend fun matchRelatedPersonsBy(filter: BaseFilterOptions<RelatedPerson>): List<String>

	/**
	 * Get the ids of all related persons matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchRelatedPersonsBy].
	 *
	 * @param filter a related person filter
	 * @return a list of related person ids
	 */
	suspend fun matchRelatedPersonsBySorted(filter: BaseSortableFilterOptions<RelatedPerson>): List<String>

	/**
	 * Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterRelatedPersonsBySorted] instead.
	 *
	 * @param filter a related person filter
	 * @return an iterator that iterates over all related persons matching the provided filter.
	 */
	suspend fun filterRelatedPersonsBy(
		filter: BaseFilterOptions<RelatedPerson>
	): PaginatedListIterator<EncryptedRelatedPerson>

	/**
	 * Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterRelatedPersonsBy].
	 *
	 * @param filter a related person filter
	 * @return an iterator that iterates over all related persons matching the provided filter.
	 */
	suspend fun filterRelatedPersonsBySorted(
		filter: BaseSortableFilterOptions<RelatedPerson>
	): PaginatedListIterator<EncryptedRelatedPerson>
}

interface RelatedPersonBasicInGroupApi : RelatedPersonBasicFlavourlessInGroupApi, RelatedPersonBasicFlavouredInGroupApi<EncryptedRelatedPerson> { // TODO subscribable
	/**
	 * In-group version of [RelatedPersonBasicApi.matchRelatedPersonsBy]
	 */
	suspend fun matchRelatedPersonsBy(groupId: String, filter: BaseFilterOptions<RelatedPerson>): List<String>

	/**
	 * In-group version of [RelatedPersonBasicApi.matchRelatedPersonsBySorted]
	 */
	suspend fun matchRelatedPersonsBySorted(groupId: String, filter: BaseSortableFilterOptions<RelatedPerson>): List<String>

	/**
	 * In-group version of [RelatedPersonBasicApi.filterRelatedPersonsBy]
	 */
	suspend fun filterRelatedPersonsBy(groupId: String, filter: BaseFilterOptions<RelatedPerson>): PaginatedListIterator<GroupScoped<EncryptedRelatedPerson>>

	/**
	 * In-group version of [RelatedPersonBasicApi.filterRelatedPersonsBySorted]
	 */
	suspend fun filterRelatedPersonsBySorted(groupId: String, filter: BaseSortableFilterOptions<RelatedPerson>): PaginatedListIterator<GroupScoped<EncryptedRelatedPerson>>
}
