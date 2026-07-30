// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {RelatedPersonDelegateOptions} from '../crypto/entities/RelatedPersonDelegateOptions.mjs';
import {RelatedPersonShareOptions} from '../crypto/entities/RelatedPersonShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {DecryptedRelatedPerson, EncryptedRelatedPerson, RelatedPerson} from '../model/RelatedPerson.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {RelatedPersonFlavouredInGroupApi} from './RelatedPersonFlavouredInGroupApi.mjs';


export interface RelatedPersonInGroupApi {

	encrypted: RelatedPersonFlavouredInGroupApi<EncryptedRelatedPerson>;

	tryAndRecover: RelatedPersonFlavouredInGroupApi<RelatedPerson>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedRelatedPerson | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.withEncryptionMetadataAndDelegates]
	 */
	withEncryptionMetadataAndDelegates(entityGroupId: string, base: DecryptedRelatedPerson | undefined,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, delegateOptions: RelatedPersonDelegateOptions }, 'delegate'>,
			options?: { user?: User | undefined, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(relatedPerson: GroupScoped<RelatedPerson>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.hasWriteAccess]
	 */
	hasWriteAccess(relatedPerson: GroupScoped<RelatedPerson>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.getSecretIdsOf]
	 */
	getSecretIdsOf(relatedPerson: GroupScoped<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<RelatedPerson>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.decrypt]
	 */
	decrypt(relatedPersons: Array<GroupScoped<EncryptedRelatedPerson>>): Promise<Array<GroupScoped<DecryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.tryDecrypt]
	 */
	tryDecrypt(relatedPersons: Array<GroupScoped<EncryptedRelatedPerson>>): Promise<Array<GroupScoped<RelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.encryptOrValidate]
	 */
	encryptOrValidate(relatedPersons: Array<GroupScoped<RelatedPerson>>): Promise<Array<GroupScoped<EncryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.matchRelatedPersonsBy]
	 */
	matchRelatedPersonsBy(groupId: string,
			filter: FilterOptions<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [RelatedPersonApi.matchRelatedPersonsBySorted]
	 */
	matchRelatedPersonsBySorted(groupId: string,
			filter: SortableFilterOptions<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersonById]
	 */
	deleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersonsByIds]
	 */
	deleteRelatedPersonsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersonById]
	 */
	purgeRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersonsByIds]
	 */
	purgeRelatedPersonsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPerson]
	 */
	deleteRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersons]
	 */
	deleteRelatedPersons(relatedPersons: Array<GroupScoped<RelatedPerson>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPerson]
	 */
	purgeRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): Promise<void>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersons]
	 */
	purgeRelatedPersons(relatedPersons: Array<GroupScoped<RelatedPerson>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, relatedPerson: GroupScoped<DecryptedRelatedPerson>,
			options?: { options?: RelatedPersonShareOptions | undefined }): Promise<GroupScoped<DecryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonFlavouredApi.shareWithMany]
	 */
	shareWithMany(relatedPerson: GroupScoped<DecryptedRelatedPerson>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: RelatedPersonShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonFlavouredApi.filterRelatedPersonsBy]
	 */
	filterRelatedPersonsBy(groupId: string,
			filter: FilterOptions<RelatedPerson>): Promise<PaginatedListIterator<GroupScoped<DecryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonFlavouredApi.filterRelatedPersonsBySorted]
	 */
	filterRelatedPersonsBySorted(groupId: string,
			filter: SortableFilterOptions<RelatedPerson>): Promise<PaginatedListIterator<GroupScoped<DecryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.createRelatedPerson]
	 */
	createRelatedPerson(entity: GroupScoped<DecryptedRelatedPerson>): Promise<GroupScoped<DecryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.createRelatedPersons]
	 */
	createRelatedPersons(entities: Array<GroupScoped<DecryptedRelatedPerson>>): Promise<Array<GroupScoped<DecryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersonById]
	 */
	undeleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersonsByIds]
	 */
	undeleteRelatedPersonsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPerson]
	 */
	undeleteRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): Promise<GroupScoped<DecryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersons]
	 */
	undeleteRelatedPersons(relatedPersons: Array<GroupScoped<DecryptedRelatedPerson>>): Promise<Array<GroupScoped<DecryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.modifyRelatedPerson]
	 */
	modifyRelatedPerson(entity: GroupScoped<DecryptedRelatedPerson>): Promise<GroupScoped<DecryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.modifyRelatedPersons]
	 */
	modifyRelatedPersons(entities: Array<GroupScoped<DecryptedRelatedPerson>>): Promise<Array<GroupScoped<DecryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.getRelatedPerson]
	 */
	getRelatedPerson(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedRelatedPerson> | undefined>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.getRelatedPersons]
	 */
	getRelatedPersons(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedRelatedPerson>>>;

}
