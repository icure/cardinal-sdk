// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches healthcare elements having a qualified link with the provided association id.
 * /
 */
@SerialName("HealthElementByAssociationIdFilter")
@Serializable
data class HealthElementByAssociationIdFilter(
	/**
	 * The association identifier to match.
	 */
	public val associationId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByAssociationIdFilter-HealthElementByAssociationIdFilter
	// endregion
}
