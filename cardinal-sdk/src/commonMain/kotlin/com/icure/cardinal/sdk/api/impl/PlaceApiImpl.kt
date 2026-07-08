package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.api.PlaceInGroupApi
import com.icure.cardinal.sdk.api.raw.RawPlaceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractPlaceApi(
	protected val rawApi: RawPlaceApi,
) {

	protected suspend fun doCreatePlace(groupId: String?, entity: Place): Place {
		requireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createPlace(placeDto = entity)
		} else {
			rawApi.createPlaceInGroup(groupId = groupId, place = entity)
		}.successBody()
	}

	protected suspend fun doCreatePlaces(groupId: String?, entities: List<Place>): List<Place> =
		skipRequestOnEmptyList(entities) { places ->
			if (groupId == null) {
				rawApi.createPlaces(placeDtos = places)
			} else {
				rawApi.createPlacesInGroup(groupId = groupId, placeBatch = places)
			}.successBody()
		}

	protected suspend fun doGetPlace(groupId: String?, entityId: String): Place? =
		if (groupId == null) {
			rawApi.getPlace(placeId = entityId)
		} else {
			rawApi.getPlaceInGroup(groupId = groupId, placeId = entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetPlaces(groupId: String?, entityIds: List<String>): List<Place> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getPlacesByIds(placeIds = ListOfIds(ids))
			} else {
				rawApi.getPlacesInGroup(groupId = groupId, placeIds = ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyPlace(groupId: String?, entity: Place): Place {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.modifyPlace(placeDto = entity)
		} else {
			rawApi.modifyPlaceInGroup(groupId = groupId, place = entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyPlaces(groupId: String?, entities: List<Place>): List<Place> =
		skipRequestOnEmptyList(entities) { places ->
			if (groupId == null) {
				rawApi.modifyPlaces(placeDtos = places)
			} else {
				rawApi.modifyPlacesInGroup(groupId = groupId, placeBatch = places)
			}.successBody()
		}

	protected suspend fun doDeletePlace(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deletePlace(placeId = entityId, rev = rev)
		} else {
			rawApi.deletePlaceInGroup(groupId = groupId, placeId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeletePlaces(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deletePlacesWithRev(placeIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.deletePlacesInGroup(groupId = groupId, placeIds = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeletePlace(groupId: String?, entityId: String, rev: String): Place =
		if (groupId == null) {
			rawApi.undeletePlace(placeId = entityId, rev = rev)
		} else {
			rawApi.undeletePlaceInGroup(groupId = groupId, placeId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeletePlaces(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<Place> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeletePlaces(placeIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.undeletePlacesInGroup(groupId = groupId, placeIds = ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgePlace(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgePlace(placeId = entityId, rev = rev)
		} else {
			rawApi.purgePlaceInGroup(groupId = groupId, placeId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgePlaces(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgePlaces(placeIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.purgePlacesInGroup(groupId = groupId, placeIds = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}
}

@InternalIcureApi
internal class PlaceApiImpl(
	rawApi: RawPlaceApi,
): PlaceApi, AbstractPlaceApi(rawApi) {

	override val inGroup: PlaceInGroupApi = PlaceInGroupApiImpl(rawApi)

	override suspend fun createPlace(place: Place): Place =
		doCreatePlace(groupId = null, place)

	override suspend fun createPlaces(places: List<Place>): List<Place> {
		requireIsValidForCreation(places)
		return doCreatePlaces(groupId = null, places)
	}

	override suspend fun getPlace(placeId: String): Place? =
		doGetPlace(groupId = null, placeId)

	override suspend fun getPlaces(placesIds: List<String>): List<Place> =
		doGetPlaces(groupId = null, placesIds)

	override suspend fun modifyPlace(place: Place): Place =
		doModifyPlace(groupId = null, place)

	override suspend fun modifyPlaces(places: List<Place>): List<Place> {
		requireIsValidForModification(places)
		return doModifyPlaces(groupId = null, places)
	}

	override suspend fun deletePlaceById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeletePlace(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deletePlaceByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeletePlaces(groupId = null, entityIds = entityIds)

	override suspend fun undeletePlaceById(entityId: String, rev: String): Place =
		doUndeletePlace(groupId = null, entityId = entityId, rev = rev)

	override suspend fun undeletePlaceByIds(entityIds: List<StoredDocumentIdentifier>): List<Place> =
		doUndeletePlaces(groupId = null, entityIds = entityIds)

	override suspend fun purgePlaceById(entityId: String, rev: String) {
		doPurgePlace(groupId = null, entityId = entityId, rev = rev)
	}

	override suspend fun purgePlaceByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgePlaces(groupId = null, entityIds)

}

@OptIn(InternalIcureApi::class)
internal class PlaceInGroupApiImpl(
	rawApi: RawPlaceApi
) : PlaceInGroupApi, AbstractPlaceApi(rawApi) {

	override suspend fun createPlace(place: GroupScoped<Place>): GroupScoped<Place> =
		groupScopedWith(place) { groupId, entity -> doCreatePlace(groupId, entity) }

	override suspend fun createPlaces(places: List<GroupScoped<Place>>): List<GroupScoped<Place>> {
		requireIsValidForCreationInGroup(places)
		return places.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreatePlaces(groupId, chunk)
		}
	}

	override suspend fun getPlace(groupId: String, placeId: String): GroupScoped<Place>? =
		groupScopedIn(groupId) { doGetPlace(groupId = groupId, entityId = placeId) }

	override suspend fun getPlaces(groupId: String, placesIds: List<String>): List<GroupScoped<Place>> =
		groupScopedListIn(groupId) { doGetPlaces(groupId = groupId, placesIds) }

	override suspend fun modifyPlace(place: GroupScoped<Place>): GroupScoped<Place> =
		groupScopedWith(place) { groupId, entity -> doModifyPlace(groupId, entity) }

	override suspend fun modifyPlaces(places: List<GroupScoped<Place>>): List<GroupScoped<Place>> {
		requireIsValidForModificationInGroup(places)
		return places.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyPlaces(groupId, chunk)
		}
	}

	override suspend fun deletePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, entity -> doDeletePlace(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun deletePlaceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doDeletePlaces(groupId = groupId, entityIds = chunk)
		}

	override suspend fun undeletePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Place> =
		groupScopedWith(entityId) { groupId, entity -> doUndeletePlace(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun undeletePlaceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Place>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeletePlaces(groupId = groupId, entityIds = chunk)
		}

	override suspend fun purgePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgePlace(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgePlaceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doPurgePlaces(groupId = groupId, entityIds = chunk)
		}

}
