package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawExchangeDataMapApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.ExchangeDataMap
import com.icure.cardinal.sdk.model.ExchangeDataMapCreationBatch
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawExchangeDataMapApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig),
	RawExchangeDataMapApi {
	// region common endpoints

	override suspend fun createOrUpdateExchangeDataMapBatch(batch: ExchangeDataMapCreationBatch): HttpResponse<String> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedatamap", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(batch)
		}.wrap()

	override suspend fun getExchangeDataMapBatch(ids: ListOfIds): HttpResponse<List<ExchangeDataMap>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedatamap", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createOrUpdateExchangeDataMapBatch(
		batch: ExchangeDataMapCreationBatch,
		groupId: String,
	): HttpResponse<String> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedatamap", "batch", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(batch)
		}.wrap()

	override suspend fun getExchangeDataMapBatch(
		ids: ListOfIds,
		groupId: String,
	): HttpResponse<List<ExchangeDataMap>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedatamap", "batch", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	// endregion
}
