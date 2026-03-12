// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedMaintenanceTask, MaintenanceTask} from '../model/MaintenanceTask.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';


export interface MaintenanceTaskBasicApi {

	/**
	 *
	 *  Get the ids of all maintenance tasks matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchMaintenanceTasksBySorted] instead.
	 *
	 *  @param filter a maintenance task filter
	 *  @return a list of maintenance task ids
	 */
	matchMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all maintenance tasks matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchMaintenanceTasksBy].
	 *
	 *  @param filter a maintenance task filter
	 *  @return a list of maintenance task ids
	 */
	matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	/**
	 *
	 *  Get an iterator that iterates through all maintenance tasks matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterMaintenanceTasksBySorted] instead.
	 *
	 *  @param filter a maintenance task filter
	 *  @return an iterator that iterates over all maintenance tasks matching the provided filter.
	 */
	filterMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<EncryptedMaintenanceTask>>;

	/**
	 *
	 *  Get an iterator that iterates through all maintenance tasks matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterMaintenanceTasksBy].
	 *
	 *  @param filter a maintenance task filter
	 *  @return an iterator that iterates over all maintenance tasks matching the provided filter.
	 */
	filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<EncryptedMaintenanceTask>>;

	deleteMaintenanceTaskUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasksUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	/**
	 *
	 *  Deletes a maintenanceTask. If you don't have write access to the maintenanceTask the method will fail.
	 *  @param entityId id of the maintenanceTask.
	 *  @param rev the latest known rev of the maintenanceTask to delete
	 *  @return the id and revision of the deleted maintenanceTask.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteMaintenanceTaskById(entityId: string, rev: string): Promise<DocIdentifier>;

	/**
	 *
	 *  Deletes many maintenanceTasks. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the maintenanceTasks to delete.
	 *  @return the id and revision of the deleted maintenanceTasks. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteMaintenanceTasksByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DocIdentifier>>;

	/**
	 *
	 *  Permanently deletes a maintenanceTask.
	 *  @param id id of the maintenanceTask to purge
	 *  @param rev latest revision of the maintenanceTask
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeMaintenanceTaskById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Deletes a maintenanceTask. If you don't have write access to the maintenanceTask the method will fail.
	 *  @param maintenanceTask the maintenanceTask to delete
	 *  @return the id and revision of the deleted maintenanceTask.
	 *  @throws RevisionConflictException if the provided maintenanceTask doesn't match the latest known revision
	 */
	deleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<DocIdentifier>;

	/**
	 *
	 *  Deletes many maintenanceTasks. Ignores maintenanceTask for which you don't have write access or that don't match the latest revision.
	 *  @param maintenanceTasks the maintenanceTasks to delete
	 *  @return the id and revision of the deleted maintenanceTasks. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteMaintenanceTasks(maintenanceTasks: Array<MaintenanceTask>): Promise<Array<DocIdentifier>>;

	/**
	 *
	 *  Permanently deletes a maintenanceTask.
	 *  @param maintenanceTask the maintenanceTask to purge.
	 *  @throws RevisionConflictException if the provided maintenanceTask doesn't match the latest known revision
	 */
	purgeMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<void>;

	/**
	 *
	 *  Create a new maintenance task. The provided maintenance task must have the encryption metadata initialized.
	 *  @param entity a maintenance task with initialized encryption metadata
	 *  @return the created maintenance task with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	/**
	 *
	 *  Restores a maintenanceTask that was marked as deleted.
	 *  @param maintenanceTask the maintenanceTask to undelete
	 *  @return the restored maintenanceTask.
	 *  @throws RevisionConflictException if the provided maintenanceTask doesn't match the latest known revision
	 */
	undeleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<MaintenanceTask>;

	/**
	 *
	 *  Restores a maintenanceTask that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteMaintenanceTaskById(id: string, rev: string): Promise<EncryptedMaintenanceTask>;

	/**
	 *
	 *  Modifies a maintenance task. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a maintenance task with update content
	 *  @return the maintenance task updated with the provided content and a new revision.
	 */
	modifyMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	/**
	 *
	 *  Get a maintenance task by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a maintenance task, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a maintenance task id.
	 *  @return the maintenance task with id [entityId].
	 */
	getMaintenanceTask(entityId: string): Promise<EncryptedMaintenanceTask | undefined>;

	/**
	 *
	 *  Get multiple maintenance tasks by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a maintenance task, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of maintenance tasks ids
	 *  @return all maintenance tasks that you can access with one of the provided ids.
	 */
	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<EncryptedMaintenanceTask>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<MaintenanceTask>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMaintenanceTask>>;

}
