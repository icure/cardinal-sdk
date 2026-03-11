// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.chain

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.predicate.Predicate
import kotlin.String

/**
 * A chain that combines a filter with an optional predicate for post-filtering results.
 * /
 */

data class FilterChain<O : Identifiable<String>>(
	/**
	 * The filter to apply.
	 */
	public val filter: AbstractFilter<O>,
	/**
	 * An optional predicate to further refine the filter results.
	 */
	public val predicate: Predicate? = null,
) {
	// region FilterChain-FilterChain

	// endregion
}
