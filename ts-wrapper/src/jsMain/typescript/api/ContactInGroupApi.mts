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

	/**
	 *
	 *  In-group version of [ContactApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedContact | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(contact: GroupScoped<Contact>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [ContactApi.hasWriteAccess]
	 */
	hasWriteAccess(contact: GroupScoped<Contact>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [ContactApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(contact: GroupScoped<Contact>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [ContactApi.decryptPatientIdOfService]
	 */
	decryptPatientIdOfService(service: GroupScoped<Service>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [ContactApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Contact>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [ContactApi.decrypt]
	 */
	decrypt(contacts: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactApi.tryDecrypt]
	 */
	tryDecrypt(contacts: Array<GroupScoped<EncryptedContact>>): Promise<Array<GroupScoped<Contact>>>;

	/**
	 *
	 *  In-group version of [ContactApi.decryptService]
	 */
	decryptService(service: GroupScoped<EncryptedService>): Promise<GroupScoped<DecryptedService>>;

	/**
	 *
	 *  In-group version of [ContactApi.tryDecryptService]
	 */
	tryDecryptService(service: GroupScoped<EncryptedService>): Promise<GroupScoped<Service>>;

	/**
	 *
	 *  In-group version of [ContactApi.matchContactsBy]
	 */
	matchContactsBy(groupId: string, filter: FilterOptions<Contact>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [ContactApi.matchContactsBySorted]
	 */
	matchContactsBySorted(groupId: string,
			filter: SortableFilterOptions<Contact>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [ContactApi.matchServicesBy]
	 */
	matchServicesBy(groupId: string, filter: FilterOptions<Service>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [ContactApi.matchServicesBySorted]
	 */
	matchServicesBySorted(groupId: string,
			filter: SortableFilterOptions<Service>): Promise<Array<string>>;

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
	 *  In-group version of [ContactFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, contact: GroupScoped<DecryptedContact>,
			options?: { options?: ContactShareOptions | undefined }): Promise<GroupScoped<DecryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactFlavouredApi.shareWithMany]
	 */
	shareWithMany(contact: GroupScoped<DecryptedContact>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: ContactShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactFlavouredApi.filterContactsBy]
	 */
	filterContactsBy(groupId: string,
			filter: FilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<DecryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactFlavouredApi.filterContactsBySorted]
	 */
	filterContactsBySorted(groupId: string,
			filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<GroupScoped<DecryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.createContact].
	 */
	createContact(entity: GroupScoped<DecryptedContact>): Promise<GroupScoped<DecryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.createContacts].
	 */
	createContacts(entities: Array<GroupScoped<DecryptedContact>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContactById]
	 */
	undeleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContactsByIds]
	 */
	undeleteContactsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContact]
	 */
	undeleteContact(contact: GroupScoped<Contact>): Promise<GroupScoped<DecryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.undeleteContacts]
	 */
	undeleteContacts(contacts: Array<GroupScoped<DecryptedContact>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.modifyContact]
	 */
	modifyContact(entity: GroupScoped<DecryptedContact>): Promise<GroupScoped<DecryptedContact>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.modifyContacts]
	 */
	modifyContacts(entities: Array<GroupScoped<DecryptedContact>>): Promise<Array<GroupScoped<DecryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getContact]
	 */
	getContact(groupId: string, entityId: string): Promise<GroupScoped<DecryptedContact> | undefined>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getContacts]
	 */
	getContacts(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedContact>>>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getService]
	 */
	getService(groupId: string, serviceId: string): Promise<GroupScoped<DecryptedService> | undefined>;

	/**
	 *
	 *  In-group version of [ContactBasicFlavouredApi.getServices]
	 */
	getServices(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedService>>>;

}
