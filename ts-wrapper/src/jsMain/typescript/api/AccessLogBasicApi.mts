// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {AccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {AccessLogBasicInGroupApi} from './AccessLogBasicInGroupApi.mjs';


export interface AccessLogBasicApi {

	inGroup: AccessLogBasicInGroupApi;

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
	matchAccessLogsBy(filter: BaseFilterOptions<AccessLog>): Promise<Array<string>>;

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
	matchAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): Promise<Array<string>>;

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
	filterAccessLogsBy(filter: BaseFilterOptions<AccessLog>): Promise<PaginatedListIterator<EncryptedAccessLog>>;

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
	filterAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<EncryptedAccessLog>>;

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
	 *  Create a new access log. The provided access log must have the encryption metadata initialized.
	 *  @param entity an access log with initialized encryption metadata
	 *  @return the created access log with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createAccessLog(entity: EncryptedAccessLog): Promise<EncryptedAccessLog>;

	/**
	 *
	 *  Create a batch of new access logs. All the provided access log must have the encryption metadata initialized.
	 *  @param entities the accessLogs with initialized encryption metadata
	 *  @return the created access logs with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	createAccessLogs(entities: Array<EncryptedAccessLog>): Promise<Array<EncryptedAccessLog>>;

	/**
	 *
	 *  Restores a accessLog that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteAccessLogById(id: string, rev: string): Promise<EncryptedAccessLog>;

	/**
	 *
	 *  Restores a batch of accessLogs that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the accessLogs to restore.
	 *  @return the restored accessLogs. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedAccessLog>>;

	/**
	 *
	 *  Restores a accessLog that was marked as deleted.
	 *  @param accessLog the accessLog to undelete
	 *  @return the restored accessLog.
	 *  @throws RevisionConflictException if the provided accessLog doesn't match the latest known revision
	 */
	undeleteAccessLog(accessLog: AccessLog): Promise<EncryptedAccessLog>;

	/**
	 *
	 *  Restores a batch of accessLogs that were marked as deleted.
	 *  @param accessLogs the accessLogs to restore.
	 *  @return the restored accessLogs. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<EncryptedAccessLog>>;

	/**
	 *
	 *  Modifies an access log. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity an access log with update content
	 *  @return the updated access log with a new revision.
	 */
	modifyAccessLog(entity: EncryptedAccessLog): Promise<EncryptedAccessLog>;

	/**
	 *
	 *  Modifies a batch of accessLogs.
	 *  Flavoured method-
	 *  @param entities the updated accessLogs.
	 *  @return the updated accessLogs with their new revisions. If some entities couldn't be updated (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	modifyAccessLogs(entities: Array<EncryptedAccessLog>): Promise<Array<EncryptedAccessLog>>;

	/**
	 *
	 *  Get an access log by its id. You must have read access to the access log. Fails if the access log does not exist
	 *  or if you don't have read access to it.
	 *  Flavoured method.
	 *  @param entityId an access log id.
	 *  @return the access log with id [entityId].
	 */
	getAccessLog(entityId: string): Promise<EncryptedAccessLog | undefined>;

	/**
	 *
	 *  Get multiple access logs by their ids. Ignores all ids that do not exist, or access logs that you can't access.
	 *  Flavoured method.
	 *  @param entityIds a list of access log ids
	 *  @return all access logs that you can access with one of the provided ids.
	 */
	getAccessLogs(entityIds: Array<string>): Promise<Array<EncryptedAccessLog>>;

}
