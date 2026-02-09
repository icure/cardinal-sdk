// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {EncryptedPatient, Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {PatientBasicInGroupApi} from './PatientBasicInGroupApi.mjs';


export interface PatientBasicApi {

	inGroup: PatientBasicInGroupApi;

	matchPatientsBy(filter: BaseFilterOptions<Patient>): Promise<Array<string>>;

	matchPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): Promise<Array<string>>;

	filterPatientsBy(filter: BaseFilterOptions<Patient>): Promise<PaginatedListIterator<EncryptedPatient>>;

	filterPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): Promise<PaginatedListIterator<EncryptedPatient>>;

	deletePatientById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deletePatientsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgePatientById(id: string, rev: string): Promise<void>;

	purgePatientsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deletePatient(patient: Patient): Promise<StoredDocumentIdentifier>;

	deletePatients(patients: Array<Patient>): Promise<Array<StoredDocumentIdentifier>>;

	purgePatient(patient: Patient): Promise<void>;

	purgePatients(patients: Array<Patient>): Promise<Array<StoredDocumentIdentifier>>;

	getDataOwnersWithAccessTo(patient: Patient): Promise<EntityAccessInformation>;

	createPatient(patient: EncryptedPatient): Promise<EncryptedPatient>;

	createPatients(patients: Array<EncryptedPatient>): Promise<Array<EncryptedPatient>>;

	undeletePatient(patient: Patient): Promise<Patient>;

	undeletePatients(patients: Array<Patient>): Promise<Array<EncryptedPatient>>;

	modifyPatient(entity: EncryptedPatient): Promise<EncryptedPatient>;

	undeletePatientById(id: string, rev: string): Promise<EncryptedPatient>;

	undeletePatientsByIds(ids: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedPatient>>;

	getPatient(entityId: string): Promise<EncryptedPatient | undefined>;

	getPatientResolvingMerges(patientId: string,
			maxMergeDepth: number | undefined): Promise<EncryptedPatient>;

	getPatients(patientIds: Array<string>): Promise<Array<EncryptedPatient>>;

	modifyPatients(patients: Array<EncryptedPatient>): Promise<Array<EncryptedPatient>>;

	mergePatients(from: Patient, mergedInto: EncryptedPatient): Promise<EncryptedPatient>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Patient>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedPatient>>;

}
