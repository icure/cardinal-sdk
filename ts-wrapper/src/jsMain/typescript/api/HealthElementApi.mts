// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedHealthElement, EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {HealthElementFlavouredApi} from './HealthElementFlavouredApi.mjs';
import {HealthElementInGroupApi} from './HealthElementInGroupApi.mjs';


export interface HealthElementApi {

	encrypted: HealthElementFlavouredApi<EncryptedHealthElement>;

	tryAndRecover: HealthElementFlavouredApi<HealthElement>;

	inGroup: HealthElementInGroupApi;

	/**
	 *
	 *  Creates a new health element with initialized encryption metadata
	 *  @param base a health element with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the health element.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new health element
	 *  @return a health element with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedHealthElement | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedHealthElement>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a health element. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param healthElement a health element
	 *  @return the encryption keys extracted from the provided health element.
	 */
	getEncryptionKeysOf(healthElement: HealthElement): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a health element through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param healthElement a health element
	 *  @return if the current user has write access to the provided health element
	 */
	hasWriteAccess(healthElement: HealthElement): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a health element.
	 *  Note: health elements usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param healthElement a health element
	 *  @return the id of the patient linked to the health element, or empty if the current user can't access any patient id
	 *  of the health element.
	 */
	decryptPatientIdOf(healthElement: HealthElement): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a health element.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided health element. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the health element the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any HealthElement,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a health element E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any health element that you have shared with P, H will be able to know that the health element was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a health element that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a health element
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: HealthElement,
			delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts HealthElements, throwing an exception if it is not possible.
	 *  @param healthElements encrypted HealthElements
	 *  @return the decrypted HealthElements
	 *  @throws EntityEncryptionException if any of the provided HealthElements couldn't be decrypted
	 */
	decrypt(healthElements: Array<EncryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	/**
	 *
	 *  Tries to decrypt a HealthElement, returns the input if it is not possible.
	 *  @param healthElements encrypted HealthElements
	 *  @return all the provided HealthElements, each of them decrypted if possible or unchanged (still encrypted)
	 */
	tryDecrypt(healthElements: Array<EncryptedHealthElement>): Promise<Array<HealthElement>>;

	/**
	 *
	 *  Encrypts provided decrypted HealthElements, and validates already encrypted HealthElements.
	 *  @param healthElements HealthElements to encrypt and/or validate
	 *  @return the encrypted and validates HealthElements
	 *  @throws EntityEncryptionException if any of the provided decrypted HealthElements couldn't be encrypted (the current
	 *  user can't access its encryption key or no key was initialized) or if the already encrypted HealthElements don't
	 *  respect the manifest.
	 */
	encryptOrValidate(healthElements: Array<HealthElement>): Promise<Array<EncryptedHealthElement>>;

	/**
	 *
	 *  Get the ids of all health elements matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchHealthElementsBySorted] instead.
	 *
	 *  @param filter a health element filter
	 *  @return a list of health element ids
	 */
	matchHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all health elements matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchHealthElementsBy].
	 *
	 *  @param filter a health element filter
	 *  @return a list of health element ids
	 */
	matchHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<Array<string>>;

