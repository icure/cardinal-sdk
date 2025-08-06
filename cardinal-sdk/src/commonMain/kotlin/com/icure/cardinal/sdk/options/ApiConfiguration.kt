package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.crypto.BasicInternalCryptoApi
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Provides access to general APIs configuration.
 */
@InternalIcureApi
internal interface BasicApiConfiguration {
	val apiUrl: String
	val webSocketAuthProvider: JwtBasedAuthProvider?
	val crypto: BasicInternalCryptoApi
	val encryption: EntitiesEncryptedFieldsManifests
	val rawApiConfig: RawApiConfig

	fun requireWebSocketAuthProvider(): JwtBasedAuthProvider =
		webSocketAuthProvider ?: throw UnsupportedOperationException("Your chosen authentication method does not support websocket subscriptions")

	fun getBoundGroup(coroutineContext: CoroutineContext): SdkBoundGroup?
}

@InternalIcureApi
internal interface ApiConfiguration : BasicApiConfiguration {
	val autofillAuthor: Boolean
	override val crypto: InternalCryptoServices
	val jsonPatcher: JsonPatcher
	val parentJob: Job?
}

@InternalIcureApi
internal data class ApiConfigurationImpl(
	override val apiUrl: String,
	override val webSocketAuthProvider: JwtBasedAuthProvider?,
	override val autofillAuthor: Boolean,
	override val crypto: InternalCryptoServices,
	override val encryption: EntitiesEncryptedFieldsManifests,
	override val jsonPatcher: JsonPatcher,
	override val parentJob: Job?,
	override val rawApiConfig: RawApiConfig,
	val boundGroup: SdkBoundGroup?
) : ApiConfiguration {
	override fun getBoundGroup(coroutineContext: CoroutineContext): SdkBoundGroup? =
		boundGroup
}

@InternalIcureApi
internal data class BasicApiConfigurationImpl(
	override val apiUrl: String,
	override val webSocketAuthProvider: JwtBasedAuthProvider?,
	override val crypto: BasicInternalCryptoApi,
	override val encryption: EntitiesEncryptedFieldsManifests,
	override val rawApiConfig: RawApiConfig,
	val boundGroup: SdkBoundGroup?
) : BasicApiConfiguration {
	override fun getBoundGroup(coroutineContext: CoroutineContext): SdkBoundGroup? =
		boundGroup
}

@InternalIcureApi
internal data class UnboundBasicApiConfigurationImpl(
	override val apiUrl: String,
	override val webSocketAuthProvider: JwtBasedAuthProvider?,
	override val crypto: BasicInternalCryptoApi,
	override val encryption: EntitiesEncryptedFieldsManifests,
	override val rawApiConfig: RawApiConfig,
	val boundGroupProvider: (CoroutineContext) -> SdkBoundGroup?
) : BasicApiConfiguration {
	override fun getBoundGroup(coroutineContext: CoroutineContext): SdkBoundGroup? =
		boundGroupProvider(coroutineContext)
}
