// auto-generated file
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {CustomEntityBase, EncryptedCustomEntityBase} from '../model/CustomEntityBase.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface CustomEntityBasicInGroupApi {

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
	 *  In-group version of [CustomEntityBasicFlavouredApi.createEntity]
	 */
	createEntity(entity: GroupScoped<EncryptedCustomEntityBase>): Promise<GroupScoped<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.createEntities]
	 */
	createEntities(entities: Array<GroupScoped<EncryptedCustomEntityBase>>): Promise<Array<GroupScoped<EncryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntityById]
	 */
	undeleteEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntitiesByIds]
	 */
	undeleteEntitiesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntity]
	 */
	undeleteEntity(entity: GroupScoped<CustomEntityBase>): Promise<GroupScoped<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntities]
	 */
	undeleteEntities(entities: Array<GroupScoped<CustomEntityBase>>): Promise<Array<GroupScoped<EncryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.modifyEntity]
	 */
	modifyEntity(entity: GroupScoped<EncryptedCustomEntityBase>): Promise<GroupScoped<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.modifyEntities]
	 */
	modifyEntities(entities: Array<GroupScoped<EncryptedCustomEntityBase>>): Promise<Array<GroupScoped<EncryptedCustomEntityBase>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.getEntity]
	 */
	getEntity(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedCustomEntityBase> | undefined>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.getEntities]
	 */
	getEntities(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedCustomEntityBase>>>;

}
