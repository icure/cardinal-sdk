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

	/**
	 *
	 *  In-group version of [PatientApi.decrypt]
	 */
	decrypt(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientApi.tryDecrypt]
	 */
	tryDecrypt(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<Patient>>>;

	/**
	 *
	 *  In-group version of [PatientApi.encryptOrValidate]
	 */
	encryptOrValidate(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientApi.getSecretIdsOf]
	 */
	getSecretIdsOf(patient: GroupScoped<Patient>): Promise<{ [ key: string ]: Array<EntityReferenceInGroup> }>;

	/**
	 *
	 *  In-group version of [PatientApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(patient: GroupScoped<Patient>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [PatientApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedPatient | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientApi.hasWriteAccess]
	 */
	hasWriteAccess(patient: GroupScoped<DecryptedPatient>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [PatientApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<DecryptedPatient>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [PatientApi.matchPatientsBy]
	 */
	matchPatientsBy(groupId: string, filter: FilterOptions<Patient>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [PatientApi.matchPatientsBySorted]
	 */
	matchPatientsBySorted(groupId: string,
			filter: SortableFilterOptions<Patient>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavourlessApi.deletePatientById]
	 */
	deletePatientById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavourlessApi.deletePatientsByIds]
	 */
	deletePatientsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavourlessApi.purgePatientById]
	 */
	purgePatientById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavourlessApi.purgePatientsByIds]
	 */
	purgePatientsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavourlessApi.deletePatient]
	 */
	deletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavourlessApi.deletePatients]
	 */
	deletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavourlessApi.purgePatient]
	 */
	purgePatient(patient: GroupScoped<Patient>): Promise<void>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavourlessApi.getDataOwnersWithAccessTo].
	 */
	getDataOwnersWithAccessTo(patient: GroupScoped<Patient>): Promise<EntityAccessInformation>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, patient: GroupScoped<DecryptedPatient>,
			options?: { options?: PatientShareOptions | undefined }): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.shareWithMany]
	 */
	shareWithMany(patient: GroupScoped<DecryptedPatient>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: PatientShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.initializeConfidentialSecretId]
	 */
	initializeConfidentialSecretId(patient: GroupScoped<DecryptedPatient>): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.filterPatientsBy]
	 */
	filterPatientsBy(groupId: string,
			filter: FilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<DecryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.filterPatientsBySorted]
	 */
	filterPatientsBySorted(groupId: string,
			filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<DecryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.createPatient]
	 */
	createPatient(patient: GroupScoped<DecryptedPatient>): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.createPatients]
	 */
	createPatients(patients: Array<GroupScoped<DecryptedPatient>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatient]
	 */
	undeletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatients]
	 */
	undeletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.modifyPatient]
	 */
	modifyPatient(entity: GroupScoped<DecryptedPatient>): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatientById]
	 */
	undeletePatientById(patientId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatientsByIds]
	 */
	undeletePatientsByIds(patientIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatient]
	 */
	getPatient(groupId: string, entityId: string): Promise<GroupScoped<DecryptedPatient> | undefined>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatientResolvingMerges]
	 */
	getPatientResolvingMerges(groupId: string, patientId: string,
			maxMergeDepth: number | undefined): Promise<GroupScoped<DecryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatients]
	 */
	getPatients(groupId: string,
			patientIds: Array<string>): Promise<Array<GroupScoped<DecryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.modifyPatients]
	 */
	modifyPatients(patients: Array<GroupScoped<DecryptedPatient>>): Promise<Array<GroupScoped<DecryptedPatient>>>;

}
