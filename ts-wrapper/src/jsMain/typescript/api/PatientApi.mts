// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {EntityWithTypeInfo} from '../crypto/entities/EntityWithTypeInfo.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {ShareAllPatientDataOptions} from '../crypto/entities/ShareAllPatientDataOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DecryptedPatient, EncryptedPatient, Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {SortDirection} from '../model/couchdb/SortDirection.mjs';
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

	getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfo<any>): Promise<string>;

	getConfidentialSecretIdsOf(patient: Patient): Promise<Array<string>>;

	forceInitializeExchangeDataToNewlyInvitedPatient(patientId: string): Promise<boolean>;

	matchPatientsBy(filter: FilterOptions<Patient>): Promise<Array<string>>;

	matchPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<Array<string>>;

	ensureEncryptionMetadataForSelfIsInitialized(options?: { sharingWith?: { [ key: string ]: AccessLevel }, ignoreIfEncryptionMetadataExists?: boolean, alternateRootDelegateId?: string | undefined }): Promise<EncryptedPatient>;

	deletePatientUnsafe(entityId: string): Promise<StoredDocumentIdentifier>;

	deletePatientsUnsafe(entityIds: Array<string>): Promise<Array<StoredDocumentIdentifier>>;

	deletePatientById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deletePatientsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgePatientById(id: string, rev: string): Promise<void>;

	deletePatient(patient: Patient): Promise<StoredDocumentIdentifier>;

	deletePatients(patients: Array<Patient>): Promise<Array<StoredDocumentIdentifier>>;

	purgePatient(patient: Patient): Promise<void>;

	getDataOwnersWithAccessTo(patient: Patient): Promise<EntityAccessInformation>;

	countOfPatients(hcPartyId: string): Promise<number>;

	shareWith(delegateId: string, patient: DecryptedPatient,
			options?: { options?: PatientShareOptions | undefined }): Promise<DecryptedPatient>;

	shareWithMany(patient: DecryptedPatient,
			delegates: { [ key: string ]: PatientShareOptions }): Promise<DecryptedPatient>;

	initializeConfidentialSecretId(patient: DecryptedPatient): Promise<DecryptedPatient>;

	filterPatientsBy(filter: FilterOptions<Patient>): Promise<PaginatedListIterator<DecryptedPatient>>;

	filterPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<DecryptedPatient>>;

	createPatient(patient: DecryptedPatient): Promise<DecryptedPatient>;

	createPatientsMinimal(patients: Array<DecryptedPatient>): Promise<Array<StoredDocumentIdentifier>>;

	createPatients(patients: Array<DecryptedPatient>): Promise<Array<DecryptedPatient>>;

	undeletePatient(patient: Patient): Promise<Patient>;

	modifyPatient(entity: DecryptedPatient): Promise<DecryptedPatient>;

	undeletePatientById(id: string, rev: string): Promise<DecryptedPatient>;

	undeletePatients(ids: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedPatient>>;

	getPatient(entityId: string): Promise<DecryptedPatient | undefined>;

	getPatientResolvingMerges(patientId: string,
			maxMergeDepth: number | undefined): Promise<DecryptedPatient>;

	findPatientsByNameBirthSsinAuto(filterValue: string,
			options?: { healthcarePartyId?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<DecryptedPatient>>;

	listPatientsOfHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<DecryptedPatient>>;

	listOfMergesAfter(date: number): Promise<Array<DecryptedPatient>>;

	findPatientsModifiedAfter(date: number,
			options?: { startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedPatient>>;

	listPatientsByHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<DecryptedPatient>>;

	findPatientsByHealthcareParty(options?: { hcPartyId?: string | undefined, sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<DecryptedPatient>>;

	findPatientsIdsByHealthcareParty(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<string>>;

	getPatientByExternalId(externalId: string): Promise<DecryptedPatient>;

	fuzzySearch(firstName: string, lastName: string,
			options?: { dateOfBirth?: number | undefined }): Promise<Array<DecryptedPatient>>;

	findDeletedPatients(startDate: number,
			options?: { endDate?: number | undefined, desc?: boolean | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedPatient>>;

	listDeletedPatientsByName(options?: { firstName?: string | undefined, lastName?: string | undefined }): Promise<Array<DecryptedPatient>>;

	getPatients(patientIds: Array<string>): Promise<Array<DecryptedPatient>>;

	getPatientByHealthcarePartyAndIdentifier(hcPartyId: string, id: string,
			options?: { system?: string | undefined }): Promise<DecryptedPatient>;

	modifyPatientsMinimal(patients: Array<DecryptedPatient>): Promise<Array<StoredDocumentIdentifier>>;

	modifyPatients(patients: Array<DecryptedPatient>): Promise<Array<DecryptedPatient>>;

	findDuplicatesBySsin(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedPatient>>;

	findDuplicatesByName(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedPatient>>;

	mergePatients(from: Patient, mergedInto: DecryptedPatient): Promise<DecryptedPatient>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Patient>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedPatient>>;

}
