// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.predicate

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Predicate that evaluates to true when any sub-predicate evaluates to true (logical OR).
 * /
 */
@Serializable
data class OrPredicate(
	/**
	 * The list of predicates where at least one must be satisfied.
	 */
	@param:DefaultValue("emptyList()")
	public val predicates: List<Predicate> = emptyList(),
) : Predicate {
	// region OrPredicate-OrPredicate

	// endregion
}
