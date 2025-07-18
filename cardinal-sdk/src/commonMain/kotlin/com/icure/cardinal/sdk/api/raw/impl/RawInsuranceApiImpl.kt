package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawInsuranceApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
class RawInsuranceApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawInsuranceApi {
	// region common endpoints

	override suspend fun getAllInsurances(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Insurance>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createInsurance(insuranceDto: Insurance): HttpResponse<Insurance> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(insuranceDto)
		}.wrap()

	override suspend fun deleteInsurance(insuranceId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance", insuranceId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getInsurance(insuranceId: String): HttpResponse<Insurance> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance", insuranceId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getInsurances(insuranceIds: ListOfIds): HttpResponse<List<Insurance>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(insuranceIds)
		}.wrap()

	override suspend fun listInsurancesByCode(insuranceCode: String): HttpResponse<List<Insurance>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance", "byCode", insuranceCode)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listInsurancesByName(insuranceName: String): HttpResponse<List<Insurance>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance", "byName", insuranceName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyInsurance(insuranceDto: Insurance): HttpResponse<Insurance> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(insuranceDto)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createInsurancesInGroup(
		groupId: String,
		insuranceBatch: List<Insurance>,
	): HttpResponse<List<Insurance>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(insuranceBatch)
		}.wrap()

	override suspend fun getInsurancesInGroup(
		groupId: String,
		insuranceIds: String,
	): HttpResponse<List<Insurance>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance", "inGroup", groupId, "byIds", insuranceIds)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyInsurancesInGroup(
		groupId: String,
		insuranceBatch: List<Insurance>,
	): HttpResponse<List<Insurance>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "insurance", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(insuranceBatch)
		}.wrap()

	// endregion
}
