// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int

/**
 * Represents a numeric value paired with its precision (number of significant digits).
 * /
 */
@Serializable
data class ValueWithPrecision(
	/**
	 * The numeric value.
	 */
	public val `value`: Int,
	/**
	 * The number of significant digits.
	 */
	public val precision: Int,
) {
	// region ValueWithPrecision-ValueWithPrecision

	// endregion
}
