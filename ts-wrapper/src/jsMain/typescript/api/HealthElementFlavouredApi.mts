// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {HealthElement} from '../model/HealthElement.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface HealthElementFlavouredApi<E extends HealthElement> {

	shareWith(delegateId: string, healthElement: E,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<E>;

	shareWithMany(healthElement: E,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<E>;

	filterHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<E>>;

	filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<E>>;

	createHealthElement(entity: E): Promise<E>;

	createHealthElements(entities: Array<E>): Promise<Array<E>>;

	undeleteHealthElementById(id: string, rev: string): Promise<E>;

	undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteHealthElement(healthElement: HealthElement): Promise<E>;

	undeleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<E>>;

	modifyHealthElement(entity: E): Promise<E>;

	modifyHealthElements(entities: Array<E>): Promise<Array<E>>;

	getHealthElement(entityId: string): Promise<E | undefined>;

	getHealthElements(entityIds: Array<string>): Promise<Array<E>>;

}
