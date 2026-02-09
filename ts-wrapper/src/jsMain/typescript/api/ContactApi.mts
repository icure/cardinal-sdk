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

	matchContactsBy(filter: FilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBy(filter: FilterOptions<Service>): Promise<Array<string>>;

	matchContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBySorted(filter: SortableFilterOptions<Service>): Promise<Array<string>>;

	withEncryptionMetadata(base: DecryptedContact | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedContact>;

	getEncryptionKeysOf(contact: Contact): Promise<Array<HexString>>;

	hasWriteAccess(contact: Contact): Promise<boolean>;

	decryptPatientIdOf(contact: Contact): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: Contact, delegates: Array<string>): Promise<void>;

	decrypt(contact: EncryptedContact): Promise<DecryptedContact>;

	tryDecrypt(contact: EncryptedContact): Promise<Contact>;

	decryptService(service: EncryptedService): Promise<DecryptedService>;

	tryDecryptService(service: EncryptedService): Promise<Service>;

	subscribeToServiceCreateOrUpdateEvents(filter: FilterOptions<Service>,
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

	shareWith(delegateId: string, contact: DecryptedContact,
			options?: { options?: ContactShareOptions | undefined }): Promise<DecryptedContact>;

	shareWithMany(contact: DecryptedContact,
			delegates: { [ key: string ]: ContactShareOptions }): Promise<DecryptedContact>;

	filterContactsBy(filter: FilterOptions<Contact>): Promise<PaginatedListIterator<DecryptedContact>>;

	filterServicesBy(filter: FilterOptions<Service>): Promise<PaginatedListIterator<DecryptedService>>;

	filterContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<DecryptedContact>>;

	filterServicesBySorted(filter: SortableFilterOptions<Service>): Promise<PaginatedListIterator<DecryptedService>>;

	createContact(entity: DecryptedContact): Promise<DecryptedContact>;

	createContacts(entities: Array<DecryptedContact>): Promise<Array<DecryptedContact>>;

	undeleteContactById(id: string, rev: string): Promise<DecryptedContact>;

	undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedContact>>;

	undeleteContact(contact: Contact): Promise<DecryptedContact>;

	undeleteContacts(contacts: Array<Contact>): Promise<Array<DecryptedContact>>;

	modifyContact(entity: DecryptedContact): Promise<DecryptedContact>;

	modifyContacts(entities: Array<DecryptedContact>): Promise<Array<DecryptedContact>>;

	getContact(entityId: string): Promise<DecryptedContact | undefined>;

	getContacts(entityIds: Array<string>): Promise<Array<DecryptedContact>>;

	getService(serviceId: string): Promise<DecryptedService | undefined>;

	getServices(entityIds: Array<string>): Promise<Array<DecryptedService>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Contact>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedContact>>;

}
