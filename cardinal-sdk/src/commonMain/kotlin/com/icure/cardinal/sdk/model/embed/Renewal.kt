// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int

/**
 * Represents the renewal information for a medication prescription, including the number of
 * renewals and their duration.
 * /
 */
@Serializable
data class Renewal(
	/**
	 * The number of authorized renewals.
	 */
	public val decimal: Int? = null,
	/**
	 * The duration of each renewal period.
	 */
	public val duration: Duration? = null,
) {
	// region Renewal-Renewal

	// endregion
}
