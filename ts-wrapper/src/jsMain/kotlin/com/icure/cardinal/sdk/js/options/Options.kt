package com.icure.cardinal.sdk.js.options

 import com.icure.cardinal.sdk.js.crypto.CryptoStrategiesBridge
import com.icure.cardinal.sdk.js.model.userGroup_toJs
import com.icure.cardinal.sdk.js.options.external.AnonymousSdkOptionsJs
import com.icure.cardinal.sdk.js.options.external.BasicSdkOptionsJs
import com.icure.cardinal.sdk.js.options.external.BasicToFullSdkOptionsJs
 import com.icure.cardinal.sdk.js.options.external.CustomisedSdkOptionsJs
 import com.icure.cardinal.sdk.js.options.external.SdkOptionsJs
import com.icure.cardinal.sdk.js.storage.loadKeyStorageOptions
 import com.icure.cardinal.sdk.js.utils.cardinalInternalGlobals
 import com.icure.cardinal.sdk.options.AnonymousSdkOptions
import com.icure.cardinal.sdk.options.BasicSdkOptions
import com.icure.cardinal.sdk.options.BasicToFullSdkOptions
 import com.icure.cardinal.sdk.options.CustomisedSdkOptions
 import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
 import com.icure.cardinal.sdk.options.EncryptedFieldsOptions
 import com.icure.cardinal.sdk.options.PartialEncryptedManifest
 import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.adaptCryptoServiceForExternal
import com.icure.kryptom.crypto.external.adaptExternalCryptoService
import com.icure.kryptom.js.defaultJsCryptoAvailable
import kotlinx.coroutines.await
 import kotlinx.serialization.ExperimentalSerializationApi
 import kotlinx.serialization.json.Json
 import kotlinx.serialization.json.decodeFromDynamic

suspend fun SdkOptionsJs.toKt(): SdkOptions {
	val defaultSdkOptions = SdkOptions()
	return SdkOptions(
		useHierarchicalDataOwners = this.useHierarchicalDataOwners ?: defaultSdkOptions.useHierarchicalDataOwners,
		createTransferKeys = this.createTransferKeys ?: defaultSdkOptions.createTransferKeys,
		cryptoService = this.cryptoService.checkRequiredAdaptAndPolyfillRandom() ?: defaultSdkOptions.cryptoService,
		groupSelector = this.groupSelector?.let { groupSelectorJs ->
			{ ktGroups ->
				groupSelectorJs(ktGroups.map { userGroup_toJs(it) }.toTypedArray()).await()
			}
		} ?: defaultSdkOptions.groupSelector,
		autoCreateEncryptionKeyForExistingLegacyData = this.autoCreateEncryptionKeyForExistingLegacyData ?: defaultSdkOptions.autoCreateEncryptionKeyForExistingLegacyData,
		keyStorage = this.keyStorage?.let { loadKeyStorageOptions(it) } ?: defaultSdkOptions.keyStorage,
		cryptoStrategies = this.cryptoStrategies?.let {
			CryptoStrategiesBridge(it, this.cryptoService ?: adaptCryptoServiceForExternal(defaultSdkOptions.cryptoService))
		} ?: defaultSdkOptions.cryptoStrategies,
		ignoreUnknownFields = this.ignoreUnknownFields ?: defaultSdkOptions.ignoreUnknownFields,
		dataOwnerScope = this.dataOwnerScope ?: defaultSdkOptions.dataOwnerScope,
		unversionedEntitiesDecryptedJsonStrictness = this.unversionedEntitiesDecryptedJsonStrictness?.let {
			DecryptedJsonStrictness.valueOf(it)
		} ?: defaultSdkOptions.unversionedEntitiesDecryptedJsonStrictness,
	)
}

