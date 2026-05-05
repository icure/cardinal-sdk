// auto-generated file
package com.icure.cardinal.sdk.py.api.RecoveryApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeySize
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
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
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateRecoveryInfoForAvailableParentKeyPairsParams(
	public val parentId: String,
	public val includeAncestorKeys: Boolean = false,
	public val lifetimeSeconds: Int? = null,
	public val recoveryKeyOptions: RecoveryKeyOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun createRecoveryInfoForAvailableParentKeyPairsBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateRecoveryInfoForAvailableParentKeyPairsParams>(params)
	runBlocking {
		sdk.recovery.createRecoveryInfoForAvailableParentKeyPairs(
			decodedParams.parentId,
			decodedParams.includeAncestorKeys,
			decodedParams.lifetimeSeconds,
			decodedParams.recoveryKeyOptions,
		)
	}
}.toPyString(RecoveryDataKey.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRecoveryInfoForAvailableParentKeyPairsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateRecoveryInfoForAvailableParentKeyPairsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.createRecoveryInfoForAvailableParentKeyPairs(
				decodedParams.parentId,
				decodedParams.includeAncestorKeys,
				decodedParams.lifetimeSeconds,
				decodedParams.recoveryKeyOptions,
			)
		}.toPyStringAsyncCallback(RecoveryDataKey.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRecoveryInfoParams(
	public val recoveryKey: RecoveryDataKey,
)

@OptIn(InternalIcureApi::class)
public fun purgeRecoveryInfoBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRecoveryInfoParams>(params)
	runBlocking {
		sdk.recovery.purgeRecoveryInfo(
			decodedParams.recoveryKey,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRecoveryInfoAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRecoveryInfoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.purgeRecoveryInfo(
				decodedParams.recoveryKey,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeAllRecoveryInfoForParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeAllRecoveryInfoForBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAllRecoveryInfoForParams>(params)
	runBlocking {
		sdk.recovery.purgeAllRecoveryInfoFor(
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeAllRecoveryInfoForAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAllRecoveryInfoForParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.purgeAllRecoveryInfoFor(
				decodedParams.dataOwnerId,
			)
		}.toPyStringAsyncCallback(Int.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeAllKeyPairRecoveryInfoForParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeAllKeyPairRecoveryInfoForBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeAllKeyPairRecoveryInfoForParams>(params)
	runBlocking {
		sdk.recovery.purgeAllKeyPairRecoveryInfoFor(
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeAllKeyPairRecoveryInfoForAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeAllKeyPairRecoveryInfoForParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.purgeAllKeyPairRecoveryInfoFor(
				decodedParams.dataOwnerId,
			)
		}.toPyStringAsyncCallback(Int.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeAllExchangeDataRecoveryInfoForParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeAllExchangeDataRecoveryInfoForBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeAllExchangeDataRecoveryInfoForParams>(params)
	runBlocking {
		sdk.recovery.purgeAllExchangeDataRecoveryInfoFor(
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeAllExchangeDataRecoveryInfoForAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeAllExchangeDataRecoveryInfoForParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.purgeAllExchangeDataRecoveryInfoFor(
				decodedParams.dataOwnerId,
			)
		}.toPyStringAsyncCallback(Int.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PreGenerateRecoveryKeyParams(
	public val keySize: RecoveryKeySize,
)

@OptIn(InternalIcureApi::class)
public fun preGenerateRecoveryKeyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PreGenerateRecoveryKeyParams>(params)
	runBlocking {
		sdk.recovery.preGenerateRecoveryKey(
			decodedParams.keySize,
		)
	}
}.toPyString(RecoveryDataKey.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun preGenerateRecoveryKeyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PreGenerateRecoveryKeyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.preGenerateRecoveryKey(
				decodedParams.keySize,
			)
		}.toPyStringAsyncCallback(RecoveryDataKey.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
