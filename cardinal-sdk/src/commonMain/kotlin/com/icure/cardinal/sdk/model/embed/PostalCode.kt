// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

/**
 * Represents a postal code with its code value and localized labels.
 * /
 */
@Serializable
data class PostalCode(
	/**
	 * The postal code value.
	 */
	public val code: String? = null,
	/**
	 * Localized labels for this postal code, keyed by language code.
	 */
	@param:DefaultValue("emptyMap()")
	public val label: Map<String, String> = emptyMap(),
) {
	// region PostalCode-PostalCode

	// endregion
}
