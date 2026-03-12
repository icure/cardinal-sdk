// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
class Launcher(
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
) {
	// region Launcher-Launcher

	// endregion
}
