// auto-generated file
import {CustomEntityShareOptions} from '../crypto/entities/CustomEntityShareOptions.mjs';
import {CustomEntityBase} from '../model/CustomEntityBase.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface CustomEntityFlavouredInGroupApi<E extends CustomEntityBase> {

	/**
	 *
	 *  In-group version of [CustomEntityFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, entity: GroupScoped<E>,
			options?: { options?: CustomEntityShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CustomEntityFlavouredApi.shareWithMany]
	 */
	shareWithMany(entity: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: CustomEntityShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.createEntity]
	 */
	createEntity(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.createEntities]
	 */
	createEntities(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntityById]
	 */
	undeleteEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntitiesByIds]
	 */
	undeleteEntitiesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntity]
	 */
	undeleteEntity(entity: GroupScoped<CustomEntityBase>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.undeleteEntities]
	 */
	undeleteEntities(entities: Array<GroupScoped<CustomEntityBase>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.modifyEntity]
	 */
	modifyEntity(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.modifyEntities]
	 */
	modifyEntities(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.getEntity]
	 */
	getEntity(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [CustomEntityBasicFlavouredApi.getEntities]
	 */
	getEntities(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
