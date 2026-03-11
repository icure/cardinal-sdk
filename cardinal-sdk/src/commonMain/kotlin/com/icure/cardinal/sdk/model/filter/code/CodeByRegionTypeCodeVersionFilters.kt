package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches codes by region, type, code value, and version.
 * /
 */
@SerialName("CodeByRegionTypeCodeVersionFilters")
@Serializable
public data class CodeByRegionTypeCodeVersionFilters(
	/**
	 * The region to filter codes by.
	 */
	public val region: String,
	/**
	 * The code type to match.
	 */
	public val type: String?,
	/**
	 * The code value to match.
	 */
	public val code: String?,
	/**
	 * The code version to match.
	 */
	public val version: String?,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String?,
) : AbstractFilter<Code>
