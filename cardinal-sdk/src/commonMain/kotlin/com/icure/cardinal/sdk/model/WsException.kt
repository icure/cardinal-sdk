package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

/**
 *
 *  @author Bernard Paulus on 23/05/17.
 */
@Serializable
public class WsException(
	public val level: String,
	public val error: String,
	public val translations: Map<String, String>,
)
