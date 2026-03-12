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

	/**
	 *
	 *  In-group version of [AccessLogApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedAccessLog | undefined,
			patient: GroupScoped<Patient>,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(accessLog: GroupScoped<AccessLog>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [AccessLogApi.hasWriteAccess]
	 */
	hasWriteAccess(accessLog: GroupScoped<AccessLog>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [AccessLogApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(accessLog: GroupScoped<AccessLog>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [AccessLogApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<AccessLog>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [AccessLogApi.decrypt]
	 */
	decrypt(accessLogs: Array<GroupScoped<EncryptedAccessLog>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogApi.tryDecrypt]
	 */
	tryDecrypt(accessLogs: Array<GroupScoped<EncryptedAccessLog>>): Promise<Array<GroupScoped<AccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogApi.matchAccessLogsBy]
	 */
	matchAccessLogsBy(groupId: string, filter: FilterOptions<AccessLog>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [AccessLogApi.matchAccessLogsBySorted]
	 */
	matchAccessLogsBySorted(groupId: string,
			filter: SortableFilterOptions<AccessLog>): Promise<Array<string>>;

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
	createAccessLog(entity: GroupScoped<DecryptedAccessLog>): Promise<GroupScoped<DecryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.createAccessLogs].
	 */
	createAccessLogs(entities: Array<GroupScoped<DecryptedAccessLog>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.undeleteAccessLogById]
	 */
	undeleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.undeleteAccessLogsByIds]
	 */
	undeleteAccessLogsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.undeleteAccessLog]
	 */
	undeleteAccessLog(accessLog: GroupScoped<AccessLog>): Promise<GroupScoped<DecryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.undeleteAccessLogs]
	 */
	undeleteAccessLogs(accessLogs: Array<GroupScoped<AccessLog>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.modifyAccessLog]
	 */
	modifyAccessLog(entity: GroupScoped<DecryptedAccessLog>): Promise<GroupScoped<DecryptedAccessLog>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.modifyAccessLogs]
	 */
	modifyAccessLogs(entities: Array<GroupScoped<DecryptedAccessLog>>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.getAccessLog]
	 */
	getAccessLog(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedAccessLog> | undefined>;

	/**
	 *
	 *  In-group version of [AccessLogBasicFlavouredApi.getAccessLogs]
	 */
	getAccessLogs(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedAccessLog>>>;

}
