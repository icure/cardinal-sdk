// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface PatientFlavouredApi<E extends Patient> {

	shareWith(delegateId: string, patient: E,
			options?: { options?: PatientShareOptions | undefined }): Promise<E>;

	shareWithMany(patient: E, delegates: { [ key: string ]: PatientShareOptions }): Promise<E>;

	initializeConfidentialSecretId(patient: E): Promise<E>;

	filterPatientsBy(filter: FilterOptions<Patient>): Promise<PaginatedListIterator<E>>;

	filterPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<E>>;

	createPatient(patient: E): Promise<E>;

	createPatients(patients: Array<E>): Promise<Array<E>>;

	undeletePatient(patient: Patient): Promise<Patient>;

	undeletePatients(patients: Array<Patient>): Promise<Array<E>>;

	modifyPatient(entity: E): Promise<E>;

	undeletePatientById(id: string, rev: string): Promise<E>;

	undeletePatientsByIds(ids: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	getPatient(entityId: string): Promise<E | undefined>;

	getPatientResolvingMerges(patientId: string, maxMergeDepth: number | undefined): Promise<E>;

	getPatients(patientIds: Array<string>): Promise<Array<E>>;

	modifyPatients(patients: Array<E>): Promise<Array<E>>;

	mergePatients(from: Patient, mergedInto: E): Promise<E>;

}
