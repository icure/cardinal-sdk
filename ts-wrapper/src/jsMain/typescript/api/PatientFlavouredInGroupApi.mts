// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface PatientFlavouredInGroupApi<E extends Patient> {

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, patient: GroupScoped<E>,
			options?: { options?: PatientShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.shareWithMany]
	 */
	shareWithMany(patient: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: PatientShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.initializeConfidentialSecretId]
	 */
	initializeConfidentialSecretId(patient: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.filterPatientsBy]
	 */
	filterPatientsBy(groupId: string,
			filter: FilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [PatientFlavouredApi.filterPatientsBySorted]
	 */
	filterPatientsBySorted(groupId: string,
			filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.createPatient]
	 */
	createPatient(patient: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.createPatients]
	 */
	createPatients(patients: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatient]
	 */
	undeletePatient(patient: GroupScoped<Patient>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatients]
	 */
	undeletePatients(patients: Array<GroupScoped<Patient>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.modifyPatient]
	 */
	modifyPatient(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatientById]
	 */
	undeletePatientById(patientId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.undeletePatientsByIds]
	 */
	undeletePatientsByIds(patientIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatient]
	 */
	getPatient(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatientResolvingMerges]
	 */
	getPatientResolvingMerges(groupId: string, patientId: string,
			maxMergeDepth: number | undefined): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.getPatients]
	 */
	getPatients(groupId: string, patientIds: Array<string>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [PatientBasicFlavouredApi.modifyPatients]
	 */
	modifyPatients(patients: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

}
