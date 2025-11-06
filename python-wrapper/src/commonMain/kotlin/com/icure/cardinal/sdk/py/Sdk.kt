package com.icure.cardinal.sdk.py

import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.BasicSdkOptions
import com.icure.cardinal.sdk.options.EncryptedFieldsConfiguration
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.py.PyStorage.StorageFacadeOptions
import com.icure.cardinal.sdk.py.options.PyAuthMethod
import com.icure.cardinal.sdk.storage.KeyStorageFacade
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.storage.impl.FileStorageFacade
import com.icure.cardinal.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.utils.InternalIcureApi
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.asStableRef
import kotlinx.coroutines.cancel
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable


@Serializable
@InternalIcureApi
private data class PySdkParams(
	val applicationId: String? = null,
	val baseUrl: String,
	val authenticationMethod: PyAuthMethod,
	val storageFacade: StorageFacadeOptions,
	val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	val useHierarchicalDataOwners: Boolean = false,
	val createTransferKeys: Boolean = true,
	val keyStorage: StorageFacadeOptions? = null,
	val lenientJson: Boolean = true,
) {
	@OptIn(ExperimentalForeignApi::class)
	suspend fun getStorageAndApiOptions(
		cryptoStrategies: COpaquePointer?,
		customStorageFacade: COpaquePointer?,
		customKeyStorage: COpaquePointer?,
		customJsonPatcher: COpaquePointer?
	): RichPyApiParams {
		val strategies: CryptoStrategies? = cryptoStrategies?.asStableRef<CryptoStrategies>()?.get()
		val loadedStorageFacade: StorageFacade = when (storageFacade) {
			StorageFacadeOptions.Custom -> ensureNonNull(customStorageFacade) {
				"Storage facade options are custom but no implementation provided"
			}.asStableRef<StorageFacade>().get()
			is StorageFacadeOptions.File -> FileStorageFacade(storageFacade.directory)
		}
		val keyStorage: KeyStorageFacade? = keyStorage?.let { options ->
			val storageFacadeForKeys: StorageFacade = when (options) {
				StorageFacadeOptions.Custom -> ensureNonNull(customKeyStorage) {
					"Key storage facade as string options are custom but no implementation provided"
				}.asStableRef<StorageFacade>().get()
				this.storageFacade -> loadedStorageFacade
				is StorageFacadeOptions.File -> FileStorageFacade(options.directory)
			}
			JsonAndBase64KeyStorage(storageFacadeForKeys)
		}
		return RichPyApiParams(
			SdkOptions(
				encryptedFields = encryptedFields,
				useHierarchicalDataOwners = useHierarchicalDataOwners,
				createTransferKeys = createTransferKeys,
				keyStorage = keyStorage,
				cryptoStrategies = strategies,
				jsonPatcher = customJsonPatcher?.asStableRef<JsonPatcher>()?.get(),
				lenientJson = lenientJson
			),
			loadedStorageFacade,
			authenticationMethod.toKt()
		)
	}
}

private data class RichPyApiParams(
	val sdkOptions: SdkOptions,
	val storageFacade: StorageFacade,
	val authenticationMethod: AuthenticationMethod
)

class SdkInitializationResult internal constructor(
	val success: CardinalSdk?,
	val failure: String?
)

/**
 * In python some api options aren't supported since they aren't inline with the principle of python only being used
 * for server automations, for example:
 * - Group selection -> the server automatically knows which group it should log in to.
 * - Authentication with secret provider -> there is no user to interface with in the secret provider
 */
@OptIn(ExperimentalForeignApi::class, InternalIcureApi::class)
fun initializeSdk(
	dataParams: String,
	cryptoStrategies: COpaquePointer?,
	customStorageFacade: COpaquePointer?,
	customKeyStorage: COpaquePointer?,
	customJsonPatcher: COpaquePointer?,
): SdkInitializationResult = runBlocking {
	kotlin.runCatching {
		val decodedParams = Serialization.json.decodeFromString<PySdkParams>(dataParams)
		val richParams = decodedParams.getStorageAndApiOptions(
			cryptoStrategies = cryptoStrategies,
			customStorageFacade = customStorageFacade,
			customKeyStorage = customKeyStorage,
			customJsonPatcher = customJsonPatcher,
		)
		CardinalSdk.initialize(
			decodedParams.applicationId,
			decodedParams.baseUrl,
			richParams.authenticationMethod,
			richParams.storageFacade,
			richParams.sdkOptions
		)
	}.fold(
		onSuccess = { SdkInitializationResult(it, null) },
		onFailure = { SdkInitializationResult(null, it.stackTraceToString()) }
	)
}

@Serializable
private data class PyBaseSdkParams(
	val applicationId: String? = null,
	val baseUrl: String,
	val authenticationMethod: PyAuthMethod,
	val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
) {
	fun getRichApiParams(): RichPyBaseApiParams {
		val options = BasicSdkOptions(
			encryptedFields = encryptedFields
		)
		return RichPyBaseApiParams(
			options,
			authenticationMethod.toKt()
		)
	}
}

private data class RichPyBaseApiParams(
	val apiOptions: BasicSdkOptions,
	val authenticationMethod: AuthenticationMethod
)

class BaseSdkInitializationResult internal constructor(
	val success: CardinalBaseSdk?,
	val failure: String?
)

fun initializeBaseSdk(
	dataParams: String
): BaseSdkInitializationResult = runBlocking {
	kotlin.runCatching {
		val decodedParams = Serialization.json.decodeFromString<PyBaseSdkParams>(dataParams)
		val richParams = decodedParams.getRichApiParams()
		CardinalBaseSdk.initialize(
			decodedParams.applicationId,
			decodedParams.baseUrl,
			richParams.authenticationMethod,
			richParams.apiOptions
		)
	}.fold(
		onSuccess = { BaseSdkInitializationResult(it, null) },
		onFailure = { BaseSdkInitializationResult(null, it.stackTraceToString()) }
	)
}

fun closeSdk(
	sdk: CardinalSdk
) {
	sdk.scope.cancel()
}
