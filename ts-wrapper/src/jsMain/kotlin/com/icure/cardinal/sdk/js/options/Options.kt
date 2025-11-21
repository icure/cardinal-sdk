package com.icure.cardinal.sdk.js.options

 import com.icure.cardinal.sdk.js.crypto.CryptoStrategiesBridge
import com.icure.cardinal.sdk.js.model.userGroup_toJs
import com.icure.cardinal.sdk.js.options.external.AnonymousSdkOptionsJs
import com.icure.cardinal.sdk.js.options.external.BasicSdkOptionsJs
import com.icure.cardinal.sdk.js.options.external.BasicToFullSdkOptionsJs
import com.icure.cardinal.sdk.js.options.external.EncryptedFieldsConfigurationJs
import com.icure.cardinal.sdk.js.options.external.JsonPatcherJs
import com.icure.cardinal.sdk.js.options.external.SdkOptionsJs
import com.icure.cardinal.sdk.js.storage.loadKeyStorageOptions
 import com.icure.cardinal.sdk.js.utils.cardinalInternalGlobals
 import com.icure.cardinal.sdk.options.AnonymousSdkOptions
import com.icure.cardinal.sdk.options.BasicSdkOptions
import com.icure.cardinal.sdk.options.BasicToFullSdkOptions
import com.icure.cardinal.sdk.options.EncryptedFieldsConfiguration
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.adaptCryptoServiceForExternal
import com.icure.kryptom.crypto.external.adaptExternalCryptoService
import com.icure.kryptom.js.defaultJsCryptoAvailable
import kotlinx.coroutines.await
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromDynamic
import kotlinx.serialization.json.encodeToDynamic

suspend fun SdkOptionsJs.toKt(): SdkOptions {
	val defaultSdkOptions = SdkOptions()
	return SdkOptions(
		encryptedFields = this.encryptedFields?.toKt() ?: defaultSdkOptions.encryptedFields,
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
		jsonPatcher = this.jsonPatcher?.let { JsonPatcherBridge(it) } ?: defaultSdkOptions.jsonPatcher,
		lenientJson = this.lenientJson ?: defaultSdkOptions.lenientJson
	)
}

suspend fun BasicSdkOptionsJs.toKt(): BasicSdkOptions {
	val defaultApiOptions = BasicSdkOptions()
	return BasicSdkOptions(
		encryptedFields = this.encryptedFields?.toKt() ?: defaultApiOptions.encryptedFields,
		cryptoService = this.cryptoService.checkRequiredAdaptAndPolyfillRandom() ?: defaultApiOptions.cryptoService,
		groupSelector = this.groupSelector?.let { groupSelectorJs ->
			{ ktGroups ->
				groupSelectorJs(ktGroups.map { userGroup_toJs(it) }.toTypedArray()).await()
			}
		} ?: defaultApiOptions.groupSelector,
		lenientJson = this.lenientJson ?: defaultApiOptions.lenientJson
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
		jsonPatcher = this.jsonPatcher?.let { JsonPatcherBridge(it) } ?: defaultOptions.jsonPatcher
	)
}

fun AnonymousSdkOptionsJs.toKt(): AnonymousSdkOptions {
	val defaultApiOptions = AnonymousSdkOptions()
	return AnonymousSdkOptions(
		lenientJson = this.lenientJson ?: defaultApiOptions.lenientJson
	)
}

private fun EncryptedFieldsConfigurationJs.toKt(): EncryptedFieldsConfiguration {
	val defaultConfig = EncryptedFieldsConfiguration()
	return EncryptedFieldsConfiguration(
		accessLog = this.accessLog?.toSet() ?: defaultConfig.accessLog,
		calendarItem = this.calendarItem?.toSet() ?: defaultConfig.calendarItem,
		contact = this.contact?.toSet() ?: defaultConfig.contact,
		service = this.service?.toSet() ?: defaultConfig.service,
		healthElement = this.healthElement?.toSet() ?: defaultConfig.healthElement,
		maintenanceTask = this.maintenanceTask?.toSet() ?: defaultConfig.maintenanceTask,
		patient = this.patient?.toSet() ?: defaultConfig.patient,
		message = this.message?.toSet() ?: defaultConfig.message,
		topic = this.topic?.toSet() ?: defaultConfig.topic,
		document = this.document?.toSet() ?: defaultConfig.document,
		form = this.form?.toSet() ?: defaultConfig.form,
		receipt = this.receipt?.toSet() ?: defaultConfig.receipt,
		classification = this.classification?.toSet() ?: defaultConfig.classification,
		timeTable = this.timeTable?.toSet() ?: defaultConfig.timeTable,
		invoice = this.invoice?.toSet() ?: defaultConfig.invoice
	)
}

