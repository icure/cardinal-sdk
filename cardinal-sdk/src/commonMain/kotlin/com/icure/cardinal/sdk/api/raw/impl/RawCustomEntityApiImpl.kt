package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawCustomEntityApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawCustomEntityApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.IcureStub
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
	customEntityType: String,
	accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	usesAccessControlKeys: Boolean,
	rawApiConfig: RawApiConfig,
) : BaseRawCustomEntityApi(rawApiConfig, customEntityType, accessControlKeysHeadersProvider, usesAccessControlKeys),
	RawCustomEntityApi {
	// region common endpoints

	override suspend fun createCustomEntity(entityDto: EncryptedCustomEntityBase): HttpResponse<EncryptedCustomEntityBase> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityDto)
		}.wrap()

	override suspend fun createCustomEntities(entityDtos: List<EncryptedCustomEntityBase>): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityDtos)
		}.wrap()

	override suspend fun getCustomEntity(entityId: String): HttpResponse<EncryptedCustomEntityBase> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, entityId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCustomEntities(entityIds: ListOfIds): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrapList()

	override suspend fun findCustomEntitiesDelegationsStubsByIds(entityIds: ListOfIds): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "delegations")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun modifyCustomEntity(customEntityDto: EncryptedCustomEntityBase): HttpResponse<EncryptedCustomEntityBase> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(customEntityDto)
		}.wrap()

	override suspend fun modifyCustomEntities(
		customEntityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(customEntityDtos)
		}.wrap()

	override suspend fun deleteCustomEntity(
		entityId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, entityId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteCustomEntities(entityIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun undeleteCustomEntity(
		entityId: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "undelete", entityId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteCustomEntities(entityIds: ListOfIdsAndRev): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun purgeCustomEntity(
		entityId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "purge", entityId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeCustomEntities(entityIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCustomEntityBase>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun getAttachment(
		entityId: String,
		key: String,
		fileName: String?,
	): HttpResponse<ByteArray> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, entityId, "attachments", key)
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun setAttachment(
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
				appendPathSegments("rest", "v2", "custom", customEntityType, entityId, "attachments", key)
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
		entityId: String,
		key: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, entityId, "attachments", key)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createCustomEntityInGroup(
		groupId: String,
		entityDto: EncryptedCustomEntityBase,
	): HttpResponse<EncryptedCustomEntityBase> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityDto)
		}.wrap()

	override suspend fun createCustomEntitiesInGroup(
		groupId: String,
		entityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityDtos)
		}.wrap()

	override suspend fun getCustomEntityInGroup(
		groupId: String,
		entityId: String,
	): HttpResponse<EncryptedCustomEntityBase> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, entityId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCustomEntitiesInGroup(
		groupId: String,
		entityIds: ListOfIds,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrapList()

	override suspend fun modifyCustomEntityInGroup(
		groupId: String,
		customEntityDto: EncryptedCustomEntityBase,
	): HttpResponse<EncryptedCustomEntityBase> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(customEntityDto)
		}.wrap()

	override suspend fun modifyCustomEntitiesInGroup(
		groupId: String,
		customEntityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(customEntityDtos)
		}.wrap()

	override suspend fun deleteCustomEntityInGroup(
		groupId: String,
		entityId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, entityId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteCustomEntitiesInGroup(
		groupId: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun undeleteCustomEntityInGroup(
		groupId: String,
		entityId: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "undelete", entityId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteCustomEntitiesInGroup(
		groupId: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedCustomEntityBase>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun purgeCustomEntityInGroup(
		groupId: String,
		entityId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "purge", entityId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeCustomEntitiesInGroup(
		groupId: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityIds)
		}.wrap()

	override suspend fun bulkShareInGroup(
		groupId: String,
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCustomEntityBase>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "custom", customEntityType, "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
