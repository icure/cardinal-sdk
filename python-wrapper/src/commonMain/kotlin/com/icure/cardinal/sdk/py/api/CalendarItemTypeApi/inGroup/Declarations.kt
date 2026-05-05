// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.GroupScoped
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
	public val calendarItemType: GroupScoped<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.createCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(GroupScoped.serializer(CalendarItemType.serializer()))

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
			sdk.calendarItemType.inGroup.createCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateCalendarItemTypesParams(
	public val calendarItemTypes: List<GroupScoped<CalendarItemType>>,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.createCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())))

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
			sdk.calendarItemType.inGroup.createCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemTypeParams(
	public val groupId: String,
	public val calendarItemTypeId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.getCalendarItemType(
			decodedParams.groupId,
			decodedParams.calendarItemTypeId,
		)
	}
}.toPyString(GroupScoped.serializer(CalendarItemType.serializer()))

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
			sdk.calendarItemType.inGroup.getCalendarItemType(
				decodedParams.groupId,
				decodedParams.calendarItemTypeId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemTypesParams(
	public val groupId: String,
	public val calendarItemTypesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.getCalendarItemTypes(
			decodedParams.groupId,
			decodedParams.calendarItemTypesIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())))

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
			sdk.calendarItemType.inGroup.getCalendarItemTypes(
				decodedParams.groupId,
				decodedParams.calendarItemTypesIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemTypeParams(
	public val calendarItemType: GroupScoped<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.modifyCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(GroupScoped.serializer(CalendarItemType.serializer()))

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
			sdk.calendarItemType.inGroup.modifyCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemTypesParams(
	public val calendarItemTypes: List<GroupScoped<CalendarItemType>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.modifyCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())))

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
			sdk.calendarItemType.inGroup.modifyCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypeByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypeByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeByIdParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.deleteCalendarItemTypeById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

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
			sdk.calendarItemType.inGroup.deleteCalendarItemTypeById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypeByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypeByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeByIdsParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.deleteCalendarItemTypeByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.calendarItemType.inGroup.deleteCalendarItemTypeByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypeParams(
	public val calendarItemType: GroupScoped<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.deleteCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

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
			sdk.calendarItemType.inGroup.deleteCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypesParams(
	public val calendarItemTypes: List<GroupScoped<CalendarItemType>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.deleteCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.calendarItemType.inGroup.deleteCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemTypeByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemTypeByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeByIdParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.undeleteCalendarItemTypeById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(CalendarItemType.serializer()))

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
			sdk.calendarItemType.inGroup.undeleteCalendarItemTypeById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemTypeByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemTypeByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeByIdsParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.undeleteCalendarItemTypeByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())))

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
			sdk.calendarItemType.inGroup.undeleteCalendarItemTypeByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemTypeParams(
	public val calendarItemType: GroupScoped<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.undeleteCalendarItemType(
			decodedParams.calendarItemType,
		)
	}
}.toPyString(GroupScoped.serializer(CalendarItemType.serializer()))

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
			sdk.calendarItemType.inGroup.undeleteCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemTypesParams(
	public val calendarItemTypes: List<GroupScoped<CalendarItemType>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.undeleteCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())))

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
			sdk.calendarItemType.inGroup.undeleteCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(CalendarItemType.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemTypeByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemTypeByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeByIdParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.purgeCalendarItemTypeById(
			decodedParams.entityId,
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
			sdk.calendarItemType.inGroup.purgeCalendarItemTypeById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemTypeByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemTypeByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeByIdsParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.purgeCalendarItemTypeByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.calendarItemType.inGroup.purgeCalendarItemTypeByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemTypeParams(
	public val calendarItemType: GroupScoped<CalendarItemType>,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.purgeCalendarItemType(
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
			sdk.calendarItemType.inGroup.purgeCalendarItemType(
				decodedParams.calendarItemType,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemTypesParams(
	public val calendarItemTypes: List<GroupScoped<CalendarItemType>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.inGroup.purgeCalendarItemTypes(
			decodedParams.calendarItemTypes,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.calendarItemType.inGroup.purgeCalendarItemTypes(
				decodedParams.calendarItemTypes,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
