// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches code identifiers within an interval defined by start and end type, code, and
 * version.
 * /
 */
@SerialName("CodeIdsByTypeCodeVersionIntervalFilter")
@Serializable
data class CodeIdsByTypeCodeVersionIntervalFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The type at the start of the interval.
	 */
	public val startType: String? = null,
	/**
	 * The code value at the start of the interval.
	 */
	public val startCode: String? = null,
	/**
	 * The version at the start of the interval.
	 */
	public val startVersion: String? = null,
	/**
	 * The type at the end of the interval.
	 */
	public val endType: String? = null,
	/**
	 * The code value at the end of the interval.
	 */
	public val endCode: String? = null,
	/**
	 * The version at the end of the interval.
	 */
	public val endVersion: String? = null,
) : AbstractFilter<Code> {
	// region CodeIdsByTypeCodeVersionIntervalFilter-CodeIdsByTypeCodeVersionIntervalFilter

	// endregion
}
