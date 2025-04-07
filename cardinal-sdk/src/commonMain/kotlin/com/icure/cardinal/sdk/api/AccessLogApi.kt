package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.AccessLogShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface AccessLogBasicFlavourlessApi {
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteAccessLogUnsafe(entityId: String): DocIdentifier
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteAccessLogsUnsafe(entityIds: List<String>): List<DocIdentifier>

	/**
	 * Deletes a accessLog. If you don't have write access to the accessLog the method will fail.
	 * @param entityId id of the accessLog.
	 * @param rev the latest known rev of the accessLog to delete
	 * @return the id and revision of the deleted accessLog.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteAccessLogById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many accessLogs. Ids that don't correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the accessLogs to delete.
	 * @return the id and revision of the deleted accessLogs. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteAccessLogsByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier>

	/**
	 * Permanently deletes a accessLog.
	 * @param id id of the accessLog to purge
	 * @param rev latest revision of the accessLog
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeAccessLogById(id: String, rev: String)

	/**
	 * Deletes a accessLog. If you don't have write access to the accessLog the method will fail.
	 * @param accessLog the accessLog to delete
	 * @return the id and revision of the deleted accessLog.
	 * @throws RevisionConflictException if the provided accessLog doesn't match the latest known revision
	 */
	suspend fun deleteAccessLog(accessLog: AccessLog): DocIdentifier =
		deleteAccessLogById(accessLog.id, requireNotNull(accessLog.rev) { "Can't delete an accessLog that has no rev" })

	/**
	 * Deletes many accessLogs. Ignores accessLog for which you don't have write access or that don't match the latest revision.
	 * @param accessLogs the accessLogs to delete
	 * @return the id and revision of the deleted accessLogs. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteAccessLogs(accessLogs: List<AccessLog>): List<DocIdentifier> =
		deleteAccessLogsByIds(accessLogs.map { accessLog ->
			StoredDocumentIdentifier(accessLog.id, requireNotNull(accessLog.rev) { "Can't delete an accessLog that has no rev" })
		})

	/**
	 * Permanently deletes a accessLog.
	 * @param accessLog the accessLog to purge.
	 * @throws RevisionConflictException if the provided accessLog doesn't match the latest known revision
	 */
	suspend fun purgeAccessLog(accessLog: AccessLog) {
		purgeAccessLogById(accessLog.id, requireNotNull(accessLog.rev) { "Can't delete an accessLog that has no rev" })
	}
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface AccessLogBasicFlavouredApi<E : AccessLog> {
	/**
	 * Create a new access log. The provided access log must have the encryption metadata initialized.
	 * @param entity an access log with initialized encryption metadata
	 * @return the created access log with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createAccessLog(entity: E): E

	/**
	 * Restores a accessLog that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteAccessLogById(id: String, rev: String): E

	/**
	 * Restores a accessLog that was marked as deleted.
	 * @param accessLog the accessLog to undelete
	 * @return the restored accessLog.
	 * @throws RevisionConflictException if the provided accessLog doesn't match the latest known revision
	 */
	suspend fun undeleteAccessLog(accessLog: AccessLog): E =
		undeleteAccessLogById(accessLog.id, requireNotNull(accessLog.rev) { "Can't delete an accessLog that has no rev" })

	/**
	 * Modifies an access log. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity an access log with update content
	 * @return the updated access log with a new revision.
	 */
	suspend fun modifyAccessLog(entity: E): E

	/**
	 * Get an access log by its id. You must have read access to the access log. Fails if the access log does not exist
	 * or if you don't have read access to it.
	 * Flavoured method.
	 * @param entityId an access log id.
	 * @return the access log with id [entityId].
	 */
	suspend fun getAccessLog(entityId: String): E

	/**
	 * Get multiple access logs by their ids. Ignores all ids that do not exist, or access logs that you can't access.
	 * Flavoured method.
	 * @param entityIds a list of access log ids
	 * @return all access logs that you can access with one of the provided ids.
	 */
	suspend fun getAccessLogs(entityIds: List<String>): List<E>

	@Deprecated("Replaced with filter")
	suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E>

	@Deprecated("Use filter instead")
	suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		@DefaultValue("null")
		accessType: String? = null,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedList<E>

	@Deprecated("Use filter instead")
	suspend fun findAccessLogsInGroup(
		groupId: String,
		@DefaultValue("null")
		fromEpoch: Long? = null,
		@DefaultValue("null")
		toEpoch: Long? = null,
		@DefaultValue("null")
		startKey: Long? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface AccessLogFlavouredApi<E : AccessLog> : AccessLogBasicFlavouredApi<E> {
	/**
	 * Share an access log with another data owner.
	 * @param delegateId the owner that will gain access to [accessLog]
	 * @param accessLog the access log to share with [delegateId]
	 * @param options specifies how the access log will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the access log.
	 * @return the updated access log
	 */
	suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		@DefaultValue("null")
		options: AccessLogShareOptions? = null,
	): E

	/**
	 * Share an access log with multiple data owners.
	 * @param accessLog the access log to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated access log.
	 */
	suspend fun shareWithMany(
		accessLog: E,
		delegates: Map<String, AccessLogShareOptions>
	): E

	@Deprecated("Use filter instead")
	suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all access logs matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterAccessLogsBySorted] instead.
	 *
	 * @param filter a access log filter
	 * @return an iterator that iterates over all access logs matching the provided filter.
	 */
	suspend fun filterAccessLogsBy(
		filter: FilterOptions<AccessLog>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all access logs matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterAccessLogsBy].
	 *
	 * @param filter a access log filter
	 * @return an iterator that iterates over all access logs matching the provided filter.
	 */
	suspend fun filterAccessLogsBySorted(
		filter: SortableFilterOptions<AccessLog>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface AccessLogApi : AccessLogBasicFlavourlessApi, AccessLogFlavouredApi<DecryptedAccessLog> {
	/**
	 * Creates a new access log with initialized encryption metadata
	 * @param base an access log with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the access log.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new access log
	 * @return an access log with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedAccessLog?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
	): DecryptedAccessLog

	/**
	 * Attempts to extract the encryption keys of an access log. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param accessLog an access log
	 * @return the encryption keys extracted from the provided access log.
	 */
	suspend fun getEncryptionKeysOf(accessLog: AccessLog): Set<HexString>

	/**
	 * Specifies if the current user has write access to an access log through delegations.
 	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
 	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
 	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
 	 * side this method will still return true if there is a delegation to the parent.
	 * @param accessLog an access log
	 * @return if the current user has write access to the provided access log
	 */
	suspend fun hasWriteAccess(accessLog: AccessLog): Boolean

	/**
	 * Attempts to extract the patient id linked to an access log.
	 * Note: access logs usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param accessLog an access log
	 * @return the id of the patient linked to the access log, or empty if the current user can't access any patient id
	 * of the access log.
	 */
	suspend fun decryptPatientIdOf(accessLog: AccessLog): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of an entity.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided entity. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the `entity` the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any AccessLog,
	 * not only in the provided entity.
	 *
	 * ## Example
	 *
	 * If you have an access log E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any access log that you have shared with P, H will be able to know that the access log was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to an access log that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 * 
	 * @param entity an access log
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: AccessLog, delegates: Set<String>)

	/**
	 * Decrypts an access log, throwing an exception if it is not possible.
	 * @param accessLog an encrypted access log
	 * @return the decrypted access log
	 * @throws EntityEncryptionException if the access log could not be decrypted
	 */
	suspend fun decrypt(accessLog: EncryptedAccessLog): DecryptedAccessLog

	/**
	 * Tries to decrypt an access log, returns the input if it is not possible.
	 * @param accessLog an encrypted access log
	 * @return the decrypted access log if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(accessLog: EncryptedAccessLog): AccessLog

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: AccessLogFlavouredApi<EncryptedAccessLog>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: AccessLogFlavouredApi<AccessLog>

	/**
	 * Get the ids of all access logs matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchAccessLogsBySorted] instead.
	 *
	 * @param filter a access log filter
	 * @return a list of access log ids
	 */
	suspend fun matchAccessLogsBy(filter: FilterOptions<AccessLog>): List<String>

	/**
	 * Get the ids of all access logs matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchAccessLogsBy].
	 *
	 * @param filter a access log filter
	 * @return a list of access log ids
	 */
	suspend fun matchAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): List<String>
}

interface AccessLogBasicApi : AccessLogBasicFlavourlessApi, AccessLogBasicFlavouredApi<EncryptedAccessLog> {
	/**
	 * Get the ids of all access logs matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchAccessLogsBySorted] instead.
	 *
	 * @param filter a access log filter
	 * @return a list of access log ids
	 */
	suspend fun matchAccessLogsBy(filter: BaseFilterOptions<AccessLog>): List<String>

	/**
	 * Get the ids of all access logs matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchAccessLogsBy].
	 *
	 * @param filter a access log filter
	 * @return a list of access log ids
	 */
	suspend fun matchAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): List<String>

	/**
	 * Get an iterator that iterates through all access logs matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterAccessLogsBySorted] instead.
	 *
	 * @param filter a access log filter
	 * @return an iterator that iterates over all access logs matching the provided filter.
	 */
	suspend fun filterAccessLogsBy(
		filter: BaseFilterOptions<AccessLog>
	): PaginatedListIterator<EncryptedAccessLog>

	/**
	 * Get an iterator that iterates through all access logs matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterAccessLogsBy].
	 *
	 * @param filter a access log filter
	 * @return an iterator that iterates over all access logs matching the provided filter.
	 */
	suspend fun filterAccessLogsBySorted(
		filter: BaseSortableFilterOptions<AccessLog>
	): PaginatedListIterator<EncryptedAccessLog>
}
