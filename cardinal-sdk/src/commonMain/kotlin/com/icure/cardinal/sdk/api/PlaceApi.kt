package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionRequest
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionResult
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionStrategy
import com.icure.cardinal.sdk.model.conflicts.MergeResult
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue

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

	/**
	 * Get the ids of all the places that have conflicting revisions.
	 * Requires the permission to manually resolve conflicts.
	 * @return the ids of the places with conflicts.
	 */
	suspend fun getConflictingEntitiesIds(): List<String>

	/**
	 * Get the conflicting revisions of a place.
	 * Requires read access to all the conflicting revisions of the place.
	 * If the place has too many conflicts, only part of them are returned.
	 * @param entityId the id of a place with conflicts, for example obtained through [getConflictingEntitiesIds].
	 * @return the conflicting revisions of the place.
	 */
	suspend fun getConflictsForEntity(entityId: String): List<Place>

	/**
	 * Resolves the conflicts of a place by declaring the version that should be kept and the conflicting revisions that
	 * should be purged.
	 * Requires the permission to manually resolve conflicts and write access to all the conflicting revisions of the place.
	 * @param request the place to keep and the conflicting revisions to purge.
	 * @return the updated place and the revisions that are still in conflict.
	 */
	suspend fun declareConflictWinner(request: ConflictResolutionRequest<Place>): ConflictResolutionResult<Place>

	/**
	 * Automatically resolves the conflicts of the places with the provided ids.
	 * Requires the permission to automatically resolve conflicts.
	 * @param entityIds ids of places with conflicts, for example obtained through [getConflictingEntitiesIds].
	 * @param strategy the strategy to use to resolve the conflicts. If null the backend uses its default strategy.
	 * @return the outcome of the conflict resolution for each place.
	 */
	suspend fun autoSolveConflicts(
		entityIds: List<String>,
		@DefaultValue("null")
		strategy: ConflictResolutionStrategy? = null,
	): List<MergeResult>
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

	/**
	 * In-group version of [PlaceApi.getConflictingEntitiesIds].
	 */
	suspend fun getConflictingEntitiesIds(groupId: String): List<String>

	/**
	 * In-group version of [PlaceApi.getConflictsForEntity].
	 */
	suspend fun getConflictsForEntity(groupId: String, entityId: String): List<GroupScoped<Place>>

	/**
	 * In-group version of [PlaceApi.declareConflictWinner].
	 */
	suspend fun declareConflictWinner(groupId: String, request: ConflictResolutionRequest<Place>): ConflictResolutionResult<Place>

	/**
	 * In-group version of [PlaceApi.autoSolveConflicts].
	 */
	suspend fun autoSolveConflicts(
		groupId: String,
		entityIds: List<String>,
		@DefaultValue("null")
		strategy: ConflictResolutionStrategy? = null,
	): List<MergeResult>
}

