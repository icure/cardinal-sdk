// auto-generated file
package com.icure.cardinal.sdk.py.api.PlaceApi.inGroup

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreatePlaceParams(
	public val place: GroupScoped<Place>,
)

@OptIn(InternalIcureApi::class)
public fun createPlaceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePlaceParams>(params)
	runBlocking {
		sdk.place.inGroup.createPlace(
			decodedParams.place,
		)
	}
}.toPyString(GroupScoped.serializer(Place.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createPlaceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.createPlace(
				decodedParams.place,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Place.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreatePlacesParams(
	public val places: List<GroupScoped<Place>>,
)

@OptIn(InternalIcureApi::class)
public fun createPlacesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePlacesParams>(params)
	runBlocking {
		sdk.place.inGroup.createPlaces(
			decodedParams.places,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Place.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createPlacesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePlacesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.createPlaces(
				decodedParams.places,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Place.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPlaceParams(
	public val groupId: String,
	public val placeId: String,
)

@OptIn(InternalIcureApi::class)
public fun getPlaceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPlaceParams>(params)
	runBlocking {
		sdk.place.inGroup.getPlace(
			decodedParams.groupId,
			decodedParams.placeId,
		)
	}
}.toPyString(GroupScoped.serializer(Place.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPlaceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.getPlace(
				decodedParams.groupId,
				decodedParams.placeId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Place.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPlacesParams(
	public val groupId: String,
	public val placesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getPlacesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPlacesParams>(params)
	runBlocking {
		sdk.place.inGroup.getPlaces(
			decodedParams.groupId,
			decodedParams.placesIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Place.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPlacesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPlacesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.getPlaces(
				decodedParams.groupId,
				decodedParams.placesIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Place.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPlaceParams(
	public val place: GroupScoped<Place>,
)

@OptIn(InternalIcureApi::class)
public fun modifyPlaceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPlaceParams>(params)
	runBlocking {
		sdk.place.inGroup.modifyPlace(
			decodedParams.place,
		)
	}
}.toPyString(GroupScoped.serializer(Place.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPlaceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.modifyPlace(
				decodedParams.place,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Place.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPlacesParams(
	public val places: List<GroupScoped<Place>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyPlacesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPlacesParams>(params)
	runBlocking {
		sdk.place.inGroup.modifyPlaces(
			decodedParams.places,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Place.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPlacesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPlacesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.modifyPlaces(
				decodedParams.places,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Place.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePlaceByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deletePlaceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePlaceByIdParams>(params)
	runBlocking {
		sdk.place.inGroup.deletePlaceById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePlaceByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePlaceByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.deletePlaceById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePlaceByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deletePlaceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePlaceByIdsParams>(params)
	runBlocking {
		sdk.place.inGroup.deletePlaceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePlaceByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePlaceByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.deletePlaceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePlaceParams(
	public val place: GroupScoped<Place>,
)

@OptIn(InternalIcureApi::class)
public fun deletePlaceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePlaceParams>(params)
	runBlocking {
		sdk.place.inGroup.deletePlace(
			decodedParams.place,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePlaceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.deletePlace(
				decodedParams.place,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePlacesParams(
	public val places: List<GroupScoped<Place>>,
)

@OptIn(InternalIcureApi::class)
public fun deletePlacesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePlacesParams>(params)
	runBlocking {
		sdk.place.inGroup.deletePlaces(
			decodedParams.places,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePlacesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePlacesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.deletePlaces(
				decodedParams.places,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeletePlaceByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeletePlaceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePlaceByIdParams>(params)
	runBlocking {
		sdk.place.inGroup.undeletePlaceById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(Place.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeletePlaceByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePlaceByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.undeletePlaceById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Place.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeletePlaceByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun undeletePlaceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePlaceByIdsParams>(params)
	runBlocking {
		sdk.place.inGroup.undeletePlaceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Place.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeletePlaceByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePlaceByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.undeletePlaceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Place.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeletePlaceParams(
	public val place: GroupScoped<Place>,
)

@OptIn(InternalIcureApi::class)
public fun undeletePlaceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePlaceParams>(params)
	runBlocking {
		sdk.place.inGroup.undeletePlace(
			decodedParams.place,
		)
	}
}.toPyString(GroupScoped.serializer(Place.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeletePlaceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.undeletePlace(
				decodedParams.place,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Place.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeletePlacesParams(
	public val places: List<GroupScoped<Place>>,
)

@OptIn(InternalIcureApi::class)
public fun undeletePlacesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePlacesParams>(params)
	runBlocking {
		sdk.place.inGroup.undeletePlaces(
			decodedParams.places,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Place.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeletePlacesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePlacesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.undeletePlaces(
				decodedParams.places,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Place.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgePlaceByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgePlaceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePlaceByIdParams>(params)
	runBlocking {
		sdk.place.inGroup.purgePlaceById(
			decodedParams.entityId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgePlaceByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePlaceByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.purgePlaceById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgePlaceByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun purgePlaceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePlaceByIdsParams>(params)
	runBlocking {
		sdk.place.inGroup.purgePlaceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgePlaceByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePlaceByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.purgePlaceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgePlaceParams(
	public val place: GroupScoped<Place>,
)

@OptIn(InternalIcureApi::class)
public fun purgePlaceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePlaceParams>(params)
	runBlocking {
		sdk.place.inGroup.purgePlace(
			decodedParams.place,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgePlaceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.purgePlace(
				decodedParams.place,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgePlacesParams(
	public val places: List<GroupScoped<Place>>,
)

@OptIn(InternalIcureApi::class)
public fun purgePlacesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePlacesParams>(params)
	runBlocking {
		sdk.place.inGroup.purgePlaces(
			decodedParams.places,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgePlacesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePlacesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.inGroup.purgePlaces(
				decodedParams.places,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
