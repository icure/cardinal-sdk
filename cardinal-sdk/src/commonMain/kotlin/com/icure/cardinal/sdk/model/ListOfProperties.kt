// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Set

/**
 *
 *  DTO wrapping a set of property stubs, used for bulk property operations.
 */
@Serializable
data class ListOfProperties(
	/**
	 * The set of property stubs.
	 */
	@param:DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
) {
	// region ListOfProperties-ListOfProperties

	// endregion
}
