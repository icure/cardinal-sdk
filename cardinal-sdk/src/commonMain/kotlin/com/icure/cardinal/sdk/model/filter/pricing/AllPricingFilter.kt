// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.pricing

import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches all pricing (tarification) entries without any filtering criteria.
 * /
 */
@SerialName("AllPricingFilter")
@Serializable
data class AllPricingFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Tarification>, Filter.AllFilter<Tarification> {
	// region AllPricingFilter-AllPricingFilter

	// endregion
}