	/**
	 *
	 *  Deletes a healthElement. If you don't have write access to the healthElement the method will fail.
	 *  @param entityId id of the healthElement.
	 *  @param rev the latest known rev of the healthElement to delete
	 *  @return the id and revision of the deleted healthElement.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteHealthElementById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many healthElements. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the healthElements to delete.
	 *  @return the id and revision of the deleted healthElements. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a healthElement.
	 *  @param id id of the healthElement to purge
	 *  @param rev latest revision of the healthElement
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeHealthElementById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many healthElements.
	 *  @param entityIds ids and revisions of the healthElements to delete
	 *  @return the id and revision of the deleted healthElements. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a healthElement. If you don't have write access to the healthElement the method will fail.
	 *  @param healthElement the healthElement to delete
	 *  @return the id and revision of the deleted healthElement.
	 *  @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	deleteHealthElement(healthElement: HealthElement): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many healthElements. Ignores healthElement for which you don't have write access or that don't match the latest revision.
	 *  @param healthElements the healthElements to delete
	 *  @return the id and revision of the deleted healthElements. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a healthElement.
	 *  @param healthElement the healthElement to purge.
	 *  @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	purgeHealthElement(healthElement: HealthElement): Promise<void>;

	/**
	 *
	 *  Permanently deletes many healthElements.
	 *  @param healthElements the healthElements to purge.
	 *  @return the id and revision of the deleted healthElements. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeHealthElements(healthElements: Array<HealthElement>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Share a health element with another data owner. The health element must already exist in the database for this method to
	 *  succeed. If you want to share the health element before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the health element
	 *  @param healthElement the health element to share with [delegateId]
	 *  @param options specifies how the health element will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the health element. Refer
	 *  to the documentation of [HealthElementShareOptions] for more information.
	 *  @return the updated health element if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, healthElement: DecryptedHealthElement,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<DecryptedHealthElement>;

	/**
	 *
	 *  Share a health element with multiple data owners. The health element must already exist in the database for this method to
	 *  succeed. If you want to share the health element before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param healthElement the health element to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated health element.
	 */
	shareWithMany(healthElement: DecryptedHealthElement,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<DecryptedHealthElement>;

	/**
	 *
	 *  Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterHealthElementsBySorted] instead.
	 *
	 *  @param filter a health element filter
	 *  @return an iterator that iterates over all health elements matching the provided filter.
	 */
	filterHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<DecryptedHealthElement>>;

	/**
	 *
	 *  Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterHealthElementsBy].
	 *
	 *  @param filter a health element filter
	 *  @return an iterator that iterates over all health elements matching the provided filter.
	 */
	filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<DecryptedHealthElement>>;

	/**
	 *
	 *  Create a new health element. The provided health element must have the encryption metadata initialized.
	 *  @param entity a health element with initialized encryption metadata
	 *  @return the created health element with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createHealthElement(entity: DecryptedHealthElement): Promise<DecryptedHealthElement>;

	/**
	 *
	 *  Create multiple health elements. All the provided health elements must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities health elements with initialized encryption metadata
	 *  @return the created health elements with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any health element in the input was not initialized.
	 */
	createHealthElements(entities: Array<DecryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	/**
	 *
	 *  Restores a healthElement that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteHealthElementById(id: string, rev: string): Promise<DecryptedHealthElement>;

	/**
	 *
	 *  Restores a batch of healthElementIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the healthElementIds to restore.
	 *  @return the restored healthElementIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedHealthElement>>;

	/**
	 *
	 *  Restores a healthElement that was marked as deleted.
	 *  @param healthElement the healthElement to undelete
	 *  @return the restored healthElement.
	 *  @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	undeleteHealthElement(healthElement: HealthElement): Promise<DecryptedHealthElement>;

	/**
	 *
	 *  Restores a batch of healthElements that were marked as deleted.
	 *  @param healthElements the healthElements to restore.
	 *  @return the restored healthElements. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<DecryptedHealthElement>>;

	/**
	 *
	 *  Modifies a health element. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a health element with update content
	 *  @return the health element updated with the provided content and a new revision.
	 */
	modifyHealthElement(entity: DecryptedHealthElement): Promise<DecryptedHealthElement>;

	/**
	 *
	 *  Modifies multiple health elements. Ignores all health elements for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities health elements with update content
	 *  @return the updated health elements with a new revision.
	 */
	modifyHealthElements(entities: Array<DecryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	/**
	 *
	 *  Get a health element by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a health element, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a health element id.
	 *  @return the health element with id [entityId].
	 */
	getHealthElement(entityId: string): Promise<DecryptedHealthElement | undefined>;

	/**
	 *
	 *  Get multiple health elements by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a health element, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of health elements ids
	 *  @return all health elements that you can access with one of the provided ids.
	 */
	getHealthElements(entityIds: Array<string>): Promise<Array<DecryptedHealthElement>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<HealthElement>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedHealthElement>>;

}
