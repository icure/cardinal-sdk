package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("CodeByRegionTypesLanguageLabelVersionFilters")
@Serializable
public data class CodeByRegionTypesLanguageLabelVersionFilters(
	public val region: String? = null,
	public val types: List<String>,
	public val language: String,
	public val label: String,
	public val version: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Code>
