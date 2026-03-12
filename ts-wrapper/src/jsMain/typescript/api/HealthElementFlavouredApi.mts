// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {HealthElement} from '../model/HealthElement.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface HealthElementFlavouredApi<E extends HealthElement> {

	/**
	 *
	 *  Share a health element with another data owner. The health element must already exist in the database for this method to
	 *  succeed. If you want to share the health element before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the health element
	 *  @param healthElement the health element to share with [delegateId]
	 *  @param options specifies how the health element will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the health element. Refer
	 *  to the documentation of [HealthElementShareOptions] for more information.
	 *  @return the updated health element if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, healthElement: E,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share a health element with multiple data owners. The health element must already exist in the database for this method to
	 *  succeed. If you want to share the health element before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param healthElement the health element to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated health element.
	 */
	shareWithMany(healthElement: E,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<E>;

	/**
	 *
	 *  Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterHealthElementsBySorted] instead.
	 *
	 *  @param filter a health element filter
	 *  @return an iterator that iterates over all health elements matching the provided filter.
	 */
	filterHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterHealthElementsBy].
	 *
	 *  @param filter a health element filter
	 *  @return an iterator that iterates over all health elements matching the provided filter.
	 */
	filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new health element. The provided health element must have the encryption metadata initialized.
	 *  @param entity a health element with initialized encryption metadata
	 *  @return the created health element with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createHealthElement(entity: E): Promise<E>;

	/**
	 *
	 *  Create multiple health elements. All the provided health elements must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities health elements with initialized encryption metadata
	 *  @return the created health elements with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any health element in the input was not initialized.
	 */
	createHealthElements(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a healthElement that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteHealthElementById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of healthElementIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the healthElementIds to restore.
	 *  @return the restored healthElementIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a healthElement that was marked as deleted.
	 *  @param healthElement the healthElement to undelete
	 *  @return the restored healthElement.
	 *  @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	undeleteHealthElement(healthElement: HealthElement): Promise<E>;

	/**
	 *
	 *  Restores a batch of healthElements that were marked as deleted.
	 *  @param healthElements the healthElements to restore.
	 *  @return the restored healthElements. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a health element. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a health element with update content
	 *  @return the health element updated with the provided content and a new revision.
	 */
	modifyHealthElement(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple health elements. Ignores all health elements for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities health elements with update content
	 *  @return the updated health elements with a new revision.
	 */
	modifyHealthElements(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a health element by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a health element, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a health element id.
	 *  @return the health element with id [entityId].
	 */
	getHealthElement(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple health elements by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a health element, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of health elements ids
	 *  @return all health elements that you can access with one of the provided ids.
	 */
	getHealthElements(entityIds: Array<string>): Promise<Array<E>>;

}
