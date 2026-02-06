package com.icure.cardinal.sdk.model.filter.predicate

import kotlinx.serialization.Serializable

@Serializable
public data class NotPredicate(
	public val predicate: Predicate,
) : Predicate
