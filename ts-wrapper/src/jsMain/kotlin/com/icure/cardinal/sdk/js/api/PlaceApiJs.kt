// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.PlaceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PlaceApi")
public external interface PlaceApiJs {
	public val inGroup: PlaceInGroupApiJs

	public fun createPlace(place: PlaceJs): Promise<PlaceJs>

	public fun createPlaces(places: Array<PlaceJs>): Promise<Array<PlaceJs>>

	public fun getPlace(placeId: String): Promise<PlaceJs?>

	public fun getPlaces(placesIds: Array<String>): Promise<Array<PlaceJs>>

	public fun modifyPlace(place: PlaceJs): Promise<PlaceJs>

	public fun modifyPlaces(places: Array<PlaceJs>): Promise<Array<PlaceJs>>

	public fun deletePlaceById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deletePlaceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deletePlace(place: PlaceJs): Promise<StoredDocumentIdentifierJs>

	public fun deletePlaces(places: Array<PlaceJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeletePlaceById(entityId: String, rev: String): Promise<PlaceJs>

	public fun undeletePlaceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<PlaceJs>>

	public fun undeletePlace(place: PlaceJs): Promise<PlaceJs>

	public fun undeletePlaces(places: Array<PlaceJs>): Promise<Array<PlaceJs>>

	public fun purgePlaceById(entityId: String, rev: String): Promise<Unit>

	public fun purgePlaceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgePlace(place: PlaceJs): Promise<Unit>

	public fun purgePlaces(places: Array<PlaceJs>): Promise<Array<StoredDocumentIdentifierJs>>
}
