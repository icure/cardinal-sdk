// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.dao

import kotlinx.serialization.Serializable

@Serializable
data class RangeQueryParameters(
	/**
	 * The key component the range query starts from, inclusive.
	 */
	public val startKey: KeyComponent,
	/**
	 * The key component the range query ends at, inclusive.
	 */
	public val endKey: KeyComponent,
) {
	// region RangeQueryParameters-RangeQueryParameters

	// endregion
}
