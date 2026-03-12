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
public data class PropertyTypeStub(
	/**
	 * The human-readable identifier of this property type.
	 */
	public val identifier: String? = null,
	/**
	 * The value type of this property type.
	 */
	public val type: TypedValuesType? = null,
)
