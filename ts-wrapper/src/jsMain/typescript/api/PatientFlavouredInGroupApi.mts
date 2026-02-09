// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface PatientFlavouredInGroupApi<E extends Patient> {

	shareWith(delegate: EntityReferenceInGroup, patient: GroupScoped<E>,
			options?: { options?: PatientShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(patient: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: PatientShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	initializeConfidentialSecretId(patient: GroupScoped<E>): Promise<GroupScoped<E>>;

	filterPatientsBy(groupId: string,
			filter: FilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterPatientsBySorted(groupId: string,
			filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createPatient(patient: GroupScoped<E>): Promise<GroupScoped<E>>;

	createPatients(patients: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<E>>;

	undeletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<E>>>;

	modifyPatient(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	undeletePatientById(patientId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeletePatientsByIds(patientIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	getPatient(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getPatientResolvingMerges(groupId: string, patientId: string,
			maxMergeDepth: number | undefined): Promise<GroupScoped<E>>;

	getPatients(groupId: string, patientIds: Array<string>): Promise<Array<GroupScoped<E>>>;

	modifyPatients(patients: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

}
