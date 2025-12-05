// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {AccessLogShareOptions} from '../crypto/entities/AccessLogShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {AccessLog, DecryptedAccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {AccessLogFlavouredApi} from './AccessLogFlavouredApi.mjs';
import {AccessLogInGroupApi} from './AccessLogInGroupApi.mjs';


export interface AccessLogApi {

	encrypted: AccessLogFlavouredApi<EncryptedAccessLog>;

	tryAndRecover: AccessLogFlavouredApi<AccessLog>;

	inGroup: AccessLogInGroupApi;

	withEncryptionMetadata(base: DecryptedAccessLog | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedAccessLog>;

	getEncryptionKeysOf(accessLog: AccessLog): Promise<Array<HexString>>;

	hasWriteAccess(accessLog: AccessLog): Promise<boolean>;

	decryptPatientIdOf(accessLog: AccessLog): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: AccessLog,
			delegates: Array<string>): Promise<void>;

	decrypt(accessLog: EncryptedAccessLog): Promise<DecryptedAccessLog>;

	tryDecrypt(accessLog: EncryptedAccessLog): Promise<AccessLog>;

	matchAccessLogsBy(filter: FilterOptions<AccessLog>): Promise<Array<string>>;

	matchAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): Promise<Array<string>>;

	deleteAccessLogUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteAccessLogsUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteAccessLogById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAccessLogById(id: string, rev: string): Promise<void>;

	deleteAccessLog(accessLog: AccessLog): Promise<StoredDocumentIdentifier>;

	deleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAccessLog(accessLog: AccessLog): Promise<void>;

	shareWith(delegateId: string, accessLog: DecryptedAccessLog,
			options?: { options?: AccessLogShareOptions | undefined }): Promise<DecryptedAccessLog>;

	shareWithMany(accessLog: DecryptedAccessLog,
			delegates: { [ key: string ]: AccessLogShareOptions }): Promise<DecryptedAccessLog>;

	findAccessLogsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedAccessLog>>;

	filterAccessLogsBy(filter: FilterOptions<AccessLog>): Promise<PaginatedListIterator<DecryptedAccessLog>>;

	filterAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<DecryptedAccessLog>>;

	createAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	undeleteAccessLogById(id: string, rev: string): Promise<DecryptedAccessLog>;

	undeleteAccessLog(accessLog: AccessLog): Promise<DecryptedAccessLog>;

	modifyAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	getAccessLog(entityId: string): Promise<DecryptedAccessLog | undefined>;

	getAccessLogs(entityIds: Array<string>): Promise<Array<DecryptedAccessLog>>;

	findAccessLogsBy(
			fromEpoch: number | undefined,
			toEpoch: number | undefined,
			startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<DecryptedAccessLog>>;

	findAccessLogsByUserAfterDate(userId: string,
			options?: { accessType?: string | undefined, startDate?: number | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedList<DecryptedAccessLog>>;

	findAccessLogsInGroup(groupId: string,
			options?: { fromEpoch?: number | undefined, toEpoch?: number | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedAccessLog>>;

}
