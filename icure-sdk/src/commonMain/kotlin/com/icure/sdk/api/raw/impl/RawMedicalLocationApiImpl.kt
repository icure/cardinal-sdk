package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawMedicalLocationApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MedicalLocation
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.serialization.MedicalLocationAbstractFilterSerializer
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawMedicalLocationApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawMedicalLocationApi {
	// region common endpoints

	override suspend fun createMedicalLocation(medicalLocationDto: MedicalLocation): HttpResponse<MedicalLocation> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "medicallocation")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(medicalLocationDto)
		}.wrap()

	override suspend fun deleteMedicalLocations(locationIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "medicallocation", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(locationIds)
		}.wrap()

	override suspend fun getMedicalLocation(locationId: String): HttpResponse<MedicalLocation> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "medicallocation", locationId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getMedicalLocations(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<MedicalLocation>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "medicallocation")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyMedicalLocation(medicalLocationDto: MedicalLocation): HttpResponse<MedicalLocation> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "medicallocation")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(medicalLocationDto)
		}.wrap()

	override suspend fun getMedicalLocationsByIds(accessLogIds: ListOfIds): HttpResponse<List<MedicalLocation>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "medicallocation", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogIds)
		}.wrap()

	override suspend fun matchMedicalLocationsBy(filter: AbstractFilter<MedicalLocation>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "medicallocation", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(MedicalLocationAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}
