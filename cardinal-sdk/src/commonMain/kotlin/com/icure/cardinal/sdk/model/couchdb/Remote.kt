package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class Remote(
	public val url: String,
	public val auth: RemoteAuthentication? = null,
)
