package com.icure.cardinal.sdk.model.filter.predicate

import kotlinx.serialization.Serializable

/**
 * Predicate that negates another predicate (logical NOT).
 * /
 */
@Serializable
public data class NotPredicate(
	/**
	 * The predicate to negate.
	 */
	public val predicate: Predicate,
) : Predicate
