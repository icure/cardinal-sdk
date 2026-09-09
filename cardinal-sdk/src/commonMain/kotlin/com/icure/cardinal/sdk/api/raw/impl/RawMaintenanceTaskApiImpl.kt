package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.MaintenanceTaskAbstractFilterSerializer
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
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawMaintenanceTaskApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawMaintenanceTaskApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
		)

	// region common endpoints

	override suspend fun createMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(maintenanceTaskDto)
		}.wrap()

	override suspend fun deleteMaintenanceTasks(maintenanceTaskIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(maintenanceTaskIds)
		}.wrap()

	override suspend fun deleteMaintenanceTasksWithRev(maintenanceTaskIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(maintenanceTaskIds)
		}.wrap()

	override suspend fun deleteMaintenanceTask(
		maintenanceTaskId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", maintenanceTaskId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteMaintenanceTask(
		maintenanceTaskId: String,
		rev: String,
	): HttpResponse<EncryptedMaintenanceTask> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "undelete", maintenanceTaskId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeMaintenanceTask(
		maintenanceTaskId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "purge", maintenanceTaskId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getMaintenanceTask(maintenanceTaskId: String): HttpResponse<EncryptedMaintenanceTask> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", maintenanceTaskId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getMaintenanceTasks(ids: ListOfIds): HttpResponse<List<EncryptedMaintenanceTask>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun findMaintenanceTasksDelegationsStubsByIds(maintenanceTaskIds: ListOfIds): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "delegations")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(maintenanceTaskIds)
		}.wrap()

	override suspend fun modifyMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(maintenanceTaskDto)
		}.wrap()

	override suspend fun filterMaintenanceTasksBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<MaintenanceTask>,
	): HttpResponse<PaginatedList<EncryptedMaintenanceTask>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(
				FilterChainSerializer(MaintenanceTaskAbstractFilterSerializer),
				filterChain,
			)
		}.wrap()

	override suspend fun matchMaintenanceTasksBy(filter: AbstractFilter<MaintenanceTask>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(MaintenanceTaskAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedMaintenanceTask>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
