// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedPatient, Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface PatientBasicInGroupApi {

	/**
	 *
	 *  In-group version of [PatientBasicApi.matchPatientsBy]
	 */
	matchPatientsBy(groupId: string, filter: BaseFilterOptions<Patient>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [PatientBasicApi.matchPatientsBySorted]
	 */
	matchPatientsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Patient>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [PatientBasicApi.filterPatientsBy]
	 */
	filterPatientsBy(groupId: string,
			filter: BaseFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<EncryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicApi.filterPatientsBySorted]
	 */
	filterPatientsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<EncryptedPatient>>>;

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
	 *  In-group version of [PatientBasicFlavouredApi.createPatient]
	 */
	createPatient(patient: GroupScoped<EncryptedPatient>): Promise<GroupScoped<EncryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.createPatients]
	 */
	createPatients(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatient]
	 */
	undeletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<EncryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatients]
	 */
	undeletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.modifyPatient]
	 */
	modifyPatient(entity: GroupScoped<EncryptedPatient>): Promise<GroupScoped<EncryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatientById]
	 */
	undeletePatientById(patientId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatientsByIds]
	 */
	undeletePatientsByIds(patientIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatient]
	 */
	getPatient(groupId: string, entityId: string): Promise<GroupScoped<EncryptedPatient> | undefined>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatientResolvingMerges]
	 */
	getPatientResolvingMerges(groupId: string, patientId: string,
			maxMergeDepth: number | undefined): Promise<GroupScoped<EncryptedPatient>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatients]
	 */
	getPatients(groupId: string,
			patientIds: Array<string>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.modifyPatients]
	 */
	modifyPatients(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

}
