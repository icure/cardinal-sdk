// auto-generated file
package com.icure.cardinal.sdk.py.api.DataOwnerApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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

public fun getCurrentDataOwnerBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwner()
	}
}.toPyString(DataOwnerWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwner()
		}.toPyStringAsyncCallback(DataOwnerWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerStubBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerStub()
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerStubAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerStub()
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerIdBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerId()
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerIdAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerId()
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerReferenceBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerReference()
	}
}.toPyString(EntityReferenceInGroup.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerReferenceAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerReference()
		}.toPyStringAsyncCallback(EntityReferenceInGroup.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerHierarchyIdsBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerHierarchyInfo()
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerHierarchyIdsAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerHierarchyInfo()
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerHierarchyIdsReferenceBlocking(sdk: CardinalApis): String =
		kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerHierarchyIdsReference()
	}
}.toPyString(ListSerializer(EntityReferenceInGroup.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerHierarchyIdsReferenceAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerHierarchyIdsReference()
		}.toPyStringAsyncCallback(ListSerializer(EntityReferenceInGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDataOwnerParams(
	public val ownerId: String,
)

@OptIn(InternalIcureApi::class)
public fun getDataOwnerBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDataOwnerParams>(params)
	runBlocking {
		sdk.dataOwner.getDataOwner(
			decodedParams.ownerId,
		)
	}
}.toPyString(DataOwnerWithType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDataOwnerAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDataOwnerParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getDataOwner(
				decodedParams.ownerId,
			)
		}.toPyStringAsyncCallback(DataOwnerWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCryptoActorStubParams(
	public val ownerId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCryptoActorStubBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCryptoActorStubParams>(params)
	runBlocking {
		sdk.dataOwner.getCryptoActorStub(
			decodedParams.ownerId,
		)
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCryptoActorStubAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCryptoActorStubParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCryptoActorStub(
				decodedParams.ownerId,
			)
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCryptoActorStubInGroupParams(
	public val entityReferenceInGroup: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun getCryptoActorStubInGroupBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCryptoActorStubInGroupParams>(params)
	runBlocking {
		sdk.dataOwner.getCryptoActorStubInGroup(
			decodedParams.entityReferenceInGroup,
		)
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCryptoActorStubInGroupAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCryptoActorStubInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCryptoActorStubInGroup(
				decodedParams.entityReferenceInGroup,
			)
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCurrentDataOwnerHierarchyIdsFromParams(
	public val parentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCurrentDataOwnerHierarchyIdsFromBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCurrentDataOwnerHierarchyIdsFromParams>(params)
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerParentHierarchy(
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCurrentDataOwnerHierarchyIdsFromAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCurrentDataOwnerHierarchyIdsFromParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerParentHierarchy(
				decodedParams.parentId,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerHierarchyBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerHierarchy()
	}
}.toPyString(ListSerializer(DataOwnerWithType.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerHierarchyAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerHierarchy()
		}.toPyStringAsyncCallback(ListSerializer(DataOwnerWithType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDataOwnerStubParams(
	public val cryptoActorStubWithTypeDto: CryptoActorStubWithType,
)

@OptIn(InternalIcureApi::class)
public fun modifyDataOwnerStubBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDataOwnerStubParams>(params)
	runBlocking {
		sdk.dataOwner.modifyDataOwnerStub(
			decodedParams.cryptoActorStubWithTypeDto,
		)
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyDataOwnerStubAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDataOwnerStubParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.modifyDataOwnerStub(
				decodedParams.cryptoActorStubWithTypeDto,
			)
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerTypeBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerType()
	}
}.toPyString(DataOwnerType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerTypeAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerType()
		}.toPyStringAsyncCallback(DataOwnerType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun clearCurrentDataOwnerIdsCache(sdk: CardinalApis): String = kotlin.runCatching {
	sdk.dataOwner.clearCurrentDataOwnerIdsCache()
}.toPyString(Unit.serializer())
