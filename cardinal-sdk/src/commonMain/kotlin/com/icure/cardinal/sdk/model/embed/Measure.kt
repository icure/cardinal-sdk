// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 * Represents a measured value with its unit, reference value, severity, evolution, and reference
 * ranges.
 * /
 */
@Serializable
data class Measure(
	/**
	 * The measured numeric value.
	 */
	public val `value`: Double? = null,
	/**
	 * The reference value for comparison.
	 */
	public val ref: Double? = null,
	/**
	 * The severity level as an integer.
	 */
	public val severity: Int? = null,
	/**
	 * The severity code as a string.
	 */
	public val severityCode: String? = null,
	/**
	 * The evolution indicator as an integer.
	 */
	public val evolution: Int? = null,
	/**
	 * The unit of measurement as a string.
	 */
	public val unit: String? = null,
	/**
	 * The coded units of measurement.
	 */
	public val unitCodes: Set<CodeStub>? = null,
	/**
	 * A comment about the measurement.
	 */
	public val comment: String? = null,
	/**
	 * A comparator string (e.g., "<", ">", "<=").
	 */
	public val comparator: String? = null,
	/**
	 * The sign of the value.
	 */
	public val sign: String? = null,
	/**
	 * The list of reference ranges for this measurement.
	 */
	@param:DefaultValue("emptyList()")
	public val referenceRanges: List<ReferenceRange> = emptyList(),
	/**
	 * The value with its precision information.
	 */
	public val valueWithPrecision: ValueWithPrecision? = null,
) {
	// region Measure-Measure

	// endregion
}
