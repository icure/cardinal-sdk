package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier

interface PlaceApi {

	val inGroup: PlaceInGroupApi

	suspend fun createPlace(place: Place): Place
	suspend fun createPlaces(places: List<Place>): List<Place>

	suspend fun getPlace(placeId: String): Place?
	suspend fun getPlaces(placesIds: List<String>): List<Place>

	suspend fun modifyPlace(place: Place): Place
	suspend fun modifyPlaces(places: List<Place>): List<Place>

	suspend fun deletePlaceById(entityId: String, rev: String): StoredDocumentIdentifier
	suspend fun deletePlaceByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun deletePlace(place: Place): StoredDocumentIdentifier =
		deletePlaceById(entityId = place.id, rev = requireNotNull(place.rev) { "Can't delete a place that has no rev" })
	suspend fun deletePlaces(places: List<Place>): List<StoredDocumentIdentifier> =
		deletePlaceByIds(places.map { it.toStoredDocumentIdentifier() })

	suspend fun undeletePlaceById(entityId: String, rev: String): Place
	suspend fun undeletePlaceByIds(entityIds: List<StoredDocumentIdentifier>): List<Place>

	suspend fun undeletePlace(place: Place): Place =
		undeletePlaceById(entityId = place.id, rev = requireNotNull(place.rev) { "Can't undelete a place that has no rev" })
	suspend fun undeletePlaces(places: List<Place>): List<Place> =
		undeletePlaceByIds(places.map { it.toStoredDocumentIdentifier() })

	suspend fun purgePlaceById(entityId: String, rev: String)
	suspend fun purgePlaceByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun purgePlace(place: Place) {
		purgePlaceById(entityId = place.id, rev = requireNotNull(place.rev) { "Can't purge a place that has no rev" })
	}
	suspend fun purgePlaces(places: List<Place>): List<StoredDocumentIdentifier> =
		purgePlaceByIds(places.map { it.toStoredDocumentIdentifier() })

}

interface PlaceInGroupApi {

	suspend fun createPlace(place: GroupScoped<Place>): GroupScoped<Place>
	suspend fun createPlaces(places: List<GroupScoped<Place>>): List<GroupScoped<Place>>

	suspend fun getPlace(groupId: String, placeId: String): GroupScoped<Place>?
	suspend fun getPlaces(groupId: String, placesIds: List<String>): List<GroupScoped<Place>>

	suspend fun modifyPlace(place: GroupScoped<Place>): GroupScoped<Place>
	suspend fun modifyPlaces(places: List<GroupScoped<Place>>): List<GroupScoped<Place>>

	suspend fun deletePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>
	suspend fun deletePlaceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deletePlace(place: GroupScoped<Place>): GroupScoped<StoredDocumentIdentifier> =
		deletePlaceById(place.toStoredDocumentIdentifier())
	suspend fun deletePlaces(places: List<GroupScoped<Place>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deletePlaceByIds(places.map { it.toStoredDocumentIdentifier() })

	suspend fun undeletePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Place>
	suspend fun undeletePlaceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Place>>

	suspend fun undeletePlace(place: GroupScoped<Place>): GroupScoped<Place> =
		undeletePlaceById(place.toStoredDocumentIdentifier())
	suspend fun undeletePlaces(places: List<GroupScoped<Place>>): List<GroupScoped<Place>> =
		undeletePlaceByIds(places.map { it.toStoredDocumentIdentifier() })

	suspend fun purgePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>)
	suspend fun purgePlaceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun purgePlace(place: GroupScoped<Place>) {
		purgePlaceById(place.toStoredDocumentIdentifier())
	}
	suspend fun purgePlaces(places: List<GroupScoped<Place>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgePlaceByIds(places.map { it.toStoredDocumentIdentifier() })

}

