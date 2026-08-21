package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.requests.ExchangeDataPieceCreationRequest
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

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

	suspend fun createExchangeDataGroupPieces(
		exchangeDataGroupId: String,
		delegator: String,
		`delegate`: String,
		piecesByRecipient: Map<String, ExchangeDataPieceCreationRequest>,
	): HttpResponse<List<ExchangeData>>

	suspend fun getExchangeDataGroupById(
		exchangeDataGroupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataGroupByIdForRecipients(
		exchangeDataGroupId: String,
		recipients: String,
		startDocumentId: String? = null,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataByParticipantForRecipients(
		dataOwnerId: String,
		recipients: String,
		startDocumentId: String? = null,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataByDelegatorDelegateForRecipients(
		delegatorId: String,
		delegateId: String,
		recipients: String,
		startDocumentId: String? = null,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun findNonGroupPieceCounterparts(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String? = null,
		startKey: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<String>>
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

	suspend fun createExchangeDataGroupPieces(
		exchangeDataGroupId: String,
		delegator: String,
		`delegate`: String,
		piecesByRecipient: Map<String, ExchangeDataPieceCreationRequest>,
		groupId: String,
	): HttpResponse<List<ExchangeData>>

	suspend fun getExchangeDataGroupById(
		exchangeDataGroupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataGroupByIdForRecipients(
		exchangeDataGroupId: String,
		recipients: String,
		startDocumentId: String? = null,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataByParticipantForRecipients(
		dataOwnerId: String,
		recipients: String,
		startDocumentId: String? = null,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataByDelegatorDelegateForRecipients(
		delegatorId: String,
		delegateId: String,
		recipients: String,
		startDocumentId: String? = null,
		groupId: String,
	): HttpResponse<PaginatedList<ExchangeData>>
	// endregion
}
