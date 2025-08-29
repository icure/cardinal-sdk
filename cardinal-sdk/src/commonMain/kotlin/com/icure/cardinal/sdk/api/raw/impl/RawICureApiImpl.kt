package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawICureApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.IndexingInfo
import com.icure.cardinal.sdk.model.ReplicationInfo
import com.icure.cardinal.sdk.model.couchdb.ReplicatorDocument
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.http.ContentType.Application
import io.ktor.http.ContentType.Text
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawICureApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawICureApi {
	// region common endpoints

	override suspend fun getVersion(): HttpResponse<String> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "v")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Text.Plain)
		}.wrap()

	override suspend fun isReady(): HttpResponse<String> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "ok")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Text.Plain)
		}.wrap()

	override suspend fun getProcessInfo(): HttpResponse<String> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "p")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Text.Plain)
		}.wrap()

	override suspend fun getIndexingInfo(): HttpResponse<IndexingInfo> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "i")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getReplicationInfo(): HttpResponse<ReplicationInfo> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "r")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun updateDesignDoc(
		entityName: String,
		warmup: Boolean?,
	): HttpResponse<Boolean> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "dd", entityName)
				parameter("warmup", warmup)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resolvePatientsConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "patient")
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resolveContactsConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "contact")
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resolveFormsConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "form")
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resolveHealthElementsConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "healthelement")
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resolveInvoicesConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "invoice")
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resolveMessagesConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "message")
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resolveDocumentsConflicts(
		ids: String?,
		limit: Int?,
	): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "document")
				parameter("ids", ids)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resolveCodesConflicts(
		ids: String?,
		limit: Int?,
	): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "code")
				parameter("ids", ids)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getIndexingInfoByGroup(groupId: String): HttpResponse<IndexingInfo> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "byGroup", groupId, "i")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getReplicatorInfo(id: String): HttpResponse<ReplicatorDocument> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "r", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun evictAllFromMap(mapName: String): HttpResponse<String> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "hzc", mapName)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun loglevel(
		loglevel: String,
		loggerName: String,
	): HttpResponse<String> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "loglevel", loggerName, loglevel)
			}
			contentType(Application.Json)
			accept(Text.Plain)
		}.wrap()

	override suspend fun updateSharedEntitiesDesignDocuments(
		cluster: String,
		databasePartition: String,
		entityType: String,
		viewPartition: String,
		dryRun: Boolean?,
		warmup: Boolean?,
	): HttpResponse<Map<String, Map<String, Map<Int, Set<String>>>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "sharedEntities", "dd")
				parameter("cluster", cluster)
				parameter("databasePartition", databasePartition)
				parameter("entityType", entityType)
				parameter("viewPartition", viewPartition)
				parameter("dryRun", dryRun)
				parameter("warmup", warmup)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	// endregion
}
