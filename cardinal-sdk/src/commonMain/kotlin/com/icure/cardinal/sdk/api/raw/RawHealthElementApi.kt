package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawHealthElementApi {
	// region common endpoints

	suspend fun createHealthElement(c: EncryptedHealthElement): HttpResponse<EncryptedHealthElement>

	suspend fun getHealthElement(healthElementId: String): HttpResponse<EncryptedHealthElement>

	suspend fun getHealthElements(healthElementIds: ListOfIds): HttpResponse<List<EncryptedHealthElement>>

	suspend fun listHealthElementIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun listHealthElementsDelegationsStubById(healthElementIds: ListOfIds): HttpResponse<List<IcureStub>>

	suspend fun deleteHealthElements(healthElementIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteHealthElementsWithRev(healthElementIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteHealthElement(
		healthElementId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteHealthElement(
		healthElementId: String,
		rev: String,
	): HttpResponse<EncryptedHealthElement>

	suspend fun undeleteHealthElements(healthElementIds: ListOfIdsAndRev): HttpResponse<List<EncryptedHealthElement>>

	suspend fun purgeHealthElement(
		healthElementId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeHealthElements(healthElementIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun modifyHealthElement(healthElementDto: EncryptedHealthElement): HttpResponse<EncryptedHealthElement>

	suspend fun modifyHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>>

	suspend fun createHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>>

	suspend fun filterHealthElementsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<HealthElement>,
	): HttpResponse<PaginatedList<EncryptedHealthElement>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedHealthElement>>>

	suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>): HttpResponse<List<String>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion

	// region cloud endpoints

	suspend fun createHealthElementInGroup(
		groupId: String,
		healthElementDto: EncryptedHealthElement,
	): HttpResponse<EncryptedHealthElement>

	suspend fun createHealthElementsInGroup(
		groupId: String,
		healthElementDtos: List<EncryptedHealthElement>,
	): HttpResponse<List<EncryptedHealthElement>>

	suspend fun modifyHealthElementInGroup(
		groupId: String,
		healthElementDto: EncryptedHealthElement,
	): HttpResponse<EncryptedHealthElement>

	suspend fun modifyHealthElementsInGroup(
		groupId: String,
		healthElementDtos: List<EncryptedHealthElement>,
	): HttpResponse<List<EncryptedHealthElement>>

	suspend fun getHealthElementInGroup(
		groupId: String,
		healthElementId: String,
	): HttpResponse<EncryptedHealthElement>

	suspend fun getHealthElementsInGroup(
		groupId: String,
		healthElementIds: ListOfIds,
	): HttpResponse<List<EncryptedHealthElement>>

	suspend fun deleteHealthElementInGroup(
		groupId: String,
		healthElementId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deleteHealthElementsInGroup(
		groupId: String,
		healthElementIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteHealthElementInGroup(
		groupId: String,
		healthElementId: String,
		rev: String,
	): HttpResponse<EncryptedHealthElement>

	suspend fun undeleteHealthElementsInGroup(
		groupId: String,
		healthElementIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedHealthElement>>

	suspend fun purgeHealthElementInGroup(
		groupId: String,
		healthElementId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeHealthElementsInGroup(
		groupId: String,
		healthElementIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedHealthElement>>>

	suspend fun matchHealthElementsInGroupBy(
		filter: AbstractFilter<HealthElement>,
		groupId: String,
	): HttpResponse<List<String>>
	// endregion
}
