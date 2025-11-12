package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class DocIdentifier(
	public val id: String? = null,
	public val rev: String? = null,
)
