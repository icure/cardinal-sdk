package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawRelatedPersonApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionRequest
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionResult
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionStrategy
import com.icure.cardinal.sdk.model.conflicts.MergeResult
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.RelatedPersonAbstractFilterSerializer
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawRelatedPersonApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawRelatedPersonApi {
	// region common endpoints

	override suspend fun createRelatedPerson(c: EncryptedRelatedPerson): HttpResponse<EncryptedRelatedPerson> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getRelatedPerson(relatedPersonId: String): HttpResponse<EncryptedRelatedPerson> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", relatedPersonId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getRelatedPersons(relatedPersonIds: ListOfIds): HttpResponse<List<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun deleteRelatedPersons(relatedPersonIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun deleteRelatedPersonsWithRev(relatedPersonIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun deleteRelatedPerson(
		relatedPersonId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", relatedPersonId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteRelatedPerson(
		relatedPersonId: String,
		rev: String,
	): HttpResponse<EncryptedRelatedPerson> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "undelete", relatedPersonId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteRelatedPersons(relatedPersonIds: ListOfIdsAndRev): HttpResponse<List<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun purgeRelatedPerson(
		relatedPersonId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "purge", relatedPersonId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeRelatedPersons(relatedPersonIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun modifyRelatedPerson(relatedPersonDto: EncryptedRelatedPerson): HttpResponse<EncryptedRelatedPerson> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonDto)
		}.wrap()

	override suspend fun modifyRelatedPersons(relatedPersonDtos: List<EncryptedRelatedPerson>): HttpResponse<List<EncryptedRelatedPerson>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonDtos)
		}.wrap()

	override suspend fun createRelatedPersons(relatedPersonDtos: List<EncryptedRelatedPerson>): HttpResponse<List<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonDtos)
		}.wrap()

	override suspend fun filterRelatedPersonsBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<RelatedPerson>,
	): HttpResponse<PaginatedList<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(RelatedPersonAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedRelatedPerson>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchRelatedPersonsBy(filter: AbstractFilter<RelatedPerson>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(RelatedPersonAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun getConflictingEntitiesIds(): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "conflicts")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getConflictsForEntity(entityId: String): HttpResponse<List<EncryptedRelatedPerson>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "conflicts", "of")
				parameter("entityId", entityId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun declareConflictWinner(
		request: ConflictResolutionRequest<EncryptedRelatedPerson>,
	): HttpResponse<ConflictResolutionResult<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "conflicts", "winner")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun autoSolveConflicts(
		entityIds: List<String>,
		strategy: ConflictResolutionStrategy?,
	): HttpResponse<List<MergeResult>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "conflicts", "solve")
				parameter("strategy", strategy?.dtoSerialName)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createRelatedPersonInGroup(
		groupId: String,
		relatedPersonDto: EncryptedRelatedPerson,
	): HttpResponse<EncryptedRelatedPerson> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonDto)
		}.wrap()

	override suspend fun createRelatedPersonsInGroup(
		groupId: String,
		relatedPersonDtos: List<EncryptedRelatedPerson>,
	): HttpResponse<List<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonDtos)
		}.wrap()

	override suspend fun modifyRelatedPersonInGroup(
		groupId: String,
		relatedPersonDto: EncryptedRelatedPerson,
	): HttpResponse<EncryptedRelatedPerson> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonDto)
		}.wrap()

	override suspend fun modifyRelatedPersonsInGroup(
		groupId: String,
		relatedPersonDtos: List<EncryptedRelatedPerson>,
	): HttpResponse<List<EncryptedRelatedPerson>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonDtos)
		}.wrap()

	override suspend fun getRelatedPersonInGroup(
		groupId: String,
		relatedPersonId: String,
	): HttpResponse<EncryptedRelatedPerson> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, relatedPersonId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getRelatedPersonsInGroup(
		groupId: String,
		relatedPersonIds: ListOfIds,
	): HttpResponse<List<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun deleteRelatedPersonInGroup(
		groupId: String,
		relatedPersonId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, relatedPersonId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteRelatedPersonsInGroup(
		groupId: String,
		relatedPersonIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun undeleteRelatedPersonInGroup(
		groupId: String,
		relatedPersonId: String,
		rev: String,
	): HttpResponse<EncryptedRelatedPerson> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "undelete", relatedPersonId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteRelatedPersonsInGroup(
		groupId: String,
		relatedPersonIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun purgeRelatedPersonInGroup(
		groupId: String,
		relatedPersonId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "purge", relatedPersonId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeRelatedPersonsInGroup(
		groupId: String,
		relatedPersonIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(relatedPersonIds)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedRelatedPerson>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchRelatedPersonsInGroupBy(
		filter: AbstractFilter<RelatedPerson>,
		groupId: String,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(RelatedPersonAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun getConflictingEntitiesIdsInGroup(groupId: String): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "conflicts")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getConflictsForEntityInGroup(
		groupId: String,
		entityId: String,
	): HttpResponse<List<EncryptedRelatedPerson>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "conflicts", "of")
				parameter("entityId", entityId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun declareConflictWinnerInGroup(
		groupId: String,
		request: ConflictResolutionRequest<EncryptedRelatedPerson>,
	): HttpResponse<ConflictResolutionResult<EncryptedRelatedPerson>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "conflicts", "winner")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun autoSolveConflictsInGroup(
		groupId: String,
		entityIds: List<String>,
		strategy: ConflictResolutionStrategy?,
	): HttpResponse<List<MergeResult>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "relatedperson", "inGroup", groupId, "conflicts", "solve")
				parameter("strategy", strategy?.dtoSerialName)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	// endregion
}
