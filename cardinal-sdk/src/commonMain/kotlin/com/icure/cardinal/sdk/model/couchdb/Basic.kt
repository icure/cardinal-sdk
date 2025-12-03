package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class Basic(
	public val username: String,
	public val password: String,
)
