package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawDocumentApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.DocumentAbstractFilterSerializer
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
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawDocumentApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawDocumentApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.Document,
		)

	// region common endpoints

	override suspend fun createDocument(
		documentDto: EncryptedDocument,
		strict: Boolean?,
	): HttpResponse<EncryptedDocument> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document")
				parameter("strict", strict)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDto)
		}.wrap()

	override suspend fun createDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun deleteDocuments(documentIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun deleteDocumentsWithRev(documentIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun deleteDocument(
		documentId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteDocument(
		documentId: String,
		rev: String,
	): HttpResponse<EncryptedDocument> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "undelete", documentId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteDocuments(documentIds: ListOfIdsAndRev): HttpResponse<List<EncryptedDocument>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun purgeDocument(
		documentId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "purge", documentId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeDocuments(documentIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun getMainAttachment(
		documentId: String,
		fileName: String?,
	): HttpResponse<ByteArray> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "attachment")
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.OctetStream)
		}.wrap()

	override suspend fun deleteAttachment(
		documentId: String,
		rev: String,
	): HttpResponse<EncryptedDocument> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "attachment")
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun setDocumentAttachment(
		documentId: String,
		rev: String,
		utis: List<String>?,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean?,
	): HttpResponse<EncryptedDocument> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "attachment")
				parameter("rev", rev)
				utis?.forEach {
					parameter("utis", it)
				}
				parameter("encrypted", encrypted)
			}
			accept(Application.Json)
			`header`("Content-Length", lengthHeader)
			setBody(ByteArrayContent(payload, Application.OctetStream))
		}.wrap()

	override suspend fun getDocument(documentId: String): HttpResponse<EncryptedDocument> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getDocumentByExternalUuid(externalUuid: String): HttpResponse<EncryptedDocument> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "externaluuid", externalUuid)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getDocumentsByExternalUuid(externalUuid: String): HttpResponse<List<EncryptedDocument>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "externaluuid", externalUuid, "all")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getDocuments(documentIds: ListOfIds): HttpResponse<List<EncryptedDocument>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun modifyDocument(documentDto: EncryptedDocument): HttpResponse<EncryptedDocument> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDto)
		}.wrap()

	override suspend fun modifyDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun listDocumentIdsByDataOwnerPatientCreated(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "byDataOwnerPatientCreated")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findWithoutDelegation(limit: Int?): HttpResponse<List<EncryptedDocument>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "woDelegation")
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun setSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>?,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean?,
	): HttpResponse<EncryptedDocument> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "secondaryAttachments", key)
				parameter("rev", rev)
				utis?.forEach {
					parameter("utis", it)
				}
				parameter("encrypted", encrypted)
			}
			accept(Application.Json)
			`header`("Content-Length", lengthHeader)
			setBody(ByteArrayContent(payload, Application.OctetStream))
		}.wrap()

	override suspend fun getSecondaryAttachment(
		documentId: String,
		key: String,
		fileName: String?,
	): HttpResponse<ByteArray> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "secondaryAttachments", key)
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
	): HttpResponse<EncryptedDocument> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "secondaryAttachments", key)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedDocument>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchDocumentsBy(filter: AbstractFilter<Document>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(DocumentAbstractFilterSerializer, filter)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createDocumentInGroup(
		groupId: String,
		documentDto: EncryptedDocument,
	): HttpResponse<EncryptedDocument> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDto)
		}.wrap()

	override suspend fun createDocumentsInGroup(
		groupId: String,
		documentDtos: List<EncryptedDocument>,
	): HttpResponse<List<EncryptedDocument>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun modifyDocumentInGroup(
		groupId: String,
		documentDto: EncryptedDocument,
	): HttpResponse<EncryptedDocument> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDto)
		}.wrap()

	override suspend fun modifyDocumentsInGroup(
		groupId: String,
		documentDtos: List<EncryptedDocument>,
	): HttpResponse<List<EncryptedDocument>> =
		put(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun getDocumentInGroup(
		groupId: String,
		documentId: String,
	): HttpResponse<EncryptedDocument> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, documentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getDocumentsInGroup(
		groupId: String,
		documentIds: ListOfIds,
	): HttpResponse<List<EncryptedDocument>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun deleteDocumentInGroup(
		groupId: String,
		documentId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, documentId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteDocumentsInGroup(
		groupId: String,
		documentIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun undeleteDocumentInGroup(
		groupId: String,
		documentId: String,
		rev: String,
	): HttpResponse<EncryptedDocument> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "undelete", documentId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteDocumentsInGroup(
		groupId: String,
		documentIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedDocument>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun purgeDocumentInGroup(
		groupId: String,
		documentId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "purge", documentId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeDocumentsInGroup(
		groupId: String,
		documentIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedDocument>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchDocumentsInGroupBy(
		filter: AbstractFilter<Document>,
		groupId: String,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(DocumentAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}
