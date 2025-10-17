package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

@Serializable
public class WsException(
	public val level: String,
	public val error: String,
	public val translations: Map<String, String>,
)
