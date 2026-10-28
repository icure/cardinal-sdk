// auto-generated file
import {CustomEntityDelegateOptions} from '../crypto/entities/CustomEntityDelegateOptions.mjs';
import {CustomEntityOwningEntity} from '../crypto/entities/CustomEntityOwningEntity.mjs';
import {CustomEntityShareOptions} from '../crypto/entities/CustomEntityShareOptions.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {CustomEntityBase, DecryptedCustomEntityBase, EncryptedCustomEntityBase} from '../model/CustomEntityBase.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {HasEncryptionMetadata} from '../model/base/HasEncryptionMetadata.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {CustomEntityFlavouredInGroupApi} from './CustomEntityFlavouredInGroupApi.mjs';


export interface CustomEntityInGroupApi {

	encrypted: CustomEntityFlavouredInGroupApi<EncryptedCustomEntityBase>;

	tryAndRecover: CustomEntityFlavouredInGroupApi<CustomEntityBase>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedCustomEntityBase | undefined,
			options?: { owningEntity?: CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>> | undefined, user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.withEncryptionMetadataAndDelegates]
	 */
	withEncryptionMetadataAndDelegates(entityGroupId: string,
			base: DecryptedCustomEntityBase | undefined,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, delegateOptions: CustomEntityDelegateOptions }, 'delegate'>,
			options?: { owningEntity?: CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>> | undefined, user?: User | undefined, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(entity: GroupScoped<CustomEntityBase>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.getSecretIdsOf]
	 */
	getSecretIdsOf(entity: GroupScoped<CustomEntityBase>): Promise<{ [ key: string ]: Array<EntityReferenceInGroup> }>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.hasWriteAccess]
	 */
	hasWriteAccess(entity: GroupScoped<CustomEntityBase>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.decryptOwningEntityIdsOf]
	 */
	decryptOwningEntityIdsOf(entity: GroupScoped<CustomEntityBase>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<CustomEntityBase>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.decrypt]
	 */
	decrypt(entities: Array<GroupScoped<EncryptedCustomEntityBase>>): Promise<Array<GroupScoped<DecryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.tryDecrypt]
	 */
	tryDecrypt(entities: Array<GroupScoped<EncryptedCustomEntityBase>>): Promise<Array<GroupScoped<CustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityApi.encryptOrValidate]
	 */
	encryptOrValidate(entities: Array<GroupScoped<CustomEntityBase>>): Promise<Array<GroupScoped<EncryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.deleteEntityById]
	 */
	deleteEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.deleteEntitiesByIds]
	 */
	deleteEntitiesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.purgeEntityById]
	 */
	purgeEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.purgeEntitiesByIds]
	 */
	purgeEntitiesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.deleteEntity]
	 */
	deleteEntity(entity: GroupScoped<CustomEntityBase>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.deleteEntities]
	 */
	deleteEntities(entities: Array<GroupScoped<CustomEntityBase>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.purgeEntity]
	 */
	purgeEntity(entity: GroupScoped<CustomEntityBase>): Promise<void>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.purgeEntities]
	 */
	purgeEntities(entities: Array<GroupScoped<CustomEntityBase>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavourlessApi.getDataOwnersWithAccessTo].
	 */
	getDataOwnersWithAccessTo(entity: GroupScoped<CustomEntityBase>): Promise<EntityAccessInformation>;

	/**
	 *
	 *  In-group version of [CustomEntityFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, entity: GroupScoped<DecryptedCustomEntityBase>,
			options?: { options?: CustomEntityShareOptions | undefined }): Promise<GroupScoped<DecryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityFlavouredApi.shareWithMany]
	 */
	shareWithMany(entity: GroupScoped<DecryptedCustomEntityBase>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: CustomEntityShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.createEntity]
	 */
	createEntity(entity: GroupScoped<DecryptedCustomEntityBase>): Promise<GroupScoped<DecryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.createEntities]
	 */
	createEntities(entities: Array<GroupScoped<DecryptedCustomEntityBase>>): Promise<Array<GroupScoped<DecryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntityById]
	 */
	undeleteEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntitiesByIds]
	 */
	undeleteEntitiesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntity]
	 */
	undeleteEntity(entity: GroupScoped<CustomEntityBase>): Promise<GroupScoped<DecryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntities]
	 */
	undeleteEntities(entities: Array<GroupScoped<CustomEntityBase>>): Promise<Array<GroupScoped<DecryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.modifyEntity]
	 */
	modifyEntity(entity: GroupScoped<DecryptedCustomEntityBase>): Promise<GroupScoped<DecryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.modifyEntities]
	 */
	modifyEntities(entities: Array<GroupScoped<DecryptedCustomEntityBase>>): Promise<Array<GroupScoped<DecryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.getEntity]
	 */
	getEntity(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedCustomEntityBase> | undefined>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.getEntities]
	 */
	getEntities(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedCustomEntityBase>>>;

}
