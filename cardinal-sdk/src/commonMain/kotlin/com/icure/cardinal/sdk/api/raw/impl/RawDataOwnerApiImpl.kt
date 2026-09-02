package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawDataOwnerApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawDataOwnerApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawDataOwnerApi {
	// region common endpoints

	override suspend fun getDataOwner(dataOwnerId: String): HttpResponse<DataOwnerWithType> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", dataOwnerId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getDataOwners(dataOwnerIds: ListOfIds): HttpResponse<List<DataOwnerWithType>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(dataOwnerIds)
		}.wrap()

	override suspend fun getDataOwnerStub(dataOwnerId: String): HttpResponse<CryptoActorStubWithType> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "stub", dataOwnerId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getDataOwnerStubs(dataOwnerIds: ListOfIds): HttpResponse<List<CryptoActorStubWithType>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "stub", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(dataOwnerIds)
		}.wrap()

	override suspend fun modifyDataOwnerStub(updated: CryptoActorStubWithType): HttpResponse<CryptoActorStubWithType> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "stub")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(updated)
		}.wrap()

	override suspend fun getCurrentDataOwner(): HttpResponse<DataOwnerWithType> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "current")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCurrentDataOwnerStub(): HttpResponse<CryptoActorStubWithType> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "current", "stub")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCurrentDataOwnerHierarchy(): HttpResponse<List<DataOwnerWithType>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "current", "hierarchy")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCurrentDataOwnerHierarchyStub(): HttpResponse<List<CryptoActorStubWithType>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "current", "hierarchy", "stub")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getCryptoActorStubInGroup(
		groupId: String,
		dataOwnerId: String,
	): HttpResponse<CryptoActorStubWithType> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "inGroup", groupId, dataOwnerId, "stub")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
