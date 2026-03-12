package com.icure.cardinal.sdk.model.`data`

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable

/**
 * Data transfer object wrapping a raw byte array for use in API requests and responses.
 * /
 */
@Serializable
public data class ByteArray(
	/**
	 * The byte array content.
	 */
	@Serializable(with = ByteArraySerializer::class)
	public val `data`: kotlin.ByteArray,
)
