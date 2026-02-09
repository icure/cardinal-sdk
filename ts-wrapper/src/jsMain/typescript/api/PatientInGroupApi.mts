// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {DecryptedPatient, EncryptedPatient, Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {PatientFlavouredInGroupApi} from './PatientFlavouredInGroupApi.mjs';


export interface PatientInGroupApi {

	encrypted: PatientFlavouredInGroupApi<EncryptedPatient>;

	tryAndRecover: PatientFlavouredInGroupApi<Patient>;

	decrypt(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	tryDecrypt(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<Patient>>>;

	encryptOrValidate(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	getSecretIdsOf(patient: GroupScoped<Patient>): Promise<{ [ key: string ]: Array<EntityReferenceInGroup> }>;

	getEncryptionKeysOf(patient: GroupScoped<Patient>): Promise<Array<HexString>>;

	withEncryptionMetadata(entityGroupId: string, base: DecryptedPatient | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedPatient>>;

	hasWriteAccess(patient: GroupScoped<DecryptedPatient>): Promise<boolean>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<DecryptedPatient>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	matchPatientsBy(groupId: string, filter: FilterOptions<Patient>): Promise<Array<string>>;

	matchPatientsBySorted(groupId: string,
			filter: SortableFilterOptions<Patient>): Promise<Array<string>>;

	deletePatientById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deletePatientsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgePatientById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgePatientsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgePatient(patient: GroupScoped<Patient>): Promise<void>;

	getDataOwnersWithAccessTo(patient: GroupScoped<Patient>): Promise<EntityAccessInformation>;

	shareWith(delegate: EntityReferenceInGroup, patient: GroupScoped<DecryptedPatient>,
			options?: { options?: PatientShareOptions | undefined }): Promise<GroupScoped<DecryptedPatient>>;

	shareWithMany(patient: GroupScoped<DecryptedPatient>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: PatientShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedPatient>>;

	initializeConfidentialSecretId(patient: GroupScoped<DecryptedPatient>): Promise<GroupScoped<DecryptedPatient>>;

	filterPatientsBy(groupId: string,
			filter: FilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<DecryptedPatient>>>;

	filterPatientsBySorted(groupId: string,
			filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<DecryptedPatient>>>;

	createPatient(patient: GroupScoped<DecryptedPatient>): Promise<GroupScoped<DecryptedPatient>>;

	createPatients(patients: Array<GroupScoped<DecryptedPatient>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	undeletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<DecryptedPatient>>;

	undeletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	modifyPatient(entity: GroupScoped<DecryptedPatient>): Promise<GroupScoped<DecryptedPatient>>;

	undeletePatientById(patientId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedPatient>>;

	undeletePatientsByIds(patientIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	getPatient(groupId: string, entityId: string): Promise<GroupScoped<DecryptedPatient> | undefined>;

	getPatientResolvingMerges(groupId: string, patientId: string,
			maxMergeDepth: number | undefined): Promise<GroupScoped<DecryptedPatient>>;

	getPatients(groupId: string,
			patientIds: Array<string>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	modifyPatients(patients: Array<GroupScoped<DecryptedPatient>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

}
