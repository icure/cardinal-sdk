// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Contact, EncryptedContact} from '../model/Contact.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {LabelledOccurence} from '../model/data/LabelledOccurence.mjs';
import {EncryptedService, Service} from '../model/embed/Service.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {ContactBasicInGroupApi} from './ContactBasicInGroupApi.mjs';


export interface ContactBasicApi {

	inGroup: ContactBasicInGroupApi;

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
	matchContactsBy(filter: BaseFilterOptions<Contact>): Promise<Array<string>>;

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
	matchServicesBy(filter: BaseFilterOptions<Service>): Promise<Array<string>>;

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
	matchContactsBySorted(filter: BaseSortableFilterOptions<Contact>): Promise<Array<string>>;

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
	matchServicesBySorted(filter: BaseSortableFilterOptions<Service>): Promise<Array<string>>;

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
	filterContactsBy(filter: BaseFilterOptions<Contact>): Promise<PaginatedListIterator<EncryptedContact>>;

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
	filterServicesBy(filter: BaseFilterOptions<Service>): Promise<PaginatedListIterator<EncryptedService>>;

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
	filterContactsBySorted(filter: BaseSortableFilterOptions<Contact>): Promise<PaginatedListIterator<EncryptedContact>>;

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
	filterServicesBySorted(filter: BaseSortableFilterOptions<Service>): Promise<PaginatedListIterator<EncryptedService>>;

	/**
	 *
	 *  Subscribe to creation and update events on Services. Unlike other entity events subscription methods for services
	 *  you all subscription will be notified of both creation and update events.
	 *  @param filter only events for services matching this filter will be notified
	 *  @param subscriptionConfig customize the subscription configuration
	 *  @return a subscription that receives notifications for creation or update of services.
	 */
	subscribeToServiceCreateOrUpdateEvents(filter: BaseFilterOptions<Service>,
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
	 *  Create a new contact. The provided contact must have the encryption metadata initialized.
	 *  @param entity a contact with initialized encryption metadata
	 *  @return the created contact with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createContact(entity: EncryptedContact): Promise<EncryptedContact>;

	/**
	 *
	 *  Create multiple contacts. All the provided contacts must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities contacts with initialized encryption metadata
	 *  @return the created contacts with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any contact in the input was not initialized.
	 */
	createContacts(entities: Array<EncryptedContact>): Promise<Array<EncryptedContact>>;

	/**
	 *
	 *  Restores a contact that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteContactById(id: string, rev: string): Promise<EncryptedContact>;

	/**
	 *
	 *  Restores a batch of contacts that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the contacts to restore.
	 *  @return the restored contacts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedContact>>;

	/**
	 *
	 *  Restores a contact that was marked as deleted.
	 *  @param contact the contact to undelete
	 *  @return the restored contact.
	 *  @throws RevisionConflictException if the provided contact doesn't match the latest known revision
	 */
	undeleteContact(contact: Contact): Promise<EncryptedContact>;

	/**
	 *
	 *  Restores a batch of contacts that were marked as deleted.
	 *  @param contacts the contacts to restore.
	 *  @return the restored contacts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteContacts(contacts: Array<Contact>): Promise<Array<EncryptedContact>>;

	/**
	 *
	 *  Modifies a contact. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a contact with update content
	 *  @return the contact updated with the provided content and a new revision.
	 */
	modifyContact(entity: EncryptedContact): Promise<EncryptedContact>;

	/**
	 *
	 *  Modifies multiple contacts. Ignores all contacts for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities contacts with update content
	 *  @return the updated contacts with a new revision.
	 */
	modifyContacts(entities: Array<EncryptedContact>): Promise<Array<EncryptedContact>>;

	/**
	 *
	 *  Get a contact by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a contact, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a contact id.
	 *  @return the contact with id [entityId].
	 */
	getContact(entityId: string): Promise<EncryptedContact | undefined>;

	/**
	 *
	 *  Get multiple contacts by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a contact, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of contacts ids
	 *  @return all contacts that you can access with one of the provided ids.
	 */
	getContacts(entityIds: Array<string>): Promise<Array<EncryptedContact>>;

	/**
	 *
	 *  Get a service by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a service, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param serviceId a service id
	 *  @return the service with id [serviceId].
	 */
	getService(serviceId: string): Promise<EncryptedService | undefined>;

	/**
	 *
	 *  Get multiple services by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a services, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of service ids
	 *  @return all services that you can access with one of the provided ids.
	 */
	getServices(entityIds: Array<string>): Promise<Array<EncryptedService>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Contact>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedContact>>;

}
