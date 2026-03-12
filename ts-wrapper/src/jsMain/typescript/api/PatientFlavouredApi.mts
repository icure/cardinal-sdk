// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface PatientFlavouredApi<E extends Patient> {

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
	shareWith(delegateId: string, patient: E,
			options?: { options?: PatientShareOptions | undefined }): Promise<E>;

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
	shareWithMany(patient: E, delegates: { [ key: string ]: PatientShareOptions }): Promise<E>;

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
	initializeConfidentialSecretId(patient: E): Promise<E>;

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
	filterPatientsBy(filter: FilterOptions<Patient>): Promise<PaginatedListIterator<E>>;

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
	filterPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new patient. The provided patient must have the encryption metadata initialized.
	 *  @param patient a patient with initialized encryption metadata
	 *  @return the created patient with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input wasn't initialized.
	 */
	createPatient(patient: E): Promise<E>;

	/**
	 *
	 *  Bulk version of [createPatient], returns all the successfully created patients.
	 *  If a patient couldn't be created (for example because there is already a patient with the same id) it will be
	 *  excluded from the result.
	 */
	createPatients(patients: Array<E>): Promise<Array<E>>;

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
	undeletePatients(patients: Array<Patient>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a patient. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a patient with update content
	 *  @return the patient updated with the provided content and a new revision.
	 */
	modifyPatient(entity: E): Promise<E>;

	/**
	 *
	 *  Restores a patient that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeletePatientById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores one or more patients that were marked as deleted.
	 *  Ignores any entities that the current user is not allowed to restore or that have a revision different from the
	 *  provided revision.
	 *  @param ids the ids and revisions of the patients to restore
	 *  @return the restored entities.
	 */
	undeletePatientsByIds(ids: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Get a patient by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a patient, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a patient id.
	 *  @return the patient with id [entityId].
	 */
	getPatient(entityId: string): Promise<E | undefined>;

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
	getPatientResolvingMerges(patientId: string, maxMergeDepth: number | undefined): Promise<E>;

	/**
	 *
	 *  Get multiple patients by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a patient, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param patientIds a list of patients ids
	 *  @return all patients that you can access with one of the provided ids.
	 */
	getPatients(patientIds: Array<string>): Promise<Array<E>>;

	/**
	 *
	 *  Bulk version of [modifyPatient], returns all the successfully updated patients.
	 *  If a patient couldn't be updated (for example because of a revision mismatch) it will be excluded from the
	 *  result.
	 */
	modifyPatients(patients: Array<E>): Promise<Array<E>>;

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
	mergePatients(from: Patient, mergedInto: E): Promise<E>;

}
