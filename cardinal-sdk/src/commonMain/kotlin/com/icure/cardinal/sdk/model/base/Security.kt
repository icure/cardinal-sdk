package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Security(
	@param:DefaultValue("Right()")
	public val admins: Right = Right(),
	@param:DefaultValue("Right()")
	public val members: Right = Right(),
) {
	// region Security-Security

	// endregion
}
