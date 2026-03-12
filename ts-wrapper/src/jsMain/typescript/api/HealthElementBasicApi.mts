// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {HealthElementBasicInGroupApi} from './HealthElementBasicInGroupApi.mjs';


export interface HealthElementBasicApi {

	inGroup: HealthElementBasicInGroupApi;

	/**
	 *
	 *  Get the ids of all health elements matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchHealthElementsBySorted] instead.
	 *
	 *  @param filter a health element filter
	 *  @return a list of health element ids
	 */
	matchHealthElementsBy(filter: BaseFilterOptions<HealthElement>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all health elements matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchHealthElementsBy].
	 *
	 *  @param filter a health element filter
	 *  @return a list of health element ids
	 */
	matchHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): Promise<Array<string>>;

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
	filterHealthElementsBy(filter: BaseFilterOptions<HealthElement>): Promise<PaginatedListIterator<EncryptedHealthElement>>;

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
	filterHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<EncryptedHealthElement>>;

	/**
	 *
	 *  Deletes a healthElement. If you don't have write access to the healthElement the method will fail.
	 *  @param entityId id of the healthElement.
	 *  @param rev the latest known rev of the healthElement to delete
	 *  @return the id and revision of the deleted healthElement.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteHealthElementById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many healthElements. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the healthElements to delete.
	 *  @return the id and revision of the deleted healthElements. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a healthElement.
	 *  @param id id of the healthElement to purge
	 *  @param rev latest revision of the healthElement
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeHealthElementById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many healthElements.
	 *  @param entityIds ids and revisions of the healthElements to delete
	 *  @return the id and revision of the deleted healthElements. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a healthElement. If you don't have write access to the healthElement the method will fail.
	 *  @param healthElement the healthElement to delete
	 *  @return the id and revision of the deleted healthElement.
	 *  @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	deleteHealthElement(healthElement: HealthElement): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many healthElements. Ignores healthElement for which you don't have write access or that don't match the latest revision.
	 *  @param healthElements the healthElements to delete
	 *  @return the id and revision of the deleted healthElements. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a healthElement.
	 *  @param healthElement the healthElement to purge.
	 *  @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	purgeHealthElement(healthElement: HealthElement): Promise<void>;

	/**
	 *
	 *  Permanently deletes many healthElements.
	 *  @param healthElements the healthElements to purge.
	 *  @return the id and revision of the deleted healthElements. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeHealthElements(healthElements: Array<HealthElement>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Create a new health element. The provided health element must have the encryption metadata initialized.
	 *  @param entity a health element with initialized encryption metadata
	 *  @return the created health element with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createHealthElement(entity: EncryptedHealthElement): Promise<EncryptedHealthElement>;

	/**
	 *
	 *  Create multiple health elements. All the provided health elements must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities health elements with initialized encryption metadata
	 *  @return the created health elements with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any health element in the input was not initialized.
	 */
	createHealthElements(entities: Array<EncryptedHealthElement>): Promise<Array<EncryptedHealthElement>>;

	/**
	 *
	 *  Restores a healthElement that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteHealthElementById(id: string, rev: string): Promise<EncryptedHealthElement>;

	/**
	 *
	 *  Restores a batch of healthElementIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the healthElementIds to restore.
	 *  @return the restored healthElementIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedHealthElement>>;

	/**
	 *
	 *  Restores a healthElement that was marked as deleted.
	 *  @param healthElement the healthElement to undelete
	 *  @return the restored healthElement.
	 *  @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	undeleteHealthElement(healthElement: HealthElement): Promise<EncryptedHealthElement>;

	/**
	 *
	 *  Restores a batch of healthElements that were marked as deleted.
	 *  @param healthElements the healthElements to restore.
	 *  @return the restored healthElements. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<EncryptedHealthElement>>;

	/**
	 *
	 *  Modifies a health element. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a health element with update content
	 *  @return the health element updated with the provided content and a new revision.
	 */
	modifyHealthElement(entity: EncryptedHealthElement): Promise<EncryptedHealthElement>;

	/**
	 *
	 *  Modifies multiple health elements. Ignores all health elements for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities health elements with update content
	 *  @return the updated health elements with a new revision.
	 */
	modifyHealthElements(entities: Array<EncryptedHealthElement>): Promise<Array<EncryptedHealthElement>>;

	/**
	 *
	 *  Get a health element by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a health element, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a health element id.
	 *  @return the health element with id [entityId].
	 */
	getHealthElement(entityId: string): Promise<EncryptedHealthElement | undefined>;

	/**
	 *
	 *  Get multiple health elements by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a health element, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of health elements ids
	 *  @return all health elements that you can access with one of the provided ids.
	 */
	getHealthElements(entityIds: Array<string>): Promise<Array<EncryptedHealthElement>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<HealthElement>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedHealthElement>>;

}
