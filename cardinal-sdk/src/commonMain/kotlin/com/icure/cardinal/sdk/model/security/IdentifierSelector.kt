package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class IdentifierSelector(
	public val assigner: String,
	public val valueField: String,
) {
	// region IdentifierSelector-IdentifierSelector

	// endregion
}
