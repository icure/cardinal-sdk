package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawReceiptApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.content.ByteArrayContent
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.ByteArray
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawReceiptApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawReceiptApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.Receipt,
		)

	// region common endpoints

	override suspend fun createReceipt(receiptDto: EncryptedReceipt): HttpResponse<EncryptedReceipt> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptDto)
		}.wrap()

	override suspend fun createReceipts(receiptDtos: List<EncryptedReceipt>): HttpResponse<List<EncryptedReceipt>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptDtos)
		}.wrap()

	override suspend fun deleteReceipts(receiptIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun deleteReceiptsWithRev(receiptIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun deleteReceipt(
		receiptId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", receiptId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteReceipt(
		receiptId: String,
		rev: String,
	): HttpResponse<EncryptedReceipt> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "undelete", receiptId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteReceipts(receiptIds: ListOfIdsAndRev): HttpResponse<List<EncryptedReceipt>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun purgeReceipt(
		receiptId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "purge", receiptId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeReceipts(receiptIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun getReceiptAttachment(
		receiptId: String,
		attachmentId: String,
	): HttpResponse<ByteArray> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", receiptId, "attachment", attachmentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.OctetStream)
		}.wrap()

	override suspend fun setReceiptAttachment(
		receiptId: String,
		blobType: String,
		rev: String,
		payload: ByteArray,
	): HttpResponse<EncryptedReceipt> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", receiptId, "attachment", blobType)
				parameter("rev", rev)
			}
			accept(Application.Json)
			setBody(ByteArrayContent(payload, Application.OctetStream))
		}.wrap()

	override suspend fun getReceipt(receiptId: String): HttpResponse<EncryptedReceipt> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", receiptId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getReceipts(receiptIds: ListOfIds): HttpResponse<List<EncryptedReceipt>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun listByReference(ref: String): HttpResponse<List<EncryptedReceipt>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "byRef", ref)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyReceipt(receiptDto: EncryptedReceipt): HttpResponse<EncryptedReceipt> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptDto)
		}.wrap()

	override suspend fun modifyReceipts(receiptDtos: List<EncryptedReceipt>): HttpResponse<List<EncryptedReceipt>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptDtos)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedReceipt>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createReceiptInGroup(
		groupId: String,
		receiptDto: EncryptedReceipt,
	): HttpResponse<EncryptedReceipt> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptDto)
		}.wrap()

	override suspend fun createReceiptsInGroup(
		groupId: String,
		receiptDtos: List<EncryptedReceipt>,
	): HttpResponse<List<EncryptedReceipt>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptDtos)
		}.wrap()

	override suspend fun modifyReceiptInGroup(
		groupId: String,
		receiptDto: EncryptedReceipt,
	): HttpResponse<EncryptedReceipt> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptDto)
		}.wrap()

	override suspend fun modifyReceiptsInGroup(
		groupId: String,
		receiptDtos: List<EncryptedReceipt>,
	): HttpResponse<List<EncryptedReceipt>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptDtos)
		}.wrap()

	override suspend fun getReceiptInGroup(
		groupId: String,
		receiptId: String,
	): HttpResponse<EncryptedReceipt> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, receiptId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getReceiptsInGroup(
		groupId: String,
		receiptIds: ListOfIds,
	): HttpResponse<List<EncryptedReceipt>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun deleteReceiptInGroup(
		groupId: String,
		receiptId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, receiptId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteReceiptsInGroup(
		groupId: String,
		receiptIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun undeleteReceiptInGroup(
		groupId: String,
		receiptId: String,
		rev: String,
	): HttpResponse<EncryptedReceipt> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "undelete", receiptId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteReceiptsInGroup(
		groupId: String,
		receiptIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedReceipt>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun purgeReceiptInGroup(
		groupId: String,
		receiptId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "purge", receiptId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeReceiptsInGroup(
		groupId: String,
		receiptIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedReceipt>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
