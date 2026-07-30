// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {RelatedPersonDelegateOptions} from '../crypto/entities/RelatedPersonDelegateOptions.mjs';
import {RelatedPersonShareOptions} from '../crypto/entities/RelatedPersonShareOptions.mjs';
import {DecryptedRelatedPerson, EncryptedRelatedPerson, RelatedPerson} from '../model/RelatedPerson.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {RelatedPersonFlavouredApi} from './RelatedPersonFlavouredApi.mjs';
import {RelatedPersonInGroupApi} from './RelatedPersonInGroupApi.mjs';


export interface RelatedPersonApi {

	encrypted: RelatedPersonFlavouredApi<EncryptedRelatedPerson>;

	tryAndRecover: RelatedPersonFlavouredApi<RelatedPerson>;

	inGroup: RelatedPersonInGroupApi;

	/**
	 *
	 *  Creates a new related person with initialized encryption metadata.
	 *
	 *  A related person is a root entity: it isn't linked to any owning entity, and it has its own secret ids.
	 *
	 *  @param base a related person with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @return a related person with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedRelatedPerson | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, alternateRootDelegateId?: string | undefined }): Promise<DecryptedRelatedPerson>;

	/**
	 *
	 *  Creates a new related person with initialized encryption metadata, specifying fine-grained options for each
	 *  additional data owner that will have access to the entity.
	 *  @param base a related person with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity and if they will have access to the secretIds and/or
	 *  encryptionKeys of the new entity.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @return a related person with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadataAndDelegates(base: DecryptedRelatedPerson | undefined,
			delegates: { [ key: string ]: RelatedPersonDelegateOptions },
			options?: { user?: User | undefined, alternateRootDelegateId?: string | undefined }): Promise<DecryptedRelatedPerson>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a related person. If the user does not have access to any encryption key
	 *  of the related person the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param relatedPerson a related person
	 *  @return the encryption keys extracted from the provided related person.
	 */
	getEncryptionKeysOf(relatedPerson: RelatedPerson): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a related person through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param relatedPerson a related person
	 *  @return if the current user has write access to the provided related person
	 */
	hasWriteAccess(relatedPerson: RelatedPerson): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the secret ids of a related person. Since a related person is a root entity these secret ids
	 *  may be used to link other entities to it.
	 *  @param relatedPerson a related person
	 *  @return the secret ids of the provided related person that the current user can access.
	 */
	getSecretIdsOf(relatedPerson: RelatedPerson): Promise<Array<string>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a related person.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided related person. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the related person the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any RelatedPerson,
	 *  not only in the provided instance.
	 *
	 *  @param entity a related person
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: RelatedPerson,
			delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts RelatedPersons, throwing an exception if it is not possible.
	 *  @param relatedPersons encrypted RelatedPersons
	 *  @return the decrypted RelatedPersons
	 *  @throws EntityEncryptionException if any of the provided RelatedPersons couldn't be decrypted
	 */
	decrypt(relatedPersons: Array<EncryptedRelatedPerson>): Promise<Array<DecryptedRelatedPerson>>;

	/**
	 *
	 *  Tries to decrypt a RelatedPerson, returns the input if it is not possible.
	 *  @param relatedPersons encrypted RelatedPersons
	 *  @return all the provided RelatedPersons, each of them decrypted if possible or unchanged (still encrypted)
	 */
	tryDecrypt(relatedPersons: Array<EncryptedRelatedPerson>): Promise<Array<RelatedPerson>>;

	/**
	 *
	 *  Encrypts provided decrypted RelatedPersons, and validates already encrypted RelatedPersons.
	 *  @param relatedPersons RelatedPersons to encrypt and/or validate
	 *  @return the encrypted and validates RelatedPersons
	 *  @throws EntityEncryptionException if any of the provided decrypted RelatedPersons couldn't be encrypted (the current
	 *  user can't access its encryption key or no key was initialized) or if the already encrypted RelatedPersons don't
	 *  respect the manifest.
	 */
	encryptOrValidate(relatedPersons: Array<RelatedPerson>): Promise<Array<EncryptedRelatedPerson>>;

