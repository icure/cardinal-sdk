// auto-generated file
package com.icure.cardinal.sdk.py.api.AgendaApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
import kotlin.Int
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
private class GetAllAgendasParams(
	public val startDocumentId: String?,
	public val limit: Int?,
)

@OptIn(InternalIcureApi::class)
public fun getAllAgendasBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAllAgendasParams>(params)
	runBlocking {
		sdk.agenda.getAllAgendas(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Agenda.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAllAgendasAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAllAgendasParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.getAllAgendas(
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateAgendaParams(
	public val agendaDto: Agenda,
)

@OptIn(InternalIcureApi::class)
public fun createAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAgendaParams>(params)
	runBlocking {
		sdk.agenda.createAgenda(
			decodedParams.agendaDto,
		)
	}
}.toPyString(Agenda.serializer())

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
			sdk.agenda.createAgenda(
				decodedParams.agendaDto,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendaUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendaUnsafeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendaUnsafeParams>(params)
	runBlocking {
		sdk.agenda.deleteAgendaUnsafe(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAgendaUnsafeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendaUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.deleteAgendaUnsafe(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendasUnsafeParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendasUnsafeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendasUnsafeParams>(params)
	runBlocking {
		sdk.agenda.deleteAgendasUnsafe(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAgendasUnsafeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendasUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.deleteAgendasUnsafe(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendaByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendaByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendaByIdParams>(params)
	runBlocking {
		sdk.agenda.deleteAgendaById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DocIdentifier.serializer())

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
			sdk.agenda.deleteAgendaById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendasByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendasByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendasByIdsParams>(params)
	runBlocking {
		sdk.agenda.deleteAgendasByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

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
			sdk.agenda.deleteAgendasByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeAgendaByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeAgendaByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAgendaByIdParams>(params)
	runBlocking {
		sdk.agenda.purgeAgendaById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeAgendaByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAgendaByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.purgeAgendaById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteAgendaByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteAgendaByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAgendaByIdParams>(params)
	runBlocking {
		sdk.agenda.undeleteAgendaById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Agenda.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteAgendaByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAgendaByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.undeleteAgendaById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendaParams(
	public val agenda: Agenda,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendaParams>(params)
	runBlocking {
		sdk.agenda.deleteAgenda(
			decodedParams.agenda,
		)
	}
}.toPyString(DocIdentifier.serializer())

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
			sdk.agenda.deleteAgenda(
				decodedParams.agenda,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendasParams(
	public val agendas: List<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAgendasBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAgendasParams>(params)
	runBlocking {
		sdk.agenda.deleteAgendas(
			decodedParams.agendas,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

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
			sdk.agenda.deleteAgendas(
				decodedParams.agendas,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeAgendaParams(
	public val agenda: Agenda,
)

@OptIn(InternalIcureApi::class)
public fun purgeAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAgendaParams>(params)
	runBlocking {
		sdk.agenda.purgeAgenda(
			decodedParams.agenda,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.purgeAgenda(
				decodedParams.agenda,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteAgendaParams(
	public val agenda: Agenda,
)

@OptIn(InternalIcureApi::class)
public fun undeleteAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAgendaParams>(params)
	runBlocking {
		sdk.agenda.undeleteAgenda(
			decodedParams.agenda,
		)
	}
}.toPyString(Agenda.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.undeleteAgenda(
				decodedParams.agenda,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAgendaParams(
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun getAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAgendaParams>(params)
	runBlocking {
		sdk.agenda.getAgenda(
			decodedParams.agendaId,
		)
	}
}.toPyString(Agenda.serializer())

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
			sdk.agenda.getAgenda(
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAgendasParams(
	public val agendaIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getAgendasBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAgendasParams>(params)
	runBlocking {
		sdk.agenda.getAgendas(
			decodedParams.agendaIds,
		)
	}
}.toPyString(ListSerializer(Agenda.serializer()))

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
			sdk.agenda.getAgendas(
				decodedParams.agendaIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAgendasForUserParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun getAgendasForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAgendasForUserParams>(params)
	runBlocking {
		sdk.agenda.getAgendasForUser(
			decodedParams.userId,
		)
	}
}.toPyString(Agenda.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAgendasForUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAgendasForUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.getAgendasForUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReadableAgendasForUserParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun getReadableAgendasForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetReadableAgendasForUserParams>(params)
	runBlocking {
		sdk.agenda.getReadableAgendasForUser(
			decodedParams.userId,
		)
	}
}.toPyString(ListSerializer(Agenda.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getReadableAgendasForUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetReadableAgendasForUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.getReadableAgendasForUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(ListSerializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyAgendaParams(
	public val agendaDto: Agenda,
)

@OptIn(InternalIcureApi::class)
public fun modifyAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyAgendaParams>(params)
	runBlocking {
		sdk.agenda.modifyAgenda(
			decodedParams.agendaDto,
		)
	}
}.toPyString(Agenda.serializer())

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
			sdk.agenda.modifyAgenda(
				decodedParams.agendaDto,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchAgendasByParams(
	public val filter: BaseFilterOptions<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun matchAgendasByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAgendasByParams>(params)
	runBlocking {
		sdk.agenda.matchAgendasBy(
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
			sdk.agenda.matchAgendasBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchAgendasBySortedParams(
	public val filter: BaseSortableFilterOptions<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun matchAgendasBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAgendasBySortedParams>(params)
	runBlocking {
		sdk.agenda.matchAgendasBySorted(
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
			sdk.agenda.matchAgendasBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterAgendasByParams(
	public val filter: BaseFilterOptions<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun filterAgendasByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAgendasByParams>(params)
	runBlocking {
		sdk.agenda.filterAgendasBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, Agenda.serializer())}

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
			sdk.agenda.filterAgendasBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, Agenda.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterAgendasBySortedParams(
	public val filter: BaseSortableFilterOptions<Agenda>,
)

@OptIn(InternalIcureApi::class)
public fun filterAgendasBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAgendasBySortedParams>(params)
	runBlocking {
		sdk.agenda.filterAgendasBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, Agenda.serializer())}

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
			sdk.agenda.filterAgendasBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, Agenda.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
