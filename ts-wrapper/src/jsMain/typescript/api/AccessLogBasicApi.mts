// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {AccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {AccessLogBasicInGroupApi} from './AccessLogBasicInGroupApi.mjs';


export interface AccessLogBasicApi {

	inGroup: AccessLogBasicInGroupApi;

	matchAccessLogsBy(filter: BaseFilterOptions<AccessLog>): Promise<Array<string>>;

	matchAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): Promise<Array<string>>;

	filterAccessLogsBy(filter: BaseFilterOptions<AccessLog>): Promise<PaginatedListIterator<EncryptedAccessLog>>;

	filterAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<EncryptedAccessLog>>;

	deleteAccessLogById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAccessLogById(id: string, rev: string): Promise<void>;

	purgeAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteAccessLog(accessLog: AccessLog): Promise<StoredDocumentIdentifier>;

	deleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAccessLog(accessLog: AccessLog): Promise<void>;

	purgeAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<StoredDocumentIdentifier>>;

	createAccessLog(entity: EncryptedAccessLog): Promise<EncryptedAccessLog>;

	createAccessLogs(entities: Array<EncryptedAccessLog>): Promise<Array<EncryptedAccessLog>>;

	undeleteAccessLogById(id: string, rev: string): Promise<EncryptedAccessLog>;

	undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedAccessLog>>;

	undeleteAccessLog(accessLog: AccessLog): Promise<EncryptedAccessLog>;

	undeleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<EncryptedAccessLog>>;

	modifyAccessLog(entity: EncryptedAccessLog): Promise<EncryptedAccessLog>;

	modifyAccessLogs(entities: Array<EncryptedAccessLog>): Promise<Array<EncryptedAccessLog>>;

	getAccessLog(entityId: string): Promise<EncryptedAccessLog | undefined>;

	getAccessLogs(entityIds: Array<string>): Promise<Array<EncryptedAccessLog>>;

}
