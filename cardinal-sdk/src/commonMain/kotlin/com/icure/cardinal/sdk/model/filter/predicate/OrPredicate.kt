package com.icure.cardinal.sdk.model.filter.predicate

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.List

@Serializable
public data class OrPredicate(
	@DefaultValue("emptyList()")
	public val predicates: List<Predicate> = emptyList(),
) : Predicate
