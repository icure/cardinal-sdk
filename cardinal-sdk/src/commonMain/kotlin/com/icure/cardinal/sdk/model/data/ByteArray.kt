// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.`data`

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable

/**
 * Data transfer object wrapping a raw byte array for use in API requests and responses.
 * /
 */
@Serializable
data class ByteArray(
	/**
	 * The byte array content.
	 */
	@Serializable(with = ByteArraySerializer::class)
	public val `data`: kotlin.ByteArray,
) {
	// region ByteArray-ByteArray

	// endregion
}