	/**
	 *
	 *  Get the ids of all related persons matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchRelatedPersonsBySorted] instead.
	 *
	 *  @param filter a related person filter
	 *  @return a list of related person ids
	 */
	matchRelatedPersonsBy(filter: FilterOptions<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all related persons matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchRelatedPersonsBy].
	 *
	 *  @param filter a related person filter
	 *  @return a list of related person ids
	 */
	matchRelatedPersonsBySorted(filter: SortableFilterOptions<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  Deletes a relatedPerson. If you don't have write access to the relatedPerson the method will fail.
	 *  @param entityId id of the relatedPerson.
	 *  @param rev the latest known rev of the relatedPerson to delete
	 *  @return the id and revision of the deleted relatedPerson.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteRelatedPersonById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many relatedPersons. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the relatedPersons to delete.
	 *  @return the id and revision of the deleted relatedPersons. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a relatedPerson.
	 *  @param id id of the relatedPerson to purge
	 *  @param rev latest revision of the relatedPerson
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeRelatedPersonById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many relatedPersons.
	 *  @param entityIds ids and revisions of the relatedPersons to delete
	 *  @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a relatedPerson. If you don't have write access to the relatedPerson the method will fail.
	 *  @param relatedPerson the relatedPerson to delete
	 *  @return the id and revision of the deleted relatedPerson.
	 *  @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	deleteRelatedPerson(relatedPerson: RelatedPerson): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many relatedPersons. Ignores relatedPerson for which you don't have write access or that don't match the latest revision.
	 *  @param relatedPersons the relatedPersons to delete
	 *  @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteRelatedPersons(relatedPersons: Array<RelatedPerson>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a relatedPerson.
	 *  @param relatedPerson the relatedPerson to purge.
	 *  @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	purgeRelatedPerson(relatedPerson: RelatedPerson): Promise<void>;

	/**
	 *
	 *  Permanently deletes many relatedPersons.
	 *  @param relatedPersons the relatedPersons to purge.
	 *  @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeRelatedPersons(relatedPersons: Array<RelatedPerson>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Share a related person with another data owner. The related person must already exist in the database for this method to
	 *  succeed. If you want to share the related person before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the related person
	 *  @param relatedPerson the related person to share with [delegateId]
	 *  @param options specifies how the related person will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the related person. Refer
	 *  to the documentation of [RelatedPersonShareOptions] for more information.
	 *  @return the updated related person if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, relatedPerson: DecryptedRelatedPerson,
			options?: { options?: RelatedPersonShareOptions | undefined }): Promise<DecryptedRelatedPerson>;

	/**
	 *
	 *  Share a related person with multiple data owners. The related person must already exist in the database for this method to
	 *  succeed. If you want to share the related person before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param relatedPerson the related person to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated related person.
	 */
	shareWithMany(relatedPerson: DecryptedRelatedPerson,
			delegates: { [ key: string ]: RelatedPersonShareOptions }): Promise<DecryptedRelatedPerson>;

	/**
	 *
	 *  Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterRelatedPersonsBySorted] instead.
	 *
	 *  @param filter a related person filter
	 *  @return an iterator that iterates over all related persons matching the provided filter.
	 */
	filterRelatedPersonsBy(filter: FilterOptions<RelatedPerson>): Promise<PaginatedListIterator<DecryptedRelatedPerson>>;

	/**
	 *
	 *  Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterRelatedPersonsBy].
	 *
	 *  @param filter a related person filter
	 *  @return an iterator that iterates over all related persons matching the provided filter.
	 */
	filterRelatedPersonsBySorted(filter: SortableFilterOptions<RelatedPerson>): Promise<PaginatedListIterator<DecryptedRelatedPerson>>;

	/**
	 *
	 *  Create a new related person. The provided related person must have the encryption metadata initialized.
	 *  @param entity a related person with initialized encryption metadata
	 *  @return the created related person with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createRelatedPerson(entity: DecryptedRelatedPerson): Promise<DecryptedRelatedPerson>;

	/**
	 *
	 *  Create multiple related persons. All the provided related persons must have the encryption metadata initialized,
	 *  otherwise this method fails without doing anything.
	 *  @param entities related persons with initialized encryption metadata
	 *  @return the created related persons with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any related person in the input was not initialized.
	 */
	createRelatedPersons(entities: Array<DecryptedRelatedPerson>): Promise<Array<DecryptedRelatedPerson>>;

	/**
	 *
	 *  Restores a relatedPerson that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteRelatedPersonById(id: string, rev: string): Promise<DecryptedRelatedPerson>;

	/**
	 *
	 *  Restores a batch of relatedPersons that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the relatedPersons to restore.
	 *  @return the restored relatedPersons. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedRelatedPerson>>;

	/**
	 *
	 *  Restores a relatedPerson that was marked as deleted.
	 *  @param relatedPerson the relatedPerson to undelete
	 *  @return the restored relatedPerson.
	 *  @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	undeleteRelatedPerson(relatedPerson: RelatedPerson): Promise<DecryptedRelatedPerson>;

	/**
	 *
	 *  Restores a batch of relatedPersons that were marked as deleted.
	 *  @param relatedPersons the relatedPersons to restore.
	 *  @return the restored relatedPersons. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteRelatedPersons(relatedPersons: Array<RelatedPerson>): Promise<Array<DecryptedRelatedPerson>>;

	/**
	 *
	 *  Modifies a related person. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a related person with update content
	 *  @return the related person updated with the provided content and a new revision.
	 */
	modifyRelatedPerson(entity: DecryptedRelatedPerson): Promise<DecryptedRelatedPerson>;

	/**
	 *
	 *  Modifies multiple related persons. Ignores all related persons for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities related persons with update content
	 *  @return the updated related persons with a new revision.
	 */
	modifyRelatedPersons(entities: Array<DecryptedRelatedPerson>): Promise<Array<DecryptedRelatedPerson>>;

	/**
	 *
	 *  Get a related person by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a related person, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a related person id.
	 *  @return the related person with id [entityId].
	 */
	getRelatedPerson(entityId: string): Promise<DecryptedRelatedPerson | undefined>;

	/**
	 *
	 *  Get multiple related persons by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a related person, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of related persons ids
	 *  @return all related persons that you can access with one of the provided ids.
	 */
	getRelatedPersons(entityIds: Array<string>): Promise<Array<DecryptedRelatedPerson>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<RelatedPerson>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedRelatedPerson>>;

}
