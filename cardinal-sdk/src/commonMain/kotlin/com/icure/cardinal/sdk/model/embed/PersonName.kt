package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class PersonName(
	public val lastName: String? = null,
	@param:DefaultValue("emptyList()")
	public val firstNames: List<String> = emptyList(),
	public val start: Long? = null,
	public val end: Long? = null,
	@param:DefaultValue("emptyList()")
	public val prefix: List<String> = emptyList(),
	@param:DefaultValue("emptyList()")
	public val suffix: List<String> = emptyList(),
	public val text: String? = null,
	public val use: PersonNameUse? = null,
) {
	// region PersonName-PersonName

	// endregion
}
