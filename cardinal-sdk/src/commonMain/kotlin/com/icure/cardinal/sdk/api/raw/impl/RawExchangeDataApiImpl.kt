package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawExchangeDataApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.requests.ExchangeDataPieceCreationRequest
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
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawExchangeDataApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawExchangeDataApi {
	// region common endpoints

	override suspend fun createExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(exchangeData)
		}.wrap()

	override suspend fun createExchangeDataInBulk(exchangeDatas: List<ExchangeData>): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "bulk")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(exchangeDatas)
		}.wrap()

	override suspend fun modifyExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(exchangeData)
		}.wrap()

	override suspend fun getExchangeDataById(exchangeDataId: String): HttpResponse<ExchangeData> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", exchangeDataId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByIds(exchangeDataIds: ListOfIds): HttpResponse<List<ExchangeData>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(exchangeDataIds)
		}.wrap()

	override suspend fun createExchangeDataGroupPieces(
		exchangeDataGroupId: String,
		delegator: String,
		`delegate`: String,
		piecesByRecipient: Map<String, ExchangeDataPieceCreationRequest>,
	): HttpResponse<List<ExchangeData>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "group", exchangeDataGroupId, "pieces")
				parameter("delegator", delegator)
				parameter("delegate", delegate)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(piecesByRecipient)
		}.wrap()

	override suspend fun getExchangeDataGroupById(
		exchangeDataGroupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "group", exchangeDataGroupId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataGroupByIdForRecipients(
		exchangeDataGroupId: String,
		recipients: String,
		startDocumentId: String?,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "group", exchangeDataGroupId, "byRecipients")
				parameter("recipients", recipients)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByParticipantForRecipients(
		dataOwnerId: String,
		recipients: String,
		startDocumentId: String?,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", "byRecipients")
				parameter("dataOwnerId", dataOwnerId)
				parameter("recipients", recipients)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByDelegatorDelegateForRecipients(
		delegatorId: String,
		delegateId: String,
		recipients: String,
		startDocumentId: String?,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byDelegatorDelegate", "byRecipients")
				parameter("delegatorId", delegatorId)
				parameter("delegateId", delegateId)
				parameter("recipients", recipients)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findNonGroupPieceCounterparts(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String?,
		startKey: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", "nonGroupPieceCounterparts")
				parameter("dataOwnerId", dataOwnerId)
				parameter("counterpartsTypes", counterpartsTypes)
				parameter("ignoreOnEntryForFingerprint", ignoreOnEntryForFingerprint)
				parameter("startKey", startKey)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createExchangeData(
		exchangeData: ExchangeData,
		groupId: String,
	): HttpResponse<ExchangeData> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(exchangeData)
		}.wrap()

	override suspend fun modifyExchangeData(
		exchangeData: ExchangeData,
		groupId: String,
	): HttpResponse<ExchangeData> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(exchangeData)
		}.wrap()

	override suspend fun getExchangeDataById(
		exchangeDataId: String,
		groupId: String,
	): HttpResponse<ExchangeData> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", exchangeDataId, "inGroup", groupId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByIds(
		exchangeDataIds: ListOfIds,
		groupId: String,
	): HttpResponse<List<ExchangeData>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byIds", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(exchangeDataIds)
		}.wrap()

	override suspend fun createExchangeDataGroupPieces(
		exchangeDataGroupId: String,
		delegator: String,
		`delegate`: String,
		piecesByRecipient: Map<String, ExchangeDataPieceCreationRequest>,
		groupId: String,
	): HttpResponse<List<ExchangeData>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "group", exchangeDataGroupId, "pieces", "inGroup", groupId)
				parameter("delegator", delegator)
				parameter("delegate", delegate)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(piecesByRecipient)
		}.wrap()

	override suspend fun getExchangeDataGroupById(
		exchangeDataGroupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "group", exchangeDataGroupId, "inGroup", groupId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataGroupByIdForRecipients(
		exchangeDataGroupId: String,
		recipients: String,
		startDocumentId: String?,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "group", exchangeDataGroupId, "byRecipients", "inGroup", groupId)
				parameter("recipients", recipients)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByParticipantForRecipients(
		dataOwnerId: String,
		recipients: String,
		startDocumentId: String?,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", "byRecipients", "inGroup", groupId)
				parameter("dataOwnerId", dataOwnerId)
				parameter("recipients", recipients)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByDelegatorDelegateForRecipients(
		delegatorId: String,
		delegateId: String,
		recipients: String,
		startDocumentId: String?,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byDelegatorDelegate", "byRecipients", "inGroup", groupId)
				parameter("delegatorId", delegatorId)
				parameter("delegateId", delegateId)
				parameter("recipients", recipients)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
