package com.icure.cardinal.sdk.model.filter.predicate

import com.icure.cardinal.sdk.model.specializations.AnyPrimitive
import com.icure.cardinal.sdk.serialization.AnyPrimitiveSerializer
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Predicate that evaluates a comparison between an entity property and a value using an operator.
 * /
 */
@Serializable
public data class KeyValuePredicate(
	/**
	 * The property key to compare.
	 */
	public val key: String? = null,
	/**
	 * The comparison operator.
	 */
	public val `operator`: Operator? = null,
	/**
	 * The value to compare against.
	 */
	@Serializable(with = AnyPrimitiveSerializer::class)
	public val `value`: AnyPrimitive? = null,
) : Predicate
