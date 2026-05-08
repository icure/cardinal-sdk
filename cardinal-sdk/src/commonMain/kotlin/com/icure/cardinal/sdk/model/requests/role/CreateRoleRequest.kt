// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests.role

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@Serializable
data class CreateRoleRequest(
	public val permissions: Set<String>,
	public val description: String? = null,
) {
	// region CreateRoleRequest-CreateRoleRequest
	// endregion
}
