package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Set

/**
 *
 *  DTO wrapping a set of property stubs, used for bulk property operations.
 */
@Serializable
public data class ListOfProperties(
	/**
	 * The set of property stubs.
	 */
	@param:DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
)
