// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
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
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val calendarItem: CalendarItem,
	public val options: CalendarItemShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.calendarItem,
			decodedParams.options,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.calendarItem,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val calendarItem: CalendarItem,
	public val delegates: Map<String, CalendarItemShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.shareWithMany(
			decodedParams.calendarItem,
			decodedParams.delegates,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.shareWithMany(
				decodedParams.calendarItem,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindCalendarItemsByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findCalendarItemsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.findCalendarItemsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(CalendarItem::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findCalendarItemsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.findCalendarItemsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(CalendarItem::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class LinkToPatientParams(
	public val calendarItem: CalendarItem,
	public val patient: Patient,
	public val shareLinkWithDelegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun linkToPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<LinkToPatientParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.linkToPatient(
			decodedParams.calendarItem,
			decodedParams.patient,
			decodedParams.shareLinkWithDelegates,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun linkToPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<LinkToPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.linkToPatient(
				decodedParams.calendarItem,
				decodedParams.patient,
				decodedParams.shareLinkWithDelegates,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsByParams(
	public val filter: FilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.filterCalendarItemsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(CalendarItem::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCalendarItemsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.filterCalendarItemsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(CalendarItem::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsBySortedParams(
	public val filter: SortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.filterCalendarItemsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(CalendarItem::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCalendarItemsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.filterCalendarItemsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(CalendarItem::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateCalendarItemParams(
	public val entity: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.createCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.createCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class BookCalendarItemCheckingAvailabilityParams(
	public val entity: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun bookCalendarItemCheckingAvailabilityBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<BookCalendarItemCheckingAvailabilityParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.bookCalendarItemCheckingAvailability(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun bookCalendarItemCheckingAvailabilityAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<BookCalendarItemCheckingAvailabilityParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.bookCalendarItemCheckingAvailability(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.undeleteCalendarItemById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.undeleteCalendarItemById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.undeleteCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.undeleteCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemParams(
	public val entity: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.modifyCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.modifyCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.getCalendarItem(
			decodedParams.entityId,
		)
	}
}.toPyString(PolymorphicSerializer(CalendarItem::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.getCalendarItem(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(CalendarItem::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.getCalendarItems(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(CalendarItem::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.getCalendarItems(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(CalendarItem::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsByPeriodAndHcPartyIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val hcPartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemsByPeriodAndHcPartyIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarItemsByPeriodAndHcPartyIdParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.getCalendarItemsByPeriodAndHcPartyId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(CalendarItem::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemsByPeriodAndHcPartyIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarItemsByPeriodAndHcPartyIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.getCalendarItemsByPeriodAndHcPartyId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(CalendarItem::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarsByPeriodAndAgendaIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarsByPeriodAndAgendaIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarsByPeriodAndAgendaIdParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.getCalendarsByPeriodAndAgendaId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(CalendarItem::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarsByPeriodAndAgendaIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarsByPeriodAndAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.getCalendarsByPeriodAndAgendaId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(CalendarItem::class)),
				resultCallback)
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
public fun findCalendarItemsByRecurrenceIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByRecurrenceIdParams>(params)
	runBlocking {
		sdk.calendarItem.tryAndRecover.findCalendarItemsByRecurrenceId(
			decodedParams.recurrenceId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(CalendarItem::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findCalendarItemsByRecurrenceIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByRecurrenceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryAndRecover.findCalendarItemsByRecurrenceId(
				decodedParams.recurrenceId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(CalendarItem::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
