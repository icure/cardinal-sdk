// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {RelatedPersonShareOptions} from '../crypto/entities/RelatedPersonShareOptions.mjs';
import {RelatedPerson} from '../model/RelatedPerson.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface RelatedPersonFlavouredApi<E extends RelatedPerson> {

	/**
	 *
	 *  Share a related person with another data owner. The related person must already exist in the database for this method to
	 *  succeed. If you want to share the related person before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the related person
	 *  @param relatedPerson the related person to share with [delegateId]
	 *  @param options specifies how the related person will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the related person. Refer
	 *  to the documentation of [RelatedPersonShareOptions] for more information.
	 *  @return the updated related person if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, relatedPerson: E,
			options?: { options?: RelatedPersonShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share a related person with multiple data owners. The related person must already exist in the database for this method to
	 *  succeed. If you want to share the related person before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param relatedPerson the related person to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated related person.
	 */
	shareWithMany(relatedPerson: E,
			delegates: { [ key: string ]: RelatedPersonShareOptions }): Promise<E>;

	/**
	 *
	 *  Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterRelatedPersonsBySorted] instead.
	 *
	 *  @param filter a related person filter
	 *  @return an iterator that iterates over all related persons matching the provided filter.
	 */
	filterRelatedPersonsBy(filter: FilterOptions<RelatedPerson>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterRelatedPersonsBy].
	 *
	 *  @param filter a related person filter
	 *  @return an iterator that iterates over all related persons matching the provided filter.
	 */
	filterRelatedPersonsBySorted(filter: SortableFilterOptions<RelatedPerson>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new related person. The provided related person must have the encryption metadata initialized.
	 *  @param entity a related person with initialized encryption metadata
	 *  @return the created related person with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createRelatedPerson(entity: E): Promise<E>;

	/**
	 *
	 *  Create multiple related persons. All the provided related persons must have the encryption metadata initialized,
	 *  otherwise this method fails without doing anything.
	 *  @param entities related persons with initialized encryption metadata
	 *  @return the created related persons with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any related person in the input was not initialized.
	 */
	createRelatedPersons(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a relatedPerson that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteRelatedPersonById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of relatedPersons that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the relatedPersons to restore.
	 *  @return the restored relatedPersons. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a relatedPerson that was marked as deleted.
	 *  @param relatedPerson the relatedPerson to undelete
	 *  @return the restored relatedPerson.
	 *  @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	undeleteRelatedPerson(relatedPerson: RelatedPerson): Promise<E>;

	/**
	 *
	 *  Restores a batch of relatedPersons that were marked as deleted.
	 *  @param relatedPersons the relatedPersons to restore.
	 *  @return the restored relatedPersons. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteRelatedPersons(relatedPersons: Array<RelatedPerson>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a related person. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a related person with update content
	 *  @return the related person updated with the provided content and a new revision.
	 */
	modifyRelatedPerson(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple related persons. Ignores all related persons for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities related persons with update content
	 *  @return the updated related persons with a new revision.
	 */
	modifyRelatedPersons(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a related person by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a related person, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a related person id.
	 *  @return the related person with id [entityId].
	 */
	getRelatedPerson(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple related persons by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a related person, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of related persons ids
	 *  @return all related persons that you can access with one of the provided ids.
	 */
	getRelatedPersons(entityIds: Array<string>): Promise<Array<E>>;

}
