package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class MapOfIds(
	@param:DefaultValue("emptyMap()")
	public val mapOfIds: Map<String, List<String>> = emptyMap(),
) {
	// region MapOfIds-MapOfIds

	// endregion
}
