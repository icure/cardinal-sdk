// auto-generated file
package com.icure.cardinal.sdk.py.api.ApplicationSettingsApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.EncryptedApplicationSettings
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

public fun getApplicationSettingsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.applicationSettings.getApplicationSettings()
	}
}.toPyString(ListSerializer(EncryptedApplicationSettings.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getApplicationSettingsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.applicationSettings.getApplicationSettings()
		}.toPyStringAsyncCallback(ListSerializer(EncryptedApplicationSettings.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateApplicationSettingsParams(
	public val applicationSettings: EncryptedApplicationSettings,
)

@OptIn(InternalIcureApi::class)
public fun createApplicationSettingsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateApplicationSettingsParams>(params)
	runBlocking {
		sdk.applicationSettings.createApplicationSettings(
			decodedParams.applicationSettings,
		)
	}
}.toPyString(EncryptedApplicationSettings.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createApplicationSettingsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateApplicationSettingsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.applicationSettings.createApplicationSettings(
				decodedParams.applicationSettings,
			)
		}.toPyStringAsyncCallback(EncryptedApplicationSettings.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UpdateApplicationSettingsParams(
	public val applicationSettings: EncryptedApplicationSettings,
)

@OptIn(InternalIcureApi::class)
public fun updateApplicationSettingsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UpdateApplicationSettingsParams>(params)
	runBlocking {
		sdk.applicationSettings.updateApplicationSettings(
			decodedParams.applicationSettings,
		)
	}
}.toPyString(EncryptedApplicationSettings.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun updateApplicationSettingsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UpdateApplicationSettingsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.applicationSettings.updateApplicationSettings(
				decodedParams.applicationSettings,
			)
		}.toPyStringAsyncCallback(EncryptedApplicationSettings.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
