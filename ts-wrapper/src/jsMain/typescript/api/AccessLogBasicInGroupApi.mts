// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {AccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface AccessLogBasicInGroupApi {

	matchAccessLogsBy(groupId: string, filter: BaseFilterOptions<AccessLog>): Promise<Array<string>>;

	matchAccessLogsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<AccessLog>): Promise<Array<string>>;

	filterAccessLogsBy(groupId: string,
			filter: BaseFilterOptions<AccessLog>): Promise<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>>;

	filterAccessLogsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>>;

	deleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteAccessLog(accessLog: GroupScoped<AccessLog>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeAccessLog(accessLog: GroupScoped<AccessLog>): Promise<void>;

	purgeAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createAccessLog(entity: GroupScoped<EncryptedAccessLog>): Promise<GroupScoped<EncryptedAccessLog>>;

	createAccessLogs(entities: Array<GroupScoped<EncryptedAccessLog>>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

	undeleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedAccessLog>>;

	undeleteAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

	undeleteAccessLog(accessLog: GroupScoped<AccessLog>): Promise<GroupScoped<EncryptedAccessLog>>;

	undeleteAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

	modifyAccessLog(entity: GroupScoped<EncryptedAccessLog>): Promise<GroupScoped<EncryptedAccessLog>>;

	modifyAccessLogs(entities: Array<GroupScoped<EncryptedAccessLog>>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

	getAccessLog(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedAccessLog> | undefined>;

	getAccessLogs(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

}
