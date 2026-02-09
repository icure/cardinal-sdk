// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ContactShareOptions} from '../crypto/entities/ContactShareOptions.mjs';
import {Contact} from '../model/Contact.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {Service} from '../model/embed/Service.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface ContactFlavouredInGroupApi<E extends Contact, S extends Service> {

	shareWith(delegate: EntityReferenceInGroup, contact: GroupScoped<E>,
			options?: { options?: ContactShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(contact: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: ContactShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	filterContactsBy(groupId: string,
			filter: FilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterContactsBySorted(groupId: string,
			filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createContact(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createContacts(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<E>>;

	undeleteContacts(contacts: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyContact(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyContacts(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getContact(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getContacts(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

	getService(groupId: string, serviceId: string): Promise<GroupScoped<S> | undefined>;

	getServices(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<S>>>;

}
