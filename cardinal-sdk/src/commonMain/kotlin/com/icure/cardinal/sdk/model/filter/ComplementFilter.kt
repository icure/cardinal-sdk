package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class ComplementFilter<O : Identifiable<String>>(
	override val desc: String? = null,
	override val superSet: AbstractFilter<O>,
	override val subSet: AbstractFilter<O>,
) : AbstractFilter<O>, Filter.ComplementFilter<O>
