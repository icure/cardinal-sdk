package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawPlaceApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Place
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
class RawPlaceApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawPlaceApi {
	// region common endpoints

	override suspend fun createPlace(placeDto: Place): HttpResponse<Place> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeDto)
		}.wrap()

	override suspend fun createPlaces(placeDtos: List<Place>): HttpResponse<List<Place>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeDtos)
		}.wrap()

	override suspend fun deletePlace(
		placeId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", placeId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deletePlaces(placeIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun deletePlacesWithRev(placeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun undeletePlace(
		placeId: String,
		rev: String,
	): HttpResponse<Place> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "undelete", placeId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeletePlaces(placeIds: ListOfIdsAndRev): HttpResponse<List<Place>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun purgePlace(
		placeId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "purge", placeId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgePlaces(placeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun getPlace(placeId: String): HttpResponse<Place> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", placeId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getPlacesByIds(placeIds: ListOfIds): HttpResponse<List<Place>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun getPlaces(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Place>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyPlace(placeDto: Place): HttpResponse<Place> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeDto)
		}.wrap()

	override suspend fun modifyPlaces(placeDtos: List<Place>): HttpResponse<List<Place>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeDtos)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createPlaceInGroup(
		groupId: String,
		place: Place,
	): HttpResponse<Place> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(place)
		}.wrap()

	override suspend fun createPlacesInGroup(
		groupId: String,
		placeBatch: List<Place>,
	): HttpResponse<List<Place>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeBatch)
		}.wrap()

	override suspend fun getPlaceInGroup(
		groupId: String,
		placeId: String,
	): HttpResponse<Place> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, placeId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getPlacesInGroup(
		groupId: String,
		placeIds: ListOfIds,
	): HttpResponse<List<Place>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun modifyPlaceInGroup(
		groupId: String,
		place: Place,
	): HttpResponse<Place> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(place)
		}.wrap()

	override suspend fun modifyPlacesInGroup(
		groupId: String,
		placeBatch: List<Place>,
	): HttpResponse<List<Place>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeBatch)
		}.wrap()

	override suspend fun deletePlaceInGroup(
		groupId: String,
		placeId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, placeId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deletePlacesInGroup(
		groupId: String,
		placeIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun undeletePlaceInGroup(
		groupId: String,
		placeId: String,
		rev: String,
	): HttpResponse<Place> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, "undelete", placeId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeletePlacesInGroup(
		groupId: String,
		placeIds: ListOfIdsAndRev,
	): HttpResponse<List<Place>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun purgePlaceInGroup(
		groupId: String,
		placeId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, "purge", placeId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgePlacesInGroup(
		groupId: String,
		placeIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(placeIds)
		}.wrap()

	// endregion
}
