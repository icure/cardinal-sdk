// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {ShareAllPatientDataOptions} from '../crypto/entities/ShareAllPatientDataOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedPatient, EncryptedPatient, Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {PatientFlavouredApi} from './PatientFlavouredApi.mjs';
import {PatientInGroupApi} from './PatientInGroupApi.mjs';


export interface PatientApi {

	encrypted: PatientFlavouredApi<EncryptedPatient>;

	tryAndRecover: PatientFlavouredApi<Patient>;

	inGroup: PatientInGroupApi;

	decrypt(patients: Array<EncryptedPatient>): Promise<Array<DecryptedPatient>>;

	tryDecrypt(patients: Array<EncryptedPatient>): Promise<Array<Patient>>;

	encryptOrValidate(patients: Array<Patient>): Promise<Array<EncryptedPatient>>;

	getSecretIdsOf(patient: Patient): Promise<{ [ key: string ]: Array<EntityReferenceInGroup> }>;

	getEncryptionKeysOf(patient: Patient): Promise<Array<HexString>>;

	withEncryptionMetadata(base: DecryptedPatient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, alternateRootDelegateId?: string | undefined }): Promise<DecryptedPatient>;

	hasWriteAccess(patient: Patient): Promise<boolean>;

	createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Array<string>): Promise<void>;

	shareAllDataOfPatient(patientId: string,
			delegatesWithShareType: { [ key: string ]: Array<ShareAllPatientDataOptions.Tag> }): Promise<ShareAllPatientDataOptions.Result>;

	getConfidentialSecretIdsOf(patient: Patient): Promise<Array<string>>;

	forceInitializeExchangeDataToNewlyInvitedPatient(patientId: string): Promise<boolean>;

	matchPatientsBy(filter: FilterOptions<Patient>): Promise<Array<string>>;

	matchPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<Array<string>>;

	ensureEncryptionMetadataForSelfIsInitialized(options?: { sharingWith?: { [ key: string ]: AccessLevel }, ignoreIfEncryptionMetadataExists?: boolean, alternateRootDelegateId?: string | undefined }): Promise<EncryptedPatient>;

	deletePatientById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deletePatientsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgePatientById(id: string, rev: string): Promise<void>;

	purgePatientsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deletePatient(patient: Patient): Promise<StoredDocumentIdentifier>;

	deletePatients(patients: Array<Patient>): Promise<Array<StoredDocumentIdentifier>>;

	purgePatient(patient: Patient): Promise<void>;

	purgePatients(patients: Array<Patient>): Promise<Array<StoredDocumentIdentifier>>;

	getDataOwnersWithAccessTo(patient: Patient): Promise<EntityAccessInformation>;

	shareWith(delegateId: string, patient: DecryptedPatient,
			options?: { options?: PatientShareOptions | undefined }): Promise<DecryptedPatient>;

	shareWithMany(patient: DecryptedPatient,
			delegates: { [ key: string ]: PatientShareOptions }): Promise<DecryptedPatient>;

	initializeConfidentialSecretId(patient: DecryptedPatient): Promise<DecryptedPatient>;

	filterPatientsBy(filter: FilterOptions<Patient>): Promise<PaginatedListIterator<DecryptedPatient>>;

	filterPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<DecryptedPatient>>;

	createPatient(patient: DecryptedPatient): Promise<DecryptedPatient>;

	createPatients(patients: Array<DecryptedPatient>): Promise<Array<DecryptedPatient>>;

	undeletePatient(patient: Patient): Promise<Patient>;

	undeletePatients(patients: Array<Patient>): Promise<Array<DecryptedPatient>>;

	modifyPatient(entity: DecryptedPatient): Promise<DecryptedPatient>;

	undeletePatientById(id: string, rev: string): Promise<DecryptedPatient>;

	undeletePatientsByIds(ids: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedPatient>>;

	getPatient(entityId: string): Promise<DecryptedPatient | undefined>;

	getPatientResolvingMerges(patientId: string,
			maxMergeDepth: number | undefined): Promise<DecryptedPatient>;

	getPatients(patientIds: Array<string>): Promise<Array<DecryptedPatient>>;

	modifyPatients(patients: Array<DecryptedPatient>): Promise<Array<DecryptedPatient>>;

	mergePatients(from: Patient, mergedInto: DecryptedPatient): Promise<DecryptedPatient>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Patient>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedPatient>>;

}
