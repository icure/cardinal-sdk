package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@Serializable
public class Launcher(
	public val name: String,
	public val triggerer: Trigger,
	@DefaultValue("false")
	public val shouldPassValue: Boolean = false,
)
