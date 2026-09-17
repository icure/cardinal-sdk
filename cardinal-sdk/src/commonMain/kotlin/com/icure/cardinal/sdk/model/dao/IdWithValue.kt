// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.dao

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.String

/**
 *
 *  A view row identifier paired with its associated value.
 */
@Serializable
data class IdWithValue(
	/**
	 * The id of the row.
	 */
	public val id: String,
	/**
	 * The value associated to the row.
	 */
	public val `value`: JsonElement,
) {
	// region IdWithValue-IdWithValue

	// endregion
}
