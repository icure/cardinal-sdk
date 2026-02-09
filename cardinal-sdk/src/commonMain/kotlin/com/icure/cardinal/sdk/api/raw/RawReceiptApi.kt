package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.ByteArray
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawReceiptApi {
	// region common endpoints

	suspend fun createReceipt(receiptDto: EncryptedReceipt): HttpResponse<EncryptedReceipt>

	suspend fun createReceipts(receiptDtos: List<EncryptedReceipt>): HttpResponse<List<EncryptedReceipt>>

	suspend fun deleteReceipts(receiptIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteReceiptsWithRev(receiptIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteReceipt(
		receiptId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteReceipt(
		receiptId: String,
		rev: String,
	): HttpResponse<EncryptedReceipt>

	suspend fun undeleteReceipts(receiptIds: ListOfIdsAndRev): HttpResponse<List<EncryptedReceipt>>

	suspend fun purgeReceipt(
		receiptId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeReceipts(receiptIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun getReceiptAttachment(
		receiptId: String,
		attachmentId: String,
	): HttpResponse<ByteArray>

	suspend fun setReceiptAttachment(
		receiptId: String,
		blobType: String,
		rev: String,
		payload: ByteArray,
	): HttpResponse<EncryptedReceipt>

	suspend fun getReceipt(receiptId: String): HttpResponse<EncryptedReceipt>

	suspend fun getReceipts(receiptIds: ListOfIds): HttpResponse<List<EncryptedReceipt>>

	suspend fun listByReference(ref: String): HttpResponse<List<EncryptedReceipt>>

	suspend fun modifyReceipt(receiptDto: EncryptedReceipt): HttpResponse<EncryptedReceipt>

	suspend fun modifyReceipts(receiptDtos: List<EncryptedReceipt>): HttpResponse<List<EncryptedReceipt>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedReceipt>>>
	// endregion

	// region cloud endpoints

	suspend fun createReceiptInGroup(
		groupId: String,
		receiptDto: EncryptedReceipt,
	): HttpResponse<EncryptedReceipt>

	suspend fun createReceiptsInGroup(
		groupId: String,
		receiptDtos: List<EncryptedReceipt>,
	): HttpResponse<List<EncryptedReceipt>>

	suspend fun modifyReceiptInGroup(
		groupId: String,
		receiptDto: EncryptedReceipt,
	): HttpResponse<EncryptedReceipt>

	suspend fun modifyReceiptsInGroup(
		groupId: String,
		receiptDtos: List<EncryptedReceipt>,
	): HttpResponse<List<EncryptedReceipt>>

	suspend fun getReceiptInGroup(
		groupId: String,
		receiptId: String,
	): HttpResponse<EncryptedReceipt>

	suspend fun getReceiptsInGroup(
		groupId: String,
		receiptIds: ListOfIds,
	): HttpResponse<List<EncryptedReceipt>>

	suspend fun deleteReceiptInGroup(
		groupId: String,
		receiptId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deleteReceiptsInGroup(
		groupId: String,
		receiptIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteReceiptInGroup(
		groupId: String,
		receiptId: String,
		rev: String,
	): HttpResponse<EncryptedReceipt>

	suspend fun undeleteReceiptsInGroup(
		groupId: String,
		receiptIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedReceipt>>

	suspend fun purgeReceiptInGroup(
		groupId: String,
		receiptId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeReceiptsInGroup(
		groupId: String,
		receiptIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedReceipt>>>
	// endregion
}
