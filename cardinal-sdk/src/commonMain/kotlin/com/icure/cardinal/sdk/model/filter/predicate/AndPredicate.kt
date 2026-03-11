package com.icure.cardinal.sdk.model.filter.predicate

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Predicate that evaluates to true only when all sub-predicates evaluate to true (logical AND).
 * /
 */
@Serializable
public data class AndPredicate(
	/**
	 * The list of predicates that must all be satisfied.
	 */
	@param:DefaultValue("emptyList()")
	public val predicates: List<Predicate> = emptyList(),
) : Predicate
