package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawExchangeDataApi {
	// region common endpoints

	suspend fun createExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData>

	suspend fun createExchangeDataInBulk(exchangeDatas: List<ExchangeData>): HttpResponse<List<IdWithRev>>

	suspend fun modifyExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData>

	suspend fun getExchangeDataById(exchangeDataId: String): HttpResponse<ExchangeData>

	suspend fun getExchangeDataByIds(exchangeDataIds: ListOfIds): HttpResponse<List<ExchangeData>>

	suspend fun getExchangeDataByParticipant(
		dataOwnerId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataByParticipantQuery(
		dataOwnerId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataByDelegatorDelegate(
		delegatorId: String,
		delegateId: String,
	): HttpResponse<List<ExchangeData>>

	suspend fun getExchangeDataByDelegatorDelegateQuery(
		delegatorId: String,
		delegateId: String,
	): HttpResponse<List<ExchangeData>>

	suspend fun getParticipantCounterparts(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String? = null,
	): HttpResponse<List<String>>

	suspend fun getParticipantCounterpartsQuery(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String? = null,
	): HttpResponse<List<String>>
	// endregion

	// region cloud endpoints

	suspend fun createExchangeData(
		exchangeData: ExchangeData,
		groupId: String,
	): HttpResponse<ExchangeData>

	suspend fun modifyExchangeData(
		exchangeData: ExchangeData,
		groupId: String,
	): HttpResponse<ExchangeData>

	suspend fun getExchangeDataById(
		exchangeDataId: String,
		groupId: String,
	): HttpResponse<ExchangeData>

	suspend fun getExchangeDataByIds(
		exchangeDataIds: ListOfIds,
		groupId: String,
	): HttpResponse<List<ExchangeData>>

	suspend fun getExchangeDataByParticipant(
		dataOwnerId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataByDelegatorDelegate(
		delegatorId: String,
		delegateId: String,
		groupId: String,
	): HttpResponse<List<ExchangeData>>
	// endregion
}
