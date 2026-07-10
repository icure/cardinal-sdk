package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface MaintenanceTaskBasicFlavourlessApi {
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteMaintenanceTaskUnsafe(entityId: String): DocIdentifier
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteMaintenanceTasksUnsafe(entityIds: List<String>): List<DocIdentifier>

	/**
	 * Deletes a maintenanceTask. If you don't have write access to the maintenanceTask the method will fail.
	 * @param entityId id of the maintenanceTask.
	 * @param rev the latest known rev of the maintenanceTask to delete
	 * @return the id and revision of the deleted maintenanceTask.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteMaintenanceTaskById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many maintenanceTasks. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the maintenanceTasks to delete.
	 * @return the id and revision of the deleted maintenanceTasks. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteMaintenanceTasksByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier>

	/**
	 * Permanently deletes a maintenanceTask.
	 * @param id id of the maintenanceTask to purge
	 * @param rev latest revision of the maintenanceTask
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeMaintenanceTaskById(id: String, rev: String)

	/**
	 * Deletes a maintenanceTask. If you don't have write access to the maintenanceTask the method will fail.
	 * @param maintenanceTask the maintenanceTask to delete
	 * @return the id and revision of the deleted maintenanceTask.
	 * @throws RevisionConflictException if the provided maintenanceTask doesn't match the latest known revision
	 */
	suspend fun deleteMaintenanceTask(maintenanceTask: MaintenanceTask): DocIdentifier =
		deleteMaintenanceTaskById(maintenanceTask.id, requireNotNull(maintenanceTask.rev) { "Can't delete a maintenanceTask that has no rev" })

	/**
	 * Deletes many maintenanceTasks. Ignores maintenanceTask for which you don't have write access or that don't match the latest revision.
	 * @param maintenanceTasks the maintenanceTasks to delete
	 * @return the id and revision of the deleted maintenanceTasks. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteMaintenanceTasks(maintenanceTasks: List<MaintenanceTask>): List<DocIdentifier> =
		deleteMaintenanceTasksByIds(maintenanceTasks.map { maintenanceTask ->
			StoredDocumentIdentifier(maintenanceTask.id, requireNotNull(maintenanceTask.rev) { "Can't delete a maintenanceTask that has no rev" })
		})

	/**
	 * Permanently deletes a maintenanceTask.
	 * @param maintenanceTask the maintenanceTask to purge.
	 * @throws RevisionConflictException if the provided maintenanceTask doesn't match the latest known revision
	 */
	suspend fun purgeMaintenanceTask(maintenanceTask: MaintenanceTask) {
		purgeMaintenanceTaskById(maintenanceTask.id, requireNotNull(maintenanceTask.rev) { "Can't delete a maintenanceTask that has no rev" })
	}
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface MaintenanceTaskBasicFlavouredApi<E : MaintenanceTask> {
	/**
	 * Create a new maintenance task. The provided maintenance task must have the encryption metadata initialized.
	 * @param entity a maintenance task with initialized encryption metadata
	 * @return the created maintenance task with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createMaintenanceTask(entity: E): E

	/**
	 * Restores a maintenanceTask that was marked as deleted.
	 * @param maintenanceTask the maintenanceTask to undelete
	 * @return the restored maintenanceTask.
	 * @throws RevisionConflictException if the provided maintenanceTask doesn't match the latest known revision
	 */
	suspend fun undeleteMaintenanceTask(maintenanceTask: MaintenanceTask): MaintenanceTask =
		undeleteMaintenanceTaskById(maintenanceTask.id, requireNotNull(maintenanceTask.rev) { "Can't delete a maintenanceTask that has no rev" })

	/**
	 * Restores a maintenanceTask that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteMaintenanceTaskById(id: String, rev: String): E

	/**
	 * Modifies a maintenance task. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a maintenance task with update content
	 * @return the maintenance task updated with the provided content and a new revision.
	 */
	suspend fun modifyMaintenanceTask(entity: E): E

	/**
	 * Get a maintenance task by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a maintenance task, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a maintenance task id.
	 * @return the maintenance task with id [entityId].
	 */
	suspend fun getMaintenanceTask(entityId: String): E?

	/**
	 * Get multiple maintenance tasks by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a maintenance task, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of maintenance tasks ids
	 * @return all maintenance tasks that you can access with one of the provided ids.
	 */
	suspend fun getMaintenanceTasks(entityIds: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface MaintenanceTaskFlavouredApi<E : MaintenanceTask> : MaintenanceTaskBasicFlavouredApi<E> {
	/**
	 * Share a maintenance task with another data owner. The maintenance task must already exist in the database for this method to
	 * succeed. If you want to share the maintenance task before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * @param delegateId the owner that will gain access to the maintenance task
	 * @param maintenanceTask the maintenance task to share with [delegateId]
	 * @param options specifies how the maintenance task will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the maintenance task. Refer
	 * to the documentation of [MaintenanceTaskShareOptions] for more information.
	 * @return the updated maintenance task if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		maintenanceTask: E,
		@DefaultValue("null")
		options: MaintenanceTaskShareOptions? = null
	): E

	/**
	 * Share a maintenance task with multiple data owners. The maintenance task must already exist in the database for this method to
	 * succeed. If you want to share the maintenance task before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * Throws an exception if the operation fails.
	 * @param maintenanceTask the maintenance task to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated maintenance task.
	 */
	suspend fun shareWithMany(
		maintenanceTask: E,
		delegates: Map<String, MaintenanceTaskShareOptions>
	): E

	/**
	 * Get an iterator that iterates through all maintenance tasks matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterMaintenanceTasksBySorted] instead.
	 *
	 * @param filter a maintenance task filter
	 * @return an iterator that iterates over all maintenance tasks matching the provided filter.
	 */
	suspend fun filterMaintenanceTasksBy(
		filter: FilterOptions<MaintenanceTask>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all maintenance tasks matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterMaintenanceTasksBy].
	 *
	 * @param filter a maintenance task filter
	 * @return an iterator that iterates over all maintenance tasks matching the provided filter.
	 */
	suspend fun filterMaintenanceTasksBySorted(
		filter: SortableFilterOptions<MaintenanceTask>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface MaintenanceTaskApi : MaintenanceTaskBasicFlavourlessApi, MaintenanceTaskFlavouredApi<DecryptedMaintenanceTask>, Subscribable<MaintenanceTask, EncryptedMaintenanceTask, FilterOptions<MaintenanceTask>> {
	/**
	 * Creates a maintenance task with initialized encryption metadata, using the provided maintenance task as a base.
	 * @param maintenanceTask a maintenance task with initialized content, to be used as a base for the result.
	 * @param user the current user. If provided the auto-delegations from the user will be used in addition to
	 * [delegates], and the user details will be used to autofill author information (if not provided author information
	 * will be autofilled by the server for explicit data owners).
	 * @param delegates users that will be granted access to the maintenance task (in addition to the current data owner
	 * and, if user is non-null, auto-delegations).
	 */
	suspend fun withEncryptionMetadata(
		maintenanceTask: DecryptedMaintenanceTask?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedMaintenanceTask

	/**
	 * Attempts to extract the encryption keys of a maintenance task. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param maintenanceTask a maintenance task
	 * @return the encryption keys extracted from the provided maintenance task.
	 */
	suspend fun getEncryptionKeysOf(maintenanceTask: MaintenanceTask): Set<HexString>

	/**
	 * Specifies if the current user has write access to a maintenance task through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 * side this method will still return true if there is a delegation to the parent.
	 * @param maintenanceTask a maintenance task
	 * @return if the current user has write access to the provided maintenance task
	 */
	suspend fun hasWriteAccess(maintenanceTask: MaintenanceTask): Boolean

	/**
	 * Attempts to extract the patient id linked to a maintenance task.
	 * Note: maintenance tasks usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param maintenanceTask a maintenance task
	 * @return the id of the patient linked to the maintenance task, or empty if the current user can't access any patient id
	 * of the maintenance task.
	 */
	suspend fun decryptPatientIdOf(maintenanceTask: MaintenanceTask): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a maintenance task.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided maintenance task. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the maintenance task the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any MaintenanceTask,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a maintenance task E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any maintenance task that you have shared with P, H will be able to know that the maintenance task was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a maintenance task that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a maintenance task
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTask, delegates: Set<String>)

	/**
	 * Decrypts maintenance tasks, throwing an exception if it is not possible.
	 * @param maintenanceTasks encrypted maintenance tasks
	 * @return the decrypted maintenance tasks
	 * @throws EntityEncryptionException if any of the provided maintenance tasks couldn't be decrypted
	 */
	suspend fun decrypt(maintenanceTasks: List<EncryptedMaintenanceTask>): List<DecryptedMaintenanceTask>

	/**
	 * Tries to decrypt a maintenance tasks, returns the input if it is not possible.
	 * @param maintenanceTasks encrypted maintenance tasks
	 * @return all the provided maintenance task, each of them decrypted if possible or unchanged (still encrypted)
	 */
	suspend fun tryDecrypt(maintenanceTasks: List<EncryptedMaintenanceTask>): List<MaintenanceTask>

	/**
	 * Decrypts a maintenance task, throwing an exception if it is not possible.
	 * @param maintenanceTask a maintenance task
	 * @return the decrypted maintenance task
	 * @throws EntityEncryptionException if the maintenance task could not be decrypted
	 */
	suspend fun decrypt(maintenanceTask: EncryptedMaintenanceTask): DecryptedMaintenanceTask =
		decrypt(listOf(maintenanceTask)).single()

	/**
	 * Tries to decrypt a maintenance task, returns the input if it is not possible.
	 * @param maintenanceTask an encrypted maintenance task
	 * @return the decrypted maintenance task if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(maintenanceTask: EncryptedMaintenanceTask): MaintenanceTask =
		tryDecrypt(listOf(maintenanceTask)).single()

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask>

	/**
	 * Get the ids of all maintenance tasks matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchMaintenanceTasksBySorted] instead.
	 *
	 * @param filter a maintenance task filter
	 * @return a list of maintenance task ids
	 */
	suspend fun matchMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): List<String>

	/**
	 * Get the ids of all maintenance tasks matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchMaintenanceTasksBy].
	 *
	 * @param filter a maintenance task filter
	 * @return a list of maintenance task ids
	 */
	suspend fun matchMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): List<String>
}

interface MaintenanceTaskBasicApi : MaintenanceTaskBasicFlavourlessApi, MaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask>, Subscribable<MaintenanceTask, EncryptedMaintenanceTask, BaseFilterOptions<MaintenanceTask>> {
	/**
	 * Get the ids of all maintenance tasks matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchMaintenanceTasksBySorted] instead.
	 *
	 * @param filter a maintenance task filter
	 * @return a list of maintenance task ids
	 */
	suspend fun matchMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): List<String>

	/**
	 * Get the ids of all maintenance tasks matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchMaintenanceTasksBy].
	 *
	 * @param filter a maintenance task filter
	 * @return a list of maintenance task ids
	 */
	suspend fun matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): List<String>

	/**
	 * Get an iterator that iterates through all maintenance tasks matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterMaintenanceTasksBySorted] instead.
	 *
	 * @param filter a maintenance task filter
	 * @return an iterator that iterates over all maintenance tasks matching the provided filter.
	 */
	suspend fun filterMaintenanceTasksBy(
		filter: BaseFilterOptions<MaintenanceTask>
	): PaginatedListIterator<EncryptedMaintenanceTask>

	/**
	 * Get an iterator that iterates through all maintenance tasks matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterMaintenanceTasksBy].
	 *
	 * @param filter a maintenance task filter
	 * @return an iterator that iterates over all maintenance tasks matching the provided filter.
	 */
	suspend fun filterMaintenanceTasksBySorted(
		filter: BaseSortableFilterOptions<MaintenanceTask>
	): PaginatedListIterator<EncryptedMaintenanceTask>
}
