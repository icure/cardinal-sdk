package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.Serializable
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Security(
	public val admins: Right,
	public val members: Right,
) {
	// region Security-Security

	// endregion
}
