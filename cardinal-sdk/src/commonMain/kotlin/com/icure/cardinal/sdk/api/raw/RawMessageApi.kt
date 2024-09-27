package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.MessagesReadStatusUpdate
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
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawMessageApi {
	// region common endpoints

	suspend fun createMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage>

	suspend fun deleteMessages(messageIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteMessagesWithRev(messageIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteMessage(messageId: String): HttpResponse<DocIdentifier>

	suspend fun undeleteMessage(messageId: String): HttpResponse<EncryptedMessage>

	suspend fun purgeMessage(messageId: String): HttpResponse<DocIdentifier>

	suspend fun getMessage(messageId: String): HttpResponse<EncryptedMessage>

	suspend fun getMessages(messageIds: ListOfIds): HttpResponse<List<EncryptedMessage>>

	suspend fun listMessagesByTransportGuids(
		hcpId: String,
		transportGuids: ListOfIds,
	): HttpResponse<List<EncryptedMessage>>

	suspend fun findMessagesByHCPartyPatientForeignKeys(secretFKeys: String): HttpResponse<List<EncryptedMessage>>

	suspend fun listMessageIdsByDataOwnerPatientSentDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: List<String>): HttpResponse<List<EncryptedMessage>>

	suspend fun findMessages(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedMessage>>

	suspend fun getChildrenMessages(messageId: String): HttpResponse<List<EncryptedMessage>>

	suspend fun getMessagesChildren(parentIds: ListOfIds): HttpResponse<List<EncryptedMessage>>

	suspend fun listMessagesByInvoices(ids: ListOfIds): HttpResponse<List<EncryptedMessage>>

	suspend fun findMessagesByTransportGuid(
		transportGuid: String? = null,
		received: Boolean? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		hcpId: String? = null,
	): HttpResponse<PaginatedList<EncryptedMessage>>

	suspend fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Long,
		to: Long,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		hcpId: String? = null,
	): HttpResponse<PaginatedList<EncryptedMessage>>

	suspend fun findMessagesByToAddress(
		toAddress: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		reverse: Boolean? = null,
		hcpId: String? = null,
	): HttpResponse<PaginatedList<EncryptedMessage>>

	suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		hcpId: String? = null,
	): HttpResponse<PaginatedList<EncryptedMessage>>

	suspend fun modifyMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage>

	suspend fun setMessagesStatusBits(
		status: Int,
		messageIds: ListOfIds,
	): HttpResponse<List<EncryptedMessage>>

	suspend fun setMessagesReadStatus(`data`: MessagesReadStatusUpdate): HttpResponse<List<EncryptedMessage>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedMessage>>>

	suspend fun filterMessagesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Message>,
	): HttpResponse<PaginatedList<EncryptedMessage>>

	suspend fun matchMessagesBy(filter: AbstractFilter<Message>): HttpResponse<List<String>>
	// endregion

	// region cloud endpoints

	suspend fun createMessageInTopic(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage>

	suspend fun matchMessagesBy(
		groupId: String,
		filter: AbstractFilter<Message>,
	): HttpResponse<List<String>>
	// endregion
}
