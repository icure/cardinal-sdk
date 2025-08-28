package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Action(
	public val launchers: List<Launcher>? = null,
	public val expression: String? = null,
	public val states: List<State>? = null,
)
