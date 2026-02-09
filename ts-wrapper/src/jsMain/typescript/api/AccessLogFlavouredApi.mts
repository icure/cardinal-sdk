// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {AccessLogShareOptions} from '../crypto/entities/AccessLogShareOptions.mjs';
import {AccessLog} from '../model/AccessLog.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface AccessLogFlavouredApi<E extends AccessLog> {

	shareWith(delegateId: string, accessLog: E,
			options?: { options?: AccessLogShareOptions | undefined }): Promise<E>;

	shareWithMany(accessLog: E, delegates: { [ key: string ]: AccessLogShareOptions }): Promise<E>;

	filterAccessLogsBy(filter: FilterOptions<AccessLog>): Promise<PaginatedListIterator<E>>;

	filterAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<E>>;

	createAccessLog(entity: E): Promise<E>;

	createAccessLogs(entities: Array<E>): Promise<Array<E>>;

	undeleteAccessLogById(id: string, rev: string): Promise<E>;

	undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteAccessLog(accessLog: AccessLog): Promise<E>;

	undeleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<E>>;

	modifyAccessLog(entity: E): Promise<E>;

	modifyAccessLogs(entities: Array<E>): Promise<Array<E>>;

	getAccessLog(entityId: string): Promise<E | undefined>;

	getAccessLogs(entityIds: Array<string>): Promise<Array<E>>;

}
