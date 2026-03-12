// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {AccessLogShareOptions} from '../crypto/entities/AccessLogShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {AccessLog, DecryptedAccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {AccessLogFlavouredApi} from './AccessLogFlavouredApi.mjs';
import {AccessLogInGroupApi} from './AccessLogInGroupApi.mjs';


export interface AccessLogApi {

	encrypted: AccessLogFlavouredApi<EncryptedAccessLog>;

	tryAndRecover: AccessLogFlavouredApi<AccessLog>;

	inGroup: AccessLogInGroupApi;

	/**
	 *
	 *  Creates a new access log with initialized encryption metadata
	 *  @param base an access log with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the access log.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new access log
	 *  @return an access log with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedAccessLog | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedAccessLog>;

	/**
	 *
	 *  Attempts to extract the encryption keys of an access log. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param accessLog an access log
	 *  @return the encryption keys extracted from the provided access log.
	 */
	getEncryptionKeysOf(accessLog: AccessLog): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to an access log through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param accessLog an access log
	 *  @return if the current user has write access to the provided access log
	 */
	hasWriteAccess(accessLog: AccessLog): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to an access log.
	 *  Note: access logs usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param accessLog an access log
	 *  @return the id of the patient linked to the access log, or empty if the current user can't access any patient id
	 *  of the access log.
	 */
	decryptPatientIdOf(accessLog: AccessLog): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of an entity.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided entity. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the `entity` the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any AccessLog,
	 *  not only in the provided entity.
	 *
	 *  ## Example
	 *
	 *  If you have an access log E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any access log that you have shared with P, H will be able to know that the access log was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to an access log that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity an access log
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: AccessLog,
			delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts an access log, throwing an exception if it is not possible.
	 *  @param accessLog an encrypted access log
	 *  @return the decrypted access log
	 *  @throws EntityEncryptionException if the access log could not be decrypted
	 */
	decrypt(accessLog: EncryptedAccessLog): Promise<DecryptedAccessLog>;

	/**
	 *
	 *  Tries to decrypt an access log, returns the input if it is not possible.
	 *  @param accessLog an encrypted access log
	 *  @return the decrypted access log if the decryption was successful or the input if it was not.
	 */
	tryDecrypt(accessLog: EncryptedAccessLog): Promise<AccessLog>;

