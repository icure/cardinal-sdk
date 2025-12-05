package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("CodeByRegionTypeCodeVersionFilters")
@Serializable
public data class CodeByRegionTypeCodeVersionFilters(
	public val region: String,
	public val type: String?,
	public val code: String?,
	public val version: String?,
	override val desc: String?,
) : AbstractFilter<Code>
