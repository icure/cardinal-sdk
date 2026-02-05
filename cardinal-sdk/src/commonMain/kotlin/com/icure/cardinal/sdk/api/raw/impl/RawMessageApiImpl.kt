package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawMessageApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
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
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.MessageAbstractFilterSerializer
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
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawMessageApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawMessageApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.Message,
		)

	// region common endpoints

	override suspend fun createMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun createMessages(messageDtos: List<EncryptedMessage>): HttpResponse<List<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDtos)
		}.wrap()

	override suspend fun deleteMessages(messageIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun deleteMessagesWithRev(messageIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun deleteMessage(
		messageId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", messageId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteMessage(
		messageId: String,
		rev: String,
	): HttpResponse<EncryptedMessage> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "undelete", messageId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteMessages(messageIds: ListOfIdsAndRev): HttpResponse<List<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun purgeMessage(
		messageId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "purge", messageId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeMessages(messageIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun getMessage(messageId: String): HttpResponse<EncryptedMessage> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", messageId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getMessages(messageIds: ListOfIds): HttpResponse<List<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun listMessagesByTransportGuids(
		hcpId: String,
		transportGuids: ListOfIds,
	): HttpResponse<List<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byTransportGuid", "list")
				parameter("hcpId", hcpId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(transportGuids)
		}.wrap()

	override suspend fun listMessageIdsByDataOwnerPatientSentDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byDataOwnerPatientSentDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findMessages(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getChildrenMessages(messageId: String): HttpResponse<List<EncryptedMessage>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", messageId, "children")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getMessagesChildren(parentIds: ListOfIds): HttpResponse<List<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "children", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(parentIds)
		}.wrap()

	override suspend fun listMessagesByInvoices(ids: ListOfIds): HttpResponse<List<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byInvoice")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun findMessagesByTransportGuid(
		transportGuid: String?,
		received: Boolean?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		hcpId: String?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byTransportGuid")
				parameter("transportGuid", transportGuid)
				parameter("received", received)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("hcpId", hcpId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Long,
		to: Long,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		hcpId: String?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byTransportGuidSentDate")
				parameter("transportGuid", transportGuid)
				parameter("from", from)
				parameter("to", to)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("hcpId", hcpId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findMessagesByToAddress(
		toAddress: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		reverse: Boolean?,
		hcpId: String?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byToAddress")
				parameter("toAddress", toAddress)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("reverse", reverse)
				parameter("hcpId", hcpId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		hcpId: String?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byFromAddress")
				parameter("fromAddress", fromAddress)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("hcpId", hcpId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun modifyMessages(messageDtos: List<EncryptedMessage>): HttpResponse<List<EncryptedMessage>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDtos)
		}.wrap()

	override suspend fun setMessagesStatusBits(
		status: Int,
		messageIds: ListOfIds,
	): HttpResponse<List<EncryptedMessage>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "status", "$status")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun setMessagesReadStatus(`data`: MessagesReadStatusUpdate): HttpResponse<List<EncryptedMessage>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "readstatus")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(data)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedMessage>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun filterMessagesBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<Message>,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(MessageAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchMessagesBy(filter: AbstractFilter<Message>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(MessageAbstractFilterSerializer, filter)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getMessageInGroup(
		groupId: String,
		messageId: String,
	): HttpResponse<EncryptedMessage> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, messageId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getMessagesInGroup(
		groupId: String,
		messageIds: ListOfIds,
	): HttpResponse<List<EncryptedMessage>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun createMessageInTopic(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "topic")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun createMessageInGroup(
		groupId: String,
		messageDto: EncryptedMessage,
	): HttpResponse<EncryptedMessage> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun createMessagesInGroup(
		groupId: String,
		messageDtos: List<EncryptedMessage>,
	): HttpResponse<List<EncryptedMessage>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDtos)
		}.wrap()

	override suspend fun modifyMessageInGroup(
		groupId: String,
		messageDto: EncryptedMessage,
	): HttpResponse<EncryptedMessage> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun modifyMessagesInGroup(
		groupId: String,
		messageDtos: List<EncryptedMessage>,
	): HttpResponse<List<EncryptedMessage>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDtos)
		}.wrap()

	override suspend fun deleteMessagesInGroup(
		groupId: String,
		messageIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun deleteMessageInGroup(
		groupId: String,
		messageId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, messageId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteMessageInGroup(
		groupId: String,
		messageId: String,
		rev: String,
	): HttpResponse<EncryptedMessage> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "undelete", messageId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteMessagesInGroup(
		groupId: String,
		messageIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedMessage>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun purgeMessageInGroup(
		groupId: String,
		messageId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "purge", messageId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeMessagesInGroup(
		groupId: String,
		messageIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun matchMessagesBy(
		groupId: String,
		filter: AbstractFilter<Message>,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(MessageAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedMessage>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
