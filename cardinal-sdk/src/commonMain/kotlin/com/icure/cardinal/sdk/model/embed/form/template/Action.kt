package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Action(
	@DefaultValue("emptyList()")
	public val launchers: List<Launcher>? = emptyList(),
	public val expression: String? = null,
	@DefaultValue("emptyList()")
	public val states: List<State>? = emptyList(),
)
