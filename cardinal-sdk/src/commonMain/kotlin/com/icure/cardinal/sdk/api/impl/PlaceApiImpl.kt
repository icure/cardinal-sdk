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
		basicRequireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createPlace(entity)
		} else {
			rawApi.createPlaceInGroup(groupId, entity)
		}.successBody()
	}

	protected suspend fun doCreatePlaces(groupId: String?, entities: List<Place>): List<Place> =
		skipRequestOnEmptyList(entities) { places ->
			if (groupId == null) {
				rawApi.createPlaces(places)
			} else {
				rawApi.createPlacesInGroup(groupId, places)
			}.successBody()
		}

	protected suspend fun doGetPlace(groupId: String?, entityId: String): Place? =
		if (groupId == null) {
			rawApi.getPlace(entityId)
		} else {
			rawApi.getPlaceInGroup(groupId, entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetPlaces(groupId: String?, entityIds: List<String>): List<Place> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getPlacesByIds(ListOfIds(ids))
			} else {
				rawApi.getPlacesInGroup(groupId, ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyPlace(groupId: String?, entity: Place): Place {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.modifyPlace(entity)
		} else {
			rawApi.modifyPlaceInGroup(groupId, entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyPlaces(groupId: String?, entities: List<Place>): List<Place> =
		skipRequestOnEmptyList(entities) { places ->
			if (groupId == null) {
				rawApi.modifyPlaces(places)
			} else {
				rawApi.modifyPlacesInGroup(groupId, places)
			}.successBody()
		}

	protected suspend fun doDeletePlace(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deletePlace(entityId, rev)
		} else {
			rawApi.deletePlaceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeletePlaces(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deletePlacesWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deletePlacesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeletePlace(groupId: String?, entityId: String, rev: String): Place =
		if (groupId == null) {
			rawApi.undeletePlace(entityId, rev)
		} else {
			rawApi.undeletePlaceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeletePlaces(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<Place> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeletePlaces(ListOfIdsAndRev(ids))
			} else {
				rawApi.undeletePlacesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgePlace(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgePlace(entityId, rev)
		} else {
			rawApi.purgePlaceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgePlaces(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgePlaces(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgePlacesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
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
		basicRequireIsValidForCreation(places)
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
		basicRequireIsValidForCreationInGroup(places)
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
