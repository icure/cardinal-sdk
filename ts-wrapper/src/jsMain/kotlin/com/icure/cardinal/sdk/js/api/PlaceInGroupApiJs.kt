// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PlaceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PlaceInGroupApi")
public external interface PlaceInGroupApiJs {
	public fun createPlace(place: GroupScopedJs<PlaceJs>): Promise<GroupScopedJs<PlaceJs>>

	public fun createPlaces(places: Array<GroupScopedJs<PlaceJs>>):
			Promise<Array<GroupScopedJs<PlaceJs>>>

	public fun getPlace(groupId: String, placeId: String): Promise<GroupScopedJs<PlaceJs>?>

	public fun getPlaces(groupId: String, placesIds: Array<String>):
			Promise<Array<GroupScopedJs<PlaceJs>>>

	public fun modifyPlace(place: GroupScopedJs<PlaceJs>): Promise<GroupScopedJs<PlaceJs>>

	public fun modifyPlaces(places: Array<GroupScopedJs<PlaceJs>>):
			Promise<Array<GroupScopedJs<PlaceJs>>>

	public fun deletePlaceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deletePlaceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deletePlace(place: GroupScopedJs<PlaceJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deletePlaces(places: Array<GroupScopedJs<PlaceJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun undeletePlaceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<PlaceJs>>

	public fun undeletePlaceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<PlaceJs>>>

	public fun undeletePlace(place: GroupScopedJs<PlaceJs>): Promise<GroupScopedJs<PlaceJs>>

	public fun undeletePlaces(places: Array<GroupScopedJs<PlaceJs>>):
			Promise<Array<GroupScopedJs<PlaceJs>>>

	public fun purgePlaceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgePlaceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgePlace(place: GroupScopedJs<PlaceJs>): Promise<Unit>

	public fun purgePlaces(places: Array<GroupScopedJs<PlaceJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>
}
