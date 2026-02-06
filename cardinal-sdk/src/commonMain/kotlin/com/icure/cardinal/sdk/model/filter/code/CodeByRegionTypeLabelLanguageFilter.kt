package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("CodeByRegionTypeLabelLanguageFilter")
@Serializable
public data class CodeByRegionTypeLabelLanguageFilter(
	override val desc: String? = null,
	public val region: String? = null,
	public val type: String,
	public val language: String,
	public val label: String? = null,
) : AbstractFilter<Code>
