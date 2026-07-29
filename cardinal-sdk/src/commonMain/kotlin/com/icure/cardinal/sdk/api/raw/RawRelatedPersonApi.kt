package com.icure.cardinal.sdk.api.raw

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
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawRelatedPersonApi {
	// region common endpoints

	suspend fun createRelatedPerson(c: EncryptedRelatedPerson): HttpResponse<EncryptedRelatedPerson>

	suspend fun getRelatedPerson(relatedPersonId: String): HttpResponse<EncryptedRelatedPerson>

	suspend fun getRelatedPersons(relatedPersonIds: ListOfIds): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun deleteRelatedPersons(relatedPersonIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteRelatedPersonsWithRev(relatedPersonIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteRelatedPerson(
		relatedPersonId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteRelatedPerson(
		relatedPersonId: String,
		rev: String,
	): HttpResponse<EncryptedRelatedPerson>

	suspend fun undeleteRelatedPersons(relatedPersonIds: ListOfIdsAndRev): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun purgeRelatedPerson(
		relatedPersonId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeRelatedPersons(relatedPersonIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun modifyRelatedPerson(relatedPersonDto: EncryptedRelatedPerson): HttpResponse<EncryptedRelatedPerson>

	suspend fun modifyRelatedPersons(relatedPersonDtos: List<EncryptedRelatedPerson>): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun createRelatedPersons(relatedPersonDtos: List<EncryptedRelatedPerson>): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun filterRelatedPersonsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<RelatedPerson>,
	): HttpResponse<PaginatedList<EncryptedRelatedPerson>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedRelatedPerson>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>

	suspend fun matchRelatedPersonsBy(filter: AbstractFilter<RelatedPerson>): HttpResponse<List<String>>

	suspend fun getConflictingEntitiesIds(): HttpResponse<List<String>>

	suspend fun getConflictsForEntity(entityId: String): HttpResponse<List<EncryptedRelatedPerson>>

	public suspend fun declareConflictWinner(
		request: ConflictResolutionRequest<EncryptedRelatedPerson>,
	): HttpResponse<ConflictResolutionResult<EncryptedRelatedPerson>>

	suspend fun autoSolveConflicts(
		entityIds: List<String>,
		strategy: ConflictResolutionStrategy?,
	): HttpResponse<List<MergeResult>>
	// endregion

	// region cloud endpoints

	suspend fun createRelatedPersonInGroup(
		groupId: String,
		relatedPersonDto: EncryptedRelatedPerson,
	): HttpResponse<EncryptedRelatedPerson>

	suspend fun createRelatedPersonsInGroup(
		groupId: String,
		relatedPersonDtos: List<EncryptedRelatedPerson>,
	): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun modifyRelatedPersonInGroup(
		groupId: String,
		relatedPersonDto: EncryptedRelatedPerson,
	): HttpResponse<EncryptedRelatedPerson>

	suspend fun modifyRelatedPersonsInGroup(
		groupId: String,
		relatedPersonDtos: List<EncryptedRelatedPerson>,
	): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun getRelatedPersonInGroup(
		groupId: String,
		relatedPersonId: String,
	): HttpResponse<EncryptedRelatedPerson>

	suspend fun getRelatedPersonsInGroup(
		groupId: String,
		relatedPersonIds: ListOfIds,
	): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun deleteRelatedPersonInGroup(
		groupId: String,
		relatedPersonId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deleteRelatedPersonsInGroup(
		groupId: String,
		relatedPersonIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteRelatedPersonInGroup(
		groupId: String,
		relatedPersonId: String,
		rev: String,
	): HttpResponse<EncryptedRelatedPerson>

	suspend fun undeleteRelatedPersonsInGroup(
		groupId: String,
		relatedPersonIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun purgeRelatedPersonInGroup(
		groupId: String,
		relatedPersonId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeRelatedPersonsInGroup(
		groupId: String,
		relatedPersonIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedRelatedPerson>>>

	suspend fun matchRelatedPersonsInGroupBy(
		filter: AbstractFilter<RelatedPerson>,
		groupId: String,
	): HttpResponse<List<String>>

	suspend fun getConflictingEntitiesIdsInGroup(groupId: String): HttpResponse<List<String>>

	suspend fun getConflictsForEntityInGroup(
		groupId: String,
		entityId: String,
	): HttpResponse<List<EncryptedRelatedPerson>>

	suspend fun declareConflictWinnerInGroup(
		groupId: String,
		request: ConflictResolutionRequest<EncryptedRelatedPerson>,
	): HttpResponse<ConflictResolutionResult<EncryptedRelatedPerson>>

	suspend fun autoSolveConflictsInGroup(
		groupId: String,
		entityIds: List<String>,
		strategy: ConflictResolutionStrategy?,
	): HttpResponse<List<MergeResult>>
	// endregion
}
