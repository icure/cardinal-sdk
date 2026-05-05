// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemTypeApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.CalendarItemType
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
private class CreateCalendarItemTypeParams(
	public val calendarItemType: CalendarItemType,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.createCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(CalendarItemType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.createCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(CalendarItemType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateCalendarItemTypesParams(
	public val calendarItemTypes: List<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.createCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(CalendarItemType.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCalendarItemTypesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemTypesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.createCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemTypeParams(
	public val calendarItemTypeId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.getCalendarItemType(
			decodedParams.calendarItemTypeId,
		)
	}
}.toPyString(CalendarItemType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.getCalendarItemType(
				decodedParams.calendarItemTypeId,
			)
		}.toPyStringAsyncCallback(CalendarItemType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemTypesParams(
	public val calendarItemTypesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.getCalendarItemTypes(
			decodedParams.calendarItemTypesIds,
		)
	}
}.toPyString(ListSerializer(CalendarItemType.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemTypesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.getCalendarItemTypes(
				decodedParams.calendarItemTypesIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemTypeParams(
	public val calendarItemType: CalendarItemType,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.modifyCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(CalendarItemType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.modifyCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(CalendarItemType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemTypesParams(
	public val calendarItemTypes: List<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.modifyCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(CalendarItemType.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCalendarItemTypesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemTypesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.modifyCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypeByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypeByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeByIdParams>(params)
	runBlocking {
		sdk.calendarItemType.deleteCalendarItemTypeById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemTypeByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.deleteCalendarItemTypeById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypeByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypeByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeByIdsParams>(params)
	runBlocking {
		sdk.calendarItemType.deleteCalendarItemTypeByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemTypeByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.deleteCalendarItemTypeByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypeParams(
	public val calendarItemType: CalendarItemType,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.deleteCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.deleteCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypesParams(
	public val calendarItemTypes: List<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.deleteCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemTypesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.deleteCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemTypeByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemTypeByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeByIdParams>(params)
	runBlocking {
		sdk.calendarItemType.undeleteCalendarItemTypeById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(CalendarItemType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemTypeByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.undeleteCalendarItemTypeById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(CalendarItemType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemTypeByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemTypeByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeByIdsParams>(params)
	runBlocking {
		sdk.calendarItemType.undeleteCalendarItemTypeByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(CalendarItemType.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemTypeByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.undeleteCalendarItemTypeByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemTypeParams(
	public val calendarItemType: CalendarItemType,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.undeleteCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(CalendarItemType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.undeleteCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(CalendarItemType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemTypesParams(
	public val calendarItemTypes: List<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.undeleteCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(CalendarItemType.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemTypesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.undeleteCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemTypeByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemTypeByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeByIdParams>(params)
	runBlocking {
		sdk.calendarItemType.purgeCalendarItemTypeById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeCalendarItemTypeByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.purgeCalendarItemTypeById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemTypeByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemTypeByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeByIdsParams>(params)
	runBlocking {
		sdk.calendarItemType.purgeCalendarItemTypeByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeCalendarItemTypeByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.purgeCalendarItemTypeByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemTypeParams(
	public val calendarItemType: CalendarItemType,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.purgeCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.purgeCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemTypesParams(
	public val calendarItemTypes: List<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.purgeCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeCalendarItemTypesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.purgeCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListCalendarItemTypesByAgendaIdParams(
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun listCalendarItemTypesByAgendaIdBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListCalendarItemTypesByAgendaIdParams>(params)
	runBlocking {
		sdk.calendarItemType.listCalendarItemTypesByAgendaId(
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(CalendarItemType.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listCalendarItemTypesByAgendaIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListCalendarItemTypesByAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.listCalendarItemTypesByAgendaId(
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
