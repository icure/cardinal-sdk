package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
class State(
	public val name: String,
	public val stateToUpdate: StateToUpdate,
	@param:DefaultValue("false")
	public val canLaunchLauncher: Boolean = false,
) {
	// region State-State

	// endregion
}
