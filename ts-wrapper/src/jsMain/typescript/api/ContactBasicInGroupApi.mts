// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Contact, EncryptedContact} from '../model/Contact.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EncryptedService, Service} from '../model/embed/Service.mjs';


export interface ContactBasicInGroupApi {

	/**
	 *
	 *  In-group version of [ContactBasicApi.matchContactsBy]
	 */
	matchContactsBy(groupId: string, filter: BaseFilterOptions<Contact>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [ContactBasicApi.matchContactsBySorted]
	 */
	matchContactsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Contact>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [ContactBasicApi.matchServicesBy]
	 */
	matchServicesBy(groupId: string, filter: BaseFilterOptions<Service>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [ContactBasicApi.matchServicesBySorted]
	 */
	matchServicesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Service>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [ContactBasicApi.filterContactsBy]
	 */
	filterContactsBy(groupId: string,
			filter: BaseFilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<EncryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicApi.filterContactsBySorted]
	 */
	filterContactsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<EncryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicApi.filterServicesBy]
	 */
	filterServicesBy(groupId: string,
			filter: BaseFilterOptions<Service>): Promise<PaginatedListIterator<GroupScoped<EncryptedService>>>;

	/**
	 *
	 *  In-group version of [ContactBasicApi.filterServicesBySorted]
	 */
	filterServicesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Service>): Promise<PaginatedListIterator<GroupScoped<EncryptedService>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavourlessApi.deleteContactById]
	 */
	deleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavourlessApi.deleteContactsByIds]
	 */
	deleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavourlessApi.purgeContactById]
	 */
	purgeContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavourlessApi.purgeContactsByIds]
	 */
	purgeContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavourlessApi.deleteContact]
	 */
	deleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavourlessApi.deleteContacts]
	 */
	deleteContacts(contacts: Array<GroupScoped<Contact>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavourlessApi.purgeContact]
	 */
	purgeContact(contact: GroupScoped<Contact>): Promise<void>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavourlessApi.purgeContacts]
	 */
	purgeContacts(contacts: Array<GroupScoped<Contact>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.createContact].
	 */
	createContact(entity: GroupScoped<EncryptedContact>): Promise<GroupScoped<EncryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.createContacts].
	 */
	createContacts(entities: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<EncryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContactById]
	 */
	undeleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContactsByIds]
	 */
	undeleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContact]
	 */
	undeleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<EncryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContacts]
	 */
	undeleteContacts(contacts: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<EncryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.modifyContact]
	 */
	modifyContact(entity: GroupScoped<EncryptedContact>): Promise<GroupScoped<EncryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.modifyContacts]
	 */
	modifyContacts(entities: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<EncryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getContact]
	 */
	getContact(groupId: string, entityId: string): Promise<GroupScoped<EncryptedContact> | undefined>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getContacts]
	 */
	getContacts(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getService]
	 */
	getService(groupId: string, serviceId: string): Promise<GroupScoped<EncryptedService> | undefined>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getServices]
	 */
	getServices(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedService>>>;

}
