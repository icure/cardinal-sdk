package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Represents an action in a form template, combining launchers, a conditional expression, and
 * target states.
 * /
 */
@Serializable
public data class Action(
	/**
	 * The list of launchers that can trigger this action.
	 */
	@param:DefaultValue("emptyList()")
	public val launchers: List<Launcher>? = emptyList(),
	/**
	 * A conditional expression that determines when this action is executed.
	 */
	public val expression: String? = null,
	/**
	 * The list of states to apply when this action is triggered.
	 */
	@param:DefaultValue("emptyList()")
	public val states: List<State>? = emptyList(),
)
