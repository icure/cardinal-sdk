package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public class PlannedSending(
	public val cronExpression: String? = null,
)
