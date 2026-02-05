package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class View(
	public val map: String,
	public val reduce: String? = null,
)
