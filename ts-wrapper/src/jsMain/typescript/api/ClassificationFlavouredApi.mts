// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ClassificationShareOptions} from '../crypto/entities/ClassificationShareOptions.mjs';
import {Classification} from '../model/Classification.mjs';
import {Patient} from '../model/Patient.mjs';


export interface ClassificationFlavouredApi<E extends Classification> {

	/**
	 *
	 *  Share a classification with another data owner. The classification must already exist in the database for this method to
	 *  succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the classification
	 *  @param classification the classification to share with [delegateId]
	 *  @param options specifies how the classification will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the classification. Refer
	 *  to the documentation of [ClassificationShareOptions] for more information.
	 *  @return the updated classification if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, classification: E,
			options?: { options?: ClassificationShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share a classification with multiple data owners. The classification must already exist in the database for this method to
	 *  succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param classification the classification to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated classification.
	 */
	shareWithMany(classification: E,
			delegates: { [ key: string ]: ClassificationShareOptions }): Promise<E>;

	findClassificationsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

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
	filterClassificationsBy(filter: FilterOptions<Classification>): Promise<PaginatedListIterator<E>>;

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
	filterClassificationsBySorted(filter: SortableFilterOptions<Classification>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new classification. The provided classification must have the encryption metadata initialized.
	 *  @param entity a classification with initialized encryption metadata
	 *  @return the created classification with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createClassification(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies a classification. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a classification with update content
	 *  @return the classification updated with the provided content and a new revision.
	 */
	modifyClassification(entity: E): Promise<E>;

	/**
	 *
	 *  Get a classification by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a classification, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a classification id.
	 *  @return the classification with id [entityId].
	 */
	getClassification(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple classifications by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a classification, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of classifications ids
	 *  @return all classifications that you can access with one of the provided ids.
	 */
	getClassifications(entityIds: Array<string>): Promise<Array<E>>;

}
