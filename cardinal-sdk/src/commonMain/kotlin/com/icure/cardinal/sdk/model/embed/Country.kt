// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

/**
 * Represents a country with its ISO code and localized names.
 * /
 */
@Serializable
data class Country(
	/**
	 * The ISO country code.
	 */
	public val code: String? = null,
	/**
	 * A map of localized country names, keyed by language code.
	 */
	public val name: Map<String, String>? = null,
) {
	// region Country-Country

	// endregion
}
