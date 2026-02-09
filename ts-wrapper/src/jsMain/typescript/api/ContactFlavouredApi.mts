// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ContactShareOptions} from '../crypto/entities/ContactShareOptions.mjs';
import {Contact} from '../model/Contact.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {Service} from '../model/embed/Service.mjs';


export interface ContactFlavouredApi<E extends Contact, S extends Service> {

	shareWith(delegateId: string, contact: E,
			options?: { options?: ContactShareOptions | undefined }): Promise<E>;

	shareWithMany(contact: E, delegates: { [ key: string ]: ContactShareOptions }): Promise<E>;

	filterContactsBy(filter: FilterOptions<Contact>): Promise<PaginatedListIterator<E>>;

	filterServicesBy(filter: FilterOptions<Service>): Promise<PaginatedListIterator<S>>;

	filterContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<E>>;

	filterServicesBySorted(filter: SortableFilterOptions<Service>): Promise<PaginatedListIterator<S>>;

	createContact(entity: E): Promise<E>;

	createContacts(entities: Array<E>): Promise<Array<E>>;

	undeleteContactById(id: string, rev: string): Promise<E>;

	undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteContact(contact: Contact): Promise<E>;

	undeleteContacts(contacts: Array<Contact>): Promise<Array<E>>;

	modifyContact(entity: E): Promise<E>;

	modifyContacts(entities: Array<E>): Promise<Array<E>>;

	getContact(entityId: string): Promise<E | undefined>;

	getContacts(entityIds: Array<string>): Promise<Array<E>>;

	getService(serviceId: string): Promise<S | undefined>;

	getServices(entityIds: Array<string>): Promise<Array<S>>;

}
