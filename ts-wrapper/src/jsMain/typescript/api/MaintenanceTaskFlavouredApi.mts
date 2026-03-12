// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MaintenanceTaskShareOptions} from '../crypto/entities/MaintenanceTaskShareOptions.mjs';
import {MaintenanceTask} from '../model/MaintenanceTask.mjs';


export interface MaintenanceTaskFlavouredApi<E extends MaintenanceTask> {

	/**
	 *
	 *  Share a maintenance task with another data owner. The maintenance task must already exist in the database for this method to
	 *  succeed. If you want to share the maintenance task before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the maintenance task
	 *  @param maintenanceTask the maintenance task to share with [delegateId]
	 *  @param options specifies how the maintenance task will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the maintenance task. Refer
	 *  to the documentation of [MaintenanceTaskShareOptions] for more information.
	 *  @return the updated maintenance task if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, maintenanceTask: E,
			options?: { options?: MaintenanceTaskShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share a maintenance task with multiple data owners. The maintenance task must already exist in the database for this method to
	 *  succeed. If you want to share the maintenance task before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param maintenanceTask the maintenance task to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated maintenance task.
	 */
	shareWithMany(maintenanceTask: E,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<E>;

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
	filterMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<E>>;

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
	filterMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new maintenance task. The provided maintenance task must have the encryption metadata initialized.
	 *  @param entity a maintenance task with initialized encryption metadata
	 *  @return the created maintenance task with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMaintenanceTask(entity: E): Promise<E>;

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
	undeleteMaintenanceTaskById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Modifies a maintenance task. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a maintenance task with update content
	 *  @return the maintenance task updated with the provided content and a new revision.
	 */
	modifyMaintenanceTask(entity: E): Promise<E>;

	/**
	 *
	 *  Get a maintenance task by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a maintenance task, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a maintenance task id.
	 *  @return the maintenance task with id [entityId].
	 */
	getMaintenanceTask(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple maintenance tasks by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a maintenance task, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of maintenance tasks ids
	 *  @return all maintenance tasks that you can access with one of the provided ids.
	 */
	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<E>>;

}
