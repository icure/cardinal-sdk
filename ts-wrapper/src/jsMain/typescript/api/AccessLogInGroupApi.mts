// auto-generated file
import {FilterOptions, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {AccessLog, DecryptedAccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {AccessLogFlavouredInGroupApi} from './AccessLogFlavouredInGroupApi.mjs';


export interface AccessLogInGroupApi {

	encrypted: AccessLogFlavouredInGroupApi<EncryptedAccessLog>;

	tryAndRecover: AccessLogFlavouredInGroupApi<AccessLog>;

	withEncryptionMetadata(entityGroupId: string, base: DecryptedAccessLog | undefined,
			patient: GroupScoped<Patient>,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedAccessLog>>;

	getEncryptionKeysOf(accessLog: GroupScoped<AccessLog>): Promise<Array<HexString>>;

	hasWriteAccess(accessLog: GroupScoped<AccessLog>): Promise<boolean>;

	decryptPatientIdOf(accessLog: GroupScoped<AccessLog>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<AccessLog>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(accessLogs: Array<GroupScoped<EncryptedAccessLog>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	tryDecrypt(accessLogs: Array<GroupScoped<EncryptedAccessLog>>): Promise<Array<GroupScoped<AccessLog>>>;

	matchAccessLogsBy(groupId: string, filter: FilterOptions<AccessLog>): Promise<Array<string>>;

	matchAccessLogsBySorted(groupId: string,
			filter: SortableFilterOptions<AccessLog>): Promise<Array<string>>;

	deleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteAccessLog(accessLog: GroupScoped<AccessLog>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeAccessLog(accessLog: GroupScoped<AccessLog>): Promise<void>;

	purgeAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createAccessLog(entity: GroupScoped<DecryptedAccessLog>): Promise<GroupScoped<DecryptedAccessLog>>;

	createAccessLogs(entities: Array<GroupScoped<DecryptedAccessLog>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	undeleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedAccessLog>>;

	undeleteAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	undeleteAccessLog(accessLog: GroupScoped<AccessLog>): Promise<GroupScoped<DecryptedAccessLog>>;

	undeleteAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	modifyAccessLog(entity: GroupScoped<DecryptedAccessLog>): Promise<GroupScoped<DecryptedAccessLog>>;

	modifyAccessLogs(entities: Array<GroupScoped<DecryptedAccessLog>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	getAccessLog(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedAccessLog> | undefined>;

	getAccessLogs(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

}
