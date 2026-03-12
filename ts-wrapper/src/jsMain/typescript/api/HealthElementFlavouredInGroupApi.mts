// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {HealthElement} from '../model/HealthElement.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface HealthElementFlavouredInGroupApi<E extends HealthElement> {

	/**
	 *
	 *  In-group version of [HealthElementFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, healthElement: GroupScoped<E>,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [HealthElementFlavouredApi.shareWithMany]
	 */
	shareWithMany(healthElement: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: HealthElementShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [HealthElementFlavouredApi.filterHealthElementsBy]
	 */
	filterHealthElementsBy(groupId: string,
			filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [HealthElementFlavouredApi.filterHealthElementsBySorted]
	 */
	filterHealthElementsBySorted(groupId: string,
			filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.createHealthElement]
	 */
	createHealthElement(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.createHealthElements]
	 */
	createHealthElements(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElementById]
	 */
	undeleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElementsByIds]
	 */
	undeleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElement]
	 */
	undeleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElements]
	 */
	undeleteHealthElements(healthElements: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.modifyHealthElement]
	 */
	modifyHealthElement(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.modifyHealthElements]
	 */
	modifyHealthElements(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.getHealthElement]
	 */
	getHealthElement(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.getHealthElements]
	 */
	getHealthElements(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
