package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawHealthElementApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
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
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.HealthElementAbstractFilterSerializer
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

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawHealthElementApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawHealthElementApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.HealthElement,
		)

	// region common endpoints

	override suspend fun createHealthElement(c: EncryptedHealthElement): HttpResponse<EncryptedHealthElement> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getHealthElement(healthElementId: String): HttpResponse<EncryptedHealthElement> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", healthElementId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getHealthElements(healthElementIds: ListOfIds): HttpResponse<List<EncryptedHealthElement>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun listHealthElementIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "byDataOwnerPatientOpeningDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun listHealthElementsDelegationsStubById(healthElementIds: ListOfIds): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "delegations")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun deleteHealthElements(healthElementIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun deleteHealthElementsWithRev(healthElementIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun deleteHealthElement(
		healthElementId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", healthElementId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteHealthElement(
		healthElementId: String,
		rev: String,
	): HttpResponse<EncryptedHealthElement> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "undelete", healthElementId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteHealthElements(healthElementIds: ListOfIdsAndRev): HttpResponse<List<EncryptedHealthElement>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun purgeHealthElement(
		healthElementId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "purge", healthElementId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeHealthElements(healthElementIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun modifyHealthElement(healthElementDto: EncryptedHealthElement): HttpResponse<EncryptedHealthElement> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDto)
		}.wrap()

	override suspend fun modifyHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun createHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun filterHealthElementsBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<HealthElement>,
	): HttpResponse<PaginatedList<EncryptedHealthElement>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(HealthElementAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedHealthElement>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(HealthElementAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createHealthElementInGroup(
		groupId: String,
		healthElementDto: EncryptedHealthElement,
	): HttpResponse<EncryptedHealthElement> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDto)
		}.wrap()

	override suspend fun createHealthElementsInGroup(
		groupId: String,
		healthElementDtos: List<EncryptedHealthElement>,
	): HttpResponse<List<EncryptedHealthElement>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun modifyHealthElementInGroup(
		groupId: String,
		healthElementDto: EncryptedHealthElement,
	): HttpResponse<EncryptedHealthElement> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDto)
		}.wrap()

	override suspend fun modifyHealthElementsInGroup(
		groupId: String,
		healthElementDtos: List<EncryptedHealthElement>,
	): HttpResponse<List<EncryptedHealthElement>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun getHealthElementInGroup(
		groupId: String,
		healthElementId: String,
	): HttpResponse<EncryptedHealthElement> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, healthElementId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getHealthElementsInGroup(
		groupId: String,
		healthElementIds: ListOfIds,
	): HttpResponse<List<EncryptedHealthElement>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun deleteHealthElementInGroup(
		groupId: String,
		healthElementId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, healthElementId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteHealthElementsInGroup(
		groupId: String,
		healthElementIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun undeleteHealthElementInGroup(
		groupId: String,
		healthElementId: String,
		rev: String,
	): HttpResponse<EncryptedHealthElement> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "undelete", healthElementId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteHealthElementsInGroup(
		groupId: String,
		healthElementIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedHealthElement>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun purgeHealthElementInGroup(
		groupId: String,
		healthElementId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "purge", healthElementId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeHealthElementsInGroup(
		groupId: String,
		healthElementIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedHealthElement>>> =
		put(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchHealthElementsInGroupBy(
		filter: AbstractFilter<HealthElement>,
		groupId: String,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(HealthElementAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}
