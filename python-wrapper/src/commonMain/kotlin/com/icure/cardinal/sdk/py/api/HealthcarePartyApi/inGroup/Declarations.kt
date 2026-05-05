// auto-generated file
package com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthcareParty
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
private class CreateHealthcarePartyParams(
	public val healthcareParty: GroupScoped<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun createHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.createHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(GroupScoped.serializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.createHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateHealthcarePartiesParams(
	public val healthcareParties: List<GroupScoped<HealthcareParty>>,
)

@OptIn(InternalIcureApi::class)
public fun createHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.createHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.createHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthcarePartyParams(
	public val groupId: String,
	public val healthcarePartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun getHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.getHealthcareParty(
			decodedParams.groupId,
			decodedParams.healthcarePartyId,
		)
	}
}.toPyString(GroupScoped.serializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.getHealthcareParty(
				decodedParams.groupId,
				decodedParams.healthcarePartyId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthcarePartiesParams(
	public val groupId: String,
	public val healthcarePartiesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.getHealthcareParties(
			decodedParams.groupId,
			decodedParams.healthcarePartiesIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.getHealthcareParties(
				decodedParams.groupId,
				decodedParams.healthcarePartiesIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcarePartyParams(
	public val healthcareParty: GroupScoped<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun modifyHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.modifyHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(GroupScoped.serializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.modifyHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcarePartiesParams(
	public val healthcareParties: List<GroupScoped<HealthcareParty>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.modifyHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.modifyHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartyByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteHealthcarePartyByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyByIdParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.deleteHealthcarePartyById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteHealthcarePartyByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.deleteHealthcarePartyById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartyByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteHealthcarePartyByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyByIdsParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.deleteHealthcarePartyByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteHealthcarePartyByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.deleteHealthcarePartyByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartyParams(
	public val healthcareParty: GroupScoped<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun deleteHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.deleteHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.deleteHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartiesParams(
	public val healthcareParties: List<GroupScoped<HealthcareParty>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.deleteHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.deleteHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteHealthcarePartyByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteHealthcarePartyByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyByIdParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.undeleteHealthcarePartyById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteHealthcarePartyByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.undeleteHealthcarePartyById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteHealthcarePartyByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteHealthcarePartyByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyByIdsParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.undeleteHealthcarePartyByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteHealthcarePartyByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.undeleteHealthcarePartyByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteHealthcarePartyParams(
	public val healthcareParty: GroupScoped<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.undeleteHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(GroupScoped.serializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.undeleteHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteHealthcarePartiesParams(
	public val healthcareParties: List<GroupScoped<HealthcareParty>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.undeleteHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.undeleteHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(HealthcareParty.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeHealthcarePartyByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeHealthcarePartyByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyByIdParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.purgeHealthcarePartyById(
			decodedParams.entityId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeHealthcarePartyByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.purgeHealthcarePartyById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeHealthcarePartyByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeHealthcarePartyByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyByIdsParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.purgeHealthcarePartyByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeHealthcarePartyByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.purgeHealthcarePartyByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeHealthcarePartyParams(
	public val healthcareParty: GroupScoped<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun purgeHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.purgeHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.purgeHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeHealthcarePartiesParams(
	public val healthcareParties: List<GroupScoped<HealthcareParty>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.purgeHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.purgeHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchHealthcarePartiesByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun matchHealthcarePartiesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchHealthcarePartiesByParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.matchHealthcarePartiesBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchHealthcarePartiesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchHealthcarePartiesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.matchHealthcarePartiesBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchHealthcarePartiesBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun matchHealthcarePartiesBySortedBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchHealthcarePartiesBySortedParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.matchHealthcarePartiesBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchHealthcarePartiesBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchHealthcarePartiesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.matchHealthcarePartiesBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterHealthPartiesByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun filterHealthPartiesByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterHealthPartiesByParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.filterHealthPartiesBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(HealthcareParty.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterHealthPartiesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterHealthPartiesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.filterHealthPartiesBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(HealthcareParty.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterHealthPartiesBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun filterHealthPartiesBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterHealthPartiesBySortedParams>(params)
	runBlocking {
		sdk.healthcareParty.inGroup.filterHealthPartiesBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(HealthcareParty.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterHealthPartiesBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterHealthPartiesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.inGroup.filterHealthPartiesBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(HealthcareParty.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)
