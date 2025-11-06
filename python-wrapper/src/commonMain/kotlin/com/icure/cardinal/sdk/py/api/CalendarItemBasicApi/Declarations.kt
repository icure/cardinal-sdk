// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemBasicApi

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
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
private class MatchCalendarItemsByParams(
	public val filter: BaseFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun matchCalendarItemsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.matchCalendarItemsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchCalendarItemsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCalendarItemsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.matchCalendarItemsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchCalendarItemsBySortedParams(
	public val filter: BaseSortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun matchCalendarItemsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.matchCalendarItemsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchCalendarItemsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchCalendarItemsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.matchCalendarItemsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsByParams(
	public val filter: BaseFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.filterCalendarItemsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedCalendarItem.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCalendarItemsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.filterCalendarItemsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsBySortedParams(
	public val filter: BaseSortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.filterCalendarItemsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedCalendarItem.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCalendarItemsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.filterCalendarItemsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemUnsafeBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemUnsafeParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItemUnsafe(
			decodedParams.entityId,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemUnsafeAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItemUnsafe(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsUnsafeParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsUnsafeBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsUnsafeParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItemsUnsafe(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemsUnsafeAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItemsUnsafe(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItemById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItemById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsByIdsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsByIdsParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItemsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemsByIdsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItemsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.purgeCalendarItemById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeCalendarItemByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.purgeCalendarItemById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsParams(
	public val calendarItems: List<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItems(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItems(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.purgeCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.purgeCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateCalendarItemParams(
	public val entity: EncryptedCalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.createCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.createCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class BookCalendarItemCheckingAvailabilityParams(
	public val entity: EncryptedCalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun bookCalendarItemCheckingAvailabilityBlocking(sdk: CardinalBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<BookCalendarItemCheckingAvailabilityParams>(params)
	runBlocking {
		sdk.calendarItem.bookCalendarItemCheckingAvailability(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun bookCalendarItemCheckingAvailabilityAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<BookCalendarItemCheckingAvailabilityParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.bookCalendarItemCheckingAvailability(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.undeleteCalendarItemById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.undeleteCalendarItemById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.undeleteCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.undeleteCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemParams(
	public val entity: EncryptedCalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.modifyCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.modifyCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.getCalendarItem(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getCalendarItem(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.getCalendarItems(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getCalendarItems(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsByPeriodAndHcPartyIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val hcPartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemsByPeriodAndHcPartyIdBlocking(sdk: CardinalBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarItemsByPeriodAndHcPartyIdParams>(params)
	runBlocking {
		sdk.calendarItem.getCalendarItemsByPeriodAndHcPartyId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(EncryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemsByPeriodAndHcPartyIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarItemsByPeriodAndHcPartyIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getCalendarItemsByPeriodAndHcPartyId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarsByPeriodAndAgendaIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarsByPeriodAndAgendaIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarsByPeriodAndAgendaIdParams>(params)
	runBlocking {
		sdk.calendarItem.getCalendarsByPeriodAndAgendaId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(EncryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarsByPeriodAndAgendaIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarsByPeriodAndAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getCalendarsByPeriodAndAgendaId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindCalendarItemsByRecurrenceIdParams(
	public val recurrenceId: String,
	public val startKey: String?,
	public val startDocumentId: String?,
	public val limit: Int,
)

@OptIn(InternalIcureApi::class)
public fun findCalendarItemsByRecurrenceIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByRecurrenceIdParams>(params)
	runBlocking {
		sdk.calendarItem.findCalendarItemsByRecurrenceId(
			decodedParams.recurrenceId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findCalendarItemsByRecurrenceIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByRecurrenceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.findCalendarItemsByRecurrenceId(
				decodedParams.recurrenceId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<CalendarItem>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.calendarItem.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedCalendarItem.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun subscribeToEventsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
