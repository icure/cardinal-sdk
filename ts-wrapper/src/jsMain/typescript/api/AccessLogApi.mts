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

	deleteAccessLogById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAccessLogById(id: string, rev: string): Promise<void>;

	purgeAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteAccessLog(accessLog: AccessLog): Promise<StoredDocumentIdentifier>;

	deleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<StoredDocumentIdentifier>>;

	purgeAccessLog(accessLog: AccessLog): Promise<void>;

	purgeAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<StoredDocumentIdentifier>>;

	shareWith(delegateId: string, accessLog: DecryptedAccessLog,
			options?: { options?: AccessLogShareOptions | undefined }): Promise<DecryptedAccessLog>;

	shareWithMany(accessLog: DecryptedAccessLog,
			delegates: { [ key: string ]: AccessLogShareOptions }): Promise<DecryptedAccessLog>;

	filterAccessLogsBy(filter: FilterOptions<AccessLog>): Promise<PaginatedListIterator<DecryptedAccessLog>>;

	filterAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<DecryptedAccessLog>>;

	createAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	createAccessLogs(entities: Array<DecryptedAccessLog>): Promise<Array<DecryptedAccessLog>>;

	undeleteAccessLogById(id: string, rev: string): Promise<DecryptedAccessLog>;

	undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedAccessLog>>;

	undeleteAccessLog(accessLog: AccessLog): Promise<DecryptedAccessLog>;

	undeleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<DecryptedAccessLog>>;

	modifyAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	modifyAccessLogs(entities: Array<DecryptedAccessLog>): Promise<Array<DecryptedAccessLog>>;

	getAccessLog(entityId: string): Promise<DecryptedAccessLog | undefined>;

	getAccessLogs(entityIds: Array<string>): Promise<Array<DecryptedAccessLog>>;

}
