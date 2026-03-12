// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface HealthElementBasicInGroupApi {

	/**
	 *
	 *  In-group version of [HealthElementApi.matchHealthElementsBy]
	 */
	matchHealthElementsBy(groupId: string,
			filter: BaseFilterOptions<HealthElement>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.matchHealthElementsBySorted]
	 */
	matchHealthElementsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<HealthElement>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.filterHealthElementsBy]
	 */
	filterHealthElementsBy(groupId: string,
			filter: BaseFilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<EncryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.filterHealthElementsBySorted]
	 */
	filterHealthElementsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<EncryptedHealthElement>>>;

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
	 *  In-group version of [HealthElementApi.createHealthElement]
	 */
	createHealthElement(entity: GroupScoped<EncryptedHealthElement>): Promise<GroupScoped<EncryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementApi.createHealthElements]
	 */
	createHealthElements(entities: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElementById]
	 */
	undeleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElementsByIds]
	 */
	undeleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElement]
	 */
	undeleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<EncryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElements]
	 */
	undeleteHealthElements(healthElements: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.modifyHealthElement]
	 */
	modifyHealthElement(entity: GroupScoped<EncryptedHealthElement>): Promise<GroupScoped<EncryptedHealthElement>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.modifyHealthElements]
	 */
	modifyHealthElements(entities: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.getHealthElement]
	 */
	getHealthElement(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedHealthElement> | undefined>;

	/**
	 *
	 *  In-group version of [HealthElementBasicFlavouredApi.getHealthElements]
	 */
	getHealthElements(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

}
