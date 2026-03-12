package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 *
 *  Represents a state change applied to a form field when an action is triggered.
 */
@Serializable
public class State(
	/**
	 * The name of the target field.
	 */
	public val name: String,
	/**
	 * The aspect of the field state to update (value, visibility, readonly, etc.).
	 */
	public val stateToUpdate: StateToUpdate,
	/**
	 * Whether this state change can trigger additional launchers.
	 */
	@param:DefaultValue("false")
	public val canLaunchLauncher: Boolean = false,
)
