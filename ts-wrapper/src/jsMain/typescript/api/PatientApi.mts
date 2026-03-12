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

	/**
	 *
	 *  Decrypts patients, throwing an exception if it is not possible.
	 *  @param patients encrypted patients
	 *  @return the decrypted patients
	 *  @throws EntityEncryptionException if any of the provided patients couldn't be decrypted
	 */
	decrypt(patients: Array<EncryptedPatient>): Promise<Array<DecryptedPatient>>;

	/**
	 *
	 *  Tries to decrypt a patient, returns the input if it is not possible.
	 *  @param patients encrypted patients
	 *  @return all the provided patients, each of them decrypted if possible or unchanged (still encrypted)
	 */
	tryDecrypt(patients: Array<EncryptedPatient>): Promise<Array<Patient>>;

	/**
	 *
	 *  Encrypts provided decrypted patients, and validates already encrypted patients.
	 *  @param patients patients to encrypt and/or validate
	 *  @return the encrypted and validates patients
	 *  @throws EntityEncryptionException if any of the provided decrypted patients couldn't be encrypted (the current
	 *  user can't access its encryption key or no key was initialized) or if the already encrypted patients don't
	 *  respect the manifest.
	 */
	encryptOrValidate(patients: Array<Patient>): Promise<Array<EncryptedPatient>>;

	/**
	 *
	 *  Get all the secret ids that the current data owner can access from the provided patient.
	 *  @param patient a patient
	 *  @return the secret ids of the provided patient associated to the data owners which are known to have access
	 *  to that id.
	 */
	getSecretIdsOf(patient: Patient): Promise<{ [ key: string ]: Array<EntityReferenceInGroup> }>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a patient. If the user doesn't have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this wasn't a guarantee.
	 *  @param patient a patient
	 *  @return the encryption keys extracted from the provided patient.
	 */
	getEncryptionKeysOf(patient: Patient): Promise<Array<HexString>>;

	/**
	 *
	 *  Creates a new patient with initialized encryption metadata
	 *  @param base a patient with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @return a patient with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedPatient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, alternateRootDelegateId?: string | undefined }): Promise<DecryptedPatient>;

	/**
	 *
	 *  Specifies if the current user has write access to a patient through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param patient a patient
	 *  @return if the current user has write access to the provided patient
	 */
	hasWriteAccess(patient: Patient): Promise<boolean>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a patient.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided patient. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the patient the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Patient,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a patient E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any patient that you have shared with P, H will be able to know that the patient was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a patient that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a patient
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Share a patient and all data associated to that patient that the current user can access with other data owners.
	 *  @param patientId the id of the patient id to share
	 *  @param delegatesWithShareType the data owners which will gain access to the patient data, and the type of data
	 *  they should actually get access to.
	 *  @return details on the result of the operation
	 */
	shareAllDataOfPatient(patientId: string,
			delegatesWithShareType: { [ key: string ]: Array<ShareAllPatientDataOptions.Tag> }): Promise<ShareAllPatientDataOptions.Result>;

	/**
	 *
	 *  Get all confidential secret ids of a patient
	 *
	 *  A "confidential" secret id is a secret id that was not shared with any of the current data owner parents, at
	 *  least to the extent of the knowledge of the current data owner. If the current data owner is missing access to
	 *  some of the keys of his parents a secret id that is not confidential may be mistakenly identified as confidential.
	 *  The confidential secret id may be shared in a second moment with a parent data owner, making it not confidential
	 *  anymore. It may also be possible to share the secret id with another non-parent data owner, in which case the
	 *  secret id will still be considered as confidential.
	 *
	 *  Confidential secret ids only make sense in environments where a hierarchical data owner structure is used. In
	 *  other environments all secret ids are confidential by nature.
	 *
	 *  @param patient a patient
	 *  @return the confidential secret ids of the patient
	 */
	getConfidentialSecretIdsOf(patient: Patient): Promise<Array<string>>;

	/**
	 *
	 *  Initializes the exchange data towards a newly invited patient. This allows the doctor to share data with the
	 *  patient even if the patient has not yet initialized a keypair for himself.
	 *
	 *  This method should be used only if the patient has not yet initialized a keypair for himself. If the patient has
	 *  already initialized a keypair this method does nothing and returns false. In this case the exchange data will be
	 *  automatically created the first time you share data with the patient, and your implementation of the crypto
	 *  strategies will be used to validate the public keys of the patient.
	 *
	 *  Once exchange data is initialized you can use the [RecoveryApi.createExchangeDataRecoveryInfo] to
	 *  generate a key that the patient will be able to use on his first login to immediately gain access to the exchange
	 *  data (through the [RecoveryApi.recoverExchangeData] method).
	 *
	 *  @param patientId the id of the newly invited patient.
	 *  @return true if exchange data was initialized, false if the patient already has a key pair and the exchange data
	 *  will be initialized in the standard way (automatically on the first time data is shared with the user).
	 */
	forceInitializeExchangeDataToNewlyInvitedPatient(patientId: string): Promise<boolean>;

	/**
	 *
	 *  Get the ids of all patients matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchPatientsBySorted] instead.
	 *
	 *  @param filter a patient filter
	 *  @return a list of patient ids
	 */
	matchPatientsBy(filter: FilterOptions<Patient>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all patients matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchPatientsBy].
	 *
	 *  @param filter a patient filter
	 *  @return a list of patient ids
	 */
	matchPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<Array<string>>;

	/**
	 *
	 *  Can only be used if the current data owner is a patient.
	 *  Initializes the encryption metadata for the current user's patient if it is not already initialized in a way that
	 *  allows the current user to produce medical data for himself.
	 *  - If there is no encryption metadata initialized at all, the method will initialize the encryption key and secret
	 *    ids for the patient.
	 *  - If there is some encryption metadata initialized but the current user can't access any secret id of the patient
	 *    this method will create a new secret id for the patient, unless [ignoreIfEncryptionMetadataExists] is true: in
	 *    that case this method does nothing.
	 *  - In all other cases, this method does nothing. Note that this doesn't mean that the patient can access his own
	 *    encrypted information. If the encryption key was initialized by someone else and not shared with the patient,
	 *    then the patient will only have access to a new secret id (unless [ignoreIfEncryptionMetadataExists] is true,
	 *    in that case the patient won't even have access to the secret id).
	 *  If you provided any value for [sharingWith] any metadata created by this method will be immediately shared with
	 *  the provided delegates: note that this doesn't share any existing data (if no new data was created the delegates
	 *  may not have access to any secret id for the current patient).
	 *  If the patient is initialized in keyless mode [alternateRootDelegateId] must be provided to specify which
	 *  delegate to use in the root delegation. If not in keyless mode this parameter must be null.
	 *  @throws IllegalArgumentException If the current user is not a patient
	 */
	ensureEncryptionMetadataForSelfIsInitialized(options?: { sharingWith?: { [ key: string ]: AccessLevel }, ignoreIfEncryptionMetadataExists?: boolean, alternateRootDelegateId?: string | undefined }): Promise<EncryptedPatient>;

	/**
	 *
	 *  Deletes a patient. If you don't have write access to the patient the method will fail.
	 *  @param entityId id of the patient.
	 *  @param rev the latest known rev of the patient to delete
	 *  @return the id and revision of the deleted patient.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deletePatientById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many patients. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the patients to delete.
	 *  @return the id and revision of the deleted patients. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deletePatientsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a patient.
	 *  @param id id of the patient to purge
	 *  @param rev latest revision of the patient
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgePatientById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many patients.
	 *  @param entityIds ids and revisions of the patients to delete
	 *  @return the id and revision of the deleted patients. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgePatientsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a patient. If you don't have write access to the patient the method will fail.
	 *  @param patient the patient to delete
	 *  @return the id and revision of the deleted patient.
	 *  @throws RevisionConflictException if the provided patient doesn't match the latest known revision
	 */
	deletePatient(patient: Patient): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many patients. Ignores patient for which you don't have write access or that don't match the latest revision.
	 *  @param patients the patients to delete
	 *  @return the id and revision of the deleted patients. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deletePatients(patients: Array<Patient>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a patient.
	 *  @param patient the patient to purge.
	 *  @throws RevisionConflictException if the provided patient doesn't match the latest known revision
	 */
	purgePatient(patient: Patient): Promise<void>;

	/**
	 *
	 *  Permanently deletes many patients.
	 *  @param patients the patients to purge.
	 *  @return the id and revision of the deleted patients. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgePatients(patients: Array<Patient>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Get all data owners with access to the provided patient, attempting to identify any unknown anonymous data owners
	 *  using delegations de-anonymization metadata.
	 *  @param patient a patient
	 *  @return information on users with access to the provided patient
	 */
	getDataOwnersWithAccessTo(patient: Patient): Promise<EntityAccessInformation>;

	/**
	 *
	 *  Share a patient with another data owner. The patient must already exist in the database for this method to
	 *  succeed. If you want to share the patient before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the patient
	 *  @param patient the patient to share with [delegateId]
	 *  @param options specifies how the patient will be shared. Refer to the documentation of [PatientShareOptions] for more information.
	 *  @return the updated patient if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, patient: DecryptedPatient,
			options?: { options?: PatientShareOptions | undefined }): Promise<DecryptedPatient>;

	/**
	 *
	 *  Share a patient with multiple data owners. The patient must already exist in the database for this method to
	 *  succeed. If you want to share the patient before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param patient the patient to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated patient.
	 */
	shareWithMany(patient: DecryptedPatient,
			delegates: { [ key: string ]: PatientShareOptions }): Promise<DecryptedPatient>;

	/**
	 *
	 *  Initializes a new "confidential" secret id for the provided patient if there is none, and saves it. Returns the
	 *  updated patient if a new secret id was initialized, or the input if there was already a confidential secret id
	 *  available.
	 *
	 *  A "confidential" secret id is a secret id that was not shared with any of the current data owner parents, at
	 *  least to the extent of the knowledge of the current data owner. If the current data owner is missing access to
	 *  some of the keys of his parents a secret id that is not confidential may be mistakenly identified as confidential.
	 *  The confidential secret id may be shared in a second moment with a parent data owner, making it not confidential
	 *  anymore. It may also be possible to share the secret id with another non-parent data owner, in which case the
	 *  secret id will still be considered as confidential.
	 *
	 *  Confidential secret ids only make sense in environments where a hierarchical data owner structure is used. In
	 *  other environments all secret ids are confidential by nature.
	 *
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *
	 *  @param patient a patient
	 *  @return the input if there is already a secret id available for the patient, or the updated patient otherwise.
	 */
	initializeConfidentialSecretId(patient: DecryptedPatient): Promise<DecryptedPatient>;

	/**
	 *
	 *  Get an iterator that iterates through all patients matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterPatientsBySorted] instead.
	 *
	 *  @param filter a patient filter
	 *  @return an iterator that iterates over all patients matching the provided filter.
	 */
	filterPatientsBy(filter: FilterOptions<Patient>): Promise<PaginatedListIterator<DecryptedPatient>>;

	/**
	 *
	 *  Get an iterator that iterates through all patients matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterPatientsBy].
	 *
	 *  @param filter a patient filter
	 *  @return an iterator that iterates over all patients matching the provided filter.
	 */
	filterPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<DecryptedPatient>>;

	/**
	 *
	 *  Create a new patient. The provided patient must have the encryption metadata initialized.
	 *  @param patient a patient with initialized encryption metadata
	 *  @return the created patient with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input wasn't initialized.
	 */
	createPatient(patient: DecryptedPatient): Promise<DecryptedPatient>;

	/**
	 *
	 *  Bulk version of [createPatient], returns all the successfully created patients.
	 *  If a patient couldn't be created (for example because there is already a patient with the same id) it will be
	 *  excluded from the result.
	 */
	createPatients(patients: Array<DecryptedPatient>): Promise<Array<DecryptedPatient>>;

	/**
	 *
	 *  Restores a patient that was marked as deleted.
	 *  @param patient the patient to undelete
	 *  @return the restored patient.
	 *  @throws RevisionConflictException if the provided patient doesn't match the latest known revision
	 */
	undeletePatient(patient: Patient): Promise<Patient>;

	/**
	 *
	 *  Restores a batch of patients that were marked as deleted.
	 *  @param patients the patients to restore.
	 *  @return the restored patients. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeletePatients(patients: Array<Patient>): Promise<Array<DecryptedPatient>>;

	/**
	 *
	 *  Modifies a patient. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a patient with update content
	 *  @return the patient updated with the provided content and a new revision.
	 */
	modifyPatient(entity: DecryptedPatient): Promise<DecryptedPatient>;

	/**
	 *
	 *  Restores a patient that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeletePatientById(id: string, rev: string): Promise<DecryptedPatient>;

	/**
	 *
	 *  Restores one or more patients that were marked as deleted.
	 *  Ignores any entities that the current user is not allowed to restore or that have a revision different from the
	 *  provided revision.
	 *  @param ids the ids and revisions of the patients to restore
	 *  @return the restored entities.
	 */
	undeletePatientsByIds(ids: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedPatient>>;

	/**
	 *
	 *  Get a patient by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a patient, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a patient id.
	 *  @return the patient with id [entityId].
	 */
	getPatient(entityId: string): Promise<DecryptedPatient | undefined>;

	/**
	 *
	 *  Get the patient with the provided id and follows the chain of patient merges indicated by the
	 *  [Patient.mergeToPatientId] field until a patient that was not merged into another patient is reached, then that
	 *  patient is returned.
	 *  You can optionally limit the maximum depth of merges this method will go through by providing a [maxMergeDepth]
	 *  parameter. This parameter limits the amount of links that will be resolved: if by the time the [maxMergeDepth] is
	 *  reached the end of the merge chain is not yet reached this method will throw an exception.
	 *  @param patientId the id of a patient
	 *  @param maxMergeDepth a number greater than 0 or null if you don't want to limit the merge depth
	 *  @return the patient at the end of the merge chain
	 *  @throws IllegalArgumentException if maxMergeLevel is less than 1, or if the max merge level has been reached but
	 *  the end of the merge chain was not yet reached.
	 */
	getPatientResolvingMerges(patientId: string,
			maxMergeDepth: number | undefined): Promise<DecryptedPatient>;

	/**
	 *
	 *  Get multiple patients by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a patient, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param patientIds a list of patients ids
	 *  @return all patients that you can access with one of the provided ids.
	 */
	getPatients(patientIds: Array<string>): Promise<Array<DecryptedPatient>>;

	/**
	 *
	 *  Bulk version of [modifyPatient], returns all the successfully updated patients.
	 *  If a patient couldn't be updated (for example because of a revision mismatch) it will be excluded from the
	 *  result.
	 */
	modifyPatients(patients: Array<DecryptedPatient>): Promise<Array<DecryptedPatient>>;

	/**
	 *
	 *  Merge two patients into one. This method performs the following operations:
	 *  - The `from` patient will be soft-deleted, and it will point to the `into` patient. Only the `deletionDate` and `mergeToPatientId` fields of the
	 *    patient will be changed (automatically by this method). Note that the value of [from] is only used to verify that the client is aware of
	 *    the last version of the `from` patient: any changes to its content and/or metadata compared to what is actually stored in the database will be
	 *    ignored.
	 *  - The metadata of the `into` patient will be automatically updated to contain also the metadata of the `from` patient and to keep track of the
	 *    merge:
	 *    - the `mergedIds` will be updated to contain the `from` patient id
	 *    - all secret ids of the `from` patient will be added to the `into` patient
	 *    - all data owners (including anonymous data owners) with access to the `from` patient will have the same access to the merged `into` patient
	 *      (unless they already had greater access to the `into` patient, in which case they keep the greater access)
	 *  - The content of the `into` patient will be updated to match the content (name, address, note, ...) of the provided [mergedInto] parameter.
	 *    Note that since the metadata is automatically updated by this method you must not change the metadata of the `mergedInto` patient
	 *    (`delegations`, mergedInto`, ...): if there is any change between the metadata of the provided `mergedInto` patient and the stored patient this
	 *    method will fail.
	 *
	 *  In case the revisions of [from] and/or [mergedInto] does not match the latest revisions for these patients in the database this
	 *  method will fail without soft-deleting the `from` patient and without updating the `into` patient with the merged content and metadata. You will
	 *  have to retrieve the updated versions of both patients before retrying the merge.
	 *
	 *  Finally, note that this method only merges existing data, and does not perform any automatic sharing of the data. The secret ids and encryption
	 *  keys will not be shared with users that had access only to one of the entity, you will have to use a share method after the merge
	 *  if you want to do so.
	 *  For example consider hcps A, B with access to P' and hcps A, C with access to P'', and we merge P'' into P'. After the merge:
	 *  - A has access to all secret ids of the merged patient and to the encryption key of the merged patient
	 *  - B has access to the encryption key of the merged patient (since it is the same as in P'), but only to the secret id which was originally from
	 *    the unmerged P'
	 *  - C has no access to the encryption key of the merged patient, and has access only to the secret id which was originally from the unmerged P''
	 *
	 *  Note that the user performing this operation must have write access to both patients.
	 *
	 *  @param from the original, unmodified `from` patient. Its content will be unchanged and its metadata will be automatically updated by this method
	 *  to reflect the merge.
	 *  @param mergedInto the `into` patient with updated content result of the merge with the `from` patient, as specified by your application logic.
	 *  The metadata of the `mergedInto` patient must not differ from the metadata of the stored version of the patient, since it will be automatically
	 *  updated by the method.
	 *  @return the updated `into` patient.
	 */
	mergePatients(from: Patient, mergedInto: DecryptedPatient): Promise<DecryptedPatient>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Patient>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedPatient>>;

}
