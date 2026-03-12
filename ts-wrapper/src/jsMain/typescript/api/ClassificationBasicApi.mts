// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Classification, EncryptedClassification} from '../model/Classification.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface ClassificationBasicApi {

	/**
	 *
	 *  Get the ids of all classifications matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchClassificationsBySorted] instead.
	 *
	 *  @param filter a classification filter
	 *  @return a list of classification ids
	 */
	matchClassificationsBy(filter: BaseFilterOptions<Classification>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all classifications matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchClassificationsBy].
	 *
	 *  @param filter a classification filter
	 *  @return a list of classification ids
	 */
	matchClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): Promise<Array<string>>;

	/**
	 *
	 *  Get an iterator that iterates through all classifications matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterClassificationsBySorted] instead.
	 *
	 *  @param filter a classification filter
	 *  @return an iterator that iterates over all classifications matching the provided filter.
	 */
	filterClassificationsBy(filter: BaseFilterOptions<Classification>): Promise<PaginatedListIterator<EncryptedClassification>>;

	/**
	 *
	 *  Get an iterator that iterates through all classifications matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterClassificationsBy].
	 *
	 *  @param filter a classification filter
	 *  @return an iterator that iterates over all classifications matching the provided filter.
	 */
	filterClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): Promise<PaginatedListIterator<EncryptedClassification>>;

	/**
	 *
	 *  Deletes a classification. If you don't have write access to the classification the method will fail.
	 *  @param entityId id of the classification.
	 *  @return the id and revision of the deleted classification.
	 */
	deleteClassification(entityId: string): Promise<DocIdentifier>;

	/**
	 *
	 *  Deletes many classifications. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids of the classifications.
	 *  @return the id and revision of the deleted classifications. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteClassifications(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	/**
	 *
	 *  Create a new classification. The provided classification must have the encryption metadata initialized.
	 *  @param entity a classification with initialized encryption metadata
	 *  @return the created classification with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createClassification(entity: EncryptedClassification): Promise<EncryptedClassification>;

	/**
	 *
	 *  Modifies a classification. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a classification with update content
	 *  @return the classification updated with the provided content and a new revision.
	 */
	modifyClassification(entity: EncryptedClassification): Promise<EncryptedClassification>;

	/**
	 *
	 *  Get a classification by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a classification, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a classification id.
	 *  @return the classification with id [entityId].
	 */
	getClassification(entityId: string): Promise<EncryptedClassification | undefined>;

	/**
	 *
	 *  Get multiple classifications by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a classification, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of classifications ids
	 *  @return all classifications that you can access with one of the provided ids.
	 */
	getClassifications(entityIds: Array<string>): Promise<Array<EncryptedClassification>>;

}
