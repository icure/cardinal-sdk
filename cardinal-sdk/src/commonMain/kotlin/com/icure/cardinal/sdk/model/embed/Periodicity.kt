// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.generation.RequireHashable
import kotlinx.serialization.Serializable

/**
 * Represents a periodicity linking a code to its related periodicity code, used in medication
 * regimens.
 * /
 */
@RequireHashable
@Serializable
data class Periodicity(
	/**
	 * The code associated with this periodicity.
	 */
	public val relatedCode: CodeStub? = null,
	/**
	 * The periodicity code defining the recurrence pattern.
	 */
	public val relatedPeriodicity: CodeStub? = null,
) {
	// region Periodicity-Periodicity

	// endregion
}
