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
public data class MapOfIds(
	/**
	 * A map where each key is an entity identifier and the value is a list of related entity
	 * identifiers.
	 */
	@param:DefaultValue("emptyMap()")
	public val mapOfIds: Map<String, List<String>> = emptyMap(),
)
