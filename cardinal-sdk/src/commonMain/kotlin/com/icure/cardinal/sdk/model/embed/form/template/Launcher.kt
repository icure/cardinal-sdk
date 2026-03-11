package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 *
 *  Represents a launcher that triggers an action in a form template based on a specific trigger
 * event.
 */
@Serializable
public class Launcher(
	/**
	 * The name of the launcher.
	 */
	public val name: String,
	/**
	 * The trigger event that activates this launcher.
	 */
	public val triggerer: Trigger,
	/**
	 * Whether the current field value should be passed when the launcher is triggered.
	 */
	@param:DefaultValue("false")
	public val shouldPassValue: Boolean = false,
)
