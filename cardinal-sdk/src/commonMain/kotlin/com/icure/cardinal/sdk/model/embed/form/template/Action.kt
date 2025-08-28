package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Action(
	public val launchers: List<Launcher>? = null,
	public val expression: String? = null,
	public val states: List<State>? = null,
) {
	// region Action-Action

	// endregion
}
