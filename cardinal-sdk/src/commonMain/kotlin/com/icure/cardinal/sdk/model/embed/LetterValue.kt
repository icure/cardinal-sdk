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
public data class LetterValue(
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
)
