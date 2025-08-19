package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable

/**
 * Data class representing the details required to inject exchange data.
 */
@Serializable
class ExchangeDataInjectionDetails(
	val exchangeDataId: String,
	@Serializable(with = ByteArraySerializer::class)
	val accessControlSecret: ByteArray,
	@Serializable(with = ByteArraySerializer::class)
	val exchangeKey: ByteArray,
	@Serializable(with = ByteArraySerializer::class)
	val sharedSignatureKey: ByteArray,
	val verified: Boolean
)
