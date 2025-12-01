package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable

@Serializable
public data class RemoteAuthentication(
	public val basic: Basic? = null,
)
