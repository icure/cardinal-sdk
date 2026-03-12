// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class ListOfIds(
	/**
	 * The list of entity identifiers.
	 */
	@param:DefaultValue("emptyList()")
	public val ids: List<String> = emptyList(),
) {
	// region ListOfIds-ListOfIds

	// endregion
}
