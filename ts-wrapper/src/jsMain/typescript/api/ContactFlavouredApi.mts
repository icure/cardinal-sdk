// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ContactShareOptions} from '../crypto/entities/ContactShareOptions.mjs';
import {Contact} from '../model/Contact.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {Service} from '../model/embed/Service.mjs';


export interface ContactFlavouredApi<E extends Contact, S extends Service> {

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
	shareWith(delegateId: string, contact: E,
			options?: { options?: ContactShareOptions | undefined }): Promise<E>;

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
	shareWithMany(contact: E, delegates: { [ key: string ]: ContactShareOptions }): Promise<E>;

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
	filterContactsBy(filter: FilterOptions<Contact>): Promise<PaginatedListIterator<E>>;

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
	filterServicesBy(filter: FilterOptions<Service>): Promise<PaginatedListIterator<S>>;

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
	filterContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<E>>;

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
	filterServicesBySorted(filter: SortableFilterOptions<Service>): Promise<PaginatedListIterator<S>>;

	/**
	 *
	 *  Create a new contact. The provided contact must have the encryption metadata initialized.
	 *  @param entity a contact with initialized encryption metadata
	 *  @return the created contact with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createContact(entity: E): Promise<E>;

	/**
	 *
	 *  Create multiple contacts. All the provided contacts must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities contacts with initialized encryption metadata
	 *  @return the created contacts with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any contact in the input was not initialized.
	 */
	createContacts(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a contact that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteContactById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of contacts that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the contacts to restore.
	 *  @return the restored contacts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a contact that was marked as deleted.
	 *  @param contact the contact to undelete
	 *  @return the restored contact.
	 *  @throws RevisionConflictException if the provided contact doesn't match the latest known revision
	 */
	undeleteContact(contact: Contact): Promise<E>;

	/**
	 *
	 *  Restores a batch of contacts that were marked as deleted.
	 *  @param contacts the contacts to restore.
	 *  @return the restored contacts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteContacts(contacts: Array<Contact>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a contact. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a contact with update content
	 *  @return the contact updated with the provided content and a new revision.
	 */
	modifyContact(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple contacts. Ignores all contacts for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities contacts with update content
	 *  @return the updated contacts with a new revision.
	 */
	modifyContacts(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a contact by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a contact, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a contact id.
	 *  @return the contact with id [entityId].
	 */
	getContact(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple contacts by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a contact, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of contacts ids
	 *  @return all contacts that you can access with one of the provided ids.
	 */
	getContacts(entityIds: Array<string>): Promise<Array<E>>;

	/**
	 *
	 *  Get a service by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a service, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param serviceId a service id
	 *  @return the service with id [serviceId].
	 */
	getService(serviceId: string): Promise<S | undefined>;

	/**
	 *
	 *  Get multiple services by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a services, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of service ids
	 *  @return all services that you can access with one of the provided ids.
	 */
	getServices(entityIds: Array<string>): Promise<Array<S>>;

}
