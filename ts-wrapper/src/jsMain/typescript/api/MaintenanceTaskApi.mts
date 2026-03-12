// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MaintenanceTaskShareOptions} from '../crypto/entities/MaintenanceTaskShareOptions.mjs';
import {DecryptedMaintenanceTask, EncryptedMaintenanceTask, MaintenanceTask} from '../model/MaintenanceTask.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {MaintenanceTaskFlavouredApi} from './MaintenanceTaskFlavouredApi.mjs';


export interface MaintenanceTaskApi {

	encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>;

	tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask>;

	/**
	 *
	 *  Creates a maintenance task with initialized encryption metadata, using the provided maintenance task as a base.
	 *  @param maintenanceTask a maintenance task with initialized content, to be used as a base for the result.
	 *  @param user the current user. If provided the auto-delegations from the user will be used in addition to
	 *  [delegates], and the user details will be used to autofill author information (if not provided author information
	 *  will be autofilled by the server for explicit data owners).
	 *  @param delegates users that will be granted access to the maintenance task (in addition to the current data owner
	 *  and, if user is non-null, auto-delegations).
	 */
	withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTask | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, alternateRootDelegateId?: string | undefined }): Promise<DecryptedMaintenanceTask>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a maintenance task. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param maintenanceTask a maintenance task
	 *  @return the encryption keys extracted from the provided maintenance task.
	 */
	getEncryptionKeysOf(maintenanceTask: MaintenanceTask): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a maintenance task through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param maintenanceTask a maintenance task
	 *  @return if the current user has write access to the provided maintenance task
	 */
	hasWriteAccess(maintenanceTask: MaintenanceTask): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a maintenance task.
	 *  Note: maintenance tasks usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param maintenanceTask a maintenance task
	 *  @return the id of the patient linked to the maintenance task, or empty if the current user can't access any patient id
	 *  of the maintenance task.
	 */
	decryptPatientIdOf(maintenanceTask: MaintenanceTask): Promise<Array<string>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a maintenance task.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided maintenance task. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the maintenance task the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any MaintenanceTask,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a maintenance task E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any maintenance task that you have shared with P, H will be able to know that the maintenance task was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a maintenance task that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a maintenance task
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: MaintenanceTask,
			delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts a maintenance task, throwing an exception if it is not possible.
	 *  @param maintenanceTask a maintenance task
	 *  @return the decrypted maintenance task
	 *  @throws EntityEncryptionException if the maintenance task could not be decrypted
	 */
	decrypt(maintenanceTask: EncryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

	/**
	 *
	 *  Tries to decrypt a maintenance task, returns the input if it is not possible.
	 *  @param maintenanceTask an encrypted maintenance task
	 *  @return the decrypted maintenance task if the decryption was successful or the input if it was not.
	 */
	tryDecrypt(maintenanceTask: EncryptedMaintenanceTask): Promise<MaintenanceTask>;

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
	matchMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): Promise<Array<string>>;

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
	matchMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): Promise<Array<string>>;

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
	shareWith(delegateId: string, maintenanceTask: DecryptedMaintenanceTask,
			options?: { options?: MaintenanceTaskShareOptions | undefined }): Promise<DecryptedMaintenanceTask>;

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
	shareWithMany(maintenanceTask: DecryptedMaintenanceTask,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<DecryptedMaintenanceTask>;

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
	filterMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<DecryptedMaintenanceTask>>;

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
	filterMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<DecryptedMaintenanceTask>>;

	/**
	 *
	 *  Create a new maintenance task. The provided maintenance task must have the encryption metadata initialized.
	 *  @param entity a maintenance task with initialized encryption metadata
	 *  @return the created maintenance task with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMaintenanceTask(entity: DecryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

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
	undeleteMaintenanceTaskById(id: string, rev: string): Promise<DecryptedMaintenanceTask>;

	/**
	 *
	 *  Modifies a maintenance task. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a maintenance task with update content
	 *  @return the maintenance task updated with the provided content and a new revision.
	 */
	modifyMaintenanceTask(entity: DecryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

	/**
	 *
	 *  Get a maintenance task by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a maintenance task, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a maintenance task id.
	 *  @return the maintenance task with id [entityId].
	 */
	getMaintenanceTask(entityId: string): Promise<DecryptedMaintenanceTask | undefined>;

	/**
	 *
	 *  Get multiple maintenance tasks by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a maintenance task, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of maintenance tasks ids
	 *  @return all maintenance tasks that you can access with one of the provided ids.
	 */
	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<DecryptedMaintenanceTask>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<MaintenanceTask>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMaintenanceTask>>;

}
