package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
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
public interface RawDocumentApi {
	// region common endpoints

	suspend fun createDocument(
		documentDto: EncryptedDocument,
		strict: Boolean? = null,
	): HttpResponse<EncryptedDocument>

	suspend fun createDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>>

	suspend fun deleteDocuments(documentIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteDocumentsWithRev(documentIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteDocument(
		documentId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteDocument(
		documentId: String,
		rev: String,
	): HttpResponse<EncryptedDocument>

	suspend fun undeleteDocuments(documentIds: ListOfIdsAndRev): HttpResponse<List<EncryptedDocument>>

	suspend fun purgeDocument(
		documentId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeDocuments(documentIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun getMainAttachment(
		documentId: String,
		fileName: String? = null,
	): HttpResponse<ByteArray>

	suspend fun deleteAttachment(
		documentId: String,
		rev: String,
	): HttpResponse<EncryptedDocument>

	suspend fun setDocumentAttachment(
		documentId: String,
		rev: String,
		utis: List<String>? = null,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean? = null,
	): HttpResponse<EncryptedDocument>

	suspend fun getDocument(documentId: String): HttpResponse<EncryptedDocument>

	suspend fun getDocumentByExternalUuid(externalUuid: String): HttpResponse<EncryptedDocument>

	suspend fun getDocumentsByExternalUuid(externalUuid: String): HttpResponse<List<EncryptedDocument>>

	suspend fun getDocuments(documentIds: ListOfIds): HttpResponse<List<EncryptedDocument>>

	suspend fun modifyDocument(documentDto: EncryptedDocument): HttpResponse<EncryptedDocument>

	suspend fun modifyDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>>

	suspend fun listDocumentIdsByDataOwnerPatientCreated(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun findWithoutDelegation(limit: Int? = null): HttpResponse<List<EncryptedDocument>>

	suspend fun setSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>? = null,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean? = null,
	): HttpResponse<EncryptedDocument>

	suspend fun getSecondaryAttachment(
		documentId: String,
		key: String,
		fileName: String? = null,
	): HttpResponse<ByteArray>

	suspend fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
	): HttpResponse<EncryptedDocument>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedDocument>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>

	suspend fun matchDocumentsBy(filter: AbstractFilter<Document>): HttpResponse<List<String>>
	// endregion

	// region cloud endpoints

	suspend fun createDocumentInGroup(
		groupId: String,
		documentDto: EncryptedDocument,
	): HttpResponse<EncryptedDocument>

	suspend fun createDocumentsInGroup(
		groupId: String,
		documentDtos: List<EncryptedDocument>,
	): HttpResponse<List<EncryptedDocument>>

	suspend fun modifyDocumentInGroup(
		groupId: String,
		documentDto: EncryptedDocument,
	): HttpResponse<EncryptedDocument>

	suspend fun modifyDocumentsInGroup(
		groupId: String,
		documentDtos: List<EncryptedDocument>,
	): HttpResponse<List<EncryptedDocument>>

	suspend fun getDocumentInGroup(
		groupId: String,
		documentId: String,
	): HttpResponse<EncryptedDocument>

	suspend fun getDocumentsInGroup(
		groupId: String,
		documentIds: ListOfIds,
	): HttpResponse<List<EncryptedDocument>>

	suspend fun deleteDocumentInGroup(
		groupId: String,
		documentId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deleteDocumentsInGroup(
		groupId: String,
		documentIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteDocumentInGroup(
		groupId: String,
		documentId: String,
		rev: String,
	): HttpResponse<EncryptedDocument>

	suspend fun undeleteDocumentsInGroup(
		groupId: String,
		documentIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedDocument>>

	suspend fun purgeDocumentInGroup(
		groupId: String,
		documentId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeDocumentsInGroup(
		groupId: String,
		documentIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedDocument>>>

	suspend fun matchDocumentsInGroupBy(
		filter: AbstractFilter<Document>,
		groupId: String,
	): HttpResponse<List<String>>
	// endregion
}
