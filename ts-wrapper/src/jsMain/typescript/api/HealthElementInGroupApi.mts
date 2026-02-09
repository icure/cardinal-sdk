// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {DecryptedHealthElement, EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {HealthElementFlavouredInGroupApi} from './HealthElementFlavouredInGroupApi.mjs';


export interface HealthElementInGroupApi {

	encrypted: HealthElementFlavouredInGroupApi<EncryptedHealthElement>;

	tryAndRecover: HealthElementFlavouredInGroupApi<HealthElement>;

	withEncryptionMetadata(entityGroupId: string, base: DecryptedHealthElement | undefined,
			patient: GroupScoped<Patient>,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedHealthElement>>;

	getEncryptionKeysOf(healthElement: GroupScoped<HealthElement>): Promise<Array<HexString>>;

	hasWriteAccess(healthElement: GroupScoped<HealthElement>): Promise<boolean>;

	decryptPatientIdOf(healthElement: GroupScoped<HealthElement>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<HealthElement>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(healthElements: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	tryDecrypt(healthElements: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<HealthElement>>>;

	encryptOrValidate(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	matchHealthElementsBy(groupId: string,
			filter: FilterOptions<HealthElement>): Promise<Array<string>>;

	matchHealthElementsBySorted(groupId: string,
			filter: SortableFilterOptions<HealthElement>): Promise<Array<string>>;

	deleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteHealthElements(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeHealthElement(healthElement: GroupScoped<HealthElement>): Promise<void>;

	purgeHealthElements(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	shareWith(delegate: EntityReferenceInGroup, healthElement: GroupScoped<DecryptedHealthElement>,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<GroupScoped<DecryptedHealthElement>>;

	shareWithMany(healthElement: GroupScoped<DecryptedHealthElement>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: HealthElementShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedHealthElement>>;

	filterHealthElementsBy(groupId: string,
			filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<DecryptedHealthElement>>>;

	filterHealthElementsBySorted(groupId: string,
			filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<DecryptedHealthElement>>>;

	createHealthElement(entity: GroupScoped<DecryptedHealthElement>): Promise<GroupScoped<DecryptedHealthElement>>;

	createHealthElements(entities: Array<GroupScoped<DecryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	undeleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedHealthElement>>;

	undeleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	undeleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<DecryptedHealthElement>>;

	undeleteHealthElements(healthElements: Array<GroupScoped<DecryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	modifyHealthElement(entity: GroupScoped<DecryptedHealthElement>): Promise<GroupScoped<DecryptedHealthElement>>;

	modifyHealthElements(entities: Array<GroupScoped<DecryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	getHealthElement(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedHealthElement> | undefined>;

	getHealthElements(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

}
