package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Action(
	@param:DefaultValue("emptyList()")
	public val launchers: List<Launcher>? = emptyList(),
	public val expression: String? = null,
	@param:DefaultValue("emptyList()")
	public val states: List<State>? = emptyList(),
) {
	// region Action-Action

	// endregion
}
