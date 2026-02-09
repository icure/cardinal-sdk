// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Contact, EncryptedContact} from '../model/Contact.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EncryptedService, Service} from '../model/embed/Service.mjs';


export interface ContactBasicInGroupApi {

	matchContactsBy(groupId: string, filter: BaseFilterOptions<Contact>): Promise<Array<string>>;

	matchContactsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBy(groupId: string, filter: BaseFilterOptions<Service>): Promise<Array<string>>;

	matchServicesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Service>): Promise<Array<string>>;

	filterContactsBy(groupId: string,
			filter: BaseFilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<EncryptedContact>>>;

	filterContactsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<EncryptedContact>>>;

	filterServicesBy(groupId: string,
			filter: BaseFilterOptions<Service>): Promise<PaginatedListIterator<GroupScoped<EncryptedService>>>;

	filterServicesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Service>): Promise<PaginatedListIterator<GroupScoped<EncryptedService>>>;

	deleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteContacts(contacts: Array<GroupScoped<Contact>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeContact(contact: GroupScoped<Contact>): Promise<void>;

	purgeContacts(contacts: Array<GroupScoped<Contact>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createContact(entity: GroupScoped<EncryptedContact>): Promise<GroupScoped<EncryptedContact>>;

	createContacts(entities: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<EncryptedContact>>>;

	undeleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedContact>>;

	undeleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedContact>>>;

	undeleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<EncryptedContact>>;

	undeleteContacts(contacts: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<EncryptedContact>>>;

	modifyContact(entity: GroupScoped<EncryptedContact>): Promise<GroupScoped<EncryptedContact>>;

	modifyContacts(entities: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<EncryptedContact>>>;

	getContact(groupId: string, entityId: string): Promise<GroupScoped<EncryptedContact> | undefined>;

	getContacts(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedContact>>>;

	getService(groupId: string, serviceId: string): Promise<GroupScoped<EncryptedService> | undefined>;

	getServices(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedService>>>;

}
