// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {AccessLogShareOptions} from '../crypto/entities/AccessLogShareOptions.mjs';
import {AccessLog} from '../model/AccessLog.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface AccessLogFlavouredApi<E extends AccessLog> {

	/**
	 *
	 *  Share an access log with another data owner.
	 *  @param delegateId the owner that will gain access to [accessLog]
	 *  @param accessLog the access log to share with [delegateId]
	 *  @param options specifies how the access log will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the access log.
	 *  @return the updated access log
	 */
	shareWith(delegateId: string, accessLog: E,
			options?: { options?: AccessLogShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share an access log with multiple data owners.
	 *  @param accessLog the access log to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated access log.
	 */
	shareWithMany(accessLog: E, delegates: { [ key: string ]: AccessLogShareOptions }): Promise<E>;

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
	filterAccessLogsBy(filter: FilterOptions<AccessLog>): Promise<PaginatedListIterator<E>>;

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
	filterAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new access log. The provided access log must have the encryption metadata initialized.
	 *  @param entity an access log with initialized encryption metadata
	 *  @return the created access log with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createAccessLog(entity: E): Promise<E>;

	/**
	 *
	 *  Create a batch of new access logs. All the provided access log must have the encryption metadata initialized.
	 *  @param entities the accessLogs with initialized encryption metadata
	 *  @return the created access logs with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	createAccessLogs(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a accessLog that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteAccessLogById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of accessLogs that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the accessLogs to restore.
	 *  @return the restored accessLogs. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a accessLog that was marked as deleted.
	 *  @param accessLog the accessLog to undelete
	 *  @return the restored accessLog.
	 *  @throws RevisionConflictException if the provided accessLog doesn't match the latest known revision
	 */
	undeleteAccessLog(accessLog: AccessLog): Promise<E>;

	/**
	 *
	 *  Restores a batch of accessLogs that were marked as deleted.
	 *  @param accessLogs the accessLogs to restore.
	 *  @return the restored accessLogs. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies an access log. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity an access log with update content
	 *  @return the updated access log with a new revision.
	 */
	modifyAccessLog(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies a batch of accessLogs.
	 *  Flavoured method-
	 *  @param entities the updated accessLogs.
	 *  @return the updated accessLogs with their new revisions. If some entities couldn't be updated (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	modifyAccessLogs(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get an access log by its id. You must have read access to the access log. Fails if the access log does not exist
	 *  or if you don't have read access to it.
	 *  Flavoured method.
	 *  @param entityId an access log id.
	 *  @return the access log with id [entityId].
	 */
	getAccessLog(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple access logs by their ids. Ignores all ids that do not exist, or access logs that you can't access.
	 *  Flavoured method.
	 *  @param entityIds a list of access log ids
	 *  @return all access logs that you can access with one of the provided ids.
	 */
	getAccessLogs(entityIds: Array<string>): Promise<Array<E>>;

}
