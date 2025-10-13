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

	override suspend fun getExchangeDataByParticipant(
		dataOwnerId: String,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", dataOwnerId)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByParticipantQuery(
		dataOwnerId: String,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByDelegatorDelegate(
		delegatorId: String,
		delegateId: String,
	): HttpResponse<List<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byDelegatorDelegate", delegatorId, delegateId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByDelegatorDelegateQuery(
		delegatorId: String,
		delegateId: String,
	): HttpResponse<List<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byDelegatorDelegate")
				parameter("delegatorId", delegatorId)
				parameter("delegateId", delegateId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getParticipantCounterparts(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String?,
	): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", dataOwnerId, "counterparts")
				parameter("counterpartsTypes", counterpartsTypes)
				parameter("ignoreOnEntryForFingerprint", ignoreOnEntryForFingerprint)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getParticipantCounterpartsQuery(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String?,
	): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", "counterparts")
				parameter("dataOwnerId", dataOwnerId)
				parameter("counterpartsTypes", counterpartsTypes)
				parameter("ignoreOnEntryForFingerprint", ignoreOnEntryForFingerprint)
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

	override suspend fun getExchangeDataByParticipant(
		dataOwnerId: String,
		startDocumentId: String?,
		limit: Int?,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", "inGroup", groupId)
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByDelegatorDelegate(
		delegatorId: String,
		delegateId: String,
		groupId: String,
	): HttpResponse<List<ExchangeData>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byDelegatorDelegate", "inGroup", groupId)
				parameter("delegatorId", delegatorId)
				parameter("delegateId", delegateId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
