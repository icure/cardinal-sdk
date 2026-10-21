package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawCustomEntityApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.`header`
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.content.ByteArrayContent
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCustomEntityApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig),
	RawCustomEntityApi {
	// region common endpoints

	override suspend fun createCustomEntity(
		entityType: String,
		entityDto: EncryptedCustomEntityBase,
	): HttpResponse<EncryptedCustomEntityBase> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityDto)
		}.wrap()

	override suspend fun createCustomEntities(
		entityType: String,
		entityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityDtos)
		}.wrap()

	override suspend fun getCustomEntity(
		entityType: String,
		entityId: String,
	): HttpResponse<EncryptedCustomEntityBase> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, entityId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCustomEntities(
		entityType: String,
		entityIds: ListOfIds,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrapList()

	override suspend fun modifyCustomEntity(
		entityType: String,
		customEntityDto: EncryptedCustomEntityBase,
	): HttpResponse<EncryptedCustomEntityBase> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(customEntityDto)
		}.wrap()

	override suspend fun modifyCustomEntities(
		entityType: String,
		customEntityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(customEntityDtos)
		}.wrap()

	override suspend fun deleteCustomEntity(
		entityType: String,
		entityId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, entityId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteCustomEntities(
		entityType: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun undeleteCustomEntity(
		entityType: String,
		entityId: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "undelete", entityId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteCustomEntities(
		entityType: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun purgeCustomEntity(
		entityType: String,
		entityId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "purge", entityId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeCustomEntities(
		entityType: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun bulkShare(
		entityType: String,
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCustomEntityBase>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(
		entityType: String,
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun getAttachment(
		entityType: String,
		entityId: String,
		key: String,
		fileName: String?,
	): HttpResponse<ByteArray> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, entityId, "attachments", key)
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun setAttachment(
		entityType: String,
		entityId: String,
		key: String,
		rev: String,
		utis: List<String>?,
		compressionAlgorithm: String?,
		triedCompressionAlgorithmsVersion: String?,
		realDataSize: Long?,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean?,
	): HttpResponse<EncryptedCustomEntityBase> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, entityId, "attachments", key)
				parameter("rev", rev)
				utis?.forEach {
					parameter("utis", it)
				}
				parameter("compressionAlgorithm", compressionAlgorithm)
				parameter("triedCompressionAlgorithmsVersion", triedCompressionAlgorithmsVersion)
				parameter("realDataSize", realDataSize)
				parameter("encrypted", encrypted)
			}
			accept(Application.Json)
			`header`("Content-Length", lengthHeader)
			setBody(ByteArrayContent(payload, Application.OctetStream))
		}.wrap()

	override suspend fun deleteAttachment(
		entityType: String,
		entityId: String,
		key: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", entityType, entityId, "attachments", key)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
