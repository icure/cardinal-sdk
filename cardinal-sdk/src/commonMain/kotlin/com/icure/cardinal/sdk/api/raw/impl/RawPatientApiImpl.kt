package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawPatientApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
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
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.PatientAbstractFilterSerializer
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
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
class RawPatientApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawPatientApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.Patient,
		)

	// region common endpoints

	override suspend fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String?,
		filterValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byNameBirthSsinAuto")
				parameter("healthcarePartyId", healthcarePartyId)
				parameter("filterValue", filterValue)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("sortDirection", sortDirection.dtoSerialName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "ofHcParty", hcPartyId)
				parameter("sortField", sortField)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("sortDirection", sortDirection.dtoSerialName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listOfMergesAfter(date: Long): HttpResponse<List<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "merges", "$date")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findPatientsModifiedAfter(
		date: Long,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "modifiedAfter", "$date")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "hcParty", hcPartyId)
				parameter("sortField", sortField)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("sortDirection", sortDirection.dtoSerialName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getPatientHcPartyKeysForDelegate(patientId: String): HttpResponse<Map<String, String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId, "keys")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getPatientAesExchangeKeysForDelegate(
		patientId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId, "aesExchangeKeys")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun countOfPatients(hcPartyId: String): HttpResponse<EncryptedContent> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "hcParty", hcPartyId, "count")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findPatientsByHealthcareParty(
		hcPartyId: String?,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient")
				parameter("hcPartyId", hcPartyId)
				parameter("sortField", sortField)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("sortDirection", sortDirection.dtoSerialName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byHcPartyId")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getPatientByExternalId(externalId: String): HttpResponse<EncryptedPatient> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byExternalId", externalId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findPatientsByAccessLogUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byAccess", userId)
				parameter("accessType", accessType)
				parameter("startDate", startDate)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun filterPatientsBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		skip: Int?,
		sort: String?,
		desc: Boolean?,
		filterChain: FilterChain<Patient>,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "filter")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("skip", skip)
				parameter("sort", sort)
				parameter("desc", desc)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(PatientAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchPatientsBy(filter: AbstractFilter<Patient>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(PatientAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Int?,
	): HttpResponse<List<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "fuzzy")
				parameter("firstName", firstName)
				parameter("lastName", lastName)
				parameter("dateOfBirth", dateOfBirth)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createPatient(p: EncryptedPatient): HttpResponse<EncryptedPatient> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(p)
		}.wrap()

	override suspend fun deletePatients(patientIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientIds)
		}.wrap()

	override suspend fun deletePatientsWithRev(patientIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientIds)
		}.wrap()

	override suspend fun deletePatient(
		patientId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeletePatient(
		patientId: String,
		rev: String,
	): HttpResponse<EncryptedPatient> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "undelete", patientId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeletePatient(patientIds: String): HttpResponse<List<DocIdentifier>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "undelete", patientIds)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeletePatients(ids: ListOfIdsAndRev): HttpResponse<List<EncryptedPatient>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun purgePatient(
		patientId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "purge", patientId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgePatients(patientIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientIds)
		}.wrap()

	override suspend fun findDeletedPatients(
		startDate: Long,
		endDate: Long?,
		desc: Boolean?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "deleted", "byDate")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("desc", desc)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listDeletedPatientsByName(
		firstName: String?,
		lastName: String?,
	): HttpResponse<List<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "deleted", "by_name")
				parameter("firstName", firstName)
				parameter("lastName", lastName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getPatients(patientIds: ListOfIds): HttpResponse<List<EncryptedPatient>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientIds)
		}.wrap()

	override suspend fun getPatient(patientId: String): HttpResponse<EncryptedPatient> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	): HttpResponse<EncryptedPatient> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", hcPartyId, id)
				parameter("system", system)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createPatientsMinimal(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "batch", "minimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun createPatientsFull(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "batch", "full")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun modifyPatientsMinimal(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "batch", "minimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun modifyPatientsFull(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "batch", "full")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun modifyPatient(patientDto: EncryptedPatient): HttpResponse<EncryptedPatient> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDto)
		}.wrap()

	override suspend fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Long?,
		end: Long?,
	): HttpResponse<EncryptedPatient> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId, "referral", referralId)
				parameter("start", start)
				parameter("end", end)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "duplicates", "ssin")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "duplicates", "name")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatient,
		omitEncryptionKeysOfFrom: Boolean?,
	): HttpResponse<EncryptedPatient> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "mergeInto", intoId, "from", fromId)
				parameter("expectedFromRev", expectedFromRev)
				parameter("omitEncryptionKeysOfFrom", omitEncryptionKeysOfFrom)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(updatedInto)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String?,
		useShortToken: Boolean?,
		createAutoDelegation: Boolean,
		p: EncryptedPatient,
	): HttpResponse<DataOwnerRegistrationSuccess> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "register", "forHcp", hcPartyId, "inGroup", groupId)
				parameter("token", token)
				parameter("useShortToken", useShortToken)
				parameter("createAutoDelegation", createAutoDelegation)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(p)
		}.wrap()

	override suspend fun matchPatientsInGroupBy(
		groupId: String,
		filter: AbstractFilter<Patient>,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(PatientAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun createPatientInGroup(
		groupId: String,
		patientDto: EncryptedPatient,
	): HttpResponse<EncryptedPatient> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDto)
		}.wrap()

	override suspend fun modifyPatientInGroup(
		groupId: String,
		patientDto: EncryptedPatient,
	): HttpResponse<EncryptedPatient> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDto)
		}.wrap()

	override suspend fun getPatientInGroup(
		groupId: String,
		patientId: String,
	): HttpResponse<EncryptedPatient> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, patientId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun getPatientsInGroup(
		groupId: String,
		patientIds: ListOfIds,
	): HttpResponse<List<EncryptedPatient>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientIds)
		}.wrap()

	override suspend fun createPatientsInGroupFull(
		groupId: String,
		patientDtos: List<EncryptedPatient>,
	): HttpResponse<List<EncryptedPatient>> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "batch", "full")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun createPatientsInGroupMinimal(
		groupId: String,
		patientDtos: List<EncryptedPatient>,
	): HttpResponse<List<IdWithRev>> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "batch", "minimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun modifyPatientsInGroupFull(
		groupId: String,
		patientDtos: List<EncryptedPatient>,
	): HttpResponse<List<EncryptedPatient>> =
		put(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "batch", "full")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun modifyPatientsInGroupMinimal(
		groupId: String,
		patientDtos: List<EncryptedPatient>,
	): HttpResponse<List<IdWithRev>> =
		put(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "batch", "minimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun deletePatientsWithRevInGroup(
		groupId: String,
		patientIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientIds)
		}.wrap()

	override suspend fun deletePatientInGroup(
		groupId: String,
		patientId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, patientId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeletePatientInGroup(
		groupId: String,
		patientId: String,
		rev: String,
	): HttpResponse<EncryptedPatient> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "undelete", patientId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeletePatientsInGroup(
		groupId: String,
		ids: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedPatient>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun purgePatientInGroup(
		groupId: String,
		patientId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "purge", patientId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgePatientsInGroup(
		groupId: String,
		patientIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientIds)
		}.wrap()

	// endregion
}
