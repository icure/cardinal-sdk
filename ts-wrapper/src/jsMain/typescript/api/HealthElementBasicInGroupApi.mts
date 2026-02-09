// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface HealthElementBasicInGroupApi {

	matchHealthElementsBy(groupId: string,
			filter: BaseFilterOptions<HealthElement>): Promise<Array<string>>;

	matchHealthElementsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<HealthElement>): Promise<Array<string>>;

	filterHealthElementsBy(groupId: string,
			filter: BaseFilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<EncryptedHealthElement>>>;

	filterHealthElementsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<EncryptedHealthElement>>>;

	deleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteHealthElements(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeHealthElement(healthElement: GroupScoped<HealthElement>): Promise<void>;

	purgeHealthElements(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createHealthElement(entity: GroupScoped<EncryptedHealthElement>): Promise<GroupScoped<EncryptedHealthElement>>;

	createHealthElements(entities: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	undeleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedHealthElement>>;

	undeleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	undeleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<EncryptedHealthElement>>;

	undeleteHealthElements(healthElements: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	modifyHealthElement(entity: GroupScoped<EncryptedHealthElement>): Promise<GroupScoped<EncryptedHealthElement>>;

	modifyHealthElements(entities: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	getHealthElement(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedHealthElement> | undefined>;

	getHealthElements(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

}
