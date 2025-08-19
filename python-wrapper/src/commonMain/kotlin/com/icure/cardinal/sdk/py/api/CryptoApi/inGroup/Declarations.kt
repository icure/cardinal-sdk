// auto-generated file
package com.icure.cardinal.sdk.py.api.CryptoApi.inGroup

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
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

@Serializable
private class KeylessCreateExchangeDataToParams(
	public val groupId: String?,
	public val `delegate`: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun keylessCreateExchangeDataToBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<KeylessCreateExchangeDataToParams>(params)
	runBlocking {
		sdk.crypto.inGroup.keylessCreateExchangeDataTo(
			decodedParams.groupId,
			decodedParams.delegate,
		)
	}
}.toPyString(RawDecryptedExchangeData.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun keylessCreateExchangeDataToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<KeylessCreateExchangeDataToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.crypto.inGroup.keylessCreateExchangeDataTo(
				decodedParams.groupId,
				decodedParams.delegate,
			)
		}.toPyStringAsyncCallback(RawDecryptedExchangeData.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
