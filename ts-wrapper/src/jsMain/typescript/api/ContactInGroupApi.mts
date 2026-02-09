// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ContactShareOptions} from '../crypto/entities/ContactShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {Contact, DecryptedContact, EncryptedContact} from '../model/Contact.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {DecryptedService, EncryptedService, Service} from '../model/embed/Service.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {ContactFlavouredInGroupApi} from './ContactFlavouredInGroupApi.mjs';


export interface ContactInGroupApi {

	encrypted: ContactFlavouredInGroupApi<EncryptedContact, EncryptedService>;

	tryAndRecover: ContactFlavouredInGroupApi<Contact, Service>;

	withEncryptionMetadata(entityGroupId: string, base: DecryptedContact | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedContact>>;

	getEncryptionKeysOf(contact: GroupScoped<Contact>): Promise<Array<HexString>>;

	hasWriteAccess(contact: GroupScoped<Contact>): Promise<boolean>;

	decryptPatientIdOf(contact: GroupScoped<Contact>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Contact>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(contacts: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	tryDecrypt(contacts: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<Contact>>>;

	decryptService(service: GroupScoped<EncryptedService>): Promise<GroupScoped<DecryptedService>>;

	tryDecryptService(service: GroupScoped<EncryptedService>): Promise<GroupScoped<Service>>;

	matchContactsBy(groupId: string, filter: FilterOptions<Contact>): Promise<Array<string>>;

	matchContactsBySorted(groupId: string,
			filter: SortableFilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBy(groupId: string, filter: FilterOptions<Service>): Promise<Array<string>>;

	matchServicesBySorted(groupId: string,
			filter: SortableFilterOptions<Service>): Promise<Array<string>>;

	deleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteContacts(contacts: Array<GroupScoped<Contact>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeContact(contact: GroupScoped<Contact>): Promise<void>;

	purgeContacts(contacts: Array<GroupScoped<Contact>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	shareWith(delegate: EntityReferenceInGroup, contact: GroupScoped<DecryptedContact>,
			options?: { options?: ContactShareOptions | undefined }): Promise<GroupScoped<DecryptedContact>>;

	shareWithMany(contact: GroupScoped<DecryptedContact>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: ContactShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedContact>>;

	filterContactsBy(groupId: string,
			filter: FilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<DecryptedContact>>>;

	filterContactsBySorted(groupId: string,
			filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<DecryptedContact>>>;

	createContact(entity: GroupScoped<DecryptedContact>): Promise<GroupScoped<DecryptedContact>>;

	createContacts(entities: Array<GroupScoped<DecryptedContact>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	undeleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedContact>>;

	undeleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	undeleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<DecryptedContact>>;

	undeleteContacts(contacts: Array<GroupScoped<DecryptedContact>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	modifyContact(entity: GroupScoped<DecryptedContact>): Promise<GroupScoped<DecryptedContact>>;

	modifyContacts(entities: Array<GroupScoped<DecryptedContact>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	getContact(groupId: string, entityId: string): Promise<GroupScoped<DecryptedContact> | undefined>;

	getContacts(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedContact>>>;

	getService(groupId: string, serviceId: string): Promise<GroupScoped<DecryptedService> | undefined>;

	getServices(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedService>>>;

}
