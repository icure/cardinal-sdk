package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawPlaceApi {
	// region common endpoints

	suspend fun createPlace(placeDto: Place): HttpResponse<Place>

	suspend fun createPlaces(placeDtos: List<Place>): HttpResponse<List<Place>>

	suspend fun deletePlace(
		placeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deletePlaces(placeIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deletePlacesWithRev(placeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun undeletePlace(
		placeId: String,
		rev: String,
	): HttpResponse<Place>

	suspend fun undeletePlaces(placeIds: ListOfIdsAndRev): HttpResponse<List<Place>>

	suspend fun purgePlace(
		placeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgePlaces(placeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun getPlace(placeId: String): HttpResponse<Place>

	suspend fun getPlacesByIds(placeIds: ListOfIds): HttpResponse<List<Place>>

	suspend fun getPlaces(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Place>>

	suspend fun modifyPlace(placeDto: Place): HttpResponse<Place>

	suspend fun modifyPlaces(placeDtos: List<Place>): HttpResponse<List<Place>>
	// endregion

	// region cloud endpoints

	suspend fun createPlaceInGroup(
		groupId: String,
		place: Place,
	): HttpResponse<Place>

	suspend fun createPlacesInGroup(
		groupId: String,
		placeBatch: List<Place>,
	): HttpResponse<List<Place>>

	suspend fun getPlaceInGroup(
		groupId: String,
		placeId: String,
	): HttpResponse<Place>

	suspend fun getPlacesInGroup(
		groupId: String,
		placeIds: ListOfIds,
	): HttpResponse<List<Place>>

	suspend fun modifyPlaceInGroup(
		groupId: String,
		place: Place,
	): HttpResponse<Place>

	suspend fun modifyPlacesInGroup(
		groupId: String,
		placeBatch: List<Place>,
	): HttpResponse<List<Place>>

	suspend fun deletePlaceInGroup(
		groupId: String,
		placeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deletePlacesInGroup(
		groupId: String,
		placeIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeletePlaceInGroup(
		groupId: String,
		placeId: String,
		rev: String,
	): HttpResponse<Place>

	suspend fun undeletePlacesInGroup(
		groupId: String,
		placeIds: ListOfIdsAndRev,
	): HttpResponse<List<Place>>

	suspend fun purgePlaceInGroup(
		groupId: String,
		placeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgePlacesInGroup(
		groupId: String,
		placeIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>
	// endregion
}
