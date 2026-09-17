// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.dao

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
data class ValueFilterParameters(
	/**
	 *
	 *  If not null, represents the key in the value object to check for filtering. If null, it means that the value is a scalar.
	 */
	public val valueKey: String?,
	public val range: RangeQueryParameters,
) {
	// region ValueFilterParameters-ValueFilterParameters

	// endregion
}
