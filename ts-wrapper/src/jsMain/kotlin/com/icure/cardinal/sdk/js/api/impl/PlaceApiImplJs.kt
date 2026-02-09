// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.js.api.PlaceApiJs
import com.icure.cardinal.sdk.js.api.PlaceInGroupApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PlaceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.place_fromJs
import com.icure.cardinal.sdk.js.model.place_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PlaceApiImplJs(
	private val placeApi: PlaceApi,
) : PlaceApiJs {
	override val inGroup: PlaceInGroupApiJs = object : PlaceInGroupApiJs {
		override fun createPlace(place: GroupScopedJs<PlaceJs>): Promise<GroupScopedJs<PlaceJs>> =
				GlobalScope.promise {
			val placeConverted: GroupScoped<Place> = groupScoped_fromJs(
				place,
				{ x1: PlaceJs ->
					place_fromJs(x1)
				},
			)
			val result = placeApi.inGroup.createPlace(
				placeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Place ->
					place_toJs(x1)
				},
			)
		}

		override fun createPlaces(places: Array<GroupScopedJs<PlaceJs>>):
				Promise<Array<GroupScopedJs<PlaceJs>>> = GlobalScope.promise {
			val placesConverted: List<GroupScoped<Place>> = arrayToList(
				places,
				"places",
				{ x1: GroupScopedJs<PlaceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: PlaceJs ->
							place_fromJs(x2)
						},
					)
				},
			)
			val result = placeApi.inGroup.createPlaces(
				placesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Place> ->
					groupScoped_toJs(
						x1,
						{ x2: Place ->
							place_toJs(x2)
						},
					)
				},
			)
		}

		override fun getPlace(groupId: String, placeId: String): Promise<GroupScopedJs<PlaceJs>?> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val placeIdConverted: String = placeId
			val result = placeApi.inGroup.getPlace(
				groupIdConverted,
				placeIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: Place ->
							place_toJs(x1)
						},
					)
				}
			)
		}

		override fun getPlaces(groupId: String, placesIds: Array<String>):
				Promise<Array<GroupScopedJs<PlaceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val placesIdsConverted: List<String> = arrayToList(
				placesIds,
				"placesIds",
				{ x1: String ->
					x1
				},
			)
			val result = placeApi.inGroup.getPlaces(
				groupIdConverted,
				placesIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Place> ->
					groupScoped_toJs(
						x1,
						{ x2: Place ->
							place_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyPlace(place: GroupScopedJs<PlaceJs>): Promise<GroupScopedJs<PlaceJs>> =
				GlobalScope.promise {
			val placeConverted: GroupScoped<Place> = groupScoped_fromJs(
				place,
				{ x1: PlaceJs ->
					place_fromJs(x1)
				},
			)
			val result = placeApi.inGroup.modifyPlace(
				placeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Place ->
					place_toJs(x1)
				},
			)
		}

		override fun modifyPlaces(places: Array<GroupScopedJs<PlaceJs>>):
				Promise<Array<GroupScopedJs<PlaceJs>>> = GlobalScope.promise {
			val placesConverted: List<GroupScoped<Place>> = arrayToList(
				places,
				"places",
				{ x1: GroupScopedJs<PlaceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: PlaceJs ->
							place_fromJs(x2)
						},
					)
				},
			)
			val result = placeApi.inGroup.modifyPlaces(
				placesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Place> ->
					groupScoped_toJs(
						x1,
						{ x2: Place ->
							place_toJs(x2)
						},
					)
				},
			)
		}

		override fun deletePlaceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = placeApi.inGroup.deletePlaceById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deletePlaceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = placeApi.inGroup.deletePlaceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deletePlace(place: GroupScopedJs<PlaceJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val placeConverted: GroupScoped<Place> = groupScoped_fromJs(
				place,
				{ x1: PlaceJs ->
					place_fromJs(x1)
				},
			)
			val result = placeApi.inGroup.deletePlace(
				placeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deletePlaces(places: Array<GroupScopedJs<PlaceJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val placesConverted: List<GroupScoped<Place>> = arrayToList(
				places,
				"places",
				{ x1: GroupScopedJs<PlaceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: PlaceJs ->
							place_fromJs(x2)
						},
					)
				},
			)
			val result = placeApi.inGroup.deletePlaces(
				placesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeletePlaceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<PlaceJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = placeApi.inGroup.undeletePlaceById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Place ->
					place_toJs(x1)
				},
			)
		}

		override fun undeletePlaceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<PlaceJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = placeApi.inGroup.undeletePlaceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Place> ->
					groupScoped_toJs(
						x1,
						{ x2: Place ->
							place_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeletePlace(place: GroupScopedJs<PlaceJs>): Promise<GroupScopedJs<PlaceJs>> =
				GlobalScope.promise {
			val placeConverted: GroupScoped<Place> = groupScoped_fromJs(
				place,
				{ x1: PlaceJs ->
					place_fromJs(x1)
				},
			)
			val result = placeApi.inGroup.undeletePlace(
				placeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Place ->
					place_toJs(x1)
				},
			)
		}

		override fun undeletePlaces(places: Array<GroupScopedJs<PlaceJs>>):
				Promise<Array<GroupScopedJs<PlaceJs>>> = GlobalScope.promise {
			val placesConverted: List<GroupScoped<Place>> = arrayToList(
				places,
				"places",
				{ x1: GroupScopedJs<PlaceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: PlaceJs ->
							place_fromJs(x2)
						},
					)
				},
			)
			val result = placeApi.inGroup.undeletePlaces(
				placesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Place> ->
					groupScoped_toJs(
						x1,
						{ x2: Place ->
							place_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgePlaceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit> =
				GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			placeApi.inGroup.purgePlaceById(
				entityIdConverted,
			)

		}

		override fun purgePlaceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = placeApi.inGroup.purgePlaceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgePlace(place: GroupScopedJs<PlaceJs>): Promise<Unit> = GlobalScope.promise {
			val placeConverted: GroupScoped<Place> = groupScoped_fromJs(
				place,
				{ x1: PlaceJs ->
					place_fromJs(x1)
				},
			)
			placeApi.inGroup.purgePlace(
				placeConverted,
			)

		}

		override fun purgePlaces(places: Array<GroupScopedJs<PlaceJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val placesConverted: List<GroupScoped<Place>> = arrayToList(
				places,
				"places",
				{ x1: GroupScopedJs<PlaceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: PlaceJs ->
							place_fromJs(x2)
						},
					)
				},
			)
			val result = placeApi.inGroup.purgePlaces(
				placesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun createPlace(place: PlaceJs): Promise<PlaceJs> = GlobalScope.promise {
		val placeConverted: Place = place_fromJs(place)
		val result = placeApi.createPlace(
			placeConverted,
		)
		place_toJs(result)
	}

	override fun createPlaces(places: Array<PlaceJs>): Promise<Array<PlaceJs>> = GlobalScope.promise {
		val placesConverted: List<Place> = arrayToList(
			places,
			"places",
			{ x1: PlaceJs ->
				place_fromJs(x1)
			},
		)
		val result = placeApi.createPlaces(
			placesConverted,
		)
		listToArray(
			result,
			{ x1: Place ->
				place_toJs(x1)
			},
		)
	}

	override fun getPlace(placeId: String): Promise<PlaceJs?> = GlobalScope.promise {
		val placeIdConverted: String = placeId
		val result = placeApi.getPlace(
			placeIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				place_toJs(nonNull1)
			}
		)
	}

	override fun getPlaces(placesIds: Array<String>): Promise<Array<PlaceJs>> = GlobalScope.promise {
		val placesIdsConverted: List<String> = arrayToList(
			placesIds,
			"placesIds",
			{ x1: String ->
				x1
			},
		)
		val result = placeApi.getPlaces(
			placesIdsConverted,
		)
		listToArray(
			result,
			{ x1: Place ->
				place_toJs(x1)
			},
		)
	}

	override fun modifyPlace(place: PlaceJs): Promise<PlaceJs> = GlobalScope.promise {
		val placeConverted: Place = place_fromJs(place)
		val result = placeApi.modifyPlace(
			placeConverted,
		)
		place_toJs(result)
	}

	override fun modifyPlaces(places: Array<PlaceJs>): Promise<Array<PlaceJs>> = GlobalScope.promise {
		val placesConverted: List<Place> = arrayToList(
			places,
			"places",
			{ x1: PlaceJs ->
				place_fromJs(x1)
			},
		)
		val result = placeApi.modifyPlaces(
			placesConverted,
		)
		listToArray(
			result,
			{ x1: Place ->
				place_toJs(x1)
			},
		)
	}

	override fun deletePlaceById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = placeApi.deletePlaceById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deletePlaceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = placeApi.deletePlaceByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deletePlace(place: PlaceJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val placeConverted: Place = place_fromJs(place)
		val result = placeApi.deletePlace(
			placeConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deletePlaces(places: Array<PlaceJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val placesConverted: List<Place> = arrayToList(
			places,
			"places",
			{ x1: PlaceJs ->
				place_fromJs(x1)
			},
		)
		val result = placeApi.deletePlaces(
			placesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeletePlaceById(entityId: String, rev: String): Promise<PlaceJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = placeApi.undeletePlaceById(
			entityIdConverted,
			revConverted,
		)
		place_toJs(result)
	}

	override fun undeletePlaceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<PlaceJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = placeApi.undeletePlaceByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: Place ->
				place_toJs(x1)
			},
		)
	}

	override fun undeletePlace(place: PlaceJs): Promise<PlaceJs> = GlobalScope.promise {
		val placeConverted: Place = place_fromJs(place)
		val result = placeApi.undeletePlace(
			placeConverted,
		)
		place_toJs(result)
	}

	override fun undeletePlaces(places: Array<PlaceJs>): Promise<Array<PlaceJs>> =
			GlobalScope.promise {
		val placesConverted: List<Place> = arrayToList(
			places,
			"places",
			{ x1: PlaceJs ->
				place_fromJs(x1)
			},
		)
		val result = placeApi.undeletePlaces(
			placesConverted,
		)
		listToArray(
			result,
			{ x1: Place ->
				place_toJs(x1)
			},
		)
	}

	override fun purgePlaceById(entityId: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		placeApi.purgePlaceById(
			entityIdConverted,
			revConverted,
		)

	}

	override fun purgePlaceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = placeApi.purgePlaceByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgePlace(place: PlaceJs): Promise<Unit> = GlobalScope.promise {
		val placeConverted: Place = place_fromJs(place)
		placeApi.purgePlace(
			placeConverted,
		)

	}

	override fun purgePlaces(places: Array<PlaceJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val placesConverted: List<Place> = arrayToList(
			places,
			"places",
			{ x1: PlaceJs ->
				place_fromJs(x1)
			},
		)
		val result = placeApi.purgePlaces(
			placesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}
}
