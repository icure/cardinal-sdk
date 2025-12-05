// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {AccessLogShareOptions} from '../crypto/entities/AccessLogShareOptions.mjs';
import {AccessLog} from '../model/AccessLog.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface AccessLogFlavouredInGroupApi<E extends AccessLog> {

	shareWith(delegate: EntityReferenceInGroup, accessLog: GroupScoped<E>,
			options?: { options?: AccessLogShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(accessLog: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: AccessLogShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	filterAccessLogsBy(groupId: string,
			filter: FilterOptions<AccessLog>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterAccessLogsBySorted(groupId: string,
			filter: SortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createAccessLog(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyAccessLog(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	getAccessLog(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getAccessLogs(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
