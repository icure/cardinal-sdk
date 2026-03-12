// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * DTO wrapping a map of entity identifiers to lists of associated identifiers, used for expressing
 * relationships between entities in bulk operations.
 * /
 */
@Serializable
data class MapOfIds(
	/**
	 * A map where each key is an entity identifier and the value is a list of related entity
	 * identifiers.
	 */
	@param:DefaultValue("emptyMap()")
	public val mapOfIds: Map<String, List<String>> = emptyMap(),
) {
	// region MapOfIds-MapOfIds

	// endregion
}