suspend fun BasicSdkOptionsJs.toKt(): BasicSdkOptions {
	val defaultApiOptions = BasicSdkOptions()
	return BasicSdkOptions(
		cryptoService = this.cryptoService.checkRequiredAdaptAndPolyfillRandom() ?: defaultApiOptions.cryptoService,
		groupSelector = this.groupSelector?.let { groupSelectorJs ->
			{ ktGroups ->
				groupSelectorJs(ktGroups.map { userGroup_toJs(it) }.toTypedArray()).await()
			}
		} ?: defaultApiOptions.groupSelector,
		ignoreUnknownFields = this.ignoreUnknownFields ?: defaultApiOptions.ignoreUnknownFields,
		dataOwnerScope = this.dataOwnerScope ?: defaultApiOptions.dataOwnerScope,
	)
}

suspend fun BasicToFullSdkOptionsJs.toKt(jsCryptoService: XCryptoService): BasicToFullSdkOptions {
	val defaultOptions = BasicToFullSdkOptions()
	return BasicToFullSdkOptions(
		useHierarchicalDataOwners = this.useHierarchicalDataOwners ?: defaultOptions.useHierarchicalDataOwners,
		createTransferKeys = this.createTransferKeys ?: defaultOptions.createTransferKeys,
		autoCreateEncryptionKeyForExistingLegacyData = this.autoCreateEncryptionKeyForExistingLegacyData ?: defaultOptions.autoCreateEncryptionKeyForExistingLegacyData,
		keyStorage = this.keyStorage?.let { loadKeyStorageOptions(it) } ?: defaultOptions.keyStorage,
		cryptoStrategies = this.cryptoStrategies?.let {
			CryptoStrategiesBridge(it, jsCryptoService)
		} ?: defaultOptions.cryptoStrategies,
		unversionedEntitiesDecryptedJsonStrictness = this.unversionedEntitiesDecryptedJsonStrictness?.let {
			DecryptedJsonStrictness.valueOf(it)
		} ?: defaultOptions.unversionedEntitiesDecryptedJsonStrictness,
	)
}

fun AnonymousSdkOptionsJs.toKt(): AnonymousSdkOptions {
	val defaultApiOptions = AnonymousSdkOptions()
	return AnonymousSdkOptions(
		ignoreUnknownFields = this.ignoreUnknownFields ?: defaultApiOptions.ignoreUnknownFields,
	)
}

fun CustomisedSdkOptionsJs.toKt(): CustomisedSdkOptions {
	val defaultSdkOptions = CustomisedSdkOptions()
	return CustomisedSdkOptions(
		encryptedFieldsOptions = parseEncryptedFieldOptions(encryptedFieldsOptions) ?: defaultSdkOptions.encryptedFieldsOptions,
	)
}

private fun XCryptoService?.checkRequiredAdaptAndPolyfillRandom(): CryptoService? {
	check (defaultJsCryptoAvailable() || this != null) {
		"""
			Js crypto or crypto.subtle is not available.
			To use CardinalSdk with node and ES modules you need to use node 19 or later.
			To use CardinalSdk in expo / react native you need to use the @icure/nitro-kryptom npm package and pass the `nitroKryptomCryptoService` explicitly as the `cryptoService` in the SDK initialization options.
		""".trimIndent()
	}
	val adapted = this?.let(::adaptExternalCryptoService)
	if (adapted != null && cardinalInternalGlobals.randomUuid == null) {
		cardinalInternalGlobals.randomUuid = adapted.strongRandom::randomUUID
	}
	return adapted
}

@OptIn(ExperimentalSerializationApi::class)
private fun parseEncryptedFieldOptions(options: dynamic): EncryptedFieldsOptions? {
	if (options == null) return null
	if (options == "Legacy") return EncryptedFieldsOptions.Legacy
	if (options == "Default") return EncryptedFieldsOptions.Default
	val manifestsJson = options.manifestsJson
	if (manifestsJson != null) {
		return EncryptedFieldsOptions.Custom(Json.decodeFromDynamic(PartialEncryptedManifest.serializer(), manifestsJson))
	}
	throw IllegalArgumentException("Invalid encryptedFieldsOptions: $options")
}