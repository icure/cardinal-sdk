// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {HealthElement} from '../model/HealthElement.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface HealthElementFlavouredInGroupApi<E extends HealthElement> {

	shareWith(delegate: EntityReferenceInGroup, healthElement: GroupScoped<E>,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(healthElement: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: HealthElementShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	filterHealthElementsBy(groupId: string,
			filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterHealthElementsBySorted(groupId: string,
			filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createHealthElement(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createHealthElements(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteHealthElementsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteHealthElement(healthElement: GroupScoped<HealthElement>): Promise<GroupScoped<E>>;

	undeleteHealthElements(healthElements: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyHealthElement(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyHealthElements(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getHealthElement(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getHealthElements(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
