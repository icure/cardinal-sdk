package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.SortDirection
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface PatientBasicFlavourlessApi {
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deletePatientUnsafe(entityId: String): StoredDocumentIdentifier
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deletePatientsUnsafe(entityIds: List<String>): List<StoredDocumentIdentifier>

	/**
	 * Deletes a patient. If you don't have write access to the patient the method will fail.
	 * @param entityId id of the patient.
	 * @param rev the latest known rev of the patient to delete
	 * @return the id and revision of the deleted patient.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deletePatientById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many patients. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the patients to delete.
	 * @return the id and revision of the deleted patients. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deletePatientsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a patient.
	 * @param id id of the patient to purge
	 * @param rev latest revision of the patient
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgePatientById(id: String, rev: String)

	/**
	 * Deletes a patient. If you don't have write access to the patient the method will fail.
	 * @param patient the patient to delete
	 * @return the id and revision of the deleted patient.
	 * @throws RevisionConflictException if the provided patient doesn't match the latest known revision
	 */
	suspend fun deletePatient(patient: Patient): StoredDocumentIdentifier =
		deletePatientById(patient.id, requireNotNull(patient.rev) { "Can't delete a patient that has no rev" })

	/**
	 * Deletes many patients. Ignores patient for which you don't have write access or that don't match the latest revision.
	 * @param patients the patients to delete
	 * @return the id and revision of the deleted patients. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deletePatients(patients: List<Patient>): List<StoredDocumentIdentifier> =
		deletePatientsByIds(patients.map { patient ->
			StoredDocumentIdentifier(patient.id, requireNotNull(patient.rev) { "Can't delete a patient that has no rev" })
		})

	/**
	 * Permanently deletes a patient.
	 * @param patient the patient to purge.
	 * @throws RevisionConflictException if the provided patient doesn't match the latest known revision
	 */
	suspend fun purgePatient(patient: Patient) {
		purgePatientById(patient.id, requireNotNull(patient.rev) { "Can't delete a patient that has no rev" })
	}

	/**
	 * Get all data owners with access to the provided patient, attempting to identify any unknown anonymous data owners
	 * using delegations de-anonymization metadata.
	 * @param patient a patient
	 * @return information on users with access to the provided patient
	 */
	suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation

	@Deprecated("This method gives inaccurate results outside of the simples scenarios, use match instead")
	suspend fun countOfPatients(hcPartyId: String): Int
}

interface PatientBasicFlavourlessInGroupApi {
	/**
	 * In-group version of [PatientBasicFlavourlessApi.deletePatientById]
	 */
	// TODO suspend fun deletePatientById(groupId: String, entityId: String, rev: String): GroupScoped<StoredDocumentIdentifier>

	/**
	 * In-group version of [PatientBasicFlavourlessApi.deletePatientsByIds]
	 */
	// TODO? suspend fun deletePatientsByIds(entityIds: List<GroupScoped<IdWithMandatoryRev>>): List<GroupScoped<StoredDocumentIdentifier>> // would need to make GroupScoped constructor public, provide a method for converting GroupScoped<Revisionable> to GroupScoped<IdWithMandatoryRev>>, or similar...
	/**
	 * In-group version of [PatientBasicFlavourlessApi.purgePatientById]
	 */
	// TODO suspend fun purgePatientById(groupId: String, entityId: String, rev: String)

	/**
	 * In-group version of [PatientBasicFlavourlessApi.deletePatient]
	 */
	// TODO suspend fun deletePatient(patient: GroupScoped<Patient>): GroupScoped<StoredDocumentIdentifier>

	/**
	 * In-group version of [PatientBasicFlavourlessApi.deletePatients]
	 */
	// TODO suspend fun deletePatients(patients: List<GroupScoped<Patient>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [PatientBasicFlavourlessApi.purgePatient]
	 */
	// TODO suspend fun purgePatient(patient: GroupScoped<Patient>)

