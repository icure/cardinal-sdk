package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("IdsFilter")
@Serializable
public data class IdsFilter<O : Identifiable<String>>(
	override val desc: String? = null,
	override val ids: Set<String>,
) : AbstractFilter<O>, Filter.IdsFilter<String, O>
