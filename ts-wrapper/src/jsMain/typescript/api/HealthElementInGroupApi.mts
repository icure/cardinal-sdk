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

	/**
	 *
	 *  In-group version of [HealthElementApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedHealthElement | undefined,
			patient: GroupScoped<Patient>,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(healthElement: GroupScoped<HealthElement>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.hasWriteAccess]
	 */
	hasWriteAccess(healthElement: GroupScoped<HealthElement>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [HealthElementApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(healthElement: GroupScoped<HealthElement>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<HealthElement>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [HealthElementApi.decrypt]
	 */
	decrypt(healthElements: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.tryDecrypt]
	 */
	tryDecrypt(healthElements: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<HealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.encryptOrValidate]
	 */
	encryptOrValidate(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.matchHealthElementsBy]
	 */
	matchHealthElementsBy(groupId: string,
			filter: FilterOptions<HealthElement>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.matchHealthElementsBySorted]
	 */
	matchHealthElementsBySorted(groupId: string,
			filter: SortableFilterOptions<HealthElement>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavourlessApi.deleteHealthElementById]
	 */
	deleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavourlessApi.deleteHealthElementsByIds]
	 */
	deleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavourlessApi.purgeHealthElementById]
	 */
	purgeHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavourlessApi.purgeHealthElementsByIds]
	 */
	purgeHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavourlessApi.deleteHealthElement]
	 */
	deleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavourlessApi.deleteHealthElements]
	 */
	deleteHealthElements(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavourlessApi.purgeHealthElement]
	 */
	purgeHealthElement(healthElement: GroupScoped<HealthElement>): Promise<void>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavourlessApi.purgeHealthElements]
	 */
	purgeHealthElements(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [HealthElementFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, healthElement: GroupScoped<DecryptedHealthElement>,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<GroupScoped<DecryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementFlavouredApi.shareWithMany]
	 */
	shareWithMany(healthElement: GroupScoped<DecryptedHealthElement>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: HealthElementShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementFlavouredApi.filterHealthElementsBy]
	 */
	filterHealthElementsBy(groupId: string,
			filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<DecryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementFlavouredApi.filterHealthElementsBySorted]
	 */
	filterHealthElementsBySorted(groupId: string,
			filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<DecryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.createHealthElement]
	 */
	createHealthElement(entity: GroupScoped<DecryptedHealthElement>): Promise<GroupScoped<DecryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.createHealthElements]
	 */
	createHealthElements(entities: Array<GroupScoped<DecryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElementById]
	 */
	undeleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElementsByIds]
	 */
	undeleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElement]
	 */
	undeleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<DecryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElements]
	 */
	undeleteHealthElements(healthElements: Array<GroupScoped<DecryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.modifyHealthElement]
	 */
	modifyHealthElement(entity: GroupScoped<DecryptedHealthElement>): Promise<GroupScoped<DecryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.modifyHealthElements]
	 */
	modifyHealthElements(entities: Array<GroupScoped<DecryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.getHealthElement]
	 */
	getHealthElement(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedHealthElement> | undefined>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.getHealthElements]
	 */
	getHealthElements(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

}
