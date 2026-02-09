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

	matchContactsBy(filter: BaseFilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBy(filter: BaseFilterOptions<Service>): Promise<Array<string>>;

	matchContactsBySorted(filter: BaseSortableFilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBySorted(filter: BaseSortableFilterOptions<Service>): Promise<Array<string>>;

	filterContactsBy(filter: BaseFilterOptions<Contact>): Promise<PaginatedListIterator<EncryptedContact>>;

	filterServicesBy(filter: BaseFilterOptions<Service>): Promise<PaginatedListIterator<EncryptedService>>;

	filterContactsBySorted(filter: BaseSortableFilterOptions<Contact>): Promise<PaginatedListIterator<EncryptedContact>>;

	filterServicesBySorted(filter: BaseSortableFilterOptions<Service>): Promise<PaginatedListIterator<EncryptedService>>;

	subscribeToServiceCreateOrUpdateEvents(filter: BaseFilterOptions<Service>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedService>>;

	deleteContactById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeContactById(id: string, rev: string): Promise<void>;

	purgeContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteContact(contact: Contact): Promise<StoredDocumentIdentifier>;

	deleteContacts(contacts: Array<Contact>): Promise<Array<StoredDocumentIdentifier>>;

	purgeContact(contact: Contact): Promise<void>;

	purgeContacts(contacts: Array<Contact>): Promise<Array<StoredDocumentIdentifier>>;

	getServiceCodesOccurrences(codeType: string,
			minOccurrences: number): Promise<Array<LabelledOccurence>>;

	createContact(entity: EncryptedContact): Promise<EncryptedContact>;

	createContacts(entities: Array<EncryptedContact>): Promise<Array<EncryptedContact>>;

	undeleteContactById(id: string, rev: string): Promise<EncryptedContact>;

	undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedContact>>;

	undeleteContact(contact: Contact): Promise<EncryptedContact>;

	undeleteContacts(contacts: Array<Contact>): Promise<Array<EncryptedContact>>;

	modifyContact(entity: EncryptedContact): Promise<EncryptedContact>;

	modifyContacts(entities: Array<EncryptedContact>): Promise<Array<EncryptedContact>>;

	getContact(entityId: string): Promise<EncryptedContact | undefined>;

	getContacts(entityIds: Array<string>): Promise<Array<EncryptedContact>>;

	getService(serviceId: string): Promise<EncryptedService | undefined>;

	getServices(entityIds: Array<string>): Promise<Array<EncryptedService>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Contact>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedContact>>;

}
