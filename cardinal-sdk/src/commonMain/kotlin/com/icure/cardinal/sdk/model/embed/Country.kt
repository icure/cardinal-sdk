package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

/**
 * Represents a country with its ISO code and localized names.
 * /
 */
@Serializable
public data class Country(
	/**
	 * The ISO country code.
	 */
	public val code: String? = null,
	/**
	 * A map of localized country names, keyed by language code.
	 */
	public val name: Map<String, String>? = null,
)
