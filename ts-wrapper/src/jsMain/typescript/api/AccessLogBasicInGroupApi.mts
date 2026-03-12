// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {AccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface AccessLogBasicInGroupApi {

	/**
	 *
	 *  In-group version of [AccessLogBasicApi.matchAccessLogsBy]
	 */
	matchAccessLogsBy(groupId: string, filter: BaseFilterOptions<AccessLog>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicApi.matchAccessLogsBySorted]
	 */
	matchAccessLogsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<AccessLog>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicApi.filterAccessLogsBy]
	 */
	filterAccessLogsBy(groupId: string,
			filter: BaseFilterOptions<AccessLog>): Promise<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicApi.filterAccessLogsBySorted]
	 */
	filterAccessLogsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavourlessApi.deleteAccessLogById]
	 */
	deleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavourlessApi.deleteAccessLogsByIds]
	 */
	deleteAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavourlessApi.purgeAccessLogById]
	 */
	purgeAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavourlessApi.purgeAccessLogsByIds]
	 */
	purgeAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavourlessApi.deleteAccessLog]
	 */
	deleteAccessLog(accessLog: GroupScoped<AccessLog>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavourlessApi.deleteAccessLogs]
	 */
	deleteAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavourlessApi.purgeAccessLog]
	 */
	purgeAccessLog(accessLog: GroupScoped<AccessLog>): Promise<void>;

	purgeAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.createAccessLog].
	 */
	createAccessLog(entity: GroupScoped<EncryptedAccessLog>): Promise<GroupScoped<EncryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.createAccessLogs].
	 */
	createAccessLogs(entities: Array<GroupScoped<EncryptedAccessLog>>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.undeleteAccessLogById]
	 */
	undeleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.undeleteAccessLogsByIds]
	 */
	undeleteAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.undeleteAccessLog]
	 */
	undeleteAccessLog(accessLog: GroupScoped<AccessLog>): Promise<GroupScoped<EncryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.undeleteAccessLogs]
	 */
	undeleteAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.modifyAccessLog]
	 */
	modifyAccessLog(entity: GroupScoped<EncryptedAccessLog>): Promise<GroupScoped<EncryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.modifyAccessLogs]
	 */
	modifyAccessLogs(entities: Array<GroupScoped<EncryptedAccessLog>>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.getAccessLog]
	 */
	getAccessLog(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedAccessLog> | undefined>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.getAccessLogs]
	 */
	getAccessLogs(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedAccessLog>>>;

}
