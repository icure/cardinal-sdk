package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Substanceproduct(
	@param:DefaultValue("emptyList()")
	public val intendedcds: List<CodeStub> = emptyList(),
	@param:DefaultValue("emptyList()")
	public val deliveredcds: List<CodeStub> = emptyList(),
	public val intendedname: String? = null,
	public val deliveredname: String? = null,
	public val productId: String? = null,
) {
	// region Substanceproduct-Substanceproduct

	// endregion
}
