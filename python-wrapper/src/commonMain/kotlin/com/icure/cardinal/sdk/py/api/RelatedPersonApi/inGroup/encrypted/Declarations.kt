// auto-generated file
package com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
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
import com.icure.cardinal.sdk.serialization.MapAsArraySerializer
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val `delegate`: EntityReferenceInGroup,
	public val relatedPerson: GroupScoped<EncryptedRelatedPerson>,
	public val options: RelatedPersonShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.shareWith(
			decodedParams.delegate,
			decodedParams.relatedPerson,
			decodedParams.options,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.encrypted.shareWith(
				decodedParams.delegate,
				decodedParams.relatedPerson,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val relatedPerson: GroupScoped<EncryptedRelatedPerson>,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, RelatedPersonShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.shareWithMany(
			decodedParams.relatedPerson,
			decodedParams.delegates,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.encrypted.shareWithMany(
				decodedParams.relatedPerson,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsByParams(
	public val groupId: String,
	public val filter: FilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.filterRelatedPersonsBy(
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
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.encrypted.filterRelatedPersonsBy(
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
	public val filter: SortableFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.filterRelatedPersonsBySorted(
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
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.encrypted.filterRelatedPersonsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(EncryptedRelatedPerson.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonParams(
	public val entity: GroupScoped<EncryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.createRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.encrypted.createRelatedPerson(
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
public fun createRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.createRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.encrypted.createRelatedPersons(
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
public fun undeleteRelatedPersonByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.undeleteRelatedPersonById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.encrypted.undeleteRelatedPersonById(
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
public fun undeleteRelatedPersonsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.undeleteRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.encrypted.undeleteRelatedPersonsByIds(
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
public fun undeleteRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.undeleteRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.encrypted.undeleteRelatedPerson(
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
public fun undeleteRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.undeleteRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.encrypted.undeleteRelatedPersons(
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
public fun modifyRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.modifyRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.encrypted.modifyRelatedPerson(
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
public fun modifyRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.modifyRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.encrypted.modifyRelatedPersons(
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
public fun getRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.getRelatedPerson(
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
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.encrypted.getRelatedPerson(
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
public fun getRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encrypted.getRelatedPersons(
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
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.inGroup.encrypted.getRelatedPersons(
				decodedParams.groupId,
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
