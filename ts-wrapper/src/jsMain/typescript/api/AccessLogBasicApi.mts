// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {AccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLogBasicInGroupApi} from './AccessLogBasicInGroupApi.mjs';


export interface AccessLogBasicApi {

	inGroup: AccessLogBasicInGroupApi;

	matchAccessLogsBy(filter: BaseFilterOptions<AccessLog>): Promise<Array<string>>;

	matchAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): Promise<Array<string>>;

	filterAccessLogsBy(filter: BaseFilterOptions<AccessLog>): Promise<PaginatedListIterator<EncryptedAccessLog>>;

	filterAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<EncryptedAccessLog>>;

	deleteAccessLogUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteAccessLogsUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteAccessLogById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAccessLogById(id: string, rev: string): Promise<void>;

	deleteAccessLog(accessLog: AccessLog): Promise<StoredDocumentIdentifier>;

	deleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAccessLog(accessLog: AccessLog): Promise<void>;

	createAccessLog(entity: EncryptedAccessLog): Promise<EncryptedAccessLog>;

	undeleteAccessLogById(id: string, rev: string): Promise<EncryptedAccessLog>;

	undeleteAccessLog(accessLog: AccessLog): Promise<EncryptedAccessLog>;

	modifyAccessLog(entity: EncryptedAccessLog): Promise<EncryptedAccessLog>;

	getAccessLog(entityId: string): Promise<EncryptedAccessLog | undefined>;

	getAccessLogs(entityIds: Array<string>): Promise<Array<EncryptedAccessLog>>;

	findAccessLogsBy(
			fromEpoch: number | undefined,
			toEpoch: number | undefined,
			startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<EncryptedAccessLog>>;

	findAccessLogsByUserAfterDate(userId: string,
			options?: { accessType?: string | undefined, startDate?: number | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedList<EncryptedAccessLog>>;

	findAccessLogsInGroup(groupId: string,
			options?: { fromEpoch?: number | undefined, toEpoch?: number | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedAccessLog>>;

}
