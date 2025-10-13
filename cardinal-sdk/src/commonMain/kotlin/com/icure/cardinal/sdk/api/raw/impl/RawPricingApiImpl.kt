package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawPricingApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.TarificationAbstractFilterSerializer
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
class RawPricingApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawPricingApi {
	// region cloud endpoints

	override suspend fun createCodesInGroup(
		groupId: String,
		pricingBatch: List<Tarification>,
	): HttpResponse<List<Tarification>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(pricingBatch)
		}.wrap()

	override suspend fun getPricingItems(
		groupId: String,
		pricingIds: ListOfIds,
	): HttpResponse<List<Tarification>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(pricingIds)
		}.wrap()

	override suspend fun modifyPricingInGroup(
		groupId: String,
		pricingBatch: List<Tarification>,
	): HttpResponse<List<Tarification>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(pricingBatch)
		}.wrap()

	override suspend fun matchPricingBy(
		groupId: String,
		filter: AbstractFilter<Tarification>,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(TarificationAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}
