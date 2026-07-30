// auto-generated file
package com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
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
import kotlin.collections.Map
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
	public val relatedPerson: RelatedPerson,
	public val options: RelatedPersonShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.relatedPerson,
			decodedParams.options,
		)
	}
}.toPyString(PolymorphicSerializer(RelatedPerson::class))

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
			sdk.relatedPerson.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.relatedPerson,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(RelatedPerson::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val relatedPerson: RelatedPerson,
	public val delegates: Map<String, RelatedPersonShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.shareWithMany(
			decodedParams.relatedPerson,
			decodedParams.delegates,
		)
	}
}.toPyString(PolymorphicSerializer(RelatedPerson::class))

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
			sdk.relatedPerson.tryAndRecover.shareWithMany(
				decodedParams.relatedPerson,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(RelatedPerson::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsByParams(
	public val filter: FilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.filterRelatedPersonsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(RelatedPerson::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterRelatedPersonsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.filterRelatedPersonsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(RelatedPerson::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsBySortedParams(
	public val filter: SortableFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.filterRelatedPersonsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(RelatedPerson::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterRelatedPersonsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.filterRelatedPersonsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(RelatedPerson::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonParams(
	public val entity: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.createRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(RelatedPerson::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.createRelatedPerson(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(RelatedPerson::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonsParams(
	public val entities: List<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.createRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(RelatedPerson::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.createRelatedPersons(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(RelatedPerson::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.undeleteRelatedPersonById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(PolymorphicSerializer(RelatedPerson::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.undeleteRelatedPersonById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(RelatedPerson::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonsByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.undeleteRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(RelatedPerson::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonsByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.undeleteRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(RelatedPerson::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonParams(
	public val relatedPerson: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.undeleteRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(PolymorphicSerializer(RelatedPerson::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.undeleteRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(RelatedPerson::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonsParams(
	public val relatedPersons: List<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.undeleteRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(RelatedPerson::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.undeleteRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(RelatedPerson::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRelatedPersonParams(
	public val entity: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun modifyRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.modifyRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(RelatedPerson::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.modifyRelatedPerson(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(RelatedPerson::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRelatedPersonsParams(
	public val entities: List<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun modifyRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.modifyRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(RelatedPerson::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.modifyRelatedPersons(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(RelatedPerson::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRelatedPersonParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.getRelatedPerson(
			decodedParams.entityId,
		)
	}
}.toPyString(PolymorphicSerializer(RelatedPerson::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.getRelatedPerson(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(RelatedPerson::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRelatedPersonsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.tryAndRecover.getRelatedPersons(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(RelatedPerson::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.tryAndRecover.getRelatedPersons(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(RelatedPerson::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