private class JsonPatcherBridge(
	js: JsonPatcherJs
): JsonPatcher {
	private val doPatchAccessLog: (JsonElement) -> JsonElement = js.patchAccessLog?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchAccessLog(decryptedJson: JsonElement): JsonElement = doPatchAccessLog(decryptedJson)

	private val doPatchCalendarItem: (JsonElement) -> JsonElement = js.patchCalendarItem?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchCalendarItem(decryptedJson: JsonElement): JsonElement = doPatchCalendarItem(decryptedJson)

	private val doPatchContact: (JsonElement) -> JsonElement = js.patchContact?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchContact(decryptedJson: JsonElement): JsonElement = doPatchContact(decryptedJson)

	private val doPatchIndividualService: (JsonElement) -> JsonElement = js.patchIndividualService?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchIndividualService(decryptedJson: JsonElement): JsonElement = doPatchIndividualService(decryptedJson)

	private val doPatchHealthElement: (JsonElement) -> JsonElement = js.patchHealthElement?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchHealthElement(decryptedJson: JsonElement): JsonElement = doPatchHealthElement(decryptedJson)

	private val doPatchMaintenanceTask: (JsonElement) -> JsonElement = js.patchMaintenanceTask?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchMaintenanceTask(decryptedJson: JsonElement): JsonElement = doPatchMaintenanceTask(decryptedJson)

	private val doPatchPatient: (JsonElement) -> JsonElement = js.patchPatient?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchPatient(decryptedJson: JsonElement): JsonElement = doPatchPatient(decryptedJson)

	private val doPatchMessage: (JsonElement) -> JsonElement = js.patchMessage?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchMessage(decryptedJson: JsonElement): JsonElement = doPatchMessage(decryptedJson)

	private val doPatchTopic: (JsonElement) -> JsonElement = js.patchTopic?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchTopic(decryptedJson: JsonElement): JsonElement = doPatchTopic(decryptedJson)

	private val doPatchDocument: (JsonElement) -> JsonElement = js.patchDocument?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchDocument(decryptedJson: JsonElement): JsonElement = doPatchDocument(decryptedJson)

	private val doPatchForm: (JsonElement) -> JsonElement = js.patchForm?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchForm(decryptedJson: JsonElement): JsonElement = doPatchForm(decryptedJson)

	private val doPatchReceipt: (JsonElement) -> JsonElement = js.patchReceipt?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchReceipt(decryptedJson: JsonElement): JsonElement = doPatchReceipt(decryptedJson)

	private val doPatchClassification: (JsonElement) -> JsonElement = js.patchClassification?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchClassification(decryptedJson: JsonElement): JsonElement = doPatchClassification(decryptedJson)

	private val doPatchTimeTable: (JsonElement) -> JsonElement = js.patchTimeTable?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchTimeTable(decryptedJson: JsonElement): JsonElement = doPatchTimeTable(decryptedJson)

	private val doPatchInvoice: (JsonElement) -> JsonElement = js.patchInvoice?.let { doPatchJs ->
		adaptJsPatchMethod(doPatchJs)
	} ?: { it }
	override fun patchInvoice(decryptedJson: JsonElement): JsonElement = doPatchInvoice(decryptedJson)

	@OptIn(ExperimentalSerializationApi::class)
	private inline fun adaptJsPatchMethod(crossinline doPatchJs: (dynamic) -> dynamic): (JsonElement) -> JsonElement = { x ->
		Json.decodeFromDynamic(doPatchJs(Json.encodeToDynamic(x)))
	}
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