	/**
	 *
	 *  Get the ids of all access logs matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchAccessLogsBySorted] instead.
	 *
	 *  @param filter an access log filter
	 *  @return a list of access log ids
	 */
	matchAccessLogsBy(filter: FilterOptions<AccessLog>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all access logs matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchAccessLogsBy].
	 *
	 *  @param filter an access log filter
	 *  @return a list of access log ids
	 */
	matchAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): Promise<Array<string>>;

	/**
	 *
	 *  Deletes a accessLog. If you don't have write access to the accessLog the method will fail.
	 *  @param entityId id of the accessLog.
	 *  @param rev the latest known rev of the accessLog to delete
	 *  @return the id and revision of the deleted accessLog.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteAccessLogById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many accessLogs. Ids that don't correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the accessLogs to delete.
	 *  @return the id and revision of the deleted accessLogs. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a accessLog.
	 *  @param id id of the accessLog to purge
	 *  @param rev latest revision of the accessLog
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeAccessLogById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many accessLogs.
	 *  @param entityIds ids and revisions of the accessLogs to delete
	 *  @return the id and revision of the deleted accessLogs. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a accessLog. If you don't have write access to the accessLog the method will fail.
	 *  @param accessLog the accessLog to delete
	 *  @return the id and revision of the deleted accessLog.
	 *  @throws RevisionConflictException if the provided accessLog doesn't match the latest known revision
	 */
	deleteAccessLog(accessLog: AccessLog): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many accessLogs. Ignores accessLog for which you don't have write access or that don't match the latest revision.
	 *  @param accessLogs the accessLogs to delete
	 *  @return the id and revision of the deleted accessLogs. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a accessLog.
	 *  @param accessLog the accessLog to purge.
	 *  @throws RevisionConflictException if the provided accessLog doesn't match the latest known revision
	 */
	purgeAccessLog(accessLog: AccessLog): Promise<void>;

	/**
	 *
	 *  Permanently deletes many accessLogs.
	 *  @param accessLogs the accessLogs to purge.
	 *  @return the id and revision of the deleted accessLogs. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Share an access log with another data owner.
	 *  @param delegateId the owner that will gain access to [accessLog]
	 *  @param accessLog the access log to share with [delegateId]
	 *  @param options specifies how the access log will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the access log.
	 *  @return the updated access log
	 */
	shareWith(delegateId: string, accessLog: DecryptedAccessLog,
			options?: { options?: AccessLogShareOptions | undefined }): Promise<DecryptedAccessLog>;

	/**
	 *
	 *  Share an access log with multiple data owners.
	 *  @param accessLog the access log to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated access log.
	 */
	shareWithMany(accessLog: DecryptedAccessLog,
			delegates: { [ key: string ]: AccessLogShareOptions }): Promise<DecryptedAccessLog>;

	/**
	 *
	 *  Get an iterator that iterates through all access logs matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterAccessLogsBySorted] instead.
	 *
	 *  @param filter an access log filter
	 *  @return an iterator that iterates over all access logs matching the provided filter.
	 */
	filterAccessLogsBy(filter: FilterOptions<AccessLog>): Promise<PaginatedListIterator<DecryptedAccessLog>>;

	/**
	 *
	 *  Get an iterator that iterates through all access logs matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterAccessLogsBy].
	 *
	 *  @param filter an access log filter
	 *  @return an iterator that iterates over all access logs matching the provided filter.
	 */
	filterAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<DecryptedAccessLog>>;

	/**
	 *
	 *  Create a new access log. The provided access log must have the encryption metadata initialized.
	 *  @param entity an access log with initialized encryption metadata
	 *  @return the created access log with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	/**
	 *
	 *  Create a batch of new access logs. All the provided access log must have the encryption metadata initialized.
	 *  @param entities the accessLogs with initialized encryption metadata
	 *  @return the created access logs with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	createAccessLogs(entities: Array<DecryptedAccessLog>): Promise<Array<DecryptedAccessLog>>;

	/**
	 *
	 *  Restores a accessLog that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteAccessLogById(id: string, rev: string): Promise<DecryptedAccessLog>;

	/**
	 *
	 *  Restores a batch of accessLogs that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the accessLogs to restore.
	 *  @return the restored accessLogs. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedAccessLog>>;

	/**
	 *
	 *  Restores a accessLog that was marked as deleted.
	 *  @param accessLog the accessLog to undelete
	 *  @return the restored accessLog.
	 *  @throws RevisionConflictException if the provided accessLog doesn't match the latest known revision
	 */
	undeleteAccessLog(accessLog: AccessLog): Promise<DecryptedAccessLog>;

	/**
	 *
	 *  Restores a batch of accessLogs that were marked as deleted.
	 *  @param accessLogs the accessLogs to restore.
	 *  @return the restored accessLogs. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<DecryptedAccessLog>>;

	/**
	 *
	 *  Modifies an access log. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity an access log with update content
	 *  @return the updated access log with a new revision.
	 */
	modifyAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	/**
	 *
	 *  Modifies a batch of accessLogs.
	 *  Flavoured method-
	 *  @param entities the updated accessLogs.
	 *  @return the updated accessLogs with their new revisions. If some entities couldn't be updated (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	modifyAccessLogs(entities: Array<DecryptedAccessLog>): Promise<Array<DecryptedAccessLog>>;

	/**
	 *
	 *  Get an access log by its id. You must have read access to the access log. Fails if the access log does not exist
	 *  or if you don't have read access to it.
	 *  Flavoured method.
	 *  @param entityId an access log id.
	 *  @return the access log with id [entityId].
	 */
	getAccessLog(entityId: string): Promise<DecryptedAccessLog | undefined>;

	/**
	 *
	 *  Get multiple access logs by their ids. Ignores all ids that do not exist, or access logs that you can't access.
	 *  Flavoured method.
	 *  @param entityIds a list of access log ids
	 *  @return all access logs that you can access with one of the provided ids.
	 */
	getAccessLogs(entityIds: Array<string>): Promise<Array<DecryptedAccessLog>>;

}
