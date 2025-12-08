package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("CodeByIdsFilter")
@Serializable
public data class CodeByIdsFilter(
	override val ids: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Code>, Filter.IdsFilter<String, Code>
