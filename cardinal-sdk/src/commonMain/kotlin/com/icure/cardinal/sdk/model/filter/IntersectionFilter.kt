package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("IntersectionFilter")
@Serializable
public data class IntersectionFilter<O : Identifiable<String>>(
	override val desc: String? = null,
	@DefaultValue("emptyList()")
	override val filters: List<AbstractFilter<O>> = emptyList(),
) : AbstractFilter<O>, Filter.IntersectionFilter<O>
