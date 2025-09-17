package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@Serializable
public class State(
	public val name: String,
	public val stateToUpdate: StateToUpdate,
	@DefaultValue("false")
	public val canLaunchLauncher: Boolean = false,
)
