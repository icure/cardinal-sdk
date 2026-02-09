package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Delegation(
	public val owner: String? = null,
	public val delegatedTo: String? = null,
	public val key: HexString? = null,
	@param:DefaultValue("emptyList()")
	public val tags: List<String> = emptyList(),
) {
  // region Delegation-Delegation

  // endregion
}
