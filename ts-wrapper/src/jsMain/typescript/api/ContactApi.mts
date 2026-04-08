// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ContactShareOptions} from '../crypto/entities/ContactShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {Contact, DecryptedContact, EncryptedContact} from '../model/Contact.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {LabelledOccurence} from '../model/data/LabelledOccurence.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {DecryptedService, EncryptedService, Service} from '../model/embed/Service.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {ContactFlavouredApi} from './ContactFlavouredApi.mjs';
import {ContactInGroupApi} from './ContactInGroupApi.mjs';


export interface ContactApi {

	encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService>;

	tryAndRecover: ContactFlavouredApi<Contact, Service>;

	inGroup: ContactInGroupApi;

	/**
	 *
	 *  Get the ids of all contacts matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchContactsBySorted] instead.
	 *
	 *  @param filter a contact filter
	 *  @return a list of contact ids
	 */
	matchContactsBy(filter: FilterOptions<Contact>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all services matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchServicesBySorted] instead.
	 *
	 *  @param filter a service filter
	 *  @return a list of service ids
	 */
	matchServicesBy(filter: FilterOptions<Service>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all contacts matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchContactsBy].
	 *
	 *  @param filter a contact filter
	 *  @return a list of contact ids
	 */
	matchContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all services matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchServicesBy].
	 *
	 *  @param filter a service filter
	 *  @return a list of service ids
	 */
	matchServicesBySorted(filter: SortableFilterOptions<Service>): Promise<Array<string>>;

	/**
	 *
	 *  Creates a new contact with initialized encryption metadata
	 *  @param base a contact with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the contact.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new contact
	 *  @return a contact with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedContact | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedContact>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a contact. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param contact a contact
	 *  @return the encryption keys extracted from the provided contact.
	 */
	getEncryptionKeysOf(contact: Contact): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a contact through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param contact a contact
	 *  @return if the current user has write access to the provided contact
	 */
	hasWriteAccess(contact: Contact): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a contact.
	 *  Note: contacts usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param contact a contact
	 *  @return the id of the patient linked to the contact, or empty if the current user can't access any patient id
	 *  of the contact.
	 */
	decryptPatientIdOf(contact: Contact): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a service.
	 *  Note: services usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  It is to be noted that only services returned by getServices, or filterServices method will have the metadata necessary
	 *  to deduce the patient id. In the case of services obtained directly from the Contact, you should use decryptPatientIdOf(Contact) instead.
	 *  @param service a service returned by getServices, or filterServices method.
	 *  @return the id of the patient linked to the service, or empty if the current user can't access any patient id
	 *  of the service.
	 */
	decryptPatientIdOfService(service: Service): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a contact.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided contact. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the contact the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Contact,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a contact E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any contact that you have shared with P, H will be able to know that the contact was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a contact that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a contact
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: Contact, delegates: Array<string>): Promise<void>;

	decrypt(contact: EncryptedContact): Promise<DecryptedContact>;

	tryDecrypt(contact: EncryptedContact): Promise<Contact>;

	/**
	 *
	 *  Decrypts a single [EncryptedService].
	 *  Note: you should use this function only when you retrieve [Service]s as single entity. If you are retrieving them as part of a
	 *  [Contact], use [decrypt] instead.
	 *
	 *  @param service the [EncryptedService] to decrypt.
	 *  @return the [DecryptedService].
	 *  @throws EntityEncryptionException if [service] could not be decrypted.
	 */
	decryptService(service: EncryptedService): Promise<DecryptedService>;

	/**
	 *
	 *  Tries to decrypt a single [EncryptedService].
	 *  Note: you should use this function only when you retrieve [Service]s as single entity. If you are retrieving them as part of a
	 *  [Contact], use [tryDecrypt] instead.
	 *
	 *  @param service the [EncryptedService] to decrypt.
	 *  @return the [DecryptedService] if the decryption was successful, the original [service] otherwise.
	 */
	tryDecryptService(service: EncryptedService): Promise<Service>;

	/**
	 *
	 *  Subscribe to creation and update events on Services. Unlike other entity events subscription methods for services
	 *  you all subscription will be notified of both creation and update events.
	 *  @param filter only events for services matching this filter will be notified
	 *  @param subscriptionConfig customize the subscription configuration
	 *  @return a subscription that receives notifications for creation or update of services.
	 */
	subscribeToServiceCreateOrUpdateEvents(filter: FilterOptions<Service>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedService>>;

	/**
	 *
	 *  Deletes a contact. If you don't have write access to the contact the method will fail.
	 *  @param entityId id of the contact.
	 *  @param rev the latest known rev of the contact to delete
	 *  @return the id and revision of the deleted contact.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteContactById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many contacts. Ids that don't correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the contacts to delete.
	 *  @return the id and revision of the deleted contacts. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a contact.
	 *  @param id id of the contact to purge
	 *  @param rev latest revision of the contact
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeContactById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many contacts.
	 *  @param entityIds ids and revisions of the contacts to delete
	 *  @return the id and revision of the deleted contacts. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a contact. If you don't have write access to the contact the method will fail.
	 *  @param contact the contact to delete
	 *  @return the id and revision of the deleted contact.
	 *  @throws RevisionConflictException if the provided contact doesn't match the latest known revision
	 */
	deleteContact(contact: Contact): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many contacts. Ignores contact for which you don't have write access or that don't match the latest revision.
	 *  @param contacts the contacts to delete
	 *  @return the id and revision of the deleted contacts. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteContacts(contacts: Array<Contact>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a contact.
	 *  @param contact the contact to purge.
	 *  @throws RevisionConflictException if the provided contact doesn't match the latest known revision
	 */
	purgeContact(contact: Contact): Promise<void>;

	/**
	 *
	 *  Permanently deletes many contacts.
	 *  @param contacts the contacts to delete
	 *  @return the id and revision of the deleted contacts. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeContacts(contacts: Array<Contact>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Gives an approximation of the amount of times each code of type [codeType] is used in services where the current
	 *  data owner is a direct delegate (does not count situations where the data owner has access to the service through
	 *  delegations to a parent data owner).
	 *  This number is not exact, and may be cached, so you should not use this method if you need precise values, but
	 *  it can be useful if you want to give suggestions.
	 *  Only codes that occur at least [minOccurrences] times will be used.
	 *  @return the occurrences for codes of type [codeType] in services.
	 */
	getServiceCodesOccurrences(codeType: string,
			minOccurrences: number): Promise<Array<LabelledOccurence>>;

	/**
	 *
	 *  Share a contact with another data owner. The contact must already exist in the database for this method to
	 *  succeed. If you want to share the contact before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the contact
	 *  @param contact the contact to share with [delegateId]
	 *  @param options specifies how the contact will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the contact. Refer
	 *  to the documentation of [ContactShareOptions] for more information.
	 *  @return the updated contact if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, contact: DecryptedContact,
			options?: { options?: ContactShareOptions | undefined }): Promise<DecryptedContact>;

	/**
	 *
	 *  Share a contact with multiple data owners. The contact must already exist in the database for this method to
	 *  succeed. If you want to share the contact before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param contact the contact to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated contact.
	 */
	shareWithMany(contact: DecryptedContact,
			delegates: { [ key: string ]: ContactShareOptions }): Promise<DecryptedContact>;

	/**
	 *
	 *  Get an iterator that iterates through all contacts matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterContactsBySorted] instead.
	 *
	 *  @param filter a contact filter
	 *  @return an iterator that iterates over all contacts matching the provided filter.
	 */
	filterContactsBy(filter: FilterOptions<Contact>): Promise<PaginatedListIterator<DecryptedContact>>;

	/**
	 *
	 *  Get an iterator that iterates through all services matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterServicesBySorted] instead.
	 *
	 *  @param filter a service filter
	 *  @return an iterator that iterates over all services matching the provided filter.
	 */
	filterServicesBy(filter: FilterOptions<Service>): Promise<PaginatedListIterator<DecryptedService>>;

	/**
	 *
	 *  Get an iterator that iterates through all contacts matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterContactsBy].
	 *
	 *  @param filter a contact filter
	 *  @return an iterator that iterates over all contacts matching the provided filter.
	 */
	filterContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<DecryptedContact>>;

	/**
	 *
	 *  Get an iterator that iterates through all services matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterServicesBy].
	 *
	 *  @param filter a service filter
	 *  @return an iterator that iterates over all services matching the provided filter.
	 */
	filterServicesBySorted(filter: SortableFilterOptions<Service>): Promise<PaginatedListIterator<DecryptedService>>;

	/**
	 *
	 *  Create a new contact. The provided contact must have the encryption metadata initialized.
	 *  @param entity a contact with initialized encryption metadata
	 *  @return the created contact with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createContact(entity: DecryptedContact): Promise<DecryptedContact>;

	/**
	 *
	 *  Create multiple contacts. All the provided contacts must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities contacts with initialized encryption metadata
	 *  @return the created contacts with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any contact in the input was not initialized.
	 */
	createContacts(entities: Array<DecryptedContact>): Promise<Array<DecryptedContact>>;

	/**
	 *
	 *  Restores a contact that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteContactById(id: string, rev: string): Promise<DecryptedContact>;

	/**
	 *
	 *  Restores a batch of contacts that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the contacts to restore.
	 *  @return the restored contacts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedContact>>;

	/**
	 *
	 *  Restores a contact that was marked as deleted.
	 *  @param contact the contact to undelete
	 *  @return the restored contact.
	 *  @throws RevisionConflictException if the provided contact doesn't match the latest known revision
	 */
	undeleteContact(contact: Contact): Promise<DecryptedContact>;

	/**
	 *
	 *  Restores a batch of contacts that were marked as deleted.
	 *  @param contacts the contacts to restore.
	 *  @return the restored contacts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteContacts(contacts: Array<Contact>): Promise<Array<DecryptedContact>>;

	/**
	 *
	 *  Modifies a contact. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a contact with update content
	 *  @return the contact updated with the provided content and a new revision.
	 */
	modifyContact(entity: DecryptedContact): Promise<DecryptedContact>;

	/**
	 *
	 *  Modifies multiple contacts. Ignores all contacts for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities contacts with update content
	 *  @return the updated contacts with a new revision.
	 */
	modifyContacts(entities: Array<DecryptedContact>): Promise<Array<DecryptedContact>>;

	/**
	 *
	 *  Get a contact by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a contact, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a contact id.
	 *  @return the contact with id [entityId].
	 */
	getContact(entityId: string): Promise<DecryptedContact | undefined>;

	/**
	 *
	 *  Get multiple contacts by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a contact, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of contacts ids
	 *  @return all contacts that you can access with one of the provided ids.
	 */
	getContacts(entityIds: Array<string>): Promise<Array<DecryptedContact>>;

	/**
	 *
	 *  Get a service by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a service, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param serviceId a service id
	 *  @return the service with id [serviceId].
	 */
	getService(serviceId: string): Promise<DecryptedService | undefined>;

	/**
	 *
	 *  Get multiple services by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a services, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of service ids
	 *  @return all services that you can access with one of the provided ids.
	 */
	getServices(entityIds: Array<string>): Promise<Array<DecryptedService>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Contact>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedContact>>;

}
