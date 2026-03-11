package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 *
 *  DTO wrapping a list of entity identifiers, used for bulk operations.
 */
@Serializable
public data class ListOfIds(
	/**
	 * The list of entity identifiers.
	 */
	@param:DefaultValue("emptyList()")
	public val ids: List<String> = emptyList(),
)