	/**
	 * In-group version of [PatientBasicFlavourlessApi.getDataOwnersWithAccessTo].
	 */
	suspend fun getDataOwnersWithAccessTo(patient: GroupScoped<Patient>): EntityAccessInformation
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface PatientBasicFlavouredApi<E : Patient> {
	/**
	 * Create a new patient. The provided patient must have the encryption metadata initialized.
	 * @param patient a patient with initialized encryption metadata
	 * @return the created patient with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input wasn't initialized.
	 */
	suspend fun createPatient(patient: E): E

	/**
	 * Similar to [createPatients] but returns only the id and revision of the successfully created patients.
	 * Note that while most of the created patient entity will be the same as the input, some fields (such as
	 * [Patient.created]) are automatically filled in if left empty.
	 */
	suspend fun createPatientsMinimal(patients: List<E>): List<StoredDocumentIdentifier>

	/**
	 * Bulk version of [createPatient], returns all the successfully created patients.
	 * If a patient couldn't be created (for example because there is already a patient with the same id) it will be
	 * excluded from the result.
	 */
	suspend fun createPatients(patients: List<E>): List<E>

	/**
	 * Restores a patient that was marked as deleted.
	 * @param patient the patient to undelete
	 * @return the restored patient.
	 * @throws RevisionConflictException if the provided patient doesn't match the latest known revision
	 */
	suspend fun undeletePatient(patient: Patient): Patient =
		undeletePatientById(patient.id, requireNotNull(patient.rev) { "Can't delete a patient that has no rev" })

	/**
	 * Modifies a patient. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a patient with update content
	 * @return the patient updated with the provided content and a new revision.
	 */
	suspend fun modifyPatient(entity: E): E

	/**
	 * Restores a patient that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeletePatientById(id: String, rev: String): E

	/**
	 * Restores one or more patients that were marked as deleted.
	 * Ignores any entities that the current user is not allowed to restore or that have a revision different from the
	 * provided revision.
	 * @param ids the ids and revisions of the patients to restore
	 * @return the restored entities.
	 */
	suspend fun undeletePatients(ids: List<StoredDocumentIdentifier>): List<E>

	/**
	 * Get a patient by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a patient, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a patient id.
	 * @return the patient with id [entityId].
	 */
	suspend fun getPatient(	entityId: String): E?

	/**
	 * Get the patient with the provided id and follows the chain of patient merges indicated by the
	 * [Patient.mergeToPatientId] field until a patient that was not merged into another patient is reached, then that
	 * patient is returned.
	 * You can optionally limit the maximum depth of merges this method will go through by providing a [maxMergeDepth]
	 * parameter. This parameter limits the amount of links that will be resolved: if by the time the [maxMergeDepth] is
	 * reached the end of the merge chain is not yet reached this method will throw an exception.
	 * @param patientId the id of a patient
	 * @param maxMergeDepth a number greater than 0 or null if you don't want to limit the merge depth
	 * @return the patient at the end of the merge chain
	 * @throws IllegalArgumentException if maxMergeLevel is less than 1, or if the max merge level has been reached but
	 * the end of the merge chain was not yet reached.
	 */
	suspend fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Int? = null): E

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findPatientsByNameBirthSsinAuto(
		@DefaultValue("null")
		healthcarePartyId: String? = null,
		filterValue: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc")
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun listPatientsOfHcParty(
		hcPartyId: String,
		@DefaultValue("\"name\"")
		sortField: String = "name",
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc")
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	@Deprecated("Use filter instead")
	suspend fun listOfMergesAfter(date: Long): List<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findPatientsModifiedAfter(
		date: Long,
		@DefaultValue("null")
		startKey: Long? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun listPatientsByHcParty(
		hcPartyId: String,
		@DefaultValue("\"name\"")
		sortField: String = "name",
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc")
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findPatientsByHealthcareParty(
		@DefaultValue("null")
		hcPartyId: String? = null,
		@DefaultValue("\"name\"")
		sortField: String = "name",
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc")
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<String>

	@Deprecated("This method has undefined behaviour in case multiple patients have the same external id. You should use the corresponding filter instead.")
	suspend fun getPatientByExternalId(externalId: String): E

	@Deprecated("Use filter instead")
	suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		@DefaultValue("null")
		dateOfBirth: Int? = null,
	): List<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findDeletedPatients(
		startDate: Long,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		desc: Boolean? = null,
		@DefaultValue("null")
		startKey: Long? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	@Deprecated("Use filter instead")
	suspend fun listDeletedPatientsByName(
		@DefaultValue("null")
		firstName: String? = null,
		@DefaultValue("null")
		lastName: String? = null,
	): List<E>

	/**
	 * Get multiple patients by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a patient, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param patientIds a list of patients ids
	 * @return all patients that you can access with one of the provided ids.
	 */
	suspend fun getPatients(patientIds: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		@DefaultValue("null")
		system: String? = null,
	): E


	/**
	 * Similar to [modifyPatients] but returns only the id and revision of the successfully updated patients.
	 * Note that while most of the created patient entity will be the same as the input, some fields (such as
	 * [Patient.modified]) are automatically filled in if left empty.
	 */
	suspend fun modifyPatientsMinimal(patients: List<E>): List<StoredDocumentIdentifier>

	/**
	 * Bulk version of [modifyPatient], returns all the successfully updated patients.
	 * If a patient couldn't be updated (for example because of a revision mismatch) it will be excluded from the
	 * result.
	 */
	suspend fun modifyPatients(patients: List<E>): List<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findDuplicatesByName(
		hcPartyId: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	/**
	 * Merge two patients into one. This method performs the following operations:
	 * - The `from` patient will be soft-deleted, and it will point to the `into` patient. Only the `deletionDate` and `mergeToPatientId` fields of the
	 *   patient will be changed (automatically by this method). Note that the value of [from] is only used to verify that the client is aware of
	 *   the last version of the `from` patient: any changes to its content and/or metadata compared to what is actually stored in the database will be
	 *   ignored.
	 * - The metadata of the `into` patient will be automatically updated to contain also the metadata of the `from` patient and to keep track of the
	 *   merge:
	 *   - the `mergedIds` will be updated to contain the `from` patient id
	 *   - all secret ids of the `from` patient will be added to the `into` patient
	 *   - all data owners (including anonymous data owners) with access to the `from` patient will have the same access to the merged `into` patient
	 *     (unless they already had greater access to the `into` patient, in which case they keep the greater access)
	 * - The content of the `into` patient will be updated to match the content (name, address, note, ...) of the provided [mergedInto] parameter.
	 *   Note that since the metadata is automatically updated by this method you must not change the metadata of the `mergedInto` patient
	 *   (`delegations`, mergedInto`, ...): if there is any change between the metadata of the provided `mergedInto` patient and the stored patient this
	 *   method will fail.
	 *
	 * In case the revisions of [from] and/or [mergedInto] does not match the latest revisions for these patients in the database this
	 * method will fail without soft-deleting the `from` patient and without updating the `into` patient with the merged content and metadata. You will
	 * have to retrieve the updated versions of both patients before retrying the merge.
	 *
	 * Finally, note that this method only merges existing data, and does not perform any automatic sharing of the data. The secret ids and encryption
	 * keys will not be shared with users that had access only to one of the entity, you will have to use a share method after the merge
	 * if you want to do so.
	 * For example consider hcps A, B with access to P' and hcps A, C with access to P'', and we merge P'' into P'. After the merge:
	 * - A has access to all secret ids of the merged patient and to the encryption key of the merged patient
	 * - B has access to the encryption key of the merged patient (since it is the same as in P'), but only to the secret id which was originally from
	 *   the unmerged P'
	 * - C has no access to the encryption key of the merged patient, and has access only to the secret id which was originally from the unmerged P''
	 *
	 * Note that the user performing this operation must have write access to both patients.
	 *
	 * @param from the original, unmodified `from` patient. Its content will be unchanged and its metadata will be automatically updated by this method
	 * to reflect the merge.
	 * @param mergedInto the `into` patient with updated content result of the merge with the `from` patient, as specified by your application logic.
	 * The metadata of the `mergedInto` patient must not differ from the metadata of the stored version of the patient, since it will be automatically
	 * updated by the method.
	 * @return the updated `into` patient.
	 */
	suspend fun mergePatients(from: Patient, mergedInto: E): E
}

interface PatientBasicFlavouredInGroupApi<E : Patient> {
	/**
	 * In-group version of [PatientBasicFlavouredApi.createPatient]
	 */
	suspend fun createPatient(patient: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [PatientBasicFlavouredApi.createPatientsMinimal]
	 */
	suspend fun createPatientsMinimal(patients: List<GroupScoped<E>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [PatientBasicFlavouredApi.createPatients]
	 */
	suspend fun createPatients(patients: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [PatientBasicFlavouredApi.undeletePatient]
	 */
	// TODO suspend fun undeletePatient(patient: GroupScoped<Patient>): GroupScoped<E>

	/**
	 * In-group version of [PatientBasicFlavouredApi.modifyPatient]
	 */
	// TODO suspend fun modifyPatient(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [PatientBasicFlavouredApi.undeletePatientById]
	 */
	// TODO suspend fun undeletePatientById(groupId: String, id: String, rev: String): GroupScoped<E>

	/**
	 * In-group version of [PatientBasicFlavouredApi.undeletePatients]
	 */
	// TODO? suspend fun undeletePatients(ids: List<GroupScoped<IdWithMandatoryRev>>): List<GroupScoped<E>> // would need to make GroupScoped constructor public, provide a method for converting GroupScoped<Revisionable> to GroupScoped<IdWithMandatoryRev>>, or similar...

	/**
	 * In-group version of [PatientBasicFlavouredApi.getPatient]
	 */
	suspend fun getPatient(groupId: String, entityId: String): GroupScoped<E>?

	/**
	 * In-group version of [PatientBasicFlavouredApi.getPatientResolvingMerges]
	 */
	suspend fun getPatientResolvingMerges(groupId: String, patientId: String, maxMergeDepth: Int? = null): GroupScoped<E>

	/**
	 * In-group version of [PatientBasicFlavouredApi.getPatients]
	 */
	suspend fun getPatients(groupId: String, patientIds: List<String>): List<GroupScoped<E>>

	/**
	 * In-group version of [PatientBasicFlavouredApi.modifyPatientsMinimal]
	 */
	suspend fun modifyPatientsMinimal(patients: List<GroupScoped<E>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [PatientBasicFlavouredApi.modifyPatients]
	 */
	suspend fun modifyPatients(patients: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [PatientBasicFlavouredApi.mergePatients]
	 */
	// TODO? suspend fun mergePatients(from: GroupScoped<Patient>, mergedInto: GroupScoped<E>): GroupScoped<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface PatientFlavouredApi<E : Patient> : PatientBasicFlavouredApi<E> {
	/**
	 * Share a patient with another data owner. The patient must already exist in the database for this method to
	 * succeed. If you want to share the patient before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * @param delegateId the owner that will gain access to the patient
	 * @param patient the patient to share with [delegateId]
	 * @param options specifies how the patient will be shared. Refer to the documentation of [PatientShareOptions] for more information.
	 * @return the updated patient if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		patient: E,
		@DefaultValue("null")
		options: PatientShareOptions? = null
	): E

	/**
	 * Share a patient with multiple data owners. The patient must already exist in the database for this method to
	 * succeed. If you want to share the patient before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * Throws an exception if the operation fails.
	 * @param patient the patient to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated patient.
	 */
	suspend fun shareWithMany(
		patient: E,
		delegates: Map<String, PatientShareOptions>
	): E

	/**
	 * Initializes a new "confidential" secret id for the provided patient if there is none, and saves it. Returns the
	 * updated patient if a new secret id was initialized, or the input if there was already a confidential secret id
	 * available.
	 *
	 * A "confidential" secret id is a secret id that was not shared with any of the current data owner parents, at
	 * least to the extent of the knowledge of the current data owner. If the current data owner is missing access to
	 * some of the keys of his parents a secret id that is not confidential may be mistakenly identified as confidential.
	 * The confidential secret id may be shared in a second moment with a parent data owner, making it not confidential
	 * anymore. It may also be possible to share the secret id with another non-parent data owner, in which case the
	 * secret id will still be considered as confidential.
	 *
	 * Confidential secret ids only make sense in environments where a hierarchical data owner structure is used. In
	 * other environments all secret ids are confidential by nature.
	 *
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *
	 * @param patient a patient
	 * @return the input if there is already a secret id available for the patient, or the updated patient otherwise.
	 */
	suspend fun initializeConfidentialSecretId(patient: E): E

	/**
	 * Get an iterator that iterates through all patients matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterPatientsBySorted] instead.
	 *
	 * @param filter a patient filter
	 * @return an iterator that iterates over all patients matching the provided filter.
	 */
	suspend fun filterPatientsBy(
		filter: FilterOptions<Patient>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all patients matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterPatientsBy].
	 *
	 * @param filter a patient filter
	 * @return an iterator that iterates over all patients matching the provided filter.
	 */
	suspend fun filterPatientsBySorted(
		filter: SortableFilterOptions<Patient>
	): PaginatedListIterator<E>
}

interface PatientFlavouredInGroupApi<E : Patient> : PatientBasicFlavouredInGroupApi<E> {

	/**
	 * In-group version of [PatientFlavouredApi.shareWith]
	 */
	suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		patient: GroupScoped<E>,
		@DefaultValue("null")
		options: PatientShareOptions? = null
	): GroupScoped<E>

	/**
	 * In-group version of [PatientFlavouredApi.shareWithMany]
	 */
	suspend fun shareWithMany(
		patient: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, PatientShareOptions>
	): GroupScoped<E>

	/**
	 * In-group version of [PatientFlavouredApi.initializeConfidentialSecretId]
	 */
	suspend fun initializeConfidentialSecretId(patient: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [PatientFlavouredApi.filterPatientsBy]
	 */
	suspend fun filterPatientsBy(groupId: String, filter: FilterOptions<Patient>): PaginatedListIterator<GroupScoped<E>>

	/**
	 * In-group version of [PatientFlavouredApi.filterPatientsBySorted]
	 */
	suspend fun filterPatientsBySorted(groupId: String, filter: SortableFilterOptions<Patient>): PaginatedListIterator<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface PatientApi : PatientBasicFlavourlessApi, PatientFlavouredApi<DecryptedPatient>, Subscribable<Patient, EncryptedPatient, FilterOptions<Patient>> {
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: PatientFlavouredApi<EncryptedPatient>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: PatientFlavouredApi<Patient>

	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: PatientInGroupApi

	/**
	 * Decrypts patients, throwing an exception if it is not possible.
	 * @param patients encrypted patients
	 * @return the decrypted patients
	 * @throws EntityEncryptionException if any of the provided patients couldn't be decrypted
	 */
	suspend fun decrypt(patients: List<EncryptedPatient>): List<DecryptedPatient>

	/**
	 * Tries to decrypt a patient, returns the input if it is not possible.
	 * @param patients encrypted patients
	 * @return all the provided patients, each of them decrypted if possible or unchanged (still encrypted)
	 */
	suspend fun tryDecrypt(patients: List<EncryptedPatient>): List<Patient>

	/**
	 * Encrypts provided decrypted patients, and validates already encrypted patients.
	 * @param patients patients to encrypt and/or validate
	 * @return the encrypted and validates patients
	 * @throws EntityEncryptionException if any of the provided decrypted patients couldn't be encrypted (the current
	 * user can't access its encryption key or no key was initialized) or if the already encrypted patients don't
	 * respect the manifest.
	 */
	suspend fun encryptOrValidate(patients: List<Patient>): List<EncryptedPatient>

	/**
	 * Get all the secret ids that the current data owner can access from the provided patient.
	 * @param patient a patient
	 * @return the secret ids of the provided patient associated to the data owners which are known to have access
	 * to that id.
	 */
	suspend fun getSecretIdsOf(patient: Patient): Map<String, Set<EntityReferenceInGroup>>

	/**
	 * Attempts to extract the encryption keys of a patient. If the user doesn't have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this wasn't a guarantee.
	 * @param patient a patient
	 * @return the encryption keys extracted from the provided patient.
	 */
	suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString>

	/**
	 * Creates a new patient with initialized encryption metadata
	 * @param base a patient with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @return a patient with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedPatient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedPatient

	/**
	 * Specifies if the current user has write access to a patient through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 * side this method will still return true if there is a delegation to the parent.
	 * @param patient a patient
	 * @return if the current user has write access to the provided patient
	 */
	suspend fun hasWriteAccess(patient: Patient): Boolean

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a patient.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided patient. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the patient the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Patient,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a patient E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any patient that you have shared with P, H will be able to know that the patient was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a patient that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a patient
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Set<String>)

	/**
	 * Share a patient and all data associated to that patient that the current user can access with other data owners.
	 * @param patientId the id of the patient id to share
	 * @param delegatesWithShareType the data owners which will gain access to the patient data, and the type of data
	 * they should actually get access to.
	 * @return details on the result of the operation
	 */
	suspend fun shareAllDataOfPatient(
		patientId: String,
		delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>
	): ShareAllPatientDataOptions.Result

	@Deprecated("This method combines the getPatientId of a child document (contact, health element, ...) with the getPatientResolvingMerges method. Use the methods individually instead.")
	suspend fun getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfo<*>): String

	/**
	 * Get all confidential secret ids of a patient
	 *
	 * A "confidential" secret id is a secret id that was not shared with any of the current data owner parents, at
	 * least to the extent of the knowledge of the current data owner. If the current data owner is missing access to
	 * some of the keys of his parents a secret id that is not confidential may be mistakenly identified as confidential.
	 * The confidential secret id may be shared in a second moment with a parent data owner, making it not confidential
	 * anymore. It may also be possible to share the secret id with another non-parent data owner, in which case the
	 * secret id will still be considered as confidential.
	 *
	 * Confidential secret ids only make sense in environments where a hierarchical data owner structure is used. In
	 * other environments all secret ids are confidential by nature.
	 *
	 * @param patient a patient
	 * @return the confidential secret ids of the patient
	 */
	suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String>

	/**
	 * Initializes the exchange data towards a newly invited patient. This allows the doctor to share data with the
	 * patient even if the patient has not yet initialized a keypair for himself.
	 *
	 * This method should be used only if the patient has not yet initialized a keypair for himself. If the patient has
	 * already initialized a keypair this method does nothing and returns false. In this case the exchange data will be
	 * automatically created the first time you share data with the patient, and your implementation of the crypto
	 * strategies will be used to validate the public keys of the patient.
	 *
	 * Once exchange data is initialized you can use the [RecoveryApi.createExchangeDataRecoveryInfo] to
	 * generate a key that the patient will be able to use on his first login to immediately gain access to the exchange
	 * data (through the [RecoveryApi.recoverExchangeData] method).
	 *
	 * @param patientId the id of the newly invited patient.
	 * @return true if exchange data was initialized, false if the patient already has a key pair and the exchange data
	 * will be initialized in the standard way (automatically on the first time data is shared with the user).
	 */
	suspend fun forceInitializeExchangeDataToNewlyInvitedPatient(patientId: String): Boolean

	/**
	 * Get the ids of all patients matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchPatientsBySorted] instead.
	 *
	 * @param filter a patient filter
	 * @return a list of patient ids
	 */
	suspend fun matchPatientsBy(filter: FilterOptions<Patient>): List<String>

	/**
	 * Get the ids of all patients matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchPatientsBy].
	 *
	 * @param filter a patient filter
	 * @return a list of patient ids
	 */
	suspend fun matchPatientsBySorted(filter: SortableFilterOptions<Patient>): List<String>

	/**
	 * Can only be used if the current data owner is a patient.
	 * Initializes the encryption metadata for the current user's patient if it is not already initialized in a way that
	 * allows the current user to produce medical data for himself.
	 * - If there is no encryption metadata initialized at all, the method will initialize the encryption key and secret
	 *   ids for the patient.
	 * - If there is some encryption metadata initialized but the current user can't access any secret id of the patient
	 *   this method will create a new secret id for the patient, unless [ignoreIfEncryptionMetadataExists] is true: in
	 *   that case this method does nothing.
	 * - In all other cases, this method does nothing. Note that this doesn't mean that the patient can access his own
	 *   encrypted information. If the encryption key was initialized by someone else and not shared with the patient,
	 *   then the patient will only have access to a new secret id (unless [ignoreIfEncryptionMetadataExists] is true,
	 *   in that case the patient won't even have access to the secret id).
	 * If you provided any value for [sharingWith] any metadata created by this method will be immediately shared with
	 * the provided delegates: note that this doesn't share any existing data (if no new data was created the delegates
	 * may not have access to any secret id for the current patient).
	 * If the patient is initialized in keyless mode [alternateRootDelegateId] must be provided to specify which
	 * delegate to use in the root delegation. If not in keyless mode this parameter must be null.
	 * @throws IllegalArgumentException If the current user is not a patient
	 */
	suspend fun ensureEncryptionMetadataForSelfIsInitialized(
		@DefaultValue("emptyMap()")
		sharingWith: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("false")
		ignoreIfEncryptionMetadataExists: Boolean = false,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): EncryptedPatient
}

interface PatientInGroupApi : PatientBasicFlavourlessInGroupApi, PatientFlavouredInGroupApi<DecryptedPatient> { // TODO subscribable?
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: PatientFlavouredInGroupApi<EncryptedPatient>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: PatientFlavouredInGroupApi<Patient>

	/**
	 * In-group version of [PatientApi.decrypt]
	 */
	suspend fun decrypt(patients: List<GroupScoped<EncryptedPatient>>): List<GroupScoped<DecryptedPatient>>

	/**
	 * In-group version of [PatientApi.tryDecrypt]
	 */
	suspend fun tryDecrypt(patients: List<GroupScoped<EncryptedPatient>>): List<GroupScoped<Patient>>

	/**
	 * In-group version of [PatientApi.encryptOrValidate]
	 */
	suspend fun encryptOrValidate(patients: List<GroupScoped<Patient>>): List<GroupScoped<EncryptedPatient>>

	/**
	 * In-group version of [PatientApi.getSecretIdsOf]
	 */
	suspend fun getSecretIdsOf(patient: GroupScoped<Patient>): Map<String, Set<EntityReferenceInGroup>>

	/**
	 * In-group version of [PatientApi.getEncryptionKeysOf]
	 */
	suspend fun getEncryptionKeysOf(patient: GroupScoped<Patient>): Set<HexString>

	/**
	 * In-group version of [PatientApi.withEncryptionMetadata]
	 */
	suspend fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedPatient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
		@DefaultValue("null")
		alternateRootDelegateReference: EntityReferenceInGroup? = null,
	): GroupScoped<DecryptedPatient>

	/**
	 * In-group version of [PatientApi.hasWriteAccess]
	 */
	suspend fun hasWriteAccess(patient: GroupScoped<DecryptedPatient>): Boolean

	/**
	 * In-group version of [PatientApi.createDelegationDeAnonymizationMetadata]
	 */
	suspend fun createDelegationDeAnonymizationMetadata(
		entity: GroupScoped<DecryptedPatient>,
		delegates: Set<EntityReferenceInGroup>
	)

	/**
	 * In-group version of [PatientApi.getConfidentialSecretIdsOf]
	 */
	// TODO suspend fun getConfidentialSecretIdsOf(patient: GroupScoped<DecryptedPatient>): Set<String>


	/**
	 * In-group version of [PatientApi.matchPatientsBy]
	 */
	suspend fun matchPatientsBy(groupId: String, filter: FilterOptions<Patient>): List<String>


	/**
	 * In-group version of [PatientApi.matchPatientsBySorted]
	 */
	suspend fun matchPatientsBySorted(groupId: String, filter: SortableFilterOptions<Patient>): List<String>


	/**
	 * In-group version of [PatientApi.forceInitializeExchangeDataToNewlyInvitedPatient]
	 */
	// TODO? suspend fun forceInitializeExchangeDataToNewlyInvitedPatient(groupId: String, patientId: String): Boolean
}

interface PatientBasicApi : PatientBasicFlavourlessApi, PatientBasicFlavouredApi<EncryptedPatient>,
	Subscribable<Patient, EncryptedPatient, BaseFilterOptions<Patient>> {
	/**
	 * Gives access to methods of the api that allow to use entitiesin groups other than the current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: PatientBasicInGroupApi

	/**
	 * Get the ids of all patients matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchPatientsBySorted] instead.
	 *
	 * @param filter a patient filter
	 * @return a list of patient ids
	 */
	suspend fun matchPatientsBy(filter: BaseFilterOptions<Patient>): List<String>

	/**
	 * Get the ids of all patients matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchPatientsBy].
	 *
	 * @param filter a patient filter
	 * @return a list of patient ids
	 */
	suspend fun matchPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): List<String>

	/**
	 * Get an iterator that iterates through all patients matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterPatientsBySorted] instead.
	 *
	 * @param filter a patient filter
	 * @return an iterator that iterates over all patients matching the provided filter.
	 */
	suspend fun filterPatientsBy(
		filter: BaseFilterOptions<Patient>
	): PaginatedListIterator<EncryptedPatient>

	/**
	 * Get an iterator that iterates through all patients matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterPatientsBy].
	 *
	 * @param filter a patient filter
	 * @return an iterator that iterates over all patients matching the provided filter.
	 */
	suspend fun filterPatientsBySorted(
		filter: BaseSortableFilterOptions<Patient>
	): PaginatedListIterator<EncryptedPatient>
}

interface PatientBasicInGroupApi : PatientBasicFlavourlessInGroupApi, PatientBasicFlavouredInGroupApi<EncryptedPatient> { // TODO subscribable?
	/**
	 * In-group version of [PatientBasicApi.matchPatientsBy]
	 */
	suspend fun matchPatientsBy(groupId: String, filter: BaseFilterOptions<Patient>): List<String>

	/**
	 * In-group version of [PatientBasicApi.matchPatientsBySorted]
	 */
	suspend fun matchPatientsBySorted(groupId: String, filter: BaseSortableFilterOptions<Patient>): List<String>

	/**
	 * In-group version of [PatientBasicApi.filterPatientsBy]
	 */
	suspend fun filterPatientsBy(groupId: String, filter: BaseFilterOptions<Patient>): PaginatedListIterator<GroupScoped<EncryptedPatient>>

	/**
	 * In-group version of [PatientBasicApi.filterPatientsBySorted]
	 */
	suspend fun filterPatientsBySorted(groupId: String, filter: BaseSortableFilterOptions<Patient>): PaginatedListIterator<GroupScoped<EncryptedPatient>>
}
