// auto-generated file
package com.icure.cardinal.sdk.py.api.AgendaApi.inGroup

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
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
private class GetAgendaParams(
	public val groupId: String,
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAgendaParams>(params)
	runBlocking {
		sdk.agenda.inGroup.getAgenda(
			decodedParams.groupId,
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(Agenda.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.getAgenda(
				decodedParams.groupId,
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAgendasParams(
	public val groupId: String,
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getAgendasBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAgendasParams>(params)
	runBlocking {
		sdk.agenda.inGroup.getAgendas(
			decodedParams.groupId,
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Agenda.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAgendasAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAgendasParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.getAgendas(
				decodedParams.groupId,
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Agenda.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateAgendaParams(
	public val entity: GroupScoped<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun createAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAgendaParams>(params)
	runBlocking {
		sdk.agenda.inGroup.createAgenda(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(Agenda.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.createAgenda(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyAgendaParams(
	public val entity: GroupScoped<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun modifyAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyAgendaParams>(params)
	runBlocking {
		sdk.agenda.inGroup.modifyAgenda(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(Agenda.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.modifyAgenda(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendasParams(
	public val agendas: List<GroupScoped<Agenda>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendasBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendasParams>(params)
	runBlocking {
		sdk.agenda.inGroup.deleteAgendas(
			decodedParams.agendas,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAgendasAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendasParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.deleteAgendas(
				decodedParams.agendas,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendaParams(
	public val agenda: GroupScoped<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendaParams>(params)
	runBlocking {
		sdk.agenda.inGroup.deleteAgenda(
			decodedParams.agenda,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.deleteAgenda(
				decodedParams.agenda,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendasByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendasByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendasByIdsParams>(params)
	runBlocking {
		sdk.agenda.inGroup.deleteAgendasByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAgendasByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendasByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.deleteAgendasByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendaByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendaByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendaByIdParams>(params)
	runBlocking {
		sdk.agenda.inGroup.deleteAgendaById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAgendaByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendaByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.deleteAgendaById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchAgendasByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun matchAgendasByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAgendasByParams>(params)
	runBlocking {
		sdk.agenda.inGroup.matchAgendasBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchAgendasByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAgendasByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.matchAgendasBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchAgendasBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun matchAgendasBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAgendasBySortedParams>(params)
	runBlocking {
		sdk.agenda.inGroup.matchAgendasBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchAgendasBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAgendasBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.matchAgendasBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterAgendasByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun filterAgendasByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAgendasByParams>(params)
	runBlocking {
		sdk.agenda.inGroup.filterAgendasBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(Agenda.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterAgendasByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAgendasByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.filterAgendasBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(Agenda.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterAgendasBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun filterAgendasBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAgendasBySortedParams>(params)
	runBlocking {
		sdk.agenda.inGroup.filterAgendasBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(Agenda.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterAgendasBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAgendasBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.inGroup.filterAgendasBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(Agenda.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)
