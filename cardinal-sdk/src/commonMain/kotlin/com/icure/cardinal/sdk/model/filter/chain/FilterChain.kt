package com.icure.cardinal.sdk.model.filter.chain

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.predicate.Predicate
import kotlin.String

public data class FilterChain<O : Identifiable<String>>(
	public val filter: AbstractFilter<O>,
	public val predicate: Predicate? = null,
)
