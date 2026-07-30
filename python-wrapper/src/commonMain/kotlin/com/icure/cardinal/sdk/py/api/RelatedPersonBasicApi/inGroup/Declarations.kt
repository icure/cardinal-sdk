// auto-generated file
package com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.RelatedPerson
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
private class MatchRelatedPersonsByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun matchRelatedPersonsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsByParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.matchRelatedPersonsBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchRelatedPersonsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.matchRelatedPersonsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchRelatedPersonsBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun matchRelatedPersonsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsBySortedParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.matchRelatedPersonsBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchRelatedPersonsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.matchRelatedPersonsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.filterRelatedPersonsBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it,
			GroupScoped.serializer(EncryptedRelatedPerson.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterRelatedPersonsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.filterRelatedPersonsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(EncryptedRelatedPerson.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.filterRelatedPersonsBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it,
			GroupScoped.serializer(EncryptedRelatedPerson.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterRelatedPersonsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.filterRelatedPersonsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(EncryptedRelatedPerson.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.deleteRelatedPersonById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteRelatedPersonByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.deleteRelatedPersonById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonsByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonsByIdsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.deleteRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteRelatedPersonsByIdsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.deleteRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.purgeRelatedPersonById(
			decodedParams.entityId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRelatedPersonByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.purgeRelatedPersonById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonsByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonsByIdsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.purgeRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRelatedPersonsByIdsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.purgeRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.deleteRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteRelatedPersonAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.deleteRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonsParams(
	public val relatedPersons: List<GroupScoped<RelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.deleteRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteRelatedPersonsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.deleteRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.purgeRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRelatedPersonAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.purgeRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonsParams(
	public val relatedPersons: List<GroupScoped<RelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.purgeRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRelatedPersonsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.purgeRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonParams(
	public val entity: GroupScoped<EncryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.createRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRelatedPersonAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.createRelatedPerson(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonsParams(
	public val entities: List<GroupScoped<EncryptedRelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.createRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRelatedPersonsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.createRelatedPersons(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.undeleteRelatedPersonById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.undeleteRelatedPersonById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonsByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonsByIdsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.undeleteRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonsByIdsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.undeleteRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.undeleteRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.undeleteRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonsParams(
	public val relatedPersons: List<GroupScoped<EncryptedRelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.undeleteRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.undeleteRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRelatedPersonParams(
	public val entity: GroupScoped<EncryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun modifyRelatedPersonBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.modifyRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyRelatedPersonAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.modifyRelatedPerson(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRelatedPersonsParams(
	public val entities: List<GroupScoped<EncryptedRelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyRelatedPersonsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.modifyRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyRelatedPersonsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.modifyRelatedPersons(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRelatedPersonParams(
	public val groupId: String,
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getRelatedPersonBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.getRelatedPerson(
			decodedParams.groupId,
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRelatedPersonAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.getRelatedPerson(
				decodedParams.groupId,
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRelatedPersonsParams(
	public val groupId: String,
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getRelatedPersonsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.getRelatedPersons(
			decodedParams.groupId,
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRelatedPersonsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.getRelatedPersons(
				decodedParams.groupId,
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
