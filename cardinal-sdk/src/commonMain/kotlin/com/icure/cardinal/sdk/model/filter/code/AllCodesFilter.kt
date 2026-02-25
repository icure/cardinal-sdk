package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllCodesFilter")
@Serializable
public data class AllCodesFilter(
	override val desc: String? = null,
) : AbstractFilter<Code>, Filter.AllFilter<Code>
