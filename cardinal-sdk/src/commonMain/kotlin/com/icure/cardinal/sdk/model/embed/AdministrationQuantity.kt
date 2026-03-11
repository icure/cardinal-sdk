// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String

/**
 * Represents a quantity for medication administration, including the numeric amount and the unit of
 * administration.
 * /
 */
@Serializable
data class AdministrationQuantity(
	/**
	 * The numeric quantity to administer.
	 */
	public val quantity: Double? = null,
	/**
	 * The coded unit of administration (CD-ADMINISTRATIONUNIT).
	 */
	public val administrationUnit: CodeStub? = null,
	/**
	 * A textual representation of the unit.
	 */
	public val unit: String? = null,
) {
	// region AdministrationQuantity-AdministrationQuantity

	// endregion
}
