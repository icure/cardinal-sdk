// auto-generated file
package com.icure.cardinal.sdk.py.api.FilterApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.filter.FilterOptionGroupWithViews
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
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
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer

public fun getFilterOptionsDefinitionsBlocking(sdk: CardinalNonCryptoApis): String =
		kotlin.runCatching {
	runBlocking {
		sdk.filter.getFilterOptionsDefinitions()
	}
}.toPyString(MapSerializer(String.serializer(),
		ListSerializer(FilterOptionGroupWithViews.serializer())))

@OptIn(ExperimentalForeignApi::class)
public fun getFilterOptionsDefinitionsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.filter.getFilterOptionsDefinitions()
		}.toPyStringAsyncCallback(MapSerializer(String.serializer(),
				ListSerializer(FilterOptionGroupWithViews.serializer())), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
