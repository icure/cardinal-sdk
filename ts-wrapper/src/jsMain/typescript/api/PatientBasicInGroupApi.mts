// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedPatient, Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface PatientBasicInGroupApi {

	matchPatientsBy(groupId: string, filter: BaseFilterOptions<Patient>): Promise<Array<string>>;

	matchPatientsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Patient>): Promise<Array<string>>;

	filterPatientsBy(groupId: string,
			filter: BaseFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<EncryptedPatient>>>;

	filterPatientsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<EncryptedPatient>>>;

	deletePatientById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deletePatientsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgePatientById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgePatientsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgePatient(patient: GroupScoped<Patient>): Promise<void>;

	getDataOwnersWithAccessTo(patient: GroupScoped<Patient>): Promise<EntityAccessInformation>;

	createPatient(patient: GroupScoped<EncryptedPatient>): Promise<GroupScoped<EncryptedPatient>>;

	createPatients(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	undeletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<EncryptedPatient>>;

	undeletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	modifyPatient(entity: GroupScoped<EncryptedPatient>): Promise<GroupScoped<EncryptedPatient>>;

	undeletePatientById(patientId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedPatient>>;

	undeletePatientsByIds(patientIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	getPatient(groupId: string, entityId: string): Promise<GroupScoped<EncryptedPatient> | undefined>;

	getPatientResolvingMerges(groupId: string, patientId: string,
			maxMergeDepth: number | undefined): Promise<GroupScoped<EncryptedPatient>>;

	getPatients(groupId: string,
			patientIds: Array<string>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	modifyPatients(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

}
