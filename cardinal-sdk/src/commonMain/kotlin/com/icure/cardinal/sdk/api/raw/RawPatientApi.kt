package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.DataOwnerRegistrationSuccess
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.SortDirection
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawPatientApi {
	// region common endpoints

	suspend fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String? = null,
		filterValue: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun listOfMergesAfter(date: Long): HttpResponse<List<EncryptedPatient>>

	suspend fun findPatientsModifiedAfter(
		date: Long,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun getPatientHcPartyKeysForDelegate(patientId: String): HttpResponse<Map<String, String>>

	suspend fun getPatientAesExchangeKeysForDelegate(
		patientId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>

	suspend fun countOfPatients(hcPartyId: String): HttpResponse<EncryptedContent>

	suspend fun findPatientsByHealthcareParty(
		hcPartyId: String? = null,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<String>>

	suspend fun getPatientByExternalId(externalId: String): HttpResponse<EncryptedPatient>

	suspend fun findPatientsByAccessLogUserAfterDate(
		userId: String,
		accessType: String? = null,
		startDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun filterPatientsBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skip: Int? = null,
		sort: String? = null,
		desc: Boolean? = null,
		filterChain: FilterChain<Patient>,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun matchPatientsBy(filter: AbstractFilter<Patient>): HttpResponse<List<String>>

	suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Int? = null,
	): HttpResponse<List<EncryptedPatient>>

	suspend fun createPatient(p: EncryptedPatient): HttpResponse<EncryptedPatient>

	suspend fun deletePatients(patientIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deletePatientsWithRev(patientIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deletePatient(
		patientId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeletePatient(
		patientId: String,
		rev: String,
	): HttpResponse<EncryptedPatient>

	suspend fun undeletePatient(patientIds: String): HttpResponse<List<DocIdentifier>>

	suspend fun undeletePatients(ids: ListOfIdsAndRev): HttpResponse<List<EncryptedPatient>>

	suspend fun purgePatient(
		patientId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgePatients(patientIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun findDeletedPatients(
		startDate: Long,
		endDate: Long? = null,
		desc: Boolean? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun listDeletedPatientsByName(
		firstName: String? = null,
		lastName: String? = null,
	): HttpResponse<List<EncryptedPatient>>

	suspend fun getPatients(patientIds: ListOfIds): HttpResponse<List<EncryptedPatient>>

	suspend fun getPatient(patientId: String): HttpResponse<EncryptedPatient>

	suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String? = null,
	): HttpResponse<EncryptedPatient>

	suspend fun createPatientsMinimal(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>>

	suspend fun createPatientsFull(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>>

	suspend fun modifyPatientsMinimal(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>>

	suspend fun modifyPatientsFull(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>>

	suspend fun modifyPatient(patientDto: EncryptedPatient): HttpResponse<EncryptedPatient>

	suspend fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Long? = null,
		end: Long? = null,
	): HttpResponse<EncryptedPatient>

	suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>

	suspend fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatient,
		omitEncryptionKeysOfFrom: Boolean? = null,
	): HttpResponse<EncryptedPatient>
	// endregion

	// region cloud endpoints

	suspend fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String? = null,
		useShortToken: Boolean? = null,
		createAutoDelegation: Boolean = true,
		p: EncryptedPatient,
	): HttpResponse<DataOwnerRegistrationSuccess>

	suspend fun matchPatientsInGroupBy(
		groupId: String,
		filter: AbstractFilter<Patient>,
	): HttpResponse<List<String>>

	suspend fun createPatientInGroup(
		groupId: String,
		patientDto: EncryptedPatient,
	): HttpResponse<EncryptedPatient>

	suspend fun modifyPatientInGroup(
		groupId: String,
		patientDto: EncryptedPatient,
	): HttpResponse<EncryptedPatient>

	suspend fun getPatientInGroup(
		groupId: String,
		patientId: String,
	): HttpResponse<EncryptedPatient>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>>

	suspend fun getPatientsInGroup(
		groupId: String,
		patientIds: ListOfIds,
	): HttpResponse<List<EncryptedPatient>>

	suspend fun createPatientsInGroupFull(
		groupId: String,
		patientDtos: List<EncryptedPatient>,
	): HttpResponse<List<EncryptedPatient>>

	suspend fun createPatientsInGroupMinimal(
		groupId: String,
		patientDtos: List<EncryptedPatient>,
	): HttpResponse<List<IdWithRev>>

	suspend fun modifyPatientsInGroupFull(
		groupId: String,
		patientDtos: List<EncryptedPatient>,
	): HttpResponse<List<EncryptedPatient>>

	suspend fun modifyPatientsInGroupMinimal(
		groupId: String,
		patientDtos: List<EncryptedPatient>,
	): HttpResponse<List<IdWithRev>>

	suspend fun deletePatientsWithRevInGroup(
		groupId: String,
		patientIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deletePatientInGroup(
		groupId: String,
		patientId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeletePatientInGroup(
		groupId: String,
		patientId: String,
		rev: String,
	): HttpResponse<EncryptedPatient>

	suspend fun undeletePatientsInGroup(
		groupId: String,
		ids: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedPatient>>

	suspend fun purgePatientInGroup(
		groupId: String,
		patientId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgePatientsInGroup(
		groupId: String,
		patientIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>
	// endregion
}
