// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String

/**
 * Represents a letter-based value used in tarification, associating a letter key with an index,
 * coefficient, and numeric value.
 * /
 */
@Serializable
data class LetterValue(
	/**
	 * The letter key identifier.
	 */
	public val letter: String? = null,
	/**
	 * The index associated with this letter value.
	 */
	public val index: String? = null,
	/**
	 * The coefficient multiplier.
	 */
	public val coefficient: Double? = null,
	/**
	 * The numeric value.
	 */
	public val `value`: Double? = null,
) {
	// region LetterValue-LetterValue

	// endregion
}
