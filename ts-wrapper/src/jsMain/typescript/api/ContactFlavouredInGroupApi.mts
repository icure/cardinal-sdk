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

	/**
	 *
	 *  In-group version of [ContactFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, contact: GroupScoped<E>,
			options?: { options?: ContactShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ContactFlavouredApi.shareWithMany]
	 */
	shareWithMany(contact: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: ContactShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ContactFlavouredApi.filterContactsBy]
	 */
	filterContactsBy(groupId: string,
			filter: FilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ContactFlavouredApi.filterContactsBySorted]
	 */
	filterContactsBySorted(groupId: string,
			filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.createContact].
	 */
	createContact(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.createContacts].
	 */
	createContacts(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContactById]
	 */
	undeleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContactsByIds]
	 */
	undeleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContact]
	 */
	undeleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContacts]
	 */
	undeleteContacts(contacts: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.modifyContact]
	 */
	modifyContact(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.modifyContacts]
	 */
	modifyContacts(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getContact]
	 */
	getContact(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getContacts]
	 */
	getContacts(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getService]
	 */
	getService(groupId: string, serviceId: string): Promise<GroupScoped<S> | undefined>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getServices]
	 */
	getServices(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<S>>>;

}
