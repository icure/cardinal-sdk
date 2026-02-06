package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawTopicApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.model.requests.topic.AddParticipant
import com.icure.cardinal.sdk.model.requests.topic.RemoveParticipant
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.TopicAbstractFilterSerializer
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
class RawTopicApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawTopicApi {
	// region cloud endpoints

	override suspend fun getTopic(topicId: String): HttpResponse<EncryptedTopic> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", topicId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getTopics(topicIds: ListOfIds): HttpResponse<List<EncryptedTopic>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun getTopicInGroup(
		groupId: String,
		topicId: String,
	): HttpResponse<EncryptedTopic> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, topicId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getTopicsInGroup(
		groupId: String,
		topicIds: ListOfIds,
	): HttpResponse<List<EncryptedTopic>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun createTopic(ft: EncryptedTopic): HttpResponse<EncryptedTopic> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun createTopics(topicDtos: List<EncryptedTopic>): HttpResponse<List<EncryptedTopic>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicDtos)
		}.wrap()

	override suspend fun createTopicInGroup(
		groupId: String,
		topicDto: EncryptedTopic,
	): HttpResponse<EncryptedTopic> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicDto)
		}.wrap()

	override suspend fun createTopicsInGroup(
		groupId: String,
		topicDtos: List<EncryptedTopic>,
	): HttpResponse<List<EncryptedTopic>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicDtos)
		}.wrap()

	override suspend fun modifyTopic(topicDto: EncryptedTopic): HttpResponse<EncryptedTopic> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicDto)
		}.wrap()

	override suspend fun modifyTopics(topicDtos: List<EncryptedTopic>): HttpResponse<List<EncryptedTopic>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicDtos)
		}.wrap()

	override suspend fun modifyTopicInGroup(
		groupId: String,
		topicDto: EncryptedTopic,
	): HttpResponse<EncryptedTopic> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicDto)
		}.wrap()

	override suspend fun modifyTopicsInGroup(
		groupId: String,
		topicDtos: List<EncryptedTopic>,
	): HttpResponse<List<EncryptedTopic>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicDtos)
		}.wrap()

	override suspend fun deleteTopics(topicIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun deleteTopicsWithRev(topicIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun deleteTopic(
		topicId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", topicId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteTopicInGroup(
		groupId: String,
		topicId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, topicId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteTopicsInGroup(
		groupId: String,
		topicIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun undeleteTopic(
		topicId: String,
		rev: String,
	): HttpResponse<EncryptedTopic> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "undelete", topicId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteTopics(topicIds: ListOfIdsAndRev): HttpResponse<List<EncryptedTopic>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun undeleteTopicInGroup(
		groupId: String,
		topicId: String,
		rev: String,
	): HttpResponse<EncryptedTopic> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "undelete", topicId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteTopicsInGroup(
		groupId: String,
		topicIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedTopic>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun purgeTopic(
		topicId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "purge", topicId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeTopics(topicIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun purgeTopicInGroup(
		groupId: String,
		topicId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "purge", topicId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeTopicsInGroup(
		groupId: String,
		topicIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedTopic>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedTopic>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun filterTopicsBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<Topic>,
	): HttpResponse<PaginatedList<EncryptedTopic>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(TopicAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchTopicsBy(filter: AbstractFilter<Topic>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(TopicAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun matchTopicsBy(
		groupId: String,
		filter: AbstractFilter<Topic>,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(TopicAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun addParticipant(
		topicId: String,
		request: AddParticipant,
	): HttpResponse<EncryptedTopic> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", topicId, "addParticipant")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun removeParticipant(
		topicId: String,
		request: RemoveParticipant,
	): HttpResponse<EncryptedTopic> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", topicId, "removeParticipant")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
