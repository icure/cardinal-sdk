// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.embed.TypedValuesType
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Lightweight stub representation of a property type, containing only the identifier and value
 * type.
 * /
 */
@Serializable
data class PropertyTypeStub(
	/**
	 * The human-readable identifier of this property type.
	 */
	public val identifier: String? = null,
	/**
	 * The value type of this property type.
	 */
	public val type: TypedValuesType? = null,
) {
	// region PropertyTypeStub-PropertyTypeStub

	// endregion
}
